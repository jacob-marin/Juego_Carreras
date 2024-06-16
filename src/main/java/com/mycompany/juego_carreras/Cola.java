package com.mycompany.juego_carreras;
/**
 *
 * @author jacob
 */
import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa una cola.
 * @param <T> El tipo de elementos en la cola.
 */
public class Cola<T> {
    private List<T> elementos;

    /**
     * Constructor para crear una nueva cola.
     */
    public Cola() {
        elementos = new ArrayList<>();
    }

    /**
     * Agrega un elemento al final de la cola.
     * @param elemento El elemento a agregar.
     */
    public void add(T elemento) {
        elementos.add(elemento);
    }

    /**
     * Elimina y devuelve el elemento al frente de la cola.
     * @return El elemento al frente de la cola.
     */
    public T poll() { // permite recuperar o eliminar el elemento superir(cabeza) de una cola
        if (elementos.isEmpty()) { //IsEmpty devuelve una valor booleano, devuelve 1 si el campo esta vacio, de lo contrario devuelve un 0.
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos.remove(0); //elimina el elemento seleccionado 
    }

    /**
     * Devuelve el número de elementos en la cola.
     * @return El número de elementos en la cola.
     */
    public int size() { //contar el número de elementos de un array
        return elementos.size();
    }

    /**
     * Devuelve una lista de todos los elementos en la cola.
     * @return Una lista de todos los elementos en la cola.
     */
    public List<T> getElementos() {
        return new ArrayList<>(elementos);
    }
}