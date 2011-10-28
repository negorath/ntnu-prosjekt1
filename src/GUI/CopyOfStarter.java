package GUI;

import java.awt.EventQueue;
import logic.*;

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
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;


import database.People;
import database.TemporaryUser;

public class CopyOfStarter{
	private TemporaryDatabase database = new TemporaryDatabase();
	private JFrame frame;
	private JTextField nummer, navn, gatenavn, postnummer, poststed, kommentar, redigerNavn, redigerNummer, redigerGatenavn;
	private JTextField redigerHusnr, redigerPostnummer, redigerPoststed, husNr, husBokstav, land;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblRegistrerteAdresser, label;
	private JPanel bestilling, reciept, panel, bestillingsInfo, Rediger;
	private JComboBox comboBox;
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
//	private logic.Product product;
//	private logic.Address adress;
//	private logic.User user;
	
	private ArrayList<Integer> kvittering = new ArrayList<Integer>();
	JList list;
	DefaultListModel model = new DefaultListModel();
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblPostnummer;
	private JLabel lblPoststed;
	private JLabel lblKommentar;
	private JLabel lblRingendeNummer;
	private JLabel lblBestillinger;
	private JButton btnLeggTil_1;
	private JButton btnFjernElement;
	private JPanel Utgaende;
	private JList list_2;
	private JButton btnDel;
	private JButton button_8;
	private String sisteTrykteKnapp;
	
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 784, 583);
		frame.getContentPane().add(tabbedPane);
		
		//---------------------Ny bestilling--------------------------------------
		
		bestilling = new JPanel();
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
		toggleButton.setBounds(16, 45, 75, 29);
		bestilling.add(toggleButton);
		
		toggleButton_1 = new JButton("Nr.2");
		toggleButton_1.setBounds(95, 45, 75, 29);
		bestilling.add(toggleButton_1);
		toggleButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		sisteTrykteKnapp=menyKnappTrykk("Pizza med cheesedoodles");
		 	}
		 });
				
		 toggleButton_2 = new JButton("Nr.3");
		toggleButton_2.setBounds(178, 45, 75, 29);
		bestilling.add(toggleButton_2);
		toggleButton_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		sisteTrykteKnapp=menyKnappTrykk("Pizza nr3");
		 	}
		 });
		
		
		 toggleButton_3 = new JButton("Nr.4");
		toggleButton_3.setBounds(16, 78, 75, 29);
		bestilling.add(toggleButton_3);
		toggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr4");
	 	}
	 });
		
		 toggleButton_4 = new JButton("Nr.5");
		toggleButton_4.setBounds(95, 78, 75, 29);
		bestilling.add(toggleButton_4);
		toggleButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr5");
	 	}
	 });
		
		 toggleButton_5 = new JButton("Nr.6");
		toggleButton_5.setBounds(178, 78, 75, 29);
		bestilling.add(toggleButton_5);
		toggleButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr6");
	 	}
	 });
		toggleButton_6 = new JButton("Nr.7");
		toggleButton_6.setBounds(16, 111, 75, 29);
		bestilling.add(toggleButton_6);
		toggleButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr7");
	 	}
	 });
		
		toggleButton_7 = new JButton("Nr.8");
		toggleButton_7.setBounds(95, 111, 75, 29);
		bestilling.add(toggleButton_7);
		toggleButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr8");
	 	}
	 });
		
		toggleButton_8 = new JButton("Nr.9");
		toggleButton_8.setBounds(178, 111, 75, 29);
		bestilling.add(toggleButton_8);
		toggleButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Pizza nr9");
	 	}
	 });
	 
		 reciept = new JPanel();
		reciept.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Kvittering", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		reciept.setBounds(300, 23, 352, 436);
		bestilling.add(reciept);
		reciept.setLayout(null);
		
		JButton btnFjernAlt = new JButton("Fjern Alt");
		btnFjernAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kvittering.clear();
				count = "0";
				model.removeAllElements();
				
			}
		});
		
		btnFjernElement = new JButton("Fjern");
		btnFjernElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		if (model.getSize()>0)
		 			model.remove(model.getSize()-1);
			}
		});
		btnFjernElement.setBounds(174, 0, 69, 23);
		reciept.add(btnFjernElement);
		btnFjernAlt.setBounds(253, 0, 89, 23);
		reciept.add(btnFjernAlt);
		
		list = new JList(model);		 
		list.setBounds(10, 23, 332, 402);
		reciept.add(list);
		
		
		///////////////////////Drikkeknapper/////////////////////////
		
		tglbtnCola = new JButton("Cola");
		tglbtnCola.setBounds(16, 213, 75, 29);
		bestilling.add(tglbtnCola);
		tglbtnCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Cola");
	 	}
	 });
		tglbtnFanta = new JButton("Fanta");
		tglbtnFanta.setBounds(95, 213, 78, 29);
		bestilling.add(tglbtnFanta);
		tglbtnFanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Fanta");
	 	}
	 });
		tglbtnSprite = new JButton("Sprite");
		tglbtnSprite.setBounds(178, 213, 80, 29);
		bestilling.add(tglbtnSprite);
		tglbtnSprite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Sprite");
	 	}
	 });
		tglbtnUrge = new JButton("Urge");
		tglbtnUrge.setBounds(16, 246, 75, 29);
		bestilling.add(tglbtnUrge);
		tglbtnUrge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Urge");
	 	}
	 });
		tglbtnFarris = new JButton("Farris");
		tglbtnFarris.setBounds(95, 246, 79, 29);
		bestilling.add(tglbtnFarris);
		tglbtnFarris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sisteTrykteKnapp=menyKnappTrykk("Farris");
	 	}
	 });
		tglbtnLol = new JButton("Vann");
		tglbtnLol.setBounds(178, 246, 80, 29);
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
		button.setBounds(16, 361, 75, 29);
		bestilling.add(button);
		
		 button_1 = new JButton("2");
		 button_1.setBounds(95, 361, 75, 29);
		 bestilling.add(button_1);
		 button_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		nummerKnappTrykk("2");
		 	}
		 });
		
		 btnNewButton = new JButton("3");
		 btnNewButton.setActionCommand("2");
		 btnNewButton.setBounds(177, 361, 80, 29);
		 bestilling.add(btnNewButton);
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		nummerKnappTrykk("3");
		 	}
		 });
		
		 button_2 = new JButton("4");
		 button_2.setBounds(16, 394, 75, 29);
		 bestilling.add(button_2);
		 button_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		nummerKnappTrykk("4");
		 	}
		 });
		
		
		button_4 = new JButton("5");
		button_4.setBounds(95, 394, 75, 29);
		bestilling.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nummerKnappTrykk("5");
			}
		});
		
		 button_5 = new JButton("6");
		 button_5.setBounds(178, 394, 80, 29);
		 bestilling.add(button_5);
		 button_5.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		nummerKnappTrykk("6");
		 	}
		 });
		 
		 button_3 = new JButton("7");
		 button_3.setBounds(16, 427, 75, 29);
		 bestilling.add(button_3);
		 button_3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				nummerKnappTrykk("7");
			 }
		 });
		
		 button_6 = new JButton("8");
		 button_6.setBounds(95, 427, 75, 29);
		 bestilling.add(button_6);
		 button_6.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		nummerKnappTrykk("8");
		 	}
		 });
		
		 btnNewButton_1 = new JButton("9");
		 btnNewButton_1.setBounds(178, 427, 80, 29);
		 bestilling.add(btnNewButton_1);
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		nummerKnappTrykk("9");
		 	}
		 });
		 
		 button_8 = new JButton("0");
		 button_8.setBounds(95, 460, 75, 29);
		 bestilling.add(button_8);
		 button_8.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 nummerKnappTrykk("0");
			 }
		 });
		 
		 btnDel = new JButton("del");
		 btnDel.setBounds(16, 460, 75, 29);
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
		 btnNeste.setBounds(694, 486, 80, 29);
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
		bestillingsInfo.setBackground(Color.PINK);
		tabbedPane.addTab("info", null, bestillingsInfo, null);
		bestillingsInfo.setLayout(null);
		
		navn = new JTextField();
		navn.setBounds(16, 30, 278, 28);
		navn.setText("Navn");
		bestillingsInfo.add(navn);
		navn.setColumns(10);
		
		nummer = new JTextField();
		nummer.setFont(new Font("Verdana", Font.BOLD, 20));
		nummer.setBounds(635, 26, 134, 28);
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
		
		textField = new JTextField();
		textField.setBounds(216, 83, 34, 28);
		bestillingsInfo.add(textField);
		textField.setColumns(10);
		
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
		lblRingendeNummer.setBounds(635, 12, 134, 14);
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
		
		//--------------------------Utgaaende/chef-----------------------------------------
		
		 Utgaende = new JPanel();
		 Utgaende.setBackground(Color.BLACK);
		 tabbedPane.addTab("Utg\u00E5ende", null, Utgaende, null);
		 Utgaende.setLayout(null);
		 
		 list_2 = new JList(model);
		 list_2.setBounds(10, 11, 759, 533);
		 Utgaende.add(list_2);
		
		 //------------------------Rediger-------------------------------------------------
		 
		Rediger = new JPanel();
		Rediger.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Rediger", null, Rediger, null);
		Rediger.setLayout(null);
		
		redigerNavn = new JTextField();
		redigerNavn.setFont(new Font("Verdana", Font.PLAIN, 11));
		redigerNavn.setBackground(new Color(245, 245, 245));
		redigerNavn.setText("Fornavn");
		redigerNavn.setBounds(10, 89, 120, 20);
		Rediger.add(redigerNavn);
		redigerNavn.setColumns(10);
		
		redigerNummer = new JTextField();
		redigerNummer.setBackground(new Color(245, 245, 245));
		redigerNummer.setFont(new Font("Verdana", Font.BOLD, 18));
		redigerNummer.setText("Telefon nr");
		redigerNummer.setBounds(10, 30, 149, 34);
		Rediger.add(redigerNummer);
		redigerNummer.setColumns(10);
		
		redigerGatenavn = new JTextField();
		redigerGatenavn.setFont(new Font("Verdana", Font.PLAIN, 11));
		redigerGatenavn.setBackground(new Color(245, 245, 245));
		redigerGatenavn.setText("Gatenavn");
		redigerGatenavn.setBounds(10, 129, 187, 20);
		Rediger.add(redigerGatenavn);
		redigerGatenavn.setColumns(10);
		
		redigerHusnr = new JTextField();
		redigerHusnr.setFont(new Font("Verdana", Font.PLAIN, 11));
		redigerHusnr.setBackground(new Color(245, 245, 245));
		redigerHusnr.setText("Husnr");
		redigerHusnr.setBounds(207, 129, 53, 20);
		Rediger.add(redigerHusnr);
		redigerHusnr.setColumns(10);
		
		redigerPostnummer = new JTextField();
		redigerPostnummer.setFont(new Font("Verdana", Font.PLAIN, 11));
		redigerPostnummer.setBackground(new Color(245, 245, 245));
		redigerPostnummer.setText("Postnummer");
		redigerPostnummer.setBounds(10, 170, 86, 20);
		Rediger.add(redigerPostnummer);
		redigerPostnummer.setColumns(10);
		
		redigerPoststed = new JTextField();
		redigerPoststed.setFont(new Font("Verdana", Font.PLAIN, 11));
		redigerPoststed.setBackground(new Color(245, 245, 245));
		redigerPoststed.setText("Poststed");
		redigerPoststed.setBounds(111, 170, 149, 20);
		Rediger.add(redigerPoststed);
		redigerPoststed.setColumns(10);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(321, 90, 279, 20);
		Rediger.add(comboBox);
		
		lblRegistrerteAdresser = new JLabel("Registrerte adresser til " + redigerNummer.getText());
		lblRegistrerteAdresser.setBounds(321, 69, 279, 14);
		Rediger.add(lblRegistrerteAdresser);
		
		 btnRediger = new JButton("Rediger");
		btnRediger.setBounds(108, 216, 89, 23);
		Rediger.add(btnRediger);
		
		 btnHentNr = new JButton("Hent Nr");
		btnHentNr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				redigerNavn.setText(logic.User.retrieve(0).getName());
//				redigerGatenavn.setText(logic.User.retrieve(0).getAddress().getStreet());
//				redigerHusnr.setText(logic.User.retrieve(0).getAddress().getHouseNumber());
//				redigerPostnummer.setText(logic.User.retrieve(0).getAddress().getZipcode());
//				redigerPoststed.setText(logic.User.retrieve(0).getAddress().getCity());
//				
				frame.repaint();
			}
		});
		btnHentNr.setBounds(171, 39, 89, 23);
		Rediger.add(btnHentNr);
		
		//INCALL; SL�R OPP I DATABASEN OG HENTER INFO OM MULIG
		 btnIncall = new JButton("Incall");
		btnIncall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				People p = new People();
				String nr = JOptionPane.showInputDialog(null, "Skriv inn incall number");
				nummer.setText(nr);
				try{
					TemporaryUser user = p.user(nr);						
					navn.setText(user.getName());
					gatenavn.setText(user.getAddress().getStreet() + " " + user.getAddress().getHouseNumber());
					//legger til houseletter hvis det finnes
					if(user.getAddress().getHouseLetter() != null){
						gatenavn.setText(gatenavn.getText() + user.getAddress().getHouseLetter());
					}
					postnummer.setText(user.getAddress().getZipcode());
					poststed.setText(user.getAddress().getCity());
					kommentar.setText(user.getKommentar());
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
		btnIncall.setBounds(680, 11, 89, 23);
		bestilling.add(btnIncall);
		
		
		
		
		 btnLeggTil = new JButton("Legg til");
		btnLeggTil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.User.create(navn.getText(), redigerNummer.getText(), new Address(redigerGatenavn.getText(), redigerHusnr.getText(), redigerPostnummer.getText(), redigerPoststed.getText()));
				redigerNavn.setText("Navn");
				redigerNummer.setText("Telefon nr");
				redigerGatenavn.setText("Gatenavn");
				redigerHusnr.setText("Hus nr");
				redigerPostnummer.setText("Postnummer");
				redigerPoststed.setText("Poststed");
				frame.repaint();
			}
		});
		btnLeggTil.setBounds(10, 216, 89, 23);
		Rediger.add(btnLeggTil);
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