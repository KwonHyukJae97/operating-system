package com.operation.management.remoteStatusDomain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RemoteStatusRepository extends JpaRepository<RemoteStatus, Long>, JpaSpecificationExecutor<RemoteStatus> {
    Optional<RemoteStatus> findById(Long key);
    
}
