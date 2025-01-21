package com.aluraCursos.challengeForoHub.Controller.Topico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosRegistroTopico(
        @NotNull @Size(min = 5, max = 100) String titulo,
        @NotNull @Size(min = 10) String mensaje,
        @NotNull String status,
        @NotNull String autor,
        @NotNull String curso) {


}
