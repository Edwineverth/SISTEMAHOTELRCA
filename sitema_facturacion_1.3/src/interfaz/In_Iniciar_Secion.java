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

import conexion.Conexion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import logica.Lg_Usuario;

/**
 * The Class In_Iniciar_Secion.
 */
public class In_Iniciar_Secion {

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

	/**
	 * The main method.
	 * 
	 */
	@SuppressWarnings("unused")
	public void run() {

		In_Iniciar_Secion interfaz = new In_Iniciar_Secion();
		interfaz.componentes();
		Conexion c = Conexion.getConn();
	}

	/**
	 * Deco.
	 */
	public void deco() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
	}

	/**
	 * Componentes.
	 */
	public void componentes() {
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"imagenes/facturacion.png"));
		ventana.setTitle("FACTURE OFFICE");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(810, 500);
		
		ventana.setLocationRelativeTo(null);

		deco();

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
		ventana.add(panel);

		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon("imagenes/fondo.jpg"));
		fondo.setBounds(0, 0, 800, 488);
		panel.add(fondo);
		ventana.add(panel);
		ventana.setVisible(true);

	}

	/**
	 * The Class Escucha. Implementado un interfaz Escuchador
	 */
	public static class Escucha implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		public void actionPerformed(ActionEvent e) {
			cargando.setVisible(true);
			barra.setVisible(true);
			new Thread(new Hilo()).start();

		}
	}

	/**
	 * The Class Hilo. Implementando la clase Runable para extender de otro
	 * objeto que no sea Thread y manejar mas de un proceso.
	 */
	public static class Hilo implements Runnable {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
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
				entrar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Entrar. Metodo para poder entrar y levantar la interfaz principal . Se
	 * define variable ced y pas y por medio de ello se compara un valir boolean
	 * de true para poder entrar al a interfaz principal.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void entrar() throws IOException, ClassNotFoundException {
		Lg_Usuario usu = new Lg_Usuario();
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
			In_Principal principal = new In_Principal();
			ventana.setVisible(false);
			principal.run();
		} else {
			JOptionPane.showMessageDialog(null,
					"Usuario o Contraseña Incorrecto");
		}
	}

}