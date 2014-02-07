package conexion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class Conexion.
 */
public class Conexion {

	/** The conn. */
	static Conexion conn;

	/** The driver. */
	private static String driver = "org.postgresql.Driver";

	/** The server. */
	private static String server;

	/** The user. */
	private static String user;

	/** The password. */
	private static String password;

	/** The con. */
	private static Connection con;

	/** The pst. */
	private static PreparedStatement pst;

	/**
	 * Gets the conn.
	 * 
	 * @return una copia de la coneccion con la base de datos.
	 */
	public static Conexion getConn() {
		if (conn == null)
			conn = new Conexion();
		return conn;
	}

	/**
	 * Gets the con.
	 * 
	 * @return obtiene y da la coneccion con la base.
	 */
	public static Connection getCon() {
		return con;
	}

	/**
	 * Instantiates a new conexion.
	 */
	private Conexion() {
		lee();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(server, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Consulta. Realiza una consula a las tablas de la base de datos danto un
	 * parametro de sentecia SQL
	 * 
	 * @param sql
	 *            the sql
	 * @return the result set
	 */
	public static ResultSet consulta(String sql) {
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * Sentencia. Realiza una sentencia SQL en las tablas de base de datos.
	 * 
	 * @param sql
	 *            the sql
	 */
	public  void sentencia(String sql) {
		try {
			pst = con.prepareStatement(sql);

			int r = pst.executeUpdate();
			System.out.println(r);

			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Desconectar. Desconecta el programa con la base de datos
	 */
	public static void desconectar() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lee. Metodo de lecctura de un archivo de texto para inicializar
	 * parametros.
	 */
	@SuppressWarnings("resource")
	private static void lee() {
		try {
			LineNumberReader lee = new LineNumberReader(new FileReader(
					"conf_bd.txt"));
			String s = null;
			// Hacer hasta que la lecctura de la liena de texto sea diferente de
			// vacio
			while ((s = lee.readLine()) != null) {
				String aux[] = s.split("\\s+");
				if (lee.getLineNumber() == 1) {
					server = "jdbc:postgresql://" + aux[1];
				}
				if (lee.getLineNumber() == 2) {
					user = aux[1];
				}
				if (lee.getLineNumber() == 3) {
					password = aux[1];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}