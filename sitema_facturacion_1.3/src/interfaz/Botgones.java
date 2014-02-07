package interfaz;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Botgones extends JPanel {

	/**
	 * Create the panel.
	 */
	public Botgones() {
		setLayout(null);
		
		JButton btnRegistroHuesped = new JButton("Registro Huesped");
		btnRegistroHuesped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistroHuesped.setBounds(26, 278, 127, 65);
		add(btnRegistroHuesped);
		
		JButton btnNewButton = new JButton("Detalle Factura");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(336, 278, 127, 65);
		add(btnNewButton);

	}
}
