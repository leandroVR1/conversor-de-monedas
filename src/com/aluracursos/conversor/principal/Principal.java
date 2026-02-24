package com.aluracursos.conversor.principal;

import com.aluracursos.conversor.modelos.Monedas;
import com.aluracursos.conversor.servicios.ConsultaAPI;
import com.aluracursos.conversor.servicios.GeneradorDeConversiones;
import com.google.gson.Gson;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        // Instanciamos nuestro servicio de consulta
        ConsultaAPI consulta = new ConsultaAPI();
        GeneradorDeConversiones generador = new GeneradorDeConversiones();
        int opcion = 0;

        String menu = """
                ***************************************************
                Sea bienvenido/a al Conversor de Moneda =)
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida:
                ***************************************************
                """;
        // El bucle se repite mientras la opción no sea 7
        while (opcion != 7){
            System.out.println(menu);


            try {
                // Aquí definiremos qué moneda pedir a la API según la opción
                opcion = Integer.parseInt(lectura.nextLine()); //Leemos como String y convertimos para evitar errores de Scanner

                if (opcion == 7) break;// Si elige 7, sale del bucle

                System.out.println("Ingrese el valor que desea convertir:");
                double cantidad = Double.parseDouble(lectura.nextLine());
                // Lógica de navegación del menú
                switch (opcion) {
                    case 1 -> {
                        Monedas monedas = consulta.buscarMoneda("USD");
                        generador.mostrarConversion(monedas, "ARS", cantidad);
                    }
                    case 2 -> {
                        Monedas monedas = consulta.buscarMoneda("ARS");
                        generador.mostrarConversion(monedas, "USD", cantidad);
                    }
                    case 3 -> {
                        Monedas monedas = consulta.buscarMoneda("USD");
                        generador.mostrarConversion(monedas, "BRL", cantidad);
                    }
                    case 4 -> {
                        Monedas monedas = consulta.buscarMoneda("BRL");
                        generador.mostrarConversion(monedas, "USD", cantidad);
                    }
                    case 5 -> {
                        Monedas monedas = consulta.buscarMoneda("USD");
                        generador.mostrarConversion(monedas, "COP", cantidad);
                    }
                    case 6 -> {
                        Monedas monedas = consulta.buscarMoneda("COP");
                        generador.mostrarConversion(monedas, "USD", cantidad);
                    }
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e){
                System.out.println("Error: Ingrese solo números");
            } catch (Exception e){
                System.out.println("Ocurrió un errpr: " + e.getMessage());
            }
        }
        System.out.println("Programa finalizado. ¡Gracias por usar el conversor!");
    }

}