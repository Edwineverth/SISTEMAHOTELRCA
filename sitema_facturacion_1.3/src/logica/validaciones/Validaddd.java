/**
 * 
 */
package logica.validaciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

/**
 * @author Dell Inspiron
 *@version 1.0
 */
public class Validaddd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Validaddd frame = new Validaddd();
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
	public Validaddd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char car = evt.getKeyChar();
				if((car<'0' || car>'9')) evt.consume();
				if(car!='0' && car!='1') evt.consume();
			}
		});
		textField.setBounds(100, 55, 241, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char car = evt.getKeyChar();
				if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();

			}
		});
		textField_1.setBounds(100, 106, 241, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				
				char car = evt.getKeyChar();        
				if((car<'a' || car>'z') && (car<'A' || car>'Z')             
				    && car !='á' //Minúsculas             
				    && car !='é'            
				    && car !='í'            
				    && car !='ó'           
				    && car !='ú'   
				    && car !='Á' //Mayúsculas             
				    && car !='É'            
				    && car !='Í'            
				    && car !='Ó'           
				    && car !='Ú'             
				    && (car!=(char)KeyEvent.VK_SPACE))
				{      
				  evt.consume();   
				}
			}
		});
		textField_2.setBounds(104, 155, 237, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNumerosbin = new JLabel("numerosbin");
		lblNumerosbin.setBounds(380, 58, 65, 14);
		contentPane.add(lblNumerosbin);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char car = evt.getKeyChar();
				if(textField_3.getText().length()>=8) evt.consume();
				if((car<'0' || car>'9')) evt.consume();
				
				
			}
		});
		textField_3.setBounds(100, 202, 151, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		textField_4.setBounds(100, 233, 151, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		textField_5.setBounds(100, 264, 151, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		textField_6.setBounds(100, 295, 151, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		textField_7.setBounds(100, 326, 151, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		
	}
}
