
package logica;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

import conexion.Conexion;

/**
 * The Class Lg_Habitacion.
 */
public class Lg_Habitacion {

	/** The fichero. */
	private Persistencia fichero = new Persistencia();

	/** The cabeza. */
	Nodo cabeza;

	/** The fin. */
	Nodo fin;

	/** The c. */
	public Conexion c = Conexion.getConn();

	/** The m. */
	Lg_Validaciones m = new Lg_Validaciones();

	/** The hab_precio. */
	double hab_precio;

	/** The hab_estado. */
	boolean hab_estado;

	/** The tha_codigo. */
	int tha_codigo;

	/** The chb_codigo. */
	int chb_codigo;

	/** The hab_codigo. */
	int hab_codigo;

	/**
	 * Instantiates a new lg_ habitacion.
	 */
	public Lg_Habitacion() {
		cabeza = fin = null;
		hab_codigo = 0;
		tha_codigo = 0;
		chb_codigo = 0;
		hab_precio = 0;
		hab_estado = true;
	}

	/**
	 * Instantiates a new lg_ habitacion.
	 * 
	 * @param hab_codigo
	 *            the hab_codigo
	 * @param tha_codigo
	 *            the tha_codigo
	 * @param chb_codigo
	 *            the chb_codigo
	 * @param hab_precio
	 *            the hab_precio
	 * @param hab_estado
	 *            the hab_estado
	 */
	public Lg_Habitacion(int hab_codigo, int tha_codigo, int chb_codigo,
			double hab_precio, boolean hab_estado) {
		this.hab_codigo = hab_codigo;
		this.tha_codigo = tha_codigo;
		this.chb_codigo = chb_codigo;
		this.hab_precio = hab_precio;
		this.hab_estado = hab_estado;

	}

	/**
	 * Agregar producto. Envia y ejecuta una sentencia SQL para insetar una
	 * nueva habitacion a la tabla habitacion
	 */
	@SuppressWarnings("static-access")
	public void agregarHabitacion() {
		String cad = "INSERT INTO habitacion ( hab_codigo, tha_codigo, chb_codigo, hab_precio, hab_estado) VALUES ('"
				+ hab_codigo
				+ "','"
				+ tha_codigo
				+ "', '"
				+ chb_codigo
				+ "', "
				+ hab_precio + "," + hab_estado + " );";

		c.sentencia(cad);

	}

	/**
	 * Modificar producto. Envia y Ejecuta una Sentencia SQL para actualizar los
	 * datos que hay en la tabla con nuevos datos por medio del tipo de
	 * habitacion
	 * 
	 * @param hab_codigo
	 *            the hab_codigo
	 */
	@SuppressWarnings("static-access")
	public void ModificarProducto(int hab_codigo) {
		String cad = "UPDATE habitacion SET tha_codigo='" + tha_codigo
				+ "', chb_codigo='" + chb_codigo + ", precio=" + hab_precio
				+ ", estado =" + hab_estado + " WHERE hab_codigo=" + hab_codigo
				+ ";";

		c.sentencia(cad);

	}

	/**
	 * Llenargrilla. Recive un modelo de la tabla y los parametros de las
	 * columnas y retorna un modelo de tabla siempre y cuando se ay realizado
	 * otro metodo que se le envia parametros de modelo una sentencia SQL y las
	 * columnas..
	 * 
	 * @param model
	 *            the model
	 * @param cols
	 *            the cols
	 * @return the default table model
	 */
	public DefaultTableModel llenargrilla(DefaultTableModel model, String[] cols) {
		return m.llenargrilla(model, "SELECT * FROM habitacion;", cols);
	}

	/**
	 * Buscardatos. Buscar datos en la lista si encuentra retorna el primer
	 * parametro de la lista
	 * 
	 * @param numero
	 *            the numero
	 * @return the object
	 */
	public Object buscardatos(Object numero) {
		Nodo auxiliar = cabeza;
		boolean bn = false;
		while (!estavacia(auxiliar)) {
			if (auxiliar.numero.equals(numero)) {
				System.out.println("Se encontro el elemento buscado: "
						+ auxiliar.numero);

				bn = true;
				return String.valueOf(auxiliar.numero);

			}
			auxiliar = auxiliar.siguiente;
		}
		if (!bn) {
			System.out.println("No se encontro el elemento buscado: ");

		}
		return bn;

	}

	/**
	 * Remplazo. Buscar un dato en la lista si cumple retorna el el segundo
	 * parametro
	 * 
	 * @param numero
	 *            the numero
	 * @return the object
	 */
	public Object remplazo(Object numero) {
		Nodo auxiliar = cabeza;
		boolean bn = false;
		while (!estavacia(auxiliar)) {
			if (auxiliar.numero.equals(numero)) {
				System.out.println("Se encontro el elemento buscado: "+ auxiliar.numero);

				bn = true;
				return String.valueOf(auxiliar.tipo);

			}
			auxiliar = auxiliar.siguiente;
		}
		if (!bn) {
			System.out.println("No se encontro el elemento buscado: ");

		}
		return bn;

	}

	/**
	 * Estavacia. Pregunta si la lista esta vacia si lo esta retorna un valor de
	 * falso
	 * 
	 * @param aux
	 *            the aux
	 * @return true, if successful
	 */
	private boolean estavacia(Nodo aux) {
		if (aux == null)
			return true;
		return false;
	}

	/**
	 * Guardarobject. Guarda un objeto asignando un nombre y el objeto a guardar
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void guardarobject() throws IOException {
		fichero.guardarFichero("pila", cabeza);
	}

	/**
	 * Cargardatosfichero. Carga los datos en la lista creando un nodo auxiliar
	 * que recive todo los datos que contiene el archivo.
	 * 
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void cargardatosfichero() throws ClassNotFoundException, IOException {
		Nodo auxiliar = fichero.cargarFichero("pila");
		if (auxiliar != null) {
			cabeza = auxiliar;
			while (auxiliar.siguiente != null) {
				auxiliar = auxiliar.siguiente;
			}
			fin = auxiliar;
		}
	}

}
