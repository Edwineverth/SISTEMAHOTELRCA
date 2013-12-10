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
		
			//recursos.asignacionRecursos(1);
			System.out.println(recursos.asignacionRecursos(1).size());
			for (int i = 0; i < recursos.asignacionRecursos(1).size(); i++) {
				System.out.println(recursos.asignacionRecursos(1).get(i));
			}
			
	}

	public Vector asignacionRecursos(int permiso) {
		Vector vector = new Vector();
		Conexion c = Conexion.getConn();
		try {
			ResultSet r = c
					.consulta("SELECT  recurso.rec_nombre FROM  recurso WHERE "+permiso+" = recurso.tus_codigos;");
			while (r.next()) {
				
				vector.add(r.getString(1));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return vector;

	}

	public Vector asignacionModulos(String cedula) {
		Vector vector = new Vector<>();
		Conexion c = Conexion.getConn();
		try {
			ResultSet r = c
					.consulta("SELECT  recurso.rec_nombre FROM  usuario, tus_usuario,permisos,recurso WHERE  usuario.tus_codigos = tus_usuario.tus_codigos AND permisos.tus_codigos = tus_usuario.tus_codigos AND permisos.tus_codigos = permisos.rec_codigo AND usuario.usu_cedula ='"
							+ cedula + "'  ;");

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
}
