package GUI;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class ShowProductsFromOrder {

	private static JFrame frame;
	private static JList list;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
////				try {
////					ShowProductsFromOrder window = new ShowProductsFromOrder();
////					
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public static void get(DefaultListModel m) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		list = new JList(m);
		list.setBounds(10, 11, 202, 240);
		frame.getContentPane().add(list);
		frame.setVisible(true);
	}

}
