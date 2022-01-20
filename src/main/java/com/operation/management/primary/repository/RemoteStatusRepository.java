package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.RemoteStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RemoteStatusRepository extends JpaRepository<RemoteStatus, Long>, JpaSpecificationExecutor<RemoteStatus> {
    Optional<RemoteStatus> findById(Long key);
    
}
