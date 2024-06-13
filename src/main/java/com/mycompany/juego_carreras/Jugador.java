package com.mycompany.juego_carreras;

/**
 *
 * @author jacob
 */
/**
 * Clase que representa a un jugador en la carrera.
 */
public class Jugador {
    private String nombre;
    private int posicionActual;

    /**
     * Constructor para crear un nuevo jugador con un nombre especificado.
     * @param nombre El nombre del jugador.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicionActual = 0;
    }

    /**
     * Obtiene el nombre del jugador.
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la posición actual del jugador en la carrera.
     * @return La posición actual del jugador.
     */
    public int getPosicionActual() {
        return posicionActual;
    }

    /**
     * Establece una nueva posición para el jugador en la carrera.
     * @param nuevaPosicion La nueva posición del jugador.
     */
    public void setPosicionActual(int nuevaPosicion) {
        this.posicionActual = nuevaPosicion;
    }

    @Override
    public String toString() {
        return "Jugador " + nombre + " está en el kilómetro " + posicionActual;
    }
}
