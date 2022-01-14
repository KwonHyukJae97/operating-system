package com.operation.management.thresHoldDomain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ThresHoldRepository extends JpaRepository<ThresHold, String>, JpaSpecificationExecutor<ThresHold> {

    Optional<ThresHold> findById(String grp_cd);
    
}
