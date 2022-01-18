package com.operation.management.IncreaseHistory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.operation.management.thresHoldDto.ThresHoldDto;
import com.operation.management.thresHoldService.ThresHoldService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@SpringBootTest
public class ThresHoldTest {

    @Autowired
    private ThresHoldService thresHoldService;


    @Test
    public void insertTest() throws Exception{

        ThresHoldDto model = new ThresHoldDto();

        model.setGrp_cd("9");
        model.setGrp_nm("9");
        model.setStart_date("9");
        model.setUsed_yn("9");
        model.setLimit_price("3");
        model.setSms_price(3);
        model.setLms_price(3);
        model.setMms_price(3);
        model.setAlarm_group("3");
        model.setReset_yn("3");
        model.setReset_day("3");
        model.setReset_price("3");
        model.setReset_dttm("3");

        ThresHoldDto result = thresHoldService.insert(model);

        assertEquals("9", result.getGrp_cd());
        assertEquals("9", result.getGrp_nm());


        model.setGrp_cd("8");
        model.setGrp_nm("8");
        model.setStart_date("8");
        model.setUsed_yn("4");
        model.setLimit_price("4");
        model.setSms_price(4);
        model.setLms_price(4);
        model.setMms_price(4);
        model.setAlarm_group("4");
        model.setReset_yn("4");
        model.setReset_day("4");
        model.setReset_price("4");
        model.setReset_dttm("4");

        ThresHoldDto result2 = thresHoldService.insert(model);

        assertEquals("8", result2.getGrp_cd());
        assertEquals("8", result2.getGrp_nm());



    }
    
}
