/**Re
 * 
 */
package logica;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.Vector;
import interfaz.*;

import conexion.Conexion;

/**
 * @author EdwinEverth
 * @version 1.0
 */
public class Lg_Recursos {
	public static void main(String[] args) {
		Lg_Recursos recursos = new Lg_Recursos();

		// recursos.asignacionRecursos(1);
		// System.out.println(recursos.asignacionRecursos(1).size());
		for (int i = 0; i < recursos.asignacionModulos(1).size(); i++) {
			System.out.println(recursos.asignacionModulos(1).get(i));
		}

	}
//
	public Vector asignacionRecursos(int permiso) {
		Vector vector = new Vector();
		Conexion c = Conexion.getConn();
		try {
			ResultSet r = c
					.consulta("SELECT  recurso.rec_nombre FROM  recurso WHERE "
							+ permiso + " = recurso.tus_codigos;");
			while (r.next()) {

				vector.add(r.getString(1));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return vector;

	}

	public Vector asignacionModulos(int num) {
		Vector vector = new Vector<>();
		Conexion c = Conexion.getConn();
		try {
			ResultSet r = c
					.consulta("SELECT recurso.mod_codigo FROM modulo,recurso,usuario WHERE "
							+ num + " = recurso.tus_codigos AND '0705709806' = usuario.usu_cedula;");
			while (r.next()) {

				vector.add(r.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return vector;

	}
}
