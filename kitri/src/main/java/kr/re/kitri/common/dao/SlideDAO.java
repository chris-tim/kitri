package kr.re.kitri.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SlideDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
}
