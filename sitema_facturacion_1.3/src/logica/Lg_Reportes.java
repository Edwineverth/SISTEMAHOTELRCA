/*
 * UNIVERSIDAD TÉCNICA DE MAHCHALA 
 * FACULTAD DE INGENIERÍA CIVIL
 * ESCUELA DE INFORMÁTICA
 * SISTEMA DE FACTURACION
 */
package logica;

import java.sql.Connection;

import conexion.Conexion;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * The Class Lg_Reportes.
 */
@SuppressWarnings("unused")
public class Lg_Reportes {

	/** The c. */
	public Conexion c= Conexion.getConn();
	
	/**
	 * Reporte.
	 * 
	 * @param reporte
	 *            the reporte
	 */
	@SuppressWarnings("static-access")
	public void Reporte( String reporte) {

		try {
			JasperReport report = JasperCompileManager.compileReport(System
					.getProperty("user.dir")
					+ "/reportes/"
					+ reporte
					+ ".jrxml");

		JasperPrint jasperPrint = JasperFillManager.fillReport(report,
					null, c.getCon());

			JasperViewer jviewer = new JasperViewer(jasperPrint, false);

			jviewer.setVisible(true);
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
		}
	}
}
