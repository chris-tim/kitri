package kr.re.kitri.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

import kr.re.kitri.common.service.FileService;

@RestController
public class SummernoteImageUploadController {
	
	/*
	 * 썸머노트 이미지 업로드 처리 컨트롤러
	 */
	
	@Autowired
	private FileService fileService;

	@PostMapping(value = "summernote_image_upload")
	public JsonObject summernoteImageUpload(@RequestParam("file") MultipartFile multipartFile) {
		
		JsonObject json = new JsonObject();
		
		String dir = "summernote";
		String saveName = fileService.fileUploadToWeb(multipartFile, dir);
		
		// 이미지 URL 설정
		json.addProperty("url", saveName);
		json.addProperty("responseCode", "success");
		
		return json;
	}
}
