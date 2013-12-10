/*
 * UNIVERSIDAD TÉCNICA DE MAHCHALA 
 * FACULTAD DE INGENIERÍA CIVIL
 * ESCUELA DE INFORMÁTICA
 * SISTEMA DE FACTURACION
 */
package logica;

import interfaz.In_FacturaServicios;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.print.PrinterException;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

import java.io.IOException;

/**
 * The Class Lg_Impresion.
 * 
 * @author Edwin
 * @version 1.0
 */
public class Lg_Impresion extends PdfPageEventHelper {

	/** The bt imprimir. */
	private static JButton btImprimir;

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		JFrame v = new JFrame();
		v.setBounds(0, 0, 835, 360);
		v.setLayout(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final String[] columnas = { "NOMBRE", "APELLIDOS", "DNI", "ESTADO",
				"BLOQUEO", "ALTA" };

		final DefaultTableModel dtm = new DefaultTableModel();

		final JTable tabla1 = new JTable(dtm);
		tabla1.setUpdateSelectionOnSort(true);

		for (int i = 0; i < 6; i++) {
			dtm.addColumn(columnas[i]);
		}
		tabla1.setPreferredScrollableViewportSize(new Dimension(800, 200));
		JScrollPane scrollPane = new JScrollPane(tabla1);

		v.add(scrollPane);
		scrollPane.setBounds(10, 10, 800, 200);

		final Object[] fila2 = { "Carlos", "Mateo Ruiz", "71024121F", "ACTIVO",
				"0", "2012/02/02" };
		final Object[] fila3 = { "Marta", "Perez Hidalgo", "29116227H",
				"ACTIVO", "1", "2010/21/10" };

		dtm.addRow(fila2);
		dtm.addRow(fila3);

		btImprimir = new JButton("IMPRIMIR");

		btImprimir.setBounds(10, 250, 120, 25);
		v.add(btImprimir);

		btImprimir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				try {

					In_FacturaServicios l = new In_FacturaServicios();
					tabla1.print();// envia los datos de la tabla a la
									// impresora

				} catch (PrinterException ex) {
					JOptionPane
							.showMessageDialog(null,
									"No se ha podido imprimir correctamente, intentalo más tarde.");
				}

			}

		});

		v.repaint();

	}

}