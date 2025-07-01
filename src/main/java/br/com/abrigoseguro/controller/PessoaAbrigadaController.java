package br.com.abrigoseguro.controller;

import br.com.abrigoseguro.model.PessoaAbrigada;
import br.com.abrigoseguro.repository.PessoaAbrigadaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/abrigados")
public class PessoaAbrigadaController {
    private final PessoaAbrigadaRepository repository;

    public PessoaAbrigadaController(PessoaAbrigadaRepository pessoaAbrigadaRepository) {
        this.repository = pessoaAbrigadaRepository;
    }
    @GetMapping
    public String listar(Model model) {
        List<PessoaAbrigada> pessoas = repository.findAll();
        model.addAttribute("pessoas", pessoas);
        return "pessoas/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("pessoa", new PessoaAbrigada());
        return "pessoas/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute PessoaAbrigada pessoa) {
        repository.save(pessoa);
        return "redirect:/abrigados";
    }
}
