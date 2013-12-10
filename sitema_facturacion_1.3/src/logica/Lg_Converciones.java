/**
 * 
 */
package logica;

/**
 * @author EdwinEverth
 * @version 1.0
 */
public class Lg_Converciones {
	public String cambio(String nombre) {
		if (nombre.equals("interfaz.In_Usuario")) {
			nombre = "Usuario";
			return nombre;
		} else if (nombre.equals("interfaz.In_Cliente")) {
			nombre = "Cliente";
			return nombre;
		} else if (nombre.equals("interfaz.In_Habitacion")) {
			nombre = "Habitacion";
			return nombre;

		}else if (nombre.equals("interfaz.In_Factura")) {
			nombre="Factura";
			return nombre;
		}else if (nombre.equals("interfaz.In_Reguistros")) {
			nombre="Reguistro Factura";
			return nombre;
		}else if (nombre.equals("interfaz.In_Reportes")) {
			nombre="Reportes";
			return nombre;
		}
		return nombre;

	}
}
