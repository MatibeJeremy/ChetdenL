package com.jeremyalloys.boot.lendint.interview_prep.Controllers.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jeremyalloys.boot.lendint.interview_prep.Models.Transaction;
import com.jeremyalloys.boot.lendint.interview_prep.Services.TransactionServices;
import java.util.List;
import java.util.Random;

@RestController
// The whole controller will start from this directory just for separation
// of concerns
@RequestMapping("/api/transactions")
public class TransactionApiController {
    private TransactionServices transactionServices;

    @Autowired
    public TransactionApiController(TransactionServices transactionServices){
        super();
        this.transactionServices = transactionServices;
    }

    // Here we get all transactions we have generated in the DB
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionServices.getAllTransactions();

    }

    // This is an algorithm to quickly generate dummy transactions just for proof
    // of concept. I was kind of in a hurry
    @RequestMapping(value="/generate", method=RequestMethod.GET)
    public List<Transaction> processForm() {

        for(int i=0; i<15; i++){

            try{
            Transaction trans_object = new Transaction();
            Random rnd = new Random();
            trans_object.setReceiver("John Doe");
            trans_object.setSender("Marl");
            if((i % 2) == 0){
                trans_object.setMedium("Bank");
            }else{
                trans_object.setMedium("Mobile");
            }

            trans_object.setAmount(rnd.nextInt(20000));

            transactionServices.save(trans_object);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return transactionServices.getAllTransactions();
    }
}

