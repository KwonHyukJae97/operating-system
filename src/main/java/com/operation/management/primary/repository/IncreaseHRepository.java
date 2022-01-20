package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.IncreaseH;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface IncreaseHRepository extends JpaRepository<IncreaseH, Long>, JpaSpecificationExecutor<IncreaseH>{

    Optional<IncreaseH> findById(Long uid);
    
}
