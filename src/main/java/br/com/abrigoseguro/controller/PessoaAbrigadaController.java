package br.com.abrigoseguro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abrigados")
public class PessoaAbrigadaController {

    @GetMapping
    public String listar() {
        return "Todas as pessoas...";
    }

    @GetMapping("/novo")
    public String salvar() {
        return "Gravar pessoa...";
    }
}
