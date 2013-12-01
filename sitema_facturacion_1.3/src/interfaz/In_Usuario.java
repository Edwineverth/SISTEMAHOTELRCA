package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.table.DefaultTableModel;
import logica.Lg_Usuario;
import logica.Metodos;

/**
 * The Class In_Usuario.
 */
public class In_Usuario {

	/** The usuario. */
	Lg_Usuario usuario = new Lg_Usuario();

	/** The usu_codigo. */
	JTextField usu_codigo = new JTextField();

	/** The usu_cedula. */
	JTextField usu_cedula = new JTextField();

	/** The usu_nombre. */
	JTextField usu_nombre = new JTextField();

	/** The usu_apellido. */
	JTextField usu_apellido = new JTextField();

	/** The usu_telefono. */
	JTextField usu_telefono = new JTextField();

	/** The usu_direccion. */
	JTextField usu_direccion = new JTextField();

	/** The usu_clave. */
	JTextField usu_clave = new JTextField();

	/** The usu_tipo. */
	@SuppressWarnings("rawtypes")
	JComboBox usu_tipo = new JComboBox();

	/** The usu_ activado. */
	JRadioButton usu_Activado = new JRadioButton("Activado");

	/** The usu_ desactivado. */
	JRadioButton usu_Desactivado = new JRadioButton("Inactivo");

	/** The Comprobacion. */
	public Metodos Comprobacion = new Metodos();

	/** The usu_buscar. */
	JTextField usu_buscar;

	/** The tbuscar. */
	JLabel tbuscar = new JLabel("Cédula a Buscar");

	/** The nuevo. */
	JButton nuevo = new JButton("");

	/** The guardar. */
	JButton guardar = new JButton("");

	/** The buscar. */
	JButton buscar = new JButton("");

	/** The modificar. */
	JButton modificar = new JButton("");

	/** The inicio. */
	JButton inicio = new JButton("");

	/** The anterior. */
	JButton anterior = new JButton("");

	/** The siguiente. */
	JButton siguiente = new JButton("");

	/** The fin. */
	JButton fin = new JButton("");

	/** The Panel_ usuario. */
	JLayeredPane Panel_Usuario = new JLayeredPane();

	/** The modelo. */
	DefaultTableModel modelo = new DefaultTableModel();

	/** The tabla. */
	JTable tabla;

	/** The s. */
	JScrollPane s;

	/** The fuente. */
	Font fuente = new Font("Tahoma", Font.BOLD, 11);

	/** The n. */
	int n = 0;

	/** The bn. */
	boolean bn;

	/** The bn1. */
	boolean bn1;

	/** The estado. */
	boolean estado = true;

	/**
	 * Usuario. Levanta todos los componentes en la interfaz y llama a los otros
	 * metodos.
	 * 
	 * @return the j layered pane
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JLayeredPane usuario() {
		Panel_Usuario.setLayout(null);

		JLabel Usu_Codigo = new JLabel("Código");
		Usu_Codigo.setFont(fuente);
		Usu_Codigo.setBounds(22, 92, 99, 14);
		Panel_Usuario.add(Usu_Codigo);

		usu_codigo.setEditable(false);
		usu_codigo.setBounds(141, 82, 332, 34);
		Panel_Usuario.add(usu_codigo);

		JLabel Usu_Cedula = new JLabel("Cédula ");
		Usu_Cedula.setFont(fuente);
		Usu_Cedula.setBounds(22, 137, 99, 14);
		Panel_Usuario.add(Usu_Cedula);

		usu_cedula.setToolTipText("Ingresar Cédula");
		usu_cedula.setBounds(141, 127, 332, 34);
		Panel_Usuario.add(usu_cedula);

		JLabel Usu_Nombre = new JLabel("Nombre");
		Usu_Nombre.setFont(fuente);
		Usu_Nombre.setBounds(22, 182, 99, 14);
		Panel_Usuario.add(Usu_Nombre);

		usu_nombre.setToolTipText("Ingresar Nombre");
		usu_nombre.setBounds(141, 172, 332, 34);
		Panel_Usuario.add(usu_nombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(fuente);
		lblApellido.setBounds(654, 137, 59, 14);
		Panel_Usuario.add(lblApellido);

		usu_apellido.setToolTipText("Ingresar Apellido");
		usu_apellido.setBounds(723, 127, 332, 34);
		Panel_Usuario.add(usu_apellido);

		JLabel Usu_telefono = new JLabel("Teléfono");
		Usu_telefono.setFont(fuente);
		Usu_telefono.setBounds(22, 230, 99, 14);
		Panel_Usuario.add(Usu_telefono);

		usu_telefono.setToolTipText("Ingresar Teléfono");
		usu_telefono.setBounds(141, 217, 332, 34);
		Panel_Usuario.add(usu_telefono);

		JLabel Usu_Direccion = new JLabel("Dirección");
		Usu_Direccion.setFont(fuente);
		Usu_Direccion.setBounds(654, 182, 59, 14);
		Panel_Usuario.add(Usu_Direccion);

		usu_direccion.setToolTipText("Ingresar Dirección");
		usu_direccion.setBounds(723, 182, 332, 34);
		Panel_Usuario.add(usu_direccion);

		JLabel Usu_Clave = new JLabel("Clave");
		Usu_Clave.setFont(fuente);
		Usu_Clave.setBounds(22, 272, 46, 14);
		Panel_Usuario.add(Usu_Clave);

		usu_clave.setToolTipText("Ingrese Clave");
		usu_clave.setBounds(141, 262, 332, 34);
		Panel_Usuario.add(usu_clave);

		JLabel Usu_Tipo = new JLabel("Tipo");
		Usu_Tipo.setFont(fuente);
		Usu_Tipo.setBounds(654, 230, 46, 14);
		Panel_Usuario.add(Usu_Tipo);

		usu_tipo.setModel(new DefaultComboBoxModel(new String[] {
				"Administrador", "Recepcionista" }));
		usu_tipo.setBounds(723, 230, 91, 27);
		Panel_Usuario.add(usu_tipo);

		JLabel Pro_Estado = new JLabel("Estado");
		Pro_Estado.setFont(fuente);
		Pro_Estado.setBounds(660, 272, 100, 14);
		Panel_Usuario.add(Pro_Estado);

		usu_Activado.setSelected(true);
		usu_Activado.setBounds(723, 262, 100, 23);
		usu_Activado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado = true;

				usu_Activado.setSelected(true);// zzzz
				usu_Activado.setEnabled(false);
				usu_Desactivado.setEnabled(true);
				usu_Desactivado.setSelected(false);
			}
		});
		Panel_Usuario.add(usu_Activado);

		usu_Desactivado.setBounds(723, 282, 100, 23);
		usu_Desactivado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado = !estado;

				usu_Desactivado.setSelected(true);
				usu_Desactivado.setEnabled(false);
				usu_Activado.setEnabled(true);
				usu_Activado.setSelected(false);
			}
		});
		Panel_Usuario.add(usu_Desactivado);

		usu_cedula.setEditable(false);
		usu_nombre.setEditable(false);
		usu_apellido.setEditable(false);
		usu_telefono.setEditable(false);
		usu_direccion.setEditable(false);
		usu_clave.setEditable(false);

		botones();

		grilla();

		if (modelo.getRowCount() != 0) {
			cargar();
		}

		return Panel_Usuario;
	}

	/**
	 * Botones. Añade los botones a el contenedor y le da escuchadores de teclas
	 * a los cuadros de texto para implementar ciertos tipos de validacion.
	 */
	public void botones() {
		nuevo.setToolTipText("Nuevo");
		nuevo.setIcon(new ImageIcon("imagenes/nuevo.png"));
		nuevo.setBounds(10, 11, 37, 34);
		nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bn1 = true;

				buscar.setEnabled(false);
				modificar.setEnabled(false);
				guardar.setEnabled(true);
				inicio.setEnabled(false);
				anterior.setEnabled(false);
				siguiente.setEnabled(false);
				fin.setEnabled(false);

				if (bn) {
					tbuscar.setVisible(false);
					usu_buscar.setVisible(false);
				}

				usu_codigo.setText(String.valueOf(modelo.getRowCount() + 1));
				usu_cedula.setText(null);
				usu_nombre.setText(null);
				usu_apellido.setText(null);
				usu_telefono.setText(null);
				usu_direccion.setText(null);
				usu_clave.setText(null);

				usu_cedula.setEditable(true);
				usu_nombre.setEditable(true);
				usu_apellido.setEditable(true);
				usu_telefono.setEditable(true);
				usu_direccion.setEditable(true);
				usu_clave.setEditable(true);

				usu_cedula.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent e) {

						if (e.getKeyCode() == KeyEvent.VK_ENTER
								&& !usu_cedula.equals("")) {
							System.out.println("liso");
							if (Comprobacion.validarCedula(usu_cedula)) {

							} else {
								JOptionPane
										.showMessageDialog(null,
												"	CEDULA INCORRECTA ---- INGRESE CEDULA VALIDA ");
								usu_cedula.setText("Ingrese cedula correcta");
							}

						} else {
							System.out.println("no coje");
						}

					}

				});
				usu_telefono.addKeyListener(new KeyAdapter() {

					public void keyReleased(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_ENTER
								&& !usu_telefono.equals("")) {
							System.out.println("liso");
							if (Comprobacion
									.validarNumeroTelefonico(usu_telefono)) {

							} else {
								JOptionPane
										.showMessageDialog(null,
												"NUMERO TELEFONICO NO VALIDO ---- INGRESE NUMERO VALIDO ");
								usu_telefono
										.setText("Ingrese Numero Telefonico Valido");
							}

						} else {
							System.out.println("no coje");
						}

					}

				});

			}
		});
		Panel_Usuario.add(nuevo);

		guardar.setEnabled(false);
		guardar.setToolTipText("Guardar");
		guardar.setIcon(new ImageIcon("imagenes/guardar.png"));
		guardar.setBounds(57, 11, 37, 34);
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo.setEnabled(true);
				buscar.setEnabled(true);
				modificar.setEnabled(true);
				inicio.setEnabled(true);
				anterior.setEnabled(true);
				siguiente.setEnabled(true);
				fin.setEnabled(true);
				// crea un nuevo ojecto de la clase logica e usuario y le envia
				// los parametros que hay en los cuadros de texto
				usuario = new Lg_Usuario(
						Integer.parseInt(usu_codigo.getText()), usu_cedula
								.getText(), usu_nombre.getText(), usu_apellido
								.getText(), usu_telefono.getText(),
						usu_direccion.getText(), usu_clave.getText(), usu_tipo
								.getSelectedIndex() + 1, estado);

				if (bn1) {
					// ejecuta el metodo agregar usuario que esta en la clase
					// logica de usuario y crea un nuevo modelo de la tabla con
					// los parametros que hay en el cuadro de texto
					usuario.AgregarUsuario();
					modelo.addRow(new Object[] {
							Integer.parseInt(usu_codigo.getText()),
							usu_cedula.getText(), usu_nombre.getText(),
							usu_apellido.getText(), usu_telefono.getText(),
							usu_direccion.getText(), usu_clave.getText(),
							usu_tipo.getSelectedIndex() + 1, estado });
					System.out.println(modelo.getRowCount());
					modificadorDatos(modelo.getRowCount() - 1);
				} else {
					usuario.ModificarUsuario(Integer.parseInt(usu_codigo
							.getText()));

					modelo.setValueAt(usu_cedula.getText(), n, 1);
					modelo.setValueAt(usu_nombre.getText(), n, 2);
					modelo.setValueAt(usu_apellido.getText(), n, 3);
					modelo.setValueAt(usu_telefono.getText(), n, 4);
					modelo.setValueAt(usu_direccion.getText(), n, 5);
					modelo.setValueAt(usu_clave.getText(), n, 6);
					modelo.setValueAt(usu_tipo.getSelectedIndex() + 1, n, 7);
					modelo.setValueAt(estado, n, 8);
					modificadorDatos(n);
				}

				cargar();
				for (int i = 0; i < modelo.getRowCount(); i++) {
					modificadorDatos(i);
				}

			}
		});
		Panel_Usuario.add(guardar);

		buscar.setToolTipText("Buscar");
		buscar.setIcon(new ImageIcon("imagenes/buscar.png"));
		buscar.setBounds(104, 11, 37, 34);
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usu_cedula.setEditable(false);
				usu_nombre.setEditable(false);
				usu_apellido.setEditable(false);
				usu_telefono.setEditable(false);
				usu_direccion.setEditable(false);
				usu_clave.setEditable(false);

				guardar.setEnabled(false);

				buscar();
			}
		});
		Panel_Usuario.add(buscar);

		modificar.setToolTipText("Modificar");
		modificar.setIcon(new ImageIcon("imagenes/modificar.png"));
		modificar.setBounds(151, 11, 37, 34);
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bn1 = false;

				nuevo.setEnabled(false);
				buscar.setEnabled(false);
				guardar.setEnabled(true);
				inicio.setEnabled(false);
				anterior.setEnabled(false);
				siguiente.setEnabled(false);
				fin.setEnabled(false);

				usu_cedula.setEditable(true);
				usu_nombre.setEditable(true);
				usu_apellido.setEditable(true);
				usu_telefono.setEditable(true);
				usu_direccion.setEditable(true);
				usu_clave.setEditable(true);
			}
		});
		Panel_Usuario.add(modificar);

		navegar();
	}

	/**
	 * Navegar. Actualiza los valores que hay en lo cuadros de etexto con los
	 * valores que estan en la tabla por medio de una accion de boton.
	 */
	public void navegar() {
		inicio.setToolTipText("Main");
		inicio.setIcon(new ImageIcon("imagenes/inicio.png"));
		inicio.setBounds(198, 11, 37, 34);
		inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				n = 0;
				cargar();
			}
		});
		Panel_Usuario.add(inicio);

		anterior.setToolTipText("Anterior");
		anterior.setIcon(new ImageIcon("imagenes/anterior.png"));
		anterior.setBounds(245, 11, 37, 34);
		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (n > 0) {
					n--;
				}
				cargar();
			}
		});
		Panel_Usuario.add(anterior);

		siguiente.setToolTipText("Siguiente");
		siguiente.setIcon(new ImageIcon("imagenes/siguiente.png"));
		siguiente.setBounds(292, 11, 37, 34);
		siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (n < tabla.getRowCount() - 1) {
					n++;
				}
				cargar();
			}
		});
		Panel_Usuario.add(siguiente);

		fin.setIcon(new ImageIcon("imagenes/fin.png"));
		fin.setToolTipText("Fin");
		fin.setBounds(339, 11, 37, 34);
		fin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				n = tabla.getRowCount() - 1;
				cargar();
			}
		});
		Panel_Usuario.add(fin);
	}

	/**
	 * Grilla. Llena la grilla por medio de un metodo de llenado de grilla que
	 * le retorna un modelo de la grilla para implementar en la tabla.
	 */
	@SuppressWarnings("serial")
	public void grilla() {
		String cols[] = { "CODIGO", "CEDULA", "NOMBRES", "APELLIDOS",
				"TELEFONO", "DIRECCION", "CLAVE", "ROL", "ESTADO" };
		tabla = new JTable(usuario.llenargrilla(modelo, cols)) {
			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}
		};
		// hasta que i no sea mayor que la dimension de la fila de la tabla
		// modificar los datos.
		for (int i = 0; i < modelo.getRowCount(); i++) {

			modificadorDatos(i);
		}

		tabla.setAutoCreateRowSorter(true);

		s = new JScrollPane(tabla);
		s.setBounds(32, 350, 1055, 350);

		Panel_Usuario.add(s);
	}

	/**
	 * modificadorDatos. modifica en cierta posicion de la tabla con nuevos
	 * valores por medio de una conficion.
	 * 
	 * @param  the i
	 */
	public void modificadorDatos(int i) {
		switch (String.valueOf(modelo.getValueAt(i, 7))) {
		case "1":
			modelo.setValueAt("Administrador", i, 7);
			break;
		case "2":
			modelo.setValueAt("Recepcionista", i, 7);
			break;

		}
		switch (String.valueOf(modelo.getValueAt(i, 8))) {
		case "true":
			modelo.setValueAt("Activo", i, 8);
			break;
		case "false":
			modelo.setValueAt("Inactivo", i, 8);
			break;
		}
	}

	/**
	 * Buscar.
	 */
	public void buscar() {

		tbuscar.setFont(fuente);
		tbuscar.setBounds(600, 82, 332, 34);
		Panel_Usuario.add(tbuscar);

		usu_buscar = new JTextField(15) {

			private static final long serialVersionUID = 1L;

			public void fireCaretUpdate(CaretEvent arg0) {
				bn = !bn;

				for (int i = 0; i < tabla.getRowCount(); i++) {
					if (String.valueOf(tabla.getValueAt(i, 1))
							.equalsIgnoreCase(usu_buscar.getText())) {
						tabla.changeSelection(i, 1, false, false);
						n = tabla.getSelectedRow();
						cargar();
						break;
					}
				}
			}
		};
		usu_buscar.setBounds(723, 82, 332, 34);
		usu_buscar.setVisible(true);
		Panel_Usuario.add(usu_buscar);
	}

	/**
	 * Cargar.
	 */
	public void cargar() {
		usu_codigo.setText(String.valueOf(tabla.getValueAt(n, 0)));
		usu_cedula.setText(String.valueOf(tabla.getValueAt(n, 1)));
		usu_nombre.setText(String.valueOf(tabla.getValueAt(n, 2)));
		usu_apellido.setText(String.valueOf(tabla.getValueAt(n, 3)));
		usu_telefono.setText(String.valueOf(tabla.getValueAt(n, 4)));
		usu_direccion.setText(String.valueOf(tabla.getValueAt(n, 5)));
		usu_clave.setText(String.valueOf(tabla.getValueAt(n, 6)));
		usu_tipo.setSelectedItem(tabla.getValueAt(n, 7));

		if (String.valueOf(tabla.getValueAt(n, 8)).equalsIgnoreCase("activo")) {
			usu_Activado.setSelected(true);
			usu_Activado.setEnabled(false);
			usu_Desactivado.setSelected(false);
			usu_Desactivado.setEnabled(true);
		} else {
			usu_Activado.setSelected(false);
			usu_Activado.setEnabled(true);
			usu_Desactivado.setSelected(true);
			usu_Desactivado.setEnabled(false);
		}

	}
}
