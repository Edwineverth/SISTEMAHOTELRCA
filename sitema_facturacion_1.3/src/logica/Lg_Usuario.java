package logica;

import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import conexion.Conexion;

/**
 * The Class Lg_Usuario.
 */
public class Lg_Usuario {

	/** The c. */
	public Conexion c = Conexion.getConn();

	/** The m. */
	Lg_Validaciones m = new Lg_Validaciones();

	/** The usu_cedula. */
	String usu_cedula;

	/** The usu_nombres. */
	String usu_nombres;

	/** The usu_apellidos. */
	String usu_apellidos;

	/** The usu_telefono. */
	String usu_telefono;

	/** The usu_direccion. */
	String usu_direccion;

	/** The usu_clave. */
	String usu_clave;

	/** The usu_tipo. */
	int usu_tipo;

	/** The estado. */
	boolean estado;

	/** The usu_codigo. */
	int usu_codigo;

	/**
	 * Instantiates a new lg_ usuario.
	 */
	public Lg_Usuario() {
		usu_codigo = 0;
		usu_cedula = null;
		usu_nombres = null;
		usu_apellidos = null;
		usu_telefono = null;
		usu_direccion = null;
		usu_clave = null;
		usu_tipo = 0;
		estado = true;
	}

	/**
	 * Instantiates a new lg_ usuario.
	 * 
	 * @param usu_codigo
	 *            the usu_codigo
	 * @param usu_cedula
	 *            the usu_cedula
	 * @param usu_nombres
	 *            the usu_nombres
	 * @param usu_apellidos
	 *            the usu_apellidos
	 * @param usu_telefono
	 *            the usu_telefono
	 * @param usu_direccion
	 *            the usu_direccion
	 * @param usu_clave
	 *            the usu_clave
	 * @param usu_tipo
	 *            the usu_tipo
	 * @param estado
	 *            the estado
	 */
	public Lg_Usuario(int usu_codigo, String usu_cedula, String usu_nombres,
			String usu_apellidos, String usu_telefono, String usu_direccion,
			String usu_clave, int usu_tipo, boolean estado) {
		this.usu_codigo = usu_codigo;
		this.usu_cedula = usu_cedula;
		this.usu_nombres = usu_nombres;
		this.usu_apellidos = usu_apellidos;
		this.usu_telefono = usu_telefono;
		this.usu_direccion = usu_direccion;
		this.usu_clave = usu_clave;
		this.usu_tipo = usu_tipo;
		this.estado = estado;
	}

	/**
	 * Agregar usuario.
	 */
	@SuppressWarnings("static-access")
	public void AgregarUsuario() {
		String cad = "INSERT INTO usuario (usu_codigo,cedula, nombre, apellidos, telefono, direccion, clave, tus_codigo, estado) VALUES ('"
				+ usu_codigo
				+ "','"
				+ usu_cedula
				+ "', '"
				+ usu_nombres
				+ "', '"
				+ usu_apellidos
				+ "', '"
				+ usu_telefono
				+ "', '"
				+ usu_direccion
				+ "', '"
				+ usu_clave
				+ "', '"
				+ usu_tipo
				+ "',"
				+ estado + " );";

		c.sentencia(cad);

	}

	/**
	 * Modificar usuario.
	 * 
	 * @param usu_codigo
	 *            the usu_codigo
	 */
	@SuppressWarnings("static-access")
	public void ModificarUsuario(int usu_codigo) {
		String cad = "UPDATE usuario SET cedula='" + usu_cedula + "', nombre='"
				+ usu_nombres + "', apellidos='" + usu_apellidos
				+ "', telefono='" + usu_telefono + "', direccion='"
				+ usu_direccion + "', clave='" + usu_clave + "', tus_codigo='"
				+ usu_tipo + "', estado =" + estado + " WHERE usu_codigo="
				+ usu_codigo + ";";

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
		return m.llenargrilla(model, "SELECT * FROM usuario;", cols);
	}

	/**
	 * Login. Realiza una consulta a la base de datos para saber si la cedula
	 * consta en la tabla de usuario y si la contraseña que se envia es igual a
	 * la que se obtiene de base de datos.
	 * 
	 * @param ced
	 *            the ced
	 * @param pas
	 *            the pas
	 * @return true, if successful
	 */
	@SuppressWarnings("static-access")
	public boolean login(String ced, String pas) {
		Conexion c = Conexion.getConn();
		String pas1 = "";
		try {
			ResultSet r = c
					.consulta("SELECT usu_clave  FROM usuario WHERE usu_cedula = '"
							+ ced + "';");

			while (r.next()) {

				pas1 = r.getString(1);
				System.out.println(pas1);
			}

			System.out.println("aqui esta" + r.next());

		} catch (Exception e) {
			System.out.println("No Entro");
		}
		if (pas.equalsIgnoreCase(pas1) && !ced.equalsIgnoreCase("")
				&& !pas.equalsIgnoreCase("")) {
			System.out.println("entra");

			return true;
		} else {
			return false;
		}

	}

	/**
	 * Tipousuario. Realiza una Consulta a la base de datos para saber que
	 * persmisos tiene la cedula que se envio
	 * 
	 * @param ced
	 *            the ced
	 * @return the int
	 */
	@SuppressWarnings("static-access")
	public static int tipousuario(String ced) {
		Conexion c = Conexion.getConn();
		int persmiso = 0;
		try {
			ResultSet r = c
					.consulta("SELECT  permisos.per_permiso FROM  usuario, \"tus_Usuario\",permisos WHERE  usuario.tus_codigos = \"tus_Usuario\".tus_codigos AND permisos.tus_codigos = \"tus_Usuario\".tus_codigos AND usuario.usu_cedula = '"
							+ ced + "' ;");
			while (r.next()) {
				persmiso = Integer.parseInt(r.getString(1));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return persmiso;
	}
}
