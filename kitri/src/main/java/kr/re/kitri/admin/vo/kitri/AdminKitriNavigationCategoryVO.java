package kr.re.kitri.admin.vo.kitri;

import java.util.Map;

public class AdminKitriNavigationCategoryVO {

	private String name;
	private Map<String, Map<String, Object>> sub;

	public AdminKitriNavigationCategoryVO(String name, Map<String, Map<String, Object>> sub) {
		this.name = name;
		this.sub = sub;
	}

	public String getName() {
		return name;
	}

	public Map<String, Map<String, Object>> getSub() {
		return sub;
	}

}
