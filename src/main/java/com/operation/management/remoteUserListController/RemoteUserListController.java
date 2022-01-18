package com.operation.management.remoteUserListController;

import java.util.List;

import com.operation.management.remoteUserListDomain.RemoteUserList;
import com.operation.management.remoteUserListDto.RemoteUserListDto;
import com.operation.management.remoteUserListService.RemoteUserListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RemoteUserListController {

    @Autowired
    private RemoteUserListService userListService;

    @RequestMapping("/remoteUserList")
    String blockUserPage(Model model){
        List<RemoteUserList> allUserList = userListService.getAllUserList();
        model.addAttribute("allUserList", allUserList);
        log.info("allUserList {}", allUserList);
        return "/remoteUserList.html";
    }


    @GetMapping(value = "/insertUserList")
    public String insertUserList(){
        return "/insertRemoteUserList";
    }


    @PostMapping("/insertUser")
    public String insert(RemoteUserListDto model) throws Exception{
        userListService.insert(model);
        return "redirect:/remoteUserList";
    }


    @GetMapping(value = "editUserList")
    public String updateUserList(Long id, Model model) throws Exception{
        RemoteUserList dataU = userListService.findById(id).map(m->m).orElse(null);
        log.info("dataB = {}", dataU.toString());
        model.addAttribute("dataU", dataU);
        return "/editRemoteUserList";
    }


    @PostMapping("/updateUserList/{id}")
    public String updateUserList(@PathVariable("id") Long id, CreateUserListRequest model)throws Exception{
        userListService.updateUserList(model, id);
        return "redirect:/remoteUserList";
    }


    @PostMapping("/listU/{id}")
    public String deleteUserList(@PathVariable("id") Long id) throws Exception{
        userListService.delete(id);
        return "redirect:/remoteUserList";
    }


    @GetMapping("/userList/{id}")
    public ResponseEntity<?> view(@PathVariable("id") final long id){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<RemoteUserListDto>(userListService.view(id), HttpStatus.OK);
        }catch (NotFoundException e){
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateUserListRequest{
        private String name;
        private String email;
        private String phn_id;
        private String used_yn;
        private String type;
        private String server_user;
        private String server_ip; 
    }
    
}
