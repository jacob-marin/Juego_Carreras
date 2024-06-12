
package com.mycompany.juego_carreras;

/**
 *
 * @author jacob
 */
public class PilaJugadores {
    private static final int MAX_JUGADORES = 4;
    private String[] jugadores;
    private int top;

    public PilaJugadores() {
        this.jugadores = new String[MAX_JUGADORES];
        this.top = -1;
    }

    public boolean agregarJugador(String nombre) {
        if (top < MAX_JUGADORES - 1) {
            jugadores[++top] = nombre;
            return true;
        }
        return false;
    }

    public boolean eliminarJugador(int index) {
        if (index >= 0 && index <= top) {
            for (int i = index; i < top; i++) {
                jugadores[i] = jugadores[i + 1];
            }
            jugadores[top--] = null;
            return true;
        }
        return false;
    }

    public String imprimirJugadores() {
        if (top == -1) {
            return "No hay jugadores en la pila.";
        } else {
            StringBuilder sb = new StringBuilder("Pila de jugadores:\n");
            imprimirJugadoresRecursivo(sb, top);
            return sb.toString();
        }
    }

    private void imprimirJugadoresRecursivo(StringBuilder sb, int index) {
        if (index < 0) {
            return;
        }
        sb.append(top - index + 1).append(". ").append(jugadores[index]).append("\n");
        imprimirJugadoresRecursivo(sb, index - 1);
    }

    public String[] obtenerListaJugadores() {
        String[] lista = new String[top + 1];
        System.arraycopy(jugadores, 0, lista, 0, top + 1);
        return lista;
    }

    public int obtenerTop() {
        return top;
    }
}
