package kr.re.kitri.dto;

import java.util.List;

import kr.re.kitri.vo.ExcelSheetVO;

public class ExcelDTO {

	private final String filePath;
	private final String fileName;
	private final List<ExcelSheetVO> sheetDatas;
	
	public ExcelDTO(String filePath, String fileName, List<ExcelSheetVO> sheetDatas) {
		this.filePath = filePath;
		this.fileName = fileName;
		this.sheetDatas = sheetDatas;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public List<ExcelSheetVO> getSheetDatas() {
		return sheetDatas;
	}
	
	
}
