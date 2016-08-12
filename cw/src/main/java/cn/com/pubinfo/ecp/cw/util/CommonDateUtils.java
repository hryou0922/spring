package cn.com.pubinfo.ecp.cw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonDateUtils {
	private static Logger logger=LoggerFactory.getLogger(CommonDateUtils.class);
	public static final String DATE_PATTERN="yyyy-MM-dd";
	public static final String DATE_MONTH_INT_PATTERN="yyyyMM";
	public static final String DATE_TIME_PATTERN="yyyy-MM-dd HH:mm:ss";
    private static ThreadLocal<SimpleDateFormat> dateTimeFormat=new ThreadLocal<SimpleDateFormat>(){
    	protected SimpleDateFormat initialValue() {
    		return new SimpleDateFormat(DATE_TIME_PATTERN);
    	}
    };
    
    private static ThreadLocal<SimpleDateFormat> dateFormat=new ThreadLocal<SimpleDateFormat>(){
    	protected SimpleDateFormat initialValue() {
    		return new SimpleDateFormat(DATE_PATTERN);
    	}
    };
    
    private static ThreadLocal<SimpleDateFormat> dateMonthIntFormat=new ThreadLocal<SimpleDateFormat>(){
    	  protected SimpleDateFormat initialValue() {
    		  return new SimpleDateFormat(DATE_MONTH_INT_PATTERN);
    	  };
    };
    
    public static String dateTime2String(Date datetime){
    	if(datetime==null){
    		return "";
    	}
    	return dateTimeFormat.get().format(datetime);
    }
    
    public static String date2String(Date date){
    	if(date==null){
    		return "";
    	}
    	return dateFormat.get().format(date);
    }
    
    public static Date string2DateTime(String dateTimeStr){
    	if(dateTimeStr==null||dateTimeStr.trim().length()==0){
    		return null;
    	}
		try {
			return  dateTimeFormat.get().parse(dateTimeStr);
		} catch (ParseException e) {
            logger.error("将字符串["+dateTimeStr+"]转换成日期时间格式失败", e);
		}
    	return null;
    }
    
    public static Date string2Date(String dateStr){
    	if(dateStr==null||dateStr.trim().length()==0){
    		return null;
    	}
    	try {
			return  dateFormat.get().parse(dateStr);
		} catch (ParseException e) {
            logger.error("将字符串["+dateStr+"]转换成日期格式失败", e);
		}
    	return null;
    }
    
    /**
     * 获取今天的午夜零点时间（时分秒都为0）
     * @return
     */
    public static Date getNowDate(){
    	return getMidnight(new Date());
    }
    
    /**
     * 获取某一个日期的午夜零点（时分秒都为0）
     * @param date
     * @return
     */
    public static Date getMidnight(Date date){
    	if(date==null){
    		return null;
    	}
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	calendar.set(Calendar.MILLISECOND, 0);
    	return calendar.getTime();
    }
    
    /**
     * 获取某个日期的最后一个时间
     * @param date
     * @return
     */
    public static Date getDayEnd(Date date){
    	if(date==null){
    		return null;
    	}
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.set(Calendar.HOUR_OF_DAY, 23);
    	calendar.set(Calendar.MINUTE, 59);
    	calendar.set(Calendar.SECOND, 59);
    	calendar.set(Calendar.MILLISECOND, 999);
    	return calendar.getTime();
    }

    /**
     * 获取昨天的日期（时分秒都为0）
     */
    public static Date getYesterday(){
    	Date today=getNowDate();
    	return DateUtils.addDays(today, -1);
    }
    
    public static Date addDays(Date date,int amount){
    	if(date==null){
    		return null;
    	}
    	return DateUtils.addDays(date, amount);
    }
    
    /**
     * 获取d1和d2之间相隔多少天
     * @param d1
     * @param d2
     * @return
     */
    public static long substractAndGetDays(Date d1,Date d2){
    	if(d1==null||d2==null){
    		throw new IllegalArgumentException("参数不能为null");
    		
    	}
    	return (getMidnight(d1).getTime()-getMidnight(d2).getTime())/(24L*60*60*1000);
    }
    
    public static Integer dateMonth2Int(Date date){
    	if(date==null){
    		return null;
    	}
    	String str=dateMonthIntFormat.get().format(date);
    	return Integer.valueOf(str);
    }
}

