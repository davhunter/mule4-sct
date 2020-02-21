package com.deloitte.sct.datamodel;

import java.io.Serializable;

/**
 * Simple POJO class for working with movie data
 * 
 * @author davhunter
 *
 */
public class Movie implements Serializable {
	private static final long serialVersionUID = 6499792996701802229L;
	private String name;
	private String duration;
	private String rating;

	public Movie() {

	}

	public Movie(final String name, final String duration, final String rating) {
		this.name = name;
		this.duration = duration;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(final String duration) {
		this.duration = duration;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(final String rating) {
		this.rating = rating;
	}
}
