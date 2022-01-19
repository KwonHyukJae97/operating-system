package com.operation.management.secondController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmsLmsLimitController {

    @GetMapping(value = "/smsLimit")
    public String smsLimit() {
        return "/smsLmsLimit/smsLimit";
    }


    @GetMapping(value = "/lmsLimit")
    public String lmsLimit() {
        return "/smsLmsLimit/lmsLimit";
    }
    
}
