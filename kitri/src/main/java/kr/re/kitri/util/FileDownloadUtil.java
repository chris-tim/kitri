package kr.re.kitri.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileDownloadUtil {
	
	public static byte[] getFileByte(String filePath) {
		
		byte[] fileByte = null;
		
		File file = new File(filePath);
		
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
			return null;
		}
	}
	
	public static boolean isExists(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}
}
