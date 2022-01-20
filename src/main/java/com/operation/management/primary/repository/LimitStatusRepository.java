package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.LimitStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LimitStatusRepository extends JpaRepository<LimitStatus, Long>, JpaSpecificationExecutor<LimitStatus> {

    Optional<LimitStatus> findById(Long uid);
    
}
