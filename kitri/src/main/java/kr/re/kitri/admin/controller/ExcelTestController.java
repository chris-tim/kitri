package kr.re.kitri.admin.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.re.kitri.kitri.dao.TestDAO;

@Controller
@RequestMapping("/excel")
public class ExcelTestController {
	
	@Autowired
	TestDAO dao;
	
	@Autowired
	private ServletContext context;
	
	
	@RequestMapping("/test")
	public void test(HttpServletResponse response) {
		
		final String SAVE_PATH = context.getRealPath("/resources/excel");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String fileName = format.format(timestamp) + "_excel_test.xlsx";
		
		/*
		   HSSF - Excel 97(-2007) 파일 포맷을 사용할 때 사용 , ex) HSSFWorkbook, HSSFSheet
		   XSSF - Excel 2007 OOXML (.xlsx) 파일 포맷을 사용할 때 사용 , ex) XSSFWorkbook, XSSFSheet
		*/
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 시트 생성 및 시트 이름 지정
		XSSFSheet sheet = workbook.createSheet("NAV 카테고리 확인");
		
		sheet.setColumnWidth(1, 3000);
		
		
		//Font 객체 생성
		Font font = workbook.createFont();
		font.setBold(true);
		font.setFontName("나눔고딕");
		font.setFontHeightInPoints((short) 12);
		
		// 스타일 객체 생성
		CellStyle style = workbook.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		
		
		List<Map<String, Object>> categorys = dao.getKitriCategory();
		
		Row row;
		Cell cell;
		
		int rowNum = 0;
		
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("이름");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("경로");
		cell.setCellStyle(style);
		
		Set<String> keyset;
		int cellNum;
		
		for(Map<String, Object> category : categorys) {
			
			row = sheet.createRow(rowNum++);
			cellNum = 0;
			keyset = category.keySet();
			
			for(String key : keyset) {
				cell = row.createCell(cellNum++);
				cell.setCellValue((String) category.get(key));
			}
		}
		
		try {
			FileOutputStream out = new FileOutputStream(new File(SAVE_PATH, fileName));
			
			System.out.println(SAVE_PATH);
			System.out.println(fileName);
			
			workbook.write(out);
			out.close();
			workbook.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
			
	}
	
}
