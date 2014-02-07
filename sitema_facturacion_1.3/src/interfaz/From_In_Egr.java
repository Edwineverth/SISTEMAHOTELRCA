/**
 * 
 */
package interfaz;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class From_In_Egr extends JPanel {
	private JTextField txt_codigo;
	private JTextField txt_pedido;
	private JTextField total;
	private JTextField txtTxttotalingreso;
	private JLayeredPane panel_gastos = new JLayeredPane();
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tabla;
	private JScrollPane s;
	private Font fuente = new Font("Tahoma", Font.BOLD, 11);
	private int n = 0;
	private boolean bn;
	private boolean bn1;
	boolean estado = true;

	/**
	 * Create the panel.
	 */
	public  JLayeredPane run() {
		panel_gastos.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ingresos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 800, 231);
		panel_gastos.add(panel);
		panel.setLayout(null);
		
		JLabel lblTotalDeIngresos = new JLabel("TOTAL DE INGRESOS");
		lblTotalDeIngresos.setBounds(10, 21, 140, 14);
		panel.add(lblTotalDeIngresos);
		
		txtTxttotalingreso = new JTextField();
		txtTxttotalingreso.setBounds(132, 15, 140, 20);
		panel.add(txtTxttotalingreso);
		txtTxttotalingreso.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Egresos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 285, 800, 264);
		panel_gastos.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 31, 46, 14);
		panel_1.add(lblCodigo);
		
		txt_codigo = new JTextField();
		txt_codigo.setBounds(73, 28, 110, 20);
		panel_1.add(txt_codigo);
		txt_codigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Pedido");
		lblNewLabel.setBounds(10, 62, 46, 14);
		panel_1.add(lblNewLabel);
		
		txt_pedido = new JTextField();
		txt_pedido.setBounds(73, 59, 232, 20);
		panel_1.add(txt_pedido);
		txt_pedido.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(10, 93, 46, 14);
		panel_1.add(lblTotal);
		
		total = new JTextField();
		total.setBounds(73, 90, 110, 20);
		panel_1.add(total);
		total.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setBounds(335, 27, 89, 23);
		panel_1.add(btnGuardar);
		return panel_gastos;

	}
}
