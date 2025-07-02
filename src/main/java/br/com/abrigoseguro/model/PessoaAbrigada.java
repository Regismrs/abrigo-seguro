package br.com.abrigoseguro.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PessoaAbrigada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cpf;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private String contato;
    private String contatoEmergencia;
    private String cidadeOrigem;
    private LocalDate dataNascimento;
    private String abrigoAtual;
    private LocalDate dataEntrada;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNomeMae() { return nomeMae; }
    public void setNomeMae(String nomeMae) { this.nomeMae = nomeMae; }

    public String getNomePai() { return nomePai; }
    public void setNomePai(String nomePai) { this.nomePai = nomePai; }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    public String getContatoEmergencia() { return contatoEmergencia; }
    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getCidadeOrigem() { return cidadeOrigem; }
    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getAbrigoAtual() { return abrigoAtual; }
    public void setAbrigoAtual(String abrigoAtual) { this.abrigoAtual = abrigoAtual; }

    public LocalDate getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }
}
