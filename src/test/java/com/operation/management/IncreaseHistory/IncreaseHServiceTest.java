package com.operation.management.IncreaseHistory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.operation.management.IncreaseHistory.IncreaseHController.CreateMemberRequest;
import com.operation.management.domain.IncreaseH;
import com.operation.management.domain.IncreaseHRepository;
import com.operation.management.dto.IncreaseHDto;
import com.operation.management.dto.IncreaseHListDto;
import com.operation.management.service.IncreaseHService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
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


     
            
        
    }
    




    @Test    
    public void A_insertTest() throws Exception{
        
            IncreaseHDto model = new IncreaseHDto();
            // model.setUid(123L);

            //given
            model.setGrp_cd("111111");
            model.setStatus("사용사용");
            model.setStart_date("20220106");
            model.setLimit_price("10001");
            model.setSms_price(10);
            model.setLms_price(15);
            model.setMms_price(20);
            model.setRmk("issacShin");
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            model.setCreate_dttm(date);

            //when
            IncreaseHDto result = increaseHService.insert(model);

            //than
            assertEquals("111111"  , result.getGrp_cd());
            assertEquals("사용사용" , result.getStatus());
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
        IncreaseHDto updatedInfo = increaseHService.update(model, 323);

        //then

        Assertions.assertThat(updatedInfo.getStatus().equals(model.getStatus()));
        


    }

   



    @Test
	public void B_listTest() throws Exception {
        
		IncreaseHListDto model = new IncreaseHListDto();
		// model.setPage(1);
		// model.setPageSize(10);
		// model.setGrp_cd("111111");
        // model.setStatus("사용사용");

        // model.getGrp_cd();
        // model.getStatus();
        // model.getStart_date();
        // model.getLimit_price();
        // model.getSms_price();
        // model.getLms_price();
        // model.getMms_price();
        // model.getRmk();
        // model.getCreate_dttm();
        // System.out.println("dataList입니다..======: " + model + "================끝=========");
        
        // IncreaseHListDto result = increaseHService.list(model);
        // System.out.println("aaaaaaaaaaaaaaaa==============: " + model.getGrp_cd());
		
		// assertEquals(6, result.getTotalCount());
		// assertEquals(6, result.getList().size());
       
		
		
		

        // IncreaseHListDto result2 = increaseHService.list(model);
		
		
		// assertEquals(0, result2.getTotalCount());
		// assertEquals(0, result2.getList().size());
		
		
		
		
		// IncreaseHListDto result3 = increaseHService.list(model);

        // model.setGrp_cd("444444");
        // model.setStatus("에이");
		
		// // assertEquals(1, result3.getTotalCount());
		// // assertEquals(1, result3.getList().size());
		// assertEquals("333333", result2.getList().get(0).getGrp_cd());
		// assertEquals("사용중입니다.", result2.getList().get(0).getStatus());
        // assertEquals("444444", result3.getList().get(0).getGrp_cd());
		// assertEquals("에이", result3.getList().get(0).getStatus());
		
	}

    @Test   
    public void findAll() throws Exception{
        
    }


    // @Test
    // public void C_viewTest() throws Exception{
    //     IncreaseHListDto model = new IncreaseHListDto();
    //     model.setGrp_cd("그룹코드코드C");

    //     IncreaseHListDto list = increaseHService.list(model);
    //     long uid = list.getList().get(0).getUid();

    //     IncreaseHDto view = increaseHService.view(uid);

    //     assertEquals(uid, view.getUid());
    //     assertEquals("그루비룸코드", view.getGrp_cd());
    //     assertEquals("스테이터스는 status", view.getStatus());


    // }


    @Test
    public void E_deleteTest() throws Exception{

        // increaseHRepository.deleteById(322L);

         increaseHService.delete(309L);

       



    }

    




    
}
