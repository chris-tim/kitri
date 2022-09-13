package kr.re.kitri.common.dto;

public class BoardViewDTO {

	private String tableName;
	private int bid;
	
	public BoardViewDTO(String tableName, int bid) {
		this.tableName = tableName;
		this.bid = bid;
	}

	public String getTableName() {
		return tableName;
	}

	public int getBid() {
		return bid;
	}
	
	
}
