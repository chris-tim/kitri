package kr.re.kitri;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

import kr.re.kitri.util.FileUploadUtil;

@RestController
public class SummernoteController {
	
	@Autowired
	private FileUploadUtil util;
	
	@Autowired
	private ServletContext context;

	@PostMapping(value = "summernote_image_upload")
	public JsonObject summernoteImageUpload(@RequestParam("file") MultipartFile multipartFile) {
		
		JsonObject json = new JsonObject();
		
		String dir = "summernote";
		String saveName = util.fileUpload(multipartFile, "summernote");
		
		// 이미지 URL 설정
		json.addProperty("url", context.getContextPath() + "/resources/upload/" + dir + "/" + saveName);
		json.addProperty("responseCode", "success");
		
		return json;
		
	}
}
