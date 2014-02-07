/**
 * 
 */
package interfaz;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JButton;

/**
 * @author Dell Inspiron
 *@version 1.0
 */
public class Form_Roles extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Form_Roles() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Crear Nuevo Rol", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 58, 800, 173);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDeRol = new JLabel("Nombre");
		lblNombreDeRol.setBounds(10, 32, 75, 14);
		panel.add(lblNombreDeRol);
		
		JLabel lblDescipcion = new JLabel("Descipcion");
		lblDescipcion.setBounds(10, 92, 63, 14);
		panel.add(lblDescipcion);
		
		textField = new JTextField();
		textField.setBounds(10, 50, 399, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 117, 399, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 820, 39);
		add(toolBar);
		
		JButton btnNewButton = new JButton("Nuevo");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		toolBar.add(btnNewButton_1);

	}
}
