package com.operation.management.IncreaseHistory;

import java.util.List;

import com.operation.management.domain.IncreaseH;
import com.operation.management.service.IncreaseHService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IncreaseHController {

    private IncreaseHService increaseHService;

    public IncreaseHController(IncreaseHService increaseHService){
        this.increaseHService = increaseHService;
    }

    
    @GetMapping("/increaseH")
    public String increase(Model model) throws Exception{
        List<IncreaseH> IncreaseH= increaseHService.getIncreaseHList();
        model.addAttribute("IncreaseH", IncreaseH);
        return "/History/index";
    }


    
}
