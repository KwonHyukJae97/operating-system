package com.operation.management.primaryService;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

import com.operation.management.primary.model.LimitStatus;
import com.operation.management.primary.repository.LimitStatusRepository;
import com.operation.management.primaryController.LimitStatusController.CreateLimitStatusRequest;
import com.operation.management.primaryDto.LimitStatusDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LimitStatusService {
    @Autowired
    private LimitStatusRepository limitStatusRepository;

    public LimitStatusDto view(Long uid) throws Exception{
        Optional<LimitStatus> opt = limitStatusRepository.findById(uid);
        if(opt.isPresent()){
            return new LimitStatusDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }


    public LimitStatusDto insert(LimitStatusDto model) throws Exception{
        LimitStatus limitStatus = limitStatusRepository.save(model.toEntity());
        return new LimitStatusDto(limitStatus);
    }


    @Transactional
    public LimitStatusDto updateLimitStatus(CreateLimitStatusRequest model, long uid) throws Exception{
        LimitStatusDto view = this.view(uid);
        view.setLimit_price(model.getLimit_price());
        view.setUsed(model.getUsed());
        view.setPercent(model.getPercent());
        view.setSms_cnt(model.getSms_cnt());
        view.setLms_cnt(model.getLms_cnt());
        view.setMms_cnt(model.getMms_cnt());
        LimitStatus limitStatus = limitStatusRepository.save(view.toEntity());
        return new LimitStatusDto(limitStatus);
    }


    public Optional<LimitStatus> findById(Long uid) throws Exception{
        return limitStatusRepository.findById(uid);
    }


    @Transactional
    public void delete(long uid) throws Exception{
        this.view(uid);
        limitStatusRepository.deleteById(uid);
    }

    public List<LimitStatus> getAllLimitStatus(){
        return limitStatusRepository.findAll();
    }
    
}
