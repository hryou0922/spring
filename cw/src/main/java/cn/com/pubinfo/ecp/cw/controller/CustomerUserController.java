package cn.com.pubinfo.ecp.cw.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import cn.com.pubinfo.ecp.cw.model.ecpcn.CustomerUser;
import cn.com.pubinfo.ecp.cw.service.ecpcn.ICustomerUserService;
import cn.com.pubinfo.ecp.cw.util.CommonJsonUtils;

@Controller
@RequestMapping(value="/customerUser")
public class CustomerUserController {
	@Autowired
	private ICustomerUserService customerUserService;
	
	/**
	 * http://localhost/cw_n/customerUser/select/102082467
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("select/{id}")
	@ResponseBody
	public DeferredResult<String> getAccountExtByOwner(@PathVariable Long id) {
		DeferredResult<String> result = new DeferredResult<String>();
		CustomerUser user = customerUserService.getById(BigDecimal.valueOf(id));
		result.setResult(CommonJsonUtils.object2DataListJson(user));
		return result;
	}
	
	@RequestMapping("index")
	public String index(){
		return "screen/party/index";
	}
	
}
 