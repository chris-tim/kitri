package kr.re.kitri.kitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

import kr.re.kitri.common.dto.BoardDTO;
import kr.re.kitri.common.service.BoardService;
import kr.re.kitri.common.service.FileService;
import kr.re.kitri.common.service.GsonService;
import kr.re.kitri.kitri.KitriBase;

@Controller
@RequestMapping(value = "/kitri")
public class KitriMainController extends KitriBase {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = {"", "/", "/main"})
	public String main(Model model) {
		return KITRI_PREFIX + "main";
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		return KITRI_PREFIX + "write_view";
	}
	
	@PostMapping(value = "/uploadTest", produces = "application/json;cahrset=UTF-8;")
	@ResponseBody
	public JsonObject uploadTest(@RequestParam("uploadFile") MultipartFile multipartFile) {
		
		JsonObject json = new JsonObject();
		
		String dir = "web";
		String saveName = fileService.fileUploadToWeb(multipartFile, dir);
		
		// 이미지 URL 설정
		json.addProperty("url", saveName);
		json.addProperty("responseCode", "success");
		
		return json;
	}
	
	@GetMapping("/board")
	public String board() {
		return KITRI_PREFIX + "board";
	}
	
	@PostMapping(value = "/boardTest", produces = "application/json;cahrset=UTF-8;")
	@ResponseBody
	public String boardTest(BoardDTO dto) {
		
		dto.setTableName("테스트");
		dto.setUserId("TESTER");
		
		return boardService.boardWrite(dto);
	}
	
}
