package com.jeremyalloys.boot.lendint.interview_prep.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeremyalloys.boot.lendint.interview_prep.Controllers.UserController;
import com.jeremyalloys.boot.lendint.interview_prep.Models.User;
import com.jeremyalloys.boot.lendint.interview_prep.Services.UserServices;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    UserServices userServices;
    
    User RECORD_1 = new User(1,"test@gmail.com","Jeremy");
    User RECORD_2 = new User(1,"test2@gmail.com","Interview");
    User RECORD_3 = new User(1,"test3@gmail.com","Job");
    

    
}
