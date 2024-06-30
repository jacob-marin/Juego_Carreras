package com.mycompany.juego_carreras;
/**
 *
 * @author jacob
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JTextArea;

/**
 * Clase que gestiona la carrera, incluyendo jugadores, premios y castigos.
 * Proporciona métodos para agregar jugadores, listar jugadores, jugar turnos y mostrar premios/castigos pendientes.
 */
public class Carrera {

    private Pila<PremioOCastigo> pilaPremiosCastigos;
    private Cola<Jugador> colaJugadores;

    /**
     * Constructor que inicializa la pila de premios/castigos y la cola de jugadores.
     */
    public Carrera() {
        pilaPremiosCastigos = new Pila<>();
        colaJugadores = new Cola<>();
        inicializarPremiosCastigos();
    }

    /**
     * Agrega un jugador a la carrera.
     *
     * @param jugador el jugador a agregar
     */
    public void agregarJugador(Jugador jugador) {
        if (colaJugadores.verTamaño() < 4) {
            colaJugadores.agregar(jugador);
        } else {
            JOptionPane.showMessageDialog(null, "Máximo 4 jugadores permitidos.");
        }
    }

    /**
     * Lista los jugadores en la carrera.
     *
     * @return una lista de los jugadores en la carrera
     */
    public List<Jugador> listarJugadores() {
        List<Jugador> listaJugadores = new ArrayList<>();
        for (int i = 0; i < colaJugadores.verTamaño(); i++) {
            Jugador jugador = colaJugadores.eliminar();
            listaJugadores.add(jugador);
            colaJugadores.agregar(jugador);
        }
        return listaJugadores;
    }

    /**
     * Juega un turno para cada jugador en la carrera.
     */
    public void jugar() {
        if (colaJugadores.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay jugadores registrados.");
            return;
        }
        int numJugadores = colaJugadores.verTamaño();
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = colaJugadores.eliminar();
            jugarTurno(jugador);
            colaJugadores.agregar(jugador);
        }
    }

    /**
     * Juega un turno para un jugador.
     *
     * @param jugadorActual el jugador que juega el turno
     */
    private void jugarTurno(Jugador jugadorActual) {
        Random random = new Random();
        int firstRoll = random.nextInt(6) + 1;
        int secondRoll = random.nextInt(6) + 1;
        int avance = firstRoll + secondRoll;
        JOptionPane.showMessageDialog(null, "Primer dado: " + firstRoll + "\nSegundo dado: " + secondRoll + "\nSuma: " + avance);
        int nuevaPosicion = jugadorActual.getPosicionActual() + avance;
        JOptionPane.showMessageDialog(null, "Jugador " + jugadorActual.getNombre() + " está en el kilómetro " + jugadorActual.getPosicionActual() + "\n" +
                "Puedes avanzar " + avance + " kilómetros en la carrera, ahora tu nueva posición es: " + nuevaPosicion);
        jugadorActual.setPosicionActual(nuevaPosicion);
        if ((firstRoll + secondRoll) % 2 == 0) {
            PremioOCastigo premioOCastigo = pilaPremiosCastigos.eliminar();
            if (premioOCastigo instanceof Premio) {
                nuevaPosicion += premioOCastigo.getValor();
                JOptionPane.showMessageDialog(null, "Obtuviste un premio: " + premioOCastigo.getDescripcion() + ". Nueva posición: " + nuevaPosicion);
            } else if (premioOCastigo instanceof Castigo) {
                nuevaPosicion -= premioOCastigo.getValor();
                JOptionPane.showMessageDialog(null, "Obtuviste un castigo: " + premioOCastigo.getDescripcion() + ". Nueva posición: " + nuevaPosicion);
            }
            jugadorActual.setPosicionActual(nuevaPosicion);
        }
    }

    /**
     * Inicializa los premios y castigos en la pila.
     */
    private void inicializarPremiosCastigos() {
        pilaPremiosCastigos.agregar(new Premio(2, "Suma 2 posiciones FELICIDADES"));
        pilaPremiosCastigos.agregar(new Premio(8, "Suma 8 posiciones FELICIDADES"));
        pilaPremiosCastigos.agregar(new Castigo(3, "Resta 3 posiciones... LO SIENTO"));
        pilaPremiosCastigos.agregar(new Premio(0, "No afecta"));
        pilaPremiosCastigos.agregar(new Castigo(1, "Debe ir a inicio... LO SIENTO"));
    }

    /**
     * Muestra los premios y castigos pendientes en la pila.
     */
    public void mostrarPremiosCastigosPendientes() {
        String premiosCastigosPendientes = pilaPremiosCastigos.mostrarElementos();
        if (premiosCastigosPendientes.isEmpty()) {
            premiosCastigosPendientes = "No hay premios ni castigos pendientes.";
        }
        JTextArea areaPremiosCastigos = new JTextArea(premiosCastigosPendientes);
        areaPremiosCastigos.setEditable(false);
        JOptionPane.showMessageDialog(null, areaPremiosCastigos, "Premios/Castigos pendientes", JOptionPane.INFORMATION_MESSAGE);
    }
}
