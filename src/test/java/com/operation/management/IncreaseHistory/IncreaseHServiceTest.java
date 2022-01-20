package com.operation.management.IncreaseHistory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.operation.management.primary.model.IncreaseH;
import com.operation.management.primary.repository.IncreaseHRepository;
import com.operation.management.primaryController.IncreaseHController.CreateMemberRequest;
import com.operation.management.primaryDto.IncreaseHDto;
import com.operation.management.primaryService.IncreaseHService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@SpringBootTest
public class IncreaseHServiceTest {

    @Autowired
    private IncreaseHService increaseHService;

    @Autowired
    private IncreaseHRepository increaseHRepository;

    @Test
    public void read(){
        Optional<IncreaseH> increaseH = increaseHRepository.findById(311L);

        increaseH.ifPresent(selectUser ->{
            System.out.println("=========aaaaaaaaaaaa======="+selectUser.getGrp_cd());
            System.out.println(selectUser.getRmk());
        });
    }


    @Test
    void findAllTest() {
        System.out.println("---------------findAll---------------");
        List<IncreaseH> users = increaseHService.getALLUsers();
        // Assertions.assertThat(users.size()).isEqualTo(11);

        
            int size = users.size();
            System.out.println(users.size()+"WooStone");
            
            System.out.println("userChecke " + users);
            System.out.println("size" + size);


     
            
        
    }
    




    @Test    
    public void A_insertTest() throws Exception{
        
            IncreaseHDto model = new IncreaseHDto();
            // model.setUid(123L);

            //given
            model.setGrp_cd("111111");
            model.setStatus("이재혁");
            model.setStart_date("20220106");
            model.setLimit_price("10001");
            model.setSms_price(10);
            model.setLms_price(15);
            model.setMms_price(20);
            model.setRmk("issacShin");
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            Date now = dateFormat.parse(dateFormat.format(date));
            
            model.setCreate_dttm(now);

            //when
            IncreaseHDto result = increaseHService.insert(model);

            //than
            assertEquals("111111"  , result.getGrp_cd());
            assertEquals("이재혁" , result.getStatus());
            // assertNotNull(result.getCreate_dttm());
        

        
            // IncreaseHDto model = new IncreaseHDto();
            // model.setUid(999L);
            model.setGrp_cd("000000");
            model.setStatus("미사용미사용");
            model.setStart_date("20211231");
            model.setLimit_price("10000");
            model.setSms_price(11);
            model.setLms_price(16);
            model.setMms_price(21);
            model.setRmk("이삭신");

            IncreaseHDto result2 = increaseHService.insert(model);

            assertEquals("000000", result2.getGrp_cd());
            assertEquals("미사용미사용", result2.getStatus());

            System.out.println("aaaaaaaa=====bbbbbbbb: " + result.getGrp_cd() + result2.getGrp_cd());
            // assertNotNull(result.getCreate_dttm());
        
    }
    @Test 
    void C_updateTest() throws Exception{

        //given
        CreateMemberRequest model = new CreateMemberRequest();
        model.setStatus("arreokwon");
        model.setLimit_price("arreokwon");
        model.setSms_price(90);
        model.setLms_price(80);
        model.setMms_price(70);
        
        //when
        IncreaseHDto updatedInfo = increaseHService.update(model, 331);

        //then

        Assertions.assertThat(updatedInfo.getStatus().equals(model.getStatus()));
        


    }

   



    

    @Test   
    public void findAll() throws Exception{
        
    }


   

    @Test
    public void E_deleteTest() throws Exception{

        // increaseHRepository.deleteById(322L);

         increaseHService.delete(309L);

       



    }

    




    
}
