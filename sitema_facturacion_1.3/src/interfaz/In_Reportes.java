/*
 * UNIVERSIDAD TÉCNICA DE MAHCHALA 
 * FACULTAD DE INGENIERÍA CIVIL
 * ESCUELA DE INFORMÁTICA
 * SISTEMA DE FACTURACION
 */
package interfaz;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import logica.Lg_Reportes;

/**
 * The Class In_Reportes.
 */
public class In_Reportes {
	
	/** The r. */
	Lg_Reportes r = new Lg_Reportes();

	/** The btn factura. */
	JButton btnFactura = new JButton();
	
	/** The btn producto. */
	JButton btnProducto = new JButton();
	
	/** The btn cliente. */
	JButton btnCliente = new JButton();
	
	/** The btn usuario. */
	JButton btnUsuario = new JButton();

	/** The Panel_ reportes. */
	JLayeredPane Panel_Reportes = new JLayeredPane();

	/**
	 * Lg_Reportes.
	 * 
	 * @param p
	 *            the p
	 * @return the j layered pane
	 */
	
	public JLayeredPane run() {
		Panel_Reportes.setLayout(null);

		
			JLabel Rep_Factura = new JLabel("");
			Rep_Factura.setIcon(new ImageIcon("imagenes/factura.jpg"));
			Rep_Factura.setBounds(116, 48, 71, 60);
			Panel_Reportes.add(Rep_Factura);

			btnFactura = new JButton("Factura");
			btnFactura.setToolTipText("Reporte de factura");
			btnFactura.setBounds(106, 124, 100, 30);
			Panel_Reportes.add(btnFactura);
			btnFactura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					r.Reporte("facturaaaas");
				}
			});

		

		return Panel_Reportes;
	}

	/**
	 * 
	 */
	public In_Reportes() {
		super();
	}
}
