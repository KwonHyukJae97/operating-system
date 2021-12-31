package com.operation.management.IncreaseHistory;

import com.operation.management.domain.IncreaseHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncreaseHistoryRepository extends JpaRepository<IncreaseHistory, Long>{


    public List<Increase>
    // IncreaseHistory findByData(String grpCd);
    // // public List<IncreaseHistory> findByUid(List<String> uid);

    // public List<IncreaseHistoryVO> findByUid(Long uid);

    // public List<IncreaseHistoryVO> findByGrpCd(String grpCd);

    // void save(IncreaseHistoryVO uid);
    
}
