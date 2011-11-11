package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import logic.Address;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeAddress {

	private static JFrame frame;
	private static JTextField adresse;
	private static JTextField nr;
	private static JTextField postnr;
	private static JTextField sted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	public static Address input(Address a) {
		frame = new JFrame();
		frame.setBounds(100, 100, 248, 173);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			}
		});
		btnOk.setBounds(7, 109, 89, 23);
		frame.getContentPane().add(btnOk);
		frame.setVisible(true);
		return a;
	}
}
