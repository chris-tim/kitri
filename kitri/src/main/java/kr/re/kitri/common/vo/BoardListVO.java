package kr.re.kitri.common.vo;

import java.util.List;

public class BoardListVO {

	/*
	 * view에서 사용할 게시판 목록 데이터
	 */
	private List<BoardVO> head;
	private List<BoardVO> body;
	private String searchTarget;
	private String search;
	private int totalCount;
	private int totalPage;
	private int pageStart;
	private int pageEnd;

	public BoardListVO(List<BoardVO> head, List<BoardVO> body, String searchTarget, String search, int totalCount,
			int totalPage, int pageStart, int pageEnd) {
		this.head = head;
		this.body = body;
		this.searchTarget = searchTarget;
		this.search = search;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.pageStart = pageStart;
		this.pageEnd = pageEnd;
	}

	public List<BoardVO> getHead() {
		return head;
	}

	public List<BoardVO> getBody() {
		return body;
	}

	public String getSearchTarget() {
		return searchTarget;
	}

	public String getSearch() {
		return search;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getPageStart() {
		return pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

}
