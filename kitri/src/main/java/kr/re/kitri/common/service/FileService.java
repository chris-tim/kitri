package kr.re.kitri.common.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
		
	@Autowired
	private ServletContext context;
	
	final private String BASE_DIR = "/resources";
	final private String UPLOAD_DIR = "/upload/";
	
	public String getOSPath(String webPath) {
		return context.getRealPath(BASE_DIR + webPath.replace(context.getContextPath(), ""));
	}
	
	// 파일 업로드 - 웹 경로 반환
	public String fileUploadToWeb(MultipartFile multipartFile, String dir) {
		
		if(multipartFile != null && multipartFile.getSize() > 0) {
			
			String originFileName = multipartFile.getOriginalFilename();
			String ext = FileNameUtils.getExtension(originFileName);
			
			// 저장할 파일명
			String saveName = UUID.randomUUID() + "." + ext;
			
			// null 처리안할 경우 null 폴더 생김
			if(dir == null) {
				dir = UPLOAD_DIR;
			}
			else {
				dir = UPLOAD_DIR + dir + "/";
			}
			
			// OS 경로로 디렉토리 생성 생성
			File folder = new File(context.getRealPath(BASE_DIR + dir));
			// 지정된 폴더가 없을 경우 상위 폴더까지 생성
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			// OS 경로로 파일 생성
			try {
				File uploadFile = new File(folder.getPath() + "/" + saveName);
				InputStream stream = multipartFile.getInputStream();
				FileUtils.copyInputStreamToFile(stream, uploadFile);
				stream.close();
				
				return context.getContextPath() + dir + saveName;
			} 
			catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		else {
			return "";
		}
	}
	
	// 파일 업로드 - OS 경로 반환
	public String fileUpload(MultipartFile multipartFile, String dir) {
		
		if(multipartFile != null && multipartFile.getSize() > 0) {
			
			String originFileName = multipartFile.getOriginalFilename();
			String ext = FileNameUtils.getExtension(originFileName);
			
			// 저장할 파일명
			String saveName = UUID.randomUUID() + "." + ext;
			
			// null 처리안할 경우 null 폴더 생김
			if(dir == null) {
				dir = UPLOAD_DIR;
			}
			else {
				dir = UPLOAD_DIR + dir + "/";
			}
			
			// OS 경로로 디렉토리 생성 생성
			File folder = new File(context.getRealPath(BASE_DIR + dir));
			// 지정된 폴더가 없을 경우 상위 폴더까지 생성
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			// OS 경로로 파일 생성
			try {
				File uploadFile = new File(folder.getPath() + "/" + saveName);
				InputStream stream = multipartFile.getInputStream();
				FileUtils.copyInputStreamToFile(stream, uploadFile);
				stream.close();
				
				return uploadFile.getPath();
			} 
			catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		else {
			return "";
		}
	}

	
	// 파일 삭제
	public boolean fileDeleteToWeb(String webPath) {
		return this.fileDelete(this.getOSPath(webPath));
	}
	
	// 파일 삭제
	public boolean fileDelete(String osPath) {
		
		return this.isExists(osPath) ? new File(osPath).delete() : false;
	}
	
	// 파일 바이트 배열 반환
	public byte[] getFileByteToWeb(String webPath) {
		return this.getFileByte(this.getOSPath(webPath));
	}
	// 파일 바이트 배열 반환
	public byte[] getFileByte(String osPath) {
		
		byte[] fileByte = null;
		File file = new File(osPath);
		
		if(file.exists()) {
			try {
				fileByte = FileUtils.readFileToByteArray(file);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return fileByte;
		}
		else {
			return fileByte;
		}
	}
	
	// 파일 존재여부 확인
	public boolean isExistsToWeb(String webPath) {
		return this.isExists(this.getOSPath(webPath));
	}
	// 파일 존재여부 확인
	public boolean isExists(String osPath) {
		return new File(osPath).exists();
	}
}
