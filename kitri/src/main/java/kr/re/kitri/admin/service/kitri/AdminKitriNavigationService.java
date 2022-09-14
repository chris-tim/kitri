package kr.re.kitri.admin.service.kitri;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.kitri.admin.dao.kitri.AdminKitriNavigationDAO;
import kr.re.kitri.admin.vo.kitri.AdminKitriNavigationCategoryVO;
import kr.re.kitri.common.service.GsonService;

@Service
public class AdminKitriNavigationService {
	
	@Autowired
	private AdminKitriNavigationDAO dao;
	
	@Autowired
	private GsonService gsonService;
	
	public String getKitriNavigationJson() {
		
		List<Map<String, String>> categorys = dao.getCategory();
		Map<String, Map<String, Object>> sub; 
		
		Map<String, AdminKitriNavigationCategoryVO> jsonData = new LinkedHashMap<String, AdminKitriNavigationCategoryVO>();
		AdminKitriNavigationCategoryVO adminKitriNavigationCategoryVO;
		Map<String, Object> pageVO;
		List<Map<String, String>> pages;
		
		for(Map<String, String> category : categorys) {
			sub = new LinkedHashMap<String, Map<String, Object>>();
			
			pages = dao.getCategoryPage(category.get("path_value"));
			
			for(Map<String, String> page : pages) {
				
				pageVO = new LinkedHashMap<String, Object>();
				pageVO.put("name", page.get("name"));
				sub.put((String) page.get("view_name"), pageVO);
				
			}
			
			adminKitriNavigationCategoryVO = new AdminKitriNavigationCategoryVO(category.get("name"), sub);
			
			jsonData.put(category.get("path_value"), adminKitriNavigationCategoryVO);
		}
		
		String json = "Sitemap = " + gsonService.toJson(jsonData);
		
		return json;
		
	}
	
}
