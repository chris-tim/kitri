package kr.re.kitri.admin.dao.kitri;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminKitriNavigationDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final private String namespace = "admin.kitri.navigationMapper.";
	
	public List<Map<String, String>> getCategory() {
		return sqlSession.selectList(namespace + "categoryList");
	}
	
	public List<Map<String, String>> getCategoryPage(String path) {
		return sqlSession.selectList(namespace + "categoryPageList", path);
	}

}
