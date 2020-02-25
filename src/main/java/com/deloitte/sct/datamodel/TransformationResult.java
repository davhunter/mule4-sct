package com.deloitte.sct.datamodel;

import java.io.Serializable;

public class TransformationResult implements Serializable {

	private static final long serialVersionUID = -5240786586961352162L;
	private long timeInMillis;
	private long timeInNanos;
	private String xmlResult;

	public long getTimeInMillis() {
		return timeInMillis;
	}

	public void setTimeInMillis(long timeInMillis) {
		this.timeInMillis = timeInMillis;
	}

	public long getTimeInNanos() {
		return timeInNanos;
	}

	public void setTimeInNanos(long timeInNanos) {
		this.timeInNanos = timeInNanos;
	}

	public String getXmlResult() {
		return xmlResult;
	}

	public void setXmlResult(String xmlResult) {
		this.xmlResult = xmlResult;
	}
}
