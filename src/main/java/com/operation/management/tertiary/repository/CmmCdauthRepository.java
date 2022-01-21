package com.operation.management.tertiary.repository;


import java.util.Optional;

import com.operation.management.tertiary.model.CmmCdauth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmCdauthRepository extends JpaRepository<CmmCdauth, String>, JpaSpecificationExecutor<CmmCdauth>{
    Optional<CmmCdauth> findById(String mbrId);
}
