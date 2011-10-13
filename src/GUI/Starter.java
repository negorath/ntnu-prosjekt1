//package GUI;
//
//import java.awt.EventQueue;
//
//public class Starter {
//
//	private JFrame frame;
//	private JTextField nummer, navn, gatenavn, postnummer, poststed, kommentar, redigerNavn, redigerNummer, redigerGatenavn;
//	private JTextField redigerHusnr, redigerPostnummer, redigerPoststed;
//	private final ButtonGroup buttonGroup = new ButtonGroup();
//	private JLabel lblRegistrerteAdresser, label;
//	private JPanel bestilling, reciept, panel, bestillingsInfo, Rediger;
//	private JComboBox comboBox;
//	private JTabbedPane tabbedPane, outgoing;
//	private int count = 1;
//	private JRadioButton rdbtnKort, rdbtnKontant;
//	private JButton toggleButton, toggleButton_1, toggleButton_2, toggleButton_3, toggleButton_4, toggleButton_5, toggleButton_6, toggleButton_7;
//	private JButton toggleButton_8, tglbtnCola, tglbtnFanta, tglbtnUrge, tglbtnSprite, tglbtnFarris, tglbtnLol;
//	private StringBuilder pizzaStreng = new StringBuilder();
//	private JButton button, button_1, button_2, button_3, button_4, button_5, button_6, btnNewButton_1, btnNewButton, btnNeste;
//	private JButton btnRediger, btnHentNr, btnLeggTil, btnIncall;
//	private JCheckBox chckbxLevering; 
////	private logic.Product product;
////	private logic.Address adress;
////	private logic.User user;
//	
//	private ArrayList<Integer> kvittering = new ArrayList<Integer>();
//	JList list;
//	DefaultListModel model = new DefaultListModel();
//	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Starter window = new Starter();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public Starter() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 800, 621);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
//		
//		bestilling = new JPanel();
//		tabbedPane.addTab("Ny Bestilling", null, bestilling, null);
//		bestilling.setLayout(null);
//		
//		toggleButton = new JButton("Nr.1");
//		toggleButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				model.addElement(count + " x Pizza Margarita");
//				list = new JList(model);
//		 		kvittering.add(Product.retrieve(1).getId()); 			
//		 		count = 1;
//			}
//		});
//		toggleButton.setBounds(16, 45, 75, 29);
//		bestilling.add(toggleButton);
//		
//		 toggleButton_1 = new JButton("Nr.2");
//		toggleButton_1.setBounds(95, 45, 75, 29);
//		bestilling.add(toggleButton_1);
//		
//		 toggleButton_2 = new JButton("Nr.3");
//		toggleButton_2.setBounds(178, 45, 75, 29);
//		bestilling.add(toggleButton_2);
//		
//		 toggleButton_3 = new JButton("Nr.4");
//		toggleButton_3.setBounds(16, 78, 75, 29);
//		bestilling.add(toggleButton_3);
//		
//		 toggleButton_4 = new JButton("Nr.5");
//		toggleButton_4.setBounds(95, 78, 75, 29);
//		bestilling.add(toggleButton_4);
//		
//		 toggleButton_5 = new JButton("Nr.6");
//		toggleButton_5.setBounds(178, 78, 75, 29);
//		bestilling.add(toggleButton_5);
//		
//		 reciept = new JPanel();
//		reciept.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Kvittering", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
//		reciept.setBounds(300, 23, 352, 436);
//		bestilling.add(reciept);
//		reciept.setLayout(null);
//		
//		JButton btnFjernAlt = new JButton("Fjern Alt");
//		btnFjernAlt.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				kvittering.clear();
//				count = 1;
//				model.removeAllElements();
//				list = new JList(model);
//			}
//		});
//		btnFjernAlt.setBounds(253, 0, 89, 23);
//		reciept.add(btnFjernAlt);
//		
//		 list = new JList(model);		 
////		 list.addMouseListener(new MouseAdapter() {
////		 	@Override
////		 	public void mouseClicked(MouseEvent e) {
////		 		String s = String.valueOf(list.getSelectedValue());
////		 		model.removeElement(s);
////		 		list = new JList(model);
////		 	}
////		 });
//		list.setBounds(10, 21, 332, 404);
//		reciept.add(list);
//		
//		 toggleButton_6 = new JButton("Nr.7");
//		toggleButton_6.setBounds(16, 111, 75, 29);
//		bestilling.add(toggleButton_6);
//		
//		 toggleButton_7 = new JButton("Nr.8");
//		toggleButton_7.setBounds(95, 111, 75, 29);
//		bestilling.add(toggleButton_7);
//		
//		 toggleButton_8 = new JButton("Nr.9");
//		toggleButton_8.setBounds(178, 111, 75, 29);
//		bestilling.add(toggleButton_8);
//		
//		 tglbtnCola = new JButton("Cola");
//		tglbtnCola.setBounds(16, 213, 75, 29);
//		bestilling.add(tglbtnCola);
//		
//		 tglbtnFanta = new JButton("Fanta");
//		tglbtnFanta.setBounds(95, 213, 78, 29);
//		bestilling.add(tglbtnFanta);
//		
//		 tglbtnSprite = new JButton("Sprite");
//		tglbtnSprite.setBounds(178, 213, 80, 29);
//		bestilling.add(tglbtnSprite);
//		
//		 tglbtnUrge = new JButton("Urge");
//		tglbtnUrge.setBounds(16, 246, 75, 29);
//		bestilling.add(tglbtnUrge);
//		
//		 tglbtnFarris = new JButton("Farris");
//		tglbtnFarris.setBounds(95, 246, 79, 29);
//		bestilling.add(tglbtnFarris);
//		
//		 tglbtnLol = new JButton("Vann");
//		tglbtnLol.setBounds(178, 246, 80, 29);
//		bestilling.add(tglbtnLol);
//		
//		 btnNeste = new JButton("Neste");
//		btnNeste.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				tabbedPane.setSelectedComponent(bestillingsInfo);
//				int[] temp = new int[kvittering.size()];
//				for(int i = 0; i<kvittering.size(); i++){
//					temp[i] = kvittering.get(i);
//				}
//				Product.retrieve(temp);
//				frame.repaint();
//			}
//			
//		});
//		btnNeste.setBounds(694, 486, 80, 29);
//		bestilling.add(btnNeste);
//		
//		 button = new JButton("1");
//		 button.addActionListener(new ActionListener() {
//		 	public void actionPerformed(ActionEvent e) {
//		 		count = 1;
//		 		label.setText("Antall x " + count);
//		 	}
//		 });
//		button.setBounds(16, 361, 75, 29);
//		bestilling.add(button);
//		
//		 button_1 = new JButton("2");
//		 button_1.addActionListener(new ActionListener() {
//		 	public void actionPerformed(ActionEvent e) {
//		 		count = 2;
//		 		label.setText("Antall x " + count);
//		 	}
//		 });
//		button_1.setBounds(95, 361, 75, 29);
//		bestilling.add(button_1);
//		
//		 btnNewButton = new JButton("3");
//		 btnNewButton.addActionListener(new ActionListener() {
//		 	public void actionPerformed(ActionEvent e) {
//		 		count = 3;
//		 		label.setText("Antall x " + count);
//		 	}
//		 });
//		btnNewButton.setActionCommand("2");
//		btnNewButton.setBounds(177, 361, 80, 29);
//		bestilling.add(btnNewButton);
//		
//		 button_2 = new JButton("4");
//		 button_2.addActionListener(new ActionListener() {
//		 	public void actionPerformed(ActionEvent e) {
//		 		count = 4;
//		 		label.setText("Antall x " + count);
//		 	}
//		 });
//		button_2.setBounds(16, 394, 75, 29);
//		bestilling.add(button_2);
//		
//		 button_3 = new JButton("7");
//		 button_3.addActionListener(new ActionListener() {
//		 	public void actionPerformed(ActionEvent e) {
//		 		count = 7;
//		 		label.setText("Antall x " + count);
//		 	}
//		 });
//		button_3.setBounds(16, 427, 75, 29);
//		bestilling.add(button_3);
//		
//		 button_4 = new JButton("5");
//		button_4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				count = 5;
//				label.setText("Antall x " + count);
//			}
//		});
//		button_4.setBounds(95, 394, 75, 29);
//		bestilling.add(button_4);
//		
//		 button_5 = new JButton("6");
//		 button_5.addActionListener(new ActionListener() {
//		 	public void actionPerformed(ActionEvent e) {
//		 		count = 6;
//		 		label.setText("Antall x " + count);
//		 	}
//		 });
//		button_5.setBounds(178, 394, 80, 29);
//		bestilling.add(button_5);
//		
//		 button_6 = new JButton("8");
//		 button_6.addActionListener(new ActionListener() {
//		 	public void actionPerformed(ActionEvent e) {
//		 		count = 8;
//		 		label.setText("Antall x " + count);
//		 	}
//		 });
//		button_6.setBounds(95, 427, 75, 29);
//		bestilling.add(button_6);
//		
//		 btnNewButton_1 = new JButton("9");
//		 btnNewButton_1.addActionListener(new ActionListener() {
//		 	public void actionPerformed(ActionEvent e) {
//		 		count = 9;
//		 		label.setText("Antall x " + count);
//		 	}
//		 });
//		btnNewButton_1.setBounds(178, 427, 80, 29);
//		bestilling.add(btnNewButton_1);
//		
//		 bestillingsInfo = new JPanel();
//		bestillingsInfo.setPreferredSize(new Dimension(500, 550));
//		bestillingsInfo.setBackground(Color.PINK);
//		tabbedPane.addTab("info", null, bestillingsInfo, null);
//		bestillingsInfo.setLayout(null);
//		
//		navn = new JTextField();
//		navn.setBounds(16, 16, 133, 28);
//		navn.setText("Navn");
//		bestillingsInfo.add(navn);
//		navn.setColumns(10);
//		
//		nummer = new JTextField();
//		nummer.setFont(new Font("Verdana", Font.BOLD, 20));
//		nummer.setBounds(639, 16, 134, 28);
//		nummer.setText("Nummer");
//		bestillingsInfo.add(nummer);
//		nummer.setColumns(10);
//		
//		gatenavn = new JTextField();
//		gatenavn.setBounds(16, 48, 133, 28);
//		gatenavn.setText("Adresse");
//		bestillingsInfo.add(gatenavn);
//		gatenavn.setColumns(10);
//		
//		postnummer = new JTextField();
//		postnummer.setBounds(16, 80, 133, 28);
//		postnummer.setText("Postnr.");
//		bestillingsInfo.add(postnummer);
//		postnummer.setColumns(10);
//		
//		poststed = new JTextField();
//		poststed.setBounds(153, 80, 134, 28);
//		poststed.setText("Sted");
//		bestillingsInfo.add(poststed);
//		poststed.setColumns(10);
//		
//		kommentar = new JTextField();
//		kommentar.setBounds(16, 112, 133, 28);
//		kommentar.setText("Kommentar");
//		bestillingsInfo.add(kommentar);
//		kommentar.setColumns(10);
//		
//		 chckbxLevering = new JCheckBox("Levering");
//		chckbxLevering.setBounds(16, 146, 85, 23);
//		bestillingsInfo.add(chckbxLevering);
//		
//		 rdbtnKort = new JRadioButton("Kort");
//		buttonGroup.add(rdbtnKort);
//		rdbtnKort.setBounds(153, 146, 58, 23);
//		bestillingsInfo.add(rdbtnKort);
//		
//		 rdbtnKontant = new JRadioButton("Kontant");
//		buttonGroup.add(rdbtnKontant);
//		rdbtnKontant.setBounds(215, 146, 81, 23);
//		bestillingsInfo.add(rdbtnKontant);
//		
//		 outgoing = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.addTab("Utgående", null, outgoing, null);
//		
//		 Rediger = new JPanel();
//		Rediger.setBackground(new Color(230, 230, 250));
//		tabbedPane.addTab("Rediger", null, Rediger, null);
//		Rediger.setLayout(null);
//		
//		redigerNavn = new JTextField();
//		redigerNavn.setFont(new Font("Verdana", Font.PLAIN, 11));
//		redigerNavn.setBackground(new Color(245, 245, 245));
//		redigerNavn.setText("Fornavn");
//		redigerNavn.setBounds(10, 89, 120, 20);
//		Rediger.add(redigerNavn);
//		redigerNavn.setColumns(10);
//		
//		redigerNummer = new JTextField();
//		redigerNummer.setBackground(new Color(245, 245, 245));
//		redigerNummer.setFont(new Font("Verdana", Font.BOLD, 18));
//		redigerNummer.setText("Telefon nr");
//		redigerNummer.setBounds(10, 30, 149, 34);
//		Rediger.add(redigerNummer);
//		redigerNummer.setColumns(10);
//		
//		redigerGatenavn = new JTextField();
//		redigerGatenavn.setFont(new Font("Verdana", Font.PLAIN, 11));
//		redigerGatenavn.setBackground(new Color(245, 245, 245));
//		redigerGatenavn.setText("Gatenavn");
//		redigerGatenavn.setBounds(10, 129, 187, 20);
//		Rediger.add(redigerGatenavn);
//		redigerGatenavn.setColumns(10);
//		
//		redigerHusnr = new JTextField();
//		redigerHusnr.setFont(new Font("Verdana", Font.PLAIN, 11));
//		redigerHusnr.setBackground(new Color(245, 245, 245));
//		redigerHusnr.setText("Husnr");
//		redigerHusnr.setBounds(207, 129, 53, 20);
//		Rediger.add(redigerHusnr);
//		redigerHusnr.setColumns(10);
//		
//		redigerPostnummer = new JTextField();
//		redigerPostnummer.setFont(new Font("Verdana", Font.PLAIN, 11));
//		redigerPostnummer.setBackground(new Color(245, 245, 245));
//		redigerPostnummer.setText("Postnummer");
//		redigerPostnummer.setBounds(10, 170, 86, 20);
//		Rediger.add(redigerPostnummer);
//		redigerPostnummer.setColumns(10);
//		
//		redigerPoststed = new JTextField();
//		redigerPoststed.setFont(new Font("Verdana", Font.PLAIN, 11));
//		redigerPoststed.setBackground(new Color(245, 245, 245));
//		redigerPoststed.setText("Poststed");
//		redigerPoststed.setBounds(111, 170, 149, 20);
//		Rediger.add(redigerPoststed);
//		redigerPoststed.setColumns(10);
//		
//		 comboBox = new JComboBox();
//		comboBox.setBounds(321, 90, 279, 20);
//		Rediger.add(comboBox);
//		
//		lblRegistrerteAdresser = new JLabel("Registrerte adresser til " + redigerNummer.getText());
//		lblRegistrerteAdresser.setBounds(321, 69, 279, 14);
//		Rediger.add(lblRegistrerteAdresser);
//		
//		 btnRediger = new JButton("Rediger");
//		btnRediger.setBounds(108, 216, 89, 23);
//		Rediger.add(btnRediger);
//		
//		 btnHentNr = new JButton("Hent Nr");
//		btnHentNr.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				redigerNavn.setText(logic.User.retrieve(0).getName());
//				redigerGatenavn.setText(logic.User.retrieve(0).getAddress().getStreet());
//				redigerHusnr.setText(logic.User.retrieve(0).getAddress().getHouseNumber());
//				redigerPostnummer.setText(logic.User.retrieve(0).getAddress().getZipcode());
//				redigerPoststed.setText(logic.User.retrieve(0).getAddress().getCity());
//				
//				frame.repaint();
//			}
//		});
//		btnHentNr.setBounds(171, 39, 89, 23);
//		Rediger.add(btnHentNr);
//		
//		 btnIncall = new JButton("Incall");
//		btnIncall.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String nr = JOptionPane.showInputDialog(null, "Skriv inn incall number");
//				nummer.setText(nr);
//				//INFOTABBEN:
//				
//				
//				User costumer = User.retrieve(Integer.parseInt(nr));
//				//if customer == null. create new customer.
//				
//				
//				navn.setText(logic.User.retrieve(Integer.parseInt(nr)).getName());
//				gatenavn.setText(logic.User.retrieve(Integer.parseInt(nr)).getName());
//				postnummer.setText(logic.User.retrieve(Integer.parseInt(nr)).getName());
//				poststed.setText(logic.User.retrieve(Integer.parseInt(nr)).getName());
//				//REDIGERTABBEN:
//				redigerNummer.setText(nr);
//				redigerNavn.setText(logic.User.retrieve(Integer.parseInt(nr)).getName());
//				redigerGatenavn.setText(logic.User.retrieve(Integer.parseInt(nr)).getName());
//				redigerPostnummer.setText(logic.User.retrieve(Integer.parseInt(nr)).getName());
//				redigerPoststed.setText(logic.User.retrieve(Integer.parseInt(nr)).getName());
//
//				frame.repaint();
//			}
//		});
//		btnIncall.setBounds(680, 11, 89, 23);
//		bestilling.add(btnIncall);
//		
//		label = new JLabel("Antall x ");
//		label.setBounds(24, 337, 229, 14);
//		bestilling.add(label);
//		
//		 btnLeggTil = new JButton("Legg til");
//		btnLeggTil.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				logic.User.create(navn.getText(), redigerNummer.getText(), new Address(redigerGatenavn.getText(), redigerHusnr.getText(), redigerPostnummer.getText(), redigerPoststed.getText()));
//				redigerNavn.setText("Navn");
//				redigerNummer.setText("Telefon nr");
//				redigerGatenavn.setText("Gatenavn");
//				redigerHusnr.setText("Hus nr");
//				redigerPostnummer.setText("Postnummer");
//				redigerPoststed.setText("Poststed");
//				frame.repaint();
//			}
//		});
//		btnLeggTil.setBounds(10, 216, 89, 23);
//		Rediger.add(btnLeggTil);
//	}
//}