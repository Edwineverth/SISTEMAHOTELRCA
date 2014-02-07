/**
 * 
 */
package logica.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import conexion.Conexion;
import logica.validaciones.Validaciones;

public class Lg_Cliente {
	private int cli_codigo;
	private String cli_cedula;
	private String cli_nombre;
	private String cli_apellido;
	private String cli_telefono;
	private String cli_direccion;
	private String cli_ocupacion;
	private String cli_procedencia;
	private String cli_tipo;
	private boolean cli_estado;
	protected Validaciones m = new Validaciones();
	private Conexion c = Conexion.getConn();

	/**
	 * @param cli_codigo
	 * @param cli_cedula
	 * @param cli_nombre
	 * @param cli_apellido
	 * @param cli_telefono
	 * @param cli_direccion
	 * @param cli_ocupacion
	 * @param cli_procedencia
	 * @param cli_tipo
	 * @param cli_estado
	 */
	public Lg_Cliente(int cli_codigo, String cli_cedula, String cli_nombre,
			String cli_apellido, String cli_telefono, String cli_direccion,
			String cli_ocupacion, String cli_procedencia, String cli_tipo,
			boolean cli_estado) {
		super();
		this.cli_codigo = cli_codigo;
		this.cli_cedula = cli_cedula;
		this.cli_nombre = cli_nombre;
		this.cli_apellido = cli_apellido;
		this.cli_telefono = cli_telefono;
		this.cli_direccion = cli_direccion;
		this.cli_ocupacion = cli_ocupacion;
		this.cli_procedencia = cli_procedencia;
		this.cli_tipo = cli_tipo;
		this.cli_estado = cli_estado;
	}

	public Lg_Cliente() {
		this.cli_codigo = 0;
		this.cli_cedula = "";
		this.cli_nombre = "";
		this.cli_apellido = "";
		this.cli_telefono = "";
		this.cli_direccion = "";
		this.cli_ocupacion = "";
		this.cli_procedencia = "";
		this.cli_tipo = "";
		this.cli_estado = true;

	}

	public void AgregarCliente() {
		String cad = "INSERT INTO cliente (cli_codigo,cli_cedula,cli_nombre,cli_apellido,cli_telefono,cli_direccion,cli_ocupacion,cli_procedencia,cli_tipo,cli_estado)"
				+ " VALUES ('"
				+ cli_codigo
				+ "','"
				+ cli_cedula
				+ "', '"
				+ cli_nombre
				+ "', '"
				+ cli_apellido
				+ "', '"
				+ cli_telefono
				+ "', '"
				+ cli_direccion
				+ "','"
				+ cli_ocupacion
				+ "','"
				+ cli_procedencia
				+ "','"
				+ cli_tipo
				+ "',"
				+ cli_estado
				+ " );";
		c.sentencia(cad);

	}

	public void ModificarCliente(int cli_codigo) {
		String cad = "UPDATE cliente SET cli_cedula='" + cli_cedula
				+ "', cli_nombre='" + cli_nombre + "', cli_apellido='"
				+ cli_apellido + "', cli_telefono='" + cli_telefono
				+ "', cli_direccion='" + cli_direccion + "', cli_ocupacion ='"
				+ cli_ocupacion + "', cli_procedencia ='" + cli_procedencia
				+ "', cli_tipo ='" + cli_tipo + "', cli_estado =" + cli_estado
				+ " WHERE cli_codigo=" + cli_codigo + ";";

		c.sentencia(cad);

	}

	public DefaultTableModel llenargrilla(DefaultTableModel model, String[] cols) {
	
		return m.llenargrilla(model, "SELECT * FROM cliente;", cols);
	}

	public Vector cedulaCliente() throws SQLException {
		Vector arregloCedulas = new Vector();
		Conexion c = Conexion.getConn();
		ResultSet r = c
				.consulta("SELECT cli_cedula,cli_nombre,cli_apellido from cliente");
		while (r.next()) {
			arregloCedulas.add((String) r.getObject(1));

			arregloCedulas.add((String) r.getObject(2) + " "
					+ (String) r.getObject(3));

		}
		return arregloCedulas;

	}

	public Vector cedulaClientee() throws SQLException {
		Vector arregloCedulas = new Vector();
		Conexion c = Conexion.getConn();
		ResultSet r = c
				.consulta("SELECT cli_cedula,cli_nombre,cli_apellido from cliente");
		while (r.next()) {
			arregloCedulas.add((String) r.getObject(1));
			arregloCedulas.add((String) r.getObject(2));

		}
		return arregloCedulas;

	}
	
	
	public String cantidad() throws SQLException {

		Conexion c = Conexion.getConn();
		String cantidad = null;
		ResultSet r = c.consulta("SELECT count(*) from cliente");
		while (r.next()) {
			cantidad = r.getString(1);

		}
		return cantidad;
	}
	

	public static void main(String[] args) throws SQLException {
		Lg_Cliente c = new Lg_Cliente();
		for (int i = 0; i < c.cedulaCliente().size(); i++) {
			System.out.println(c.cedulaCliente().get(i));

		}
	}

}
