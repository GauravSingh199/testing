package com.wisdomleaf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Time {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	    private Long id; 
	 private int hour;
	 private int minute;
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
