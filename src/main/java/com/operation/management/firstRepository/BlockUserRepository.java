package com.operation.management.firstRepository;

import java.util.Optional;

import com.operation.management.firstEntity.BlockUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlockUserRepository extends JpaRepository<BlockUser, Long>, JpaSpecificationExecutor<BlockUser> {
    
    Optional<BlockUser> findById(Long id);
    
}
