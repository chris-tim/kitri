package kr.re.kitri.kitri;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.re.kitri.kitri.dao.TestDAO;

@Controller
public class KitriBase {
	
	protected final static String KITRI_PREFIX = "kitri/";
	
	@Autowired
	private TestDAO dao;
	
	protected LinkedHashMap<String, List<Map<String, Object>>> getNav() {
		
		List<Map<String, Object>> categorys = dao.getKitriCategory();
		
		LinkedHashMap<String, List<Map<String, Object>>> nav = new LinkedHashMap<String, List<Map<String,Object>>>();
		List<Map<String, Object>> pages;
		Map<String, Object> t;
		
		for (int i = 0; i < categorys.size(); i++) {
			t = categorys.get(i);
			
			pages = dao.getKitriCategoryPage((String) categorys.get(i).get("path_value"));
			
			if(pages.size() == 0) {
				continue;
			}
			
			nav.put((String) t.get("name"), pages);
			
		}
		return nav;
	}

}
