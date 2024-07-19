package com.example.AttendanceManagemetSystem.dto;

import java.sql.Date;
import java.sql.Time;

public class StudentDetailsDto {
	private String name;
	private Date date;
	private Time time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
