package com.gabiev.T1Consulting.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mockMVC;

    @Test
    public void chars() throws Exception {
        mockMVC.perform(get("/chars/aabbbbbcddd"))
                .andDo(print())
                .andExpect(content().json("{ \"b\":5, \"d\":3, \"a\":2, \"c\":1 }"));
    }

}