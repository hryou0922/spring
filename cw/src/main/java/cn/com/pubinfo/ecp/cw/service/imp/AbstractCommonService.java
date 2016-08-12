package cn.com.pubinfo.ecp.cw.service.imp;

import java.math.BigDecimal;

import cn.com.pubinfo.ecp.cw.common.Page;
import cn.com.pubinfo.ecp.cw.service.ICommonService;

public abstract class AbstractCommonService<T,V> implements ICommonService<T,V> {

	@Override
	public int insert(T record) {
		throw new UnsupportedOperationException("unsupported operation!");
	}

	@Override
	public int update(T record) {
		throw new UnsupportedOperationException("unsupported operation!");
	}

	@Override
	public Page<T> queryWithPage(V qry) {
		throw new UnsupportedOperationException("unsupported operation!");
	}

	@Override
	public T getById(String id) {
		throw new UnsupportedOperationException("unsupported operation!");
	}

	@Override
	public T getById(BigDecimal id) {
		throw new UnsupportedOperationException("unsupported operation!");
	}
	
}
