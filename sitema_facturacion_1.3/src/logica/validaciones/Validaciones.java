package logica.validaciones;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

import conexion.Conexion;

public class Validaciones {

	public Conexion c = Conexion.getConn();
	public boolean bandera = false;
	static String ncedula;
	static int cedula[];
	static int res;

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

	public DefaultTableModel llenargrilla(DefaultTableModel model, String sql,
			String[] cols) {

		try {
			ResultSet r = c.consulta(sql);
			model.setColumnIdentifiers(cols);

			while (r.next()) {
				Object data[] = new Object[cols.length];

				for (int i = 0; i < data.length; ++i) {
					data[i] = r.getObject(i + 1);
				}

				model.addRow(data);
			}

		} catch (Exception e) {
			System.out.println("NO SE LLENO");
		}
		return model;
	}

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

	public boolean validarDecimales(JTextField decimal) {
		if (decimal.getText().matches("[0-9]+.[0-9]*")) {
			return true;
		} else {
			return false;
		}
	}

	
	public void validaNombre(KeyEvent evt) {
		char car = evt.getKeyChar();        
		if((car<'a' || car>'z') && (car<'A' || car>'Z')             
		    && car !='á'             
		    && car !='é'            
		    && car !='í'            
		    && car !='ó'           
		    && car !='ú'   
		    && car !='Á'             
		    && car !='É'            
		    && car !='Í'            
		    && car !='Ó'           
		    && car !='Ú'             
		    && (car!=(char)KeyEvent.VK_SPACE))
		{      
		  evt.consume();   
		}
	}
	public void validaClave(KeyEvent evt, JTextField clave) {
		char car = evt.getKeyChar();
		if(clave.getText().length()>=16) evt.consume();
		if((car<'0' || car>'9')) evt.consume();
		
	}
	public void validaNumeros(KeyEvent evt) {
		char car = evt.getKeyChar();
		if((car<'0' || car>'9')) evt.consume();
		
	}
	

}
