/**
 * 
 */
package interfaz;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.JButton;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.toedter.calendar.JDateChooser;

import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import logica.validaciones.Validaciones;
import logica.entidades.*;

/**
 * @author Dell Inspiron
 * @version 1.0
 */
public class Form_Recervacion extends JPanel {
	private JTextField txt_codigo;
	private JTextField txt_cedula;
	private JTextField txt_buscar;
	private JTextField txt_numerohabitacion;
	private JToolBar toolBar = new JToolBar();
	private JButton btnNuevo = new JButton(new ImageIcon(
			"imagenes/nuevodoc.png"));
	private JButton btnGuardar = new JButton(new ImageIcon(
			"imagenes/savedata.png"));
	private JButton btnInicio = new JButton(new ImageIcon(
			"imagenes/datainicio.png"));
	private JButton btnAnterior = new JButton(new ImageIcon(
			"imagenes/dataarriba.png"));
	private JButton btnSiguiente = new JButton(new ImageIcon(
			"imagenes/dataabajo.png"));
	private JButton btnFin = new JButton(new ImageIcon("imagenes/datafin.png"));
	private JButton btnCancelar = new JButton(new ImageIcon(
			"imagenes/cancelar.png"));

	private JDateChooser dateinicio = new JDateChooser();
	private JDateChooser datefin = new JDateChooser();
	private int n = 0;
	private boolean bn;
	private boolean bn1;
	private boolean estado = true;
	private DefaultTableModel modelo = new DefaultTableModel();
	public Validaciones comprobacion = new Validaciones();
	private JTable tabla;
	private JScrollPane barraDesplazamiento;
	private Recervacion r = new Recervacion();
	private JLayeredPane panel_Recervacion = new JLayeredPane();
	private Prueba_inicio p = new Prueba_inicio();
	private JLabel lblinformacion = new JLabel("Inicializando");
	private Lg_Habitacion lg_habitacion = new Lg_Habitacion();
	private Lg_Cliente lg_cliente = new Lg_Cliente();

	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public JLayeredPane run() throws SQLException {
		panel_Recervacion.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Registro Recervacion",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(50, 80, 713, 214);
		panel_Recervacion.add(panel);

		JLabel label = new JLabel("Buscar");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(20, 24, 46, 14);
		panel.add(label);

		JLabel label_1 = new JLabel("Codigo");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(10, 49, 56, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Cedula");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(20, 74, 46, 14);
		panel.add(label_2);

		txt_codigo = new JTextField();
		txt_codigo.setColumns(10);
		txt_codigo.setBounds(76, 46, 86, 20);
		panel.add(txt_codigo);

		txt_cedula = new JTextField();
		txt_cedula.setColumns(10);
		txt_cedula.setBounds(76, 71, 144, 20);
		panel.add(txt_cedula);

		txt_buscar = new JTextField(15) {

			public void fireCaretUpdate(CaretEvent arg0) {
				for (int i = 0; i < tabla.getRowCount(); i++) {
					if (String.valueOf(tabla.getValueAt(i, 0))
							.equalsIgnoreCase(txt_buscar.getText())) {
						tabla.changeSelection(i, 0, false, false);
						n = tabla.getSelectedRow();
						cargar();

						break;
					}
				}
			}
		};
		txt_buscar.setBounds(76, 21, 122, 20);
		panel.add(txt_buscar);
		txt_buscar.setColumns(10);

		JLabel lblNHabitacion = new JLabel("N\u00B0 Habitacion");
		lblNHabitacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNHabitacion.setBounds(391, 74, 91, 14);
		panel.add(lblNHabitacion);

		txt_numerohabitacion = new JTextField();
		txt_numerohabitacion.setBounds(492, 71, 86, 20);
		panel.add(txt_numerohabitacion);
		txt_numerohabitacion.setColumns(10);

		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInicio.setBounds(20, 99, 46, 14);
		panel.add(lblInicio);

		dateinicio.setBounds(76, 99, 144, 20);
		panel.add(dateinicio);

		JLabel lblFin = new JLabel("Fin");
		lblFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFin.setBounds(436, 102, 46, 14);
		panel.add(lblFin);

		datefin.setBounds(492, 102, 129, 20);
		panel.add(datefin);

		toolBar.setBounds(0, 0, 820, 50);
		panel_Recervacion.add(toolBar);

		JPanel p_cargado = new JPanel();
		p_cargado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		p_cargado.setBounds(10, 172, 693, 30);
		panel.add(p_cargado);
		p_cargado.add(lblinformacion);

		txt_codigo.setEditable(false);
		txt_cedula.setEditable(false);
		txt_numerohabitacion.setEditable(false);
		dateinicio.setEnabled(false);
		datefin.setEnabled(false);
		botones();
		validaciones();
		grilla();

		if (modelo.getRowCount() != 0) {
			cargar();

		}
		autocompletado();

		return panel_Recervacion;

	}

	public void autocompletado() throws SQLException {

		TextAutoCompleter autocompletadoCliente = new TextAutoCompleter(
				txt_cedula);
		for (int i = 0; i < lg_cliente.cedulaCliente().size(); i++) {
			autocompletadoCliente.addItem((String) lg_cliente.cedulaCliente()
					.get(i));

		}
		autocompletadoCliente.setMode(-1);

		TextAutoCompleter autocompletado = new TextAutoCompleter(
				txt_numerohabitacion);
		for (int i = 0; i < lg_habitacion.numeroHabitacion().size(); i++) {
			autocompletado.addItem((String) lg_habitacion.numeroHabitacion()
					.get(i));

		}
		autocompletado.setMode(-1);

	}

	public void validaciones() {

		txt_cedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// /VALIDACION CEDULA
				comprobacion.validaNumeros(e);
			}
		});
		txt_codigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// /VALIDACION CODIGO
				comprobacion.validaNumeros(e);
			}
		});
		txt_numerohabitacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// /VALIDACION NUMERO HABITACION
				comprobacion.validaNumeros(e);
			}
		});

	}

	public void botones() {
		btnGuardar.setEnabled(false);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardar.setEnabled(true);
				bn1 = true;
				txt_buscar.setEditable(false);
				txt_codigo.setEditable(false);
				txt_cedula.setEditable(true);
				txt_numerohabitacion.setEditable(true);
				dateinicio.setEnabled(true);
				datefin.setEnabled(true);

				try {
					txt_codigo.setText(String.valueOf(Integer.parseInt(r.cantidad()) +1));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txt_cedula.setText(null);
				txt_numerohabitacion.setText(null);

			}
		});
		toolBar.add(btnNuevo);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txt_codigo.getText().trim().length() == 0
						&& txt_cedula.getText().trim().length() == 0
						&& txt_numerohabitacion.getText().trim().length() == 0) {

					System.out.println("Hay campos vacios ");
					lblinformacion.setText("Hay campos que estan vacios");

				} else {

					String codigoCliente = null;
					String codigoUsuario = null;
					String nombreCliente = null;
					String nombreUsuario = null;
					java.util.Date date = dateinicio.getDate();
					java.util.Date date2 = datefin.getDate();
					SimpleDateFormat format2 = new SimpleDateFormat(
							"yyyy-MM-dd");
					String fechainicio = format2.format(date);
					String fechafin = format2.format(date2);

					try {
						codigoCliente = r.consultaCodigoCliente(txt_cedula
								.getText());
						nombreCliente = r.nombreCliente(txt_cedula.getText());
						codigoUsuario = r.codigoUsuario(p.getCed());
						nombreUsuario = r.nombreUsuario(p.getCed());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					r = new Recervacion(Integer.parseInt(txt_codigo.getText()),
							fechainicio, fechafin, Integer
									.parseInt(codigoCliente), Integer
									.parseInt(txt_numerohabitacion.getText()),
							Integer.parseInt(codigoUsuario));
					if (bn1) {
						r.AgregarRecervacion();
						try {
							System.out.println("nombre");
							System.out.println(r.nombreUsuario(p.getCed()));
							modelo.addRow(new Object[] {
									Integer.parseInt(txt_codigo.getText()),
									fechainicio, fechafin, nombreCliente,
									txt_numerohabitacion.getText(),
									String.valueOf(r.nombreUsuario(p.getCed())) });

						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						System.out.println("no modific");
					}
					btnGuardar.setEnabled(false);
					lblinformacion
							.setText("La Reservacion se ha echo con exito");
				}

			}
		});
		toolBar.add(btnGuardar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int op = JOptionPane.showConfirmDialog(null,
						"Desea Cancelar Operacion");
				if (op == JOptionPane.YES_OPTION) {

					txt_codigo.setEditable(false);
					txt_cedula.setEditable(false);
					txt_numerohabitacion.setEditable(false);
					txt_buscar.setEditable(true);
					datefin.setEnabled(false);
					dateinicio.setEnabled(false);

				}

			}
		});
		toolBar.add(btnCancelar);

		navegador();

	}

	public void navegador() {

		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n = 0;
				cargar();
			}
		});
		toolBar.add(btnInicio);

		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n > 0) {
					n--;
				}
				cargar();
			}
		});
		toolBar.add(btnAnterior);

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n < tabla.getRowCount() - 1) {
					n++;
				}
				cargar();
			}
		});
		toolBar.add(btnSiguiente);

		btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n < tabla.getRowCount() - 1) {
					n++;
				}
				cargar();
			}
		});
		toolBar.add(btnFin);

	}

	public void cargar() {
		txt_codigo.setText(String.valueOf(tabla.getValueAt(n, 0)));

		dateinicio.setToolTipText(String.valueOf(tabla.getValueAt(n, 1)));
		datefin.setToolTipText(String.valueOf(tabla.getValueAt(n, 2)));

		txt_numerohabitacion.setText(String.valueOf(tabla.getValueAt(n, 4)));

	}

	public void grilla() {

		String cols[] = { "N° Recerva", "FECHA INICIO", "FECHA FIN", "CLIENTE",
				"HABITACION", "RESPONSABLE" };
		tabla = new JTable(r.llenargrilla(modelo, cols)) {
			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}
		};

		for (int i = 0; i < modelo.getRowCount(); i++) {
			// modificadorDatosTabla(i);
		}

		tabla.setAutoCreateRowSorter(true);
		barraDesplazamiento = new JScrollPane(tabla);
		barraDesplazamiento.setBounds(15, 320, 820, 200);
		barraDesplazamiento.setVisible(true);

		panel_Recervacion.add(barraDesplazamiento);
	}
}
