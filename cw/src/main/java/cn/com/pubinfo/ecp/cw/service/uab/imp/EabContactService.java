package cn.com.pubinfo.ecp.cw.service.uab.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import cn.com.pubinfo.ecp.cw.mapper.uab.EabContactMapper;
import cn.com.pubinfo.ecp.cw.model.uab.EabContact;
import cn.com.pubinfo.ecp.cw.qry.uab.EabContactQry;
import cn.com.pubinfo.ecp.cw.service.imp.AbstractCommonService;
import cn.com.pubinfo.ecp.cw.service.uab.IEabContactService;

@Component
public class EabContactService extends AbstractCommonService<EabContact, EabContactQry> implements
		IEabContactService {
	@Autowired
	private EabContactMapper eabContactMapper;
	
	
	@Override
	public EabContact getById(String id) {
		Assert.notNull("");
		return eabContactMapper.selectByPrimaryKey(id);
	}
	
}
