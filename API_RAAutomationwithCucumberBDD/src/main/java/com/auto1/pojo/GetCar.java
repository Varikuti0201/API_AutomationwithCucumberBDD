package com.auto1.pojo;

import java.util.Map;

public class GetCar {

	private String page;
	private String pageSize;
	private String totalPageCount;
	private Map<Object, Object> wkda;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(String totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public Map<Object, Object> getWkda() {
		return wkda;
	}

	public void setWkda(Map<Object, Object> wkda) {
		this.wkda = wkda;
	}

}
