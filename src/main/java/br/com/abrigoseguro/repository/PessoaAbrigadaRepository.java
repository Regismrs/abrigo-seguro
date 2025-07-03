package br.com.abrigoseguro.repository;

import br.com.abrigoseguro.model.PessoaAbrigada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaAbrigadaRepository extends JpaRepository<PessoaAbrigada, Long> {
    @Query("SELECT DISTINCT p.cidadeOrigem FROM PessoaAbrigada p ORDER BY p.cidadeOrigem ASC")
    List<String> buscarCidadesOrigem();

    @Query("SELECT DISTINCT p.abrigoAtual FROM PessoaAbrigada p ORDER BY p.abrigoAtual ASC")
    List<String> buscarAbrigos();

    Page<PessoaAbrigada> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

}
