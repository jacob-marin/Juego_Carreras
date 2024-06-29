package com.mycompany.juego_carreras;
/**
 *
 * @author jacob
 */
import javax.swing.JOptionPane;

/**
 * Clase que implementa una pila genérica.
 *
 * @param <T> el tipo de elemento que almacena la pila
 */
public class Pila<T> {

    private Nodo<T> cima;

    /**
     * Constructor por defecto que inicializa la pila vacía.
     */
    public Pila() {
        this.cima = null;
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario
     */
    public boolean esVacia() {
        return cima == null;
    }

    /**
     * Agrega un elemento a la pila.
     *
     * @param elemento el elemento a agregar
     */
    public void agregar(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (esVacia()) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return el elemento en la cima de la pila
     */
    public T eliminar() {
        if (!esVacia()) {
            T elemento = cima.getElemento();
            cima = cima.getSiguiente();
            return elemento;
        } else {
            JOptionPane.showMessageDialog(null, "No se puede extraer, pila vacía");
            return null;
        }
    }

    /**
     * Muestra los elementos en la pila.
     *
     * @return una cadena con los elementos de la pila
     */
    public String mostrarElementos() {
        StringBuilder elementos = new StringBuilder();
        Nodo<T> aux = cima;
        while (aux != null) {
            elementos.append(aux.getElemento().toString()).append("\n");
            aux = aux.getSiguiente();
        }
        return elementos.toString();
    }
}

/**
 * Clase que representa un nodo en la pila.
 *
 * @param <T> el tipo de elemento que almacena el nodo
 */
class Nodo<T> {

    private T elemento;
    private Nodo<T> siguiente;

    /**
     * Constructor que inicializa el nodo con un elemento.
     *
     * @param elemento el elemento a almacenar en el nodo
     */
    public Nodo(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }

    /**
     * Obtiene el elemento almacenado en el nodo.
     *
     * @return el elemento almacenado en el nodo
     */
    public T getElemento() {
        return elemento;
    }

    /**
     * Obtiene el nodo siguiente.
     *
     * @return el nodo siguiente
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    /**
     * Establece el nodo siguiente.
     *
     * @param siguiente el nodo siguiente
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}