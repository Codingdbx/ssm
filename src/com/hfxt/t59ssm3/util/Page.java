package com.hfxt.t59ssm3.util;

public class Page {
	private int pageIndex;//当前页
	private int pageSize;//每页显示记录数
	private int totalCount;//总记录数
	private int totalPage;//总页数
	private int startPos; // 开始位置，从0开始 
	
	public Page(){
		this(1,5,0,1);
	}
	
	public Page(int pageIndex, int pageSize, int totalCount, int totalPage) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}
	
	
	//计算得到总页数
	public int getTotalPage() {
		totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartPos() {
		return (pageIndex-1)*pageSize;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	
}

