package GUI;

import java.awt.EventQueue;
import logic.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;
import javax.swing.JScrollPane;

import logic.Address;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

import Map.MapTesting;

import database.TemporaryUser;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.UIManager;

public class CopyOfStarter{
	private TemporaryDatabase database = new TemporaryDatabase();
	private JFrame frame;
	private JTextField nummer, navn, gatenavn, postnummer, poststed, kommentar;
	private JTextField husNr, husBokstav, land;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel label;
	private JPanel bestilling, reciept, panel, bestillingsInfo, Rediger;
	private JTabbedPane tabbedPane;
	private String count;
	private JRadioButton rdbtnKort, rdbtnKontant;
	private JButton toggleButton, toggleButton_1, toggleButton_2, toggleButton_3, toggleButton_4, toggleButton_5, toggleButton_6, toggleButton_7;
	private JButton toggleButton_8, tglbtnCola, tglbtnFanta, tglbtnUrge, tglbtnSprite, tglbtnFarris, tglbtnLol;
	private StringBuilder pizzaStreng = new StringBuilder();
	private JButton button, button_1, button_2, button_3, button_4, button_5, button_6, btnNewButton_1, btnNewButton, btnNeste;
	private JButton btnIncall;
	private JCheckBox chckbxLevering; 
	JList list_1;
	BufferedImage image;
	private logic.User user;

	private ArrayList<Integer> kvittering = new ArrayList<Integer>();
	JList list;
	DefaultListModel model = new DefaultListModel(), list_2 = new DefaultListModel(), list_5 = new DefaultListModel();
	DefaultListModel m1 = new DefaultListModel();
	DefaultListModel m2 = new DefaultListModel();
	DefaultListModel m3 = new DefaultListModel();

	private JTextField husnummer;
	private JTextField textField_1;
	private JLabel lblPostnummer;
	private JLabel lblPoststed;
	private JLabel lblKommentar;
	private JLabel lblRingendeNummer;
	private JButton btnLeggTil_1;
	private JButton btnFjernElement;
	private JPanel Utgaende;
	private JList list_3;
	private JList list_4;
	private JButton btnDel;
	private JButton button_8;
	private String sisteTrykteKnapp;
	private MapTesting map = new MapTesting();
	private JButton btnRedigerAdresse;
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Address> addresses = new ArrayList<Address>();

	private JTextField textField_2;
	private JLabel lblAddressNotFound;
	DatabaseConnector con = new DatabaseConnector();
	private JPanel kunder;
	private JList kunder_list;
	private JList retter_list;
	private JButton leggTil;
	private JButton Slett;
	private JButton Hent;
	private JButton Rediger_1;
	private JButton hent_retter;
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
	private JTextField retterKommentar;
	private JLabel lblProduktnavn;
	private JLabel lblPris;
	private JLabel lblBeskrivelse;
	JPanel Retter;
	DefaultListModel listmodelUsers = new DefaultListModel();
	DefaultListModel listModelProducts = new DefaultListModel();
	DefaultListModel listModelOrders = new DefaultListModel();

	ArrayList<String> alleUsers = new ArrayList<String>();
	private JPanel panel_2;
	private JButton btnLevert;
	private JPanel panel_1;
	private JLabel pizzaInfo = new JLabel();
	private JButton button_7;

	private int[] temp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyOfStarter window = new CopyOfStarter();
					window.frame.setVisible(true);
				} catch (Exception e) {	}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CopyOfStarter() {
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
		frame.setBounds(100, 100, 1000, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1000, 700);
		frame.getContentPane().add(tabbedPane);

		//---------------------Ny bestilling--------------------------------------

		bestilling = new JPanel();
		bestilling.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Ny Bestilling", null, bestilling, null);
		bestilling.setLayout(null);

		///////////////////meny knapper////////////////////////////

		toggleButton = new JButton("Nr.1");
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr.1");		
			}
		});
		toggleButton.setBounds(16, 45, 75, 45);
		bestilling.add(toggleButton);

		toggleButton_1 = new JButton("Nr.2");
		toggleButton_1.setBounds(101, 45, 75, 45);
		bestilling.add(toggleButton_1);
		toggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr.2");
			}
		});

		toggleButton_2 = new JButton("Nr.3");
		toggleButton_2.setBounds(183, 45, 75, 45);
		bestilling.add(toggleButton_2);
		toggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr.3");
			}
		});


		toggleButton_3 = new JButton("Nr.4");
		toggleButton_3.setBounds(16, 101, 75, 45);
		bestilling.add(toggleButton_3);
		toggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr.4");
			}
		});

		toggleButton_4 = new JButton("Nr.5");
		toggleButton_4.setBounds(101, 101, 75, 45);
		bestilling.add(toggleButton_4);
		toggleButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr.5");
			}
		});

		toggleButton_5 = new JButton("Nr.6");
		toggleButton_5.setBounds(183, 101, 75, 45);
		bestilling.add(toggleButton_5);
		toggleButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr.6");
			}
		});
		toggleButton_6 = new JButton("Nr.7");
		toggleButton_6.setBounds(16, 157, 75, 45);
		bestilling.add(toggleButton_6);
		toggleButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr.7");
			}
		});

		toggleButton_7 = new JButton("Nr.8");
		toggleButton_7.setBounds(101, 157, 75, 45);
		bestilling.add(toggleButton_7);
		toggleButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr.8");
			}
		});

		toggleButton_8 = new JButton("Nr.9");
		toggleButton_8.setBounds(183, 157, 75, 45);
		bestilling.add(toggleButton_8);
		toggleButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr.9");
			}
		});

		reciept = new JPanel();
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
				count = "0";
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
				sisteTrykteKnapp=menyKnappTrykk("Cola");
			}
		});
		tglbtnFanta = new JButton("Fanta");
		tglbtnFanta.setBounds(101, 235, 75, 45);
		bestilling.add(tglbtnFanta);
		tglbtnFanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Fanta");
			}
		});
		tglbtnSprite = new JButton("Sprite");
		tglbtnSprite.setBounds(183, 235, 75, 45);
		bestilling.add(tglbtnSprite);
		tglbtnSprite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Sprite");
			}
		});
		tglbtnUrge = new JButton("Urge");
		tglbtnUrge.setBounds(16, 291, 75, 45);
		bestilling.add(tglbtnUrge);
		tglbtnUrge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Urge");
			}
		});
		tglbtnFarris = new JButton("Farris");
		tglbtnFarris.setBounds(101, 291, 75, 45);
		bestilling.add(tglbtnFarris);
		tglbtnFarris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Farris");
			}
		});
		tglbtnLol = new JButton("Vann");
		tglbtnLol.setBounds(183, 291, 75, 45);
		bestilling.add(tglbtnLol);
		tglbtnLol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Vann");
			}
		});



		//////////////////////"antall" kanpper///////////////////

		button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nummerKnappTrykk("1");
			}
		});
		button.setBounds(16, 403, 75, 45);
		bestilling.add(button);

		button_1 = new JButton("2");
		button_1.setBounds(101, 403, 75, 45);
		bestilling.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nummerKnappTrykk("2");
			}
		});

		btnNewButton = new JButton("3");
		btnNewButton.setActionCommand("2");
		btnNewButton.setBounds(183, 403, 75, 45);
		bestilling.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nummerKnappTrykk("3");
			}
		});

		button_2 = new JButton("4");
		button_2.setBounds(16, 459, 75, 45);
		bestilling.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nummerKnappTrykk("4");
			}
		});


		button_4 = new JButton("5");
		button_4.setBounds(101, 459, 75, 45);
		bestilling.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nummerKnappTrykk("5");
			}
		});

		button_5 = new JButton("6");
		button_5.setBounds(183, 459, 75, 45);
		bestilling.add(button_5);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nummerKnappTrykk("6");
			}
		});

		button_3 = new JButton("7");
		button_3.setBounds(16, 515, 75, 45);
		bestilling.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nummerKnappTrykk("7");
			}
		});

		button_6 = new JButton("8");
		button_6.setBounds(101, 515, 75, 45);
		bestilling.add(button_6);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nummerKnappTrykk("8");
			}
		});

		btnNewButton_1 = new JButton("9");
		btnNewButton_1.setBounds(183, 515, 75, 45);
		bestilling.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nummerKnappTrykk("9");
			}
		});

		button_8 = new JButton("0");
		button_8.setBounds(101, 567, 75, 45);
		bestilling.add(button_8);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nummerKnappTrykk("0");
			}
		});

		btnDel = new JButton("del");
		btnDel.setBounds(16, 567, 75, 45);
		bestilling.add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count.length()>1)
					count = count.substring(0, count.length()-1);
				label.setText("x " + count);
				model.remove(model.getSize()-1);
				model.addElement(count+" x " +sisteTrykteKnapp);
			}
		});


		label = new JLabel("x "+ "1");
		if ( count == null)

			label.setBounds(24, 337, 229, 14);
		bestilling.add(label);


		btnNeste = new JButton("Neste");
		btnNeste.setForeground(new Color(47, 79, 79));
		btnNeste.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNeste.setBackground(new Color(204, 255, 204));
		btnNeste.setBounds(831, 567, 138, 68);
		bestilling.add(btnNeste);
		btnNeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedComponent(bestillingsInfo);
				temp = new int[kvittering.size()];
				for(int i = 0; i<kvittering.size(); i++){
					temp[i] = kvittering.get(i);
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

		kommentar = new JTextField();
		kommentar.setBounds(16, 190, 190, 93);
		bestillingsInfo.add(kommentar);
		kommentar.setColumns(10);

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
		husnummer.setBounds(216, 83, 34, 28);
		bestillingsInfo.add(husnummer);
		husnummer.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(260, 83, 34, 28);
		bestillingsInfo.add(textField_1);

		JLabel lblHusnr = new JLabel("Husnr og bokstav");
		lblHusnr.setBounds(204, 69, 90, 14);
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

		//Denne skal FJERNES!!!?		

		//		btnLeggTil_1 = new JButton("Legg til");
		//		btnLeggTil_1.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				database.addUser(navn.getText(), nummer.getText(), database.addAddress(gatenavn.getText(), husNr.getText(), husBokstav.getText(), postnummer.getText(), poststed.getText(), land.getText()));
		//			}
		//		});
		//		btnLeggTil_1.setBounds(16, 294, 89, 23);
		//		bestillingsInfo.add(btnLeggTil_1);

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
					User user = DatabaseConnector.getUser(nummer.getText());
					Order order = new Order(DatabaseConnector.getUser(nummer.getText()).getId());
					order.setProducts(temp);
					temp=null;
					DatabaseConnector.newOrder(order);
					getOrders();
					tmp = user.getAddress().getStreet();
					if (user.getAddress().getStreet().contains(" ")) {
						tmp = tmp.replace(' ' , '+');
					}
					try{
						map.call("http://maps.google.com/maps/api/staticmap?center=" + tmp + "&" + String.valueOf(husnummer.getText()) + "&" + poststed.getText() + ",norway&zoom=14&size=400x400&sensor=false", tmp + " " + String.valueOf(husnummer.getText()) + ", " + poststed.getText());										
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
						temp=null;
						DatabaseConnector.newOrder(order);
						getOrders();
					}catch(Exception j){
						System.out.println("Failed to create new User");
					}
				}
				navn.setText("");
				nummer.setText("");
				gatenavn.setText("");
				postnummer.setText("");
				poststed.setText("");
				kommentar.setText("");
				husnummer.setText("");
				textField_1.setText("");
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

		Utgaende = new JPanel();
		Utgaende.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Utg\u00E5ende", null, Utgaende, null);
		Utgaende.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Ikke ferdig", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(4, 35, 241, 515);
		Utgaende.add(panel_2);
		panel_2.setLayout(null);
		//list_3 = new JList(list_2);
		list_3 = new JList(listModelOrders);
		list_3.setBounds(6, 22, 229, 487);
		panel_2.add(list_3);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Ferdig", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(423, 35, 241, 515);
		Utgaende.add(panel_3);
		panel_3.setLayout(null);

		list_4 = new JList(list_5);
		list_4.setBounds(6, 22, 229, 487);
		panel_3.add(list_4);

		btnLevert = new JButton("Levert");
		btnLevert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_5.getSize()>0){
					DatabaseConnector.deleteOrder((Order)m3.getElementAt((list_4.getSelectedIndex())));
					list_5.remove(list_4.getSelectedIndex());
					getOrders();
				}
			}
		});
		btnLevert.setBounds(135, 0, 100, 23);
		panel_3.add(btnLevert);

		lblAddressNotFound = new JLabel("Kunne ikke finne adresse");
		lblAddressNotFound.setForeground(new Color(255, 0, 0));
		lblAddressNotFound.setBounds(259, 72, 222, 14);
		Utgaende.add(lblAddressNotFound);
		lblAddressNotFound.setVisible(false);

		btnRedigerAdresse = new JButton("Rediger Adresse");
		btnRedigerAdresse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedComponent(bestillingsInfo);
				lblAddressNotFound.setVisible(false);
				btnRedigerAdresse.setVisible(false);
			}
		});
		btnRedigerAdresse.setBounds(269, 97, 137, 23);
		Utgaende.add(btnRedigerAdresse);
		btnRedigerAdresse.setVisible(false);

		JButton btnVisKart = new JButton("Vis Kart");
		btnVisKart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					User u = (User)m3.getElementAt(list_3.getSelectedIndex());
					String url = u.getAddress().getStreet() + "&" + String.valueOf(u.getAddress().getHouseNumber()) + "&" + u.getAddress().getZipcode() + "&" + u.getAddress().getCity() + ",norway&zoom=14&size=400x400&sensor=false";
					String tittle = u.getAddress().getStreet() + " " + String.valueOf(u.getAddress().getHouseNumber()) + ", " + u.getAddress().getCity();
					map.call("http://maps.google.com/maps/api/staticmap?center=" + url, tittle);					
				}catch(Exception e){
					//					e.printStackTrace();
					lblAddressNotFound.setVisible(true);
					btnRedigerAdresse.setVisible(true);
				}
			}
		});
		btnVisKart.setForeground(new Color(47, 79, 79));
		btnVisKart.setFont(new Font("Verdana", Font.BOLD, 16));
		btnVisKart.setBounds(269, 18, 137, 50);
		Utgaende.add(btnVisKart);

		JButton btnLages = new JButton("Ikke ferdig");
		btnLages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(list_5.getSize()>0){
						list_2.addElement(list_4.getSelectedValue());
						list_5.remove(list_4.getSelectedIndex());
					}
				}
				catch(Exception e){
					System.out.println("Listen er tom");
				}
			}
		});
		btnLages.setBounds(269, 521, 117, 29);
		Utgaende.add(btnLages);

		JButton btnFerdig = new JButton("Ferdig");
		btnFerdig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Order o = (Order)m3.getElementAt(list_3.getSelectedIndex());
					String id = o.getUserId();
					o.setDueDateToNow();
					DatabaseConnector.edit(o);
					if(list_2.getSize()>0){
						list_5.addElement(list_3.getSelectedValue());
						listModelOrders.remove(list_3.getSelectedIndex());
					}
				}
				catch(Exception e){
					System.out.println("Listen er tom");
				}
				getOrders();
			}
		});
		btnFerdig.setBounds(269, 474, 117, 29);
		Utgaende.add(btnFerdig);




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
					System.out.println(user.getName());
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
				if(arg0.getClickCount() == 2){
					int selectedIndex = kunder_list.getSelectedIndex();
					User user = (User)m1.getElementAt(selectedIndex);
					redigerNavn.setText(user.getName());
					redigerNummer.setText(user.getPhone());
					redigerAdresse.setText(user.getAddress().getStreet());
					redigerHusNr.setText(String.valueOf(user.getAddress().getHouseNumber()));
					redigerPostNummer.setText(user.getAddress().getZipcode());
					redigerPostSted.setText(user.getAddress().getCity());
				}
				else if(arg0.getButton() == arg0.BUTTON3){
					try{
						int id = kunder_list.getSelectedIndex();
						User user = (User)m1.getElementAt(id);
						DatabaseConnector.deleteUser(user);
						getUsers();						
					}catch(Exception e){
						System.out.println("Klarte ikke slette bruker");
					}
				}
			}
		});
		kunder_list.setBounds(734, 105, 213, 468);
		kunder.add(kunder_list);

		leggTil = new JButton("Legg Til");
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
		leggTil.setBounds(734, 64, 100, 41);
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
		Slett.setBounds(847, 64, 100, 41);
		kunder.add(Slett);

		Hent = new JButton("Hent");
		Hent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedIndex = kunder_list.getSelectedIndex();
				User user = (User)m1.getElementAt(selectedIndex);
				redigerNavn.setText(user.getName());
				redigerNummer.setText(user.getPhone());
				redigerAdresse.setText(user.getAddress().getStreet());
				redigerHusNr.setText(String.valueOf(user.getAddress().getHouseNumber()));
				redigerPostNummer.setText(user.getAddress().getZipcode());
				redigerPostSted.setText(user.getAddress().getCity());
			}
		});
		Hent.setBounds(734, 11, 100, 41);
		kunder.add(Hent);

		Rediger_1 = new JButton("Rediger");
		Rediger_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Address address = new Address(redigerAdresse.getText(), Integer.parseInt(redigerHusNr.getText()), redigerPostNummer.getText(), redigerPostSted.getText());
				User newUser = new User(redigerNavn.getText(), redigerNummer.getText(), address);
				User oldUser = (User)m1.getElementAt(kunder_list.getSelectedIndex());
				DatabaseConnector.edit(oldUser, newUser);
				getUsers();
			}
		});
		Rediger_1.setBounds(847, 11, 100, 41);
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
		button_7.setBounds(10, 416, 110, 41);
		kunder.add(button_7);

		JPanel retter = new JPanel();
		tabbedPane_1.addTab("Retter", null, retter, null);
		retter.setLayout(null);

		retter_list = new JList(listModelProducts);
		retter_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					Product product = (Product)m2.getElementAt(retter_list.getSelectedIndex());
					retterNavn.setText(product.getName());
					retterPris.setText(String.valueOf(product.getPrice()));
					retterKommentar.setText(product.getDescription());
				}
				else if(e.getButton() == e.BUTTON3){
					try{
						DatabaseConnector.deleteProduct((Product)m2.getElementAt(retter_list.getSelectedIndex()));
						getProducts();						
					}catch(Exception hehe){
						System.out.println("Klarte ikke slette produkt");
					}
				}
			}
		});
		retter_list.setBounds(734, 105, 213, 468);
		retter.add(retter_list);

		hent_retter = new JButton("Hent");
		hent_retter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product = (Product)m2.getElementAt(retter_list.getSelectedIndex());
				retterNavn.setText(product.getName());
				retterPris.setText(String.valueOf(product.getPrice()));
				retterKommentar.setText(product.getDescription());
			}
		});
		hent_retter.setBounds(734, 11, 100, 41);
		retter.add(hent_retter);

		rediger_retter = new JButton("Rediger");
		rediger_retter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product oldProduct = (Product)m2.getElementAt(retter_list.getSelectedIndex());
				Product newProduct = new Product(retterNavn.getText(), retterKommentar.getText(), Double.parseDouble(retterPris.getText()));
				DatabaseConnector.edit(oldProduct, newProduct);
				getProducts();
			}
		});
		rediger_retter.setBounds(847, 11, 100, 41);
		retter.add(rediger_retter);

		leggTil_retter = new JButton("Legg Til");
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
		leggTil_retter.setBounds(734, 64, 100, 41);
		retter.add(leggTil_retter);

		leggTil_retter_1 = new JButton("Slett");
		leggTil_retter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatabaseConnector.deleteProduct((Product)m2.getElementAt(retter_list.getSelectedIndex()));
				getProducts();
			}
		});
		leggTil_retter_1.setBounds(847, 64, 100, 41);
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

		retterKommentar = new JTextField();
		retterKommentar.setFont(new Font("Verdana", Font.PLAIN, 16));
		retterKommentar.setColumns(10);
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
		btnTmFelter.setBounds(10, 412, 110, 41);
		retter.add(btnTmFelter);


		//____COMBOBOX FOR ASSOSIATING DISHES TO BUTTONS
		String[] boxComponents = {"Nr.1", "Nr.2", "Nr.3", "Nr.4", "Nr.5", "Nr.6", "Nr.7", "Nr.8", "Nr.9"};
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		buttons.add(toggleButton);buttons.add(toggleButton_1);buttons.add(toggleButton_2);
		buttons.add(toggleButton_3);buttons.add(toggleButton_4);buttons.add(toggleButton_5);
		buttons.add(toggleButton_6);buttons.add(toggleButton_7);buttons.add(toggleButton_8);


		pizzaInfo.setBounds(700, 68, 269, 492);
		bestilling.add(pizzaInfo);


		//		JList list_3 = new JList();
		for(int i = 0; i<users.size(); i++){
			m1.addElement(users.get(i));
		}
	}
	public void lagListe(){
		try{
			getProducts();
			String pizzaListe = "<html>";
			for (int j = 0; j < m2.size(); j++) {
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
		for (int i = 0; i < model.getSize(); i++) {
			if (model.get(i).toString().equals(a)) {
				nummerKnappTrykk("1");
			}
		}
		count = null;
		model.addElement("1" +" x "+a); 
		label.setText("x "+"1");
		return a;
	}
	private String nummerKnappTrykk(String nr){
		if (count == null)
			count = nr;
		else
			count += nr;
		for (int i = 0; i < model.getSize(); i++) {
			if (model.get(i).toString().charAt(9) == sisteTrykteKnapp.charAt(9)) {
				model.remove(i);
				model.addElement(count + nr + " x " + sisteTrykteKnapp);
				return null;
			}
		}
		if(!model.isEmpty()){
			model.remove(model.getSize()-1);
			model.addElement(count+" x " +sisteTrykteKnapp);			
		}
		label.setText("x " + count);

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
			//			e.printStackTrace();
			System.out.println("Finner ingen produkter i databasen");
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
			e.printStackTrace();
			System.out.println("Finner ingen kunder i databasen");
		}
	}
	public void getOrders(){
		try{
			m3 = DatabaseConnector.getOrders();
			listModelOrders.clear();
			for(int i = 0; i<m3.size(); i++){
				Order o = (Order)m3.getElementAt(i);
				listModelOrders.addElement(o.toString());
			}
		}catch(Exception e){
			System.out.println("Finner ingen orders i databasen");
		}
	}
	public String createReceipt(JList l){

		return "lololol";
	}
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