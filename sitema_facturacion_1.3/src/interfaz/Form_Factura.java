/**
 * 
 */
package interfaz;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import logica.entidades.Recervacion;
import logica.entidades.Lg_Factura;
import logica.entidades.Lg_Cliente;
import logica.entidades.Reportes;
import logica.validaciones.ParseNumeros;

/**
 * @author Dell Inspiron
 * @version 1.0
 */
public class Form_Factura extends JPanel {
	public Form_Factura() {
	}

	private JTextField txt_buscar;
	private JTextField txt_codigo;
	private JTextField txt_cedula;
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_telefono;
	private JTextField txt_direccion;
	private JTextField txt_ocupacion;
	private JTextField txt_procedencia;
	private JTextField txt_subtotal;
	private JTextField txt_iva;
	private JTextField txt_total;
	private JLayeredPane Panel_Factura = new JLayeredPane();
	private JTextField txt_servicios;
	private JTextField txt_precio_hab;
	private JButton buscar = new JButton();
	private Object[] d;
	private JButton btnNuevo = new JButton(new ImageIcon(
			"imagenes/nuevodoc.png"));
	private JButton btnGuardar = new JButton(new ImageIcon(
			"imagenes/savedata.png"));
	private JButton btnImprimir = new JButton(new ImageIcon(
			"imagenes/dataimprimir.png"));
	private JToolBar toolBar = new JToolBar();
	private Recervacion r = new Recervacion();
	private Lg_Factura l = new Lg_Factura();
	private Prueba_principal principal = new Prueba_principal();
	private JLabel lblCargar = new JLabel("Inicializando");
	private Lg_Cliente lg_cliente = new Lg_Cliente();
	private Prueba_inicio codigo_usu = new Prueba_inicio();
	private Recervacion re = new Recervacion();
	private Calendar calendar = new GregorianCalendar();
	private JComboBox comboBoxtipopago = new JComboBox();
	private JButton btnCancelar = new JButton(new ImageIcon(
			"imagenes/cancelar.png"));
	private ParseNumeros parceo = new ParseNumeros();

	private JLabel lblrecerva = new JLabel("N° R");
	private JTextField txtrecerva = new JTextField();

	public JLayeredPane run() throws SQLException {
		Panel_Factura.setLayout(null);

		toolBar.setBounds(0, 0, 820, 50);
		Panel_Factura.add(toolBar);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Control Factura",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 76, 800, 260);
		Panel_Factura.add(panel);
		panel.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(10, 93, 46, 14);
		panel.add(lblCodigo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 118, 46, 14);
		panel.add(lblNombre);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscar.setBounds(10, 28, 46, 14);
		panel.add(lblBuscar);

		txt_buscar = new JTextField();
		txt_buscar.setEditable(false);
		txt_buscar.setBounds(66, 22, 90, 20);
		panel.add(txt_buscar);
		txt_buscar.setColumns(10);

		buscar.setEnabled(false);
		buscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String codigoCliente = null;
				String codigohab = null;
				double preciohab = 0;

				try {
					l.nombre(txt_buscar.getText(), txt_buscar.getText(),
							txt_buscar.getText());
					d = l.getVector();
					for (int i = 0; i < d.length; i++) {
						System.out.println(d[i]);
						carga(d);
					}

					if (r.consultaCodigoCliente(txt_buscar.getText()) == null) {
						System.out.println("no se encuentra cliente");
						int op = JOptionPane.showConfirmDialog(null,
								"Cliente no encontrado desea Registrarlo");
						if (op == JOptionPane.YES_OPTION) {
							From_reg_fac_aux aux = new From_reg_fac_aux();
							aux.setVisible(true);
						}

					} else if (l.codigoHab(r.consultaCodigoCliente(txt_buscar
							.getText())) == null) {
						System.out.println("no se encuentra la habitacion");
						lblCargar.setText("NO SE ENCUENTRA LA HABITACIÓN");

					} else if (l.precioHab(l.codigoHab(r
							.consultaCodigoCliente(txt_buscar.getText()))) == null) {
						lblCargar.setText("Error en los datos");
						System.out.println("error de datos ");

					} else {
						preciohab = Double.parseDouble(l.precioHab(l
								.codigoHab(r.consultaCodigoCliente(txt_buscar
										.getText()))));
						txt_precio_hab.setText(String.valueOf(preciohab));
					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		buscar.setBounds(165, 22, 20, 20);
		panel.add(buscar);

		txt_codigo = new JTextField();
		txt_codigo.setEditable(false);
		txt_codigo.setBounds(66, 90, 40, 20);
		panel.add(txt_codigo);
		txt_codigo.setColumns(10);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setBounds(396, 93, 64, 14);
		panel.add(lblCedula);

		txt_cedula = new JTextField();
		txt_cedula.setEditable(false);
		txt_cedula.setBounds(470, 90, 320, 20);
		panel.add(txt_cedula);
		txt_cedula.setColumns(10);

		txt_nombre = new JTextField();
		txt_nombre.setEditable(false);
		txt_nombre.setBounds(66, 115, 320, 20);
		panel.add(txt_nombre);
		txt_nombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(396, 118, 64, 14);
		panel.add(lblApellido);

		txt_apellido = new JTextField();
		txt_apellido.setEditable(false);
		txt_apellido.setBounds(470, 115, 320, 20);
		panel.add(txt_apellido);
		txt_apellido.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(10, 143, 46, 14);
		panel.add(lblTelefono);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(396, 143, 64, 14);
		panel.add(lblDireccion);

		txt_telefono = new JTextField();
		txt_telefono.setEditable(false);
		txt_telefono.setBounds(66, 140, 320, 20);
		panel.add(txt_telefono);
		txt_telefono.setColumns(10);

		txt_direccion = new JTextField();
		txt_direccion.setEditable(false);
		txt_direccion.setBounds(470, 140, 320, 20);
		panel.add(txt_direccion);
		txt_direccion.setColumns(10);

		JLabel lblClave = new JLabel("Ocupacion");
		lblClave.setHorizontalAlignment(SwingConstants.LEFT);
		lblClave.setBounds(10, 168, 57, 14);
		panel.add(lblClave);

		txt_ocupacion = new JTextField();
		txt_ocupacion.setEditable(false);
		txt_ocupacion.setBounds(66, 165, 320, 20);
		panel.add(txt_ocupacion);
		txt_ocupacion.setColumns(10);

		JLabel lblNewLabel = new JLabel("Procedencia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(396, 168, 64, 14);
		panel.add(lblNewLabel);

		txt_procedencia = new JTextField();
		txt_procedencia.setEditable(false);
		txt_procedencia.setBounds(470, 168, 320, 20);
		panel.add(txt_procedencia);
		txt_procedencia.setColumns(10);

		comboBoxtipopago.setBounds(471, 59, 319, 20);
		comboBoxtipopago.setModel(new DefaultComboBoxModel(new String[] {
				"Efectivo", "Cheque", "Tarjeta Credito" }));
		panel.add(comboBoxtipopago);

		JLabel lblNewLabel_2 = new JLabel("Tipo de Pago");
		lblNewLabel_2.setBounds(388, 62, 72, 14);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 350, 800, 178);
		Panel_Factura.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Subtotal:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(586, 76, 46, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblIva = new JLabel("Iva:");
		lblIva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIva.setBounds(586, 107, 46, 14);
		panel_1.add(lblIva);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(586, 138, 46, 14);
		panel_1.add(lblTotal);

		txt_subtotal = new JTextField();
		txt_subtotal.setEditable(false);
		txt_subtotal.setBounds(642, 73, 86, 20);
		panel_1.add(txt_subtotal);
		txt_subtotal.setColumns(10);

		txt_iva = new JTextField();
		txt_iva.setEditable(false);
		txt_iva.setBounds(642, 104, 86, 20);
		panel_1.add(txt_iva);
		txt_iva.setColumns(10);

		txt_total = new JTextField();
		txt_total.setEditable(false);
		txt_total.setBounds(642, 135, 86, 20);
		panel_1.add(txt_total);
		txt_total.setColumns(10);

		JLabel lblServicios = new JLabel("Servicios:");
		lblServicios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblServicios.setBounds(574, 45, 58, 14);
		panel_1.add(lblServicios);

		txt_servicios = new JTextField();
		txt_servicios.setEditable(false);
		txt_servicios.setBounds(642, 42, 86, 20);
		panel_1.add(txt_servicios);
		txt_servicios.setColumns(10);

		txt_precio_hab = new JTextField();
		txt_precio_hab.setEditable(false);
		txt_precio_hab.setBounds(642, 11, 86, 20);
		panel_1.add(txt_precio_hab);
		txt_precio_hab.setColumns(10);

		JLabel lblPrecioHab = new JLabel("Precio Hab.");
		lblPrecioHab.setBounds(574, 14, 58, 14);
		panel_1.add(lblPrecioHab);

		lblrecerva.setBounds(10, 59, 50, 20);
		panel.add(lblrecerva);

		txtrecerva.setBounds(65, 59, 50, 20);
		panel.add(txtrecerva);

		JPanel panel_2 = new JPanel();

		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_2.setBounds(10, 214, 770, 36);
		panel.add(panel_2);

		panel_2.add(lblCargar);

		botones();
		autollenado();
		//autocompleter();
		return Panel_Factura;
	}

	public void autollenado() throws SQLException {
		TextAutoCompleter autocompletado = new TextAutoCompleter(txt_buscar);
		for (int i = 0; i < lg_cliente.cedulaClientee().size(); i++) {
			autocompletado.addItem((String) lg_cliente.cedulaClientee().get(i));

		}
		autocompletado.setMode(-1);

	}

	public void autocompleter() throws SQLException {

		TextAutoCompleter autocompletado = new TextAutoCompleter(txtrecerva);
		for (int i = 0; i < l.cantidadrecervas().size(); i++) {
			autocompletado.addItem((String) l.cantidadrecervas().get(i));

		}
		autocompletado.setMode(-1);

	}

	public void botones() {
		btnGuardar.setEnabled(false);
		btnImprimir.setEnabled(false);
		btnNuevo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				buscar.setEnabled(true);
				txt_servicios.setEditable(true);
				txt_buscar.setEditable(true);
				btnNuevo.setEnabled(false);
				btnGuardar.setEnabled(true);
				btnImprimir.setEnabled(true);
				lblCargar.setText("Ingrese la Cedula del Cliente");
			}
		});
		toolBar.add(btnNuevo);
		btnGuardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				l = new Lg_Factura();

				txt_servicios.setEditable(false);

				if (!(txt_servicios.getText().trim().length() == 0)) {
					txt_subtotal.setText(String.valueOf(l.redondear(l
							.CalculoSubtotal(Double.parseDouble(txt_precio_hab
									.getText())
									+ Double.parseDouble(txt_servicios
											.getText())), 2)));

				} else {

					txt_subtotal.setText(String.valueOf(l.redondear(l
							.CalculoSubtotal(Double.parseDouble(txt_precio_hab
									.getText())), 2)));
					txt_servicios.setText("0");

				}

				txt_iva.setText(String.valueOf(l.redondear(l.CalculoIva(
						Double.parseDouble(txt_subtotal.getText()),
						Double.parseDouble(txt_precio_hab.getText())), 2)));

				txt_total.setText(txt_precio_hab.getText());

				try {
					java.util.Date date = calendar.getTime();

					SimpleDateFormat format2 = new SimpleDateFormat(
							"yyyy-MM-dd");
					String fecha = format2.format(date);

					System.out.println("dsfsdf");
					System.out.println(fecha);

					l = new Lg_Factura(Integer.parseInt(txt_codigo.getText()),
							Double.parseDouble(txt_servicios.getText()), Double
									.parseDouble(txt_subtotal.getText()),
							Double.parseDouble(txt_iva.getText()), Double
									.parseDouble(txt_total.getText()), fecha,
							true, comboBoxtipopago.getSelectedIndex() + 1,
							Integer.parseInt(txtrecerva.getText()), Integer
									.parseInt(r.codigoUsuario(codigo_usu
											.getCed())));

				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				l.AgregarFactura(Double.parseDouble(txt_total.getText()),
						Double.parseDouble(txt_subtotal.getText()),
						Double.parseDouble(txt_iva.getText()),
						Double.parseDouble(txt_servicios.getText()));

				Double con = Double.parseDouble(txt_total.getText()) ;
				
				
				
				int conver =   (int)Math.floor(con) ;
				
				
				
				l.AgregarFacturaDe(Double.parseDouble(txt_total.getText()),
						Double.parseDouble(txt_subtotal.getText()), Double
								.parseDouble(txt_iva.getText()), Double
								.parseDouble(txt_servicios.getText()), Double
								.parseDouble(txt_total.getText()), "HOSPEDAJE",
						parceo.convertirLetras(conver));
				System.out.println(parceo.convertirLetras( String.valueOf((int)(Double.parseDouble(txt_total.getText()))
						)
						));

				btnGuardar.setEnabled(false);
				btnImprimir.setEnabled(true);
				lblCargar
						.setText("La Factura se ha creado correctamente, puede imprimir");

			}
		});
		toolBar.add(btnGuardar);
		btnImprimir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Reportes reporte = new Reportes();
				reporte.Reporte("facturaRCA");
				lblCargar.setText("Impresion Realizada");
				l.vaciar();
			btnNuevo.setEnabled(true);
				btnImprimir.setEnabled(false);
				btnGuardar.setEnabled(false);
				
			}
		});
		toolBar.add(btnImprimir);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int op = JOptionPane.showConfirmDialog(null,
						"Desea Cancelar Operacion");
				if (op == JOptionPane.YES_OPTION) {
					txt_codigo.setEnabled(false);
					txt_nombre.setEnabled(false);
					txt_apellido.setEnabled(false);
					txt_cedula.setEnabled(false);
					txt_ocupacion.setEnabled(false);
					txt_procedencia.setEnabled(false);
					txt_direccion.setEnabled(false);
					txt_telefono.setEnabled(false);
					txt_codigo.setText(null);
					txt_nombre.setText(null);
					txt_apellido.setText(null);
					txt_cedula.setText(null);
					txt_ocupacion.setText(null);
					txt_procedencia.setText(null);
					txt_direccion.setText(null);
					txt_telefono.setText(null);
					btnNuevo.setEnabled(true);

				}

			}
		});
		toolBar.add(btnCancelar);
	}

	public void carga(Object data[]) {
		txt_codigo.setText(String.valueOf(data[0]));
		txt_cedula.setText(String.valueOf(data[1]));
		txt_nombre.setText(String.valueOf(data[2]));
		txt_apellido.setText(String.valueOf(data[3]));
		txt_telefono.setText(String.valueOf(data[4]));
		txt_direccion.setText(String.valueOf(data[5]));
		txt_ocupacion.setText(String.valueOf(data[6]));
		txt_procedencia.setText(String.valueOf(data[7]));
	}

}
