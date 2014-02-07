package logica.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import logica.validaciones.*;
import conexion.Conexion;

public class Lg_Factura {
	protected int fac_codigo;
	protected double fac_servicio;
	protected double fac_subtotal;
	protected double fac_iva;
	protected double fac_total;
	protected String fac_fecha;
	protected boolean fac_estado;
	protected int form_codigo;
	protected int rec_codigo;
	protected int usu_codigo;
	protected Conexion c = Conexion.getConn();
	protected Object[] vector;

	public Lg_Factura() {
		this.fac_codigo = 0;
		this.fac_servicio = 0;
		this.fac_subtotal = 0;
		this.fac_iva = 0;
		this.fac_total = 0;
		this.fac_fecha = "";
		this.fac_estado = true;
		this.form_codigo = 0;
		this.rec_codigo = 0;
		this.usu_codigo = 0;

	}

	public Lg_Factura(int fac_codigo, double fac_servicio, double fac_subtotal,
			double fac_iva, double fac_total, String fac_fecha,
			boolean fac_estado, int form_codigo, int rec_codigo, int usu_codigo) {
		super();
		this.fac_codigo = fac_codigo;
		this.fac_servicio = fac_servicio;
		this.fac_subtotal = fac_subtotal;
		this.fac_iva = fac_iva;
		this.fac_total = fac_total;
		this.fac_fecha = fac_fecha;
		this.fac_estado = fac_estado;
		this.form_codigo = form_codigo;
		this.rec_codigo = rec_codigo;
		this.usu_codigo = usu_codigo;
	}

	public void AgregarFactura(double total1, double subtotal1, double iva1,
			double servicio1) {
		String cad = "insert into factura (fac_codigo,fac_servicio,fac_subtotal,fac_iva,fac_total,fac_fecha,fac_estado,form_codigo,rec_codigo,usu_codigo) VALUES ("
				+ fac_codigo
				+ ","
				+ servicio1
				+ ","
				+ subtotal1
				+ ","
				+ iva1
				+ ","
				+ total1
				+ ",'"
				+ fac_fecha
				+ "',"
				+ fac_estado
				+ ","
				+ form_codigo + "," + rec_codigo + "," + usu_codigo + ")";
		c.sentencia(cad);

	}

	public void AgregarFacturaDe(double total1, double subtotal1, double iva1,
			double servicio1, double preciou, String descripccion,
			String convertido) {
		String cad = "insert into detalle_factura (fac_codigo,det_fecha,det_descipcion,det_preciou,det_subtotal,det_iva,det_servicio,det_total,det_numero_letra,form_codigo) VALUES ("
				+ fac_codigo
				+ ",'"
				+ fac_fecha
				+ "','"
				+ descripccion
				+ "',"
				+ preciou
				+ ","
				+ subtotal1
				+ ","
				+ iva1
				+ ","
				+ servicio1
				+ "," + total1 + ",'" + convertido + "'," + form_codigo + ");";

		c.sentencia(cad);

	}

	public void nombre(String cad, String nom, String ape) throws SQLException {
		Object[] data = new Object[10];
		@SuppressWarnings("static-access")
		ResultSet r = c.consulta("SELECT * FROM cliente WHERE cli_cedula='"
				+ cad + "'or cli_nombre like '" + nom
				+ "' or cli_apellido like '" + ape + "'  ");
		while (r.next()) {

			for (int i = 0; i < data.length; ++i) {
				data[i] = r.getObject(i + 1);
			}

		}
		vector = data;

	}

	public String codigoHab(String cod) throws SQLException {
		String codigoHab = null;
		@SuppressWarnings("static-access")
		ResultSet r = c
				.consulta("SELECT hab_codigo  FROM recervacion WHERE cli_codigo = '"
						+ cod + "';");
		while (r.next()) {
			codigoHab = r.getString(1);
		}
		return codigoHab;

	}

	public String precioHab(String cod) throws SQLException {
		String precioHab = null;
		@SuppressWarnings("static-access")
		ResultSet r = c
				.consulta("SELECT hab_precio  FROM habitacion WHERE hab_codigo = '"
						+ cod + "';");
		while (r.next()) {
			precioHab = r.getString(1);
		}
		return precioHab;

	}

	public String n_hab(String codigo) throws SQLException {
		String precioHabitacion = null;
		@SuppressWarnings("static-access")
		ResultSet r = c
				.consulta("SELECT hab_precio FROM habitacion WHERE cli_codigo='"
						+ codigo + "' ");
		while (r.next()) {
			precioHabitacion = r.getString(1);

		}

		return precioHabitacion;
	}

	public double CalculoSubtotal(double total) {
		double subtotal = 0;
		subtotal = total / 1.12;
		return subtotal;
	}

	public double CalculoIva(double subtotal, double total) {

		double iva = 0;
		iva = total - subtotal;
		return iva;

	}

	public double redondear(double numero, int decimales) {
		return Math.round(numero * Math.pow(10, decimales))
				/ Math.pow(10, decimales);
	}

	public Object[] getVector() {
		return vector;
	}

	public String codigorecurso(String cod, String fecha) throws SQLException {
		Conexion c = Conexion.getConn();
		String nombre = null;
		ResultSet r = c
				.consulta("select rec_codigo from recervacion where usu_codigo ="
						+ cod + " and rec_fechafin = '" + fecha + "';");
		while (r.next()) {
			nombre = r.getString(1);

		}
		return nombre;

	}
	
	
	public Vector cantidadrecervas() throws SQLException {
		Vector arreglorecervaciones = new Vector();
		Conexion c = Conexion.getConn();
		ResultSet r = c
				.consulta("SELECT rec_codigo from recervacion");
		while (r.next()) {
			arreglorecervaciones.add((String) r.getObject(0));
			

		}
		return arreglorecervaciones;

	}

	public String conteorecerva(String ced) throws SQLException {
		Conexion c = Conexion.getConn();
		String conteo = null;
		ResultSet r = c
				.consulta("select count (*) from habitacion where hab_codigo = any (select hab_codigo from recervacion where cli_codigo = any (select cli_codigo from cliente where cli_cedula = '"
						+ ced + "'))");
		while (r.next()) {
			conteo = r.getString(1);

		}
		return conteo;

	}
	public void vaciar (){
		String cad = "delete from detalle_factura";
		c.sentencia(cad);
	}

}
