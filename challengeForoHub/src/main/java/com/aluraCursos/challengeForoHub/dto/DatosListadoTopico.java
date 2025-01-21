package com.aluraCursos.challengeForoHub.dto;

import com.aluraCursos.challengeForoHub.Controller.Topico.Topico;

import java.time.format.DateTimeFormatter;

public record DatosListadoTopico(
     String titulo,
     String mensaje,
     String fechaDeCreacion,
     String status,
     String autor,
     String curso
) {

    public DatosListadoTopico(Topico  topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion().format(String.valueOf(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}