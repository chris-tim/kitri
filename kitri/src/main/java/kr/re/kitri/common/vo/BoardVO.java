package kr.re.kitri.common.vo;

import javax.annotation.Nullable;

public class BoardVO {

	// DB에서 꺼내온 데이터
	
	private @Nullable String bid;
	private String datetime;
	private @Nullable String userId;
	private String userName;
	private String title;
	private String content;
	private @Nullable String file1;
	private @Nullable String file2;
	private @Nullable String file3;
	private @Nullable String file4;
	private @Nullable String file5;
	private @Nullable String url;
	private @Nullable String source;
	private @Nullable int views;
	private @Nullable int head;
	private int open;
	
	public String getBid() {
		return bid;
	}
	public String getDatetime() {
		return datetime;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getFile1() {
		return file1;
	}
	public String getFile2() {
		return file2;
	}
	public String getFile3() {
		return file3;
	}
	public String getFile4() {
		return file4;
	}
	public String getFile5() {
		return file5;
	}
	public String getUrl() {
		return url;
	}
	public String getSource() {
		return source;
	}
	public int getViews() {
		return views;
	}
	public int getHead() {
		return head;
	}
	public int getOpen() {
		return open;
	}
}
