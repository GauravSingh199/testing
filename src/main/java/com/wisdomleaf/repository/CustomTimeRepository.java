package com.wisdomleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wisdomleaf.entity.CustomTime;

public interface CustomTimeRepository extends JpaRepository<CustomTime, Long> {

}
