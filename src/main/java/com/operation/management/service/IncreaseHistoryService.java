package com.operation.management.service;

Autowired;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.operation.management.IncreaseHistory.IncreaseHistoryRepository;
import com.operation.management.domain.IncreaseHistory;
import com.operation.management.vo.IncreaseHistoryVO;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class IncreaseHistoryService {
    private IncreaseHistoryRepository increaseHistoryRepository;

    @Transactional
    public List<IncreaseHistoryVO> getHistoryList(){
        List<IncreaseHistory> increaseHistory = increaseHistoryRepository.findAll();
        List<IncreaseHistoryVO> increaseHistoryVO2 = new ArrayList<>();

        for(IncreaseHistory increaseHistory2 : increaseHistory){
            IncreaseHistoryVO increaseHistoryVO = IncreaseHistoryVO.builder().uid(increaseHistory2.getUid()).grpCd(increaseHistory2.getGrpCd()).status(increaseHistory2.getStatus()).startDate(increaseHistory2.getStartDate()).limitPrice(increaseHistory2.getLimitPrice()).smsPrice(increaseHistory2.getSmsPrice()).lmsPrice(increaseHistory2.getLmsPrice()).mmsPrice(increaseHistory2.getMmsPrice()).rmk(increaseHistory2.getRmk()).createDttm(increaseHistory2.getCreateDttm()).build();
            increaseHistoryVO2.add(increaseHistoryVO);
        }
        return increaseHistoryVO2;

    }

    // @Autowired
    // private IncreaseHistoryRepository increaseHistoryRepository;


    // // public List<IncreaseHistoryVO> findAll(){
    // //     List<IncreaseHistoryVO> history = new ArrayList<>();
    // //     increaseHistoryRepository.findAll().forEach(e -> history.add(e));
    // //     return history;
    // // }

    // public List<IncreaseHistoryVO> findByGrpCd(String grpCd){
    //     List<IncreaseHistoryVO> history = increaseHistoryRepository.findByGrpCd(grpCd);
    //     return history;

    // }




    // @Transactional
    // public IncreaseHistory getSelect(String grpCd){
    //     return increaseHistoryRepository.findByData(grpCd);
    // }

    // @Transactional
    // public List<IncreaseHistory> getIncreaseByUid(List<String> uid){
    //     return increaseHistoryRepository.findByUid(uid);
    // }












    // @Transactional
    // public IncreaseHistoryVO select(int uid){
    //     List<IncreaseHistory> increaseHistory = increaseHistoryRepository.findByUid(uid);
    //     if(increaseHistory == null){
    //         throw new NullPointerException("uid is not exist");
    //     }

    //     IncreaseHistoryVO increaseHistoryVO = new IncreaseHistoryVO(0, "uid exist", "", "", "", 0, 0, 0, "", null);
    //     return increaseHistoryVO;
    // }

    }
    

