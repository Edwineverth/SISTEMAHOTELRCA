/**
 * 
 */
package logica.seguridad;

import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import conexion.Conexion;
import logica.validaciones.Validaciones;

/**
 * @author Dell Inspiron
 * @version 1.0
 */
public class Seguridad_Usuario {

	protected String usu_cedula;
	protected String usu_nombres;
	protected String usu_apellidos;
	protected String usu_telefono;
	protected String usu_direccion;
	protected String usu_clave;
	protected int usu_tipo;
	protected boolean estado;
	protected int usu_codigo;
	public Conexion c = Conexion.getConn();
	public Validaciones m = new Validaciones();

	public Seguridad_Usuario() {
		this.usu_codigo = 0;
		this.usu_cedula = "";
		this.usu_nombres = "";
		this.usu_apellidos = "";
		this.usu_telefono = "";
		this.usu_direccion = "";
		this.usu_clave = "";
		this.usu_tipo = 0;
		this.estado = false;
		
	}

	public Seguridad_Usuario(int usu_codigo,String usu_cedula, String usu_nombres,
			String usu_apellidos, String usu_telefono, String usu_direccion,
			String usu_clave, int usu_tipo, boolean estado ) {
		this.usu_cedula = usu_cedula;
		this.usu_nombres = usu_nombres;
		this.usu_apellidos = usu_apellidos;
		this.usu_telefono = usu_telefono;
		this.usu_direccion = usu_direccion;
		this.usu_clave = usu_clave;
		this.usu_tipo = usu_tipo;
		this.estado = estado;
		this.usu_codigo = usu_codigo;
	}

	public void AgregarUsuario() {
		String cad = "INSERT INTO usuario (usu_codigo,usu_cedula, usu_nombre, usu_apellido, usu_telefono, usu_direccion, usu_clave, usu_estado, rol_codigo) VALUES ('"
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
				+ estado
				+ "',"
				+ usu_tipo + " );";

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
		String cad = "UPDATE usuario SET usu_cedula='" + usu_cedula + "', usu_nombre='"
				+ usu_nombres + "', usu_apellido='" + usu_apellidos
				+ "', usu_telefono='" + usu_telefono + "', usu_direccion='"
				+ usu_direccion + "', usu_clave='" + usu_clave + "', rol_codigo='"
				+ usu_tipo + "', usu_estado =" + estado + " WHERE usu_codigo="
				+ usu_codigo + ";";

		c.sentencia(cad);

	}

	public DefaultTableModel llenargrilla(DefaultTableModel model, String[] cols) {
		return m.llenargrilla(model, "SELECT * FROM usuario;", cols);
	}

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

	@SuppressWarnings("static-access")
	public static int tipousuario(String ced) {
		Conexion c = Conexion.getConn();
		int persmiso = 0;
		try {
			ResultSet r = c
					.consulta("SELECT  usuario.rol_codigo FROM  usuario WHERE usuario.usu_cedula = '"
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
