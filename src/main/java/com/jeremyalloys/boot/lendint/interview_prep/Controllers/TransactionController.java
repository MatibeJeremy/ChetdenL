package com.jeremyalloys.boot.lendint.interview_prep.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeremyalloys.boot.lendint.interview_prep.Services.TransactionServices;

@Controller
// Whole controller starts from this url
@RequestMapping("/transactions")
public class TransactionController {
    private TransactionServices transactionServices;

    @Autowired
    public TransactionController(TransactionServices transactionServices){
        super();
        this.transactionServices = transactionServices;
    }

    // This will fetch for us all the transactions and show
    // in the frontend view
    @GetMapping
    public String getAllTransactions(Model model){

        //This is how we send values to the templates
        model.addAttribute("transactions", this.transactionServices.getAllTransactions());
        return "transactions";
    }
}
