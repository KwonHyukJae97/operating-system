package com.operation.management.IncreaseHistory;


import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.operation.management.domain.IncreaseH;
import com.operation.management.domain.IncreaseHRepository;
import com.operation.management.dto.IncreaseHDto;
import com.operation.management.dto.IncreaseHListDto;
import com.operation.management.service.IncreaseHService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import oracle.net.aso.j;

@RestController
@RequestMapping("/increaseH")
public class IncreaseHController {

    @Autowired
    private IncreaseHService increaseHService;

    



    // @GetMapping("/")
    // public String list(Model model){
    //     List<IncreaseH> hList = increaseHRepository.findAll();
    //     model.addAttribute("hList", hList);
    //     return "/History/index.html";
    // }

    @RequestMapping("/IncreaseListVw")
    public String list(Model model){
        
        return "/list.html";
    }


    @GetMapping("/IncreaseHListDo")
    public String list(final IncreaseHListDto model) throws Exception{

        List<IncreaseH> allUsers = increaseHService.getALLUsers();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("IncreseHList", allUsers);
        
        ObjectMapper mapper = new ObjectMapper();

        

        // return entity;
        return mapper.writeValueAsString(jsonObject);
    }

    public IncreaseHController() {
    }


    @GetMapping("/{uid}")
    public ResponseEntity<?> view(@PathVariable("uid") final long uid){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<IncreaseHDto>(increaseHService.view(uid), HttpStatus.OK);
        }catch (NotFoundException e){
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return entity;
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody final IncreaseHDto model){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<IncreaseHDto>(increaseHService.insert(model), HttpStatus.CREATED);
        }catch (Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }

    @PutMapping("/{uid}")
    public ResponseEntity<?> update(@PathVariable("uid") final long uid, @RequestBody final IncreaseHDto model){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<IncreaseHDto>(increaseHService.update(model, uid), HttpStatus.OK);
        }catch (Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<?> delete(@PathVariable("uid") final long uid){
        ResponseEntity<?> entity = null;

        try{
            increaseHService.delete(uid);
            entity = new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException e){
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }



    // public IncreaseHController(IncreaseHService increaseHService){
    //     this.increaseHService = increaseHService;
    // }

    
    // @GetMapping("/increaseH")
    // public String increase(Model model) throws Exception{
    //     List<IncreaseH> IncreaseH= increaseHService.getIncreaseHList();
    //     model.addAttribute("IncreaseH", IncreaseH);
    //     return "/History/index";
    // }


    
}
