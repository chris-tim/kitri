package kr.re.kitri.common.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MailDTO {
	
	// 발송자 메일
	final String from = "khala0017@gmail.com";
	// 발송자 이름 - simple안됨
	private String fromName = "한국정보기술원";

	// 응답 주소 설정
	private String replayTo;
	/*
	 * 수신자, 참조, 숨은 참조
	 * 리스트에 넣을시 추가 작업이 필요해서 배열로 처리
	 */
	// 수신자
	private String[] to;
	// 참조
	private String[] cc;
	// 숨은 참조
	private String[] bcc;
	// 제목
	private String title;
	// 내용
	private String content;
	// simple 메일 여부
	private boolean simple = false;
	// 첨부파일
	private List<MultipartFile> attachments;
	
	public String getFrom() {
		return from;
	}
	
	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	
	public String getReplayTo() {
		return replayTo;
	}

	public void setReplayTo(String replayTo) {
		this.replayTo = replayTo;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

	public String getTitle() {
		return title;
	}

	public void setSubject(String title) {
		this.title = title;
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
	public List<MultipartFile> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<MultipartFile> attachments) {
		this.attachments = attachments;
	}
	
	public void consoleWrite() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("replayTo : " + this.replayTo);
		buffer.append("\rfromName : " + this.fromName);
		buffer.append("\rto : " + this.to);
		buffer.append("\rcc : " + this.cc);
		buffer.append("\rbcc : " + this.bcc);
		buffer.append("\rsimple : " + this.simple);
		buffer.append("\rtitle : " + this.title);
		buffer.append("\rattachments : " + this.attachments);
		buffer.append("\rcontent : " + this.content);
		
		System.out.println(buffer.toString());
	}

}
