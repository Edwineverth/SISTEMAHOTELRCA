package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JEditorPane;
import javax.swing.JToolBar;
import javax.swing.JButton;

import com.mxrck.autocompleter.TextAutoCompleter;

import logica.entidades.Lg_Cliente;
import logica.entidades.Lg_Habitacion;
import logica.entidades.Recervacion;

public class From_reg_fac_aux extends JFrame {

	private JPanel contentPane;
	private JTextField txt_cod;
	private JTextField txt_nombre;
	private JTextField txt_cedula;
	private JTextField txt_apellido;
	private JTextField txt_direccion;
	private JTextField txt_procedencia;
	private JTextField txt_telefono;
	private JTextField txt_ocupacion;
	private JTextField txt_tipo;
	private JPanel panel_1;
	private JTextField txt_numero_hab;
	private JToolBar toolBar = new JToolBar();
	private JPanel panel = new JPanel();
	private boolean bn;
	private boolean bn1;
	private boolean estado = true;
	private JButton btnNuevo = new JButton("Nuevo");
	private JButton btnGuardar = new JButton("Guardar");
	private Lg_Cliente c = new Lg_Cliente();
	private JLabel lblinformacion = new JLabel("Inicializando");
	private JScrollPane panelDesplazamiento;
	private JList lista;
	private Vector listahab = new Vector<String>();
	private String[] listhab;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	private Lg_Habitacion habitacion = new Lg_Habitacion();
	private Recervacion recervacion = new Recervacion();
	private Calendar calendar = new GregorianCalendar();
	private Prueba_inicio p = new Prueba_inicio();
	private String codigoUsuario;
	private JButton btnAceptarcliente = new JButton("Aceptar");
	private JButton btnAgregar_habitacion = new JButton("Agregar");
	private JButton btnAceptar_habitacion = new JButton("Aceptar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					From_reg_fac_aux frame = new From_reg_fac_aux();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public From_reg_fac_aux() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel.setBorder(new TitledBorder(null, "Registro Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 63, 556, 245);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(23, 33, 60, 14);
		panel.add(lblCodigo);
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(23, 58, 60, 14);
		panel.add(lblNombre);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(317, 33, 73, 14);
		panel.add(lblCedula);
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(327, 58, 59, 14);
		panel.add(lblApellido);
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(23, 83, 60, 14);
		panel.add(lblTelefono);
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(317, 83, 69, 14);
		panel.add(lblDireccion);
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblOcupacion = new JLabel("Ocupacion");
		lblOcupacion.setBounds(23, 108, 60, 14);
		panel.add(lblOcupacion);
		lblOcupacion.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblProcedencia = new JLabel("Procedencia");
		lblProcedencia.setBounds(317, 108, 69, 14);
		panel.add(lblProcedencia);
		lblProcedencia.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(23, 137, 60, 14);
		panel.add(lblTipo);
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);

		txt_cod = new JTextField();
		txt_cod.setHorizontalAlignment(SwingConstants.LEFT);
		txt_cod.setBounds(93, 30, 60, 20);
		panel.add(txt_cod);
		txt_cod.setColumns(10);

		txt_nombre = new JTextField();
		txt_nombre.setBounds(93, 55, 155, 20);
		panel.add(txt_nombre);
		txt_nombre.setColumns(10);

		txt_cedula = new JTextField();
		txt_cedula.setBounds(396, 30, 108, 20);
		panel.add(txt_cedula);
		txt_cedula.setColumns(10);

		txt_apellido = new JTextField();
		txt_apellido.setBounds(396, 55, 137, 20);
		panel.add(txt_apellido);
		txt_apellido.setColumns(10);

		txt_direccion = new JTextField();
		txt_direccion.setBounds(396, 80, 137, 20);
		panel.add(txt_direccion);
		txt_direccion.setColumns(10);

		txt_procedencia = new JTextField();
		txt_procedencia.setBounds(396, 105, 137, 20);
		panel.add(txt_procedencia);
		txt_procedencia.setColumns(10);

		txt_telefono = new JTextField();
		txt_telefono.setBounds(93, 80, 122, 20);
		panel.add(txt_telefono);
		txt_telefono.setColumns(10);

		txt_ocupacion = new JTextField();
		txt_ocupacion.setBounds(93, 105, 122, 20);
		panel.add(txt_ocupacion);
		txt_ocupacion.setColumns(10);

		txt_tipo = new JTextField();
		txt_tipo.setBounds(93, 134, 122, 20);
		panel.add(txt_tipo);
		txt_tipo.setColumns(10);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Registro Habitaci\u00F3n",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(576, 70, 288, 238);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNHabitacion = new JLabel("N\u00B0 Habitacion");
		lblNHabitacion.setBounds(10, 58, 77, 14);
		panel_1.add(lblNHabitacion);

		txt_numero_hab = new JTextField();
		txt_numero_hab.setBounds(97, 55, 86, 20);
		panel_1.add(txt_numero_hab);
		txt_numero_hab.setColumns(10);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 30, 268, 14);
		panel_1.add(lblCliente);

		toolBar.setBounds(10, 11, 854, 41);
		contentPane.add(toolBar);
		btnGuardar.setEnabled(false);

		botones();
	//	Autocompletado();
		habilitaciones();

	}

	public void habilitaciones() {
		txt_cod.setEnabled(false);
		txt_cedula.setEnabled(false);
		txt_nombre.setEnabled(false);
		txt_apellido.setEnabled(false);
		txt_telefono.setEnabled(false);
		txt_direccion.setEnabled(false);
		txt_ocupacion.setEnabled(false);
		txt_procedencia.setEnabled(false);
		txt_tipo.setEnabled(false);
		txt_numero_hab.setEnabled(false);
		btnAceptar_habitacion.setEnabled(false);
		btnAceptarcliente.setEnabled(false);
		btnAgregar_habitacion.setEnabled(false);

	}

	public void Autocompletado() throws SQLException {
		TextAutoCompleter autocompletado = new TextAutoCompleter(txt_numero_hab);
		for (int i = 0; i < habitacion.numeroHabitacion().size(); i++) {
			autocompletado.addItem((String) habitacion.numeroHabitacion()
					.get(i));

		}
		autocompletado.setMode(-1);

	}

	public void botones() {

		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bn1 = true;
				txt_cod.setEnabled(true);
				txt_cedula.setEnabled(true);
				txt_nombre.setEnabled(true);
				txt_apellido.setEnabled(true);
				txt_telefono.setEnabled(true);
				txt_direccion.setEnabled(true);
				txt_ocupacion.setEnabled(true);
				txt_procedencia.setEnabled(true);
				txt_tipo.setEnabled(true);
				txt_numero_hab.setEnabled(false);
				btnNuevo.setEnabled(false);
				txt_cod.setEditable(true);
				txt_nombre.setEditable(true);
				txt_apellido.setEditable(true);
				txt_telefono.setEditable(true);
				txt_direccion.setEditable(true);
				txt_ocupacion.setEditable(true);
				txt_procedencia.setEditable(true);
				txt_tipo.setEditable(true);
				btnGuardar.setEnabled(false);
				btnAceptarcliente.setEnabled(true);
				txt_cod.setText(null);
				txt_cedula.setText(null);
				txt_nombre.setText(null);
				txt_apellido.setText(null);
				txt_telefono.setText(null);
				txt_direccion.setText(null);
				txt_ocupacion.setText(null);
				txt_procedencia.setText(null);
				txt_tipo.setText(null);

			}
		});

		toolBar.add(btnNuevo);

		btnGuardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String dia = Integer.toString(calendar.get(Calendar.DATE));
				String mes = Integer.toString(calendar.get(Calendar.MONTH));
				String annio = Integer.toString(calendar.get(Calendar.YEAR));
				try {
					codigoUsuario = recervacion.codigoUsuario(p.getCed());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				recervacion = new Recervacion();
				try {
					recervacion = new Recervacion(Integer.parseInt(recervacion
							.conteo() + 1), dia + "/" + mes + "/" + annio, dia
							+ "/" + mes + "/" + annio, Integer.parseInt(txt_cod
							.getText()), Integer.parseInt(txt_numero_hab
							.getText()), Integer.parseInt(codigoUsuario));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnGuardar.setEnabled(false);
				btnNuevo.setEnabled(true);

			}
		});
		toolBar.add(btnGuardar);

		btnAceptarcliente.setBounds(444, 206, 89, 28);
		btnAceptarcliente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (txt_cod.getText().trim().length() == 0
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
					c = new Lg_Cliente(Integer.parseInt(txt_cod.getText()),
							txt_cedula.getText(), txt_nombre.getText(),
							txt_apellido.getText(), txt_telefono.getText(),
							txt_direccion.getText(), txt_ocupacion.getText(),
							txt_procedencia.getText(), txt_tipo.getText(),
							estado);

					if (bn1) {
						c.AgregarCliente();

					} else {
						// c.ModificarCliente(Integer.parseInt(txt_cod
						// .getText()));

					}
				}
				btnAgregar_habitacion.setEnabled(true);
				txt_numero_hab.setEnabled(true);
				txt_cod.setEnabled(false);
				txt_cedula.setEnabled(false);
				txt_nombre.setEnabled(false);
				txt_apellido.setEnabled(false);
				txt_telefono.setEnabled(false);
				txt_direccion.setEnabled(false);
				txt_ocupacion.setEnabled(false);
				txt_procedencia.setEnabled(false);
				txt_tipo.setEnabled(false);
				
				btnAceptarcliente.setEnabled(false);
				btnAceptar_habitacion.setEnabled(true);

			}
		});
		panel.add(btnAceptarcliente);
		lista = new JList<>();

		btnAgregar_habitacion.setBounds(189, 54, 89, 23);
		btnAgregar_habitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.addElement(txt_numero_hab.getText());
				lista.setModel(modelo);
			}
		});
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		panelDesplazamiento = new JScrollPane(lista);

		panelDesplazamiento.setBounds(30, 100, 220, 70);
		panelDesplazamiento.setVisible(true);
		panel_1.add(panelDesplazamiento);
		panel_1.add(btnAgregar_habitacion);

		btnAceptar_habitacion.setBounds(189, 198, 89, 29);
		btnAceptar_habitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_numero_hab.setEnabled(false);
				lista.setEnabled(false);
				btnAgregar_habitacion.setEnabled(false);
				btnAceptar_habitacion.setEnabled(false);
				btnGuardar.setEnabled(true);
			}
		});
		panel_1.add(btnAceptar_habitacion);

	}
}
