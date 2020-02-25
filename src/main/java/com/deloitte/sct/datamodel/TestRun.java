package com.deloitte.sct.datamodel;

import java.io.Serializable;

public class TestRun implements Serializable {

	private static final long serialVersionUID = 5196829647285604789L;
	private int numRecords;
	private String testType;
	private Long completedInMillis;
	private Long completedInNanos;

	/**
	 * Constructor doesn't bother with completedIn... attributes, since they are
	 * filled in after object instantiation
	 * 
	 * @param numRecords Number of records to process in the test
	 * @param testType   Type of test to perform
	 */
	public TestRun(int numRecords, String testType) {
		super();
		this.numRecords = numRecords;
		this.testType = testType;
	}

	/**
	 * Empty constructor
	 */
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

	public Long getCompletedInMillis() {
		return completedInMillis;
	}

	public void setCompletedInMillis(Long completedInMillis) {
		this.completedInMillis = completedInMillis;
	}

	public Long getCompletedInNanos() {
		return completedInNanos;
	}

	public void setCompletedInNanos(Long completedInNanos) {
		this.completedInNanos = completedInNanos;
	}
}
