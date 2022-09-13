package kr.re.kitri.common.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.re.kitri.common.dao.BoardDAO;
import kr.re.kitri.common.dto.BoardEditDTO;
import kr.re.kitri.common.dto.BoardListDTO;
import kr.re.kitri.common.dto.BoardViewDTO;
import kr.re.kitri.common.vo.BoardListVO;
import kr.re.kitri.common.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Autowired
	private FileService fileService;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private int rowLimit = 20;
	private int pageLimit = 10;
	
	public BoardListVO boardList(String tableName, int page) {
		
		int start = (page - 1) * rowLimit;
		
		BoardListDTO dto = new BoardListDTO(tableName, start, rowLimit);
		
		List<BoardVO> head = dao.boardHeadList(dto);
		List<BoardVO> body = dao.boardBodyList(dto);
		int totalCount = dao.boardTotal(dto);
		int totalPage = (int) Math.ceil((double) totalCount / rowLimit );
		int pageStart = (int) ((Math.ceil((double) page / pageLimit) - 1) * pageLimit) + 1;
		int pageEnd = pageStart + pageLimit - 1;
		
		BoardListVO vo = new BoardListVO(head, body, totalCount, totalPage, pageStart, pageEnd);
		
		return vo;
	}
	
	public BoardVO boardView(BoardViewDTO dto) {
		
		dao.boardViewsUpdate(dto);
		
		return dao.boardView(dto);
	}
	
	public int boardWrite(BoardEditDTO dto) {
		
		dto.setDatetime(this.getDatetime());
		dto.setWebPaths(this.attachmentCheck(dto.getAttachments()));
		dto.setAttachments(null);
		
		return dao.boardWrite(dto);
	}

	public int boardUpdate(BoardEditDTO dto) {
		
		dto.setDatetime(this.getDatetime());
		dto.setWebPaths(this.attachmentCheck(dto.getAttachments()));
		dto.setAttachments(null);
		
		return dao.boardUpdate(dto);
	}
	
	public int boardDelete(String tableName, int bid) {
		
		return 0;
	}
	
	private List<String> attachmentCheck(List<MultipartFile> attachments) {
		
		int size = attachments.size();
		
		List<String> files = new LinkedList<String>();
		String fileName;
		
		for(int i = 0; i<size; i++) {
			if(attachments.get(i).getSize() < 1) {
				continue;
			}
			
			fileName = fileService.fileUploadToWeb(attachments.get(i), null);
			
			files.add(fileName);
		}
		return files;
	}

	private String getDatetime() {
		return format.format(System.currentTimeMillis());
	}
}
