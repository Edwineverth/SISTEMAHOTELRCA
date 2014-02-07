/**
 * 
 */
package logica.entidades;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import logica.roles.Nodo;
import logica.roles.Persistencia;
import logica.validaciones.Validaciones;
import conexion.Conexion;

public class Lg_Habitacion {
	public Conexion c = Conexion.getConn();
	public Persistencia fichero = new Persistencia();
	private Validaciones m = new Validaciones();
	private int hab_codigo;
	private Double hab_precio;
	private boolean hab_estado;
	private int tip_codigo_hab;
	private int cat_codigo;

	public Lg_Habitacion() {
		this.hab_codigo = 0;
		this.hab_precio = 0.0;
		this.hab_estado = true;
		this.tip_codigo_hab = 0;
		this.cat_codigo = 0;
	}

	public Lg_Habitacion(int hab_codigo, Double hab_precio, boolean hab_estado,
			int tip_codigo_hab, int cat_codigo) {

		this.hab_codigo = hab_codigo;
		this.hab_precio = hab_precio;
		this.hab_estado = hab_estado;
		this.tip_codigo_hab = tip_codigo_hab;
		this.cat_codigo = cat_codigo;
	}

	public void agregarHabitacionCliente() {
		String cad = "INSERT INTO habitacion ( hab_codigo, hab_precio, hab_estado,tip_codigo_hab,cat_codigo) VALUES ("
				+ hab_codigo
				+ ","
				+ hab_precio
				+ ", "
				+ hab_estado
				+ ", " + tip_codigo_hab + ", " + cat_codigo + " );";

		c.sentencia(cad);

	}

	public void ModificarHabitacion(int hab_codigo) {
		String cad = "UPDATE habitacion SET hab_precio=" + hab_precio
				+ ", hab_estado=" + hab_estado + "', tip_codigo_hab ="
				+ tip_codigo_hab + ", cat_codigo =" + cat_codigo
				+ " WHERE hab_codigo=" + hab_codigo + ";";

		c.sentencia(cad);

	}

	public DefaultTableModel llenargrilla(DefaultTableModel model, String[] cols) {
		return m.llenargrilla(model, "SELECT * FROM habitacion;", cols);
	}
	
	public Vector numeroHabitacion() throws SQLException {
		Vector arregloNumeroHabitaciones = new Vector();
		Conexion c = Conexion.getConn();
		ResultSet r = c.consulta("SELECT hab_codigo from habitacion");
		while (r.next()) {
			arregloNumeroHabitaciones.add(String.valueOf( r.getObject(1)));

		}
		return arregloNumeroHabitaciones;
	}
	
	
	public String cantidad() throws SQLException {

		Conexion c = Conexion.getConn();
		String cantidad = null;
		ResultSet r = c.consulta("SELECT count(*) from habitacion");
		while (r.next()) {
			cantidad = r.getString(1);

		}
		return cantidad;
	}
	

}
