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
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Starter {

	private JFrame frame;
	private JTextField txtNummer;
	private JTextField txtNavn;
	private JTextField txtAdresse;
	private JTextField txtPostnr;
	private JTextField txtSted;
	private JTextField txtKommentar;

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
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(306, 45, 340, 408);
		editorPane.setMinimumSize(new Dimension(340, 300));
		bestilling.add(editorPane);
		
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
		btnNeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread{
					public void run(){
						Info.main(new String[]{});
						
					}
				}.start();
			}
		});
		btnNeste.setBounds(694, 486, 80, 29);
		bestilling.add(btnNeste);
		
		JPanel bestillingsInfo = new JPanel();
		bestillingsInfo.setPreferredSize(new Dimension(500, 550));
		bestillingsInfo.setBackground(Color.PINK);
		tabbedPane.addTab("info", null, bestillingsInfo, null);
		bestillingsInfo.setLayout(new MigLayout("", "[134px][134px][134px][134px][][][][][][][]", "[28px][28px][28px][28px][28px][28px][28px][][][][][][][][][][][]"));
		
		txtNavn = new JTextField();
		txtNavn.setText("Navn");
		bestillingsInfo.add(txtNavn, "cell 0 0,alignx left,aligny top");
		txtNavn.setColumns(10);
		
		txtNummer = new JTextField();
		txtNummer.setText("Nummer");
		bestillingsInfo.add(txtNummer, "cell 1 0,alignx left,aligny top");
		txtNummer.setColumns(10);
		
		txtAdresse = new JTextField();
		txtAdresse.setText("Adresse");
		bestillingsInfo.add(txtAdresse, "cell 0 1,alignx left,aligny top");
		txtAdresse.setColumns(10);
		
		txtPostnr = new JTextField();
		txtPostnr.setText("Postnr.");
		bestillingsInfo.add(txtPostnr, "cell 0 2,alignx left,aligny top");
		txtPostnr.setColumns(10);
		
		txtSted = new JTextField();
		txtSted.setText("Sted");
		bestillingsInfo.add(txtSted, "cell 1 2,alignx left,aligny top");
		txtSted.setColumns(10);
		
		txtKommentar = new JTextField();
		txtKommentar.setText("Kommentar");
		bestillingsInfo.add(txtKommentar, "cell 0 3,alignx left");
		txtKommentar.setColumns(10);
		
		JCheckBox chckbxLevering = new JCheckBox("Levering");
		bestillingsInfo.add(chckbxLevering, "cell 0 4");
		
		JRadioButton rdbtnKort = new JRadioButton("Kort");
		bestillingsInfo.add(rdbtnKort, "flowx,cell 1 4");
		
		JRadioButton rdbtnKontant = new JRadioButton("Kontant");
		bestillingsInfo.add(rdbtnKontant, "cell 1 4");
		
		JPanel Utgaende = new JPanel();
		Utgaende.setBackground(Color.RED);
		tabbedPane.addTab("Utg\u00E5ende", null, Utgaende, null);
		
		JPanel Rediger = new JPanel();
		Rediger.setBackground(Color.MAGENTA);
		tabbedPane.addTab("Rediger", null, Rediger, null);
	}
}
