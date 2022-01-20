package com.operation.management.primary.repository;

import java.util.Optional;

import com.operation.management.primary.model.BlockUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlockUserRepository extends JpaRepository<BlockUser, Long>, JpaSpecificationExecutor<BlockUser> {
    
    Optional<BlockUser> findById(Long id);
    
}
