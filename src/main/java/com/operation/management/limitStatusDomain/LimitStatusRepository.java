package com.operation.management.limitStatusDomain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LimitStatusRepository extends JpaRepository<LimitStatus, Long>, JpaSpecificationExecutor<LimitStatus> {

    Optional<LimitStatus> findById(Long uid);
    
}
