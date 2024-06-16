package com.mycompany.juego_carreras;
/**
 *
 * @author jacob
 */
/**
 * Clase abstracta que representa un premio o un castigo.
 */
public abstract class PremioOCastigo {
    protected int valor;
    protected String descripcion;

    /**
     * Constructor para crear un nuevo premio o castigo.
     * @param valor El valor del premio o castigo.
     * @param descripcion La descripción del premio o castigo.
     */
    public PremioOCastigo(int valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el valor del premio o castigo.
     * @return El valor del premio o castigo.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene la descripción del premio o castigo.
     * @return La descripción del premio o castigo.
     */
    public String getDescripcion() {
        return descripcion;
    }
}

/**
 * Clase que representa un premio.
 */
class Premio extends PremioOCastigo { ///////////////////////////////////////////////////////////////////////////////
    /**
     * Constructor para crear un nuevo premio.
     * @param valor El valor del premio.
     * @param descripcion La descripción del premio.
     */
    public Premio(int valor, String descripcion) {
        super(valor, descripcion);
    }
}

/**
 * Clase que representa un castigo.
 */
class Castigo extends PremioOCastigo { //////////////////////////////////////////////////////////////////////////////
    /**
     * Constructor para crear un nuevo castigo.
     * @param valor El valor del castigo.
     * @param descripcion La descripción del castigo.
     */
    public Castigo(int valor, String descripcion) {
        super(valor, descripcion);
    }
}