package interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JScrollPane;

import conexion.Conexion;
import logica.seguridad.*;
import logica.dinamismo.*;

import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.watermark.SubstanceImageWatermark;

import javax.swing.event.TreeSelectionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;

public class Prueba_principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Seguridad_Recursos recursos = new Seguridad_Recursos();
	private Seguridad_Modulo modulos = new Seguridad_Modulo();
	private Logica_Usuario usuario = new Logica_Usuario();
	private JTabbedPane contenedor = new JTabbedPane(JTabbedPane.TOP);
	private JTree arbol;
	public Conexion c = Conexion.getConn();
	java.util.Calendar calendario;
	int dia, mes, año, hora, minutos, segundos;
	private javax.swing.JLabel label;
	int dom;
	String hour, date;
	JLabel label_1 = new JLabel("");
	Prueba_inicio pru = new Prueba_inicio();

	public Prueba_principal() {

	}

	public Prueba_principal(int k) throws SQLException {
		dom = k;

		setTitle("SISTEMA DE GESTION ADMINISTRATIVA RCA HOTEL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"imagenes/rcalogo.png"));
		//SubstanceLookAndFeel.setCurrentWatermark(new SubstanceImageWatermark( "imagenes//rcalogo.png"));
		//SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.5));
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1332, 805);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnConfiguraciones = new JMenu("Configuraciones");
		menuBar.add(mnConfiguraciones);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 180, 600);

		String str = "select * from \"Permiso\" where rol_codigo=" + k
				+ " and per_estado=true";
		ResultSet rs = null;
		try {
			rs = c.consulta(str);
			while (rs.next()) {
				recursos.consulta_nombre(rs.getObject("rec_codigo").toString());
			}
			rs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		String m[] = new String[recursos.Count()];
		for (int i = 0; i < m.length; i++)
			m[i] = "";

		for (int i = 0; i < recursos.Count(); i++) {
			boolean t = true;

			for (int j = 0; j < m.length; j++) {
				if (m[j].equals(recursos.get_Modulo(i)))
					t = false;
			}

			if (t) {
				modulos.consulta_nombre(recursos.get_Modulo(i));
			}

			m[i] = recursos.get_Modulo(i);
		}

		arbol = new JTree(modulo());
		contenedor.setBounds(200, 45, 850, 693);
		reloj();
		contenedor();
		scrollPane.setViewportView(arbol);

		contentPane.add(scrollPane);
		Prueba_inicio pru = new Prueba_inicio();
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Bienvenido" + "  "
				+ usuario.UsuarioNombre(pru.getCed()), TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(788, 11, 262, 34);
		contentPane.add(panel);
		panel.setLayout(null);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_1.setBounds(10, 11, 249, 23);
		panel.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		setExtendedState(MAXIMIZED_BOTH);

	}

	public DefaultTreeModel modulo() {

		DefaultMutableTreeNode modulos = new DefaultMutableTreeNode("HOTEL RCA");
		DefaultMutableTreeNode[] mod = new DefaultMutableTreeNode[this.modulos
				.Count()];
		DefaultTreeModel modelo = new DefaultTreeModel(modulos);
		for (int i = 0; i < this.modulos.Count(); i++) {
			mod[i] = new DefaultMutableTreeNode(this.modulos.get_nombre(i));
			modelo.insertNodeInto(mod[i], modulos, i);
			String str = "select rec_nombre from \"Recurso\" where mod_codigo="
					+ this.modulos.get_codigo(i);
			int cont = 0;
			try {
				ResultSet rs = c.consulta(str);
				while (rs.next()) {
					modelo.insertNodeInto(new DefaultMutableTreeNode(rs
							.getObject("rec_nombre").toString()), mod[i], cont);
					cont++;
				}
				rs.close();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		return modelo;
	}

	public void contenedor() {
		arbol.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent e) {
				if (!(contenedor.getSize() == null)) {
					contenedor.removeAll();
				}
				DefaultMutableTreeNode nseleccionado = (DefaultMutableTreeNode) arbol
						.getLastSelectedPathComponent();

				InstanciaObejtos o = new InstanciaObejtos();

				Class<?> clase;
				Method metodo = null;
				try {
					clase = Class.forName(o.consultaRecurso(String
							.valueOf(nseleccionado.getUserObject())));

					Object interfazcliente = clase.newInstance();

					metodo = clase.getMethod("run");

					contenedor.addTab(
							String.valueOf(nseleccionado.getUserObject()),
							new ImageIcon("imagenes/"
									+ String.valueOf(nseleccionado
											.getUserObject()) + ".png"),
							(Component) metodo.invoke(interfazcliente), null);

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
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		contentPane.add(contenedor);
	}

	private void reloj() {
		calendario = new java.util.GregorianCalendar();
		segundos = calendario.get(Calendar.SECOND);
		javax.swing.Timer timer = new javax.swing.Timer(1000,
				new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent ae) {
						java.util.Date actual = new java.util.Date();
						calendario.setTime(actual);
						dia = calendario.get(Calendar.DAY_OF_MONTH);
						mes = (calendario.get(Calendar.MONTH) + 1);
						año = calendario.get(Calendar.YEAR);
						hora = calendario.get(Calendar.HOUR_OF_DAY);
						minutos = calendario.get(Calendar.MINUTE);
						segundos = calendario.get(Calendar.SECOND);
						hour = String.format("%02d : %02d : %02d", hora,
								minutos, segundos);
						date = String.format("%02d / %02d / %02d", dia, mes,
								año);
						label_1.setText(hour + "      " + date);
					}
				});
		timer.start();
	}

	public JTabbedPane getContenedor() {
		return contenedor;
	}

	public void setContenedor(JTabbedPane contenedor) {
		this.contenedor = contenedor;
	}

}
