package com.operation.management.secondController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {
    
    @GetMapping(value = "/routing")
    public String routing() {
        return "/routing/routing";
    }
}
