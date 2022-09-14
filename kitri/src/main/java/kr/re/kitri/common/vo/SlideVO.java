package kr.re.kitri.common.vo;

public class SlideVO {
	
	private String img;
	private String mainCopy;
	private String subCopy;
	private String contentTitle;
	private String contentText;
	private String link;
	
	public SlideVO (String img, String mainCopy, String subCopy, String contentTitle, String contentText, String link) {
		this.img = img;
		this.mainCopy = mainCopy;
		this.subCopy = subCopy;
		this.contentTitle = contentTitle;
		this.contentText = contentText;
		this.link = link;
	}
	
	public String getImg() {
		return img;
	}
	public String getMainCopy() {
		return mainCopy;
	}
	public String getSubCopy() {
		return subCopy;
	}
	public String getContentTitle() {
		return contentTitle;
	}
	public String getContentText() {
		return contentText;
	}
	public String getLink() {
		return link;
	}

}
