/**
 * 
 */
package logica.dinamismo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import conexion.Conexion;

/**
 * @author Dell Inspiron
 * @version 1.0
 */
public class InstanciaObejtos {

	

	public String consultaRecurso(String consulta) {
		Conexion c = Conexion.getConn();
		String nombre = "";
		try {
			ResultSet r = c
					.consulta("SELECT  \"Recurso\".rec_ruta FROM  \"Recurso\" WHERE '"
							+ consulta + "' = \"Recurso\".rec_nombre;");
			while (r.next()) {

				nombre = r.getString(1);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		return nombre;

	}

}
