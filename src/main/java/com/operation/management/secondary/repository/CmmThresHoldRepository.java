package com.operation.management.secondary.repository;

import java.util.Optional;

import com.operation.management.secondary.model.CmmThresHold;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmThresHoldRepository extends JpaRepository<CmmThresHold, String>, JpaSpecificationExecutor<CmmThresHold> {
    
    Optional<CmmThresHold> findById(String mbrId);
    
}
