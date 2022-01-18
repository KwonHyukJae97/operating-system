package com.operation.management.firstService;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

import com.operation.management.firstController.RemoteUserListController.CreateUserListRequest;
import com.operation.management.firstDto.RemoteUserListDto;
import com.operation.management.firstEntity.RemoteUserList;
import com.operation.management.firstRepository.RemoteUserListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteUserListService {
    @Autowired
    private RemoteUserListRepository userListRepository;

    public RemoteUserListDto view(Long id) throws Exception{
        Optional<RemoteUserList> opt = userListRepository.findById(id);
        if(opt.isPresent()){
            return new RemoteUserListDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }


    public RemoteUserListDto insert(RemoteUserListDto model) throws Exception{
        RemoteUserList userList = userListRepository.save(model.toEntity());
        return new RemoteUserListDto(userList);
    }


    @Transactional
    public RemoteUserListDto updateUserList(CreateUserListRequest model, long id) throws Exception{
        RemoteUserListDto view = this.view(id);
        view.setName(model.getName());
        view.setEmail(model.getEmail());
        view.setPhn_id(model.getPhn_id());
        view.setUsed_yn(model.getUsed_yn());
        view.setType(model.getType());
        view.setServer_user(model.getServer_user());
        view.setServer_ip(model.getServer_ip());
        RemoteUserList userList = userListRepository.save(view.toEntity());
        return new RemoteUserListDto(userList);

    }


    public Optional<RemoteUserList> findById(Long id) throws Exception{
        return userListRepository.findById(id);
    }


    @Transactional
    public void delete(long id) throws Exception{
        this.view(id);
        userListRepository.deleteById(id);
    }


    public List<RemoteUserList> getAllUserList(){
        return userListRepository.findAll();
    }
    
}
