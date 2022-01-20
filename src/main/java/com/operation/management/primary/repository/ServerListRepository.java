package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.ServerList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServerListRepository extends JpaRepository<ServerList, Long>, JpaSpecificationExecutor<ServerList>{
    
    Optional<ServerList> findById(Long id);
    
}
