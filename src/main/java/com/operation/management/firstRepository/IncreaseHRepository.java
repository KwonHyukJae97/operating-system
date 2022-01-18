package com.operation.management.firstRepository;

import java.util.Optional;

import com.operation.management.firstEntity.IncreaseH;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface IncreaseHRepository extends JpaRepository<IncreaseH, Long>, JpaSpecificationExecutor<IncreaseH>{

    Optional<IncreaseH> findById(Long uid);
    
}
