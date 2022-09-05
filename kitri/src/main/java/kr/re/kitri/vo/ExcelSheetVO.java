package kr.re.kitri.vo;

import java.util.List;
import java.util.Map;

public class ExcelSheetVO {
	private String sheetName;
	private Map<String, Object> header;
	private List<Map<String, Object>> body;
	
	public ExcelSheetVO(String sheetName, Map<String, Object> header, List<Map<String, Object>> body) {
		this.sheetName = sheetName;
		this.header = header;
		this.body = body;
	}

	public String getSheetName() {
		return sheetName;
	}

	public Map<String, Object> getHeader() {
		return header;
	}

	public List<Map<String, Object>> getBody() {
		return body;
	}
	
	
}
