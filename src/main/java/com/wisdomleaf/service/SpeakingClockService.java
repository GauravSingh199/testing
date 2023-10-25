package com.wisdomleaf.service;

import java.util.List;
import java.util.Optional;

import com.wisdomleaf.entity.Time;

public interface SpeakingClockService {

	String convertTimeToWords(String time);

	String handleInput(String inputTime);

	Time saveTime(Time time);

	List<Time> getAllTimes();

	Optional<Time> getTimeById(Long id);

	void deleteTime(Long id);

	
	




}