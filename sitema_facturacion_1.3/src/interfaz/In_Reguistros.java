package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.event.CaretEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;

import logica.Lg_Factura;

/**
 * The Class In_Reguistros.
 */
public class In_Reguistros {

	/** The factura. */
	Lg_Factura factura = new Lg_Factura();

	/** The fac_codigo. */
	JTextField fac_codigo = new JTextField();

	/** The cli_codigo. */
	JTextField cli_codigo = new JTextField();

	/** The Fac_ fecha. */
	JTextField Fac_Fecha = new JTextField();

	/** The fac_iva. */
	JTextField fac_iva = new JTextField();

	/** The fac_total. */
	JTextField fac_total = new JTextField();

	/** The fac_ subtotal. */
	JTextField fac_Subtotal = new JTextField();

	/** The cli_buscar. */
	JTextField cli_buscar;

	/** The tbuscar. */
	JLabel tbuscar = new JLabel("Codigo a Buscar");

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

	/** The Panel_ factura. */
	JLayeredPane Panel_Factura = new JLayeredPane();

	/** The modelo. */
	DefaultTableModel modelo = new DefaultTableModel();

	/** The tabla. */
	JTable tabla;

	/** The barraDesplazamiento. */
	JScrollPane s;

	/** The forma. */
	DecimalFormat forma = new DecimalFormat("####.##");

	/** The fuente. */
	Font fuente = new Font("Tahoma", Font.BOLD, 11);

	/** The n. */
	int n = 0;

	/** The estado. */
	boolean estado = true;

	/**
	 * Registros Añade a un contenedor toso los componentes dados en el metodo y
	 * devuelve pestaña panel con todos los datos añadidos
	 * 
	 * @return the j layered pane
	 */
	public JLayeredPane run() {
		Panel_Factura.setLayout(null);

		fac_codigo.setEditable(false);
		cli_codigo.setEditable(false);
		Fac_Fecha.setEditable(false);
		fac_iva.setEditable(false);
		fac_total.setEditable(false);
		fac_Subtotal.setEditable(false);

		JLabel Fac_Codigo = new JLabel("Codigo");
		Fac_Codigo.setFont(fuente);
		Fac_Codigo.setBounds(22, 92, 99, 14);
		Panel_Factura.add(Fac_Codigo);

		fac_codigo.setBounds(141, 82, 332, 34);
		Panel_Factura.add(fac_codigo);

		JLabel Fac_Codigo_Cliente = new JLabel("C\u00F3digo del Cliente");
		Fac_Codigo_Cliente.setFont(fuente);
		Fac_Codigo_Cliente.setBounds(22, 151, 110, 14);
		Panel_Factura.add(Fac_Codigo_Cliente);

		cli_codigo.setBounds(141, 141, 332, 34);
		Panel_Factura.add(cli_codigo);

		JLabel Fac_Subtotal_1 = new JLabel("Subtotal");
		Fac_Subtotal_1.setFont(fuente);
		Fac_Subtotal_1.setBounds(600, 230, 110, 14);
		Panel_Factura.add(Fac_Subtotal_1);

		fac_Subtotal.setBounds(712, 220, 332, 34);
		fac_Subtotal.setFont(fuente);
		Panel_Factura.add(fac_Subtotal);

		JLabel fecha_Reg = new JLabel("Fecha");
		fecha_Reg.setBounds(22, 208, 46, 14);
		fecha_Reg.setFont(fuente);
		Panel_Factura.add(fecha_Reg);
		Fac_Fecha.setBounds(141, 200, 332, 34);
		Panel_Factura.add(Fac_Fecha);

		JLabel Fac_Iva = new JLabel("Iva");
		Fac_Iva.setFont(fuente);
		Fac_Iva.setBounds(610, 133, 80, 14);
		Panel_Factura.add(Fac_Iva);

		fac_iva.setBounds(712, 123, 332, 34);
		Panel_Factura.add(fac_iva);

		JLabel Fac_Total = new JLabel("Total");
		Fac_Total.setFont(fuente);
		Fac_Total.setBounds(610, 178, 80, 14);
		Panel_Factura.add(Fac_Total);

		fac_total.setBounds(712, 168, 332, 34);
		Panel_Factura.add(fac_total);

		botones();

		grilla();

		if (modelo.getRowCount() != 0) {
			cargar();
		}
		JScrollPane s = new JScrollPane(tabla);
		s.setBounds(32, 300, 1055, 400);
		s.setViewportView(tabla);

		Panel_Factura.add(s);

		return Panel_Factura;
	}

	/**
	 * Botones. Levanta todos los botones en el contenedor y le da acciones para
	 * que cumplan con las condiciones dadas.
	 */
	public void botones() {
		guardar.setToolTipText("Guardar");
		guardar.setIcon(new ImageIcon("imagenes/guardar.png"));
		guardar.setBounds(57, 11, 37, 34);
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buscar.setEnabled(true);
				modificar.setEnabled(true);
				inicio.setEnabled(true);
				anterior.setEnabled(true);
				siguiente.setEnabled(true);
				fin.setEnabled(true);

				factura.ModificarFactura(Integer.parseInt(cli_codigo.getText()));

				cargar();

			}
		});
		Panel_Factura.add(guardar);

		buscar.setToolTipText("Buscar");
		buscar.setIcon(new ImageIcon("imagenes/buscar.png"));
		buscar.setBounds(104, 11, 37, 34);
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				guardar.setEnabled(false);

				buscar();
			}
		});
		Panel_Factura.add(buscar);

		modificar.setToolTipText("Modificar");
		modificar.setIcon(new ImageIcon("imagenes/modificar.png"));
		modificar.setBounds(151, 11, 37, 34);
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar.setEnabled(false);
				guardar.setEnabled(true);
				inicio.setEnabled(false);
				anterior.setEnabled(false);
				siguiente.setEnabled(false);
				fin.setEnabled(false);

			}
		});
		Panel_Factura.add(modificar);

		navegar();
	}

	/**
	 * Navegar. Actualiza los datos de los cuadros de texto por medio de una
	 * accion del boton navegador
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
		Panel_Factura.add(inicio);

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
		Panel_Factura.add(anterior);

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
		Panel_Factura.add(siguiente);

		fin.setIcon(new ImageIcon("imagenes/fin.png"));
		fin.setToolTipText("Fin");
		fin.setBounds(339, 11, 37, 34);
		fin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				n = tabla.getRowCount() - 1;
				cargar();
			}
		});
		Panel_Factura.add(fin);
	}

	/**
	 * Buscar. Establece una busqueda de datos y se sombrea la fila de la tabla
	 * en la que esta el parametro buscado
	 */
	public void buscar() {
		tbuscar.setFont(fuente);
		tbuscar.setBounds(590, 70, 332, 34);
		Panel_Factura.add(tbuscar);

		cli_buscar = new JTextField(15) {

			private static final long serialVersionUID = 1L;

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
		cli_buscar.setBounds(713, 70, 332, 34);
		Panel_Factura.add(cli_buscar);
	}

	/**
	 * Grilla. Llena el modelo de la tabla por medio de un metodos de llenado de
	 * tabla que debuelve un modelo tabla para implementarlo en la tabla.
	 */
	@SuppressWarnings("serial")
	public void grilla() {
		String cols[] = { "CODIGO DE FACTURA", "CODIGO DE CLIENTE", "FECHA",
				"SUBTOTAL", "IVA", "TOTAL" };
		tabla = new JTable(factura.llenargrilla(modelo, cols)) {
			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}
		};
	}

	/**
	 * Formato Tabla. Establece un estilo de formato en ciertas posicion de la
	 * tabla
	 * 
	 * @param i
	 *            the i
	 */
	public void formatoTabla(int i) {
		modelo.setValueAt(forma.format(modelo.getValueAt(i, 3)), i, 3);
		modelo.setValueAt(forma.format(modelo.getValueAt(i, 4)), i, 4);
		modelo.setValueAt(forma.format(modelo.getValueAt(i, 5)), i, 5);
	}

	/**
	 * Cargar. Actualiza los datos de los cuadros de texto por los datos que
	 * estan en las tabla.
	 */
	public void cargar() {
		fac_codigo.setText(String.valueOf(tabla.getValueAt(n, 0)));
		cli_codigo.setText(String.valueOf(tabla.getValueAt(n, 1)));
		Fac_Fecha.setText(String.valueOf(tabla.getValueAt(n, 2)));
		fac_iva.setText(String.valueOf(tabla.getValueAt(n, 3)));
		fac_total.setText(String.valueOf(tabla.getValueAt(n, 4)));
		fac_Subtotal.setText(String.valueOf(tabla.getValueAt(n, 5)));

	}

}
