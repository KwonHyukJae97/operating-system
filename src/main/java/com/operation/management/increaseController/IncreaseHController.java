package com.operation.management.increaseController;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.operation.management.increaseDomain.IncreaseH;
import com.operation.management.increaseDto.IncreaseHDto;
import com.operation.management.increaseService.IncreaseHService;

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
public class IncreaseHController {

    @Autowired
    private IncreaseHService increaseHService;


    @RequestMapping("/increaseH")
    String indexPage(Model model){
        List<IncreaseH> allUsers = increaseHService.getALLUsers();
        model.addAttribute("allUsers", allUsers);
        log.info("allUsers {}",allUsers);
        return "/increaseH.html";
    }

    
    @RequestMapping("/")
    public String list(Model model){
        return "/index";
    }


    @GetMapping(value = "/insertIncreaseH")
    public String insertIncreaseH() {
        return "/insertIncreaseH";
    }


    @PostMapping("/insert")
    public String insert(IncreaseHDto model) throws Exception{
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = dateFormat.parse(dateFormat.format(date));
        model.setCreate_dttm(now);
        increaseHService.insert(model);
        System.out.println("시간시간시간시간 : " + model);
        return "redirect:/increaseH";
    }


    @GetMapping(value = "/editIncreaseH")
    public String updateIncrease(Long uid, Model model) throws Exception{
       IncreaseH data = increaseHService.findById(uid).map(m->m).orElse(null);
        log.info("result = {}", data.toString());
        System.out.println("가져왓니가져왓니~~~" + data.toString());
        model.addAttribute("data", data);
        return "/editIncreaseH";
        
    }


    @PostMapping("/update/{uid}")
    public String update(@PathVariable("uid") Long uid, CreateMemberRequest model) throws Exception{
        increaseHService.update(model, uid);
        return "redirect:/increaseH";
    }


    @PostMapping("/list/{uid}")
    public String delete(@PathVariable("uid") Long uid) throws Exception{
        System.out.println("Delete TEST()");
        increaseHService.delete(uid);
        return "redirect:/increaseH";
    }

    
    @GetMapping("/{uid}")
    public ResponseEntity<?> view(@PathVariable("uid") final long uid){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<IncreaseHDto>(increaseHService.view(uid), HttpStatus.OK);
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
    public static class CreateMemberRequest {
        private String status;
        private String limit_price;
        private float sms_price;
        private float lms_price;
        private float mms_price;
   
    }
}
