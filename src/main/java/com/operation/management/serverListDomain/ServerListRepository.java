package com.operation.management.serverListDomain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServerListRepository extends JpaRepository<ServerList, Long>, JpaSpecificationExecutor<ServerList>{
    
    Optional<ServerList> findById(Long id);
    
}
