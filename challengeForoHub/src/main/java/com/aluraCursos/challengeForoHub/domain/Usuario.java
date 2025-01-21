package com.aluraCursos.challengeForoHub.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity(name = "usuario")
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    public Usuario() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String login;
    private String clave ;


}
