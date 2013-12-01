
package logica;

import conexion.Conexion;

import javax.swing.table.DefaultTableModel;

/**
 * The Class Lg_Cliente.
 * kmjinhubygvtfrdcs 
 */
public class Lg_Cliente {

	/** The c. */
	public Conexion c = Conexion.getConn();

	/** The m. */
	Metodos m = new Metodos();

	/** The cli_codigo. */
	int cli_codigo;

	/** The cli_cedula. */
	String cli_cedula;

	/** The cli_nombres. */
	String cli_nombres;

	/** The cli_apellidos. */
	String cli_apellidos;

	/** The cli_telefono. */
	String cli_telefono;

	/** The cli_direccion. */
	String cli_direccion;

	/** The estado. */
	boolean estado;

	/**
	 * Instantiates a new lg_ cliente.
	 */
	public Lg_Cliente() {
		cli_codigo = 0;
		cli_cedula = null;
		cli_nombres = null;
		cli_apellidos = null;
		cli_telefono = null;
		cli_direccion = null;
		estado = true;
	}

	/**
	 * Instantiates a new lg_ cliente.
	 * 
	 * @param cli_codigo
	 *            the cli_codigo
	 * @param cli_cedula
	 *            the cli_cedula
	 * @param cli_nombres
	 *            the cli_nombres
	 * @param cli_apellidos
	 *            the cli_apellidos
	 * @param cli_telefono
	 *            the cli_telefono
	 * @param cli_direccion
	 *            the cli_direccion
	 * @param estado
	 *            the estado
	 */
	public Lg_Cliente(int cli_codigo, String cli_cedula, String cli_nombres,
			String cli_apellidos, String cli_telefono, String cli_direccion,
			boolean estado) {
		this.cli_codigo = cli_codigo;
		this.cli_cedula = cli_cedula;
		this.cli_nombres = cli_nombres;
		this.cli_apellidos = cli_apellidos;
		this.cli_telefono = cli_telefono;
		this.cli_direccion = cli_direccion;
		this.estado = estado;
	}

	/**
	 * Agregar cliente. Ejecuta una sentencia SQL para insertar nuevos datos a
	 * la tabla de la base de datos con los parametros ya definidos.
	 */
	@SuppressWarnings("static-access")
	public void AgregarCliente() {
		String cad = "INSERT INTO cliente (cli_codigo,cedula, nombre, apellido, telefono, direccion, estado) VALUES ('"
				+ cli_codigo
				+ "','"
				+ cli_cedula
				+ "', '"
				+ cli_nombres
				+ "', '"
				+ cli_apellidos
				+ "', '"
				+ cli_telefono
				+ "', '"
				+ cli_direccion + "'," + estado + " );";

		c.sentencia(cad);

	}

	/**
	 * Modificar cliente. Ejectura una sentencia SQL para actualizar los
	 * parametros de una tabla.
	 * 
	 * @param cli_codigo
	 *            the cli_codigo
	 */
	@SuppressWarnings("static-access")
	public void ModificarCliente(int cli_codigo) {
		String cad = "UPDATE cliente SET cedula='" + cli_cedula + "', nombre='"
				+ cli_nombres + "', apellido='" + cli_apellidos
				+ "', telefono='" + cli_telefono + "', direccion='"
				+ cli_direccion + "', estado =" + estado + " WHERE cli_codigo="
				+ cli_codigo + ";";

		c.sentencia(cad);

	}

	/**
	 * Llenargrilla. Recive un modelo de la tabla y los parametros de las
	 * columnas y retorna un modelo de tabla siempre y cuando se ay realizado
	 * otro metodo que se le envia parametros de modelo una sentencia SQL y las columnas..
	 * 
	 * @param model
	 *            the model
	 * @param cols
	 *            the cols
	 * @return the default table model
	 */
	public DefaultTableModel llenargrilla(DefaultTableModel model, String[] cols) {
		return m.llenargrilla(model, "SELECT * FROM cliente;", cols);
	}
}