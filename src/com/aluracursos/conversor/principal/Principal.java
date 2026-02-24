package com.aluracursos.conversor.principal;

import com.google.gson.Gson;

public class Principal {
    public static void main(String[] args) {
        // Creamos un objeto Gson
        Gson gson = new Gson();

        // Si esta línea no sale en rojo, ¡tu entorno está perfecto!
        System.out.println("Gson configurado correctamente.");
    }
}