package cn.com.pubinfo.ecp.cw.qry;

import cn.com.pubinfo.ecp.cw.common.DataList;

public abstract class AbstractQry {
	protected Integer offset = 0;// 分页起始位置
	protected Integer limit = DataList.DEFAULT_PAGE_SIZE;// 每页记录条数
	protected Integer totalCount;// 记录总数
	protected Boolean requireTotalCount = Boolean.FALSE;// 是否需要记录总数

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer count) {
		this.totalCount = count;
	}

	public Boolean getRequireTotalCount() {
		return requireTotalCount;
	}

	public void setRequireTotalCount(Boolean requireCount) {
		this.requireTotalCount = requireCount;
	}

}
