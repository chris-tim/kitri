package kr.re.kitri.common.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class NormalBoardDTO {
	
	// 등록일, 수정일은 DB에서 처리
	private String tableName;
	private String title;
	private String content;
	private int open;
	private List<MultipartFile> attachments;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
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
	public int getOpen() {
		return open;
	}
	public void setOpen(int open) {
		this.open = open;
	}
	public List<MultipartFile> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<MultipartFile> attachments) {
		this.attachments = attachments;
	}
	
	
	
}
