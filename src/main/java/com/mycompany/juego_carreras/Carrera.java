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
    private Pila<PremioOCastigo> pilaPremiosCastigos;
    private Cola<Jugador> colaJugadores;

    /**
     * Constructor para crear una nueva carrera.
     */
    public Carrera() {
        jugadores = new ArrayList<>();
        pilaPremiosCastigos = new Pila<>();
        colaJugadores = new Cola<>();
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
     * Inicia el turno de juego para cada jugador en la cola.
     */
    public void jugar() {
        if (jugadores.isEmpty()) { //IsEmpty devuelve una valor booleano, devuelve 1 si el campo esta vacio, de lo contrario devuelve un 0.
            JOptionPane.showMessageDialog(null, "No hay jugadores registrados.");
            return;
        }

        int numJugadores = colaJugadores.size();
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = colaJugadores.poll(); // permite recuperar o eliminar el elemento superir(cabeza) de una cola
            jugarTurno(jugador);
            colaJugadores.add(jugador); // añade jugadores a la cola
        }
    }

    /**
     * Maneja el turno de un jugador.
     * @param jugadorActual El jugador que está tomando su turno.
     */
    private void jugarTurno(Jugador jugadorActual) {
        Random random = new Random(); // funcion random 
        int firstRoll = random.nextInt(6) + 1; // Primer dado aleatorio
        int secondRoll = random.nextInt(6) + 1; // segundo dado aleatorio
        int avance = firstRoll + secondRoll; // suma de los dados

        JOptionPane.showMessageDialog(null, "Primer dado: " + firstRoll + "\nSegundo dado: " + secondRoll + "\nSuma: " + avance);

        int nuevaPosicion = jugadorActual.getPosicionActual() + avance;
        JOptionPane.showMessageDialog(null, "Jugador " +" <<--- "+ jugadorActual.getNombre() + " --->> \n"+ "Estás en el kilómetro " + jugadorActual.getPosicionActual() +"\n"+
                "Puedes avanzar " + "---> "+ avance + " kilómetros en la carrera,\n" + "Ahora tu nueva posición es: ---> " + nuevaPosicion);

        jugadorActual.setPosicionActual(nuevaPosicion);

        if ((firstRoll + secondRoll) % 2 == 0) { // esta funcio indica que el residuo de la division de 0 el numero es par, sino es impar
            PremioOCastigo premioOCastigo = pilaPremiosCastigos.pop(); // pop elimina el premio o castigo ya utilizado 
            if (premioOCastigo instanceof Premio) { // permite verificar si un objeto pertenece a una clase determinada
                nuevaPosicion += premioOCastigo.getValor();
                JOptionPane.showMessageDialog(null, "Obtuviste un premio: " + premioOCastigo.getDescripcion() + ". Nueva posición: " + nuevaPosicion);
            } else if (premioOCastigo instanceof Castigo) {
                nuevaPosicion -= premioOCastigo.getValor();
                JOptionPane.showMessageDialog(null, "Obtuviste un castigo: " + premioOCastigo.getDescripcion() + ". Nueva posición: " + nuevaPosicion);
            }
            jugadorActual.setPosicionActual(nuevaPosicion); // indica la nueva posicion ya sumado o restado el premio o castigo 
        }
    }

    /**
     * Muestra los premios y castigos pendientes en la pila.
     */
    public void mostrarPremiosCastigosPendientes() {
        StringBuilder pendientes = new StringBuilder("Premios y Castigos dsiponibles:\n");
        for (PremioOCastigo p : pilaPremiosCastigos.getElementos()) {
            pendientes.append(p.getDescripcion()).append("\n");
        }
        JOptionPane.showMessageDialog(null, pendientes.toString());
    }

    /**
     * Inicializa la pila de premios y castigos.
     */
    private void inicializarPremiosCastigos() {
        pilaPremiosCastigos.push(new Premio(2, "Suma 2 posiciones FELICIDADES"));
        pilaPremiosCastigos.push(new Premio(8, "Suma 8 posiciones FELICIDADES"));
        pilaPremiosCastigos.push(new Castigo(3, "Resta 3 posiciones... LO SIENTO"));
        pilaPremiosCastigos.push(new Premio(0, "No afecta"));
        pilaPremiosCastigos.push(new Castigo(1, "Debe ir a inicio... LO SIENTO"));
    }
}