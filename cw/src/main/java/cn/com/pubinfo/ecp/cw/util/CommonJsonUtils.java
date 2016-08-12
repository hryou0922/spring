package cn.com.pubinfo.ecp.cw.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.pubinfo.ecp.cw.common.DataList;
import cn.com.pubinfo.ecp.cw.common.IRespCode;
import cn.com.pubinfo.ecp.cw.common.Page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

public class CommonJsonUtils {
	public static SerializeConfig mapping = new SerializeConfig();
	static {
		mapping.put(Date.class, new SimpleDateFormatSerializer(
				CommonDateUtils.DATE_TIME_PATTERN));
	}

	/**
	 * 将一个列表转换成DataList对象对应的JSON
	 * @param list
	 * @param totalCount
	 * @param apiId
	 * @return
	 */
	public static <T> String page2DataListJson(Page<T> page) {
		if (page == null) {
			return null;
		}
		DataList<T> dl = new DataList<T>(page.getRows(), page.getTotalCount());
		return JSON.toJSONString(dl, mapping,SerializerFeature.DisableCircularReferenceDetect);

	}
	
	public static String map2DataListJson(Map<String,Object> map){
		if(map==null){
			return null;
		}
		DataList<Map<String,Object>> dl=new DataList<Map<String,Object>>(Arrays.asList(map),0);
		return JSON.toJSONString(dl, mapping,SerializerFeature.DisableCircularReferenceDetect);
	}
	
	/**
	 * 将一个列表转换成DataList对象对应的JSON
	 * @param list
	 * @param totalCount
	 * @param apiId
	 * @return
	 */
	public static <T> String list2DataListJson(List<T> list) {
		if (list == null) {
			return null;
		}
		DataList<T> dl = new DataList<T>(list, list.size());
		return JSON.toJSONString(dl, mapping,SerializerFeature.DisableCircularReferenceDetect);

	}

	/**
	 * 将一个对象转换成DataList对象对应的JSON
	 * @param t
	 * @param apiId
	 * @return
	 */
	public static <T> String object2DataListJson(T t) {
		if (t == null) {
			return null;
		}
		DataList<T> dl = new DataList<T>(t);
		return JSON.toJSONString(dl, mapping);
	}

	/**
	 * 将基本信息（状态码，提示信息，apiId）转换成DataList对象对应的JSON
	 * @param code
	 * @param message
	 * @param apiId
	 * @return
	 */
	public static String basic2DataListJson(Integer code, String message) {
		if (code == null) {
			return null;
		}
		DataList<String> dl = new DataList<String>(code, message);
		return JSON.toJSONString(dl, mapping);
	}

	/**
	 * 对象转换json
	 * @param object
	 * @return
	 */
	public static <T> String toJsonString(Object object) {
		if (object == null) {
			return null;
		}
		return JSON.toJSONString(object, mapping);
	}

	/**
	 * json转对象
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T parseObject(String json, Class<T> clazz) {
		if (json == null || json.trim().length() == 0) {
			return null;
		}
		return JSON.parseObject(json, clazz);
	}
	
	/**
	 * json转List
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> parseList(String json,Class<T> clazz){
		if (json == null || json.trim().length() == 0) {
			return Collections.<T>emptyList();
		}
		return JSON.parseArray(json, clazz);
	}

	/**
	 * <p>将json转换成DataList对象。</p>
	 * <p><em>说明：FastJSON本身可以直接处理泛型，但为了在其他的地方不用耦合FastJSON的代码，统一封装在这里</em></p>
	 * @param json
	 * @param clazz
	 *            DataList中数据的类型，此类型中不能包含泛型
	 * @return
	 */
	public static <T> DataList<T> parseDataList(String json, Class<T> clazz) {
		if (json == null || json.trim().length() == 0) {
			return null;
		}

		DataList<Object> dl = JSON.parseObject(json, DataList.class);
		DataList<T> result = new DataList<T>();
		result.setApiId(dl.getApiId());
		result.setCode(dl.getCode());
		result.setMessage(dl.getMessage());
		result.setTotalCount(dl.getTotalCount());
		List<Object> jsonObjectList = dl.getRows();
		if (jsonObjectList != null && jsonObjectList.size() > 0) {
			List<T> rows = new ArrayList<T>(jsonObjectList.size());
			for (Object r : jsonObjectList) {
				if(r instanceof JSONObject){
				   JSONObject r_=(JSONObject)r;
				   rows.add(JSON.parseObject(r_.toJSONString(), clazz));
				}else if(r instanceof String&&clazz==String.class){
				   rows.add((T)r);
				}else{
					throw new UnsupportedOperationException("DataList的元素类型"+clazz.getClass().getName());
				}
			}
			result.setRows(rows);
		}

		return result;
	}
	
	public static String createSuccessDataListJson(){
		return basic2DataListJson(IRespCode.SUCCESS, "");
	}
	
}
