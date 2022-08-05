package com.alura.babySteps.controller.dto;

import com.alura.babySteps.modelo.Resposta;

import java.time.LocalDateTime;

public class RespostaDto {

    private final Long id;
    private final String menssagem;
    private final LocalDateTime dataCriacao;
    private final String nomeAutor;

    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.menssagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
