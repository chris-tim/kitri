package kr.re.kitri.admin.vo;

import java.util.Map;

public class AdminVO {

	private String userId;
	private String userName;
	// 최고 관리자 여부
	private int userLevel;
	// 관리 페이지 접근 권한
	private String auth;
	private Map<String, String> authList;
	
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public String getAuth() {
		return auth;
	}
	
	// DB에서 꺼내온 데이터를 확인하기 편하게 변경
	private void setAuthList() {
		String[] auths = auth.split(",");
		for(String auth : auths) {
			authList.put(auth, "1");
		}
	}
	
	// 해당 권한 확인
	public boolean authCheck(String auth) {
		
		boolean flag = false;
		
		if(this.authList == null) {
			this.setAuthList();
		}
		
		try {
			if(authList.get(auth) == "1")  {
				flag = true;
			}
		}
		catch (NullPointerException e) {
		}
		return flag;
		
	}
	
	// 아이디, 이름 값 여부 확인
	public boolean adminCheck() {
		if(userId != null && userName != null) {
			return true;
		}
		else {
			return false;
		}
	}
}
