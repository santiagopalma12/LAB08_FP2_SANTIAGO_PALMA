
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
    public static boolean verificar(Soldado[][] tablero, Soldado soldado) {
        return tablero[soldado.getFila()][soldado.getColumna()] != null;
    }
    public static void mostrar(Soldado[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("_________| ");
                } else {
                    System.out.print(tablero[i][j].getNombre() + " | ");
                }
            }
            System.out.println();
        }
    }

    public static void soldadoMayorVida(Map<String, Soldado> ejercito, String nombreEjercito) {
        if (ejercito.isEmpty()) {
            System.out.println("No hay soldados en " + nombreEjercito + ".");
            return;
        }

        Soldado soldadoMayor = Collections.max(ejercito.values(), Comparator.comparingInt(Soldado::getNivelVida));
        System.out.println("Soldado con mayor nivel de vida en " + nombreEjercito + ": " + soldadoMayor.getNombre() +
                " (Vida: " + soldadoMayor.getNivelVida() + ")");
    }

    public static void mostrarDatosEjercito(Map<String, Soldado> ejercito, String nombreEjercito, int vidaTotal) {
        System.out.println("Vida total de " + nombreEjercito + ": " + vidaTotal);
        System.out.println("Promedio de vida de " + nombreEjercito + ": " + vidaTotal / ejercito.size());
    }

}
