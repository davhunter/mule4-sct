package com.deloitte.sct.datamodel;

import java.io.Serializable;

public class TestRun implements Serializable {

	private static final long serialVersionUID = 5196829647285604789L;
	private int numRecords;
	private String testType;

	public TestRun(int numRecords, String testType) {
		super();
		this.numRecords = numRecords;
		this.testType = testType;
	}

	public TestRun() {

	}

	public int getNumRecords() {
		return numRecords;
	}

	public void setNumRecords(int numRecords) {
		this.numRecords = numRecords;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}
}
