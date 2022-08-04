package com.alura.babySteps.controller;

import com.alura.babySteps.controller.dto.TopicoDto;
import com.alura.babySteps.modelo.Curso;
import com.alura.babySteps.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDto> lista() {
        Topico topico = new Topico("Dúvida", "Duvida conteudo", new Curso("Sring", "Programação"));

        return TopicoDto.converter(Arrays.asList(topico, topico, topico));
    }
}
