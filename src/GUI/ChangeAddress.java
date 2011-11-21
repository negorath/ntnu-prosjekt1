package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import logic.Address;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChangeAddress {

	private static JFrame frame;
	private static JTextField adresse;
	private static JTextField nr;
	private static JTextField postnr;
	private static JTextField sted;

	/**
	 * Launch the application.
	 */
	public static void main1(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeAddress window = new ChangeAddress();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static Address input(final Address a) {
		frame = new JFrame();
		frame.setBounds(100, 100, 248, 173);
		frame.getContentPane().setLayout(null);
		
		adresse = new JTextField(a.getStreet());
		adresse.setBounds(10, 25, 150, 20);
		frame.getContentPane().add(adresse);
		adresse.setColumns(10);
		
		nr = new JTextField(String.valueOf(a.getHouseNumber()));
		nr.setBounds(170, 25, 50, 20);
		frame.getContentPane().add(nr);
		nr.setColumns(10);
		
		postnr = new JTextField(a.getZipcode());
		postnr.setBounds(10, 68, 86, 20);
		frame.getContentPane().add(postnr);
		postnr.setColumns(10);
		
		sted = new JTextField(a.getCity());
		sted.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == arg0.VK_ENTER){
					a.setStreet(adresse.getText());
					a.setHouseNumber(Integer.parseInt(nr.getText()));
					a.setZipcode(postnr.getText());
					a.setCity(sted.getText());
					
					if (!a.save()) {
						JOptionPane.showMessageDialog(null, "Klarte ikke lagre adressen i databasen", "Database-error",  JOptionPane.ERROR_MESSAGE);
					}
					
					frame.dispose();
				}
			}
		});
		sted.setBounds(106, 68, 114, 20);
		frame.getContentPane().add(sted);
		sted.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 11, 150, 14);
		frame.getContentPane().add(lblAdresse);
		
		JLabel lblHusNummer = new JLabel("nr");
		lblHusNummer.setBounds(169, 11, 98, 14);
		frame.getContentPane().add(lblHusNummer);
		
		JLabel lblPostnummer = new JLabel("Postnr");
		lblPostnummer.setBounds(10, 56, 86, 14);
		frame.getContentPane().add(lblPostnummer);
		
		JLabel lblPoststed = new JLabel("Poststed");
		lblPoststed.setBounds(106, 56, 46, 14);
		frame.getContentPane().add(lblPoststed);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a.setStreet(adresse.getText());
				a.setHouseNumber(Integer.parseInt(nr.getText()));
				a.setZipcode(postnr.getText());
				a.setCity(sted.getText());
				
				if (!a.save()) {
					JOptionPane.showMessageDialog(null, "Klarte ikke lagre adresse i databasen", "Database-error",  JOptionPane.ERROR_MESSAGE);
				}
				
				frame.dispose();
			}
		});
		
		
		
		btnOk.setBounds(7, 109, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnAvbryt = new JButton("Avbryt");
		btnAvbryt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnAvbryt.setBounds(103, 106, 117, 29);
		frame.getContentPane().add(btnAvbryt);
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setTitle("Rediger adresse");
		frame.setUndecorated(true);
		frame.setVisible(true);
		return a;
	}
}
