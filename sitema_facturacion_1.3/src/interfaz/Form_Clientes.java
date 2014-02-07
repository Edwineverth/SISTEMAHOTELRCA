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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import org.apache.poi.hssf.record.formula.functions.If;

import com.mxrck.autocompleter.TextAutoCompleter;

import logica.entidades.Lg_Cliente;
import logica.entidades.Lg_Habitacion;
import logica.validaciones.Validaciones;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class Form_Clientes extends JPanel {
	private JTextField txt_codigo;
	private JTextField txt_nombre;
	private JTextField txt_telefono;
	private JTextField txt_ocupacion;
	private JTextField txt_cedula;
	private JTextField txt_apellido;
	private JTextField txt_direccion;
	private JTextField txt_procedencia;
	private JTextField txt_tipo;
	private JTextField txt_buscar;
	private int n = 0;
	private boolean bn;
	private boolean bn1;
	private boolean estado = true;
	private DefaultTableModel modelo = new DefaultTableModel();
	private Validaciones comprobacion = new Validaciones();
	private JTable tabla;
	private JScrollPane barraDesplazamiento;
	private Lg_Cliente c = new Lg_Cliente();
	private Lg_Habitacion h = new Lg_Habitacion();
	private JLayeredPane Panel_Cliente = new JLayeredPane();
	private JToolBar toolBar = new JToolBar();
	private JRadioButton rdbtnActivo = new JRadioButton("Activo");
	private JRadioButton rdbtnInactivo = new JRadioButton("Inactivo");
	private JButton btnNuevo = new JButton(new ImageIcon(
			"imagenes/nuevodoc.png"));
	private JButton btnGuardar = new JButton(new ImageIcon(
			"imagenes/savedata.png"));
	private JButton btnModificar = new JButton(new ImageIcon(
			"imagenes/modificdata.png"));
	private JLabel lblinformacion = new JLabel("Inicializando");
	
	private JButton btnCancelar = new JButton(new ImageIcon("imagenes/cancelar.png")); 

	public JLayeredPane run() throws SQLException {
		Panel_Cliente.setLayout(null);

		toolBar.setBounds(0, 0, 820, 50);
		toolBar.setBackground(new Color(153, 0, 0));
		Panel_Cliente.add(toolBar);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registro Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(50, 80, 713, 253);
		Panel_Cliente.add(panel);
		panel.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscar.setBounds(20, 24, 46, 14);
		panel.add(lblBuscar);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(10, 49, 56, 14);
		panel.add(lblCodigo);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setBounds(391, 49, 46, 14);
		panel.add(lblCedula);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 74, 56, 14);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(391, 74, 46, 14);
		panel.add(lblApellido);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(10, 99, 56, 14);
		panel.add(lblTelefono);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(391, 99, 46, 14);
		panel.add(lblDireccion);

		JLabel lblOcupacion = new JLabel("Ocupacion");
		lblOcupacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOcupacion.setBounds(10, 124, 56, 14);
		panel.add(lblOcupacion);

		JLabel lblProcedencia = new JLabel("Procedencia");
		lblProcedencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProcedencia.setBounds(352, 124, 85, 14);
		panel.add(lblProcedencia);

		txt_codigo = new JTextField();
		txt_codigo.setBounds(76, 46, 86, 20);
		panel.add(txt_codigo);
		txt_codigo.setColumns(10);

		txt_nombre = new JTextField();
		txt_nombre.setBounds(76, 71, 182, 20);
		panel.add(txt_nombre);
		txt_nombre.setColumns(10);

		txt_telefono = new JTextField();
		txt_telefono.setBounds(76, 96, 122, 20);
		panel.add(txt_telefono);
		txt_telefono.setColumns(10);

		txt_ocupacion = new JTextField();
		txt_ocupacion.setBounds(76, 121, 122, 20);
		panel.add(txt_ocupacion);
		txt_ocupacion.setColumns(10);

		txt_cedula = new JTextField();
		txt_cedula.setBounds(447, 46, 144, 20);
		panel.add(txt_cedula);
		txt_cedula.setColumns(10);

		txt_apellido = new JTextField();
		txt_apellido.setBounds(447, 71, 173, 20);
		panel.add(txt_apellido);
		txt_apellido.setColumns(10);

		txt_direccion = new JTextField();
		txt_direccion.setBounds(447, 96, 235, 20);
		panel.add(txt_direccion);
		txt_direccion.setColumns(10);

		txt_procedencia = new JTextField();
		txt_procedencia.setBounds(447, 121, 144, 20);
		panel.add(txt_procedencia);
		txt_procedencia.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(20, 149, 46, 14);
		panel.add(lblTipo);

		txt_tipo = new JTextField();
		txt_tipo.setBounds(76, 146, 122, 20);
		panel.add(txt_tipo);
		txt_tipo.setColumns(10);

		rdbtnActivo.setBounds(446, 148, 109, 23);
		rdbtnActivo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				estado = true;
				rdbtnActivo.setSelected(true);
				rdbtnActivo.setEnabled(false);
				rdbtnInactivo.setEnabled(true);
				rdbtnInactivo.setSelected(false);
			}
		});
		panel.add(rdbtnActivo);

		rdbtnInactivo.setBounds(446, 173, 109, 23);
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

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setBounds(381, 162, 56, 14);
		panel.add(lblEstado);

		txt_buscar = new JTextField(15) {

			public void fireCaretUpdate(CaretEvent arg0) {
				for (int i = 0; i < tabla.getRowCount(); i++) {
					if (String.valueOf(tabla.getValueAt(i, 1))
							.equalsIgnoreCase(txt_buscar.getText())
							||

							(String.valueOf(tabla.getValueAt(i, 2)) + " " + String
									.valueOf(tabla.getValueAt(i, 3)))
									.equalsIgnoreCase(txt_buscar.getText())) {
						System.out.println("son iguales");
						tabla.changeSelection(i, 1, false, false);
						tabla.changeSelection(i, 2, false, false);
						tabla.changeSelection(i, 3, false, false);
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

		JPanel p_cargado = new JPanel();
		p_cargado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		p_cargado.setBounds(10, 212, 693, 30);
		panel.add(p_cargado);

		p_cargado.add(lblinformacion);

		txt_codigo.setEditable(false);
		txt_nombre.setEditable(false);
		txt_apellido.setEditable(false);
		txt_telefono.setEditable(false);
		txt_direccion.setEditable(false);
		txt_ocupacion.setEditable(false);
		txt_procedencia.setEditable(false);
		txt_tipo.setEditable(false);
		botones();
		grilla();
		validaciones();
		Autocompletado();
		if (modelo.getRowCount() != 0) {
			cargar();

		}

		return Panel_Cliente;

	}

	public void Autocompletado() throws SQLException {
		TextAutoCompleter autocompletado = new TextAutoCompleter(txt_buscar);
		for (int i = 0; i < c.cedulaCliente().size(); i++) {
			autocompletado.addItem((String) c.cedulaCliente().get(i));

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
				comprobacion.validaNombre(e);

			}
		});

		txt_ocupacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// VALIDACION DE OCUPACION
				comprobacion.validaNombre(e);

			}
		});

		txt_procedencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// VALIDACION DE PROCEDENCIA
				comprobacion.validaNombre(e);

			}
		});

		txt_tipo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// VALIDACION DE TIPO CLIENTE
				comprobacion.validaNombre(e);

			}
		});

	}

	public void botones() {
		btnGuardar.setEnabled(false);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bn1 = true;
				btnNuevo.setEnabled(false);
				txt_buscar.setEnabled(false);
				txt_codigo.setEditable(false);
				txt_nombre.setEditable(true);
				txt_apellido.setEditable(true);
				txt_telefono.setEditable(true);
				txt_direccion.setEditable(true);
				txt_ocupacion.setEditable(true);
				txt_procedencia.setEditable(true);
				txt_tipo.setEditable(true);
				btnGuardar.setEnabled(true);
				try {
					txt_codigo.setText(String.valueOf(Integer.parseInt(c.cantidad()) +1));
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txt_cedula.setText(null);
				txt_nombre.setText(null);
				txt_apellido.setText(null);
				txt_telefono.setText(null);
				txt_direccion.setText(null);
				txt_ocupacion.setText(null);
				txt_procedencia.setText(null);
				txt_tipo.setText(null);
				
				
				
				txt_codigo.setEnabled(true);
				txt_nombre.setEnabled(true);
				txt_apellido.setEnabled(true);
				txt_cedula.setEnabled(true);
				txt_ocupacion.setEnabled(true);
				txt_procedencia.setEnabled(true);
				txt_direccion.setEnabled(true);
				txt_telefono.setEnabled(true);
				txt_tipo.setEnabled(true);

			}
		});
		toolBar.add(btnNuevo);

		btnGuardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (txt_codigo.getText().trim().length() == 0
						&& txt_nombre.getText().trim().length() == 0
						&& txt_apellido.getText().trim().length() == 0
						&& txt_telefono.getText().trim().length() == 0
						&& txt_direccion.getText().trim().length() == 0
						&& txt_ocupacion.getText().trim().length() == 0
						&& txt_procedencia.getText().trim().length() == 0
						&& txt_tipo.getText().trim().length() == 0) {

					System.out.println("hay campos vacios");
					lblinformacion.setText("Hay campos que estan vacios");

				} else {
					c = new Lg_Cliente(Integer.parseInt(txt_codigo.getText()),
							txt_cedula.getText(), txt_nombre.getText(),
							txt_apellido.getText(), txt_telefono.getText(),
							txt_direccion.getText(), txt_ocupacion.getText(),
							txt_procedencia.getText(), txt_tipo.getText(),
							estado);

					if (bn1) {
						c.AgregarCliente();
						modelo.addRow(new Object[] {
								Integer.parseInt(txt_codigo.getText()),
								txt_cedula.getText(), txt_nombre.getText(),
								txt_apellido.getText(), txt_telefono.getText(),
								txt_direccion.getText(),
								txt_ocupacion.getText(),
								txt_procedencia.getText(), txt_tipo.getText(),
								estado });
					} else {
						c.ModificarCliente(Integer.parseInt(txt_codigo
								.getText()));
						modelo.setValueAt(txt_cedula.getText(), n, 1);
						modelo.setValueAt(txt_nombre.getText(), n, 2);
						modelo.setValueAt(txt_apellido.getText(), n, 3);
						modelo.setValueAt(txt_telefono.getText(), n, 4);
						modelo.setValueAt(txt_direccion.getText(), n, 5);
						modelo.setValueAt(txt_ocupacion.getText(), n, 6);
						modelo.setValueAt(txt_procedencia.getText(), n, 7);
						modelo.setValueAt(txt_tipo.getText(), n, 8);
						modelo.setValueAt(estado, n, 9);
						btnModificar.setEnabled(true);
					}

					modificadorDatosTabla(n);

					cargar();
					txt_buscar.setEnabled(true);
					btnNuevo.setEnabled(true);
					btnGuardar.setEnabled(false);
					lblinformacion.setText("Informacion guardada con exito");
					txt_codigo.setEditable(false);
					txt_nombre.setEditable(false);
					txt_apellido.setEditable(false);
					txt_cedula.setEditable(false);
					txt_telefono.setEditable(false);
					txt_direccion.setEditable(false);
					txt_ocupacion.setEditable(false);
					txt_procedencia.setEditable(false);
					txt_tipo.setEditable(false);

				}

			}
		});
		toolBar.add(btnGuardar);

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txt_buscar.setEnabled(false);
				txt_codigo.setEditable(false);
				txt_nombre.setEditable(true);
				txt_apellido.setEditable(true);
				txt_telefono.setEditable(true);
				txt_direccion.setEditable(true);
				txt_ocupacion.setEditable(true);
				txt_procedencia.setEditable(true);
				txt_tipo.setEditable(true);
				btnGuardar.setEnabled(true);
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
					txt_ocupacion.setEnabled(false);
					txt_procedencia.setEnabled(false);
					txt_direccion.setEnabled(false);
					txt_telefono.setEnabled(false);
					txt_tipo.setEnabled(false);
					
					txt_codigo.setText(null);
					txt_nombre.setText(null);
					txt_apellido.setText(null);
					txt_cedula.setText(null);
					txt_ocupacion.setText(null);
					txt_procedencia.setText(null);
					txt_direccion.setText(null);
					txt_telefono.setText(null);
					txt_tipo.setText(null);
					btnModificar.setEnabled(true);
					
					
					
					
					
				}
				
				
			}
		});
		toolBar.add(btnCancelar);
		navegacion();

	}

	public void navegacion() {
		JButton btnInicio = new JButton(
				new ImageIcon("imagenes/datainicio.png"));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n = 0;
				cargar();
			}
		});
		toolBar.add(btnInicio);

		JButton btnAnterior = new JButton(new ImageIcon(
				"imagenes/dataarriba.png"));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n > 0) {
					n--;
				}
				cargar();
			}
		});
		toolBar.add(btnAnterior);

		JButton btnSiguiente = new JButton(new ImageIcon(
				"imagenes/dataabajo.png"));
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
		txt_cedula.setText(String.valueOf(tabla.getValueAt(n, 1)));
		txt_nombre.setText(String.valueOf(tabla.getValueAt(n, 2)));
		txt_apellido.setText(String.valueOf(tabla.getValueAt(n, 3)));
		txt_telefono.setText(String.valueOf(tabla.getValueAt(n, 4)));
		txt_direccion.setText(String.valueOf(tabla.getValueAt(n, 5)));
		txt_ocupacion.setText(String.valueOf(tabla.getValueAt(n, 6)));
		txt_procedencia.setText(String.valueOf(tabla.getValueAt(n, 7)));
		txt_tipo.setText(String.valueOf(tabla.getValueAt(n, 8)));

		if (String.valueOf(tabla.getValueAt(n, 9)).equalsIgnoreCase("activo")) {
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

	public void grilla() {

		String cols[] = { "CODIGO", "CEDULA", "NOMBRES", "APELLIDOS",
				"TELEFONO", "DIRECCION", "OCUAPCION", "PROCEDENCIA", "TIPO",
				"ESTADO" };
		tabla = new JTable(c.llenargrilla(modelo, cols)) {
			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}
		};

		for (int i = 0; i < modelo.getRowCount(); i++) {
			modificadorDatosTabla(i);
		}

		tabla.setAutoCreateRowSorter(true);
		barraDesplazamiento = new JScrollPane(tabla);
		barraDesplazamiento.setBounds(15, 350, 820, 200);
		barraDesplazamiento.setVisible(true);

		Panel_Cliente.add(barraDesplazamiento);
	}

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
}
