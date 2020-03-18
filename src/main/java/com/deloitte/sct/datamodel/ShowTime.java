package com.deloitte.sct.datamodel;

import java.io.Serializable;

/**
 * Represents a showtime for a movie
 * 
 * @author davhunter
 *
 */
public class ShowTime implements Serializable {

	private static final long serialVersionUID = 5725439336155480072L;
	private String startTime;
	private String theatreName;
	private boolean vipAvailable;

	public ShowTime(final String startTime, final String theatreName, final boolean vipAvailable) {
		super();
		this.startTime = startTime;
		this.theatreName = theatreName;
		this.vipAvailable = vipAvailable;
	}

	public ShowTime() {

	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(final String startTime) {
		this.startTime = startTime;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(final String theatreName) {
		this.theatreName = theatreName;
	}

	public boolean isVipAvailable() {
		return vipAvailable;
	}

	public void setVipAvailable(final boolean vipAvailable) {
		this.vipAvailable = vipAvailable;
	}
}
