package cn.com.pubinfo.ecp.cw.service.ecpcn.imp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.com.pubinfo.ecp.cw.mapper.ecpcn.CustomerUserMapper;
import cn.com.pubinfo.ecp.cw.model.ecpcn.CustomerUser;
import cn.com.pubinfo.ecp.cw.qry.ecpcn.CustomerUserQry;
import cn.com.pubinfo.ecp.cw.service.ecpcn.ICustomerUserService;
import cn.com.pubinfo.ecp.cw.service.imp.AbstractCommonService;

@Service
public class CustomerUserService extends AbstractCommonService<CustomerUser, CustomerUserQry> implements
		ICustomerUserService{

	@Autowired
	private CustomerUserMapper customerUserMapper;
	
	@Override
	public CustomerUser getById(BigDecimal id) {
		Assert.notNull(id, "id can't be null!");
		return customerUserMapper.selectByPrimaryKey(id);
	}
	
}
