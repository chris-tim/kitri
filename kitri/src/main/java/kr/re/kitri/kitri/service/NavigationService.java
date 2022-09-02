package kr.re.kitri.kitri.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.kitri.kitri.dao.NavigationDAO;
import kr.re.kitri.kitri.vo.CategoryVO;
import kr.re.kitri.util.GsonUtil;

@Service
public class NavigationService {
	
	@Autowired
	private NavigationDAO dao;
	
	@Autowired
	private GsonUtil gson;
	
	public String getNav() {
		
		List<Map<String, Object>> categorys = dao.getCategory();
		
		
		Map<String, CategoryVO> categorysVO = new LinkedHashMap<String, CategoryVO>();
		CategoryVO categoryVO;
		Map<String, Object> pageVO;
		Map<String, Map<String, Object>> sub;
		
		List<Map<String, Object>> pages;
		
		for(Map<String, Object> category : categorys) {
			
			categoryVO = new CategoryVO();
			sub = new LinkedHashMap<String, Map<String,Object>>();
			categoryVO.setName((String) category.get("name"));
			
			pages = dao.getCategoryPage((String) category.get("path_value"));
			
			for(Map<String, Object> page : pages) {
				pageVO = new LinkedHashMap<String, Object>();
				pageVO.put("name", (String) page.get("name"));
				sub.put((String) page.get("view_name"), pageVO);
			}
			
			categoryVO.setSub(sub);
			categorysVO.put((String) category.get("path_value"), categoryVO);
		}
		
		return gson.toJson(categorysVO);
	}
	
}
