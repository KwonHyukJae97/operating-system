package com.operation.management.primaryController;

import java.util.List;

import com.operation.management.primary.model.ThresHold;
import com.operation.management.primaryDto.ThresHoldDto;
import com.operation.management.primaryService.ThresHoldService;

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
public class ThresHoldController {

    @Autowired
    private ThresHoldService thresHoldService;

    @RequestMapping("/thresHold")
    String thresHoldPage(Model model){
        List<ThresHold> allThresHold = thresHoldService.getAllThresHold();
        model.addAttribute("allThresHold", allThresHold);
        log.info("allThresHold {}", allThresHold);
        return "/countThresHold/thresHold.html";
    }


    @GetMapping(value = "/insertThresHold")
    public String insertThresHold(){
        return "/countThresHold/insertThresHold";
    }

    @PostMapping("/insertThres")
    public String insert(ThresHoldDto model) throws Exception{
        System.out.println("인서트22222222???? : " + model);
        thresHoldService.insert(model);
        System.out.println("인서트???? : " + model);
        return "redirect:/thresHold";
    }


    @GetMapping(value = "/editThresHold")
    public String updateThresHold(String grp_cd, Model model) throws Exception{
        ThresHold dataT = thresHoldService.findById(grp_cd).map(m->m).orElse(null);
        log.info("dataT = {}", dataT.toString());
        model.addAttribute("dataT", dataT);
        return "/countThresHold/editThresHold";
    }


    @PostMapping("/updateThresHold/{grp_cd}")
    public String updateThresHold(@PathVariable("grp_cd") String grp_cd, CreateThresHoldRequest model) throws Exception{
        thresHoldService.updateThresHold(model, grp_cd);
        return "redirect:/thresHold";
    }

    @PostMapping("/listT/{grp_cd}")
    public String deleteThresHold(@PathVariable("grp_cd") String grp_cd) throws Exception{
        thresHoldService.deleteThresHold(grp_cd);
        return "redirect:/thresHold";
    }


    @GetMapping("/{grp_cd}")
    public ResponseEntity<?> viewThresHold(@PathVariable("grp_cd") final String grp_cd){
        ResponseEntity<?> entity = null;
        try{
            entity = new ResponseEntity<ThresHoldDto>(thresHoldService.viewThresHold(grp_cd), HttpStatus.OK);
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
    public static class CreateThresHoldRequest {
        // private String grp_cd;
        private String grp_nm;
        private String start_date;
        private String used_yn;
        private String limit_price;
        private float sms_price;
        private float lms_price;
        private float mms_price;
        private String alarm_group;
        private String reset_yn;
        private String reset_day;
        private String reset_price;
        private String reset_dttm;
    }
    
}
