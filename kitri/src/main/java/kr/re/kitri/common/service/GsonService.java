package kr.re.kitri.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class GsonService {

private Gson gson;
	
	// Null출력
	// 특수문자 유니코드 처리 안함
	public GsonService() {
		if(gson == null) {
			gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
		}
	}
		
	// json형식으로 반환
	public <K, V> String toJson(Map<K, V> map) {
		return gson.toJson(map);
	}
	// json형식으로 반환	
	public <V> String toJson(List<V> list) {
		return gson.toJson(list);
	}
	// json형식으로 반환
	public String toJson(Object src) {
		return gson.toJson(src);
	}
}
