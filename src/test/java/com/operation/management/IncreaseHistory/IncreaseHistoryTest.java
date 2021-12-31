package com.operation.management.IncreaseHistory;

import com.operation.management.service.IncreaseHistoryService;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith({SpringExtension.class})
@WebAppConfiguration
public class IncreaseHistoryTest {


    
    @MockBean private @Autowired IncreaseHistoryRepository increaseHistoryRepository;


    @MockBean private @Autowired IncreaseHistoryService increaseHistoryService;

    @MockBean
    private IncreaseController increaseController;



    private @Autowired MockMvc mockMvc;



    // @Test
    // void findAllTest(){
    //     IncreaseHistory increaseHistory = increaseHistoryService.getSelect(uid);
    //     // List<IncreaseHistory> increaseHistory = increaseHistoryService.getSelect();
    //     Assertions.assertThat(increaseHistory.getGrpCd().equals("B000000"));
    // }

    @Test
    @WithMockUser
    void voidTest() throws Exception{

        // mockMvc.perform(MockMvcRequestBuilders.
        //     get("/select")
        //         .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON))
        //         .andDo(print())
        //         .andExpect(status().isOk());
        JSONObject jsonData = new JSONObject() ;

        jsonData.put("kwonHyukJae", "123123");



        MockHttpServletRequestBuilder builder = 
                MockMvcRequestBuilders.get("/findByGrpCd")
                                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .characterEncoding("UTF-8")
                                    .with(csrf())
                                    .content(jsonData.toString());

        this.mockMvc.perform(builder)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("Content: "+ jsonData.toString()))
                    .andDo(MockMvcResultHandlers.print());

    }
    
}
