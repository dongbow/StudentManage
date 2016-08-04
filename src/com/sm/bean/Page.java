package com.sm.bean;

public class Page {

	private static final int DEFAULT_PAGE_SIZE = 15;
	private int pageSize = DEFAULT_PAGE_SIZE;
	private int start = 0;
	private int nowPage = 1;
	private int totalPage = 0;
	private int totalCount = 0;
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getStart() {
		return start;
	}
	
	protected void setStart() { }
	
	public int getNowPage() {
		return nowPage;
	}
	
	public void setNowPage(int nowPage) {
		if(nowPage > 0 ) {
			start = (nowPage - 1) * pageSize;
			this.nowPage = nowPage;
		}
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	protected void setTotalPage() { }
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		totalPage = (int) Math.ceil((totalCount + pageSize - 1) / pageSize);   
        start = (nowPage-1) * pageSize;
	}
	
	public int getLastPage() {   
        if(hasLastPage()) {   
            return nowPage - 1;   
        }   
        return nowPage;   
    }   
	
    public int getNextPage() {   
        if(hasNextPage()) {   
            return nowPage + 1;   
        }   
        return nowPage;   
    }   
 
    public boolean hasNextPage() {   
        return nowPage < totalPage;   
    }   
  
    public boolean hasLastPage() {   
        return nowPage > 1;   
    }   
	
}
