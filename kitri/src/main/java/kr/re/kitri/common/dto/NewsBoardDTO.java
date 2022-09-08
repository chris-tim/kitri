package kr.re.kitri.common.dto;

public class NewsBoardDTO {

	// 등록일, 수정일은 DB에서 처리
	private String tableName = "news_press";
	private String title;
	private String source;
	private String url;
	private int open;
	
	public String getTableName() {
		return tableName;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getOpen() {
		return open;
	}
	public void setOpen(int open) {
		this.open = open;
	}
	
}
