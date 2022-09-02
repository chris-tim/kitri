package kr.re.kitri.kitri.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NavigationDAO {

	@Autowired
	private SqlSessionTemplate session;
	final private String namespace = "kitri.navigationMapper.";
	
	public List<Map<String, Object>> getCategory() {
		return session.selectList(namespace + "categorySelect");
	}
	
	public List<Map<String, Object>> getCategoryPage(String path) {
		return session.selectList(namespace + "categoryPageSelect", path);
	}
}
