package com.aluracursos.conversor.servicios;

import com.aluracursos.conversor.modelos.Monedas;

public class GeneradorDeConversiones {

    //Método el cual solo se encarga de la lógica matemática y mostrar el resultado

    public  void  mostrarConversion(Monedas monedas , String destino , double cantidad){
        // Sacamos la tasa del Map usando la llave
        double tasa = monedas.conversion_rates().get(destino);

        double resultado = cantidad * tasa;

        // Mostramos el resultado final formateado
        System.out.println("***************************************************");
        System.out.println("El valor " + cantidad + " [" + monedas.base_code() + "]");
        System.out.println("corresponde al valor final de =>>> " + resultado + " [" + destino + "]");
        System.out.println("***************************************************\n");

    }
}
