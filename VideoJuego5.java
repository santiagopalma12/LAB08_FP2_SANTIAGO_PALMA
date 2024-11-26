

package sas;

import java.util.*;

public class VideoJuego5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            Soldado[][] tablero = new Soldado[10][10]; 
            Map<String, Soldado> ejercito1 = new HashMap<>();
            Map<String, Soldado> ejercito2 = new HashMap<>();

            int numeroSoldados = (int) (Math.random() * 10) + 1; 

            for (int i = 0; i < numeroSoldados; i++) {
                Soldado soldado;
                int vida = (int) (Math.random() * 5) + 1;
                int fila = (int) (Math.random() * 10);
                int columna = (int) (Math.random() * 10);
                String ejercito = (i % 2 == 0) ? "Ejército 1" : "Ejército 2";

                soldado = new Soldado("Soldado" + i, vida, fila, columna, ejercito);
                if (ejercito.equals("Ejército 1")) {
                    ejercito1.put(soldado.getNombre(), soldado);
                } else {
                    ejercito2.put(soldado.getNombre(), soldado);
                }
            }

            System.out.println("Soldados generados:");

            System.out.println("¿Desea seguir jugando? Ingrese 'si' para continuar o cualquier otra tecla para salir.");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("si"));

    }
}