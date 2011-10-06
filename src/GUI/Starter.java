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

public class Starter {

	private JFrame frame;
	private JTextField txtNummer;
	private JTextField txtNavn;
	private JTextField txtAdresse;

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
		
		JPanel Bestilling = new JPanel();
		Bestilling.setPreferredSize(new Dimension(700, 440));
		Bestilling.setBackground(Color.PINK);
		tabbedPane.addTab("Ny Bestilling", null, Bestilling, null);
		FormLayout fl_Bestilling = new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("134px"),
				ColumnSpec.decode("134px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("134px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("134px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("28px"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,});
		Bestilling.setLayout(fl_Bestilling);
		
		txtNummer = new JTextField();
		txtNummer.setText("Nummer");
		Bestilling.add(txtNummer, "1, 2, left, top");
		txtNummer.setColumns(10);
		
		txtNavn = new JTextField();
		txtNavn.setText("Navn");
		Bestilling.add(txtNavn, "2, 2, left, top");
		txtNavn.setColumns(10);
		
		txtAdresse = new JTextField();
		txtAdresse.setText("Adresse");
		Bestilling.add(txtAdresse, "4, 2, left, top");
		txtAdresse.setColumns(10);
		
		JPanel Utgaende = new JPanel();
		Utgaende.setBackground(Color.RED);
		tabbedPane.addTab("Utg\u00E5ende", null, Utgaende, null);
		
		JPanel Rediger = new JPanel();
		Rediger.setBackground(Color.MAGENTA);
		tabbedPane.addTab("Rediger", null, Rediger, null);
	}
}
