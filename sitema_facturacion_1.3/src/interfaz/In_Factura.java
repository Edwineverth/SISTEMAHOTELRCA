package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import logica.Lg_Factura;

/**
 * The Class In_Factura.
 */
public class In_Factura {

	/** The factura. */
	Lg_Factura factura = new Lg_Factura();

	/** The fac_codigo. */
	JTextField fac_codigo = new JTextField();

	/** The fac_fecha. */
	JTextField fac_fecha = new JTextField();

	/** The cli_codigo. */
	JTextField cli_codigo = new JTextField();

	/** The cli_cedula. */
	JTextField cli_cedula = new JTextField();

	/** The fac_subtotal. */
	JTextField fac_subtotal = new JTextField();

	/** The fac_iva. */
	JTextField fac_iva = new JTextField();

	/** The fac_total. */
	JTextField fac_total = new JTextField();

	/** The servicio_habitacion. */
	JButton servicio_habitacion = new JButton();

	/** The fac_buscar. */
	JTextField fac_buscar;

	/** The tbuscar. */
	JLabel tbuscar = new JLabel("Ingresar Cedula a Buscar");

	/** The nuevo. */
	JButton nuevo = new JButton("");

	/** The guardar. */
	JButton guardar = new JButton("");

	/** The c. */
	Calendar c = new GregorianCalendar();

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

	/** The bn. */
	boolean bn = false;

	/** The preu. */
	double preu = 0;

	/** The total. */
	double total;

	/** The subtotal. */
	double subtotal;

	/** The iva. */
	double iva;

	/** The tip habi. */
	public String tipHabi;

	/** The Chb. */
	public String Chb;

	/** The cant. */
	static String cant;

	/** The totalf. */
	static String totalf;

	/** The pu. */
	static String pu;
	/** The fecha. */
	String fecha = c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1)
			+ "/" + c.get(Calendar.YEAR);

	/**
	 * Factura.
	 * Establece dotos los comopentes que va tener el contenedor
	 * y retorna un layerd pane 
	 * 
	 * @return the j layered pane
	 */
	public JLayeredPane run() {
		Panel_Factura.setLayout(null);

		JLabel Pro_Codigo_Cliente = new JLabel("Codigo del Cliente");
		Pro_Codigo_Cliente.setFont(fuente);
		Pro_Codigo_Cliente.setBounds(10, 58, 120, 14);
		Panel_Factura.add(Pro_Codigo_Cliente);

		cli_codigo.setEditable(false);
		cli_codigo.setBounds(129, 48, 332, 34);
		Panel_Factura.add(cli_codigo);

		JLabel Pro_Fecha = new JLabel("Fecha");
		Pro_Fecha.setFont(fuente);
		Pro_Fecha.setBounds(10, 108, 120, 14);
		Panel_Factura.add(Pro_Fecha);

		fac_fecha.setEditable(false);
		fac_fecha.setText(fecha);
		fac_fecha.setBounds(129, 98, 332, 34);
		Panel_Factura.add(fac_fecha);

		JLabel Pro_Cedula_cliente = new JLabel("Cedula del Cliente");
		Pro_Cedula_cliente.setFont(fuente);
		Pro_Cedula_cliente.setBounds(598, 58, 120, 14);
		Panel_Factura.add(Pro_Cedula_cliente);

		cli_cedula.setEditable(false);
		cli_cedula.setToolTipText("Ingresar Cedula");
		cli_cedula.setBounds(723, 48, 332, 34);
		cli_cedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cli_codigo.setText(factura.cedula(cli_cedula.getText()));
			}
		});
		Panel_Factura.add(cli_cedula);

		JLabel Pro_Numero_Factura = new JLabel("Numero de Factura");
		Pro_Numero_Factura.setFont(fuente);
		Pro_Numero_Factura.setBounds(598, 108, 120, 14);
		Panel_Factura.add(Pro_Numero_Factura);

		fac_codigo.setEditable(false);
		fac_codigo.setBounds(723, 98, 332, 34);
		Panel_Factura.add(fac_codigo);

		JLabel Fac_Subtotal = new JLabel("Subtotal");
		Fac_Subtotal.setFont(fuente);
		Fac_Subtotal.setBounds(10, 153, 120, 14);
		Panel_Factura.add(Fac_Subtotal);

		fac_subtotal.setToolTipText("Subtotal");
		fac_subtotal.setBounds(129, 143, 86, 34);
		Panel_Factura.add(fac_subtotal);

		JLabel Fac_Iva = new JLabel("Iva");
		Fac_Iva.setFont(fuente);
		Fac_Iva.setBounds(240, 153, 46, 14);
		Panel_Factura.add(Fac_Iva);

		fac_iva.setToolTipText("Iva");
		fac_iva.setBounds(276, 143, 53, 34);
		Panel_Factura.add(fac_iva);

		JLabel Fac_Total = new JLabel("Total");
		Fac_Total.setFont(fuente);
		Fac_Total.setBounds(342, 153, 46, 14);
		Panel_Factura.add(Fac_Total);

		fac_total.setToolTipText("Total");
		fac_total.setBounds(393, 143, 68, 34);
		Panel_Factura.add(fac_total);

		
		servicio_habitacion.setToolTipText("Servicio");
		servicio_habitacion.setText("SERVICIO");
		servicio_habitacion.setBounds(723, 150, 100, 34);
		Panel_Factura.add(servicio_habitacion);
		botones();
		grilla();
		JScrollPane s = new JScrollPane(tabla);
		s.setBounds(32, 200, 1055, 500);
		s.setViewportView(tabla);
		Panel_Factura.add(s);

		return Panel_Factura;
	}

	/**
	 * Botones.
	 */
	public void botones() {
		nuevo.setToolTipText("Nuevo");
		nuevo.setIcon(new ImageIcon("imagenes/nuevo.png"));
		nuevo.setBounds(10, 11, 37, 34);
		nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar.setEnabled(true);

				fac_codigo.setText(String.valueOf(factura.registros() + 1));
				fac_fecha.setText(fecha);
				cli_codigo.setText(null);
				cli_cedula.setText(null);

				cli_cedula.setEditable(true);
			}
		});
		Panel_Factura.add(nuevo);

		guardar.setEnabled(false);
		guardar.setToolTipText("Guardar");
		guardar.setIcon(new ImageIcon("imagenes/guardar.png"));
		guardar.setBounds(57, 11, 37, 34);
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("sdfsdf");
				String s = String.valueOf(modelo.getValueAt(0, 3));
				obtener(s);

				System.out.println(s);
				factura = new Lg_Factura(
						Integer.parseInt(fac_codigo.getText()), fecha, Integer
								.parseInt(cli_codigo.getText()));

				factura.AgregarFactura(total, subtotal, iva);

				for (int i = 0; i < modelo.getRowCount() - 1; i++) {
					factura.AgregarFacturaDe(Integer.parseInt(fac_codigo
							.getText()), Integer.parseInt(String.valueOf(modelo
							.getValueAt(i, 0))), Integer.parseInt(String
							.valueOf(modelo.getValueAt(i, 3))), Integer
							.parseInt(cli_codigo.getText()),
							Double.parseDouble(String.valueOf(modelo
									.getValueAt(i, 5))), Integer
									.parseInt(tipHabi), Integer.parseInt(Chb));
				}
			}
		});
		Panel_Factura.add(guardar);

		servicio_habitacion.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				In_FacturaServicios.run();

			}
		});

	}

	/**
	 * Grilla. Carga los datos en el modelo de tabla y establece edicion en
	 * ciertos celdas de la tabla para enviar parametros
	 */
	@SuppressWarnings("serial")
	public void grilla() {
		modelo.addColumn("Codigo");
		modelo.addColumn("Tipo");
		modelo.addColumn("Clase");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio Unitario");
		modelo.addColumn("Precio Total");

		tabla = new JTable(modelo) {
			public boolean isCellEditable(int rowIndex, int ColIndex) {
				if (ColIndex == 0 || ColIndex == 3)
					return true;
				else
					return false;
			}
		};

		modelo.addRow(new Object[] { "", "", "", "", "", "", });

		tabla.addKeyListener(new KeyAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
			 * 
			 * Establece un escuchador de eventos de tecleo y si se cumple la
			 * condicion se hace una consulta, enviando el codigo escrito e la
			 * primera celda de la tabla compara en base y comparado caraga los
			 * datos de la tabla de la base de datos en la tabla.
			 */
			public void keyReleased(KeyEvent e) {
				Object a[] = null;

				if (e.getKeyCode() == KeyEvent.VK_TAB
						&& !modelo.getValueAt(n, 0).equals("")) {
					try {
						bn = true;
						tabla.changeSelection(n, 3, true, true);
						a = factura.consulta(Integer.parseInt(String
								.valueOf(modelo.getValueAt(n, 0))));
						preu = Double.parseDouble(String.valueOf(a[3]));
						modelo.setValueAt(a[1], n, 1);
						tipHabi = String.valueOf(a[1]);
						modelo.setValueAt(a[2], n, 2);
						Chb = String.valueOf(a[2]);
						modelo.setValueAt(a[3], n, 4);

						for (int i = 0; i < modelo.getRowCount(); i++) {
							modificadorDeDatosTabla(i);
						}
						String c = String.valueOf(modelo.getValueAt(0, 4));
						getPrecioU(c);
					} catch (Exception e2) {
						JOptionPane
								.showMessageDialog(null,
										"Habitacion no encontrada o Error de Escritura");
					}

				}
				// Establece un escuchador que si es igual al evento entra y
				// realiza la operacion de multiplicacion de celdas de la tabla
				// y carga los datos nuevos de la tabla en los cuadros de texto.
				if (e.getKeyCode() == KeyEvent.VK_ENTER && bn == true
						&& !modelo.getValueAt(n, 3).equals("")) {
					try {
						double p = Integer.parseInt(String.valueOf(modelo
								.getValueAt(n, 3))) * preu;
						modelo.setValueAt(p + "0", n, 5);
						factura.calcular(Double.parseDouble(String
								.valueOf(modelo.getValueAt(n, 5))));

						cargar();
						bn = !bn;
						n++;

						tabla.changeSelection(n, 0, true, true);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,
								"Ingrese solo Numeros");
					}

				}
			}
		});

		cargar();

	}

	/**
	 * Cargar. carga los datos de la tabla en los cuadros de texto
	 */
	public void cargar() {
		total = factura.total;
		subtotal = factura.subtotal;
		iva = factura.iva;

		fac_subtotal.setText(String.valueOf(forma.format(factura.subtotal)));
		fac_iva.setText(String.valueOf(forma.format(factura.iva)));
		fac_total.setText(String.valueOf(forma.format(factura.total)));
		String e = String.valueOf(fac_total.getText());
		System.out.println(e);
		get(e);
	}

	/**
	 * Obtener. cambia el valor variable cant por los valores que se le envio al
	 * metodo
	 * 
	 * @param cantidad
	 */
	public void obtener(String cantidad) {
		cant = cantidad;
		System.out.println(cant);

	}

	/**
	 * Gets the. cambia el valor de un numero string y le asigna
	 * 
	 * @param the
	 *            e
	 */
	public void get(String e) {
		totalf = e;
	}

	/**
	 * the getprecio u. Obtiene cabia un valor de string por el valir dado en el
	 * metodo
	 * 
	 * @param the
	 *            e
	 */
	public void getPrecioU(String e) {
		pu = e;

	}

	/**
	 * Modificador de datos tabla. Modifica o cambia los parametros que hay en
	 * la tabla por nuevos valores establecida una condicion.
	 * 
	 * @param the
	 *            i
	 */
	public void modificadorDeDatosTabla(int i) {

		switch (String.valueOf(modelo.getValueAt(i, 1))) {
		case "1":
			modelo.setValueAt("Sencillas", i, 1);
			break;
		case "2":
			modelo.setValueAt("Dobles", i, 1);
			break;
		case "3":
			modelo.setValueAt("Cuadruples", i, 1);
			break;
		case "4":
			modelo.setValueAt("Matrimoniales", i, 1);
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

}
