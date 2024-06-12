
package com.mycompany.juego_carreras;

import javax.swing.JOptionPane;

/**
 *
 * @author jacob
 */
public class Menu {
    private static PilaJugadores pilaJugadores = new PilaJugadores();

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
                    subMenuEliminar();
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
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            if (pilaJugadores.agregarJugador(nombre)) {
                JOptionPane.showMessageDialog(null, "Jugador " + nombre + " agregado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pueden agregar más de 4 jugadores.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nombre no válido.");
        }
    }

    private static void imprimirJugadores() {
        JOptionPane.showMessageDialog(null, pilaJugadores.imprimirJugadores());
    }

    private static void subMenuEliminar() {
        String[] subOptions = {"Eliminar un jugador", "Salir del juego"};
        int subOption = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción",
                "Submenú Eliminar",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                subOptions,
                subOptions[0]
        );

        switch (subOption) {
            case 0:
                eliminarJugador();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Jugador seleccionado para salir del juego.");
                // Aquí puedes implementar la lógica para seleccionar un jugador que sale del juego sin cerrar el programa
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
                break;
        }
    }

    private static void eliminarJugador() {
        if (pilaJugadores.obtenerTop() == -1) {
            JOptionPane.showMessageDialog(null, "No hay jugadores para eliminar.");
        } else {
            String[] jugadores = pilaJugadores.obtenerListaJugadores();
            StringBuilder sb = new StringBuilder("Seleccione un jugador para eliminar:\n");
            for (int i = 0; i < jugadores.length; i++) {
                sb.append(i + 1).append(". ").append(jugadores[i]).append("\n");
            }
            String input = JOptionPane.showInputDialog(sb.toString());
            try {
                int index = Integer.parseInt(input) - 1;
                if (pilaJugadores.eliminarJugador(index)) {
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

