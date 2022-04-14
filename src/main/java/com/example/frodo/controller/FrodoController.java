package com.example.frodo.controller;

import java.io.InputStream;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FrodoController {
    
    @GetMapping("/frodo")
    public String frodo(Model model) throws Exception {
        //Runtime.getRuntime().exec("hostname");
        Process process = Runtime.getRuntime().exec("uname -n");
         InputStream in = process.getInputStream(); 
         Scanner s = new Scanner(in,"EUC-KR");
         StringBuffer buffer = new StringBuffer();
         buffer.append(":<");
         while(s.hasNextLine() == true) {
             buffer.append(s.nextLine()+">");
         }
         model.addAttribute("frodo", buffer.toString());
         return "frodo";
    }
}