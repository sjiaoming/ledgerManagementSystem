package com.lms.test;

public class InfoVO {
	private int id;

    private String date;

    private Integer gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "InfoVO [id=" + id + ", date=" + date + ", gender=" + gender
				+ "]";
	}
	
}
