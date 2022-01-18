package com.operation.management.firstRepository;

import java.util.Optional;

import com.operation.management.firstEntity.RemoteUserList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RemoteUserListRepository extends JpaRepository<RemoteUserList, Long>, JpaSpecificationExecutor<RemoteUserList> {
    Optional<RemoteUserList> findById(Long id);
    
}
