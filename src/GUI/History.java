package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import logic.DatabaseConnector;
import logic.Order;
import logic.User;

public class History {

	private static JFrame frame;
	private static DefaultListModel model1 = new DefaultListModel();
	private static DefaultListModel model2 = new DefaultListModel();
	private static DefaultListModel model3 = new DefaultListModel();
	private static DefaultListModel modelHistory = new DefaultListModel();
	private static DefaultListModel modelUsers = new DefaultListModel();
	private static DefaultListModel modelVarer = new DefaultListModel();
	private static JList userList, historyList;
	private static JList varerList;
	
	/**
	 * Opens a history window
	 * @wbp.parser.entryPoint
	 */
	public static void run() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 658, 331);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		

		userList = new JList(modelUsers);
		userList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				try{
					modelHistory.clear();
					modelVarer.clear();
					model1 = DatabaseConnector.getOrders("delivered");
					User us = (User)model2.getElementAt(userList.getSelectedIndex());
					if(model1 != null){
						for(int i = 0; i<model1.size(); i++){
							Order o = (Order)model1.getElementAt(i);
							if(us.getId().equals(o.getUserId())){
								modelHistory.addElement("Levert:  " + o.getDelivered());	
							}
						}				
						historyList.setModel(modelHistory);
					}
				}catch(Exception e){
				}
				frame.repaint();
			}
		});
		userList.setBounds(10, 26, 188, 263);
		frame.getContentPane().add(userList);
		
		historyList = new JList(modelHistory);
		historyList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try{
					modelVarer.clear();
					Order o = (Order)model1.getElementAt(historyList.getSelectedIndex());
					modelVarer = o.getProductsAsDefaultListModel();
					varerList.setModel(modelVarer);
				}catch(Exception et){
					
				}
			}
		});
		historyList.setBounds(208, 26, 259, 263);
		frame.getContentPane().add(historyList);
		
		JLabel lblKunder = new JLabel("Kunder");
		lblKunder.setForeground(Color.WHITE);
		lblKunder.setBounds(10, 11, 171, 14);
		frame.getContentPane().add(lblKunder);
		
		JLabel lblHistorie = new JLabel("Historie");
		lblHistorie.setForeground(Color.WHITE);
		lblHistorie.setBounds(208, 11, 242, 14);
		frame.getContentPane().add(lblHistorie);
		
		JButton btnLukk = new JButton("Lukk");
		btnLukk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnLukk.setBounds(10, 300, 638, 23);
		frame.getContentPane().add(btnLukk);
		
		varerList = new JList(modelVarer);
		varerList.setBounds(477, 26, 171, 263);
		frame.getContentPane().add(varerList);
		
		JLabel lblVarer = new JLabel("Varer");
		lblVarer.setForeground(Color.WHITE);
		lblVarer.setBounds(477, 11, 46, 14);
		frame.getContentPane().add(lblVarer);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		modelUsers.clear();
		try{	
			model2 = DatabaseConnector.getUsers();
			if(model2 != null){
				for(int i = 0; i<model2.size(); i++){
					User u = (User)model2.getElementAt(i);
					modelUsers.addElement(u.getPhone() + " : " + u.getName());
				}
				userList.setModel(modelUsers);
			}
		}catch(Exception e){
		}
	}
}
