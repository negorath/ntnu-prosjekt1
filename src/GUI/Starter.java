package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;

public class Starter {

	private JFrame frame;
	private JTextField txtNummer;
	private JTextField txtNavn;
	private JTextField txtAdresse;
	private JTextField txtPostnr;
	private JTextField txtSted;
	private JTextField txtKommentar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new SwingAction();
	private JTextField txtNavn_1;
	private JTextField txtEtternavn;
	private JTextField txtTelefonNr;
	private JTextField txtGatenavn;
	private JTextField txtHusnr;
	private JTextField txtPostnummer;
	private JTextField txtPoststed;
	JLabel lblRegistrerteAdresser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Starter window = new Starter();
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
	public Starter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
		
		JPanel bestilling = new JPanel();
		tabbedPane.addTab("Ny Bestilling", null, bestilling, null);
		bestilling.setLayout(null);
		
		JToggleButton toggleButton = new JToggleButton("1");
		toggleButton.setBounds(16, 45, 75, 29);
		bestilling.add(toggleButton);
		
		JToggleButton toggleButton_1 = new JToggleButton("2");
		toggleButton_1.setBounds(95, 45, 75, 29);
		bestilling.add(toggleButton_1);
		
		JToggleButton toggleButton_2 = new JToggleButton("3");
		toggleButton_2.setBounds(178, 45, 75, 29);
		bestilling.add(toggleButton_2);
		
		JToggleButton toggleButton_3 = new JToggleButton("4");
		toggleButton_3.setBounds(16, 78, 75, 29);
		bestilling.add(toggleButton_3);
		
		JToggleButton toggleButton_4 = new JToggleButton("5");
		toggleButton_4.setBounds(95, 78, 75, 29);
		bestilling.add(toggleButton_4);
		
		JToggleButton toggleButton_5 = new JToggleButton("6");
		toggleButton_5.setBounds(178, 78, 75, 29);
		bestilling.add(toggleButton_5);
		
		JPanel reciept = new JPanel();
		reciept.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Kvittering", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		reciept.setBounds(300, 23, 352, 436);
		bestilling.add(reciept);
		reciept.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 22, 340, 408);
		reciept.add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		editorPane.setMinimumSize(new Dimension(340, 300));
		
		JToggleButton toggleButton_6 = new JToggleButton("7");
		toggleButton_6.setBounds(16, 111, 75, 29);
		bestilling.add(toggleButton_6);
		
		JToggleButton toggleButton_7 = new JToggleButton("8");
		toggleButton_7.setBounds(95, 111, 75, 29);
		bestilling.add(toggleButton_7);
		
		JToggleButton toggleButton_8 = new JToggleButton("9");
		toggleButton_8.setBounds(178, 111, 75, 29);
		bestilling.add(toggleButton_8);
		
		JToggleButton tglbtnCola = new JToggleButton("Cola");
		tglbtnCola.setBounds(16, 213, 75, 29);
		bestilling.add(tglbtnCola);
		
		JToggleButton tglbtnFanta = new JToggleButton("Fanta");
		tglbtnFanta.setBounds(95, 213, 78, 29);
		bestilling.add(tglbtnFanta);
		
		JToggleButton tglbtnSprite = new JToggleButton("Sprite");
		tglbtnSprite.setBounds(178, 213, 80, 29);
		bestilling.add(tglbtnSprite);
		
		JToggleButton tglbtnUrge = new JToggleButton("Urge");
		tglbtnUrge.setBounds(16, 246, 75, 29);
		bestilling.add(tglbtnUrge);
		
		JToggleButton tglbtnFarris = new JToggleButton("Farris");
		tglbtnFarris.setBounds(95, 246, 79, 29);
		bestilling.add(tglbtnFarris);
		
		JToggleButton tglbtnLol = new JToggleButton("lol");
		tglbtnLol.setBounds(178, 246, 80, 29);
		bestilling.add(tglbtnLol);
		
		JButton btnNeste = new JButton("Neste");
		btnNeste.setBounds(694, 486, 80, 29);
		bestilling.add(btnNeste);
		
		JButton button = new JButton("1");
		button.setBounds(16, 361, 75, 29);
		bestilling.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.setBounds(95, 361, 75, 29);
		bestilling.add(button_1);
		
		JButton btnNewButton = new JButton("3");
		btnNewButton.setActionCommand("2");
		btnNewButton.setBounds(177, 361, 80, 29);
		bestilling.add(btnNewButton);
		
		JButton button_2 = new JButton("4");
		button_2.setBounds(16, 394, 75, 29);
		bestilling.add(button_2);
		
		JButton button_3 = new JButton("7");
		button_3.setBounds(16, 427, 75, 29);
		bestilling.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setBounds(95, 394, 75, 29);
		bestilling.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setBounds(178, 394, 80, 29);
		bestilling.add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.setBounds(95, 427, 75, 29);
		bestilling.add(button_6);
		
		JButton btnNewButton_1 = new JButton("9");
		btnNewButton_1.setBounds(178, 427, 80, 29);
		bestilling.add(btnNewButton_1);
		
		JButton button_7 = new JButton("0");
		button_7.setBounds(95, 460, 75, 29);
		bestilling.add(button_7);
		
		JPanel bestillingsInfo = new JPanel();
		bestillingsInfo.setPreferredSize(new Dimension(500, 550));
		bestillingsInfo.setBackground(Color.PINK);
		tabbedPane.addTab("info", null, bestillingsInfo, null);
		bestillingsInfo.setLayout(null);
		
		txtNavn = new JTextField();
		txtNavn.setBounds(16, 16, 133, 28);
		txtNavn.setText("Navn");
		bestillingsInfo.add(txtNavn);
		txtNavn.setColumns(10);
		
		txtNummer = new JTextField();
		txtNummer.setFont(new Font("Verdana", Font.BOLD, 20));
		txtNummer.setBounds(639, 16, 134, 28);
		txtNummer.setText("Nummer");
		bestillingsInfo.add(txtNummer);
		txtNummer.setColumns(10);
		
		txtAdresse = new JTextField();
		txtAdresse.setBounds(16, 48, 133, 28);
		txtAdresse.setText("Adresse");
		bestillingsInfo.add(txtAdresse);
		txtAdresse.setColumns(10);
		
		txtPostnr = new JTextField();
		txtPostnr.setBounds(16, 80, 133, 28);
		txtPostnr.setText("Postnr.");
		bestillingsInfo.add(txtPostnr);
		txtPostnr.setColumns(10);
		
		txtSted = new JTextField();
		txtSted.setBounds(153, 80, 134, 28);
		txtSted.setText("Sted");
		bestillingsInfo.add(txtSted);
		txtSted.setColumns(10);
		
		txtKommentar = new JTextField();
		txtKommentar.setBounds(16, 112, 133, 28);
		txtKommentar.setText("Kommentar");
		bestillingsInfo.add(txtKommentar);
		txtKommentar.setColumns(10);
		
		JCheckBox chckbxLevering = new JCheckBox("Levering");
		chckbxLevering.setBounds(16, 146, 85, 23);
		bestillingsInfo.add(chckbxLevering);
		
		JRadioButton rdbtnKort = new JRadioButton("Kort");
		buttonGroup.add(rdbtnKort);
		rdbtnKort.setBounds(153, 146, 58, 23);
		bestillingsInfo.add(rdbtnKort);
		
		JRadioButton rdbtnKontant = new JRadioButton("Kontant");
		buttonGroup.add(rdbtnKontant);
		rdbtnKontant.setBounds(215, 146, 81, 23);
		bestillingsInfo.add(rdbtnKontant);
		
		JPanel Utgaende = new JPanel();
		Utgaende.setBackground(Color.RED);
		tabbedPane.addTab("Utg\u00E5ende", null, Utgaende, null);
		
		JPanel Rediger = new JPanel();
		Rediger.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Rediger", null, Rediger, null);
		Rediger.setLayout(null);
		
		txtNavn_1 = new JTextField();
		txtNavn_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNavn_1.setBackground(new Color(245, 245, 245));
		txtNavn_1.setText("Fornavn");
		txtNavn_1.setBounds(10, 89, 120, 20);
		Rediger.add(txtNavn_1);
		txtNavn_1.setColumns(10);
		
		txtEtternavn = new JTextField();
		txtEtternavn.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtEtternavn.setBackground(new Color(245, 245, 245));
		txtEtternavn.setText("Etternavn");
		txtEtternavn.setBounds(140, 89, 120, 20);
		Rediger.add(txtEtternavn);
		txtEtternavn.setColumns(10);
		
		txtTelefonNr = new JTextField();
		txtTelefonNr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblRegistrerteAdresser.setText("Registrerte adresser til " + txtTelefonNr.getText());
				frame.repaint();
			}
		});
		txtTelefonNr.setBackground(new Color(245, 245, 245));
		txtTelefonNr.setFont(new Font("Verdana", Font.BOLD, 18));
		txtTelefonNr.setText("Telefon nr");
		txtTelefonNr.setBounds(10, 30, 149, 34);
		Rediger.add(txtTelefonNr);
		txtTelefonNr.setColumns(10);
		
		txtGatenavn = new JTextField();
		txtGatenavn.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtGatenavn.setBackground(new Color(245, 245, 245));
		txtGatenavn.setText("Gatenavn");
		txtGatenavn.setBounds(10, 129, 187, 20);
		Rediger.add(txtGatenavn);
		txtGatenavn.setColumns(10);
		
		txtHusnr = new JTextField();
		txtHusnr.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtHusnr.setBackground(new Color(245, 245, 245));
		txtHusnr.setText("Husnr");
		txtHusnr.setBounds(207, 129, 53, 20);
		Rediger.add(txtHusnr);
		txtHusnr.setColumns(10);
		
		txtPostnummer = new JTextField();
		txtPostnummer.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtPostnummer.setBackground(new Color(245, 245, 245));
		txtPostnummer.setText("Postnummer");
		txtPostnummer.setBounds(10, 170, 86, 20);
		Rediger.add(txtPostnummer);
		txtPostnummer.setColumns(10);
		
		txtPoststed = new JTextField();
		txtPoststed.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtPoststed.setBackground(new Color(245, 245, 245));
		txtPoststed.setText("Poststed");
		txtPoststed.setBounds(111, 170, 149, 20);
		Rediger.add(txtPoststed);
		txtPoststed.setColumns(10);
		
		JButton btnLeggTil = new JButton("Legg til");
		btnLeggTil.setBounds(7, 216, 89, 23);
		Rediger.add(btnLeggTil);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(321, 90, 279, 20);
		Rediger.add(comboBox);
		
		lblRegistrerteAdresser = new JLabel("Registrerte adresser til " + txtTelefonNr.getText());
		lblRegistrerteAdresser.setBounds(321, 69, 279, 14);
		Rediger.add(lblRegistrerteAdresser);
		
		JButton btnRediger = new JButton("Rediger");
		btnRediger.setBounds(108, 216, 89, 23);
		Rediger.add(btnRediger);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
