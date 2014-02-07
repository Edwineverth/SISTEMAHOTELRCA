/**
 * 
 */
package interfaz;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.entidades.Reportes;

public class Panel_Report extends JPanel {
	public Reportes reporte  = new Reportes();
	private JLayeredPane Panel_Reportes = new JLayeredPane();

	public JLayeredPane run() {
		Panel_Reportes.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Panel Reportes ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 37, 800, 400);
		Panel_Reportes.add(panel);
		panel.setLayout(null);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporte.Reporte("report2");
				
			}
		});
		btnUsuarios.setBounds(10, 28, 118, 74);
		panel.add(btnUsuarios);
		
		JButton btnNewButton = new JButton("Habitacion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporte.Reporte("report3");
			}
		});
		btnNewButton.setBounds(10, 113, 118, 74);
		panel.add(btnNewButton);
		
		JButton btnHabitaciones = new JButton("Clientes");
		btnHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporte.Reporte("report1");
			}
		});
		btnHabitaciones.setBounds(350, 28, 118, 74);
		panel.add(btnHabitaciones);
		
		JButton btnRegistroHusped = new JButton("Registro Huespedes");
		btnRegistroHusped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporte.Reporte("report8");
			}
		});
		btnRegistroHusped.setBounds(350, 113, 128, 74);
		panel.add(btnRegistroHusped);
		
		JButton btnEgreso = new JButton("Egresos");
		btnEgreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporte.Reporte("report4");
			}
		});
		btnEgreso.setBounds(672, 28, 118, 74);
		panel.add(btnEgreso);
		
		JButton btnDetFacturas = new JButton("Ingresos");
		btnDetFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporte.Reporte("report5");
			}
		});
		btnDetFacturas.setBounds(672, 113, 118, 74);
		panel.add(btnDetFacturas);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 820, 39);
		add(toolBar);
		
		JButton btnConfigurar = new JButton("Configurar");
		toolBar.add(btnConfigurar);
		
		JButton btnRegistroHuesped = new JButton("Registro Hospedaje");
		btnRegistroHuesped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reporte.Reporte("report7");
				
			}
		});
		btnRegistroHuesped.setBounds(10, 210, 127, 74);
		panel.add(btnRegistroHuesped);
		
		JButton btndetallefactura = new JButton("Detalle Factura");
		btndetallefactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reporte.Reporte("report6");
				
			}
		});
		btndetallefactura.setBounds(345, 210, 127, 74);
		panel.add(btndetallefactura);
			
		
		return Panel_Reportes;

	}

}
