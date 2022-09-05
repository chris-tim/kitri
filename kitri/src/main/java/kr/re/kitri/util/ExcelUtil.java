package kr.re.kitri.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

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

import kr.re.kitri.dto.ExcelDTO;
import kr.re.kitri.vo.ExcelSheetVO;

@Service
public class ExcelUtil {
	
	/*
	 * 저장경로 호출용
	 */
	@Autowired
	private ServletContext context;
	
	public boolean createExcel(ExcelDTO excelDTO) {
		
		if(excelDTO != null && excelDTO.getFileName() != "") {
		
			XSSFWorkbook workbook = new XSSFWorkbook();
			
			// 기본 저장 경로 설정
			final String SAVE_PATH = context.getRealPath("/resources/excel/");
			
			// 
			Set<String> keyset;
			Row row;
			Cell cell;
			int rowNum;
			int cellNum;
			
			List<ExcelSheetVO> sheetDatas = excelDTO.getSheetDatas();
			
			// 헤더 스타일 생성
			Font font = workbook.createFont();
			font.setBold(true);
			font.setFontName("나눔고딕");
			font.setFontHeightInPoints((short) 12);
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
				
				Map<String, Object> header = sheetData.getHeader();
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
				List<Map<String, Object>> body = sheetData.getBody();
				for(Map<String, Object> rowData : body) {
					
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
				
				String filePath;
				
				// 추가 경로 null 처리
				if(excelDTO.getFilePath() == null) {
					filePath = "";
				}
				else {
					filePath = excelDTO.getFilePath();
				}
				
				String path = SAVE_PATH + filePath;
				File folder = new File(path);
				
				// 지정된 폴더가 없을 경우 상위 폴더까지 생성
				if(!folder.exists()) {
					folder.mkdirs();
				}
				
				// 스트림 생성
				FileOutputStream out = new FileOutputStream(new File(path, excelDTO.getFileName()));
				
				// 저장 경로 확인
				System.out.println(SAVE_PATH + excelDTO.getFilePath());
				System.out.println(excelDTO.getFileName());
				
				// 엑셀 생성
				workbook.write(out);
				// 스트림 종료
				out.close();
				// 엑셀 생성 종료
				workbook.close();
			}
			catch (IOException e) {
				// 오류 확인
				e.printStackTrace();
				return false;
			}
			return true;
		}
		else {
			return false;
		}
	}
}
