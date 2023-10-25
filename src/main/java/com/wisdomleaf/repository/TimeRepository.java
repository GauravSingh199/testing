package com.wisdomleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wisdomleaf.entity.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
    // Custom query methods, if needed
}
