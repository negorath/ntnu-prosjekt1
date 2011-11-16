package GUI;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Instruksjoner {

	public static JFrame frame = new JFrame();
	/**
	 * Runs the window application.
	 * @wbp.parser.entryPoint
	 */
	public static void run() {
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(10, 11, 430, 255);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
		
		JButton btnLukk = new JButton("Lukk");
		btnLukk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnLukk.setBounds(10, 272, 430, 23);
		frame.getContentPane().add(btnLukk);
		frame.setVisible(true);
		
		String s = "Ny Bestilling\n" +
				"	Info\n" +
				"	Utg�ende\n" +
				"	Rediger";
		textArea.setText(s);
	}
}