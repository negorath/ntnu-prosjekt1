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


//import database.People;
import database.TemporaryUser;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;

public class CopyOfStarter{
	private TemporaryDatabase database = new TemporaryDatabase();
	private JFrame frame;
	private JTextField nummer, navn, gatenavn, postnummer, poststed, kommentar, redigerNavn, redigerNummer;
	private JTextField redigerHusnr, redigerPostnummer, redigerPoststed, husNr, husBokstav, land;
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
	private JButton btnRediger, btnHentNr, btnLeggTil, btnIncall;
	private JCheckBox chckbxLevering; 
	JList list_1;
	ArrayList<UserArray> userArray = new ArrayList<UserArray>();
	BufferedImage image;
	//	private logic.Product product;
	//	private logic.Address adress;
	private logic.User user;

	private ArrayList<Integer> kvittering = new ArrayList<Integer>();
	JList list;
	DefaultListModel model = new DefaultListModel(), m1 = new DefaultListModel();
	private JTextField husnummer;
	private JTextField textField_1;
	private JLabel lblPostnummer;
	private JLabel lblPoststed;
	private JLabel lblKommentar;
	private JLabel lblRingendeNummer;
	private JLabel lblBestillinger;
	private JButton btnLeggTil_1;
	private JButton btnFjernElement;
	private JPanel Utgaende;
	private JList list_2, list_3;
	private JButton btnDel;
	private JButton button_8;
	private String sisteTrykteKnapp;
	private MapTesting map = new MapTesting();
	private JTextField redigerAdresse;
	private JLabel lblGatenavn_1;
	private JLabel lblHusnummer;
	private JTextField textField_2;
	private JTextField redigerProductName;
	private JTextField RedigerProductPrice;
	private JLabel lblAddressNotFound;
	private JButton btnRedigerAdresse;
	JPanel Retter;
//	DatabaseConnector connector = new DatabaseConnector();
	ArrayList<String> alleUsers = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyOfStarter window = new CopyOfStarter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CopyOfStarter() {
		initialize();
		DatabaseConnector connector = new DatabaseConnector();
		connector.initialize();
		connector.getConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//		frame.setBounds(100, 100, 800, 621);
		frame.setBounds(100, 100, 1000, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1000, 700);
		frame.getContentPane().add(tabbedPane);

		//---------------------Ny bestilling--------------------------------------

		userArray.add(new UserArray(HelpUser.getBob().getName(), HelpUser.getBob().getPhone(), HelpUser.getBob().getAddress().getStreet(), HelpUser.getBob().getAddress().getZipcode(), HelpUser.getBob().getAddress().getCity(), HelpUser.getBob().getAddress().getHouseNumber()));
		bestilling = new JPanel();
		bestilling.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Ny Bestilling", null, bestilling, null);
		bestilling.setLayout(null);

		///////////////////meny knapper////////////////////////////

		toggleButton = new JButton("Nr.1");
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza Margaritha");
				//		 		kvittering.add(Product.retrieve(1).getId()); 			

			}
		});
		toggleButton.setBounds(16, 45, 75, 45);
		bestilling.add(toggleButton);

		toggleButton_1 = new JButton("Nr.2");
		toggleButton_1.setBounds(101, 45, 75, 45);
		bestilling.add(toggleButton_1);
		toggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza med cheesedoodles");
			}
		});

		toggleButton_2 = new JButton("Nr.3");
		toggleButton_2.setBounds(183, 45, 75, 45);
		bestilling.add(toggleButton_2);
		toggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr3");
			}
		});


		toggleButton_3 = new JButton("Nr.4");
		toggleButton_3.setBounds(16, 101, 75, 45);
		bestilling.add(toggleButton_3);
		toggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr4");
			}
		});

		toggleButton_4 = new JButton("Nr.5");
		toggleButton_4.setBounds(101, 101, 75, 45);
		bestilling.add(toggleButton_4);
		toggleButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr5");
			}
		});

		toggleButton_5 = new JButton("Nr.6");
		toggleButton_5.setBounds(183, 101, 75, 45);
		bestilling.add(toggleButton_5);
		toggleButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr6");
			}
		});
		toggleButton_6 = new JButton("Nr.7");
		toggleButton_6.setBounds(16, 157, 75, 45);
		bestilling.add(toggleButton_6);
		toggleButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr7");
			}
		});

		toggleButton_7 = new JButton("Nr.8");
		toggleButton_7.setBounds(101, 157, 75, 45);
		bestilling.add(toggleButton_7);
		toggleButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr8");
			}
		});

		toggleButton_8 = new JButton("Nr.9");
		toggleButton_8.setBounds(183, 157, 75, 45);
		bestilling.add(toggleButton_8);
		toggleButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr9");
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
					model.remove(list.getSelectedIndex());
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
		btnNeste.setBounds(831, 555, 138, 68);
		bestilling.add(btnNeste);
		btnNeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedComponent(bestillingsInfo);
				int[] temp = new int[kvittering.size()];
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
		navn.setText("Navn");
		bestillingsInfo.add(navn);
		navn.setColumns(10);

		nummer = new JTextField();
		nummer.setFont(new Font("Verdana", Font.BOLD, 20));
		nummer.setBounds(835, 30, 134, 28);
		nummer.setText("Nummer");
		bestillingsInfo.add(nummer);
		nummer.setColumns(10);

		gatenavn = new JTextField();
		gatenavn.setBounds(16, 83, 190, 28);
		gatenavn.setText("Adresse");
		bestillingsInfo.add(gatenavn);
		gatenavn.setColumns(10);

		postnummer = new JTextField();
		postnummer.setBounds(16, 135, 133, 28);
		postnummer.setText("Postnr.");
		bestillingsInfo.add(postnummer);
		postnummer.setColumns(10);

		poststed = new JTextField();
		poststed.setBounds(160, 135, 134, 28);
		poststed.setText("Sted");
		bestillingsInfo.add(poststed);
		poststed.setColumns(10);

		kommentar = new JTextField();
		kommentar.setBounds(16, 190, 190, 93);
		kommentar.setText("Kommentar");
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

		list_1 = new JList(model);

		list_1.setBounds(336, 30, 265, 379);
		bestillingsInfo.add(list_1);

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

		lblBestillinger = new JLabel("Bestillinger");
		lblBestillinger.setBounds(336, 12, 81, 14);
		bestillingsInfo.add(lblBestillinger);

		JButton btnRediger_1 = new JButton("Rediger");
		btnRediger_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedComponent(bestilling);
			}
		});
		btnRediger_1.setBounds(512, 8, 89, 23);
		bestillingsInfo.add(btnRediger_1);

		btnLeggTil_1 = new JButton("Legg til");
		btnLeggTil_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database.addUser(navn.getText(), nummer.getText(), database.addAddress(gatenavn.getText(), husNr.getText(), husBokstav.getText(), postnummer.getText(), poststed.getText(), land.getText()));
			}
		});
		btnLeggTil_1.setBounds(16, 294, 89, 23);
		bestillingsInfo.add(btnLeggTil_1);

		JButton btnNeste_1 = new JButton("Neste");
		btnNeste_1.setForeground(new Color(47, 79, 79));
		btnNeste_1.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNeste_1.setBackground(new Color(204, 255, 204));
		btnNeste_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedComponent(Utgaende);
				try{
					map.call("http://maps.google.com/maps/api/staticmap?center=" + gatenavn.getText() + "&" + String.valueOf(husnummer.getText()) + "&" + poststed.getText() + ",norway&zoom=14&size=400x400&sensor=false", gatenavn.getText() + " " + String.valueOf(husnummer.getText()) + ", " + poststed.getText());					
				}catch(Exception e){
					//					e.printStackTrace();
					lblAddressNotFound.setVisible(true);
					btnRedigerAdresse.setVisible(true);
				}
			}
		});
		btnNeste_1.setBounds(831, 555, 138, 68);
		bestillingsInfo.add(btnNeste_1);

		//--------------------------Utgaaende/chef-----------------------------------------

		Utgaende = new JPanel();
		Utgaende.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Utg\u00E5ende", null, Utgaende, null);
		Utgaende.setLayout(null);

		list_2 = new JList(model);
		list_2.setBounds(10, 11, 229, 533);
		Utgaende.add(list_2);

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
		btnRedigerAdresse.setBounds(249, 97, 137, 23);
		Utgaende.add(btnRedigerAdresse);
		btnRedigerAdresse.setVisible(false);

		JButton btnVisKart = new JButton("Vis Kart");
		btnVisKart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					map.call("http://maps.google.com/maps/api/staticmap?center=" + gatenavn.getText() + "&" + String.valueOf(husnummer.getText()) + "&" + poststed.getText() + ",norway&zoom=14&size=400x400&sensor=false", gatenavn.getText() + " " + String.valueOf(husnummer.getText()) + ", " + poststed.getText());					
				}catch(Exception e){
					//					e.printStackTrace();
					lblAddressNotFound.setVisible(true);
					btnRedigerAdresse.setVisible(true);
				}
			}
		});
		btnVisKart.setForeground(new Color(47, 79, 79));
		btnVisKart.setFont(new Font("Verdana", Font.BOLD, 16));
		btnVisKart.setBounds(249, 11, 137, 50);
		Utgaende.add(btnVisKart);


		//------------------------Rediger-------------------------------------------------

		Rediger = new JPanel();
		Rediger.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Rediger", null, Rediger, null);
		Rediger.setLayout(null);

		btnRediger = new JButton("Rediger");
		btnRediger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabbedPane.getSelectedComponent() == Rediger){
					//rediger elementer vha input til navn eller nummer
				}
				else if(tabbedPane.getSelectedComponent() == Retter){
					//rediger rett vha navn eller knapp?
				}
			}
		});
		btnRediger.setBounds(141, 108, 119, 50);
		btnRediger.setForeground(new Color(47, 79, 79));
		btnRediger.setFont(new Font("Verdana", Font.BOLD, 16));
		Rediger.add(btnRediger);

		btnHentNr = new JButton("Hent");
		btnHentNr.setBounds(10, 42, 250, 55);
		btnHentNr.setForeground(new Color(47, 79, 79));
		btnHentNr.setFont(new Font("Verdana", Font.BOLD, 16));
		btnHentNr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//FUNKSJONALITET HVIS DU TRYKKER PÅ HENT I REDIGER TABBEN
				if(tabbedPane.getSelectedComponent() == Rediger){
					try{
						redigerNavn.setText(User.retrieve(0).getName());
						redigerAdresse.setText(User.retrieve(0).getAddress().getStreet());
						redigerHusnr.setText(String.valueOf(User.retrieve(0).getAddress().getHouseNumber()));
						redigerPostnummer.setText(User.retrieve(0).getAddress().getZipcode());
						redigerPoststed.setText(User.retrieve(0).getAddress().getCity());											
					}catch(Exception t){
						System.out.println("LOOL FUNKER IKKE");
					}
					for(int i = 0; i<m1.size(); i++){
						if(list_3.getSelectedIndex() == i){
							redigerNavn.setText(userArray.get(i).name);
							redigerNummer.setText(userArray.get(i).phone);
							redigerAdresse.setText(userArray.get(i).address);
							redigerHusnr.setText(String.valueOf(userArray.get(i).nr));
							redigerPostnummer.setText(userArray.get(i).zipcode);
							redigerPoststed.setText(userArray.get(i).city);
						}
					}
				}
				
				//FUNKSJONALITET HVIS DU TRYKKER PÅ HENT I RETTER TABBEN
				else if(tabbedPane.getSelectedComponent() == Retter){
					
				}			
				frame.repaint();
			}
		});
		Rediger.add(btnHentNr);

		//INCALL; SLï¿½R OPP I DATABASEN OG HENTER INFO OM MULIG
		btnIncall = new JButton("Incall");
		btnIncall.setForeground(new Color(47, 79, 79));
		btnIncall.setFont(new Font("Verdana", Font.BOLD, 16));
		btnIncall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//				People p = new People();
				String nr = JOptionPane.showInputDialog(null, "Skriv inn incall number");
				nummer.setText(nr);
				try{
					User user = User.retrieve(Integer.parseInt(nr));
					if(user == null){
						user = new User();
					}
					else{
						navn.setText(user.getName());
						gatenavn.setText(user.getAddress().getStreet());
						husnummer.setText(String.valueOf(user.getAddress().getHouseNumber()));
						postnummer.setText(user.getAddress().getZipcode());
						poststed.setText(user.getAddress().getCity());
					}
				}catch(Exception ee){
					navn.setText("");
					gatenavn.setText("");
					postnummer.setText("");
					poststed.setText("");
					kommentar.setText("");
				}
				frame.repaint();
			}
		});
		btnIncall.setBounds(848, 11, 121, 45);
		bestilling.add(btnIncall);

		textField_2 = new JTextField("<Html>#1: Pizza Margaritha: Tomat, ost" + "<br>" + "#2:</Html>");
		textField_2.setBounds(662, 67, 307, 477);
		bestilling.add(textField_2);
		textField_2.setColumns(10);




		btnLeggTil = new JButton("Legg til");
		btnLeggTil.setBounds(10, 108, 119, 50);
		btnLeggTil.setForeground(new Color(47, 79, 79));
		btnLeggTil.setFont(new Font("Verdana", Font.BOLD, 16));
		btnLeggTil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//HVIS DU TRYKKER LEGG TIL I PANELET REDIGER
				if(tabbedPane.getSelectedComponent() == Rediger){
					Address address = new Address(redigerAdresse.getText(), Integer.parseInt(redigerHusnr.getText()), redigerPostnummer.getText(), redigerPoststed.getText());
//					User.create(redigerNavn.getText(), redigerNummer.getText(), address);
					
					m1.addElement(redigerNavn.getText() + " " + redigerNummer.getText());
					list_3 = new JList(m1);
					
					userArray.add(new UserArray(redigerNavn.getText(), redigerNummer.getText(), redigerAdresse.getText(), redigerPostnummer.getText(), redigerPoststed.getText(), Integer.parseInt(redigerNummer.getText())));
					
					
					User user = new User(redigerNavn.getText(), redigerNummer.getText(), redigerAdresse.getText(), redigerPostnummer.getText(), redigerPoststed.getText(), Integer.parseInt(redigerNummer.getText()));
					
					
				}
				//HVIS DU TRYKKER LEGG TIL I PANELET RETTER
				else if(tabbedPane.getSelectedComponent() == Retter){	
				}
				frame.repaint();
			}
		});
		Rediger.add(btnLeggTil);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(270, 11, 699, 612);
		Rediger.add(tabbedPane_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		tabbedPane_1.addTab("Kunder", null, panel_1, null);
		panel_1.setLayout(null);

		redigerNummer = new JTextField();
		redigerNummer.setBounds(20, 33, 245, 50);
		panel_1.add(redigerNummer);
		redigerNummer.setBackground(new Color(245, 245, 245));
		redigerNummer.setFont(new Font("Verdana", Font.BOLD, 18));
		redigerNummer.setText("");
		redigerNummer.setColumns(10);

		redigerNavn = new JTextField();
		redigerNavn.setBounds(20, 110, 393, 50);
		panel_1.add(redigerNavn);
		redigerNavn.setFont(new Font("Verdana", Font.PLAIN, 11));
		redigerNavn.setBackground(new Color(245, 245, 245));
		redigerNavn.setText("");
		redigerNavn.setColumns(10);

		JLabel lblTelefonNummer = new JLabel("Telefon nummer");
		lblTelefonNummer.setFont(new Font("Verdana", Font.BOLD, 16));
		lblTelefonNummer.setBounds(20, 11, 245, 23);
		panel_1.add(lblTelefonNummer);

		JLabel lblFulltNavn_1 = new JLabel("Fullt Navn");
		lblFulltNavn_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblFulltNavn_1.setBounds(20, 94, 393, 14);
		panel_1.add(lblFulltNavn_1);

		redigerPostnummer = new JTextField();
		redigerPostnummer.setBounds(20, 263, 155, 50);
		panel_1.add(redigerPostnummer);
		redigerPostnummer.setFont(new Font("Verdana", Font.PLAIN, 11));
		redigerPostnummer.setBackground(new Color(245, 245, 245));
		redigerPostnummer.setText("");
		redigerPostnummer.setColumns(10);

		redigerPoststed = new JTextField();
		redigerPoststed.setBounds(197, 263, 286, 50);
		panel_1.add(redigerPoststed);
		redigerPoststed.setFont(new Font("Verdana", Font.PLAIN, 11));
		redigerPoststed.setBackground(new Color(245, 245, 245));
		redigerPoststed.setText("");
		redigerPoststed.setColumns(10);

		JLabel lblPostnummer_1 = new JLabel("Postnummer");
		lblPostnummer_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPostnummer_1.setBounds(20, 247, 155, 14);
		panel_1.add(lblPostnummer_1);

		JLabel lblPoststed_1 = new JLabel("Poststed");
		lblPoststed_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPoststed_1.setBounds(197, 249, 286, 14);
		panel_1.add(lblPoststed_1);

		redigerHusnr = new JTextField();
		redigerHusnr.setBounds(433, 186, 50, 50);
		panel_1.add(redigerHusnr);
		redigerHusnr.setFont(new Font("Verdana", Font.PLAIN, 11));
		redigerHusnr.setBackground(new Color(245, 245, 245));
		redigerHusnr.setText("");
		redigerHusnr.setColumns(10);

		redigerAdresse = new JTextField();
		redigerAdresse.setBackground(new Color(245, 245, 245));
		redigerAdresse.setBounds(20, 186, 393, 50);
		panel_1.add(redigerAdresse);
		redigerAdresse.setColumns(10);

		lblGatenavn_1 = new JLabel("Adresse");
		lblGatenavn_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblGatenavn_1.setBounds(20, 171, 393, 14);
		panel_1.add(lblGatenavn_1);

		lblHusnummer = new JLabel("Nr");
		lblHusnummer.setFont(new Font("Verdana", Font.BOLD, 16));
		lblHusnummer.setBounds(433, 171, 52, 14);
		panel_1.add(lblHusnummer);

		Retter = new JPanel();
		Retter.setBackground(new Color(211, 211, 211));
		tabbedPane_1.addTab("Retter", null, Retter, null);
		Retter.setLayout(null);

		JLabel lblProduktetsNavn = new JLabel("Navn");
		lblProduktetsNavn.setFont(new Font("Verdana", Font.BOLD, 16));
		lblProduktetsNavn.setBounds(20, 11, 198, 14);
		Retter.add(lblProduktetsNavn);

		redigerProductName = new JTextField();
		redigerProductName.setBounds(20, 33, 280, 50);
		Retter.add(redigerProductName);
		redigerProductName.setColumns(10);

		JLabel lblPris = new JLabel("Pris");
		lblPris.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPris.setBounds(20, 97, 131, 14);
		Retter.add(lblPris);

		RedigerProductPrice = new JTextField();
		RedigerProductPrice.setBounds(20, 119, 150, 50);
		Retter.add(RedigerProductPrice);
		RedigerProductPrice.setColumns(10);

		//____COMBOBOX FOR ASSOSIATING DISHES TO BUTTONS
		String[] boxComponents = {"Nr.1", "Nr.2", "Nr.3", "Nr.4", "Nr.5", "Nr.6", "Nr.7", "Nr.8", "Nr.9"};
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		JComboBox comboBox = new JComboBox();
		buttons.add(toggleButton);buttons.add(toggleButton_1);buttons.add(toggleButton_2);
		buttons.add(toggleButton_3);buttons.add(toggleButton_4);buttons.add(toggleButton_5)
		;buttons.add(toggleButton_6);buttons.add(toggleButton_7);buttons.add(toggleButton_8);
		for(int i = 0; i<buttons.size(); i++){
			comboBox.addItem(boxComponents[i]);
		}
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if( e.getSource() == toggleButton && e.getStateChange() == ItemEvent.SELECTED ){
					//kobler knappen med ny informasjon til databasen
				}
			}
		});
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(180, 119, 188, 50);
		Retter.add(comboBox);
		//______COMBOBOX END


		JLabel lblAssosierMedKnapp = new JLabel("Assosier med Knapp");
		lblAssosierMedKnapp.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAssosierMedKnapp.setBounds(185, 97, 183, 21);
		Retter.add(lblAssosierMedKnapp);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(243, 169, 17, 454);
		Rediger.add(scrollBar);

		m1.addElement(HelpUser.getBob().getName() + " " + HelpUser.getBob().getPhone());
		list_3 = new JList(m1);
		list_3.setBounds(10, 169, 250, 454);
		Rediger.add(list_3);
	}
	private String menyKnappTrykk(String a) {

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
		if(!model.isEmpty()){
			model.remove(model.getSize()-1);
			model.addElement(count+" x " +sisteTrykteKnapp);			
		}
		label.setText("x " + count);

		return null;
	}
}
class UserArray{
	public String name, phone, address, zipcode, city;
	public int nr;
	
	public UserArray(String name, String phone, String address, String zipcode, String city, int nr){
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.nr = nr;
	}
	
}