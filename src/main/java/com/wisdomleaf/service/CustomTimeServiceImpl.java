package com.wisdomleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisdomleaf.entity.CustomTime;
import com.wisdomleaf.repository.CustomTimeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomTimeServiceImpl implements CustomTimeService {

    private final CustomTimeRepository customTimeRepository;

    @Autowired
    public CustomTimeServiceImpl(CustomTimeRepository customTimeRepository) {
        this.customTimeRepository = customTimeRepository;
    }

    @Override
    public CustomTime saveCustomTime(CustomTime customTime) {
        return customTimeRepository.save(customTime);
    }

    @Override
    public List<CustomTime> getAllCustomTimes() {
        return customTimeRepository.findAll();
    }

    @Override
    public Optional<CustomTime> getCustomTimeById(Long id) {
        return customTimeRepository.findById(id);
    }

    @Override
    public void deleteCustomTime(Long id) {
        customTimeRepository.deleteById(id);
    }
}

