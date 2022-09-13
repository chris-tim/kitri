package kr.re.kitri.common.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.re.kitri.common.dao.BoardDAO;
import kr.re.kitri.common.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private GsonService gsonService;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public List<BoardDTO> boardList(String tableName, int start, int end) {
		
		return null;
	}
	
	public BoardDTO boardView(String tableName, int bid) {
		
		return null;
	}
	
	public String boardWrite(BoardDTO dto) {
		
		dto.setDatetime(this.getDatetime());
		dto.setWebPaths(this.attachmentCheck(dto.getAttachments()));
		dto.setAttachments(null);
		
		return gsonService.toJson(dto);
	}

	public boolean boardUpdate(BoardDTO dto) {
		
		return false;
	}
	
	public boolean boardDelete(String tableName, int bid) {
		
		return false;
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
