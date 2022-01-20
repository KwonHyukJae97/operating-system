package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.ThresHold;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ThresHoldRepository extends JpaRepository<ThresHold, String>, JpaSpecificationExecutor<ThresHold> {

    Optional<ThresHold> findById(String grp_cd);
    
}
