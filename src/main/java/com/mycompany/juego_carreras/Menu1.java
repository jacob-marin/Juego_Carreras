
package com.mycompany.juego_carreras;

import javax.swing.JOptionPane;

/**
 *
 * @author jacob
 */
public class Menu1 {
        private static final int MAX_JUGADORES = 4;
    private static String[] jugadores = new String[MAX_JUGADORES];
    private static int top = -1;

    public static void main(String[] args) {
        int option = 0;

        while (true) {
            String[] options = {"Agregar jugador", "Imprimir pila de jugadores", "Eliminar jugador", "Ayuda", "Salir"};
            option = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción",
                    "Menú",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (option) {
                case 0:
                    agregarJugador();
                    break;
                case 1:
                    imprimirJugadores();
                    break;
                case 2:
                    eliminarJugador();
                    break;
                case 3:
                    mostrarAyuda();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del juego...");
                    System.exit(0); // Salir del juego
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }
    }

    private static void agregarJugador() {
        if (top < MAX_JUGADORES - 1) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                jugadores[++top] = nombre;
                JOptionPane.showMessageDialog(null, "Jugador " + nombre + " agregado.");
            } else {
                JOptionPane.showMessageDialog(null, "Nombre no válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más de " + MAX_JUGADORES + " jugadores.");
        }
    }

    private static void imprimirJugadores() {
        if (top == -1) {
            JOptionPane.showMessageDialog(null, "No hay jugadores en la pila.");
        } else {
            StringBuilder sb = new StringBuilder("Pila de jugadores:\n");
            imprimirJugadoresRecursivo(sb, top);
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    private static void imprimirJugadoresRecursivo(StringBuilder sb, int index) {
        if (index < 0) {
            return;
        }
        sb.append(top - index + 1).append(". ").append(jugadores[index]).append("\n");
        imprimirJugadoresRecursivo(sb, index - 1);
    }

    private static void eliminarJugador() {
        if (top == -1) {
            JOptionPane.showMessageDialog(null, "No hay jugadores para eliminar.");
        } else {
            StringBuilder sb = new StringBuilder("Seleccione un jugador para eliminar:\n");
            for (int i = 0; i <= top; i++) {
                sb.append(i + 1).append(". ").append(jugadores[i]).append("\n");
            }
            String input = JOptionPane.showInputDialog(sb.toString());
            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index <= top) {
                    for (int i = index; i < top; i++) {
                        jugadores[i] = jugadores[i + 1];
                    }
                    jugadores[top--] = null;
                    JOptionPane.showMessageDialog(null, "Jugador eliminado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Índice no válido.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida.");
            }
        }
    }

    private static void mostrarAyuda() {
        String ayuda = "Opciones del menú:\n" +
                "1. Agregar jugador: Permite agregar un nuevo jugador a la pila (máximo de 4 jugadores).\n" +
                "2. Imprimir pila de jugadores: Muestra la lista de jugadores agregados.\n" +
                "3. Eliminar jugador: Permite eliminar un jugador seleccionado de la pila.\n" +
                "4. Ayuda: Muestra esta información.\n" +
                "5. Salir: Cierra el programa.";
        JOptionPane.showMessageDialog(null, ayuda);
    }
}

