package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JScrollPane;

public class Instruksjoner {
	

	public static JFrame frame = new JFrame();
	/**
	 * Runs the window application.
	 * @throws IOException 
	 * @wbp.parser.entryPoint
	 */
	public static void run() throws IOException {
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		String s = "";
		String temp = "";
		
		try {
			BufferedReader in = null;
			in = new BufferedReader(new FileReader("Dokumenter/instruksjoner.txt"));
			temp = in.readLine();
			while(temp!=null){
				s += temp;
				temp = in.readLine();
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fant ikke tekstdokumentet 'instruksjoner.txt'", "Tekstfil-error",  JOptionPane.ERROR_MESSAGE);

		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 249);
		frame.getContentPane().add(scrollPane);
		
		JTextPane textArea = new JTextPane();
		scrollPane.setViewportView(textArea);
		textArea.setContentType("text/html");
		textArea.setText(s);
		textArea.setBackground(new Color(255, 255, 255));
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
		
		
	}
}
