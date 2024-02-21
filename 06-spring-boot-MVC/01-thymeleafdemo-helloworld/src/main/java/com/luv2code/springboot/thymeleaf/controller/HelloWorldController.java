package com.luv2code.springboot.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // need a controller method to read form data and
    // add data to model
    @RequestMapping("/processFormVersionTwo")
    public String letsShowDude(HttpServletRequest request, Model model){

        // read the request parameter form HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }


    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey My Friend v3 " + theName;

        // add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }
}
