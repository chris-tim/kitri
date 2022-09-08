package kr.re.kitri.common.dto;

import java.util.List;

import kr.re.kitri.admin.vo.ExcelSheetVO;

public class ExcelDTO {

	// 생성시 필요한 데이터
	private final String fileDir;
	private final String fileName;
	private final List<ExcelSheetVO> sheetDatas;
	
	// 생성 완료시 반환 데이터
	private String osPath;
	private String webPath;
	private byte[] fileByte;
	
	
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

	public String getOsPath() {
		return osPath;
	}

	public void setOsPath(String osPath) {
		this.osPath = osPath;
	}

	public String getWebPath() {
		return webPath;
	}

	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}

	public byte[] getFileByte() {
		return fileByte;
	}

	public void setFileByte(byte[] fileByte) {
		this.fileByte = fileByte;
	}
}
