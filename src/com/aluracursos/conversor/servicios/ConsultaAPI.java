package com.aluracursos.conversor.servicios;

import com.aluracursos.conversor.excepciones.ErrorConsultaMoneda;
import com.aluracursos.conversor.modelos.Monedas;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    public Monedas buscarMoneda(String codigoMoneda){
        // Dirección dinámica con tu API Key y la moneda que pida el usuario
        String apiKey = "07051b0b6034f51d3736bcb8";
        URI dirreccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey +"/latest/" + codigoMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(dirreccion).build();

        try {
            // Realiza la petición y obtiene la respuesta como texto (JSON)
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Convierte el texto JSON a nuestro molde de Monedas
            return  new Gson().fromJson(response.body(),Monedas.class);
        }catch (Exception e){
            // Si algo falla, lanza nuestra propia excepción
            throw new ErrorConsultaMoneda("No se pudo obtener la moneda consultada: " + codigoMoneda);
        }
    }
}
