package br.com.abrigoseguro.repository;

import br.com.abrigoseguro.model.PessoaAbrigada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaAbrigadaRepository extends JpaRepository<PessoaAbrigada, Long> {
}
