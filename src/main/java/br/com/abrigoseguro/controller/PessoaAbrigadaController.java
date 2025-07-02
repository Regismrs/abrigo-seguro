package br.com.abrigoseguro.controller;

import br.com.abrigoseguro.model.PessoaAbrigada;
import br.com.abrigoseguro.repository.PessoaAbrigadaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/abrigados")
public class PessoaAbrigadaController {
    private final PessoaAbrigadaRepository repository;

    public PessoaAbrigadaController(PessoaAbrigadaRepository pessoaAbrigadaRepository) {
        this.repository = pessoaAbrigadaRepository;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String nome,
                         @RequestParam(defaultValue = "0") int page,
                         Model model) {

        Page<PessoaAbrigada> pagina;

        if (nome != null && !nome.isBlank()) {
            pagina = repository.findByNomeContainingIgnoreCase(
                    nome,
                    PageRequest.of(page, 10, Sort.by("nome")));

            model.addAttribute("nome", nome);
        } else {
            pagina = repository.findAll(
                    PageRequest.of(page, 10, Sort.by("nome").ascending()));
        }

        model.addAttribute("pagina", pagina);
        return "pessoas/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("pessoa", new PessoaAbrigada());
        model.addAttribute("cidades", repository.buscarCidadesOrigem());
        model.addAttribute("abrigos", repository.buscarAbrigos());
        return "pessoas/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("pessoa") PessoaAbrigada pessoa, Model model) {
        try {
            repository.saveAndFlush(pessoa);
            model.addAttribute("sucesso", "Pessoa cadastrada com sucesso!");
        } catch (DataIntegrityViolationException e) {
            System.out.println(">>> Erro inesperado: " + e.getClass().getName());
            model.addAttribute("pessoa", pessoa);
            model.addAttribute("cidades", repository.buscarCidadesOrigem());
            model.addAttribute("abrigos", repository.buscarAbrigos());
            model.addAttribute("erro", "CPF já cadastrado.");
            return "pessoas/form";
        }
        return "redirect:/abrigados";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            repository.deleteById(id);
            redirectAttributes.addFlashAttribute("sucesso", "Pessoa excluída com sucesso.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao excluir pessoa.");
        }

        return "redirect:/abrigados";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<PessoaAbrigada> pessoalOptional = repository.findById(id);
        if (pessoalOptional.isPresent()) {
            model.addAttribute("pessoa", pessoalOptional.get());
            model.addAttribute("cidades", repository.buscarCidadesOrigem());
            model.addAttribute("abrigos", repository.buscarAbrigos());
            return "pessoas/form";
        } else {
            redirectAttributes.addFlashAttribute("erro", "Pessoa não encontrada.");
            return "redirect:/abrigados";
        }
    }

}
