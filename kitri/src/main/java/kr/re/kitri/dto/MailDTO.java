package kr.re.kitri.dto;

import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

public class MailDTO {

	// 응답 주소 설정
	private String replayTo;

	// 발송자 이름 - simple안됨
	private String fromName;
	// 수신자 메일 리스트
	private String[] to;
	// 참조
	private List<String> cc;
	// 숨은 참조
	private List<String> bcc;
	// 제목
	private String subject;
	// 내용
	private String content;
	// HTML 여부
	private boolean simple = false;

	/*
	 * 첨부파일 목록 K : 파일명, V : 첨부파일
	 */
	private Map<String, DataSource> attachments;

	public String getReplayTo() {
		return replayTo;
	}

	public void setReplayTo(String replayTo) {
		this.replayTo = replayTo;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isSimple() {
		return simple;
	}

	public void setSimple(boolean simple) {
		this.simple = simple;
	}

	public Map<String, DataSource> getAttachments() {
		return attachments;
	}

	public void setAttachments(Map<String, DataSource> attachments) {
		this.attachments = attachments;
	}
}
