package com.operation.management.firstRepository;

import java.util.Optional;

import com.operation.management.firstEntity.ServerList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServerListRepository extends JpaRepository<ServerList, Long>, JpaSpecificationExecutor<ServerList>{
    
    Optional<ServerList> findById(Long id);
    
}
