package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.RemoteUserList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RemoteUserListRepository extends JpaRepository<RemoteUserList, Long>, JpaSpecificationExecutor<RemoteUserList> {
    Optional<RemoteUserList> findById(Long id);
    
}
