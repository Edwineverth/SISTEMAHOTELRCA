package interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;

import logica.Lg_Factura;
import logica.Lg_Validaciones;
import logica.Lg_Validaciones;;

/**
 * The Class In_FacturaServicios.
 * 
 * @author Edwin
 * @version 1.0
 */

public class In_FacturaServicios extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4670964045131164620L;

	/** The content pane. */
	private JPanel contentPane;

	/** The descripcion. */
	private JTextField descripcion;

	/** The cantidad. */
	private JTextField cantidad;

	/** The precio u. */
	private JTextField precioU;

	/** The total. */
	private JTextField total;

	/** The lbl servicio al cliente. */
	private JLabel lblServicioAlCliente;

	/** The table. */
	public JTable table;

	/** The btn agregar. */
	public JButton btnAgregar = new JButton("Agregar");

	/** The brn guardar. */
	public JButton brnGuardar = new JButton("Guardar");

	/** The imprimir. */
	public JButton imprimir = new JButton("imprimir");
	

	/** The n. */
	public int n = 3;

	/** The modelo. */
	DefaultTableModel modelo = new DefaultTableModel();

	/** The total final. */
	private JTextField totalFinal;

	/** The totall. */
	public double totall;

	/** The precio total. */
	public double precioTotal;

	/**
	 * Launch the application.
	 */
	public static JFrame v_servicios = new JFrame();

	/** The comprobacion. */
	public Lg_Validaciones comprobacion = new Lg_Validaciones();

	/**
	 * Run. crea la ventana y levanta los componentes
	 * 
	 */
	public static void run() {

		In_FacturaServicios servicios = new In_FacturaServicios();
		servicios.ventana();
		v_servicios.setLocationRelativeTo(null);
		v_servicios.setVisible(true);

	}

	/**
	 * Ventana. Levantan todos los compoenentes para añadirlos al contenedor.
	 */
	@SuppressWarnings("serial")
	public void ventana() {
		v_servicios.setTitle("FACTURA ");

		v_servicios.setDefaultCloseOperation(0);
		v_servicios.setBounds(100, 100, 799, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		v_servicios.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcion.setBounds(10, 61, 94, 14);
		contentPane.add(lblDescripcion);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBounds(10, 113, 56, 31);
		contentPane.add(lblTotal);

		descripcion = new JTextField();
		descripcion.setBounds(95, 58, 237, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);

		JLabel lblPrecioUnitario = new JLabel("Cantidad");
		lblPrecioUnitario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecioUnitario.setBounds(359, 61, 79, 14);
		contentPane.add(lblPrecioUnitario);

		cantidad = new JTextField();
		cantidad.setBounds(448, 58, 40, 20);
		contentPane.add(cantidad);
		cantidad.setColumns(10);

		precioU = new JTextField();
		precioU.setBounds(662, 58, 86, 20);
		contentPane.add(precioU);
		precioU.setColumns(10);

		JLabel lblPrecioU = new JLabel("Precio Unitario");
		lblPrecioU.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecioU.setBounds(552, 61, 100, 14);
		contentPane.add(lblPrecioU);

		total = new JTextField();
		total.setBounds(95, 117, 94, 25);
		contentPane.add(total);
		total.setColumns(10);
		totalFinal = new JTextField();
		totalFinal.setFont(new Font("Tahoma", Font.BOLD, 20));
		totalFinal.setBounds(662, 561, 98, 59);
		contentPane.add(totalFinal);
		totalFinal.setColumns(10);
		totalFinal.setEditable(false);

		JLabel lblTotal_1 = new JLabel("PRECIO TOTAL : ");
		lblTotal_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotal_1.setBounds(476, 575, 179, 33);
		contentPane.add(lblTotal_1);

		lblServicioAlCliente = new JLabel("FACTURA");
		lblServicioAlCliente
				.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblServicioAlCliente.setBounds(250, 11, 205, 36);
		contentPane.add(lblServicioAlCliente);

		String[] columnNames = { "Cantidad", "Descripcion", "P. Unitario",
				"TOTAL" };

		final JTable table = new JTable(llenargrilla(modelo, columnNames)) {
			public boolean isCellEditable(int rowIndex, int ColIndex) {

				return false;
			}
		};

		table.setBounds(10, 10, 500, 500);
		JScrollPane s = new JScrollPane(table);
		s.setBounds(10, 200, 750, 350);
		s.setViewportView(table);
		contentPane.add(s);
		botones();

	}

	/**
	 * Botones. Añade los botones a al contenedor y le asigna escuchadores a los
	 * cuadros de texto de cantidad y telefono para que esten atenos a que se
	 * cumplan ciertas condiciones dadas.
	 */
	public void botones() {

		cantidad.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && !cantidad.equals("")) {

					if (comprobacion.validarNumeros(cantidad)) {

					} else {
						JOptionPane.showMessageDialog(null,
								"Ingrese cantidades Enteras ");
					}
				} else {
					System.out.println("no coje");
				}

			}

		});
		precioU.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && !precioU.equals("")) {

					if (comprobacion.validarDecimales(precioU)) {

					} else {
						JOptionPane.showMessageDialog(null,
								"Ingrese cantidades Enteras ");
					}
				} else {
					System.out.println("no coje");
				}

			}

		});

		descripcion.setEditable(false);
		cantidad.setEditable(false);
		precioU.setEditable(false);
		total.setEditable(false);
		brnGuardar.setEnabled(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				brnGuardar.setEnabled(true);
				btnAgregar.setEnabled(false);
				descripcion.setEditable(true);
				cantidad.setEditable(true);
				precioU.setEditable(true);

			}
		});
		btnAgregar.setBounds(528, 126, 89, 32);
		contentPane.add(btnAgregar);

		brnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculoTotal();
				modelo.addRow(new Object[] {
						Integer.parseInt(cantidad.getText()),
						descripcion.getText(),
						Double.parseDouble(precioU.getText()), totall, });
				btnAgregar.setEnabled(true);
				brnGuardar.setEnabled(false);
				calculoPrecioTotal();
				try {
					table.print();

				} catch (PrinterException t) {
					// TODO Auto-generated catch block
					t.printStackTrace();
				}
			}
		});
		brnGuardar.setBounds(662, 126, 86, 31);
		contentPane.add(brnGuardar);

		imprimir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				v_servicios.setVisible(false);
				// TODO Auto-generated method stub
				try {
					table.print();

				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		imprimir.setBounds(422,126,86,31);
		contentPane.add(imprimir);

	}

	/** The factura r. */
	public In_Factura facturaR = new In_Factura();

	/** The factura g. */
	public Lg_Factura facturaG = new Lg_Factura();

	/**
	 * Llenargrilla. LLena la modelo de la tabla dados los parametros de modelo
	 * de la tabla y las columnas que se le añaden a la tabla.
	 * 
	 * @param model
	 *            the model
	 * @param cols
	 *            the cols
	 * @return the default table model
	 */
	@SuppressWarnings({ "unused", "static-access" })
	DefaultTableModel llenargrilla(DefaultTableModel model, String[] cols) {

		try {
			Object a[] = null;
			model.setColumnIdentifiers(cols);
			modelo.addRow(new Object[] { "            ---      ",
					"Hospedaje " + facturaR.cant + " Noches", facturaR.pu,
					facturaR.totalf });
		} catch (Exception e) {
			System.out.println("SE GUARDO");
		}
		return model;
	}

	/**
	 * Calculo total. Realiza una opecacion de calculo total y se le envia el
	 * parametro a un cuadro de texto.
	 */
	public void calculoTotal() {
		totall = Double.parseDouble(cantidad.getText())
				* Double.parseDouble(precioU.getText());
		total.setText(String.valueOf(totall));
	}

	/**
	 * Calculo precio total. establece operacion de suma para calcular el precio
	 * total y una ves echo se le envia los parametros al cuadro de texto
	 */
	public void calculoPrecioTotal() {
		precioTotal += precioTotal + totall;
		totalFinal.setText(String.valueOf(precioTotal));
	}

}
