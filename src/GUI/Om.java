package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Om {

	public static JFrame frame = new JFrame();
	/**
	 * Runs the window application.
	 * @wbp.parser.entryPoint
	 */
	public static void run() {
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 305, 120);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(10, 11, 285, 63);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
		
		JButton btnLukk = new JButton("Lukk");
		btnLukk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnLukk.setBounds(10, 85, 285, 23);
		frame.getContentPane().add(btnLukk);
		frame.setVisible(true);
		
		String s = "Gruppe 10 Pizzabestillings program";
		textArea.setText(s);
	}
}
