package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Start extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private final JFrame frame;
	private JPanel panel, menu, chefs, dishes, contacts;
	private JButton menuButton, chefsButton, dishesButton, contactsButton, back;
	
	public static void main(String[]args){
		new Start();
	}
	public Start(){
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(800, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.PINK);
		
		//BUTTONS
		menuButton = new JButton("Menu");
		menuButton.setSize(100, 40);
		menuButton.addActionListener(this);
		
		chefsButton = new JButton("Chefs View");
		chefsButton.setSize(100, 40);
		chefsButton.addActionListener(this);
		
		dishesButton = new JButton("Dishes");
		dishesButton.setSize(100, 40);
		dishesButton.addActionListener(this);
		
		contactsButton = new JButton("Contacts");
		contactsButton.setSize(100, 40);
		contactsButton.addActionListener(this);
		
//		back = new JButton("Back");
//		back.setSize(100, 40);
//		back.addActionListener(this);

		//PANELS
		panel = new JPanel();
		panel.add(menuButton).setLocation(0, 0);
		panel.add(chefsButton).setLocation(100, 0);
		panel.add(dishesButton).setLocation(200, 0);
		panel.add(contactsButton).setLocation(300, 0);
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(600, 300));
		panel.setLayout(new BorderLayout());
		
//		menu = new JPanel();
//		menu.setBackground(Color.BLACK);
//		menu.add(back);

//		http://stackoverflow.com/questions/3076314/setsize-not-influencing-size-of-button
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	
		
	}
	public void build(){
		
		panel = new JPanel();
		panel.add(menuButton).setLocation(0, 0);
		panel.add(chefsButton).setLocation(100, 0);
		panel.add(dishesButton).setLocation(200, 0);
		panel.add(contactsButton).setLocation(300, 0);
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(600, 300));
		panel.setLayout(new BorderLayout());
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		
	}
	
    public void actionPerformed(ActionEvent e){
    	if(e.getSource() == menuButton){
			menu();
    		panel.setVisible(false);
    	}
    	else if(e.getSource() == back){

    		build();
    		
//    		panel.setVisible(true);
//			menu.setVisible(false);
//			chefs.setVisible(false);
//			dishes.setVisible(false);
//			contacts.setVisible(false);
    	}
    	else if(e.getSource() == chefsButton){
			chefs();
    		panel.setVisible(false);
    	}
		else if(e.getSource() == dishesButton){
			dishes();
			panel.setVisible(false);
		}
		else if(e.getSource() == contactsButton){
			contacts();
			panel.setVisible(false);
		}
	}
	public void menu(){
		menu = new JPanel();
		menu.setBackground(Color.BLUE);
		frame.setContentPane(menu);
		frame.pack();
		frame.setVisible(true);
		back = new JButton("Back");
		back.setSize(100, 40);
		menu.add(back).setLocation(700, 440);
		back.addActionListener(this);
		menu.setVisible(true);
	}
	public void chefs(){
		chefs = new JPanel();
		chefs.setBackground(Color.GREEN);
		frame.setContentPane(chefs);
		frame.pack();
		frame.setVisible(true);
		back = new JButton("Back");
		back.setSize(100, 40);
		chefs.add(back).setLocation(700, 440);
		back.addActionListener(this);
		chefs.setVisible(true);
	}
	public void dishes(){
		dishes = new JPanel();
		dishes.setBackground(Color.YELLOW);
		frame.setContentPane(dishes);
		frame.pack();
		frame.setVisible(true);
		back = new JButton("Back");
		back.setSize(100, 40);
		dishes.add(back).setLocation(700, 440);
		back.addActionListener(this);
		dishes.setVisible(true);
	}
	public void contacts(){
		contacts = new JPanel();
		contacts.setBackground(Color.ORANGE);
		frame.setContentPane(contacts);
		frame.pack();
		frame.setVisible(true);
		back = new JButton("Back");
		back.setSize(100, 40);
		contacts.add(back).setLocation(700, 440);
		back.addActionListener(this);
		contacts.setVisible(true);
	}
}

