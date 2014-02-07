/**
 * 
 */
package interfaz;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import com.mxrck.autocompleter.TextAutoCompleter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JRadioButton;

import logica.seguridad.Logica_Usuario;
import logica.validaciones.Validaciones;

public class Form_Usuario {

	private JTextField text_buscar;
	private JTextField txt_codigo;
	private JTextField txt_cedula;
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_telefono;
	private JTextField txt_direccion;
	private JTextField txt_clave;
	private JTextField txt_confirmacion;
	private JLayeredPane Panel_Usuario = new JLayeredPane();
	private int n = 0;
	private boolean bn;
	private boolean bn1;
	private boolean estado = true;
	private JToolBar toolBar = new JToolBar();
	private JButton btnNuevo = new JButton(new ImageIcon(
			"imagenes/nuevodoc.png"));
	private JButton btnGuardar = new JButton(new ImageIcon(
			"imagenes/savedata.png"));
	private JButton btnBuscar = new JButton("Buscar");
	private JButton btnModificar = new JButton(new ImageIcon(
			"imagenes/modificdata.png"));
	private JButton btnAnterior = new JButton(new ImageIcon(
			"imagenes/datainicio.png"));
	private JButton btnAtras = new JButton(new ImageIcon(
			"imagenes/dataarriba.png"));
	private JButton btnSiguiente = new JButton(new ImageIcon(
			"imagenes/dataabajo.png"));
	private JButton btnFin = new JButton(new ImageIcon("imagenes/datafin.png"));
	private JButton btnCancelar = new JButton(new ImageIcon("imagenes/cancelar.png")); 
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tabla;
	private JScrollPane s;
	private Validaciones comprobacion = new Validaciones();
	private JComboBox cbx_cargo = new JComboBox();
	private JRadioButton rdbtnActivo = new JRadioButton("Activo");
	private JRadioButton rdbtnInactivo = new JRadioButton("Inactivo");
	private boolean bn_estado = true;
	private JPanel panel = new JPanel();
	private JLabel lbconfirmacion = new JLabel("Confimacion");
	private Logica_Usuario usuario = new Logica_Usuario();
	private static JProgressBar barra;
	private JLabel lblinformacion = new JLabel("Inicializado");

	public JLayeredPane run() throws SQLException {
		Panel_Usuario.setLayout(null);

		toolBar.setBounds(0, 0, 820, 50);
		Panel_Usuario.add(toolBar);

		botones();

		panel.setBorder(new TitledBorder(null, "Registro Usuario",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 71, 800, 226);
		Panel_Usuario.add(panel);
		panel.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(10, 53, 66, 14);
		panel.add(lblCodigo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 78, 66, 14);
		panel.add(lblNombre);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscar.setBounds(10, 28, 66, 14);
		panel.add(lblBuscar);

		text_buscar = new JTextField(10) {

			public void fireCaretUpdate(CaretEvent arg0) {
				System.out.println("comienza");
				bn = !bn;
				System.out.println(bn);
				for (int i = 0; i < tabla.getRowCount(); i++) {
					if (String.valueOf(tabla.getValueAt(i, 1))
							.equalsIgnoreCase(text_buscar.getText())||
							
							(String.valueOf(tabla.getValueAt(i, 2))+" "+ String.valueOf(tabla.getValueAt(i, 3))).equalsIgnoreCase(text_buscar.getText())) {
						tabla.changeSelection(i, 1, false, false);
						tabla.changeSelection(i, 2, false, false);
						tabla.changeSelection(i, 3, false, false);
						n = tabla.getSelectedRow();
						System.out.println("marcado");
						cargar();
						break;
					}
				}
			}
		};
		text_buscar.setBounds(86, 22, 100, 20);
		panel.add(text_buscar);
		text_buscar.setColumns(10);
		text_buscar.setEditable(true);

		txt_codigo = new JTextField();

		txt_codigo.setBounds(86, 50, 100, 20);
		panel.add(txt_codigo);
		txt_codigo.setColumns(10);
		txt_codigo.setEditable(false);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setBounds(396, 53, 74, 14);
		panel.add(lblCedula);

		txt_cedula = new JTextField();

		txt_cedula.setBounds(480, 50, 300, 20);
		panel.add(txt_cedula);
		txt_cedula.setColumns(10);
		txt_cedula.setEditable(false);

		txt_nombre = new JTextField();

		txt_nombre.setBounds(86, 75, 300, 20);
		panel.add(txt_nombre);
		txt_nombre.setColumns(10);
		txt_nombre.setEditable(false);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(396, 78, 74, 14);
		panel.add(lblApellido);

		// CUADRO DE TEXTO APELLIDO
		txt_apellido = new JTextField();
		txt_apellido.setBounds(480, 75, 300, 20);
		panel.add(txt_apellido);
		txt_apellido.setColumns(10);
		txt_apellido.setEditable(false);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(10, 103, 66, 14);
		panel.add(lblTelefono);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(396, 103, 74, 14);
		panel.add(lblDireccion);

		txt_telefono = new JTextField();
		txt_telefono.setBounds(86, 100, 300, 20);
		panel.add(txt_telefono);
		txt_telefono.setColumns(10);
		txt_telefono.setEditable(false);

		txt_direccion = new JTextField();

		txt_direccion.setBounds(480, 100, 300, 20);
		panel.add(txt_direccion);
		txt_direccion.setColumns(10);
		txt_direccion.setEditable(false);

		JLabel lblClave = new JLabel("Clave");
		lblClave.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClave.setBounds(10, 128, 66, 14);
		panel.add(lblClave);

		txt_clave = new JTextField();

		txt_clave.setBounds(86, 125, 300, 20);
		panel.add(txt_clave);
		txt_clave.setColumns(10);
		txt_clave.setEditable(false);

		lbconfirmacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbconfirmacion.setBounds(396, 128, 74, 14);
		panel.add(lbconfirmacion);
		lbconfirmacion.setVisible(false);

		txt_confirmacion = new JTextField();

		txt_confirmacion.setBounds(480, 125, 300, 20);
		panel.add(txt_confirmacion);
		txt_confirmacion.setColumns(10);
		txt_confirmacion.setEditable(false);
		txt_confirmacion.setVisible(false);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCargo.setBounds(30, 153, 46, 14);
		panel.add(lblCargo);

		cbx_cargo.setModel(new DefaultComboBoxModel(new String[] {
				"Administrador", "Recepcionista" }));
		cbx_cargo.setBounds(86, 150, 300, 20);
		panel.add(cbx_cargo);

		JLabel estadoo = new JLabel("Estado");
		estadoo.setHorizontalAlignment(SwingConstants.RIGHT);
		estadoo.setBounds(406, 153, 64, 14);
		panel.add(estadoo);

		rdbtnActivo.setBounds(480, 149, 109, 23);
		rdbtnActivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado = true;

				rdbtnActivo.setSelected(true);// zzzz
				rdbtnActivo.setEnabled(false);
				rdbtnInactivo.setEnabled(true);
				rdbtnInactivo.setSelected(false);
			}
		});
		panel.add(rdbtnActivo);

		rdbtnInactivo.setBounds(671, 152, 109, 23);
		rdbtnInactivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado = !estado;
				rdbtnInactivo.setSelected(true);
				rdbtnInactivo.setEnabled(false);
				rdbtnActivo.setEnabled(true);
				rdbtnActivo.setSelected(false);

			}
		});

		panel.add(rdbtnInactivo);

		barra = new JProgressBar(0, 100);
		barra.setBounds(185, 320, 400, 10);

		JPanel p_cargado = new JPanel();
		p_cargado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		p_cargado.setBounds(10, 185, 780, 30);
		panel.add(p_cargado);

		p_cargado.add(lblinformacion);
		Autocompletado();
		validaciones();
		botones();
		grilla();
		for (int i = 0; i < modelo.getRowCount(); i++) {
			modificadorDatos(i);
		}
		if (modelo.getRowCount() != 0) {
			cargar();

		}

		return Panel_Usuario;

	}

	public void Autocompletado() throws SQLException {
		TextAutoCompleter autocompletado = new TextAutoCompleter(text_buscar);
		for (int i = 0; i < usuario.cedula().size(); i++) {
			autocompletado.addItem((String) usuario.cedula().get(i));

		}
		autocompletado.setMode(-1);

	}

	public void validaciones() {

		txt_codigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// /VALIDACION CODIGO
				comprobacion.validaNumeros(e);
			}
		});

		txt_cedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// VALIDACION CEDULA
				comprobacion.validaNumeros(e);
			}
		});

		txt_nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				// VALIDACION DE NOMBREEE
				comprobacion.validaNombre(e);
			}
		});

		txt_apellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// VALIDACION DE APELLIDOOOO
				comprobacion.validaNombre(e);
			}
		});

		txt_telefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// VALIDACION DE TELEFONO
				comprobacion.validaNumeros(e);
			}
		});

		txt_direccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				// VALIDACION DE DIRECCION

			}
		});

		txt_clave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				// VALIDACION DE CLAVE
				comprobacion.validaClave(e, txt_clave);
			}
		});

		txt_confirmacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				// /VALIDACION DE CONFIRMACION DE CLAVE

				comprobacion.validaClave(e, txt_clave);
			}
		});

	}

	public void botones() {

		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bn1 = true;

				btnModificar.setEnabled(false);
				btnGuardar.setEnabled(true);
				btnAnterior.setEnabled(false);
				btnAtras.setEnabled(false);
				btnSiguiente.setEnabled(false);
				btnFin.setEnabled(false);
				lbconfirmacion.setVisible(true);

				// HACIENDO NULOS
				txt_codigo.setEditable(false);
				try {
					txt_codigo.setText( String.valueOf(Integer.parseInt(usuario.cantidad()) +1) );
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txt_cedula.setText(null);
				txt_nombre.setText(null);
				txt_apellido.setText(null);
				txt_telefono.setText(null);
				txt_direccion.setText(null);
				txt_clave.setText(null);

				// haciendo Editables
				txt_confirmacion.setVisible(true);
				txt_confirmacion.setEditable(true);
				txt_codigo.setEditable(false);
				txt_cedula.setEditable(true);
				txt_nombre.setEditable(true);
				txt_apellido.setEditable(true);
				txt_telefono.setEditable(true);
				txt_direccion.setEditable(true);
				txt_clave.setEditable(true);
				txt_clave.setVisible(true);
				text_buscar.setEnabled(false);
				
				
				
				txt_codigo.setEnabled(true);
				txt_nombre.setEnabled(true);
				txt_apellido.setEnabled(true);
				txt_cedula.setEnabled(true);
				txt_clave.setEnabled(true);
				txt_confirmacion.setEnabled(true);
				txt_direccion.setEnabled(true);
				txt_telefono.setEnabled(true);

			}
		});
		toolBar.add(btnNuevo);

		// /GUARDADO DE VALORES
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNuevo.setEnabled(true);
				btnModificar.setEnabled(true);
				btnAnterior.setEnabled(true);
				btnAtras.setEnabled(true);
				btnSiguiente.setEnabled(true);
				btnFin.setEnabled(true);
				text_buscar.setEnabled(true);
				txt_confirmacion.setVisible(false);
				lbconfirmacion.setVisible(false);

				if (txt_clave.getText().equals(txt_confirmacion.getText())) {

					if (txt_codigo.getText().trim().length() == 0
							&& txt_nombre.getText().trim().length() == 0
							&& txt_apellido.getText().trim().length() == 0
							&& txt_telefono.getText().trim().length() == 0
							&& txt_direccion.getText().trim().length() == 0
							&& txt_clave.getText().trim().length() == 0
							&& txt_confirmacion.getText().trim().length() == 0) {

						System.out.println("CAMPOS VACIOS");

						lbconfirmacion.setText("Hay campos que estan Vacios");

					} else {

						usuario = new Logica_Usuario(Integer
								.parseInt(txt_codigo.getText()), txt_cedula
								.getText(), txt_nombre.getText(), txt_apellido
								.getText(), txt_telefono.getText(),
								txt_direccion.getText(), txt_clave.getText(),
								cbx_cargo.getSelectedIndex() + 1, estado);

						if (bn1) {
							usuario.Agregar_Usuario();
							modelo.addRow(new Object[] {
									Integer.parseInt(txt_codigo.getText()),
									txt_cedula.getText(), txt_nombre.getText(),
									txt_apellido.getText(),
									txt_telefono.getText(),
									txt_direccion.getText(),
									txt_clave.getText(),
									cbx_cargo.getSelectedIndex() + 1, estado });
							System.out.println(modelo.getRowCount());
							modificadorDatos(modelo.getRowCount() - 1);
						} else {
							usuario.ModificarUsuario(Integer
									.parseInt(txt_codigo.getText()));

							modelo.setValueAt(txt_cedula.getText(), n, 1);
							modelo.setValueAt(txt_nombre.getText(), n, 2);
							modelo.setValueAt(txt_apellido.getText(), n, 3);
							modelo.setValueAt(txt_telefono.getText(), n, 4);
							modelo.setValueAt(txt_direccion.getText(), n, 5);
							modelo.setValueAt(txt_clave.getText(), n, 6);
							modelo.setValueAt(cbx_cargo.getSelectedIndex() + 1,
									n, 7);
							modelo.setValueAt(estado, n, 8);
							modificadorDatos(n);
							
							lbconfirmacion.setVisible(false);
							txt_confirmacion.setVisible(false);
							btnModificar.setEnabled(true);
							btnGuardar.setEnabled(false);
							
						}

						cargar();
						for (int i = 0; i < modelo.getRowCount(); i++) {
							modificadorDatos(i);
						}
						lbconfirmacion
								.setText("Los datos han sido guardados con exito");

						txt_confirmacion.setVisible(false);
						txt_confirmacion.setEditable(false);
						txt_codigo.setEditable(false);
						txt_cedula.setEditable(false);
						txt_nombre.setEditable(false);
						txt_apellido.setEditable(false);
						txt_telefono.setEditable(false);
						txt_direccion.setEditable(false);
						txt_clave.setEditable(false);
						txt_clave.setVisible(true);
						text_buscar.setEnabled(true);

					}

				} else {
					System.out
							.println("la clave y la confirmacion no son identicas");
					lblinformacion
							.setText("La Clave y la Clave de Confirmacion no coinciden");

				}

			}
		});
		toolBar.add(btnGuardar);

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bn1 = false;
				// Modificando Botones
				btnNuevo.setEnabled(false);
				btnGuardar.setEnabled(true);
				btnAnterior.setEnabled(false);
				btnAtras.setEnabled(false);
				btnSiguiente.setEnabled(false);
				btnFin.setEnabled(false);
				// Modificando Cuadros de Texto
				txt_cedula.setEditable(true);
				txt_nombre.setEditable(true);
				txt_apellido.setEditable(true);
				txt_telefono.setEditable(true);
				txt_direccion.setEditable(true);
				txt_clave.setEditable(true);
				txt_confirmacion.setEditable(true);
				txt_confirmacion.setVisible(true);
				lbconfirmacion.setVisible(true);
				btnModificar.setEnabled(false);

			}
		});
		toolBar.add(btnModificar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int op = JOptionPane.showConfirmDialog(null,
						"Desea Cancelar Operacion");
				if (op == JOptionPane.YES_OPTION) {
					txt_codigo.setEnabled(false);
					txt_nombre.setEnabled(false);
					txt_apellido.setEnabled(false);
					txt_cedula.setEnabled(false);
					txt_clave.setEnabled(false);
					txt_confirmacion.setEnabled(false);
					txt_direccion.setEnabled(false);
					txt_telefono.setEnabled(false);
					text_buscar.setEnabled(true);
					text_buscar.setEditable(true);
					txt_codigo.setText(null);
					txt_nombre.setText(null);
					txt_apellido.setText(null);
					txt_cedula.setText(null);
					txt_clave.setText(null);
					txt_confirmacion.setText(null);
					txt_direccion.setText(null);
					txt_telefono.setText(null);
					btnModificar.setEnabled(true);
					
					
					
					
					
				}
				
				
			}
		});
		toolBar.add(btnCancelar);
		navegacion();

	}

	public void grilla() {

		String cols[] = { "CODIGO", "CEDULA", "NOMBRES", "APELLIDOS",
				"TELEFONO", "DIRECCION", "CLAVE", "ESTADO", "CARGO" };
		tabla = new JTable(usuario.llenargrilla(modelo, cols)) {
			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return true;
			}
		};

		for (int i = 0; i < modelo.getRowCount(); i++) {
			modificadorDatos(i);
		}
		tabla.setAutoCreateRowSorter(true);
		s = new JScrollPane(tabla);
		s.setBounds(13, 300, 790, 250);

		Panel_Usuario.add(s);
	}

	public void navegacion() {
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n = 0;
				cargar();

			}
		});
		toolBar.add(btnAnterior);

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n > 0) {
					n--;
				}
				cargar();

			}
		});
		toolBar.add(btnAtras);

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

				n = tabla.getRowCount() - 1;
				cargar();

			}
		});
		toolBar.add(btnFin);

	}

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

	public void cargar() {
		txt_codigo.setText(String.valueOf(tabla.getValueAt(n, 0)));
		txt_cedula.setText(String.valueOf(tabla.getValueAt(n, 1)));
		txt_nombre.setText(String.valueOf(tabla.getValueAt(n, 2)));
		txt_apellido.setText(String.valueOf(tabla.getValueAt(n, 3)));
		txt_telefono.setText(String.valueOf(tabla.getValueAt(n, 4)));
		txt_direccion.setText(String.valueOf(tabla.getValueAt(n, 5)));
		txt_clave.setText(String.valueOf(tabla.getValueAt(n, 6)));
		cbx_cargo.setSelectedItem(tabla.getValueAt(n, 7));

		if (String.valueOf(tabla.getValueAt(n, 8)).equalsIgnoreCase("activo")) {
			rdbtnActivo.setSelected(true);
			rdbtnActivo.setEnabled(false);
			rdbtnInactivo.setSelected(false);
			rdbtnInactivo.setEnabled(true);
		} else {
			rdbtnActivo.setSelected(false);
			rdbtnActivo.setEnabled(true);
			rdbtnInactivo.setSelected(true);
			rdbtnInactivo.setEnabled(false);
		}

	}

}
