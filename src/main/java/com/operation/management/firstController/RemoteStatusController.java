package com.operation.management.firstController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.operation.management.firstDto.RemoteStatusDto;
import com.operation.management.firstEntity.RemoteStatus;
import com.operation.management.firstService.RemoteStatusService;

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
public class RemoteStatusController {

    @Autowired
    private RemoteStatusService remoteStatusService;

    @RequestMapping("/remoteStatus")
    String remoteStatusPage(Model model){
        List<RemoteStatus> allRemoteStatus = remoteStatusService.getAllRemoteStatus();
        model.addAttribute("allRemoteStatus", allRemoteStatus);
        log.info("allRemoteStatus {}",allRemoteStatus);
        return "/remoteStatus/remoteStatus.html";
    }


    @GetMapping(value = "/insertRemoteStatus")
    public String insertRemoteStatus(){
        return "/remoteStatus/insertRemoteStatus";
    }


    @PostMapping("/insertRStatus")
    public String insert(RemoteStatusDto model) throws Exception{
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = dateFormat.parse(dateFormat.format(date));
        model.setCreate_dttm(now);
        model.setUpdate_dttm(now);
        remoteStatusService.insert(model);
        return "redirect:/remoteStatus";
    }


    @GetMapping(value = "/editRemoteStatus")
    public String updateRemoteStatus(Long key, Model model) throws Exception{
        RemoteStatus dataRS = remoteStatusService.findById(key).map(m->m).orElse(null);
        log.info("dataRS = {}", dataRS.toString());
        System.out.println("제발제발제발 : " + dataRS.getKey());
        model.addAttribute("dataRS", dataRS);
        return "/remoteStatus/editRemoteStatus";
    }


    @PostMapping("/updateRemoteStatus/{key}")
    public String updateRemoteStatus(@PathVariable("key") Long key, CreateRemoteStatusRequest model)throws Exception{
        remoteStatusService.updateRemoteStatus(model, key);
        return "redirect:/remoteStatus";
    }


    @PostMapping("/listRS/{key}")
    public String deleteRemoteStatus(@PathVariable("key") Long key) throws Exception{
        remoteStatusService.delete(key);
        return "redirect:/remoteStatus";
    }


    @GetMapping("/remoteStatus/{key}")
    public ResponseEntity<?> view(@PathVariable("key") final long key){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<RemoteStatusDto>(remoteStatusService.view(key), HttpStatus.OK);
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
    public static class CreateRemoteStatusRequest{
    private String email;
    private String status;
    private String server_ip;
    private String server_user;
    private String reason;
    private String start_time;
    private String end_time;
    private String create_ip;
    private String update_admin;
    private String phn_id;
    private String alarm_type;

    }
}
