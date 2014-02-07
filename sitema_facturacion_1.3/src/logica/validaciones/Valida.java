/**
 * 
 */
package logica.validaciones;

import java.util.Scanner;

/**
 * @author Dell Inspiron
 * @version 1.0
 */
public class Valida {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		System.out.println("INGRESO");
		Valida v = new Valida();
		if (v.valida(lector.next())) {
			System.out.println("si");
		} else {
			System.out.println("no");
		}
	}

	public boolean valida(String c) {
		if (c.matches("[a-zA-Z]*")) {
			return true;
		}
		return false;

	}

	
}
