package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HospitalController {
    @GetMapping("/receiptform")
    public String getreceipt(){

        return "PatientReceipt";

    }
    @GetMapping("searchprescription")
    public String SearchPrescription(){
        return "searchPress";
    }

    @GetMapping("/otp")
    public String otp(){
        return "otp";
    }

}
