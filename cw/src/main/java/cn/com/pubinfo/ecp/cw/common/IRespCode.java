package cn.com.pubinfo.ecp.cw.common;

public interface IRespCode {
	// -----------------------
	// 通用错误码
	// -----------------------
	Integer SUCCESS = 200; // 成功
	Integer PARAM_ERROR = 400; // 接口参数错误
	Integer AUTH_ERROR = 403; // 校验失败(非白名单或帐号密钥错误)
	Integer NOT_FOUND = 404; // 各种不存在
	Integer INNER_ERROR = 500; // 服务器内部错误
	Integer BLOCK_ERROR = 501; // 无法实施(服务器拒绝服务，可能进入黑名单了)
	Integer SERVICE_ERROR = 503; // 无法提供服务
}
