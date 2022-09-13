package kr.re.kitri.common.dto;

public class BoardListDTO {

	private String tableName;
	private int start;
	private int rowLimit;
	
	public BoardListDTO(String tableName, int start, int rowLimit) {
		this.tableName = tableName;
		this.start = start;
		this.rowLimit = rowLimit;
	}
	
	public String getTableName() {
		return tableName;
	}
	public int getStart() {
		return start;
	}
	public int getRowLimit() {
		return rowLimit;
	}

}
