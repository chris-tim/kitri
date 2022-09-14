package kr.re.kitri.admin.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.re.kitri.admin.dao.kitri.AdminKitriNavigationDAO;
import kr.re.kitri.common.dto.ExcelDTO;
import kr.re.kitri.common.service.ExcelService;
import kr.re.kitri.common.vo.ExcelSheetVO;

@Controller
@RequestMapping(value = "/admin")
public class AdminExcelController {
	
	// 바디 데이터 처리용
	@Autowired
	private AdminKitriNavigationDAO dao;
	
	// common.service
	@Autowired
	private ExcelService excelService;
	
	@RequestMapping(value = "/excel/service")
	public void excelService(HttpServletResponse response) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String fileName = format.format(timestamp) + "_excel_dto_test.xlsx";
		
		List<ExcelSheetVO> sheetDatas = new LinkedList<ExcelSheetVO>();
		
		String sheetName = "홈페이지 네비";
		List<Map<String, String>> body = dao.getCategory();
		Map<String, String> header = body.get(0);
		// 시트명, 헤드 데이터, 바디 데이터
		ExcelSheetVO sheet1Data = new ExcelSheetVO(sheetName, header, body); 
		
		sheetDatas.add(sheet1Data);
		
		sheetName = "홈페이지 카테고리";
		
		header = new LinkedHashMap<String, String>();
		header.put("0", "카테고리 명");
		header.put("1", "경로");
		// 시트명, 헤드 데이터, 바디 데이터
		ExcelSheetVO sheet2Data = new ExcelSheetVO(sheetName, header, body); 
		sheetDatas.add(sheet2Data);
		
		// 추가 경로, 다운 파일명,  시트 리스트
		ExcelDTO dto = new ExcelDTO(null, fileName, sheetDatas);
		
		dto = excelService.createExcel(dto);
		
		if(dto != null) {
			if(dto.getFileByte().length > 0) {
								
				try {
					String downloadFileName = URLEncoder.encode(dto.getFileName() + ".xlsx", "UTF-8").replaceAll("\\+", "%20");
					
					response.setHeader("Content-Transfer-Encoding", "binary");
					response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					response.setContentLength(dto.getFileByte().length);
					response.setHeader("Content-Disposition", "attachment; fileName=\"" + downloadFileName);
					
					response.getOutputStream().write(dto.getFileByte());
					response.getOutputStream().flush();
					response.getOutputStream().close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
