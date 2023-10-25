package com.wisdomleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisdomleaf.entity.Time;
import com.wisdomleaf.repository.TimeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpeakingClockServiceImpl implements SpeakingClockService {

    private final TimeRepository timeRepository;

    @Autowired
    public SpeakingClockServiceImpl(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public String convertTimeToWords(String time) {
    	  // Split the time into hours and minutes
        String[] timeParts = time.split(":");
        
        if (timeParts.length != 2) {
            throw new IllegalArgumentException("Invalid time format. Please provide time in HH:mm format.");
        }
        
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Invalid time values. Hours must be between 0 and 23, and minutes must be between 0 and 59.");
        }
        
        String[] hoursWords = {
            "midnight", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
        };
        
        String[] tensWords = {
            "", "", "twenty", "thirty", "forty", "fifty"
        };
        
        String timeInWords = "It's ";
        
        if (hours == 0) {
            timeInWords += "midnight";
        } else if (hours == 12) {
            timeInWords += "noon";
        } else if (hours < 12) {
            timeInWords += hoursWords[hours];
        } else {
            timeInWords += hoursWords[hours - 12];
        }
        
        if (minutes > 0) {
            if (minutes < 10) {
                timeInWords += " o'clock";
            } else if (minutes < 20) {
                timeInWords += " " + hoursWords[minutes];
            } else {
                int tens = minutes / 10;
                int ones = minutes % 10;
                timeInWords += " " + tensWords[tens];
                if (ones > 0) {
                    timeInWords += " " + hoursWords[ones];
                }
            }
        }
        
        return timeInWords;
    }

    @Override
    public String handleInput(String inputTime) {
        if (inputTime.equals("12:00")) {
            return "It's Midday";
        } else if (inputTime.equals("00:00")) {
            return "It's Midnight";
        } else {
            // Implement logic for other input times
            return "Response for input time"; // Replace with actual logic
        }
    }

    @Override
    public Time saveTime(Time time) {
        return timeRepository.save(time);
    }

    @Override
    public List<Time> getAllTimes() {
        return timeRepository.findAll();
    }

    @Override
    public Optional<Time> getTimeById(Long id) {
        return timeRepository.findById(id);
    }

    @Override
    public void deleteTime(Long id) {
        timeRepository.deleteById(id);
    }
}

