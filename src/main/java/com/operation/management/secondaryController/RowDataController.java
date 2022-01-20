package com.operation.management.secondaryController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RowDataController {
    
    @GetMapping(value = "/smsRowData")
    public String smsRowData() {
        return "/rowData/smsRowData";
    }


    @GetMapping(value = "/mmsRowData")
    public String mmsRowData() {
        return "/rowData/mmsRowData";
    }
}
