package br.com.abrigoseguro.repository;

import br.com.abrigoseguro.model.PessoaAbrigada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaAbrigadaRepository extends JpaRepository<PessoaAbrigada, Long> {

    @Query("SELECT DISTINCT p.cidadeOrigem FROM PessoaAbrigada p ORDER BY p.cidadeOrigem ASC")
    List<String> buscarCidadesOrigem();

}
