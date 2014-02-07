/**
 * 
 */
package logica.seguridad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import conexion.Conexion;
import logica.validaciones.Validaciones;
import interfaz.Form_Usuario;

public class Logica_Usuario {
	private int usu_codigo;
	private String usu_cedula;
	private String usu_nombre;
	private String usu_apellido;
	private String usu_telefono;
	private String usu_direccion;
	private String usu_clave;
	private boolean usu_estado;
	private int rol_codigo;
	public Conexion c = Conexion.getConn();
	public Validaciones m = new Validaciones ();
	
	

	public Logica_Usuario() {
		this.usu_codigo = 0;
		this.usu_cedula = "";
		this.usu_nombre = "";
		this.usu_apellido = "";
		this.usu_telefono = "";
		this.usu_direccion = "";
		this.usu_clave = "";
		this.usu_estado = false;
		this.rol_codigo = 0;
	}

	public Logica_Usuario(int parseInt, String text, String text2,
			String text3, String text4, String text5, String text6,
			int rol_codigo2, boolean estado) {
		this.usu_codigo = parseInt;
		this.usu_cedula = text;
		this.usu_nombre = text2;
		this.usu_apellido = text3;
		this.usu_telefono = text4;
		this.usu_direccion = text5;
		this.usu_clave = text6;
		this.usu_estado = estado;
		this.rol_codigo = rol_codigo2;

		// TODO Auto-generated constructor stub
	}

	public void Agregar_Usuario() {
		String cad = "INSERT INTO usuario(usu_codigo,usu_cedula,usu_nombre,usu_apellido,usu_telefono,usu_direccion,usu_clave,usu_estado,rol_codigo)VALUES ('"
				+ usu_codigo
				+ "','"
				+ usu_cedula
				+ "', '"
				+ usu_nombre
				+ "', '"
				+ usu_apellido
				+ "', '"
				+ usu_telefono
				+ "', '"
				+ usu_direccion
				+ "', '"
				+ usu_clave
				+ "', '"
				+ usu_estado
				+ "'," + rol_codigo + " );";
		c.sentencia(cad);

	}

	public void ModificarUsuario(int usu_codigo) {
		String cad = "UPDATE usuario SET usu_cedula='" + usu_cedula
				+ "', usu_nombre='" + usu_nombre + "', usu_apellido='"
				+ usu_apellido + "', usu_telefono='" + usu_telefono
				+ "', usu_direccion='" + usu_direccion + "', usu_clave='"
				+ usu_clave + "', rol_codigo='" + rol_codigo
				+ "', usu_estado =" + usu_estado + " WHERE usu_codigo="
				+ usu_codigo + ";";

		c.sentencia(cad);

	}

	public DefaultTableModel llenargrilla(DefaultTableModel model, String[] cols) {
		
		return m.llenargrilla(model, "SELECT * FROM usuario;", cols);
	}

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

	public String UsuarioNombre(String ced) throws SQLException {
		Conexion c = Conexion.getConn();
		String nombre = null;
		ResultSet r = c
				.consulta("SELECT usu_nombre FROM usuario WHERE usuario.usu_cedula='"
						+ ced + "';");
		while (r.next()) {
			nombre = r.getString(1);

		}
		return nombre;

	}

	public String cantidad() throws SQLException {

		Conexion c = Conexion.getConn();
		String cantidad = null;
		ResultSet r = c.consulta("SELECT count(*) from usuario");
		while (r.next()) {
			cantidad = r.getString(1);

		}
		return cantidad;
	}

	public Vector cedula() throws SQLException {
		Vector arregloCedulas = new Vector();

		Conexion c = Conexion.getConn();
		String cantidad = null;
		ResultSet r = c.consulta("SELECT usu_cedula,usu_nombre,usu_apellido from usuario");
		while (r.next()) {
			arregloCedulas.add((String) r.getObject(1));
			arregloCedulas.add((String) r.getObject(2)+" "+(String) r.getObject(3));

		}

		return arregloCedulas;
	}

	

}
