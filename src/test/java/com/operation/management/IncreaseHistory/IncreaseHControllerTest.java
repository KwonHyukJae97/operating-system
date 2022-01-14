package com.operation.management.IncreaseHistory;

import com.operation.management.increaseService.IncreaseHService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class IncreaseHControllerTest {



    private @Autowired IncreaseHService increaseHService;

    @Autowired  MockMvc mockMvc;

    @Test
    void testDelete() {

    }

    @Test
    void testInsert() {

    }

    @Test
    @DisplayName("/IncreaseHListDo")
    void testList() throws Exception {

        String url ="/increaseH/IncreaseHListDo";

        MvcResult returnValue = mockMvc.perform(MockMvcRequestBuilders.get(url))        
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        
        log.info("returnValue = "+ returnValue );
    }

    @Test
    void testList2() {

    }

    @Test
    void testUpdate() {

    }

    @Test
    void testView() {

    }
}
