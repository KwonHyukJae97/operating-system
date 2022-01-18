package com.operation.management.serverListService;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

import com.operation.management.serverListController.ServerListController.CreateServerListRequest;
import com.operation.management.serverListDomain.ServerList;
import com.operation.management.serverListDomain.ServerListRepository;
import com.operation.management.serverListDto.ServerListDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerListService {
    @Autowired
    private ServerListRepository serverListRepository;

    public ServerListDto view(Long id) throws Exception{
        Optional<ServerList> opt = serverListRepository.findById(id);
        if(opt.isPresent()){
            return new ServerListDto(opt.get());
        }else{
            throw new NameNotFoundException("리소스 없음");
        }
    }


    public ServerListDto insert(ServerListDto model) throws Exception{
        ServerList serverList = serverListRepository.save(model.toEntity());
        return new ServerListDto(serverList);
    }


    @Transactional
    public ServerListDto updateServerList(CreateServerListRequest model, long id) throws Exception{
        ServerListDto view = this.view(id);
        view.setServer_ip(model.getServer_ip());
        view.setServer_user(model.getServer_user());
        view.setStatus(model.getStatus());
        ServerList serverList = serverListRepository.save(view.toEntity());
        return new ServerListDto(serverList);

    }


    public Optional<ServerList> findById(Long id) throws Exception{
        return serverListRepository.findById(id);
    }


    @Transactional
    public void delete(long id) throws Exception{
        this.view(id);
        serverListRepository.deleteById(id);
    }


    public List<ServerList> getAllServerList(){
        return serverListRepository.findAll();
    }
    
}
