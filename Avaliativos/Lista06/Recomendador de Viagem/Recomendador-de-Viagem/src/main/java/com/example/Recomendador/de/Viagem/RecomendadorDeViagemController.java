package com.example.Recomendador.de.Viagem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecomendadorDeViagemController {

    @GetMapping("/recomendar")
    public String recomendar(@RequestParam String clima, @RequestParam String estilo) {
        if (clima.equalsIgnoreCase("calor") && estilo.equalsIgnoreCase("natureza")) {
            return "Rio de Janeiro";
        } else if (clima.equalsIgnoreCase("frio") && estilo.equalsIgnoreCase("aventura")) {
            return "Gramado";
        } else if (clima.equalsIgnoreCase("calor") && estilo.equalsIgnoreCase("cultura")) {
            return "Salvador";
        } else if (clima.equalsIgnoreCase("frio") && estilo.equalsIgnoreCase("relaxar")) {
            return "Campos do Jordão";
        } else {
            return "Desculpe, não temos uma recomendação para essa combinação.";
        }
    }
}
