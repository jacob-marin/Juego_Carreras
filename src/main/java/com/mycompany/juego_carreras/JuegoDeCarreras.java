package com.mycompany.juego_carreras;
/**
 *
 * @author jacob
 */
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.List;

/**
 * Clase principal que ejecuta el juego de carreras.
 */
public class JuegoDeCarreras {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();
        String[] opcionesMenu = {"Agregar jugador", "Listar jugadores", "Jugar", "Ver resultados", "Ver premios/castigos", "Ayuda", "Salir"};
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
                case 2: // Jugar
                    carrera.jugar();
                    break;
                case 3: // Ver resultados
                    List<Jugador> jugadores = carrera.listarJugadores();
                    StringBuilder resultados = new StringBuilder("Resultados:\n\n");
                    for (Jugador jugador : jugadores) {
                        resultados.append(jugador.getNombre()).append(": Km ").append(jugador.getPosicionActual()).append("\n");
                    }
                    JTextArea areaResultados = new JTextArea(resultados.toString());
                    areaResultados.setEditable(false);
                    JOptionPane.showMessageDialog(null, areaResultados, "Resultados de la carrera", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4: // Ver premios/castigos
                    carrera.mostrarPremiosCastigosPendientes();
                    break;
                case 5: // Ayuda
                    String ayuda = "Ayuda:\n\n" +
                            "1. Agregar jugador: Permite agregar un nuevo jugador a la carrera.\n" +
                            "2. Listar jugadores: Muestra la lista de jugadores registrados.\n" +
                            "3. Jugar: Inicia la carrera y avanza los turnos de los jugadores.\n" +
                            "4. Ver resultados: Muestra las posiciones actuales de los jugadores.\n" +
                            "5. Ver premios/castigos: Muestra los premios y castigos pendientes en la pila.\n" +
                            "6. Salir: Cierra el juego.\n\n" +
                            "Versión de la herramienta. V 1.2.9 Responsable Jacob Marin, Ali Fonseca, Maikel ";
                    JTextArea areaAyuda = new JTextArea(ayuda);
                    areaAyuda.setEditable(false);
                    JOptionPane.showMessageDialog(null, areaAyuda, "Ayuda", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 6: // Salir
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }
}