package com.mycompany.juego_carreras;

import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author jacob
 */

/**
 * Clase que gestiona la carrera, incluyendo jugadores, premios y castigos.
 */
public class Carrera {
    private List<Jugador> jugadores;
    private Stack<PremioOCastigo> pilaPremiosCastigos;
    private Queue<Jugador> colaJugadores;

    /**
     * Constructor para crear una nueva carrera.
     */
    public Carrera() {
        jugadores = new ArrayList<>();
        pilaPremiosCastigos = new Stack<>();
        colaJugadores = new LinkedList<>();
        inicializarPremiosCastigos();
    }

    /**
     * Agrega un nuevo jugador a la carrera, si el número de jugadores es menor que 4.
     * @param jugador El jugador a agregar.
     */
    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() < 4) {
            jugadores.add(jugador);
            colaJugadores.add(jugador);
        } else {
            JOptionPane.showMessageDialog(null, "Máximo 4 jugadores permitidos.");
        }
    }

    /**
     * Lista los jugadores actualmente en la carrera.
     * @return Una lista de jugadores.
     */
    public List<Jugador> listarJugadores() {
        return jugadores;
    }

    /**
     * Inicia el turno de juego para el siguiente jugador en la cola.
     */
    public void jugar() {
        if (jugadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay jugadores registrados.");
            return;
        }
        jugarTurno(colaJugadores.poll());
    }

    /**
     * Método recursivo que maneja el turno de un jugador.
     * @param jugadorActual El jugador que está tomando su turno.
     */
    private void jugarTurno(Jugador jugadorActual) {
       
    }

    /**
     * Muestra los premios y castigos pendientes en la pila.
     */
    public void mostrarPremiosCastigosPendientes() {
        
    }

    /**
     * Inicializa la pila de premios y castigos.
     */
    private void inicializarPremiosCastigos() {
        
    }
}
