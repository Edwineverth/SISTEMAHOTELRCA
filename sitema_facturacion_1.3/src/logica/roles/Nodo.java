/*
 * UNIVERSIDAD TÉCNICA DE MAHCHALA 
 * FACULTAD DE INGENIERÍA CIVIL
 * ESCUELA DE INFORMÁTICA
 * SISTEMA DE FACTURACION
 */
package logica.roles;

import java.io.Serializable;

/**
 * The Class Nodo.
 * 
 * @author Edwin
 * @version 1.0
 */
public class Nodo implements Serializable {
	
	/** The numero. */
	public Object numero;
	
	/** The tipo. */
	public Object tipo ;
	
	/** The anterior. */
	Nodo anterior = null;
	
	/** The siguiente. */
	public Nodo siguiente = null;

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