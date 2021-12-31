package com.operation.management.IncreaseHistory;

import java.util.List;

import com.operation.management.domain.IncreaseHistory;
import com.operation.management.service.IncreaseHistoryService;
import com.operation.management.vo.IncreaseHistoryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IncreaseController {
    @Autowired
    private IncreaseHistoryService increaseHistoryService;



    @GetMapping("/")
    public String list(Model model){
        List<IncreaseHistoryVO> historyList = increaseHistoryService.getHistoryList();

        model.addAttribute("historyList", historyList);
        return "/history/HistoryList.html";
    }






    // @Autowired
    // private IncreaseHistoryService increaseHistoryService;

    // @RequestMapping(value="/findByGrpCd", method=RequestMethod.GET)
    // public List<IncreaseHistoryVO> select(@RequestParam String grpCd) {
    //     System.out.println("Woostone is back");
    //     return increaseHistoryService.findByGrpCd(grpCd);
    // }
    
    
}
