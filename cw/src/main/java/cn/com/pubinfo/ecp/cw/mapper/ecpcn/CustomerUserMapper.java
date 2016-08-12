package cn.com.pubinfo.ecp.cw.mapper.ecpcn;

import java.math.BigDecimal;

import cn.com.pubinfo.ecp.cw.model.ecpcn.CustomerUser;

public interface CustomerUserMapper {
    int deleteByPrimaryKey(BigDecimal colId);

    int insert(CustomerUser record);

    int insertSelective(CustomerUser record);

    CustomerUser selectByPrimaryKey(BigDecimal colId);

    int updateByPrimaryKeySelective(CustomerUser record);

    int updateByPrimaryKey(CustomerUser record);
    
}