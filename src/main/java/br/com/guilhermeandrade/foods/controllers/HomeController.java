package br.com.guilhermeandrade.foods.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foods")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
