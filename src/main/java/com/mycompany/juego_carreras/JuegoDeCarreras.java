
package com.mycompany.juego_carreras;

import javax.swing.JOptionPane;

/**
 *
 * @author jacob
 */
public class JuegoDeCarreras {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();
        String[] opcionesMenu = {"Agregar jugador", "Listar jugadores", "Ayuda", "Jugar", "Salir"};
        boolean salir = false;

        while (!salir) {
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesMenu, opcionesMenu[0]);

            switch (opcion) {
                case 0: // Agregar jugador
                    if (carrera.listarJugadores().size() < 4) {
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador:");
                        if (nombre != null && !nombre.trim().isEmpty()) {
                            carrera.agregarJugador(new Jugador(nombre));
                        } else {
                            JOptionPane.showMessageDialog(null, "Nombre no válido.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pueden agregar más de 4 jugadores.");
                    }
                    break;

                case 1: // Listar jugadores
                    StringBuilder listaJugadores = new StringBuilder("Jugadores:\n");
                    for (Jugador jugador : carrera.listarJugadores()) {
                        listaJugadores.append(jugador.getNombre()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, listaJugadores.toString());
                    break;

                case 2: // Ayuda
                    JOptionPane.showMessageDialog(null, "Opciones del menú:\n" +
                            "- Agregar jugador: Añade un jugador a la carrera (máximo 4 jugadores).\n" +
                            "- Listar jugadores: Muestra la lista de jugadores.\n" +
                            "- Jugar: Comienza el juego con los jugadores agregados.\n" +
                            "- Salir: Cierra el juego.");
                    break;

                case 3: // Jugar
                    carrera.jugar();
                    break;

                case 4: // Salir
                    salir = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}
