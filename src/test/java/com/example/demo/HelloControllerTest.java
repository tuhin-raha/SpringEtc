package com.example.demo;

import com.example.demo.controller.HelloController;
import com.example.demo.entity.Employee;
import com.example.demo.service.DetailService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DetailService detailService;

    @Test
    void testTheBasicTestController() throws Exception {
        mockMvc.perform(get("/v1/api/test").param("id","100")).andExpect(status().isOk()).andExpect(content().string("100"));
    }

    @Test
    void testIncorrectPath() throws Exception {
        mockMvc.perform(get("/v1/api/testt").param("id","100")).andExpect(status().isNotFound());
    }

    @Test
    void testANegativeParam() throws Exception {
        mockMvc.perform(get("/v1/api/test").param("id","-100")).andExpect(status().isBadRequest());
    }

    @Test
    void testInvokingTheService() throws Exception {
        when(detailService.getDetailsById(Mockito.anyInt())).thenReturn(new Employee(100,"tuhin","TL"));
        mockMvc.perform(get("/v1/api/employees/131")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(100));
    }
}
