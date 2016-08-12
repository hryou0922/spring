package cn.com.pubinfo.ecp.cw.exception;

import cn.com.pubinfo.ecp.cw.util.ExceptionFormatUtils;

/**
 * 系统中的异常基类
 * @author Administrator
 *
 */
public  class CommonException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	protected int errorCode=-1;// 错误号
	protected String errorMsg;// 错误信息
	protected String[] args;// 参数信息
    protected Throwable cause;//原始异常信息
	
//    public CommonException(int errorCode,String errorMsg){
//    	super(errorMsg);
//    	this.errorCode=errorCode;
//    	this.errorMsg=errorMsg;
//    }
    
    public CommonException(int errorCode,String ...args){
    	this.errorCode=errorCode;
    	this.args=args;
    }
    
    public CommonException(int errorCode,Throwable cause){
    	this.errorCode=errorCode;
    	this.cause=cause;
    }
    
    public CommonException(Throwable e){
    	super(e);
    	if(e instanceof CommonException){
    		this.errorCode=((CommonException) e).getErrorCode();
    		this.errorMsg=((CommonException) e).getErrorMsg();
    		this.args=((CommonException) e).getArgs();
    	}
    }
	
	public int getErrorCode() {
		return errorCode;
	}


	public String getErrorMsg() {
		return errorMsg;
	}


	public String[] getArgs() {
		return args;
	}

	@Override
	public String getMessage() {
		return ExceptionFormatUtils.getFormattedMsg(this, "");
	}
}
