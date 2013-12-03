package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.table.DefaultTableModel;
import logica.Lg_Cliente;
import logica.Lg_Validaciones;

/**
 * The Class In_Cliente.Un cambio 
 * de ahora sasfasdasd
 * 
 * 
 */
public class In_Cliente {

	/** The cliente. */
	Lg_Cliente cliente = new Lg_Cliente();

	/** The comprobacion. */
	public Lg_Validaciones comprobacion = new Lg_Validaciones();

	/** The cli_codigo. */
	JTextField cli_codigo = new JTextField();

	/** The cli_cedula. */
	JTextField cli_cedula = new JTextField();

	/** The cli_nombre. */
	JTextField cli_nombre = new JTextField();

	/** The cli_apellido. */
	JTextField cli_apellido = new JTextField();

	/** The cli_telefono. */
	JTextField cli_telefono = new JTextField();

	/** The cli_direccion. */
	JTextField cli_direccion = new JTextField();

	/** The pro_ activado. */
	JRadioButton pro_Activado = new JRadioButton("Activado");

	/** The pro_ desactivado. */
	JRadioButton pro_Desactivado = new JRadioButton("Inactivo");

	/** The cli_buscar. */
	JTextField cli_buscar;

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

	/** The Panel_ cliente. */
	JLayeredPane Panel_Cliente = new JLayeredPane();

	/** The modelo. */
	DefaultTableModel modelo = new DefaultTableModel();

	/** The tabla. */
	JTable tabla;

	/** The barraDesplazamiento. */
	JScrollPane barraDesplazamiento;

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
	 * Cliente.
	 * 
	 * @return the j layered pane
	 */
	
	public JLayeredPane run() {
		System.out.println("holaaaa");
		Panel_Cliente.setLayout(null);

		JLabel Cli_codigo = new JLabel("Código");
		Cli_codigo.setFont(fuente);
		Cli_codigo.setBounds(22, 92, 99, 14);
		Panel_Cliente.add(Cli_codigo);

		cli_codigo.setEditable(false);
		cli_codigo.setBounds(141, 82, 332, 34);
		Panel_Cliente.add(cli_codigo);

		JLabel Cli_cedula = new JLabel("Cédula ");
		Cli_cedula.setFont(fuente);
		Cli_cedula.setBounds(22, 137, 99, 14);
		Panel_Cliente.add(Cli_cedula);

		cli_cedula.setToolTipText("Ingresar Cédula");
		cli_cedula.setBounds(141, 127, 332, 34);
		Panel_Cliente.add(cli_cedula);

		JLabel Cli_Nombre = new JLabel("Nombre");
		Cli_Nombre.setFont(fuente);
		Cli_Nombre.setBounds(22, 182, 99, 14);
		Panel_Cliente.add(Cli_Nombre);

		cli_nombre.setToolTipText("Ingresar Nombre");
		cli_nombre.setBounds(141, 172, 332, 34);
		Panel_Cliente.add(cli_nombre);

		JLabel Cli_Apellido = new JLabel("Apellido");
		Cli_Apellido.setFont(fuente);
		Cli_Apellido.setBounds(654, 137, 59, 14);
		Panel_Cliente.add(Cli_Apellido);

		cli_apellido.setToolTipText("Ingresar Apellido");
		cli_apellido.setBounds(723, 127, 332, 34);
		Panel_Cliente.add(cli_apellido);

		JLabel Cli_Telefono = new JLabel("Teléfono");
		Cli_Telefono.setFont(fuente);
		Cli_Telefono.setBounds(22, 230, 99, 14);
		Panel_Cliente.add(Cli_Telefono);

		cli_telefono.setToolTipText("Ingresar Teléfono");
		cli_telefono.setBounds(141, 217, 332, 34);
		Panel_Cliente.add(cli_telefono);

		JLabel Cli_Direccion = new JLabel("Dirección");
		Cli_Direccion.setFont(fuente);
		Cli_Direccion.setBounds(654, 182, 59, 14);
		Panel_Cliente.add(Cli_Direccion);

		cli_direccion.setToolTipText("Ingresar Dirección");
		cli_direccion.setBounds(723, 172, 332, 34);
		Panel_Cliente.add(cli_direccion);

		JLabel Pro_Estado = new JLabel("Estado");
		Pro_Estado.setFont(fuente);
		Pro_Estado.setBounds(660, 235, 100, 14);
		Panel_Cliente.add(Pro_Estado);

		pro_Activado.setSelected(true);
		pro_Activado.setBounds(723, 215, 100, 23);
		pro_Activado.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				estado = true;
				pro_Activado.setSelected(true);
				pro_Activado.setEnabled(false);
				pro_Desactivado.setEnabled(true);
				pro_Desactivado.setSelected(false);
			}
		});
		Panel_Cliente.add(pro_Activado);

		pro_Desactivado.setBounds(723, 240, 100, 23);
		pro_Desactivado.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				estado = !estado;
				pro_Desactivado.setSelected(true);
				pro_Desactivado.setEnabled(false);
				pro_Activado.setEnabled(true);
				pro_Activado.setSelected(false);
			}
		});
		Panel_Cliente.add(pro_Desactivado);

		cli_nombre.setEditable(false);
		cli_apellido.setEditable(false);
		cli_cedula.setEditable(false);
		cli_direccion.setEditable(false);
		cli_telefono.setEditable(false);

		botones();

		grilla();

		if (modelo.getRowCount() != 0) {
			cargar();
		}

		return Panel_Cliente;
	}

	/**
	 * Botones. Levanta todos los botones y los añade a el contenendor del
	 * programa.
	 */
	public void botones() {
		nuevo.setToolTipText("Nuevo");
		nuevo.setIcon(new ImageIcon("imagenes/nuevo.png"));
		nuevo.setBounds(10, 11, 37, 34);
		nuevo.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent) Establece una accion de pulso de boton para
			 * habilitar e inhabilitar botones y establecer acciones.
			 */
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
					cli_buscar.setVisible(false);
				}

				cli_codigo.setText(String.valueOf(modelo.getRowCount() + 1));
				cli_nombre.setText(null);
				cli_apellido.setText(null);
				cli_cedula.setText(null);
				cli_direccion.setText(null);
				cli_telefono.setText(null);

				cli_nombre.setEditable(true);
				cli_apellido.setEditable(true);
				cli_cedula.setEditable(true);
				cli_direccion.setEditable(true);
				cli_telefono.setEditable(true);

				cli_cedula.addKeyListener(new KeyAdapter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * java.awt.event.KeyAdapter#keyReleased(java.awt.event.
					 * KeyEvent) Establece una accion de escuchador de tecleo
					 */
					public void keyReleased(KeyEvent e) {
						// Si la tecla presionada es igual al evento dado entra.
						if (e.getKeyCode() == KeyEvent.VK_ENTER
								&& !cli_cedula.equals("")) {
							System.out.println("liso");
							if (comprobacion.validarCedula(cli_cedula)) {

							} else {
								JOptionPane
										.showMessageDialog(null,
												"	CEDULA INCORRECTA ---- INGRESE CEDULA VALIDA ");
								cli_cedula.setText("Ingrese cedula correcta");
							}

						} else {
							System.out.println("No Entra");
						}

					}

				});
				cli_telefono.addKeyListener(new KeyAdapter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * java.awt.event.KeyAdapter#keyReleased(java.awt.event.
					 * KeyEvent)
					 */
					public void keyReleased(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_ENTER
								&& !cli_telefono.equals("")) {
							System.out.println("liso");
							if (comprobacion
									.validarNumeroTelefonico(cli_telefono)) {

							} else {
								JOptionPane
										.showMessageDialog(null,
												"NUMERO TELEFONICO NO VALIDO ---- INGRESE NUMERO VALIDO ");
								cli_telefono
										.setText("Ingrese Numero Telefonico Valido");
							}

						} else {
							System.out.println("no coje");
						}

					}

				});

			}
		});
		Panel_Cliente.add(nuevo);

		guardar.setEnabled(false);
		guardar.setToolTipText("Guardar");
		guardar.setIcon(new ImageIcon("imagenes/guardar.png"));
		guardar.setBounds(57, 11, 37, 34);
		guardar.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent) Establece un escuchador a la accion del boton y si
			 * se cumple: -Se establece botones habilitados e inhabilitados. -se
			 * crea un objeto de la clase cliente dando los parametros de los
			 * cuadros de texto. -Se da un condicionante que si es verdadero
			 * agregas cliente y si es falso modificas cliente dado y actualizas
			 * los datos de la tabla.
			 */
			public void actionPerformed(ActionEvent arg0) {
				nuevo.setEnabled(true);
				buscar.setEnabled(true);
				modificar.setEnabled(true);
				inicio.setEnabled(true);
				anterior.setEnabled(true);
				siguiente.setEnabled(true);
				fin.setEnabled(true);

				cliente = new Lg_Cliente(
						Integer.parseInt(cli_codigo.getText()), cli_cedula
								.getText(), cli_nombre.getText(), cli_apellido
								.getText(), cli_telefono.getText(),
						cli_direccion.getText(), estado);

				if (bn1) {
					cliente.AgregarCliente();
					modelo.addRow(new Object[] {
							Integer.parseInt(cli_codigo.getText()),
							cli_cedula.getText(), cli_nombre.getText(),
							cli_apellido.getText(), cli_telefono.getText(),
							cli_direccion.getText(), estado });
				} else {
					cliente.ModificarCliente(Integer.parseInt(cli_codigo
							.getText()));
					modelo.setValueAt(cli_cedula.getText(), n, 1);
					modelo.setValueAt(cli_nombre.getText(), n, 2);
					modelo.setValueAt(cli_apellido.getText(), n, 3);
					modelo.setValueAt(cli_telefono.getText(), n, 4);
					modelo.setValueAt(cli_direccion.getText(), n, 5);
					modelo.setValueAt(estado, n, 6);
				}

				modificadorDatosTabla(n);

				cargar();

			}
		});
		Panel_Cliente.add(guardar);

		buscar.setToolTipText("Buscar");
		buscar.setIcon(new ImageIcon("imagenes/buscar.png"));
		buscar.setBounds(104, 11, 37, 34);
		buscar.addActionListener(new ActionListener() {
			/*
			 * Se da una escuchador que si se cumple se establecen parametros de
			 * habilitacion e inhabilitacion de botones.Y se llama al metodo de
			 * busqueda para seleccionar en tabla el parametro buscado
			 */
			public void actionPerformed(ActionEvent arg0) {
				cli_nombre.setEditable(false);
				cli_apellido.setEditable(false);
				cli_cedula.setEditable(false);
				cli_direccion.setEditable(false);
				cli_telefono.setEditable(false);

				guardar.setEnabled(false);

				buscar();
			}
		});
		Panel_Cliente.add(buscar);

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

				cli_nombre.setEditable(true);
				cli_apellido.setEditable(true);
				cli_cedula.setEditable(true);
				cli_direccion.setEditable(true);
				cli_telefono.setEditable(true);

			}
		});
		Panel_Cliente.add(modificar);

		navegar();
	}

	/**
	 * Navegar.
	 */
	public void navegar() {
		inicio.setToolTipText("Main");
		inicio.setIcon(new ImageIcon("imagenes/inicio.png"));
		inicio.setBounds(198, 11, 37, 34);
		inicio.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 * Envia al primer numero de la tabla y los carga en los cuadros de texto
			 */
			public void actionPerformed(ActionEvent arg0) {
				n = 0;
				cargar();
			}
		});
		Panel_Cliente.add(inicio);

		anterior.setToolTipText("Anterior");
		anterior.setIcon(new ImageIcon("imagenes/anterior.png"));
		anterior.setBounds(245, 11, 37, 34);
		anterior.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 * Carga los datos de la tabla en los cuadros de texto.
			 */
			public void actionPerformed(ActionEvent arg0) {
				if (n > 0) {
					n--;
				}
				cargar();
			}
		});
		Panel_Cliente.add(anterior);

		siguiente.setToolTipText("Siguiente");
		siguiente.setIcon(new ImageIcon("imagenes/siguiente.png"));
		siguiente.setBounds(292, 11, 37, 34);
		siguiente.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 * Carga los datos de la tabla en los cuadros de texto.
			 */
			public void actionPerformed(ActionEvent arg0) {
				if (n < tabla.getRowCount() - 1) {
					n++;
				}
				cargar();
			}
		});
		Panel_Cliente.add(siguiente);

		fin.setIcon(new ImageIcon("imagenes/fin.png"));
		fin.setToolTipText("Fin");
		fin.setBounds(339, 11, 37, 34);
		fin.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			public void actionPerformed(ActionEvent arg0) {
				n = tabla.getRowCount() - 1;
				cargar();
			}
		});
		Panel_Cliente.add(fin);
	}

	/**
	 * Grilla. Llena los datos en la tabla por medio de un metodo de llenar
	 * grilla que retorna un modelo Defaultdatamodel y lo implementa en la tabla
	 * 
	 */
	@SuppressWarnings("serial")
	public void grilla() {

		String cols[] = { "CODIGO", "CEDULA", "NOMBRES", "APELLIDOS",
				"TELEFONO", "DIRECCION", "ESTADO" };
		tabla = new JTable(cliente.llenargrilla(modelo, cols)) {
			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}
		};
		// hacer mientras que i sea menos que la diemencion de las fila de la
		// tabla
		for (int i = 0; i < modelo.getRowCount(); i++) {
			modificadorDatosTabla(i);
		}

		tabla.setAutoCreateRowSorter(true);

		barraDesplazamiento = new JScrollPane(tabla);
		barraDesplazamiento.setBounds(32, 300, 1055, 400);

		Panel_Cliente.add(barraDesplazamiento);
	}

	/**
	 * ModoficadorDatosTabla. Cambia los valores de la tabla por un una
	 * condicion dado un parametro de fila.
	 * 
	 * @param i
	 *            the i
	 */
	public void modificadorDatosTabla(int i) {
		switch (String.valueOf(modelo.getValueAt(i, 6))) {
		case "true":
			modelo.setValueAt("Activo", i, 6);
			break;
		case "false":
			modelo.setValueAt("Inactivo", i, 6);
			break;
		}
	}

	/**
	 * Buscar. Define una busqueda de datos en la tabla y si se encuentra se la
	 * sombrea en la tabla o se la selecciona el numero buscado. El metodo de
	 * busqueda se la implementa aplicando un envento de actualizacion de la
	 * tabla dado establecida una condicion.
	 */
	public void buscar() {
		bn = !bn;

		tbuscar.setFont(fuente);
		tbuscar.setBounds(610, 88, 332, 34);
		Panel_Cliente.add(tbuscar);

		cli_buscar = new JTextField(15) {

			private static final long serialVersionUID = 1L;

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * javax.swing.text.JTextComponent#fireCaretUpdate(javax.swing.event
			 * .CaretEvent)
			 */
			public void fireCaretUpdate(CaretEvent arg0) {
				for (int i = 0; i < tabla.getRowCount(); i++) {
					if (String.valueOf(tabla.getValueAt(i, 1))
							.equalsIgnoreCase(cli_buscar.getText())) {
						tabla.changeSelection(i, 1, false, false);
						n = tabla.getSelectedRow();
						cargar();
						break;
					}
				}
			}
		};
		cli_buscar.setBounds(723, 87, 332, 34);
		Panel_Cliente.add(cli_buscar);
	}

	/**
	 * Cargar. Carga los datos seleccionados en tabla en cada uno de los cuadros
	 * de texto.
	 */
	public void cargar() {
		cli_codigo.setText(String.valueOf(tabla.getValueAt(n, 0)));
		cli_cedula.setText(String.valueOf(tabla.getValueAt(n, 1)));
		cli_nombre.setText(String.valueOf(tabla.getValueAt(n, 2)));
		cli_apellido.setText(String.valueOf(tabla.getValueAt(n, 3)));
		cli_telefono.setText(String.valueOf(tabla.getValueAt(n, 4)));
		cli_direccion.setText(String.valueOf(tabla.getValueAt(n, 5)));

		if (String.valueOf(tabla.getValueAt(n, 6)).equalsIgnoreCase("activo")) {
			pro_Activado.setSelected(true);
			pro_Activado.setEnabled(false);
			pro_Desactivado.setSelected(false);
			pro_Desactivado.setEnabled(true);
		} else {
			pro_Activado.setSelected(false);
			pro_Activado.setEnabled(true);
			pro_Desactivado.setSelected(true);
			pro_Desactivado.setEnabled(false);
		}

	}

}
