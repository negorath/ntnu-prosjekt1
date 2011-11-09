//package GUI;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//public class Start extends JFrame implements ActionListener {
//
//	private static final long serialVersionUID = 1L;
//	private final JFrame frame;
//	private JPanel panel, menu, chefs, dishes, contacts;
//	private JButton menuButton, chefsButton, dishesButton, contactsButton, back;
//	
//	Toolkit toolkit =  Toolkit.getDefaultToolkit ();
//	Dimension dim = toolkit.getScreenSize();
//	
//	
//	public static void main(String[] args) {
//		new Start();
//	}
//	
//	 
//	public Start() {
//		frame = new JFrame();
////		frame.setPreferredSize(new Dimension(800, 500));
//		dim.setSize(dim.getWidth() - 80, dim.getHeight() - 80);
//		frame.setPreferredSize(dim);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setBackground(Color.PINK);
//
//		// BUTTONS
//		menuButton = new JButton("Menu");
//		menuButton.setSize(100, 40);
//		menuButton.addActionListener(this);
//
//		chefsButton = new JButton("Chefs View");
//		chefsButton.setSize(100, 40);
//		chefsButton.addActionListener(this);
//
//		dishesButton = new JButton("Map");
//		dishesButton.setSize(100, 40);
//		dishesButton.addActionListener(this);
//
//		contactsButton = new JButton("Edit");
//		contactsButton.setSize(100, 40);
//		contactsButton.addActionListener(this);
//
//		// PANELS
//		panel = new JPanel();
//		panel.add(menuButton).setLocation(0, 0);
//		panel.add(chefsButton).setLocation(100, 0);
//		panel.add(dishesButton).setLocation(200, 0);
//		panel.add(contactsButton).setLocation(300, 0);
//		panel.setBackground(Color.PINK);
//		panel.setPreferredSize(new Dimension(700, 440));
//		panel.setLayout(new BorderLayout());
//
//		frame.setContentPane(panel);
//		frame.pack();
//		frame.setVisible(true);
//
//	}
//
//
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == menuButton) {
//			menu();
//			panel.setVisible(false);
//		} else if (e.getSource() == chefsButton) {
//			chefs();
//			panel.setVisible(false);
//		} else if (e.getSource() == dishesButton) {
//			dishes();
//			panel.setVisible(false);
//		} else if (e.getSource() == contactsButton) {
//			contacts();
//			panel.setVisible(false);
//		}
//	}
//
//	public void menu() {
//		menu = new JPanel();
//		menu.setBackground(Color.BLUE);
//		frame.setContentPane(menu);
//		frame.pack();
//		frame.setVisible(true);
//		menu.setVisible(true);
//
//		menu.add(menuButton).setLocation(0, 0);
//		menu.add(chefsButton).setLocation(100, 0);
//		menu.add(dishesButton).setLocation(200, 0);
//		menu.add(contactsButton).setLocation(300, 0);
//	}
//
//	public void chefs() {
//		chefs = new JPanel();
//		chefs.setBackground(Color.GREEN);
//		frame.setContentPane(chefs);
//		frame.pack();
//		frame.setVisible(true);
//		chefs.setVisible(true);
//
//		chefs.add(menuButton).setLocation(0, 0);
//		chefs.add(chefsButton).setLocation(100, 0);
//		chefs.add(dishesButton).setLocation(200, 0);
//		chefs.add(contactsButton).setLocation(300, 0);
//	}
//
//	public void dishes() {
//		dishes = new JPanel();
//		dishes.setBackground(Color.YELLOW);
//		frame.setContentPane(dishes);
//		frame.pack();
//		frame.setVisible(true);
//		dishes.setVisible(true);
//
//		dishes.add(menuButton).setLocation(0, 0);
//		dishes.add(chefsButton).setLocation(100, 0);
//		dishes.add(dishesButton).setLocation(200, 0);
//		dishes.add(contactsButton).setLocation(300, 0);
//	}
//
//	public void contacts() {
//		contacts = new JPanel();
//		contacts.setBackground(Color.ORANGE);
//		frame.setContentPane(contacts);
//		frame.pack();
//		frame.setVisible(true);
//		contacts.setVisible(true);
//
//		contacts.add(menuButton).setLocation(0, 0);
//		contacts.add(chefsButton).setLocation(100, 0);
//		contacts.add(dishesButton).setLocation(200, 0);
//		contacts.add(contactsButton).setLocation(300, 0);
//	}
//}
