package cn.com.pubinfo.ecp.cw.service;

import java.math.BigDecimal;

import cn.com.pubinfo.ecp.cw.common.Page;

public interface ICommonService <T,V> {
	
    int insert(T record);
    
    int update(T record);
    
    Page<T> queryWithPage(V qry);
    
    T getById(String id);
    
    T getById(BigDecimal id);
}
