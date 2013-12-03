package interfaz;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;

import conexion.Conexion;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import logica.*;

/**
 * The Class In_Principal.
 */
public class In_Principal {

	/** The ventana. */
	JFrame ventana = new JFrame();

	/** The panel. */
	public JPanel panel = new JPanel();

	/** The Compacto. */
	JRadioButtonMenuItem Compacto = new JRadioButtonMenuItem("Compacto");

	/** The Windows. */
	JRadioButtonMenuItem Windows = new JRadioButtonMenuItem("Windows");

	/** The menu bar. */
	JMenuBar menuBar = new JMenuBar();

	/** The x. */
	int x = 1200;

	/** The y. */
	int y = 880;

	/** The c. */
	public Conexion c = Conexion.getConn();

	/** The contenedor. */
	public JTabbedPane contenedor = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * aparienciaVentana. Establece una apariencia a la interfaz por medio de la
	 * libreria Substance
	 */
	public void aparienciaVentana() {
		JFrame.setDefaultLookAndFeelDecorated(true);

	}

	/**
	 * Run. Metodo principal con el cual se crea la ventna y se levantan todos
	 * los componentes.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void run() throws IOException, ClassNotFoundException {
		ventana.setTitle("FACTURE OFFICE  V 1.2");
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"imagenes/facturacion.png"));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(x, y);
		ventana.setLocationRelativeTo(null);

		Compacto.setSelected(true);
		Compacto.setEnabled(false);
		Windows.setEnabled(true);
		Windows.setSelected(false);

		aparienciaVentana();

		panel.setLayout(null);

		contenedores();
		menu();

		ventana.add(panel);
		ventana.setVisible(true);
	}

	/**
	 * Contenedores. Se crean los conetendores que van a ir en la interfaz
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void contenedores() {
		Class<?> clase;
		Method metodo;
		try {
			contenedor.setBounds(15, 40, x - 40, y - 120);
			switch (Lg_Usuario.tipousuario(In_Iniciar_Secion.ced)) {

			case 1:
				Lg_Recursos recursos = new Lg_Recursos();
				for (int i = 0; i < recursos.asignacionRecursos(
						In_Iniciar_Secion.ced).size(); i++) {
					clase = Class.forName((String) recursos.asignacionRecursos(
							In_Iniciar_Secion.ced).get(i));
					System.out.println();
					Object interfazcliente = clase.newInstance();
					metodo = clase.getMethod("run");
					// metodo.invoke(interfazcliente);
					contenedor.addTab(
							(String) recursos.asignacionRecursos(
									In_Iniciar_Secion.ced).get(i), null,
							(Component) metodo.invoke(interfazcliente), null);
				}
				break;
			case 2:
				Lg_Recursos recursoss = new Lg_Recursos();
				for (int i = 0; i < recursoss.asignacionRecursos(
						In_Iniciar_Secion.ced).size(); i++) {
					clase = Class.forName((String) recursoss
							.asignacionRecursos(In_Iniciar_Secion.ced).get(i));
					System.out.println();
					Object interfazcliente = clase.newInstance();
					metodo = clase.getMethod("run");
					// metodo.invoke(interfazcliente);
					contenedor.addTab(
							(String) recursoss.asignacionRecursos(
									In_Iniciar_Secion.ced).get(i), null,
							(Component) metodo.invoke(interfazcliente), null);
				}
				break;

			default:

				break;
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("La clase no pudo ser encontrada");
		} catch (InstantiationException x) {
			System.out
					.println("No se pudo crear una instancia de la clase desconocida");
		} catch (IllegalAccessException x) {
			System.out
					.println("No se puede tener acceso a la clase desconocida");
		} catch (IllegalArgumentException x) {
			System.out
					.println("Los argumentos para invocar al metodo no son correctos");
		} catch (InvocationTargetException x) {
			System.out.println("El metodo invocado lanzo una excepcion");
		} catch (NoSuchMethodException x) {

		}
		panel.add(contenedor);
	}

	/**
	 * Menu.
	 */
	public void menu() {

		menuBar.setBounds(0, 0, x, 30);
		panel.add(menuBar);

		JMenu mnFile = new JMenu("Herramientas");
		menuBar.add(mnFile);

		JMenuItem guardar = new JMenuItem("Calculadora");
		guardar.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			public void actionPerformed(ActionEvent arg0) {
				try {
					Runtime.getRuntime().exec("calc.exe");
				} catch (IOException e) {
					JOptionPane
							.showMessageDialog(null,
									"Tipo de archivo no soportado o Archivo no encontrado");
				}
			}
		});

		mnFile.add(guardar);
		JMenuItem abrir = new JMenuItem("Abrir");
		abrir.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mnFile.add(abrir);

		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				c.desconectar();
				System.exit(0);

			}
		});
		mnFile.add(salir);

		JMenu mnWindow = new JMenu("Ajustes");
		menuBar.add(mnWindow);
		// establece parametros de tamaño de la ventana del programa tipo
		// compacto
		Compacto.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			public void actionPerformed(ActionEvent arg0) {
				x = 1200;
				y = 880;

				Compacto.setSelected(true);
				Compacto.setEnabled(false);
				Windows.setEnabled(true);
				Windows.setSelected(false);
				ventana.setSize(x, y);
				ventana.setLocationRelativeTo(null);

				contenedor.setBounds(15, 40, x - 40, y - 120);
				menuBar.setBounds(0, 0, x, 30);
			}
		});
		mnWindow.add(Compacto);
		// Por medio de un escuchador establece un tamaño de ventana al programa
		// tipo windows
		Windows.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			public void actionPerformed(ActionEvent arg0) {
				Windows.setSelected(true);
				Windows.setEnabled(false);
				Compacto.setEnabled(true);
				Compacto.setSelected(false);
				ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
				x = ventana.getWidth();
				y = ventana.getHeight();

				contenedor.setBounds(15, 40, x - 40, y - 120);
				menuBar.setBounds(0, 0, x, 30);
			}
		});
		mnWindow.add(Windows);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenuItem AcerdaDe = new JMenuItem("Acerda de");
		AcerdaDe.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane
						.showMessageDialog(
								null,
								"SISTEMA DE FACTURACION 1.2 \n DESARROLLADO POR: \n EDWIN BELDUMA - MIGUEL SIGUENZA - ALEX MURILLO");
			}
		});
		mnAyuda.add(AcerdaDe);
	}

}