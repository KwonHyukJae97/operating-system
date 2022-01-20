package com.operation.management.secondaryController;

import java.util.List;

import com.operation.management.secondary.model.CmmThresHold;
import com.operation.management.secondaryDto.CmmThresHoldDto;
import com.operation.management.secondaryService.CmmThresHoldService;

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
public class CmmThresHoldController {

    @Autowired
    private CmmThresHoldService cmmThresHoldService;


    @RequestMapping("/cmmThresHold")
    String cmmThresHoldPage(Model model){
        List<CmmThresHold> allCmmThresHold = cmmThresHoldService.getAllCmmThresHold();
        model.addAttribute("allCmmThresHold", allCmmThresHold);
        System.out.println("가지고가지고 : " + allCmmThresHold);
        System.out.println("rkwlrhrkwlrh : " + model);
        log.info("allBlockUser {}", allCmmThresHold);
        return "cmmThresHold/cmmThresHold.html";
    }

    @GetMapping(value = "/insertCmmThresHold")
    public String insertCmmThresHold(){
        return "/cmmThresHold/insertCmmThresHold";
    }


    @PostMapping("/insertCmmThres")
    public String insert(CmmThresHoldDto model) throws Exception{
        cmmThresHoldService.insert(model);
        return "redirect:/cmmThresHold";
    }


    @GetMapping(value = "editCmmThresHold")
    public String updateCmmThresHold(String mbrId, Model model) throws Exception{
        CmmThresHold dataC = cmmThresHoldService.findById(mbrId).map(m->m).orElse(null);
        log.info("dataC = {}", dataC.toString());
        model.addAttribute("dataC", dataC);
        return "/cmmThresHold/editCmmThresHold";
    }


    @PostMapping("/updateCmmThresHold/{mbrId}")
    public String updateCmmThresHold(@PathVariable("mbrId") String mbrId, CreateCmmThresHoldRequest model)throws Exception{
        cmmThresHoldService.updateCmmThresHold(model, mbrId);
        return "redirect:/cmmThresHold";
    }


    @GetMapping("/cmmThresHold/{mbrId}")
    public ResponseEntity<?> view(@PathVariable("mbrId") final String mbrId){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<CmmThresHoldDto>(cmmThresHoldService.view(mbrId), HttpStatus.OK);
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
    public static class CreateCmmThresHoldRequest{
        private int tCnt;
        private int dCnt;
        private int mCnt;
        private String delYn;
        private String upt;
        private String adtId;
    }
}
