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
import com.jeremyalloys.boot.lendint.interview_prep.Controllers.TransactionController;
import com.jeremyalloys.boot.lendint.interview_prep.Models.Transaction;
import com.jeremyalloys.boot.lendint.interview_prep.Services.TransactionServices;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    TransactionServices transactionServices;
    
    Transaction RECORD_1 = new Transaction(1,"sender","Interview",40000,"Bank");
    Transaction RECORD_2 = new Transaction(2, "test1@gmail.com", "Job", 400, "Mobile");
    Transaction RECORD_3 = new Transaction(3, "test2@gmail.com", "Kazi", 33333, "Bank");
    
    

    @Test
    public void getAllTransactionsListing_success() throws Exception {
    List<Transaction> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
    
    Mockito.when(transactionServices.getAllTransactions()).thenReturn(records);
    
    mockMvc.perform(MockMvcRequestBuilders
            .get("/transactions")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
