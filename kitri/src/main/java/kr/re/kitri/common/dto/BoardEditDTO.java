package kr.re.kitri.common.dto;

import java.util.List;

import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

public class BoardEditDTO {

	/*
	 * 폼 + 컨트롤러에서 전달받은 데이터
	 * 서비스 단에서 로직 처리
	 */
	private @Nullable int bid;
	private String datetime;
	private String tableName;
	private @Nullable String userId;
	private String userName;
	private String title;
	private String content;
	private @Nullable List<MultipartFile> attachments;
	private @Nullable List<String> webPaths = null;
	private @Nullable String url;
	private @Nullable String source;
	private @Nullable int head;
	private int open;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<MultipartFile> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<MultipartFile> attachments) {
		this.attachments = attachments;
	}
	
	public List<String> getWebPaths() {
		return webPaths;
	}
	public void setWebPaths(List<String> webPaths) {
		this.webPaths = webPaths;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getHead() {
		return head;
	}
	public void setHead(int head) {
		this.head = head;
	}
	public int getOpen() {
		return open;
	}
	public void setOpen(int open) {
		this.open = open;
	}

}
