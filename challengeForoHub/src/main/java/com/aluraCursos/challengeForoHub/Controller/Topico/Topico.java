package com.aluraCursos.challengeForoHub.Controller.Topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;



@Entity
@Table(name = "Topicos")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Topico {

public Topico() {

}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;

    @CreationTimestamp
    @Column(name = "fecha_de_creacion", updatable = false)
    private String fechaDeCreacion;

    private String status;
    private String autor;
    private String curso;


    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.status = datosRegistroTopico.status();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
    }
    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public String getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    // Métodos setter manuales
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
