package com.bean;

import java.util.List;

public class Page { //分页实体
	private int page = 1; //当前页
	private int rows=8;   //每页 的记录数
	private int maxPage;  //最大页数   
	private List<?> pageList;//返回记录集合（页面展示的集合）<?>以便其他业务也可以用
	public Page(int page, int rows, int maxPage, List<?> pageList) {
		super();
		this.page = page;
		this.rows = rows;
		this.maxPage = maxPage;
		this.pageList = pageList;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public List<?> getPageList() {
		return pageList;
	}
	public void setPageList(List<?> pageList) {
		this.pageList = pageList;
	}
	
	
	@Override
	public String toString() {
		return "Page [page=" + page + ", rows=" + rows + ", maxPage=" + maxPage + ", pageList=" + pageList + "]";
	}
	
	
	
}
