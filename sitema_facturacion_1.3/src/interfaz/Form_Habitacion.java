/**
 * 
 */
package interfaz;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import com.mxrck.autocompleter.TextAutoCompleter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import logica.validaciones.Validaciones;
import logica.entidades.Lg_Habitacion;

/**
 * @author Dell Inspiron
 * @version 1.0
 */
public class Form_Habitacion extends JPanel {
	private JTextField txt_codigo;
	private JTextField txt_buscar;
	private JTextField txt_precio;
	private int n = 0;
	private boolean bn;
	private boolean bn1;
	private boolean estado = true;
	private DefaultTableModel modelo = new DefaultTableModel();
	public Validaciones comprobacion = new Validaciones();
	private JTable tabla;
	private JScrollPane s;
	private JLayeredPane panel_Habitacion = new JLayeredPane();
	private JToolBar toolBar = new JToolBar();
	private JComboBox cbxcategoria = new JComboBox();
	private JComboBox cbxtipo = new JComboBox();
	private JRadioButton ractivo = new JRadioButton("Activo");
	private JRadioButton rinactivo = new JRadioButton("Inactivo");
	private Lg_Habitacion habitacion = new Lg_Habitacion();
	private JButton btnNuevo = new JButton(new ImageIcon("imagenes/nuevodoc.png"));
	private JButton btnGuardar = new JButton(new ImageIcon("imagenes/savedata.png"));
	private JButton btnModificar = new JButton(new ImageIcon ("imagenes/modificdata.png"));
	private JButton btnCancelar = new JButton(new ImageIcon("imagenes/cancelar.png")); 
	private JLabel lblinformacion = new JLabel("Inicializando");

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public JLayeredPane run() throws SQLException {
		panel_Habitacion.setLayout(null);

		JPanel panel_hab = new JPanel();
		panel_hab.setLayout(null);
		panel_hab.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Registro Habitaciones",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_hab.setBounds(50, 80, 713, 214);
		panel_Habitacion.add(panel_hab);

		JLabel label = new JLabel("Buscar");
		label.setBounds(20, 24, 46, 14);
		panel_hab.add(label);

		JLabel label_1 = new JLabel("Codigo");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(10, 49, 56, 14);
		panel_hab.add(label_1);

		txt_codigo = new JTextField();
		txt_codigo.setColumns(10);
		txt_codigo.setBounds(76, 46, 86, 20);
		panel_hab.add(txt_codigo);

		ractivo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				estado = true;
				ractivo.setSelected(true);
				ractivo.setEnabled(false);
				rinactivo.setEnabled(true);
				rinactivo.setSelected(false);
			}
		});
		ractivo.setBounds(443, 129, 86, 23);
		ractivo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				estado = true;
				ractivo.setSelected(true);
				ractivo.setEnabled(false);
				rinactivo.setEnabled(true);
				rinactivo.setSelected(false);
			}
		});
		panel_hab.add(ractivo);

		rinactivo.setBounds(540, 129, 109, 22);
		rinactivo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				estado = !estado;
				rinactivo.setSelected(true);
				rinactivo.setEnabled(false);
				ractivo.setEnabled(true);
				ractivo.setSelected(false);
			}
		});
		panel_hab.add(rinactivo);

		JLabel label_10 = new JLabel("Estado");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(381, 133, 56, 14);
		panel_hab.add(label_10);

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

		txt_buscar.setBounds(76, 21, 86, 20);
		panel_hab.add(txt_buscar);
		txt_buscar.setColumns(10);

		txt_precio = new JTextField();
		txt_precio.setBounds(76, 72, 86, 20);
		panel_hab.add(txt_precio);
		txt_precio.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(20, 75, 46, 14);
		panel_hab.add(lblPrecio);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(20, 100, 46, 14);
		panel_hab.add(lblTipo);

		cbxtipo.setBounds(76, 97, 174, 20);
		cbxtipo.setModel(new DefaultComboBoxModel(new String[] {
				"Vista a la calle", "Vista al parqueadero", "Sin ventana" }));
		panel_hab.add(cbxtipo);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(351, 100, 86, 14);
		panel_hab.add(lblCategoria);

		cbxcategoria.setBounds(446, 97, 174, 20);
		cbxcategoria.setModel(new DefaultComboBoxModel(new String[] {
				"Sencillas", "Dobles", "Cuadruples", "Matrimoniales" }));
		panel_hab.add(cbxcategoria);

		toolBar.setBounds(0, 0, 820, 50);
		panel_Habitacion.add(toolBar);

		JPanel p_cargado = new JPanel();
		p_cargado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		p_cargado.setBounds(10, 173, 676, 30);
		panel_hab.add(p_cargado);

		p_cargado.add(lblinformacion);
		txt_codigo.setEditable(false);
		txt_precio.setEditable(false);

		botontes();
		grilla();
		validaciones();
		Autocompletado();
		if (modelo.getRowCount() != 0) {
			cargar();

		}

		return panel_Habitacion;

	}
	public void Autocompletado() throws SQLException {
		TextAutoCompleter autocompletado = new TextAutoCompleter(txt_buscar);
		for (int i = 0; i < habitacion.numeroHabitacion().size(); i++) {
			autocompletado.addItem( (String) habitacion.numeroHabitacion().get(i));

		}
		autocompletado.setMode(-1);

	}

	public void botontes() {
		btnGuardar.setEnabled(false);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bn1 = true;
				btnGuardar.setEnabled(true);
				txt_buscar.setEditable(false);
				txt_codigo.setEditable(false);
				txt_precio.setEditable(true);
				cbxcategoria.setEnabled(true);
				cbxtipo.setEnabled(true);

				txt_buscar.setText(null);
				try {
					txt_codigo.setText(String.valueOf(Integer.parseInt(habitacion.cantidad()) +1));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txt_precio.setText(null);

			}
		});
		toolBar.add(btnNuevo);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txt_codigo.getText().trim().length() == 0
						&& txt_precio.getText().trim().length() == 0) {
					System.out.println("hay campos vacios");

					lblinformacion
							.setText("Hay campos que aun estan sin llenar");
				} else {

					habitacion = new Lg_Habitacion(Integer.parseInt(txt_codigo
							.getText()), Double.parseDouble(txt_precio
							.getText()), estado,
							cbxtipo.getSelectedIndex() + 1, cbxcategoria
									.getSelectedIndex() + 1);

					if (bn1) {
						habitacion.agregarHabitacionCliente();
						modelo.addRow(new Object[] {
								Integer.parseInt(txt_codigo.getText()),
								Double.parseDouble(txt_precio.getText()),
								estado, cbxtipo.getSelectedIndex() + 1,
								cbxcategoria.getSelectedIndex() + 1 });

						modificadorDeDatosTabla(modelo.getRowCount() - 1);
					} else {
						habitacion.ModificarHabitacion(Integer
								.parseInt(txt_codigo.getText()));
						modelo.setValueAt(txt_precio.getText(), n, 1);
						modelo.setValueAt(estado, n, 2);
						modelo.setValueAt(cbxtipo.getSelectedIndex() + 1, n, 3);
						modelo.setValueAt(cbxcategoria.getSelectedIndex() + 1,
								n, 4);
						cargar();
						System.out
								.println("los datos se han cargado correctamente");
						lblinformacion
								.setText("Se ha Agregado una nueva Habitacion");

					}
				}

			}
		});
		toolBar.add(btnGuardar);

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardar.setEnabled(true);
				txt_codigo.setEditable(true);
				txt_precio.setEditable(true);

			}
		});
		toolBar.add(btnModificar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int op = JOptionPane.showConfirmDialog(null,
						"Desea Cancelar Operacion");
				if (op == JOptionPane.YES_OPTION) {
					
					txt_codigo.setEditable(false);
					txt_precio.setEditable(false);
					txt_buscar.setEditable(true);
					cbxcategoria.setEnabled(false);
					cbxtipo.setEnabled(false);
					
					txt_codigo.setText(null);
					txt_precio.setText(null);
					
		
				}
					
			}
		});
		toolBar.add(btnCancelar);
		
		
		
		navegador();

	}

	public void validaciones() {
		txt_codigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// /VALIDACION CODIGO
				comprobacion.validaNumeros(e);
			}
		});

	}

	public void navegador() {
		JButton btnInicio = new JButton(new ImageIcon("imagenes/datainicio.png"));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n = 0;
				cargar();
			}
		});
		toolBar.add(btnInicio);

		JButton btnAtras = new JButton(new ImageIcon ("imagenes/dataarriba.png"));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n > 0) {
					n--;
				}
				cargar();
			}
		});
		toolBar.add(btnAtras);

		JButton btnSiguiente = new JButton(new ImageIcon("imagenes/dataabajo.png"));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n < tabla.getRowCount() - 1) {
					n++;
				}
				cargar();
			}
		});
		toolBar.add(btnSiguiente);

		JButton btnFin = new JButton(new ImageIcon("imagenes/datafin.png"));
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
		txt_precio.setText(String.valueOf(tabla.getValueAt(n, 1)));
		cbxtipo.setSelectedItem(tabla.getValueAt(n, 3));
		cbxcategoria.setSelectedItem(tabla.getValueAt(n, 4));

		if (String.valueOf(tabla.getValueAt(n, 2)).equalsIgnoreCase("Ocupada")) {
			ractivo.setSelected(true);
			ractivo.setEnabled(false);
			rinactivo.setSelected(false);
			rinactivo.setEnabled(true);
		} else {
			ractivo.setSelected(false);
			ractivo.setEnabled(true);
			rinactivo.setSelected(true);
			rinactivo.setEnabled(false);
		}
	}

	public void grilla() {

		String cols[] = { "NUMERO", "PRECIO", "ESTADO", "TIPO HABITACION",
				"CATEGORIA HAB" };
		tabla = new JTable(habitacion.llenargrilla(modelo, cols)) {
			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
				// no
			}
		};

		for (int i = 0; i < modelo.getRowCount(); i++) {
			modificadorDeDatosTabla(i);
		}

		tabla.setAutoCreateRowSorter(true);
		s = new JScrollPane(tabla);
		s.setBounds(10, 300, 820, 200);

		panel_Habitacion.add(s);
	}

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

}
