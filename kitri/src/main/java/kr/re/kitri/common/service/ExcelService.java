package kr.re.kitri.common.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.kitri.admin.vo.ExcelSheetVO;
import kr.re.kitri.common.dto.ExcelDTO;

@Service
public class ExcelService {

	@Autowired
	private FileService fileService;

	final private String UPLOAD_DIR = "/excel/";

	// 엑셀 생성 및 다운로드에 필요한 데이터 추가 후 반환
	public ExcelDTO createExcel(ExcelDTO dto) {

		if (dto != null && dto.getFileName() != "") {

			XSSFWorkbook workbook = new XSSFWorkbook();
			Set<String> keyset;
			Row row;
			Cell cell;
			int rowNum;
			int cellNum;

			List<ExcelSheetVO> sheetDatas = dto.getSheetDatas();

			Font font = workbook.createFont();
			font.setBold(true);
			font.setFontName("나눔고딕");
			font.setFontHeightInPoints((short) 12);
			// 헤더 스타일 생성
			CellStyle style = workbook.createCellStyle();
			style.setFont(font);
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			
			// 시트 루프 시작
			for(ExcelSheetVO sheetData : sheetDatas) {
				
				// 시트 생성
				XSSFSheet sheet = workbook.createSheet(sheetData.getSheetName());
				// 기본 넓이 지정
				sheet.setDefaultColumnWidth(15);
				
				Map<String, String> header = sheetData.getHeader();
				keyset = header.keySet();
				
				rowNum = 0;
				// 헤더 처리
				row = sheet.createRow(rowNum++);
				cellNum = 0;
				for(String key : keyset) {
					cell = row.createCell(cellNum++);
					cell.setCellValue((String) header.get(key));
					cell.setCellStyle(style);
				}
				
				// 내용 처리
				List<Map<String, String>> body = sheetData.getBody();
				for(Map<String, String> rowData : body) {
					
					row = sheet.createRow(rowNum++);
					cellNum = 0;
					
					keyset = rowData.keySet();
					
					for(String key : keyset) {
						cell = row.createCell(cellNum++);
						cell.setCellValue((String) rowData.get(key));
					}				
				}
			}
			// 시트 루프 종료
			
			// 엑셀 생성
			try {
				
				String dir = dto.getFileDir();
				
				// 추가 경로 null 처리
				if(dir == null) {
					dir = UPLOAD_DIR;
				}
				else {
					dir = UPLOAD_DIR + dir + "/";
				}
				
				String path = fileService.getOSPath(dir);
				File folder = new File(path);
				
				// 지정된 폴더가 없을 경우 상위 폴더까지 생성
				if(!folder.exists()) {
					folder.mkdirs();
				}
				
				// 스트림 생성
				FileOutputStream out = new FileOutputStream(new File(path, dto.getFileName()));
				
				// 저장 경로 확인
				System.out.println(path);
				
				// 엑셀 생성
				workbook.write(out);
				// 스트림 종료
				out.close();
				workbook.close();				
				
				dto.setOsPath(path);
				dto.setWebPath(dir + dto.getFileName());
				dto.setFileByte(fileService.getFileByte(path + dto.getFileName()));
				
				return dto;
			}
			catch (IOException e) {
				// 오류 확인
				e.printStackTrace();
				return null;
			}
		} 
		else {
			return null;
		}
	}
}
