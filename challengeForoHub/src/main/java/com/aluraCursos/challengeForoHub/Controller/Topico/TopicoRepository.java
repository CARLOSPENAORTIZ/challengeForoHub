package com.aluraCursos.challengeForoHub.Controller.Topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
