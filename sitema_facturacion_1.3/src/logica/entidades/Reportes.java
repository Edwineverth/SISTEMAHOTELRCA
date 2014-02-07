package logica.entidades;

import java.sql.Connection;
import conexion.Conexion;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Reportes {

	/** The c. */
	public Conexion c= Conexion.getConn();
	
	public void Reporte( String reporte) {

		try {
			JasperReport report = JasperCompileManager.compileReport(System
					.getProperty("user.dir")
					+ "/report/"
					+ reporte
					+ ".jrxml");

		JasperPrint jasperPrint = JasperFillManager.fillReport(report,
					null, c.getCon());

			JasperViewer jviewer = new JasperViewer(jasperPrint, false);

			jviewer.setVisible(true);
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			e.getStackTrace();
		}
	}
}
