package com.aluracursos.conversor.modelos;

import java.util.Map;

// Record para mapear la respuesta JSON de ExchangeRate-API
public record Monedas(
        // Código base de la moneda consultada (ej: USD)
        String base_code,

        // Mapa de tasas: Llave = código moneda, Valor = tasa de cambio
        Map<String, Double> conversion_rates
) {
}