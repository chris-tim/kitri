package kr.re.kitri.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadUtil {

	@Autowired
	private ServletContext context;
	
	public String fileUpload(MultipartFile multipartFile, String dir) {
		
		if(multipartFile != null) {
		
			String originFileName = multipartFile.getOriginalFilename();
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			// 저장할 파일명
			String saveName = UUID.randomUUID() + ext;
			
			// 저장 경로 처리
			final String SAVE_PATH = context.getRealPath("/resources/upload/");
			String path;
			
			if(dir != null) {
				File folder = new File(SAVE_PATH + dir);
				
				// 지정된 폴더가 없을 경우 상위 폴더까지 생성
				if(!folder.exists()) {
					folder.mkdirs();
				}
				
				path = folder.getPath() + "/";
			}
			else {
				path = SAVE_PATH;
			}
			
			try {
				File uploadFile = new File(path + saveName);
				InputStream stream = multipartFile.getInputStream();
				FileUtils.copyInputStreamToFile(stream, uploadFile);
				stream.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			
			return saveName;
		}
		else {
			return null;
		}
	}
}
