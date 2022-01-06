package com.operation.management.IncreaseHistory;


import com.operation.management.dto.IncreaseHDto;
import com.operation.management.dto.IncreaseHListDto;
import com.operation.management.service.IncreaseHService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/increaseH")
public class IncreaseHController {

    @Autowired
    private IncreaseHService increaseHService;

    @GetMapping
    public ResponseEntity<?> list(final IncreaseHListDto model){

        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<IncreaseHListDto>(increaseHService.list(model),HttpStatus.OK);
        }catch(Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
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
