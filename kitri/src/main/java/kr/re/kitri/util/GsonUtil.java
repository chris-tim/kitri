package kr.re.kitri.util;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@Service
public class GsonUtil {
	
	private Gson gson;
	
	// Null출력
	// 특수문자 유니코드 처리 안함
	public GsonUtil() {
		if(gson == null) {
			gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
		}
	}
	
	public JsonObject fromJson(String param) {
		return gson.fromJson(param, JsonObject.class);
	}
	
	public <K, V> String toJson(Map<K, V> map) {
		return gson.toJson(map);
	}
	
	public String toJson(List<Map<String, Object>> list) {
		return gson.toJson(list);
	}
}
