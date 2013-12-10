/*
 * UNIVERSIDAD TÉCNICA DE MAHCHALA 
 * FACULTAD DE INGENIERÍA CIVIL
 * ESCUELA DE INFORMÁTICA
 * SISTEMA DE FACTURACION
 */
package logica;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import conexion.Conexion;

/**
 * The Class Lg_Validaciones.
 */
public class Lg_Validaciones {

	/** The c. */
	public Conexion c = Conexion.getConn();

	/** The bandera. */
	public boolean bandera = false;

	/** The ncedula. */
	static String ncedula;

	/** The cedula. */
	static int cedula[];

	/** The res. */
	static int res;

	/**
	 * Validar cedula.
	 * 
	 * @param ced
	 *            the ced
	 * @return true, if successful
	 */
	public boolean validarCedula(JTextField ced) {
		ncedula = ced.getText();
		cedula = new int[ncedula.length()];
		res = 0;

		if (cedula.length == 10) {
			for (int i = 0; i < cedula.length; i++) {
				cedula[i] = Integer.parseInt(String.valueOf(ncedula.charAt(i)));
				int r = i % 2;

				if (r == 0) {
					cedula[i] = cedula[i] * 2;
					if (cedula[i] > 9)
						cedula[i] = cedula[i] - 9;
				}

			}

			for (int i = 0; i < cedula.length - 1; i++) {
				res = res + cedula[i];
			}

			res = res % 10;

			if (res != 0)
				res = 10 - res;

			if (res == cedula[9]) {
				System.out.println("CEDULA VALIDA");
				return true;
			} else {
				System.out.println("CEDULA INVALIDA");
				return false;
			}

		} else
			System.out.println("CEDULA INVALIDA");
		return false;

	}

	/**
	 * Llenargrilla. Recive el modelo, la sentencia y un arreglo de palabras y
	 * llena el modelo de tabla por medio de una consulta a la base de datos .
	 * 
	 * @param model
	 *            the model
	 * @param sql
	 *            the sql
	 * @param cols
	 *            the cols
	 * @return the default table model
	 */
	@SuppressWarnings("static-access")
	DefaultTableModel llenargrilla(DefaultTableModel model, String sql,
			String[] cols) {

		try {
			ResultSet r = c.consulta(sql);
			model.setColumnIdentifiers(cols);
			// Hasta que la consulta de un valor de 0
			while (r.next()) {
				Object data[] = new Object[cols.length];
				// llenar el arreglo de objetos con los datos consultados en la
				// base hasta que i no sea mayor que el tamaño del arreglo de
				// objetos
				for (int i = 0; i < data.length; ++i) {
					data[i] = r.getObject(i + 1);
				}
				// insertar una nueva fila con el arreglo de objetos.
				model.addRow(data);
			}

		} catch (Exception e) {
			System.out.println("NO SE LLENO");
		}
		return model;
	}

	/**
	 * Validar numero telefonico. Recie un cuadro de texto en el cual determina
	 * si es un numero de telefono aplicando si tiene 10 caracteres como tambien
	 * validando si es el numero ingresado tiene el formato estandar del pais.
	 * 
	 * @param number
	 *            the number
	 * @return true, if successful
	 */
	public boolean validarNumeroTelefonico(JTextField number) {
		if (number.getText().length() == 10) {
			try {
				String swissNumberStr = number.getText();
				PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

				PhoneNumber swissNumberProto = phoneUtil.parse(swissNumberStr,
						"EC");

				System.out.println(phoneUtil.format(swissNumberProto,
						PhoneNumberFormat.NATIONAL));

				return true;
			} catch (NumberParseException e) {
				JOptionPane.showMessageDialog(null, "numero no valido ");
				return false;
			}
		} else {
			return false;
		}

	}

	/**
	 * Validar numeros. Valida solo campos numerios enteros.
	 * 
	 * @param numero
	 *            the numero
	 * @return true, if successful
	 */
	public boolean validarNumeros(JTextField numero) {

		if (numero.getText().matches("[0-9]*")) {
			return true;
		} else {
			System.out.println("cad1 No es un numero o no es entero");
			return false;
		}
	}

	/**
	 * Validar decimales. Valida si el texto del cuadro de texto que se le envio
	 * es un numero decimal y no sea una letra.
	 * 
	 * @param decimal
	 *            the decimal
	 * @return true, if successful
	 */
	public boolean validarDecimales(JTextField decimal) {
		if (decimal.getText().matches("[0-9]+.[0-9]*")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validacionNombres(JTextField nombre) {
		if (!nombre.getText().matches("[a -zA-ZáéíúÁÉÍÓÚÑñüÜ]{2,30}")) {
			return false;
		}
		return true;
	}

}
