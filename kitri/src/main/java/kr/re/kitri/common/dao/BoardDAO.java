package kr.re.kitri.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.re.kitri.common.dto.BoardDTO;
import kr.re.kitri.common.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final private String namespcae = "common.boardMapper.";
	
	public List<BoardVO> boardList(String tableName, int start, int end) {
		
		return null;
	}
	
	public BoardVO boardView(String tableName, int bid) {
		
		return null;
	}
	
	public boolean boardWrite(BoardDTO dto) {
		
		return false;
	}
	
	public boolean boardUpdate(BoardDTO dto) {
		
		return false;
	}
	
	public boolean boardDelete(String tableName, int bid) {
		
		return false;
	}
	
}
