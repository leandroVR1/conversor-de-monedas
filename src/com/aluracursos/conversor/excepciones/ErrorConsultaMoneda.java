package com.aluracursos.conversor.excepciones;

// Clase para manejar errores específicos de nuestra consulta a la API
public class ErrorConsultaMoneda extends RuntimeException {
    private String mensaje;

    public ErrorConsultaMoneda(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return mensaje;
    }
}
