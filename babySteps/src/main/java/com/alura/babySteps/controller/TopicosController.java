package com.alura.babySteps.controller;

import com.alura.babySteps.controller.dto.TopicoDto;
import com.alura.babySteps.controller.form.TopicoForm;
import com.alura.babySteps.modelo.Topico;
import com.alura.babySteps.repository.CursoRepository;
import com.alura.babySteps.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public void cadastrar(@RequestBody TopicoForm form) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);
    }

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso) {
        if (nomeCurso == null) {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDto.converter(topicos);
        }
    }
}
