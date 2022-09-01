package kr.re.kitri.kitri.vo;

import java.util.LinkedList;

public class CategoryVO {
	
	private String categoryName;
	private String path;
	private LinkedList<CategoryPageVO> pages;
	
	public String getCategoryName() {
		return categoryName;
	}
	public String getPath() {
		return path;
	}
	public LinkedList<CategoryPageVO> getPages() {
		return pages;
	}
}
