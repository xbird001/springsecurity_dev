package com.xbird.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenCreateSuccess() throws Exception {
        Date date = new Date();
        logger.info(String.valueOf(date.getTime()));
        String content = "{\"name\":\"tome\",\"password\":\"123456\",\"birthday\":" + date.getTime() + "}";
        String rs = mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(content))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                    .andReturn().getResponse().getContentAsString();
        logger.info(rs);
    }

    @Test
    public void whenUpdateSuccess()throws Exception  {
        Date date = new Date();
        String content = "{\"id\":\"1\",\"name\":\"jone\",\"password\":\"654321\",\"birthday\":" + date.getTime() + "}";
        String rs = mockMvc.perform(MockMvcRequestBuilders.post("/user/update").content(content))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn().getResponse().getContentAsString();
        logger.info(rs);
    }
}