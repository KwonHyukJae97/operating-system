package com.operation.management.secondaryService;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

import com.operation.management.secondary.model.CmmThresHold;
import com.operation.management.secondary.repository.CmmThresHoldRepository;
import com.operation.management.secondaryController.CmmThresHoldController.CreateCmmThresHoldRequest;
import com.operation.management.secondaryDto.CmmThresHoldDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmmThresHoldService {

    @Autowired
    private CmmThresHoldRepository cmmThresHoldRepository;
    
    public CmmThresHoldDto view(String mbrId) throws Exception{
        Optional<CmmThresHold> opt = cmmThresHoldRepository.findById(mbrId);
        if(opt.isPresent()){
            return new CmmThresHoldDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }

    public CmmThresHoldDto insert(CmmThresHoldDto model) throws Exception{
        CmmThresHold cmmThresHold = cmmThresHoldRepository.save(model.toEntity());
        return new CmmThresHoldDto(cmmThresHold);
    }


    @Transactional
    public CmmThresHoldDto updateCmmThresHold(CreateCmmThresHoldRequest model, String mbrId) throws Exception{
        CmmThresHoldDto view = this.view(mbrId);
        view.setTCnt(model.getTCnt());
        view.setDCnt(model.getDCnt());
        view.setMCnt(model.getMCnt());
        view.setDelYn(model.getDelYn());
        view.setUpt(model.getUpt());
        view.setAdtId(model.getAdtId());
        CmmThresHold cmmThresHold = cmmThresHoldRepository.save(view.toEntity());
        return new CmmThresHoldDto(cmmThresHold);

    }


    public Optional<CmmThresHold> findById(String mbrId) throws Exception{
        return cmmThresHoldRepository.findById(mbrId);
    }


    public List<CmmThresHold> getAllCmmThresHold(){
        return cmmThresHoldRepository.findAll();
    }
}
