package com.operation.management.primaryService;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

import com.operation.management.primary.model.BlockUser;
import com.operation.management.primary.repository.BlockUserRepository;
import com.operation.management.primaryController.BlockUserController.CreateBlockUserRequest;
import com.operation.management.primaryDto.BlockUserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockUserService {
    @Autowired
    private BlockUserRepository blockUserRepository;

    public BlockUserDto view(Long id) throws Exception{
        Optional<BlockUser> opt = blockUserRepository.findById(id);
        if(opt.isPresent()){
            return new BlockUserDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }


    public BlockUserDto insert(BlockUserDto model) throws Exception{
        BlockUser blockUser = blockUserRepository.save(model.toEntity());
        return new BlockUserDto(blockUser);
    }


    @Transactional
    public BlockUserDto updateBlockUser(CreateBlockUserRequest model, long id) throws Exception{
        BlockUserDto view = this.view(id);
        view.setServer_ip(model.getServer_ip());
        view.setServer_user(model.getServer_user());
        BlockUser blockUser = blockUserRepository.save(view.toEntity());
        return new BlockUserDto(blockUser);

    }


    public Optional<BlockUser> findById(Long id) throws Exception{
        return blockUserRepository.findById(id);
    }


    @Transactional
    public void delete(long id) throws Exception{
        this.view(id);
        blockUserRepository.deleteById(id);
    }


    public List<BlockUser> getAllBlockUser(){
        return blockUserRepository.findAll();
    }
    
    
}
