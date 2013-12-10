/*
 * UNIVERSIDAD T�CNICA DE MAHCHALA 
 * FACULTAD DE INGENIER�A CIVIL
 * ESCUELA DE INFORM�TICA
 * SISTEMA DE FACTURACION
 */
package logica;

import java.io.Serializable;

/**
 * The Class Nodo.
 * 
 * @author Edwin
 * @version 1.0
 */
public class Nodo implements Serializable {
	
	/** The numero. */
	Object numero;
	
	/** The tipo. */
	Object tipo ;
	
	/** The anterior. */
	Nodo anterior = null;
	
	/** The siguiente. */
	Nodo siguiente = null;

	/**
	 * Instantiates a new nodo.
	 * 
	 * @param dato
	 *            the dato
	 * @param tipo
	 *            the tipo
	 */
	public Nodo(Object dato,Object tipo) {
		this.numero = dato;
		this.tipo= tipo;
	}
}