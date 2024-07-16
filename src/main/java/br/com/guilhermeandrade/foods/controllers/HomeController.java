package br.com.guilhermeandrade.foods.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Retorna o nome da página ou o caminho para o template correspondente
        return "index"; // Exemplo: "index.html" se estiver usando Thymeleaf ou outro template engine
    }
}
