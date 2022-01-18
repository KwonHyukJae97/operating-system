package com.operation.management.remoteUserListDomain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RemoteUserListRepository extends JpaRepository<RemoteUserList, Long>, JpaSpecificationExecutor<RemoteUserList> {
    Optional<RemoteUserList> findById(Long id);
    
}
