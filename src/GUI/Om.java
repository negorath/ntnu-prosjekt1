package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Label;

public class Om {

	public static JFrame frame = new JFrame();
	/**
	 * Runs the window application.
	 * @wbp.parser.entryPoint
	 */
	public static void run() {
		frame.getContentPane().setBackground(new Color(64, 64, 64));
		frame.setBounds(100, 100, 350, 157);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setBounds(10, 11, 193, 101);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
		
		JButton btnLukk = new JButton("Lukk");
		btnLukk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnLukk.setBounds(10, 123, 330, 23);
		frame.getContentPane().add(btnLukk);
		frame.setVisible(true);
		
		String s = "Gruppe 10\nPizzabestillings program\nVersjon 1.04\nCopyright 2011";
		textArea.setText(s);
		
		JLabel label = new JLabel(new ImageIcon("src/Bilder/logo.gif"));
		label.setBounds(213, 11, 127, 101);
		frame.getContentPane().add(label);
		
	}
}
