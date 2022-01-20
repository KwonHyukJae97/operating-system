package com.operation.management.primaryController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.operation.management.primary.model.LimitStatus;
import com.operation.management.primaryDto.LimitStatusDto;
import com.operation.management.primaryService.LimitStatusService;

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
public class LimitStatusController {

    @Autowired
    private LimitStatusService limitStatusService;

    @RequestMapping("/limitStatus")
    String limitStatusPage(Model model){
        List<LimitStatus> allLimitStatus = limitStatusService.getAllLimitStatus();
        model.addAttribute("allLimitStatus", allLimitStatus);
        log.info("allLimitStatus {}", allLimitStatus);
        return "/countStatus/limitStatus.html";
        
    }


    @GetMapping(value = "/insertLimitStatus")
    public String insertLimitStatus(){
        return "/countStatus/insertLimitStatus";
    }


    @PostMapping("/insertLimit")
    public String insert(LimitStatusDto model) throws Exception{
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = dateFormat.parse(dateFormat.format(date));
        model.setCreate_dttm(now);
        limitStatusService.insert(model);
        return "redirect:/limitStatus";
    }


    @GetMapping(value = "/editLimitStatus")
    public String updateLimitStatus(Long uid, Model model) throws Exception{
        LimitStatus dataL = limitStatusService.findById(uid).map(m->m).orElse(null);
        log.info("dataL = {}", dataL.toString());
        model.addAttribute("dataL", dataL);
        return "/countStatus/editLimitStatus";
    }


    @PostMapping("/updateLimitStatus/{uid}")
    public String updateLimitStatus(@PathVariable("uid") Long uid, CreateLimitStatusRequest model)throws Exception{
        limitStatusService.updateLimitStatus(model, uid);
        return "redirect:/limitStatus";
    }


    @PostMapping("/listL/{uid}")
    public String deleteLimitStatus(@PathVariable("uid") Long uid) throws Exception{
        limitStatusService.delete(uid);
        return "redirect:/limitStatus";
    }


    @GetMapping("/limitStatus/{uid}")
    public ResponseEntity<?> view(@PathVariable("uid") final long uid){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<LimitStatusDto>(limitStatusService.view(uid), HttpStatus.OK);
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
    public static class CreateLimitStatusRequest{
        private String limit_price;
        private int used;
        private int percent;
        private int sms_cnt;
        private int lms_cnt;
        private int mms_cnt;
    }
    
}
