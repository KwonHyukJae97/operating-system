package com.operation.management.tertiaryController;

import java.util.List;

import com.operation.management.tertiary.model.CmmCdauth;
import com.operation.management.tertiaryDto.CmmCdauthDto;
import com.operation.management.tertiaryService.CmmCdauthService;

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
public class CmmCdauthController {

    @Autowired
    private CmmCdauthService cmmCdauthService;


    @RequestMapping("/cmmCdauth")
    String cmmCdauth(Model model){
        List<CmmCdauth> allCmmCdauth = cmmCdauthService.getAllCmmCdauth();
        model.addAttribute("allCmmCdauth", allCmmCdauth);
        System.out.println("cmmCdauth데이터 가지고옴????C : " + allCmmCdauth);
        System.out.println("cmmCdauth모델 가지고옴???C : " + model);
        log.info("allCmmCdauth {}", allCmmCdauth);
        return "cmmCdauth/cmmCdauth.html";
    }


    @GetMapping(value = "/editCmmCdauth")
    public String updateCmmCdauth(String mbrId, Model model) throws Exception{
        CmmCdauth dataCmm = cmmCdauthService.findById(mbrId).map(m->m).orElse(null);
        log.info("dataCmm = {}", dataCmm.toString());
        model.addAttribute("dataCmm", dataCmm);
        System.out.println("edit창으로 cmmCdauth가지고감??? C:" + model);
        return "/cmmCdauth/editCmmCdauth";
    }


    @PostMapping("/updateCmmCdauth/{mbrId}")
    public String updateCmmCdauth(@PathVariable("mbrId") String mbrId, CreateCmmCdauthRequest model)throws Exception{
        System.out.println("수정하고 넘김??? CON: " + model);
        cmmCdauthService.updateCmmCdauth(model, mbrId);
        System.out.println("수정하고 넘김??? C: " + model);
        return "redirect:/cmmCdauth";
    }


    @GetMapping("/cmmCdauth/{mbrId}")
    public ResponseEntity<?> view(@PathVariable("mbrId") final String mbrId){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<CmmCdauthDto>(cmmCdauthService.view(mbrId), HttpStatus.OK);
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
    public static class CreateCmmCdauthRequest{
        private String authSeq;
        private String mbrIp;
        private String mbrPort;
        private int spdpsec;
        private int maxLimitRate;
        private String rmk;
        private String delYn;
        private String regUsr;
        private String regDttm;
        private String uptUsr;
        private String uptDttm;
        private int mbrLevel;
        private String spamFg;
        private String mbrIp2;
        private String client_version;;
        private String opChgFg;
        private String smtFg;
        private String alarmType;
        private String privateLineFg;
        private String callBlockFg;
        private String block60Fg;
        private String updateUser;
        private String updateDate;
        private String authSecretData;
        private String authCredentialData;
    }
}
