package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class AboutUsControllerr {



    public AboutUsControllerr(){
    }
    @GetMapping("/aboutus")
    public String listPartsandProducts(Model theModel){
        return "aboutus";
    }
}