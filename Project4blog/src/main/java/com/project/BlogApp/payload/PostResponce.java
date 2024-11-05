package com.project.BlogApp.payload;

import java.util.List;

public class PostResponce {

	private List<PostDto> cotent;
	private int pageNumber;
	private int pageSize;
	private int totalPage;
	private long totalElements;
	private boolean lastPage;

	public PostResponce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostResponce(List<PostDto> cotent, int pageNumber, int pageSize, int totalPage, long totalElements,
			boolean lastPage) {
		super();
		this.cotent = cotent;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalElements = totalElements;
		this.lastPage = lastPage;
	}

	public List<PostDto> getCotent() {
		return cotent;
	}

	public void setCotent(List<PostDto> cotent) {
		this.cotent = cotent;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

}
