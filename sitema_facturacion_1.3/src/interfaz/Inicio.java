/**
 * 
 */
package interfaz;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author EdwinEverth
 *@version 1.0
 */
public class Inicio {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class<?> clase;
		Method metodo;
		try {
			clase = Class.forName("interfaz.In_Principal");
			// creamos una instancia de nuestra clase desconocida
			Object frm = clase.newInstance();
		//	metodo = clase.getMethod("setVisible");
			metodo = clase.getMethod("run");
			// invocamos el metodo
			metodo.invoke(frm);
		} catch(ClassNotFoundException ex){
			System.out.println("La clase no pudo ser encontrada");
		}
		catch (InstantiationException x) {
		System.out.println("No se pudo crear una instancia de la clase desconocida");
		}
		catch (IllegalAccessException x) {
		System.out.println("No se puede tener acceso a la clase desconocida");
		}
		catch(IllegalArgumentException x){
		System.out.println("Los argumentos para invocar al metodo no son correctos");
		}
		catch(InvocationTargetException x){
		System.out.println("El metodo invocado lanzo una excepcion");
		}
		catch (NoSuchMethodException x) {
		System.out.println("El metodo no pudo ser encontrado");
		}

	}
}
