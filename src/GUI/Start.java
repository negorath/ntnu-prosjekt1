package GUI;

import java.awt.EventQueue;
import logic.*;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.text.html.HTMLEditorKit;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;


import logic.Address;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JList;

import Map.Map;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.JToggleButton;

public class Start extends Thread{
	private JFrame frame;
	private JTextField nummer, navn, gatenavn, postnummer, poststed;
	JTextPane kommentar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel label;
	private JPanel bestilling, reciept, panel, bestillingsInfo, Rediger;
	private JTabbedPane tabbedPane;
	private JRadioButton rdbtnKort, rdbtnKontant;
	private JButton toggleButton, toggleButton_1, toggleButton_2, toggleButton_3, toggleButton_4, toggleButton_5, toggleButton_6, toggleButton_7;
	private JButton toggleButton_8, tglbtnCola, tglbtnFanta, tglbtnUrge, tglbtnSprite, tglbtnFarris, tglbtnLol;
	private JButton button, button_1, button_2, button_3, button_4, button_5, button_6, btnNewButton_1, btnNewButton, btnNeste;
	private JButton btnIncall;
	private JCheckBox chckbxLevering; 
	private JList list_1;
	private BufferedImage image;

	private JTextArea textArea;
	private boolean isBrus = false;
	private ArrayList<String> kvittering = new ArrayList<String>();
	private JList list;
	private DefaultListModel model = new DefaultListModel(), list_2 = new DefaultListModel(), listModelFinished = new DefaultListModel();
	private DefaultListModel m1 = new DefaultListModel();
	private DefaultListModel m2 = new DefaultListModel();
	private DefaultListModel m3 = new DefaultListModel();
	private DefaultListModel m4 = new DefaultListModel();

	private JButton button_9;
	private String hvorMange = "";
	private JTextField husnummer;
	private JLabel lblPostnummer;
	private JLabel lblPoststed;
	private JLabel lblKommentar;
	private JLabel lblRingendeNummer;
	private JButton btnFjernElement;
	private JPanel Utgaende;
	private JList list_3;
	private JList list_4;
	private JButton btnDel;
	private JButton button_8;
	private String sisteTrykteKnapp;
	private Map map = new Map();
	private JButton btnRedigerAdresse;
	private ArrayList<User> users = new ArrayList<User>();

	private JPanel panel_4;
	private JTextPane kvitering;
	private JLabel lblAddressNotFound;
	private DatabaseConnector con = new DatabaseConnector();
	private JPanel kunder;
	private JList kunder_list;
	private JList retter_list;
	private JList showProductList;
	private JButton leggTil;
	private JButton Slett;
	private JButton Rediger_1;
	private JButton rediger_retter;
	private JButton leggTil_retter;
	private JButton leggTil_retter_1;
	private JTextField redigerNavn;
	private JTextField redigerNummer;
	private JTextField redigerAdresse;
	private JTextField redigerHusNr;
	private JTextField redigerPostNummer;
	private JTextField redigerPostSted;
	private JTextField retterNavn;
	private JTextField retterPris;
	private JTextPane retterKommentar;
	private JLabel lblProduktnavn;
	private JLabel lblPris;
	private JLabel lblBeskrivelse;
	private JPanel Retter;
	private DefaultListModel listmodelUsers = new DefaultListModel();
	private DefaultListModel listModelProducts = new DefaultListModel();
	private DefaultListModel listModelOrders = new DefaultListModel();
	private DefaultListModel showProductModel = new DefaultListModel();

	private ArrayList<String> alleUsers = new ArrayList<String>();
	private JPanel panel_2;
	private JButton btnLevert;
	private JPanel panel_1;
	private JLabel pizzaInfo = new JLabel();
	private JButton button_7;
	private boolean focusOnFinishedOrders = false;

	private String[] temp;
	private JMenuBar menuBar;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {	}
			}
		});
	}

	/**
	 * Created and initialize the application.
	 */
	public Start() {
		initialize();
		try{
			DatabaseConnector.initialize();			
		}catch(Exception e){
			System.out.println("Could not connect to database");
		}
		getUsers();
		getProducts();
		getOrders();
		lagListe();
		frame.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setTitle("Pizza Pie In The Sky");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int width = 1000, height = 720;
		
		frame.setBounds((dim.width-width)/2, (dim.height-height)/2, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(1, 1, 998, 695);
		frame.getContentPane().add(tabbedPane);

		//---------------------Ny bestilling--------------------------------------

		bestilling = new JPanel();
		bestilling.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Ny Bestilling", null, bestilling, null);
		bestilling.setLayout(null);
		

		///////////////////meny knapper////////////////////////////

		toggleButton = new JButton("Nr.1");
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.1";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.1";
					menyKnappTrykk("Pizza nr.1");		
				}
			}
		});
		toggleButton.setBounds(16, 45, 75, 45);
		bestilling.add(toggleButton);

		toggleButton_1 = new JButton("Nr.2");
		toggleButton_1.setBounds(101, 45, 75, 45);
		bestilling.add(toggleButton_1);
		toggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.2";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.2";
					menyKnappTrykk("Pizza nr.2");
				}
			}
		});

		toggleButton_2 = new JButton("Nr.3");
		toggleButton_2.setBounds(183, 45, 75, 45);
		bestilling.add(toggleButton_2);
		toggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.3";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.3";
					menyKnappTrykk("Pizza nr.3");
				}
			}
		});


		toggleButton_3 = new JButton("Nr.4");
		toggleButton_3.setBounds(16, 101, 75, 45);
		bestilling.add(toggleButton_3);
		toggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp = "Pizza nr.4";
				if(hvorMange != ""){
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.4";
					menyKnappTrykk("Pizza nr.4");
				}
			}
		});

		toggleButton_4 = new JButton("Nr.5");
		toggleButton_4.setBounds(101, 101, 75, 45);
		bestilling.add(toggleButton_4);
		toggleButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.5";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.5";
					menyKnappTrykk("Pizza nr.5");
				}
			}
		});

		toggleButton_5 = new JButton("Nr.6");
		toggleButton_5.setBounds(183, 101, 75, 45);
		bestilling.add(toggleButton_5);
		toggleButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.6";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.6";
					menyKnappTrykk("Pizza nr.6");
				}
			}
		});
		toggleButton_6 = new JButton("Nr.7");
		toggleButton_6.setBounds(16, 157, 75, 45);
		bestilling.add(toggleButton_6);
		toggleButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.7";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.7";
					menyKnappTrykk("Pizza nr.7");
				}
			}
		});

		toggleButton_7 = new JButton("Nr.8");
		toggleButton_7.setBounds(101, 157, 75, 45);
		bestilling.add(toggleButton_7);
		toggleButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.8";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.8";
					menyKnappTrykk("Pizza nr.8");
				}
			}
		});

		toggleButton_8 = new JButton("Nr.9");
		toggleButton_8.setBounds(183, 157, 75, 45);
		bestilling.add(toggleButton_8);
		toggleButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.9";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.9";
					menyKnappTrykk("Pizza nr.9");
				}
			}
		});

		reciept = new JPanel();
		reciept.setBackground(Color.GRAY);
		reciept.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Kvittering", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		reciept.setBounds(300, 20, 352, 603);
		bestilling.add(reciept);
		reciept.setLayout(null);

		JButton btnFjernAlt = new JButton("Fjern Alt");
		btnFjernAlt.setForeground(new Color(47, 79, 79));
		btnFjernAlt.setFont(new Font("Verdana", Font.BOLD, 11));
		btnFjernAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kvittering.clear();
				model.removeAllElements();

			}
		});

		btnFjernElement = new JButton("Fjern");
		btnFjernElement.setForeground(new Color(47, 79, 79));
		btnFjernElement.setFont(new Font("Verdana", Font.BOLD, 11));
		btnFjernElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model.getSize()>0)
					try{
						model.remove(list.getSelectedIndex());
					}catch(Exception t){
						System.out.println("Ingenting er valgt");
					}
			}
		});
		btnFjernElement.setBounds(132, 0, 100, 23);
		reciept.add(btnFjernElement);
		btnFjernAlt.setBounds(242, 0, 100, 23);
		reciept.add(btnFjernAlt);

		list = new JList(model);		 
		list.setBounds(10, 25, 332, 567);
		reciept.add(list);


		///////////////////////Drikkeknapper/////////////////////////

		tglbtnCola = new JButton("Cola");
		tglbtnCola.setBounds(16, 235, 75, 45);
		bestilling.add(tglbtnCola);
		tglbtnCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Cola";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					isBrus = true;
					sisteTrykteKnapp = "Cola";
					menyKnappTrykk("Cola");
				}
			}
		});
		tglbtnFanta = new JButton("Fanta");
		tglbtnFanta.setBounds(101, 235, 75, 45);
		bestilling.add(tglbtnFanta);
		tglbtnFanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Fanta";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Fanta";
					isBrus = true;
					menyKnappTrykk("Fanta");
				}
			}
		});
		tglbtnSprite = new JButton("Sprite");
		tglbtnSprite.setBounds(183, 235, 75, 45);
		bestilling.add(tglbtnSprite);
		tglbtnSprite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Sprite";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Sprite";
					isBrus = true;
					menyKnappTrykk("Sprite");
				}
			}
		});
		tglbtnUrge = new JButton("Cola-Zero");
		tglbtnUrge.setBounds(16, 291, 75, 45);
		bestilling.add(tglbtnUrge);
		tglbtnUrge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Cola-Zero";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Cola-Zero";
					isBrus = true;
					menyKnappTrykk("Cola-Zero");
				}
			}
		});
		tglbtnFarris = new JButton("BonAqua");
		tglbtnFarris.setBounds(101, 291, 75, 45);
		bestilling.add(tglbtnFarris);
		tglbtnFarris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "BonAqua";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "BonAqua";
					isBrus = true;
					menyKnappTrykk("BonAqua");
				}
			}
		});
		tglbtnLol = new JButton("Vann");
		tglbtnLol.setBounds(183, 291, 75, 45);
		bestilling.add(tglbtnLol);
		tglbtnLol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hvorMange != ""){
					sisteTrykteKnapp = "Vann";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Vann";
					isBrus = true;
					menyKnappTrykk("Vann");
				}
			}
		});



		//////////////////////"antall" kanpper///////////////////

		button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "1";
			}
		});
		button.setBounds(16, 403, 75, 45);
		bestilling.add(button);

		button_1 = new JButton("2");
		button_1.setBounds(101, 403, 75, 45);
		bestilling.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "2";
				System.out.println(hvorMange);
			}
		});

		btnNewButton = new JButton("3");
		btnNewButton.setActionCommand("2");
		btnNewButton.setBounds(183, 403, 75, 45);
		bestilling.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "3";
			}
		});

		button_2 = new JButton("4");
		button_2.setBounds(16, 459, 75, 45);
		bestilling.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "4";
			}
		});


		button_4 = new JButton("5");
		button_4.setBounds(101, 459, 75, 45);
		bestilling.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "5";
				System.out.println(hvorMange);
			}
		});

		button_5 = new JButton("6");
		button_5.setBounds(183, 459, 75, 45);
		bestilling.add(button_5);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "6";
			}
		});

		button_3 = new JButton("7");
		button_3.setBounds(16, 515, 75, 45);
		bestilling.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "7";
			}
		});

		button_6 = new JButton("8");
		button_6.setBounds(101, 515, 75, 45);
		bestilling.add(button_6);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "8";

			}
		});

		btnNewButton_1 = new JButton("9");
		btnNewButton_1.setBounds(183, 515, 75, 45);
		bestilling.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "9";
			}
		});

		button_8 = new JButton("0");
		button_8.setBounds(101, 567, 75, 45);
		bestilling.add(button_8);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hvorMange += "0";
			}
		});

		btnDel = new JButton("C");
		btnDel.setBounds(16, 567, 75, 45);
		bestilling.add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange = "";
			}
		});
		


		btnNeste = new JButton("Neste");
		btnNeste.setForeground(new Color(47, 79, 79));
		btnNeste.setFont(new Font("Verdana", Font.BOLD, 16));
//		btnNeste.setBackground(new Color(204, 255, 204));
		btnNeste.setBounds(831, 567, 138, 68);
		bestilling.add(btnNeste);
		btnNeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedComponent(bestillingsInfo);
				temp = new String[model.size()];
				for(int i = 0; i<model.size(); i++){
					temp[i] = (String)model.getElementAt(i);
				}
				frame.repaint();
			}
		});

		//---------------------------info---------------------------------

		bestillingsInfo = new JPanel();
		bestillingsInfo.setPreferredSize(new Dimension(500, 550));
		bestillingsInfo.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("info", null, bestillingsInfo, null);
		bestillingsInfo.setLayout(null);

		navn = new JTextField();
		navn.setBounds(16, 30, 278, 28);
		bestillingsInfo.add(navn);
		navn.setColumns(10);

		nummer = new JTextField();
		nummer.setFont(new Font("Verdana", Font.BOLD, 20));
		nummer.setBounds(835, 30, 134, 28);
		bestillingsInfo.add(nummer);
		nummer.setColumns(10);
		nummer.setEditable(false);

		gatenavn = new JTextField();
		gatenavn.setBounds(16, 83, 190, 28);
		bestillingsInfo.add(gatenavn);
		gatenavn.setColumns(10);

		postnummer = new JTextField();
		postnummer.setBounds(16, 135, 133, 28);
		bestillingsInfo.add(postnummer);
		postnummer.setColumns(10);

		poststed = new JTextField();
		poststed.setBounds(160, 135, 134, 28);
		bestillingsInfo.add(poststed);
		poststed.setColumns(10);

		kommentar = new JTextPane();
		kommentar.setBounds(16, 190, 190, 93);
		bestillingsInfo.add(kommentar);

		chckbxLevering = new JCheckBox("Levering");
		chckbxLevering.setBounds(212, 190, 85, 23);
		bestillingsInfo.add(chckbxLevering);

		rdbtnKort = new JRadioButton("Kort");
		buttonGroup.add(rdbtnKort);
		rdbtnKort.setBounds(213, 233, 58, 23);
		bestillingsInfo.add(rdbtnKort);

		rdbtnKontant = new JRadioButton("Kontant");
		buttonGroup.add(rdbtnKontant);
		rdbtnKontant.setBounds(212, 259, 81, 23);
		bestillingsInfo.add(rdbtnKontant);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Bestilling", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(335, 30, 277, 407);
		bestillingsInfo.add(panel_1);
		panel_1.setLayout(null);

		list_1 = new JList(model);
		list_1.setBounds(6, 22, 265, 379);
		panel_1.add(list_1);

		JButton btnRediger_1 = new JButton("Rediger");
		btnRediger_1.setBounds(182, 0, 89, 23);
		panel_1.add(btnRediger_1);
		btnRediger_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedComponent(bestilling);
			}
		});

		JLabel lblFulltNavn = new JLabel("Fullt Navn");
		lblFulltNavn.setBounds(16, 12, 133, 14);
		bestillingsInfo.add(lblFulltNavn);

		JLabel lblGatenavn = new JLabel("Gatenavn");
		lblGatenavn.setBounds(16, 69, 111, 14);
		bestillingsInfo.add(lblGatenavn);

		husnummer = new JTextField();
		husnummer.setBounds(216, 83, 55, 28);
		bestillingsInfo.add(husnummer);
		husnummer.setColumns(10);

		JLabel lblHusnr = new JLabel("Husnummer");
		lblHusnr.setBounds(218, 70, 90, 14);
		bestillingsInfo.add(lblHusnr);

		lblPostnummer = new JLabel("Postnummer");
		lblPostnummer.setBounds(16, 122, 133, 14);
		bestillingsInfo.add(lblPostnummer);

		lblPoststed = new JLabel("Poststed");
		lblPoststed.setBounds(159, 122, 135, 14);
		bestillingsInfo.add(lblPoststed);

		lblKommentar = new JLabel("Kommentar");
		lblKommentar.setBounds(16, 174, 190, 14);
		bestillingsInfo.add(lblKommentar);

		lblRingendeNummer = new JLabel("Ringende Nummer");
		lblRingendeNummer.setBounds(835, 12, 134, 14);
		bestillingsInfo.add(lblRingendeNummer);


		JButton btnNeste_1 = new JButton("Send");
		btnNeste_1.setForeground(new Color(47, 79, 79));
		btnNeste_1.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNeste_1.setBackground(new Color(204, 255, 204));
		btnNeste_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedComponent(Utgaende);
				list_2.addElement(createOrder(list));
				String tmp = "";
				try{
					User u = DatabaseConnector.getUser(nummer.getText());
					Order order = new Order(DatabaseConnector.getUser(nummer.getText()).getId());
					order.setProducts(temp);
					order.setKommentar(kommentar.getText());
					temp=null;
					DatabaseConnector.newOrder(order);
					getOrders();
					tmp = u.getAddress().getStreet();
					String tmp2 = u.getAddress().getCity();
					if (u.getAddress().getStreet().contains(" ") ||
						u.getAddress().getStreet().contains("æ") ||
						u.getAddress().getStreet().contains("Æ") ||
						u.getAddress().getStreet().contains("ø") ||
						u.getAddress().getStreet().contains("Ø") ||
						u.getAddress().getStreet().contains("å") ||
						u.getAddress().getStreet().contains("Å")
						) {
							tmp = tmp.replace(' ' , '+');
							tmp = tmp.replace('æ' , 'e');
							tmp = tmp.replace('ø' , 'o');
							tmp = tmp.replace('å' , 'a');
							tmp = tmp.replace('Æ' , 'e');
							tmp = tmp.replace('Ø' , 'o');
							tmp = tmp.replace('Å' , 'a');
					}
					if (u.getAddress().getCity().contains(" ") ||
							u.getAddress().getCity().contains("æ") ||
							u.getAddress().getCity().contains("Æ") ||
							u.getAddress().getCity().contains("ø") ||
							u.getAddress().getCity().contains("Ø") ||
							u.getAddress().getCity().contains("å") ||
							u.getAddress().getCity().contains("Å")
							) {
								tmp2 = tmp.replace(' ' , '+');
								tmp2 = tmp.replace('æ' , 'e');
								tmp2 = tmp.replace('ø' , 'o');
								tmp2 = tmp.replace('å' , 'a');
								tmp2 = tmp.replace('Æ' , 'e');
								tmp2 = tmp.replace('Ø' , 'o');
								tmp2 = tmp.replace('Å' , 'a');
					}
					try{
						map.call("http://maps.google.com/maps/api/staticmap?zoom=15&size=400x400&sensor=false&markers=" + tmp + "&" + String.valueOf(husnummer.getText()) + "&" + tmp2 + ",norway", tmp + " " + String.valueOf(husnummer.getText()) + ", " + poststed.getText());
						lblAddressNotFound.setVisible(false);
					}catch(Exception haha){
						lblAddressNotFound.setVisible(true);
						btnRedigerAdresse.setVisible(true);						
					}
				}catch(Exception e){
					try{
						Address a = new Address(gatenavn.getText(), Integer.parseInt(husnummer.getText()), postnummer.getText(), poststed.getText());
						User u = new User(navn.getText(), nummer.getText(), a);
						DatabaseConnector.newUser(u);
						getUsers();
						//This time the user have been created and is in the database
						Order order = new Order(DatabaseConnector.getUser(nummer.getText()).getId());
						order.setProducts(temp);
						order.setKommentar(kommentar.getText());
						temp=null;
						DatabaseConnector.newOrder(order);
						getOrders();
					}catch(Exception j){
						System.out.println("Failed to create new User");
						j.printStackTrace();
					}
				}
				navn.setText("");
				nummer.setText("");
				gatenavn.setText("");
				postnummer.setText("");
				poststed.setText("");
				kommentar.setText("");
				husnummer.setText("");
				chckbxLevering.setSelected(false);
				rdbtnKort.setSelected(false);
				rdbtnKontant.setSelected(false);
				model.clear();
				frame.repaint();
			}
		});
		btnNeste_1.setBounds(831, 555, 138, 68);
		bestillingsInfo.add(btnNeste_1);

		//--------------------------Utgaaende/chef-----------------------------------------

//		new Thread(){
//			public void run(){
//				while(true){					
//					try {
//						sleep(10000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					getUsers();
//					getProducts();
//					getOrders();
//					frame.repaint();
//				}
//			}
//		}.start();
		
		Utgaende = new JPanel();
		Utgaende.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Utg\u00E5ende", null, Utgaende, null);
		Utgaende.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Ikke ferdig", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(4, 35, 241, 515);
		Utgaende.add(panel_2);
		panel_2.setLayout(null);
		list_3 = new JList(listModelOrders);
		list_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				focusOnFinishedOrders = false;
			}
		});
		list_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(arg0.getClickCount() == 1){
					try{
						int selected = list_3.getSelectedIndex();
						Order o = DatabaseConnector.getOrder((String)list_3.getSelectedValue());							
						showProductModel = o.getProductsAsDefaultListModel();
						showProductList.setModel(showProductModel);
						kvitering.setText(o.getProductsString());
						getOrders();
						if(listModelOrders.size() > 0){
							list_3.setSelectedIndex(selected);							
						}
						textArea.setText(o.getKommentar());
					}catch(Exception e){
//						System.out.println("Fant ingen produkter i bestillingen");
					}
				}
				else if(arg0.getClickCount() == 2){
					try{
						Order o = DatabaseConnector.getOrder((String)list_3.getSelectedValue());							
						DatabaseConnector.edit(o.getId());
						getOrders();
						textArea.setText("");
						showProductModel.clear();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		list_3.setBounds(6, 22, 229, 487);
		panel_2.add(list_3);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Ferdig", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(423, 35, 241, 515);
		Utgaende.add(panel_3);
		panel_3.setLayout(null);

		list_4 = new JList(listModelFinished);
		list_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				focusOnFinishedOrders = true;
				}
		});
		list_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(arg0.getClickCount() == 1){
					try{
						int selected = list_4.getSelectedIndex();
						Order o = DatabaseConnector.getOrder((String)list_4.getSelectedValue());							
						showProductModel = o.getProductsAsDefaultListModel();
						showProductList.setModel(showProductModel);
						kvitering.setText(o.getProductsString());
						getOrders();
						if(listModelFinished.size() > 0){
							list_4.setSelectedIndex(selected);							
						}
						textArea.setText(o.getKommentar());
					}catch(Exception e){
//						System.out.println("Fant ingen produkter i bestillingen");
					}
				}
				else if(arg0.getClickCount() == 2){
					try{
						Order o = DatabaseConnector.getOrder((String)list_4.getSelectedValue());							
						DatabaseConnector.notFinished(o.getId());
						getOrders();
						textArea.setText("");
						showProductModel.clear();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		list_4.setBounds(6, 22, 229, 487);
		panel_3.add(list_4);

		btnLevert = new JButton("Levert");
		btnLevert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listModelFinished.getSize()>0){
					try{
						Order o = DatabaseConnector.getOrder((String)list_4.getSelectedValue());							
//						DatabaseConnector.deleteOrder(o);
						DatabaseConnector.delivered(o);
						getOrders();
						textArea.setText("");
						showProductModel.clear();
					}catch(Exception ett){
						ett.printStackTrace();
					}
				}
			}
		});
		btnLevert.setBounds(135, 0, 100, 23);
		panel_3.add(btnLevert);

		lblAddressNotFound = new JLabel("Kunne ikke finne adresse");
		lblAddressNotFound.setForeground(new Color(255, 0, 0));
		lblAddressNotFound.setBounds(265, 72, 159, 14);
		Utgaende.add(lblAddressNotFound);
		lblAddressNotFound.setVisible(false);

		btnRedigerAdresse = new JButton("Rediger Adresse");
		btnRedigerAdresse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order o = null;
				try{
					if(focusOnFinishedOrders){
						o = DatabaseConnector.getOrder((String)list_4.getSelectedValue());								
					}
					else{
						o = DatabaseConnector.getOrder((String)list_3.getSelectedValue());
					}
				}catch(Exception et){
//					et.printStackTrace();
				}
				try{
					Address a = DatabaseConnector.getAddressFromUser(Integer.parseInt(o.getUserId()));
					a = ChangeAddress.input(a);
					getUsers();
					kunder_list.repaint();
				}catch(Exception ed){
					System.out.println("fant ikke brukeren");
//					ed.printStackTrace();
				}
				lblAddressNotFound.setVisible(false);
			}
		});
		btnRedigerAdresse.setBounds(255, 97, 158, 23);
		Utgaende.add(btnRedigerAdresse);

		JButton btnVisKart = new JButton("Vis Kart");
		btnVisKart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Order o;
					if(focusOnFinishedOrders){
						o = DatabaseConnector.getOrder((String)list_4.getSelectedValue());
					}
					else{	
						o = DatabaseConnector.getOrder((String)list_3.getSelectedValue());
					}
					String telefonNummer = DatabaseConnector.getPhoneByUserId(Integer.parseInt(o.getUserId()));
					User u = DatabaseConnector.getUser(telefonNummer);
					
					String tmp = u.getAddress().getStreet();
					String tmp2 = u.getAddress().getCity();
					if (u.getAddress().getStreet().contains(" ") ||
						u.getAddress().getStreet().contains("æ") ||
						u.getAddress().getStreet().contains("Æ") ||
						u.getAddress().getStreet().contains("ø") ||
						u.getAddress().getStreet().contains("Ø") ||
						u.getAddress().getStreet().contains("å") ||
						u.getAddress().getStreet().contains("Å")
						) {
							tmp = tmp.replace(' ' , '+');
							tmp = tmp.replace('æ' , 'e');
							tmp = tmp.replace('ø' , 'o');
							tmp = tmp.replace('å' , 'a');
							tmp = tmp.replace('Æ' , 'e');
							tmp = tmp.replace('Ø' , 'o');
							tmp = tmp.replace('Å' , 'a');
					}
					if (u.getAddress().getCity().contains(" ") ||
							u.getAddress().getCity().contains("æ") ||
							u.getAddress().getCity().contains("Æ") ||
							u.getAddress().getCity().contains("ø") ||
							u.getAddress().getCity().contains("Ø") ||
							u.getAddress().getCity().contains("å") ||
							u.getAddress().getCity().contains("Å")
							) {
								tmp2 = tmp.replace(' ' , '+');
								tmp2 = tmp.replace('æ' , 'e');
								tmp2 = tmp.replace('ø' , 'o');
								tmp2 = tmp.replace('å' , 'a');
								tmp2 = tmp.replace('Æ' , 'e');
								tmp2 = tmp.replace('Ø' , 'o');
								tmp2 = tmp.replace('Å' , 'a');
					}
					String constant = "http://maps.google.com/maps/api/staticmap?zoom=15&size=400x400&sensor=false&markers=";
					String url = tmp + "&" + String.valueOf(u.getAddress().getHouseNumber()) + "&" + u.getAddress().getZipcode() + "&" + tmp2 + ",norway";
					String tittle = u.getAddress().getStreet() + " " + String.valueOf(u.getAddress().getHouseNumber()) + ", " + u.getAddress().getCity();
					map.call(constant + url, tittle);	
					lblAddressNotFound.setVisible(false);
				}catch(Exception e){
					e.printStackTrace();
					lblAddressNotFound.setVisible(true);
					btnRedigerAdresse.setVisible(true);
				}
			}
		});
		btnVisKart.setForeground(new Color(47, 79, 79));
		btnVisKart.setFont(new Font("Verdana", Font.BOLD, 16));
		btnVisKart.setBounds(255, 18, 158, 50);
		Utgaende.add(btnVisKart);

		
		showProductList = new JList(showProductModel);
		showProductList.setBounds(259, 151, 151, 195);
		Utgaende.add(showProductList);

		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Kvitering", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(676, 35, 297, 515);
		Utgaende.add(panel_4);
		panel_4.setLayout(null);
		
		kvitering = new JTextPane();
		kvitering.setContentType("text/html");
		kvitering.setBounds(6, 22, 285, 487);
		kvitering.setEditable(false);
		panel_4.add(kvitering);
		
		textArea = new JTextArea();
		textArea.setBounds(255, 357, 158, 193);
		Utgaende.add(textArea);
		textArea.setEditable(false);




		//------------------------Rediger-------------------------------------------------

		Rediger = new JPanel();
		Rediger.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Rediger", null, Rediger, null);
		Rediger.setLayout(null);

		btnIncall = new JButton("Incall");

		btnIncall.setBackground(new Color(238, 238, 238));
		btnIncall.setForeground(new Color(47, 79, 79));
		btnIncall.setFont(new Font("Verdana", Font.BOLD, 16));
		btnIncall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nr = JOptionPane.showInputDialog(null, "Skriv inn incall number");
				nummer.setText(nr);
				try{
					User user = (User)DatabaseConnector.getUser(nr);
					navn.setText(user.getName());
					gatenavn.setText(user.getAddress().getStreet());
					husnummer.setText(String.valueOf(user.getAddress().getHouseNumber()));
					postnummer.setText(user.getAddress().getZipcode());
					poststed.setText(user.getAddress().getCity());
				}catch(Exception ee){
					System.out.println("New Customer");
				}
			}
		});
		btnIncall.setBounds(848, 11, 121, 45);
		bestilling.add(btnIncall);


		//REDIGER TABBEN
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 11, 962, 612);
		Rediger.add(tabbedPane_1);

		kunder = new JPanel();
		tabbedPane_1.addTab("Kunder", null, kunder, null);
		kunder.setLayout(null);

		kunder_list = new JList(listmodelUsers);
		kunder_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() == 1){
					int selectedIndex = kunder_list.getSelectedIndex();
					User user = (User)m1.getElementAt(selectedIndex);
					redigerNavn.setText(user.getName());
					redigerNummer.setText(user.getPhone());
					redigerAdresse.setText(user.getAddress().getStreet());
					redigerHusNr.setText(String.valueOf(user.getAddress().getHouseNumber()));
					redigerPostNummer.setText(user.getAddress().getZipcode());
					redigerPostSted.setText(user.getAddress().getCity());
				}
//				else if(arg0.getButton() == arg0.BUTTON3){
//					try{
//						int id = kunder_list.getSelectedIndex();
//						User user = (User)m1.getElementAt(id);
//						DatabaseConnector.deleteUser(user);
//						getUsers();						
//					}catch(Exception e){
//						System.out.println("Klarte ikke slette bruker");
//					}
//				}
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(arg0.getClickCount() == 1){
					int selectedIndex = kunder_list.getSelectedIndex();
					User user = (User)m1.getElementAt(selectedIndex);
					redigerNavn.setText(user.getName());
					redigerNummer.setText(user.getPhone());
					redigerAdresse.setText(user.getAddress().getStreet());
					redigerHusNr.setText(String.valueOf(user.getAddress().getHouseNumber()));
					redigerPostNummer.setText(user.getAddress().getZipcode());
					redigerPostSted.setText(user.getAddress().getCity());
				}
			}
		});
		kunder_list.setBounds(722, 64, 213, 468);
		kunder.add(kunder_list);

		leggTil = new JButton("Opprett");
		leggTil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Address address = new Address(redigerAdresse.getText(), Integer.parseInt(redigerHusNr.getText()), redigerPostNummer.getText(), redigerPostSted.getText());
				try{
					DatabaseConnector.newUser(new User(redigerNavn.getText(), redigerNummer.getText(), address));					
					getUsers();
					redigerNummer.setText("");
					redigerNavn.setText("");
					redigerHusNr.setText("");
					redigerAdresse.setText("");
					redigerPostNummer.setText("");
					redigerPostSted.setText("");
				}catch(Exception et){
					System.out.println("Kunne ikke legge til kunde");
					et.printStackTrace();
				}
			}
		});
		leggTil.setBounds(722, 20, 100, 41);
		kunder.add(leggTil);

		Slett = new JButton("Slett");
		Slett.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = kunder_list.getSelectedIndex();
				User user = (User)m1.getElementAt(id);
				DatabaseConnector.deleteUser(user);
				getUsers();
			}
		});
		Slett.setBounds(835, 20, 100, 41);
		kunder.add(Slett);

		Rediger_1 = new JButton("Lagre");
		Rediger_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Address address = new Address(redigerAdresse.getText(), Integer.parseInt(redigerHusNr.getText()), redigerPostNummer.getText(), redigerPostSted.getText());
				User newUser = new User(redigerNavn.getText(), redigerNummer.getText(), address);
				User oldUser = (User)m1.getElementAt(kunder_list.getSelectedIndex());
				DatabaseConnector.edit(oldUser, newUser);
				getUsers();
			}
		});
		Rediger_1.setBounds(10, 420, 100, 41);
		kunder.add(Rediger_1);

		redigerNavn = new JTextField();
		redigerNavn.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerNavn.setBounds(10, 64, 408, 60);
		kunder.add(redigerNavn);
		redigerNavn.setColumns(10);

		redigerNummer = new JTextField();
		redigerNummer.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerNummer.setBounds(453, 64, 230, 60);
		kunder.add(redigerNummer);
		redigerNummer.setColumns(10);

		redigerAdresse = new JTextField();
		redigerAdresse.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerAdresse.setBounds(10, 199, 480, 60);
		kunder.add(redigerAdresse);
		redigerAdresse.setColumns(10);

		redigerHusNr = new JTextField();
		redigerHusNr.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerHusNr.setBounds(530, 199, 86, 60);
		kunder.add(redigerHusNr);
		redigerHusNr.setColumns(10);

		redigerPostNummer = new JTextField();
		redigerPostNummer.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerPostNummer.setBounds(10, 326, 130, 60);
		kunder.add(redigerPostNummer);
		redigerPostNummer.setColumns(10);

		redigerPostSted = new JTextField();
		redigerPostSted.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerPostSted.setBounds(175, 326, 445, 60);
		kunder.add(redigerPostSted);
		redigerPostSted.setColumns(10);
		
		redigerPostSted.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent arg) {
				if (arg.getKeyCode() != arg.VK_ENTER) {
					return;
				}
				
				Address address = new Address(redigerAdresse.getText(), Integer.parseInt(redigerHusNr.getText()), redigerPostNummer.getText(), redigerPostSted.getText());
				User newUser = new User(redigerNavn.getText(), redigerNummer.getText(), address);
				User oldUser = (User)m1.getElementAt(kunder_list.getSelectedIndex());
				DatabaseConnector.edit(oldUser, newUser);
				getUsers();
			}
		});

		

		JLabel lblFulltNavn_1 = new JLabel("Fullt Navn");
		lblFulltNavn_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFulltNavn_1.setBounds(10, 24, 408, 28);
		kunder.add(lblFulltNavn_1);

		JLabel lblTelefonNummer = new JLabel("Telefon Nummer");
		lblTelefonNummer.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTelefonNummer.setBounds(453, 24, 230, 28);
		kunder.add(lblTelefonNummer);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAdresse.setBounds(10, 156, 480, 32);
		kunder.add(lblAdresse);

		JLabel lblNr = new JLabel("Nr");
		lblNr.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNr.setBounds(530, 156, 86, 32);
		kunder.add(lblNr);

		JLabel redigerPostNummerlbl = new JLabel("Postnummer");
		redigerPostNummerlbl.setFont(new Font("Verdana", Font.BOLD, 14));
		redigerPostNummerlbl.setBounds(10, 283, 130, 32);
		kunder.add(redigerPostNummerlbl);

		JLabel lblPoststed_1 = new JLabel("Poststed");
		lblPoststed_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPoststed_1.setBounds(175, 283, 441, 32);
		kunder.add(lblPoststed_1);

		button_7 = new JButton("T\u00F8m Felter");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				redigerNummer.setText("");
				redigerNavn.setText("");
				redigerHusNr.setText("");
				redigerAdresse.setText("");
				redigerPostNummer.setText("");
				redigerPostSted.setText("");
			}
		});
		button_7.setBounds(510, 420, 110, 41);
		kunder.add(button_7);

		JPanel retter = new JPanel();
		tabbedPane_1.addTab("Retter", null, retter, null);
		retter.setLayout(null);

		retter_list = new JList(listModelProducts);
		retter_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					Product product = (Product)m2.getElementAt(retter_list.getSelectedIndex());
					retterNavn.setText(product.getName());
					retterPris.setText(String.valueOf(product.getPrice()));
					retterKommentar.setText(product.getDescription());
				}
//				else if(e.getButton() == e.BUTTON3){
//					try{
//						DatabaseConnector.deleteProduct((Product)m2.getElementAt(retter_list.getSelectedIndex()));
//						getProducts();						
//					}catch(Exception hehe){
//						System.out.println("Klarte ikke slette produkt");
//					}
//				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getClickCount() == 1){
					Product product = (Product)m2.getElementAt(retter_list.getSelectedIndex());
					retterNavn.setText(product.getName());
					retterPris.setText(String.valueOf(product.getPrice()));
					retterKommentar.setText(product.getDescription());
				}
			}
		});
		retter_list.setBounds(722, 64, 213, 468);
		retter.add(retter_list);

		rediger_retter = new JButton("Lagre");
		rediger_retter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product oldProduct = (Product)m2.getElementAt(retter_list.getSelectedIndex());
				Product newProduct = new Product(retterNavn.getText(), retterKommentar.getText(), Double.parseDouble(retterPris.getText()));
				DatabaseConnector.edit(oldProduct, newProduct);
				getProducts();
			}
		});
		rediger_retter.setBounds(10, 420, 100, 41);
		retter.add(rediger_retter);

		leggTil_retter = new JButton("Opprett");
		leggTil_retter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Product product = new Product(retterNavn.getText(), retterKommentar.getText(), Double.parseDouble(retterPris.getText()));
					DatabaseConnector.newProduct(product);
					getProducts();
					retterNavn.setText("");
					retterKommentar.setText("");
					retterPris.setText("");
				}catch(Exception e){
					System.out.println("Failed to add new User into database");
				}
			}
		});
		leggTil_retter.setBounds(722, 20, 100, 41);
		retter.add(leggTil_retter);

		leggTil_retter_1 = new JButton("Slett");
		leggTil_retter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatabaseConnector.deleteProduct((Product)m2.getElementAt(retter_list.getSelectedIndex()));
				getProducts();
			}
		});
		leggTil_retter_1.setBounds(835, 20, 100, 41);
		retter.add(leggTil_retter_1);

		retterNavn = new JTextField();
		retterNavn.setFont(new Font("Verdana", Font.PLAIN, 16));
		retterNavn.setColumns(10);
		retterNavn.setBounds(10, 64, 408, 60);
		retter.add(retterNavn);

		retterPris = new JTextField();
		retterPris.setFont(new Font("Verdana", Font.PLAIN, 16));
		retterPris.setColumns(10);
		retterPris.setBounds(453, 64, 156, 60);
		retter.add(retterPris);

		retterKommentar = new JTextPane();
		retterKommentar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == arg0.VK_ENTER){
					try{
						Product product = new Product(retterNavn.getText(), retterKommentar.getText(), Double.parseDouble(retterPris.getText()));
						DatabaseConnector.newProduct(product);
						getProducts();
						retterNavn.setText("");
						retterKommentar.setText("");
						retterPris.setText("");
					}catch(Exception e){
						System.out.println("Failed to add new Product into database");
					}					
				}
			}
		});
		retterKommentar.setFont(new Font("Verdana", Font.PLAIN, 16));
		retterKommentar.setBounds(10, 199, 408, 202);
		retter.add(retterKommentar);

		lblProduktnavn = new JLabel("Produktnavn");
		lblProduktnavn.setFont(new Font("Verdana", Font.BOLD, 14));
		lblProduktnavn.setBounds(10, 24, 408, 28);
		retter.add(lblProduktnavn);

		lblPris = new JLabel("Pris");
		lblPris.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPris.setBounds(453, 24, 156, 28);
		retter.add(lblPris);

		lblBeskrivelse = new JLabel("Kommentar");
		lblBeskrivelse.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBeskrivelse.setBounds(10, 158, 408, 30);
		retter.add(lblBeskrivelse);

		JButton btnTmFelter = new JButton("T\u00F8m Felter");
		btnTmFelter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				retterKommentar.setText("");
				retterNavn.setText("");
				retterPris.setText("");
			}
		});
		btnTmFelter.setBounds(510, 420, 110, 41);
		retter.add(btnTmFelter);


		//____COMBOBOX FOR ASSOSIATING DISHES TO BUTTONS
		String[] boxComponents = {"Nr.1", "Nr.2", "Nr.3", "Nr.4", "Nr.5", "Nr.6", "Nr.7", "Nr.8", "Nr.9"};
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		buttons.add(toggleButton);buttons.add(toggleButton_1);buttons.add(toggleButton_2);
		buttons.add(toggleButton_3);buttons.add(toggleButton_4);buttons.add(toggleButton_5);
		buttons.add(toggleButton_6);buttons.add(toggleButton_7);buttons.add(toggleButton_8);
		pizzaInfo.setForeground(Color.DARK_GRAY);


		pizzaInfo.setBounds(700, 68, 269, 492);
		bestilling.add(pizzaInfo);
		
		
		menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(menuBar);
		
		label_1 = new JLabel(new ImageIcon("src/Bilder/exit.gif"));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setIcon(new ImageIcon("src/Bilder/exit_on.gif"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setIcon(new ImageIcon("src/Bilder/exit.gif"));
			}
		});
		menuBar.add(label_1);
		label_1.setToolTipText("Avslutter Programmet");
		
		JMenu mnHjelp = new JMenu("Hjelp");
		mnHjelp.setForeground(Color.DARK_GRAY);
		menuBar.add(mnHjelp);
		
		JMenuItem mntmInstruksjoner = new JMenuItem("Instruksjoner");
		mntmInstruksjoner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Instruksjoner.run();
			}
		});
		mnHjelp.add(mntmInstruksjoner);
		
		JMenuItem mntmOm = new JMenuItem("Om");
		mntmOm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Om.run();
			}
		});
		mnHjelp.add(mntmOm);
		
		JMenu mnHistorie = new JMenu("Historikk");
		mnHistorie.setForeground(Color.DARK_GRAY);
		menuBar.add(mnHistorie);
		
		JMenuItem mntmOrdrehistorikk = new JMenuItem("Ordrehistorikk");
		mntmOrdrehistorikk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				History.run();				
			}
		});
		mnHistorie.add(mntmOrdrehistorikk);
		frame.setUndecorated(true);
	}
	public void lagListe(){
		try{
			getProducts();
			String pizzaListe = "<html>";
			for (int j = 0; j < 9; j++) {
				Product p = (Product)m2.getElementAt(j);
				pizzaListe += "#" + p.getId() + " " + p.toString() + "<br>" + p.getDescription() + "<br><br>";
			}
			pizzaInfo.setText(pizzaListe + "</html>");
		}catch(Exception eee){
			eee.printStackTrace();
			System.out.println("Noe gikk galt, hmmm?");
		}
	}
	private String menyKnappTrykk(String a) {
		if (isBrus) {
			for (int i = 0; i < model.getSize(); i++) {
				if (model.get(i).toString().charAt(model.get(i).toString().length()-3) == a.charAt(a.length()-3)) {
					nummerKnappTrykk("1");
					return a;
				}
			}
			isBrus = false;
			model.addElement("1" +" x "+a);
			return a;
		}
		for (int i = 0; i < model.getSize(); i++) {
			if (model.get(i).toString().charAt(model.get(i).toString().length()-1) == a.charAt(a.length()-1)) {
				nummerKnappTrykk("1");
				return a;
			}
		}
		model.addElement("1" +" x "+a); 
		return a;
	}
	private String nummerKnappTrykk(String nr){
		if (isBrus) {
			isBrus = false;
			if(model.isEmpty()){
				model.addElement(hvorMange + " x " + sisteTrykteKnapp);
				hvorMange = "";
				isBrus = false;
				return null;
			}
			for (int i = 0; i < model.getSize(); i++) {
				if(model.get(i).toString().charAt(model.get(i).toString().length()-3) == sisteTrykteKnapp.charAt(sisteTrykteKnapp.length()-3)){
					int teller = 0, temp = 0;
					String tmp = "";
					while(model.get(i).toString().charAt(teller) != ' '){
						tmp += model.get(i).toString().charAt(teller);
						teller++;
					}
					temp = Integer.parseInt(tmp) + Integer.parseInt(nr);
					Object o = model.remove(i);
					o = (temp + " x " + sisteTrykteKnapp);
					model.add(i, o);
					hvorMange = "";
					isBrus = false;
					return null;
				}
			}
			model.addElement(hvorMange + " x " + sisteTrykteKnapp);
			hvorMange = "";
			return null;
		}
		if(model.isEmpty()){
			model.addElement(hvorMange + " x " + sisteTrykteKnapp);
			hvorMange = "";
			return null;
		}

		for (int i = 0; i < model.getSize(); i++) {
			if(model.get(i).toString().charAt(model.get(i).toString().length()-1) == sisteTrykteKnapp.charAt(sisteTrykteKnapp.length()-1)){
				int teller = 0, temp = 0;
				String tmp = "";
				while(model.get(i).toString().charAt(teller) != ' '){
					tmp += model.get(i).toString().charAt(teller);
					teller++;
				}
				temp = Integer.parseInt(tmp) + Integer.parseInt(nr);
				Object o = model.remove(i);
				o = (temp + " x " + sisteTrykteKnapp);
				model.add(i, o);
				hvorMange = "";
				return null;
			}
		}
		model.addElement(hvorMange + " x " + sisteTrykteKnapp);
		hvorMange = "";
		return null;
	}
	public void getProducts(){
		try{
			//m2 inneholder Product objektene, mens listModelProducts inneholder Product.toString();
			m2 = DatabaseConnector.getProducts();
			listModelProducts.clear();
			for(int i = 0; i<m2.size(); i++){
				Product pr = (Product)m2.getElementAt(i);
				listModelProducts.addElement("#" + pr.getId() + " " + m2.getElementAt(i).toString());
			}
		}catch(Exception e){
//			System.out.println("Finner ingen produkter i databasen");
		}
	}
	/**
	 * Get or refresh all users
	 */
	public void getUsers(){
		try{
			m1 = DatabaseConnector.getUsers();		
			listmodelUsers.clear();
			//m1 inneholder objektene USERS, listmodelUsers inneholder user.toString();
			for(int i = 0; i<m1.size(); i++){
				User user = (User)m1.getElementAt(i);
				listmodelUsers.addElement(user.getId() + ". " + m1.getElementAt(i).toString());
			}
		}catch(Exception e){
//			e.printStackTrace();
//			System.out.println("Finner ingen kunder i databasen");
		}
	}
	public void getOrders(){
		try{
			listModelOrders.clear();
			listModelFinished.clear();
			//ordre som ikke er påbegynt
			m3 = DatabaseConnector.getOrders("due");
			if(m3 != null){
				for(int i = 0; i<m3.size(); i++){
					Order o = (Order)m3.getElementAt(i);
					listModelOrders.addElement(o.toString());
				}				
				list_3.setModel(listModelOrders);
			}
			//ordre som er påbegynt men enda ikke levert
			m4 = DatabaseConnector.getOrders("deliver");
			if(m3 != null){
				for(int i = 0; i<m4.size(); i++){
					Order o = (Order)m4.getElementAt(i);
					listModelFinished.addElement(o.toString());					
				}				
				list_4.setModel(listModelFinished);
			}
		}catch(Exception e){
//			System.out.println("Finner ingen orders i databasen");
//			e.printStackTrace();
		}
	}
	public String createReceipt(JList l){

		return "lololol";
	}
	/**
	 * 
	 * @param a
	 * @return
	 */
	public String createReceipt(String a){

		String temp = "";

		switch (a.charAt(9)) {
		case 1: temp = "x 1 Margarita" + "\t" + "110,-";
		case 2: temp = "x 1 Vesuvio" + "\t" + "110,-";
		case 3: temp = "x 1 Milano" + "\t" + "110,-";
		case 4: temp = "x 1 Gabagol" + "\t" + "220,-";
		case 5: temp = "x 1 Trondheim spesial" + "\t" + "110,-";	
		case 6: temp = "x 1 Calzone" + "\t" + "120,-";
		case 7: temp = "x 1 Capriciosa" + "\t" + "120,-";
		case 8: temp = "x 1 Maffioso" + "\t" + "120,-";
		case 9: temp = "x 1 Grozzo" + "\t" + "130,-";
		}

		return temp;
	}
	
	public String createOrder(JList l){

		int temp = list_2.getSize() + 1;
		String lol = "Ordre nr." + temp;
		return lol;
	}
}
