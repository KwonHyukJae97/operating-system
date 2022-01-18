package com.operation.management.firstService;


import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

import com.operation.management.firstController.RemoteStatusController.CreateRemoteStatusRequest;
import com.operation.management.firstDto.RemoteStatusDto;
import com.operation.management.firstEntity.RemoteStatus;
import com.operation.management.firstRepository.RemoteStatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteStatusService {

    @Autowired
    private RemoteStatusRepository remoteStatusRepository;

    public RemoteStatusDto view(Long key) throws Exception{
        Optional<RemoteStatus> opt = remoteStatusRepository.findById(key);
        if(opt.isPresent()){
            return new RemoteStatusDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }


    public RemoteStatusDto insert(RemoteStatusDto model) throws Exception{
        RemoteStatus remoteStatus = remoteStatusRepository.save(model.toEntity());
        return new RemoteStatusDto(remoteStatus);
    }


    @Transactional
    public RemoteStatusDto updateRemoteStatus(CreateRemoteStatusRequest model, long key) throws Exception{
        RemoteStatusDto view = this.view(key);
        System.out.println("지발지발 : " + view.getKey());
        view.setEmail(model.getEmail());
        view.setStatus(model.getStatus());
        view.setServer_ip(model.getServer_ip());
        view.setServer_user(model.getServer_user());
        view.setReason(model.getReason());
        view.setPhn_id(model.getPhn_id());
        view.setAlarm_type(model.getAlarm_type());
        RemoteStatus remoteStatus = remoteStatusRepository.save(view.toEntity());
        return new RemoteStatusDto(remoteStatus);

    }


    public Optional<RemoteStatus> findById(Long key) throws Exception{
        return remoteStatusRepository.findById(key);
    }


    @Transactional
    public void delete(long key) throws Exception{
        this.view(key);
        remoteStatusRepository.deleteById(key);
    }


    public List<RemoteStatus> getAllRemoteStatus(){
        return remoteStatusRepository.findAll();
    }
    
}
