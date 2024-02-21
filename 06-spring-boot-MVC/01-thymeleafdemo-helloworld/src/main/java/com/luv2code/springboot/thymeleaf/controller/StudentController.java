package com.luv2code.springboot.thymeleaf.controller;

import com.luv2code.springboot.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model model){

        // create a student object
        Student student = new Student();

        // add student object to the model
        model.addAttribute("student", student);

        // add the list of countries to the model
        model.addAttribute("countries", countries);

        // add the list of favorite language to the model
        model.addAttribute("languages", languages);

        // add the list of favorite system to the model
        model.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }
}
