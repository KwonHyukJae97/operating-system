package com.operation.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import com.operation.management.domain.IncreaseH;
import com.operation.management.domain.IncreaseHRepository;
import com.operation.management.dto.IncreaseHDto;
import com.operation.management.dto.IncreaseHListDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class IncreaseHService {
    @Autowired
    private IncreaseHRepository increaseHRepository;

    public IncreaseHListDto list(IncreaseHListDto model) throws Exception{
        Page<IncreaseH> page = increaseHRepository.findAll(model.toSpecification(), model.toPage());
        
        
        model.setList(page.toList());
        model.setTotalCount(page.getTotalElements());
        System.out.println("=============model ===========:" + list(model));
        return model;
    }

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

    public IncreaseHDto update(IncreaseHDto model, long uid) throws Exception{
        IncreaseHDto view = this.view(uid);

        view.setStatus(model.getStatus());
        view.setLimit_price(model.getLimit_price());
        view.setSms_price(model.getSms_price());
        view.setLms_price(model.getLms_price());
        view.setMms_price(model.getMms_price());
        IncreaseH increaseH = increaseHRepository.save(view.toEntity());

        return new IncreaseHDto(increaseH);
    }

    public void delete(long uid) throws Exception{
        this.view(uid);
            increaseHRepository.deleteById(uid);
    }


    public List<IncreaseH> getUsers() {
        return increaseHRepository.findAll();
    }

    public List<IncreaseH> getList(){
        List<IncreaseH> increaseList = increaseHRepository.findAll();

        for(IncreaseH increaseHListDto : increaseList){
            IncreaseH increaseH = IncreaseH.builder()
                 .uid(increaseHListDto.getUid())
                 .grp_cd(increaseHListDto.getGrp_cd())
                 .status(increaseHListDto.getStatus())
                 .start_date(increaseHListDto.getStart_date())
                 .limit_price(increaseHListDto.getLimit_price())
                 .sms_price(increaseHListDto.getSms_price())
                 .lms_price(increaseHListDto.getLms_price())
                 .mms_price(increaseHListDto.getMms_price())
                 .rmk(increaseHListDto.getRmk())
                 .create_dttm(increaseHListDto.getCreate_dttm())
                 .build();
            increaseList.add(increaseH);
        }
        return increaseList;
    }

}
