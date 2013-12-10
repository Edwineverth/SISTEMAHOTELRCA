/**
 * 
 */
package logica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The Class Archivos.
 */
public class Persistencia {

	/**
	 * Guardar fichero. Guarda el archivo dado un nombre y un objeto el cual
	 * serializa todo el objeto con todos los datos y asigna al archivo
	 * 
	 * @param archivo
	 *            the archivo
	 * @param nodo
	 *            the nodo
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void guardarFichero(String archivo, Object nodo) throws IOException {
		ObjectOutputStream salida = new ObjectOutputStream(
				new FileOutputStream(archivo + ".obj"));
		salida.writeObject(nodo);
		salida.close();
	}

	/**
	 * Cargar fichero. Recive como parametro e nombre del archivo deserializa el
	 * archivo y lo guarda en un nodo el cual contiene todos los datos del
	 * archivo
	 * 
	 * @param archivo
	 *            the archivo
	 * @return the nodo
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public Nodo cargarFichero(String archivo) throws IOException,
			ClassNotFoundException {
		try {
			ObjectInputStream entrada = new ObjectInputStream(
					new FileInputStream(archivo + ".obj"));
			Nodo nodo = (Nodo) entrada.readObject();
			entrada.close();
			return nodo;
		} catch (IOException e2) {
			return null;
		} catch (ClassNotFoundException e2) {
			System.out.println("no se encontro el archivo");
			return null;
		}

	}
}
