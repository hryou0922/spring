package cn.com.pubinfo.ecp.cw.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

import cn.com.pubinfo.ecp.cw.exception.CommonException;

public class ExceptionFormatUtils {
	private static Map<String, String> allErrorCodes = new HashMap<String, String>();

	private static final String ERROR_UNDEFINED = "-1";

	static {
		String fileName = "config/errorcode.properties";
		InputStream in = null;
		Properties props = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {

			in = new ClassPathResource(fileName).getInputStream();
			props.load(in);
			Enumeration<?> en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String value = props.getProperty(key);
				map.put(key, value);
			}
			allErrorCodes.putAll(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 获取格式化后的异常信息
	 * 
	 * @return
	 */
	public static String getFormattedMsg(Exception e, String msg) {

		String errorCode = ERROR_UNDEFINED;
		String[] errorParams = null;
		if (e instanceof CommonException) {
			CommonException be = (CommonException) e;
			int errorCode_ = be.getErrorCode();
			errorParams = be.getArgs();
			if (allErrorCodes.containsKey(errorCode_ + "")) {
				errorCode = errorCode_ + "";
			}
		}
		String result = "";
		String pattern = allErrorCodes.get(errorCode);
		if (pattern != null) {
			if (errorParams != null) {
				result = MessageFormat.format(pattern, errorParams);
			} else {
				result = pattern;
			}
		}
		return result;
	}

}
