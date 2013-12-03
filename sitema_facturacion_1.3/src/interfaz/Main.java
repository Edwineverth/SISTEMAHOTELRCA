
package interfaz;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;


/**
 * The Class Main.
 * 
 * @author Edwin
 * @version 1.0
 */
public class Main extends JFrame {
	
	/** The Constant serialVersionUI0705709806D. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	
	/** The frame. */
	public static Main frame;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		//Control de excepciones.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Main();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static JProgressBar barra;

	/**
	 * Instantiates a new main.
	 */
	public Main() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 800, 20);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		barra = new JProgressBar();
		barra.setBounds(0,0,800,20);
		barra.setVisible(true);
		new Thread(new Hilo()).start();

		contentPane.add(barra);

	}

	/**
	 * The Class Hilo.
	 * Implementando la clase Runable para extender de otro objeto que no sea Thread y manejar mas de un proceso.
	 * 
	 */
	public static class Hilo implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			//hacer hasta que i sea <= 100
			for (int i = 0; i<= 100; i++) {
				barra.setValue(i);
				barra.repaint();
				try {
					Thread.sleep(10);
				} catch (Exception e) {

				}
			}
			In_Iniciar_Secion login = new In_Iniciar_Secion();
			login.run();
			frame.setVisible(false);

		}

	}

}
