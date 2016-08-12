package cn.com.pubinfo.ecp.cw.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class DataList<T> implements Serializable{
	private static final long serialVersionUID = 1L;

    public static final int DEFAULT_PAGE_SIZE=10;
    
    public static final  String ATTR_NAME_CALL_SID="callSid";
	
	@JSONField(ordinal=1)
	private Integer code= IRespCode.SUCCESS;// 状态码（200表示正常，其他都表示非正常）
	
	@JSONField(ordinal=2)
	private String message="";// 提示消息或者错误消息
	
	@JSONField(ordinal=3)
//	private String apiId=(String)ThreadLocalHolder.get(ThreadLocalHolder.Key.REQ_HEADER_API_ID);// API id 请求的唯一标识
	private String apiId;
	
	@JSONField(ordinal=4)
	private Integer totalCount=0;//记录总数
	
	@JSONField(ordinal=5)
	private List<T> rows=Collections.emptyList();//本次返回的数据列表

	public DataList(){
		
	}
	
	/**
	 * 用于不带数据列表的场景
	 * @param code 状态码
	 * @param message 提示信息
	 * @param apiId
	 */
	public DataList(Integer code,String message){
		this.code=code;
		this.message=message;	
	}
	
	/**
	 * 用于传递单条数据记录的场景
	 * @param t
	 * @param apiId
	 */
	public DataList(T t){
		this.rows=new ArrayList<T>(1);
		this.rows.add(t);
		this.totalCount=1;
	}
	
	/**
	 * 用于传递数据列表的场景
	 * @param rows
	 * @param totalCount
	 * @param apiId
	 */
	public DataList(List<T> rows,Integer totalCount){
		this.rows=rows;
		this.totalCount=totalCount;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
