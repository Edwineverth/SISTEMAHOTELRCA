package interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import org.jvnet.substance.SubstanceLookAndFeel;
import conexion.Conexion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import logica.roles.*;
import logica.seguridad.Logica_Usuario;
import logica.seguridad.Seguridad_Roles;

public class Prueba_inicio extends JFrame {
	public Prueba_inicio() {
	}

	/** The ventana. */
	static JFrame ventana = new JFrame();

	/** The panel. */
	JPanel panel = new JPanel();

	/** The user. */
	static JTextField user = new JTextField();;

	/** The pass. */

	public static JPasswordField pass = new JPasswordField();

	/** The ced. */
	public static String ced = "";

	/** The barra. */
	static JProgressBar barra;

	/** The cargando. */
	static JLabel cargando = new JLabel("CARGANDO...");
	/** The pas. */
	static String pas = "";
	public static Seguridad_Roles roles = new Seguridad_Roles();
	public static Logica_Usuario  usuario = new Logica_Usuario();

	

	/**
	 * The main method.
	 * 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Prueba_inicio interfaz = new Prueba_inicio();
		interfaz.componentes();
		Conexion c = Conexion.getConn();
	}

	/**
	 * Deco.
	 */
	public void decorar() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		SubstanceLookAndFeel
				.setCurrentTheme("org.jvnet.substance.theme.SubstanceBrownTheme");
		SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistAquaSkin");
		SubstanceLookAndFeel
				.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceLatchWatermark");
		SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(1.0));

	}

	/**
	 * Componentes.
	 */
	public void componentes() {
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"imagenes/facturacion.png"));
		ventana.setTitle("FACTURE OFFICE");
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventana.setSize(810, 500);

		ventana.setLocationRelativeTo(null);

		decorar();

		panel.setLayout(null);

		user.setBounds(285, 143, 160, 20);
		panel.add(user);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imagenes/usu.png"));
		lblNewLabel.setBounds(455, 126, 46, 50);
		panel.add(lblNewLabel);

		pass.setBounds(285, 212, 160, 20);
		panel.add(pass);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("imagenes/key.png"));
		lblNewLabel_1.setBounds(455, 195, 60, 80);
		panel.add(lblNewLabel_1);

		JLabel prin_login = new JLabel("USUARIO");
		prin_login.setFont(new Font("Tahoma", Font.BOLD, 13));
		prin_login.setBounds(185, 146, 89, 14);
		prin_login.setForeground(new Color(230, 221, 46));
		panel.add(prin_login);

		JLabel prin_pass = new JLabel("CONTRASEÑA");
		prin_pass.setFont(new Font("Tahoma", Font.BOLD, 13));
		prin_pass.setBounds(185, 215, 100, 14);
		prin_pass.setForeground(new Color(230, 221, 46));
		panel.add(prin_pass);

		JButton login = new JButton("Aceptar");
		login.setBounds(320, 256, 89, 23);
		login.setForeground(new Color(55, 130, 47));
		login.setFont(new Font("Tahoma", Font.BOLD, 13));
		login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(login);

		barra = new JProgressBar(0, 100);
		barra.setBounds(185, 320, 400, 10);
		cargando.setBounds(285, 300, 160, 20);
		cargando.setForeground(SystemColor.activeCaption);
		panel.add(cargando);
		panel.add(barra);
		barra.setVisible(false);
		cargando.setVisible(false);

		login.addActionListener(new Escucha());
		ventana.getContentPane().add(panel);

		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon("imagenes/fondo.jpg"));
		fondo.setBounds(0, 0, 800, 488);
		panel.add(fondo);
		ventana.getContentPane().add(panel);
		ventana.setVisible(true);

	}

	public static class Escucha implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			cargando.setVisible(true);
			barra.setVisible(true);
			new Thread(new Hilo()).start();

		}
	}

	public static class Hilo implements Runnable {
		public void run() {
			// hacer hasta que i sea menor igual a 100
			for (int i = 0; i <= 100; i++) {
				barra.setValue(i);
				barra.repaint();
				try {
					Thread.sleep(3);
				} catch (Exception e) {

				}
			}
			try {
				Prueba_inicio u = new Prueba_inicio();
				u.entrar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void entrar() throws IOException, ClassNotFoundException,
			SQLException {
		Logica_Usuario usu = new Logica_Usuario();
		ced = "";
		pas = "";

		ced = user.getText();
		char a[] = pass.getPassword();
		System.out.println(pass.getPassword());
		for (int i = 0; i < a.length; i++) {
			pas += a[i];
		}
		// Define si el metodo por valor devuelve un valor de verdadero pasa
		// caso contrario manda un mensaje incorrecto.

		if (usu.login(ced, pas)) {
			Logica_Usuario usuario = new Logica_Usuario();
			System.out.println(usuario.tipousuario(getCed()));
			ventana.setVisible(false);
			Prueba_principal p = new Prueba_principal(
					usuario.tipousuario(getCed()));
			p.setVisible(true);
			p.setLocationRelativeTo(null);

		} else {
			JOptionPane.showMessageDialog(null,
					"Usuario o Contraseña Incorrecto");
		}
	}

	public static String getCed() {
		return ced;
	}

	public static void setCed(String ced) {
		Prueba_inicio.ced = ced;
	}

}
