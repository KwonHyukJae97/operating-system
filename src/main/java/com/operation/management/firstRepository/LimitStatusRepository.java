package com.operation.management.firstRepository;

import java.util.Optional;

import com.operation.management.firstEntity.LimitStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LimitStatusRepository extends JpaRepository<LimitStatus, Long>, JpaSpecificationExecutor<LimitStatus> {

    Optional<LimitStatus> findById(Long uid);
    
}
