package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import org.jpedal.examples.simpleviewer.Commands;
import org.jpedal.examples.simpleviewer.SimpleViewer;
import javax.swing.JScrollPane;

public class Instruksjoner {
	
//		public static void main(String[] args){
//			JFrame myPDFFrame = new JFrame();
//			myPDFFrame.getContentPane().setLayout(new BorderLayout());
//			
//			JInternalFrame pdfContainer = new JInternalFrame("Instruksjoner");
//			
//			JLabel label = new JLabel("Instruksjoner");
//			label.setFont(new Font("Lucida", Font.BOLD, 22));
//			label.setForeground(Color.BLACK);
//			myPDFFrame.add(label, BorderLayout.NORTH);
//			
//			SimpleViewer myPDFViewer = new SimpleViewer(pdfContainer, null);
//			myPDFViewer.setupViewer();
//			myPDFFrame.add(pdfContainer, BorderLayout.CENTER);
//			
//			pdfContainer.setVisible(true);
//			
//			myPDFFrame.setTitle("PDF Viewer in Java");
//			myPDFFrame.setSize(850, 650);
//			myPDFFrame.addWindowListener(new WindowListener(){
//			public void windowActivated(WindowEvent e) {}
//			public void windowClosed(WindowEvent e) {}
//			public void windowClosing(WindowEvent e) {System.exit(1);}
//			public void windowDeactivated(WindowEvent e) {}
//			public void windowDeiconified(WindowEvent e) {}
//			public void windowIconified(WindowEvent e) {}
//			public void windowOpened(WindowEvent e) {}
//			});
//
//			myPDFFrame.setVisible(true);
//			
//			Object[] myPDFinput;
//			
//			myPDFinput = new Object[]{"Dokumenter/Brukermanual for programvare.pdf"};
//			myPDFViewer.executeCommand(Commands.OPENFILE, myPDFinput);
//		}

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
			System.out.println("Fant ikke fil");
			e.printStackTrace();
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
