package kr.re.kitri.dto;

import java.util.List;

import kr.re.kitri.vo.ExcelSheetVO;

public class ExcelDTO {

	private final String fileDir;
	private final String fileName;
	private final List<ExcelSheetVO> sheetDatas;
	
	public ExcelDTO(String fileDir, String fileName, List<ExcelSheetVO> sheetDatas) {
		this.fileDir = fileDir;
		this.fileName = fileName;
		this.sheetDatas = sheetDatas;
	}

	public String getFileDir() {
		return fileDir;
	}

	public String getFileName() {
		return fileName;
	}

	public List<ExcelSheetVO> getSheetDatas() {
		return sheetDatas;
	}
	
	
}
