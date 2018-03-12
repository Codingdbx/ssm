package com.hfxt.t59ssm3.util;

public class Page {
	private int pageIndex;//��ǰҳ
	private int pageSize;//ÿҳ��ʾ��¼��
	private int totalCount;//�ܼ�¼��
	private int totalPage;//��ҳ��
	private int startPos; // ��ʼλ�ã���0��ʼ 
	
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
	
	
	//����õ���ҳ��
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

