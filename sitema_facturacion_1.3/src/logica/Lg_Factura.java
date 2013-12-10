package logica;

import java.sql.ResultSet;
import java.sql.SQLClientInfoException;

import javax.swing.table.DefaultTableModel;

import conexion.Conexion;

/**
 * The Class Lg_Factura.
 */
public class Lg_Factura {

	/** The c. */
	public Conexion c = Conexion.getConn();

	/** The m. */
	Lg_Validaciones  m = new Lg_Validaciones();

	/** The fac_codigo. */
	int fac_codigo;

	/** The fac_fecha. */
	String fac_fecha;

	/** The cli_codigo. */
	int cli_codigo;

	/** The total. */
	public double total;

	/** The subtotal. */
	public double subtotal;

	/** The iva. */
	public double iva;

	/**
	 * Instantiates a new lg_ factura.
	 */
	public Lg_Factura() {
		fac_codigo = 0;
		fac_fecha = null;
		cli_codigo = 0;
		total = 0;
		subtotal = 0;
		iva = 0;
	}

	/**
	 * Instantiates a new lg_ factura.
	 * 
	 * @param fac_codigo
	 *            the fac_codigo
	 * @param fac_fecha
	 *            the fac_fecha
	 * @param cli_codigo
	 *            the cli_codigo
	 */
	public Lg_Factura(int fac_codigo, String fac_fecha, int cli_codigo) {
		this.fac_codigo = fac_codigo;
		this.fac_fecha = fac_fecha;
		this.cli_codigo = cli_codigo;
	}

	/**
	 * Agregar factura. Envia y ejecuta una sentencia SQL de insercion de un
	 * nuevo numero de factura.
	 * 
	 * @param total1
	 *            the total1
	 * @param subtotal1
	 *            the subtotal1
	 * @param iva1
	 *            the iva1
	 */
	@SuppressWarnings("static-access")
	public void AgregarFactura(double total1, double subtotal1, double iva1) {
		String cad = "INSERT INTO factura ( fac_codigo,total, cli_codigo, estado, subtotal, iva,fecha) VALUES ('"
				+ fac_codigo
				+ "','"
				+ total1
				+ "', '"
				+ cli_codigo
				+ "', true, '"
				+ subtotal1
				+ "','"
				+ iva1
				+ "','"
				+ fac_fecha
				+ "');";

		c.sentencia(cad);

	}

	/**
	 * Agregar factura de. Envia y ejecuta una sentencia SQL de insercion un
	 * nuevo numero en la tabla detallefactura
	 * 
	 * @param fac_codigo
	 *            the fac_codigo
	 * @param hab_codigo
	 *            the hab_codigo
	 * @param cantida
	 *            the cantida
	 * @param cli_codigo
	 *            the cli_codigo
	 * @param totalpro
	 *            the totalpro
	 * @param tha_codigo
	 *            the tha_codigo
	 * @param chb_codigo
	 *            the chb_codigo
	 */
	@SuppressWarnings("static-access")
	public void AgregarFacturaDe(int fac_codigo, int hab_codigo, int cantida,
			int cli_codigo, double totalpro, int tha_codigo, int chb_codigo) {
		String cad = "INSERT INTO detalleFactura (fac_codigo, hab_codigo, cantidad, cli_codigo, totalhab, tha_codigo, chb_codigo) VALUES ("
				+ fac_codigo
				+ ","
				+ hab_codigo
				+ ",  "
				+ cantida
				+ ","
				+ cli_codigo
				+ ","
				+ totalpro
				+ ","
				+ tha_codigo
				+ ","
				+ chb_codigo +

				");";

		c.sentencia(cad);

	}

	/**
	 * Modificar factura. Envia y ejecuta una sentencia SQL de actualizacion de
	 * la tabla factura para cambiar el estado.
	 * 
	 * @param fac_codigo
	 *            the fac_codigo
	 */
	@SuppressWarnings("static-access")
	public void ModificarFactura(int fac_codigo) {
		String cad = "UPDATE factura SET  estado =" + " WHERE fac_codigo="
				+ fac_codigo + ";";

		c.sentencia(cad);

	}

	/**
	 * Consulta. Envia yejecuta una consulta SQL para seleccionar el numero de la
	 * tabla por medio de un codigo para luego llevar un arreglo de objetos con
	 * los datos que hay la tabla seleccionada.
	 * 
	 * @param cod
	 *            the cod
	 * @return the object[]
	 */
	@SuppressWarnings("static-access")
	public Object[] consulta(int cod) {
		String cad = "SELECT * FROM habitacion WHERE hab_codigo=" + cod + ";";
		Object data[] = null;

		try {
			ResultSet r = c.consulta(cad);
			while (r.next()) {
				data = new Object[5];
				for (int i = 0; i < data.length; ++i) {
					data[i] = r.getObject(i + 1);
				}
			}

		} catch (Exception e) {

		}
		return data;
	}

	/**
	 * Calcular. Ejecuta una operacion de calculo simple para determinar el
	 * subtoal iva y total de la factura.
	 * 
	 * @param parse
	 *            the parse
	 */
	public void calcular(double parse) {
		subtotal += parse;
		iva += (subtotal * 0.12);
		total += (subtotal + iva);
	}

	/**
	 * Cedula. Ejecuta una consulta SQL para determinar si se encuentra en la
	 * tabla la cedula dada.
	 * 
	 * @param cedula
	 *            the ced
	 * @return the string
	 */
	@SuppressWarnings("static-access")
	public String cedula(String cedula) {

		String ced = "";
		try {
			ResultSet r = c
					.consulta("SELECT cli_codigo  FROM cliente WHERE cedula = '"
							+ cedula + "';");
			while (r.next()) {
				ced = r.getString(1);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return ced;
	}

	/**
	 * Registros. Envia y ejecuta una sentencia SQL para determinar el nuemro de
	 * registros que hay en la tabla de factura
	 * 
	 * @return the int
	 */
	@SuppressWarnings("static-access")
	public int registros() {

		int cant = 0;
		try {
			ResultSet r = c.consulta("SELECT Count (*) FROM factura;");
			while (r.next()) {
				cant = r.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return cant;
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
		return m.llenargrilla(
				model,
				"SELECT fac_codigo,cli_codigo,fac_fecha,fac_subtotal,fac_iva,fac_total FROM factura;",
				cols);
	}

}
