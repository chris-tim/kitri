package kr.re.kitri.admin.vo;

import java.util.List;
import java.util.Map;

public class ExcelSheetVO {
	private String sheetName;
	private Map<String, String> header;
	private List<Map<String, String>> body;
	
	public ExcelSheetVO(String sheetName, Map<String, String> header, List<Map<String, String>> body) {
		this.sheetName = sheetName;
		this.header = header;
		this.body = body;
	}

	public String getSheetName() {
		return sheetName;
	}

	public Map<String, String> getHeader() {
		return header;
	}

	public List<Map<String, String>> getBody() {
		return body;
	}
	
	
}
