package kr.re.kitri.kitri.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	private String namespace = "testMapper.";
	
	public List<Map<String, Object>> getKitriCategory() {
		List<Map<String, Object>> result = session.selectList(namespace+"kitriCategorySelect");
		
		return result;
	}
	
	
	public List<Map<String, Object>> getKitriCategoryPage(String path) {
		List<Map<String, Object>> result = session.selectList(namespace+"kitriCategoryPageSelect", path);
		
		return result;
	}
}
