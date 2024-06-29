package com.mycompany.juego_carreras;
/**
 *
 * @author jacob
 */
/**
 * Clase abstracta que representa un premio o castigo en la carrera.
 */
abstract class PremioOCastigo {
    protected int valor;
    protected String descripcion;

    /**
     * Constructor que inicializa un premio o castigo con un valor y una descripción.
     *
     * @param valor el valor del premio o castigo
     * @param descripcion la descripción del premio o castigo
     */
    public PremioOCastigo(int valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el valor del premio o castigo.
     *
     * @return el valor del premio o castigo
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene la descripción del premio o castigo.
     *
     * @return la descripción del premio o castigo
     */
    public String getDescripcion() {
        return descripcion;
    }
}

/**
 * Clase que representa un premio en la carrera.
 */
class Premio extends PremioOCastigo {
    /**
     * Constructor que inicializa un premio con un valor y una descripción.
     *
     * @param valor el valor del premio
     * @param descripcion la descripción del premio
     */
    public Premio(int valor, String descripcion) {
        super(valor, descripcion);
    }
}

/**
 * Clase que representa un castigo en la carrera.
 */
class Castigo extends PremioOCastigo {
    /**
     * Constructor que inicializa un castigo con un valor y una descripción.
     *
     * @param valor el valor del castigo
     * @param descripcion la descripción del castigo
     */
    public Castigo(int valor, String descripcion) {
        super(valor, descripcion);
    }
}