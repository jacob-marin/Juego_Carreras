package com.mycompany.juego_carreras;
/**
 *
 * @author jacob
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una pila.
 * @param <T> El tipo de elementos en la pila.
 */
public class Pila<T> {
    private List<T> elementos;

    /**
     * Constructor para crear una nueva pila.
     */
    public Pila() {
        elementos = new ArrayList<>();
    }

    /**
     * Agrega un elemento a la pila.
     * @param elemento El elemento a agregar.
     */
    public void push(T elemento) {
        elementos.add(elemento); //Añade elementos...
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * @return El elemento en la cima de la pila.
     */
    public T pop() {
        if (elementos.isEmpty()) { //IsEmpty devuelve una valor booleano, devuelve 1 si el campo esta vacio, de lo contrario devuelve un 0.
            throw new IllegalStateException("La pila está vacía");
        }
        return elementos.remove(elementos.size() - 1);
    }

    /**
     * Devuelve el número de elementos en la pila.
     * @return El número de elementos en la pila.
     */
    public int size() {
        return elementos.size();
    }

    /**
     * Devuelve una lista de todos los elementos en la pila.
     * @return Una lista de todos los elementos en la pila.
     */
    public List<T> getElementos() {
        return new ArrayList<>(elementos);
    }
}