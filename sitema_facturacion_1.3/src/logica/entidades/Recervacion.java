/**
 * 
 */
package logica.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import logica.validaciones.Validaciones;
import conexion.Conexion;

public class Recervacion {
	private int rec_codigo;
	private String fecha;
	private String fechafin;
	private int cli_codigo;
	private int hab_codigo;
	private int usu_codigo;
	protected Validaciones m = new Validaciones();
	private Conexion c = Conexion.getConn();

	public Recervacion() {
		this.rec_codigo = 0;
		this.fecha = "";
		this.fechafin = "";
		this.cli_codigo = 0;
		this.hab_codigo = 0;
		this.usu_codigo = 0;
	}

	public Recervacion(int rec_codigo, String fecha, String fechafin,
			int cli_codigo, int hab_codigo, int usu_codigo) {
		super();
		this.rec_codigo = rec_codigo;
		this.fecha = fecha;
		this.fechafin = fechafin;
		this.cli_codigo = cli_codigo;
		this.hab_codigo = hab_codigo;
		this.usu_codigo = usu_codigo;
	}

	public void AgregarRecervacion() {
		String cad = " INSERT INTO  recervacion(rec_codigo,rec_fecha,rec_fechafin,cli_codigo,hab_codigo,usu_codigo) VALUES ( "
				+ rec_codigo
				+ ",'"
				+ fecha
				+ "','"
				+ fechafin
				+ "',"
				+ cli_codigo + "," + hab_codigo + "," + usu_codigo + " );  ";
		c.sentencia(cad);

	}

	public DefaultTableModel llenargrilla(DefaultTableModel model, String[] cols) {
		return m.llenargrilla(model, "SELECT * FROM recervacion;", cols);
	}

	public String consultaCedCliente(String ced) throws SQLException {
		String nombreCliente = null;
		ResultSet r = c
				.consulta("SELECT cli_nombre  FROM cliente WHERE cli_cedula = '"
						+ ced + "';");

		while (r.next()) {

			nombreCliente = r.getString(1);
			System.out.println(nombreCliente);
		}

		return nombreCliente;
	}
	public String consultaCodigoCliente(String ced) throws SQLException {
		String codigoCliente = null;
		ResultSet r = c
				.consulta("SELECT cli_codigo  FROM cliente WHERE cli_cedula = '"
						+ ced + "' or cli_nombre = '"+ced +"';");

		while (r.next()) {

			codigoCliente = r.getString(1);
			System.out.println(codigoCliente);
		}

		return codigoCliente;
		
	}
	public String codigoUsuario(String ced) throws SQLException {
		String codigoUsuario = null;
		ResultSet r = c
				.consulta("SELECT usu_codigo  FROM usuario WHERE usu_cedula = '"
						+ ced + "';");

		while (r.next()) {

			codigoUsuario = r.getString(1);
			System.out.println(codigoUsuario);
		}

		return codigoUsuario;
		
	}
	public String nombreCliente(String ced) throws SQLException {
		String nombreCli = null;
		ResultSet r = c
				.consulta("SELECT cli_nombre  FROM cliente WHERE cli_cedula = '"
						+ ced + "';");

		while (r.next()) {

			nombreCli = r.getString(1);
			System.out.println(nombreCli);
		}
		
		
		return nombreCli;
		
	}
	public String nombreUsuario(String ced) throws SQLException {
		String nombreUsu = null;
		ResultSet r = c
				.consulta("SELECT usu_nombre  FROM usuario WHERE usu_cedula = '"
						+ ced + "';");

		while (r.next()) {

			nombreUsu = r.getString(1);
			System.out.println(nombreUsu);
		}
		
		
		return nombreUsu;
		
	}
	public String conteo() throws SQLException{
		String conteo = null;
		ResultSet r = c
				.consulta("SELECT count(*)  FROM usuario ;");

		while (r.next()) {

			conteo = r.getString(1);
			System.out.println(conteo);
		}
		
		return conteo;
		
	}
	
	
	public String cantidad() throws SQLException {

		Conexion c = Conexion.getConn();
		String cantidad = null;
		ResultSet r = c.consulta("SELECT count(*) from recervacion");
		while (r.next()) {
			cantidad = r.getString(1);

		}
		return cantidad;
	}
	

}
