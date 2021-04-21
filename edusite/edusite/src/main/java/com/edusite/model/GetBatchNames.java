package com.edusite.model;

import java.util.ArrayList;
import java.util.List;

public class GetBatchNames {
	
	private List<String> batchNames = new ArrayList<>();

	
	public GetBatchNames() {
		super();
	}

	public List<String> getBatchNames() {
		return batchNames;
	}

	public void setBatchNames(List<String> batchNames) {
		this.batchNames = batchNames;
	}
	
	public void addBatchNames(String batchName) {
		this.batchNames.add(batchName);
	}
	

}
