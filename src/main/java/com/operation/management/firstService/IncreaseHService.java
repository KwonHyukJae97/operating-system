package com.operation.management.firstService;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

import com.operation.management.firstController.IncreaseHController.CreateMemberRequest;
import com.operation.management.firstDto.IncreaseHDto;
import com.operation.management.firstEntity.IncreaseH;
import com.operation.management.firstRepository.IncreaseHRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncreaseHService {
    @Autowired
    private IncreaseHRepository increaseHRepository;


    public IncreaseHDto view(Long uid) throws Exception{
        Optional<IncreaseH> opt = increaseHRepository.findById(uid);
        if(opt.isPresent()){
            return new IncreaseHDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }


    public IncreaseHDto insert(IncreaseHDto model) throws Exception{
        IncreaseH increaseH = increaseHRepository.save(model.toEntity());
        return new IncreaseHDto(increaseH);
    }

    
    @Transactional
    public IncreaseHDto update(CreateMemberRequest model, long uid) throws Exception{
        IncreaseHDto view = this.view(uid);
        view.setStatus(model.getStatus());
        view.setLimit_price(model.getLimit_price());
        view.setSms_price(model.getSms_price());
        view.setLms_price(model.getLms_price());
        view.setMms_price(model.getMms_price());
        IncreaseH increaseH = increaseHRepository.save(view.toEntity());
        return new IncreaseHDto(increaseH);
    }


    public Optional<IncreaseH> findById(Long uid) throws Exception{
        return increaseHRepository.findById(uid);
    }


    @Transactional
    public void delete(long uid) throws Exception{
        this.view(uid);
            increaseHRepository.deleteById(uid);
    }


    public List<IncreaseH> getALLUsers() {
        return increaseHRepository.findAll();
    }
}
