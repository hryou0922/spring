package cn.com.pubinfo.ecp.cw.exception;

public class DaoException extends CommonException {
	private static final long serialVersionUID = 1L;
	
	public DaoException(int errorCode, String...args) {
		super(errorCode, args);
	}
	
}
