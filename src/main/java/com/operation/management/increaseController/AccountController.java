package com.operation.management.increaseController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {

    @RequestMapping("/account/list")
        String accountList(Model model){
        return "/account/list/index";
    }


    @RequestMapping("/account/detail")
        String indexPage(Model model){
        return "/account/detail/index";
    }

}
