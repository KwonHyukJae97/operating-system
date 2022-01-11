package com.operation.management.domain;

import java.util.Optional;

import com.operation.management.dto.IncreaseHDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public interface IncreaseHRepository extends JpaRepository<IncreaseH, Long>, JpaSpecificationExecutor<IncreaseH>, CrudRepository<IncreaseH, Long>{

    Optional<IncreaseH> findById(Long uid);
    
}
