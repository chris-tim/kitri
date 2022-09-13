package kr.re.kitri.common.vo;

import java.util.List;

public class BoardListVO {

	private List<BoardVO> head;
	private List<BoardVO> body;
	private int totalCount;
	private int totalPage;
	private int pageStart;
	private int pageEnd;

	public BoardListVO(List<BoardVO> head, List<BoardVO> body, int totalCount, int totalPage, int pageStart, int pageEnd) {
		this.head = head;
		this.body = body;
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
