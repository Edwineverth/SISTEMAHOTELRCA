package logica.seguridad;

/**********CLASE DE GESTION DE RECURSO*******/
import java.sql.*;

import javax.swing.table.DefaultTableModel;

import logica.roles.Modulo;
import conexion.*;

public class Seguridad_Modulo {
	public DefaultTableModel datos;
	public Conexion c = Conexion.getConn();
	public String[] columnNames = { "Código", "Nombre", "Descripción" };

	// método que retorna el número de filas
	public int Count() {
		return datos.getRowCount();
	}

	// Constructor
	public Seguridad_Modulo() {
		datos = new DefaultTableModel();
		// asignar etiquetas de columna al modelo de tabla
		for (int i = 0; i < columnNames.length; i++)
			datos.addColumn(columnNames[i]);
	}

	// Métodos que retornan valores de una celda según campos individuales
	public String get_codigo(int pos) {
		return datos.getValueAt(pos, 0).toString();
	}

	public String get_nombre(int pos) {
		return datos.getValueAt(pos, 1).toString();
	}

	public String get_descripcion(int pos) {
		return datos.getValueAt(pos, 2).toString();
	}

	// agrega la nueva fila
	public void addFila(Modulo ob) {
		Object[] row = { new Long(ob.mod_codigo), new String(ob.mod_nombre),
				new String(ob.mod_descripcion) };
		datos.addRow(row);
	}

	// limpia todos los datos del Modelo de tabla
	public void reset() {
		while (Count() > 0)
			datos.removeRow(Count() - 1);
	}

	// Retorna el modelo de tabla
	public DefaultTableModel getTablaDatos() {
		return datos;
	}

	/******** Métodos de acceso a la base de datos */

	// rellena el modelo de table según los resultados obtenidos de la BD
	public void rellenar(ResultSet rs) {
		try {
			Modulo ob = new Modulo();
			// reset(); //limpia la lista de productos
			while (rs.next()) {
				ob.mod_codigo = Integer.parseInt(rs.getObject("mod_codigo")
						.toString());
				ob.mod_nombre = rs.getObject("mod_nombre").toString();
				ob.mod_descripcion = rs.getObject("mod_descripcion").toString();
				addFila(ob);
				System.out.println(ob.mod_nombre);
			}
		} catch (Exception ex) {
		}
	}

	// consulta todos los elementos de la tabla productos
	public void consultaAll() {
		String str = "select * from \"Modulo\"";

		ResultSet rs = null;
		try {
			rs = c.consulta(str);
			rellenar(rs);
			rs.close();
		} catch (Exception ex) {
		}
	}

	// consulta los elementos segun la descripción
	public void consulta_nombre(String Nombre) {
		String str = "select * from \"Modulo\" where mod_codigo=" + Nombre;
		ResultSet rs = null;
		try {
			rs = c.consulta(str);
			rellenar(rs);
			rs.close();
		} catch (Exception ex) {
			System.out.println("Error?");
		}
	}

	// inserta un registro en la base de datos
	public boolean insertar(Modulo ob) {
		String str = "insert into \"Modulo\" values(";
		str += "'" + ob.mod_codigo + "'";
		str += "'" + ob.mod_nombre + "'";
		str += "'" + ob.mod_descripcion + "'";
		str += ")";
		boolean estado = false;
		try {
			c.sentencia(str);
			estado = true;
		} catch (Exception ex) {
			estado = false;
		}
		return estado;
	}

}
