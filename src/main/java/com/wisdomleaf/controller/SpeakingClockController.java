package com.wisdomleaf.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wisdomleaf.entity.Time;
import com.wisdomleaf.service.SpeakingClockService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/speaking-clock")
public class SpeakingClockController {

    private final SpeakingClockService clockService;


    public SpeakingClockController(SpeakingClockService clockService) {
        this.clockService = clockService;
    }

    @GetMapping("/convert")
    public ResponseEntity<String> convertTimeToWords(@RequestParam("time") String time) {
        String convertedTime = clockService.convertTimeToWords(time);
        return ResponseEntity.ok(convertedTime);
    }

    @GetMapping("/input")
    public ResponseEntity<String> handleUserInput(@RequestParam("inputTime") String inputTime) {
        String response = clockService.handleInput(inputTime);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save-time")
    public ResponseEntity<String> saveTime(@RequestBody Time time) {
        Time savedTime = clockService.saveTime(time);
        return ResponseEntity.ok("Time saved with ID: " + savedTime.getId());
    }

    @GetMapping("/times")
    public ResponseEntity<List<Time>> getAllTimes() {
        List<Time> times = clockService.getAllTimes();
        return ResponseEntity.ok(times);
    }

    @GetMapping("/time/{id}")
    public ResponseEntity<Time> getTimeById(@PathVariable Long id) {
        Optional<Time> time = clockService.getTimeById(id);
        return time.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete-time/{id}")
    public ResponseEntity<String> deleteTime(@PathVariable Long id) {
        clockService.deleteTime(id);
        return ResponseEntity.ok("Time with ID " + id + " deleted successfully.");
    }
}

