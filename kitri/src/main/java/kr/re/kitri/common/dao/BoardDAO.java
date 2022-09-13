package kr.re.kitri.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.re.kitri.common.dto.BoardEditDTO;
import kr.re.kitri.common.dto.BoardListDTO;
import kr.re.kitri.common.dto.BoardViewDTO;
import kr.re.kitri.common.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final private String namespcae = "common.boardMapper.";
	
	public int boardTotal(BoardListDTO dto) {
		return sqlSession.selectOne(namespcae + "boardTotal", dto);
	}
	
	public List<BoardVO> boardHeadList(BoardListDTO dto) {
		
		return sqlSession.selectList(namespcae + "boardHeadList", dto);
	}
	
	public List<BoardVO> boardBodyList(BoardListDTO dto) {
		
		return sqlSession.selectList(namespcae + "boardBodyList", dto);
	}
	
	public BoardVO boardView(BoardViewDTO dto) {
		
		return sqlSession.selectOne(namespcae + "boardView", dto);
	}
	
	public void boardViewsUpdate(BoardViewDTO dto) {
		sqlSession.update(namespcae + "boardViewsUpdate", dto);
	}
	
	public int boardWrite(BoardEditDTO dto) {
		
		return sqlSession.insert(namespcae + "boardWrite", dto);
	}
	
	public int boardUpdate(BoardEditDTO dto) {
		
		return sqlSession.update(namespcae + "boardUpdate", dto);
	}
	
	public int boardDelete(String tableName, int bid) {
		
		return 0;
	}
	
}
