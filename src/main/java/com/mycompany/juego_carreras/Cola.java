package com.mycompany.juego_carreras;
/**
 *
 * @author jacob
 */
/**
 * Clase que implementa una cola genérica.
 *
 * @param <T> el tipo de elemento que almacena la cola
 */
public class Cola<T> {

    private NodoC<T> frente;
    private NodoC<T> ultimo;

    /**
     * Constructor por defecto que inicializa la cola vacía.
     */
    public Cola() {
        frente = null;
        ultimo = null;
    }

    /**
     * Agrega un elemento a la cola.
     *
     * @param elemento el elemento a agregar
     */
    public void agregar(T elemento) {
        NodoC<T> nuevo = new NodoC<>(elemento);
        if (frente == null) {
            frente = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setAtras(nuevo);
            ultimo = nuevo;
        }
    }

    /**
     * Elimina y devuelve el primer elemento en la cola.
     *
     * @return el primer elemento en la cola
     */
    public T eliminar() {
        if (frente != null) {
            T elemento = frente.getDato();
            frente = frente.getAtras();
            if (frente == null) {
                ultimo = null;
            }
            return elemento;
        } else {
            return null;
        }
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return frente == null;
    }

    /**
     * Obtiene el tamaño de la cola.
     *
     * @return el tamaño de la cola
     */
    public int verTamaño() {
        int tamaño = 0;
        NodoC<T> aux = frente;
        while (aux != null) {
            tamaño++;
            aux = aux.getAtras();
        }
        return tamaño;
    }

    /**
     * Muestra los elementos en la cola.
     *
     * @return una cadena con los elementos de la cola
     */
    public String mostrarElementos() {
        StringBuilder elementos = new StringBuilder();
        NodoC<T> aux = frente;
        while (aux != null) {
            elementos.append(aux.getDato().toString()).append("\n");
            aux = aux.getAtras();
        }
        return elementos.toString();
    }
}

/**
 * Clase que representa un nodo en la cola.
 *
 * @param <T> el tipo de elemento que almacena el nodo
 */
class NodoC<T> {
    private T dato;
    private NodoC<T> atras;

    /**
     * Constructor que inicializa el nodo con un dato.
     *
     * @param dato el dato a almacenar en el nodo
     */
    public NodoC(T dato) {
        this.dato = dato;
        this.atras = null;
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     *
     * @return el dato almacenado en el nodo
     */
    public T getDato() {
        return dato;
    }

    /**
     * Obtiene el nodo siguiente.
     *
     * @return el nodo siguiente
     */
    public NodoC<T> getAtras() {
        return atras;
    }

    /**
     * Establece el nodo siguiente.
     *
     * @param atras el nodo siguiente
     */
    public void setAtras(NodoC<T> atras) {
        this.atras = atras;
    }
}