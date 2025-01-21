package com.aluraCursos.challengeForoHub.Controller;


import com.aluraCursos.challengeForoHub.Controller.Topico.DatosRegistroTopico;
import com.aluraCursos.challengeForoHub.Controller.Topico.Topico;
import com.aluraCursos.challengeForoHub.Controller.Topico.TopicoRepository;
import com.aluraCursos.challengeForoHub.dto.DatosListadoTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicController {


    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<Topico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        Topico topico = new Topico(datosRegistroTopico);
        topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(topico);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return ResponseEntity.ok(topicos);
    }

    // Endpoint para obtener los detalles de un tópico por su ID
    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopico> obtenerDetalleTopico(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        // Si el tópico no se encuentra, devolvemos un 404
        if (optionalTopico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Si el tópico existe, devolvemos los detalles en formato JSON
        Topico topico = optionalTopico.get();
        DatosListadoTopico datosListadoTopico = new DatosListadoTopico(topico);
        return ResponseEntity.ok(datosListadoTopico);
    }

    // Endpoint para actualizar un tópico por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody DatosRegistroTopico datosRegistroTopico) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        // Si el tópico no existe, devolvemos un 404
        if (optionalTopico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Si el tópico existe, lo actualizamos
        Topico topico = optionalTopico.get();
        topico.setTitulo(datosRegistroTopico.titulo());
        topico.setMensaje(datosRegistroTopico.mensaje());
        topico.setStatus(datosRegistroTopico.status());
        topico.setAutor(datosRegistroTopico.autor());
        topico.setCurso(datosRegistroTopico.curso());

        // Guardamos el tópico actualizado
        topicoRepository.save(topico);

        // Devolvemos la respuesta con el tópico actualizado
        return ResponseEntity.ok(topico);
    }

    // Otros métodos para registrar, listar y actualizar tópicos...

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        // Verificar si el tópico existe
        if (optionalTopico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Si no se encuentra, retornamos 404
        }

        // Si el tópico existe, lo eliminamos
        topicoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // Respuesta 204 si la eliminación es exitosa
    }
}
