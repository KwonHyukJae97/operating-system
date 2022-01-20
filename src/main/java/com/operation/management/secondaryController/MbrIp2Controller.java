package com.operation.management.secondaryController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MbrIp2Controller {

    @GetMapping(value = "/mbrIp2")
    public String mbrIp2(){
        return "/mbrIp2/mbrIp2";
    }
    
}
