package com.alura.babySteps.controller.dto;

import com.alura.babySteps.modelo.StatusTopico;
import com.alura.babySteps.modelo.Topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesTopicoDto {
    private final String mensagem;
    private final LocalDateTime dataCriacao;
    private final String titulo;
    private final Long id;
    private final String nomeAutor;
    private final StatusTopico status;
    private final List<RespostaDto> resposta;

    public DetalhesTopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor().getNome();
        this.status = topico.getStatus();
        this.resposta = new ArrayList<>();
        this.resposta.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public List<RespostaDto> getResposta() {
        return resposta;
    }
}
