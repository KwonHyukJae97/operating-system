package com.operation.management.secondary.repository;



import com.operation.management.secondary.model.SecondTestEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondTestEntityRepository extends CrudRepository<SecondTestEntity, String>{
    
}
