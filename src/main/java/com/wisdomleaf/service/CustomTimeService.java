package com.wisdomleaf.service;

import java.util.List;
import java.util.Optional;

import com.wisdomleaf.entity.CustomTime;

public interface CustomTimeService {
    CustomTime saveCustomTime(CustomTime customTime);
    List<CustomTime> getAllCustomTimes();
    Optional<CustomTime> getCustomTimeById(Long id);
    void deleteCustomTime(Long id);
}
