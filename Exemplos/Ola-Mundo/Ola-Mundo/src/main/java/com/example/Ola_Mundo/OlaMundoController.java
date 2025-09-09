package com.example.Ola_Mundo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaMundoController {
    @GetMapping("/")
    public String OlaMundo(@RequestParam String nome)
    {
        return "Olá Mundo - " + nome  + " !";
    }
}
