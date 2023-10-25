package com.wisdomleaf.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wisdomleaf.entity.CustomTime;
import com.wisdomleaf.service.CustomTimeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/custom-time")
public class CustomTimeController {

    private final CustomTimeService customTimeService;

    
    public CustomTimeController(CustomTimeService customTimeService) {
        this.customTimeService = customTimeService;
    }

    @PostMapping("/save")
    public ResponseEntity<CustomTime> saveCustomTime(@RequestBody CustomTime customTime) {
        CustomTime savedTime = customTimeService.saveCustomTime(customTime);
        return ResponseEntity.ok(savedTime);
    }

    @GetMapping("/times")
    public ResponseEntity<List<CustomTime>> getAllCustomTimes() {
        List<CustomTime> customTimes = customTimeService.getAllCustomTimes();
        return ResponseEntity.ok(customTimes);
    }

    @GetMapping("/time/{id}")
    public ResponseEntity<CustomTime> getCustomTimeById(@PathVariable Long id) {
        Optional<CustomTime> customTime = customTimeService.getCustomTimeById(id);
        return customTime.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomTime(@PathVariable Long id) {
        customTimeService.deleteCustomTime(id);
        return ResponseEntity.ok("CustomTime with ID " + id + " deleted successfully.");
    }
}
