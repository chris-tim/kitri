package kr.re.kitri.kitri.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.re.kitri.common.dto.BoardEditDTO;
import kr.re.kitri.common.dto.BoardViewDTO;
import kr.re.kitri.common.service.BoardService;
import kr.re.kitri.common.service.GsonService;
import kr.re.kitri.kitri.KitriBase;

@Controller
@RequestMapping(value = "/kitri")
public class KitriMainController extends KitriBase {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private GsonService gsonService;
	
	@GetMapping(value = {"", "/", "/main"})
	public String main(Model model) {
		return KITRI_PREFIX + "main";
	}
	
	// 작성 테스트
	@GetMapping("/board")
	public String board() {
		return KITRI_PREFIX + "board";
	}
	
	@PostMapping(value = "/boardTest", produces = "application/json;cahrset=UTF-8;")
	@ResponseBody
	public String boardTest(BoardEditDTO dto) {
		
		dto.setTableName("테스트");
		dto.setUserId("TESTER");
		
		return Integer.toString(boardService.boardWrite(dto));
	}
	
	/*
	 * 완료 처리 추가 필요
	 */
	
	// 리스트 테스트
	@GetMapping(value = "/list", produces = "application/json;cahrset=UTF-8;")
	@ResponseBody
	public String boardList(
			@RequestParam(required = false, defaultValue = "1") int page, 
			@RequestParam(required = false) @Nullable String searchTarget, 
			@RequestParam(required = false) @Nullable String search,
			Model model) {
		
		if(page < 1)
			page = 1;
		
		String tableName = "테스트";
		
		model.addAttribute("boardData", boardService.boardList(tableName, page, searchTarget, search));
		model.addAttribute("page", page);

		return  gsonService.toJson(model); 
	}
	
	// 뷰 테스트
	@GetMapping(value = "/view", produces = "application/json;cahrset=UTF-8;")
	@ResponseBody
	public String boardView(@RequestParam(required = false, defaultValue = "1") int page, Model model, HttpServletResponse responese) {
		
		if(page < 1)
			page = 1;
		
		model.addAttribute("boardData", boardService.boardView(new BoardViewDTO("테스트", 3)));
		model.addAttribute("page", page);
	
		return gsonService.toJson(model);
	}
	
	// 수정 폼 테스트
	@GetMapping(value = "/edit")
	public String boardEditView(@RequestParam(required = false, defaultValue = "1") int page, Model model, HttpServletResponse responese) {
		
		model.addAttribute("boardData", boardService.boardView(new BoardViewDTO("수정 테스트", 1)));
		model.addAttribute("page", page);
		
		return KITRI_PREFIX + "edit";
	}
	
	// 수정 처리 테스트
	@PostMapping(value="/editTest", produces = "application/json;cahrset=UTF-8;")
	@ResponseBody
	public String boardEdit(BoardEditDTO dto, HttpServletResponse responese) {
		
		dto.setTableName("수정 테스트");
		dto.setUserId("EDIT_TEST");
		
		return Integer.toString(boardService.boardUpdate(dto));
	}
}
