package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.table.DefaultTableModel;

import logica.Lg_Habitacion;

/**
 * The Class In_Habitacion.
 */
public class In_Habitacion {

	/** The habitacion. */
	Lg_Habitacion habitacion = new Lg_Habitacion();

	/** The hab_codigo. */
	JTextField hab_codigo = new JTextField();

	/** The hab_tipo. */
	@SuppressWarnings("rawtypes")
	JComboBox hab_tipo = new JComboBox();

	/** The hab_clase. */
	@SuppressWarnings("rawtypes")
	JComboBox hab_clase = new JComboBox();

	/** The hab_preciounitario. */
	JTextField hab_preciounitario = new JTextField();

	/** The hab_ activado. */
	JRadioButton hab_Activado = new JRadioButton("Ocupada");

	/** The hab_ desactivado. */
	JRadioButton hab_Desactivado = new JRadioButton("Desocupada");

	/** The hab_buscar. */
	JTextField hab_buscar;

	/** The tbuscar. */
	JLabel tbuscar = new JLabel("Código a Buscar");

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

	/** The panel_ habitacion. */
	JLayeredPane panel_Habitacion = new JLayeredPane();

	/** The modelo. */
	DefaultTableModel modelo = new DefaultTableModel();

	/** The tabla. */
	JTable tabla;

	/** The barraDesplazamiento. */
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
	 * habitacion. levanta todos los componentes y los añade aun contenedor y
	 * retorna la pestaña de panel con los datos levantandos en la interfaz
	 * 
	 * @return the j layered pane
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public JLayeredPane run() throws IOException, ClassNotFoundException {
		panel_Habitacion.setLayout(null);

		JLabel Pro_Codigo = new JLabel("Código");
		Pro_Codigo.setFont(fuente);
		Pro_Codigo.setBounds(22, 92, 99, 14);
		panel_Habitacion.add(Pro_Codigo);

		hab_codigo.setEditable(false);
		hab_codigo.setToolTipText("Código");
		hab_codigo.setBounds(141, 82, 332, 34);
		panel_Habitacion.add(hab_codigo);

		JLabel Pro_Nombre = new JLabel("Tipo");
		Pro_Nombre.setFont(fuente);
		Pro_Nombre.setBounds(22, 137, 99, 14);
		panel_Habitacion.add(Pro_Nombre);

		// cambiar
		hab_tipo.setModel(new DefaultComboBoxModel(new String[] { "Sencillas",
				"Dobles", "Cuadruples", "Matrimoniales" }));
		hab_tipo.setBounds(141, 127, 332, 34);
		panel_Habitacion.add(hab_tipo);

		JLabel Pro_Marca = new JLabel("Clase");
		Pro_Marca.setFont(fuente);
		Pro_Marca.setBounds(22, 182, 99, 14);
		panel_Habitacion.add(Pro_Marca);

		hab_clase.setModel(new DefaultComboBoxModel(new String[] {
				"Vista a la calle", "Vista al parqueadero", "Sin ventana" }));
		hab_clase.setBounds(141, 172, 332, 34);
		panel_Habitacion.add(hab_clase);

		JLabel Pro_Precio = new JLabel("Precio Unitario");
		Pro_Precio.setFont(fuente);
		Pro_Precio.setBounds(618, 137, 100, 14);
		panel_Habitacion.add(Pro_Precio);

		hab_preciounitario.setToolTipText("Precio Unitario");
		hab_preciounitario.setBounds(723, 127, 332, 34);
		panel_Habitacion.add(hab_preciounitario);

		JLabel Pro_Buscar = new JLabel("Buscar ");
		Pro_Buscar.setBounds(345, 53, 75, 14);
		panel_Habitacion.add(Pro_Buscar);

		JLabel Pro_Estado = new JLabel("Estado");
		Pro_Estado.setFont(fuente);
		Pro_Estado.setBounds(664, 182, 46, 14);
		panel_Habitacion.add(Pro_Estado);

		hab_Activado.setBounds(723, 172, 100, 23);
		hab_Activado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado = true;

				hab_Activado.setSelected(true);
				hab_Activado.setEnabled(false);
				hab_Desactivado.setEnabled(true);
				hab_Desactivado.setSelected(false);
			}
		});
		panel_Habitacion.add(hab_Activado);

		hab_Desactivado.setBounds(723, 192, 100, 23);
		hab_Desactivado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado = !estado;

				hab_Desactivado.setSelected(true);
				hab_Desactivado.setEnabled(false);
				hab_Activado.setEnabled(true);
				hab_Activado.setSelected(false);
			}
		});
		panel_Habitacion.add(hab_Desactivado);

		hab_codigo.setEditable(false);

		hab_clase.setEditable(false);
		hab_preciounitario.setEditable(false);
		habitacion.cargardatosfichero();
		botones();
		grilla();

		if (modelo.getRowCount() != 0) {
			cargar();
		}

		return panel_Habitacion;
	}

	/**
	 * Botones. Añade los botones al contenedor y establece escuchadores para
	 * que esten atentos a las acciones dadas para realizar operaciones.
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
					hab_buscar.setVisible(false);
				}

				hab_codigo.setText(String.valueOf(modelo.getRowCount()));
				hab_preciounitario.setText(null);

				hab_codigo.setEditable(true);
				hab_preciounitario.setEditable(true);
			}
		});
		panel_Habitacion.add(nuevo);

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

				habitacion = new Lg_Habitacion(Integer.parseInt(hab_codigo
						.getText()), hab_tipo.getSelectedIndex() + 1, hab_clase
						.getSelectedIndex() + 1, Double
						.parseDouble(hab_preciounitario.getText()), estado);

				if (bn1) {
					habitacion.agregarHabitacion();
					modelo.addRow(new Object[] { hab_codigo.getText(),
							hab_tipo.getSelectedIndex() + 1,
							hab_clase.getSelectedIndex() + 1,
							hab_preciounitario.getText(), estado });

				} else {
					habitacion.ModificarProducto(Integer.parseInt(hab_codigo
							.getText()));
					modelo.setValueAt(hab_tipo.getSelectedIndex() + 1, n, 1);
					modelo.setValueAt(hab_clase.getSelectedIndex() + 1, n, 2);
					modelo.setValueAt(hab_preciounitario.getText(), n, 3);
					modelo.setValueAt(estado, n, 4);

				}
				cargar();
				try {
					habitacion.cargardatosfichero();
				} catch (ClassNotFoundException | IOException e) {

					e.printStackTrace();
				}
				for (int i = 0; i < modelo.getRowCount(); i++) {
					modificadorDeDatosTabla(i);
					if (habitacion.buscardatos(
							String.valueOf(modelo.getValueAt(i, 1))).equals(
							String.valueOf(modelo.getValueAt(i, 1)))) {
						modelo.setValueAt(habitacion.remplazo(String
								.valueOf(modelo.getValueAt(i, 1))), i, 1);

					}
				}

			}
		});
		panel_Habitacion.add(guardar);

		buscar.setToolTipText("Buscar");
		buscar.setIcon(new ImageIcon("imagenes/buscar.png"));
		buscar.setBounds(104, 11, 37, 34);
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				hab_clase.setEditable(false);
				hab_preciounitario.setEditable(false);

				guardar.setEnabled(false);

				buscar();
			}
		});
		panel_Habitacion.add(buscar);

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

				hab_clase.setEditable(true);
				hab_preciounitario.setEditable(true);
			}
		});
		panel_Habitacion.add(modificar);

		navegar();
	}

	/**
	 * Navegar. Establece botones de navegacion por la tabla y los datos de los
	 * cuadros de texto se van actualizando segun la fial de la tabla que este.
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
		panel_Habitacion.add(inicio);

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
		panel_Habitacion.add(anterior);

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
		panel_Habitacion.add(siguiente);

		fin.setIcon(new ImageIcon("imagenes/fin.png"));
		fin.setToolTipText("Fin");
		fin.setBounds(339, 11, 37, 34);
		fin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				n = tabla.getRowCount() - 1;
				cargar();
			}
		});
		panel_Habitacion.add(fin);
	}

	/**
	 * Grilla. Llena el modelo de la tabla por medio de un metodo de llenado de
	 * grilla.
	 */
	@SuppressWarnings("serial")
	public void grilla() {
		String cols[] = { "CODIGO", "TIPO", "CLASE", "PRECIO UNITARIO",
				"ESTADO" };
		tabla = new JTable(habitacion.llenargrilla(modelo, cols)) {
			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
				// no
			}
		};
		// hacer hasta que no sea mayor que la dimension de las filas de la
		// tabla.
		for (int i = 0; i < modelo.getRowCount(); i++) {
			modificadorDeDatosTabla(i);
			modificadorDatosLista(i);
		}

		tabla.setAutoCreateRowSorter(true);

		s = new JScrollPane(tabla);
		s.setBounds(32, 300, 1055, 400);

		panel_Habitacion.add(s);
	}

	/**
	 * Modificador de datos tabla. Modifica los datos de la tabla con nuevos
	 * valores por medio de una condicion.
	 * 
	 * @param i
	 *            the i
	 */
	public void modificadorDeDatosTabla(int i) {
		switch (String.valueOf(modelo.getValueAt(i, 4))) {
		case "true":
			modelo.setValueAt("Ocupada", i, 4);
			break;
		case "false":
			modelo.setValueAt("Desocupada", i, 4);
			break;
		}

		switch (String.valueOf(modelo.getValueAt(i, 2))) {
		case "1":
			modelo.setValueAt("Vista a la Calle", i, 2);
			break;
		case "2":
			modelo.setValueAt("Vista al Parqueadero", i, 2);
			break;
		case "3":
			modelo.setValueAt("Sin Ventana", i, 2);
			break;
		}

	}

	public void modificadorDatosLista(int i) {
		System.out.println(modelo.getValueAt(i, 1));
		if (habitacion.buscardatos(String.valueOf(modelo.getValueAt(i, 1)))
				.equals(String.valueOf(modelo.getValueAt(i, 1)))) {
			modelo.setValueAt(habitacion.remplazo(String.valueOf(modelo
					.getValueAt(i, 1))), i, 1);

		}
	}

	/**
	 * Buscar. Busca y selecciona la fila de la tabla en la que se encuentran el
	 * numero buscado. Una ves echo se actualiza los datos de la tabla
	 */
	public void buscar() {

		tbuscar.setFont(fuente);
		tbuscar.setBounds(615, 84, 332, 34);
		panel_Habitacion.add(tbuscar);

		hab_buscar = new JTextField(0) {

			private static final long serialVersionUID = 1L;

			public void fireCaretUpdate(CaretEvent arg0) {
				bn = !bn;

				for (int i = 0; i < tabla.getRowCount(); i++) {
					if (String.valueOf(tabla.getValueAt(i, 0))
							.equalsIgnoreCase(hab_buscar.getText())) {
						tabla.changeSelection(i, 1, false, false);
						n = tabla.getSelectedRow();
						cargar();
						break;
					}
				}
			}
		};
		hab_buscar.setBounds(723, 82, 332, 34);
		panel_Habitacion.add(hab_buscar);
	}

	/**
	 * Cargar. Actualiza los cuadros de texto con los parametros que hay en
	 * tabla
	 */
	public void cargar() {
		hab_codigo.setText(String.valueOf(tabla.getValueAt(n, 0)));
		hab_tipo.setSelectedItem(tabla.getValueAt(n, 1));
		hab_clase.setSelectedItem(tabla.getValueAt(n, 2));
		hab_preciounitario.setText(String.valueOf(tabla.getValueAt(n, 3)));

		if (String.valueOf(tabla.getValueAt(n, 4)).equalsIgnoreCase("Ocupada")) {
			hab_Activado.setSelected(true);
			hab_Activado.setEnabled(false);
			hab_Desactivado.setSelected(false);
			hab_Desactivado.setEnabled(true);
		} else {
			hab_Activado.setSelected(false);
			hab_Activado.setEnabled(true);
			hab_Desactivado.setSelected(true);
			hab_Desactivado.setEnabled(false);
		}
	}

}
