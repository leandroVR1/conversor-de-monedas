package com.aluracursos.conversor.principal;

import com.aluracursos.conversor.modelos.Monedas;
import com.aluracursos.conversor.servicios.ConsultaAPI;
import com.google.gson.Gson;

public class Principal {
    public static void main(String[] args) {
        // Instanciamos nuestro servicio de consulta
        ConsultaAPI consulta = new ConsultaAPI();

        try {
            // Prueba de Buscar las tasas de cambio teniendo como base el Dólar (USD)
            Monedas monedas = consulta.buscarMoneda("USD");

            // Imprimimos la base para confirmar
            System.out.println("Moneda base: " + monedas.base_code());

            // Accedemos al Map para ver cuánto vale 1 USD en otras monedas


            System.out.println("Tasa en ARS: " + monedas.conversion_rates().get("ARS"));
            System.out.println("Tasa en BRL: " + monedas.conversion_rates().get("BRL"));
            System.out.println("Tasa en COP: " + monedas.conversion_rates().get("COP"));

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}