package kr.re.kitri.common.dto;

import org.springframework.lang.Nullable;

public class BoardListDTO {
	
	/*
	 * 게시믈 목록 검색 클래스
	 */

	private String tableName;
	private int start;
	private int rowLimit;
	private @Nullable String searchTarget;
	private @Nullable String search;
	
	public BoardListDTO(String tableName, int start, int rowLimit, String searchTarget, String search) {
		this.tableName = tableName;
		this.start = start;
		this.rowLimit = rowLimit;
		this.searchTarget = searchTarget;
		this.search = search;
	}

	public String getTableName() {
		return tableName;
	}

	public int getStart() {
		return start;
	}

	public int getRowLimit() {
		return rowLimit;
	}

	public String getSearchTarget() {
		return searchTarget;
	}

	public String getSearch() {
		return search;
	}
	
}
