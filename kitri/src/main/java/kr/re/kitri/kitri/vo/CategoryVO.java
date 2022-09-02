package kr.re.kitri.kitri.vo;

import java.util.Map;

public class CategoryVO {
	private String name;
	private Map<String, Map<String, Object>> sub;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Map<String, Object>> getSub() {
		return sub;
	}
	public void setSub(Map<String, Map<String, Object>> sub) {
		this.sub = sub;
	}
	
	
}
