package it.uniroma3.hw.sii.hbase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RowBean implements Serializable { 
	
	private static final long serialVersionUID = 8730598140581859766L;
	
	Map<String, String> row; 
	
	public RowBean() {
		super();
		this.row = new HashMap<String, String>();  
	}

	public RowBean(Map<String, String> row) {
		super();
		this.row = row;
	}

	public Map<String, String> getRow() {
		return row;
	}

	public void setRow(Map<String, String> row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "RowBean [row=" + row + "]";
	}
}
