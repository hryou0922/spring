package cn.com.pubinfo.ecp.cw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import cn.com.pubinfo.ecp.cw.model.uab.EabContact;
import cn.com.pubinfo.ecp.cw.service.uab.IEabContactService;
import cn.com.pubinfo.ecp.cw.util.CommonJsonUtils;

@Controller
@RequestMapping(value="/eabContact")
public class EabContactController {
	@Autowired
	private IEabContactService eabContactService; 
 
	/**
	 * http://localhost/cw_n/select/eabContact/8f3f2c55-b5c9-4bba-89da-f4fc97912a3b
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("select/{id}")
	@ResponseBody
	public DeferredResult<String> getAccountExtByOwner(@PathVariable String id) {
		DeferredResult<String> result = new DeferredResult<String>();
		EabContact user = eabContactService.getById(id);
		result.setResult(CommonJsonUtils.object2DataListJson(user));
		return result;
	}
}
