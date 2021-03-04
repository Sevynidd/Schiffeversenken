package view.fenster;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.getter_setter.view.Getter_Setter_Spieler;
import controller.listener.Listener_Spieler;
import view.hilfe.Hilfe_Menu;

public class Spieler {

	public JFrame frame_spieler;

	private String[] buchstaben = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
	private int[] zahlen = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

																												// JTextFields
	private JTextField textField_A_bis_J[];
	private JTextField textField_0_bis_9[];
	
																												// JTextFields Namen Schiffe
	private JTextField txtSchlachtschiff;
	private JTextField txtKreuzer;
	private JTextField txtZerstrer;
	private JTextField txtUboot;

	
	public Spieler() {
		initialize();
	}

	
	private void initialize() {
																												// JFrame
		frame_spieler = new JFrame();
		frame_spieler.setTitle("Spieler");
		try {
			
			frame_spieler.setIconImage(ImageIO.read(getClass().getResourceAsStream("/ressources/icons/Spieler.png")));
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		frame_spieler.getContentPane().setBackground(Color.WHITE);
		frame_spieler.getContentPane().setLayout(null);
		frame_spieler.setBounds(100, 100, 800, 510);
		frame_spieler.setResizable(false);
		frame_spieler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menu_erstellen();
		felder_erstellen_A_bis_J();
		felder_erstellen_0_bis_9();
		button_erstellen_A0_bis_J9();
		erstellen_radioButtons();
		text_Anzahl_Schiffe();
		text_Schiffe();
		buttons_Auswahl_Schiffe();
		hinweis_textfeld();
		
	}

																												// JTextField A-J
	private void felder_erstellen_A_bis_J() {

		textField_A_bis_J = new JTextField[10];

		for (int i = 1; i <= 10; i++) {

			String buchstabe = buchstaben[i - 1];

			textField_A_bis_J[i - 1] = new JTextField();
			textField_A_bis_J[i - 1].setBounds(i * 40, 0, 40, 40);
			textField_A_bis_J[i - 1].setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField_A_bis_J[i - 1].setHorizontalAlignment(SwingConstants.CENTER);
			textField_A_bis_J[i - 1].setText(buchstabe);
			textField_A_bis_J[i - 1].setFocusable(false);
			textField_A_bis_J[i - 1].setBackground(new Color(222,222,222));
			textField_A_bis_J[i - 1].setEditable(false);

			frame_spieler.getContentPane().add(textField_A_bis_J[i - 1]);
			textField_A_bis_J[i - 1].setColumns(1);

		}

	}

																												// JTextField 0-9
	private void felder_erstellen_0_bis_9() {

		textField_0_bis_9 = new JTextField[10];

		for (int i = 1; i <= 10; i++) {

			String zahl = Integer.toString(i - 1);

			textField_0_bis_9[i - 1] = new JTextField();
			textField_0_bis_9[i - 1].setBounds(0, i * 40, 40, 40);
			textField_0_bis_9[i - 1].setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField_0_bis_9[i - 1].setHorizontalAlignment(SwingConstants.CENTER);
			textField_0_bis_9[i - 1].setText(zahl);
			textField_0_bis_9[i - 1].setBackground(new Color(222,222,222));
			textField_0_bis_9[i - 1].setEditable(false);
			textField_0_bis_9[i - 1].setFocusable(false);

			frame_spieler.getContentPane().add(textField_0_bis_9[i - 1]);
			textField_0_bis_9[i - 1].setColumns(1);

		}

	}

	private void buttons_Auswahl_Schiffe() {
			
																												// JRadioButton Schlachtschiff
		JRadioButton RadioButton_Schlachtschiff = new JRadioButton("");
		RadioButton_Schlachtschiff.setActionCommand("Schlachtschiff");
		RadioButton_Schlachtschiff.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_Schlachtschiff.setBounds(721, 150, 25, 25);
		frame_spieler.getContentPane().add(RadioButton_Schlachtschiff);
		
		Getter_Setter_Spieler.setRadioButton_Schiffe(RadioButton_Schlachtschiff, 0);
	
																												// JRadioButton Kreuzer
		JRadioButton RadioButton_Kreuzer = new JRadioButton("");
		RadioButton_Kreuzer.setActionCommand("Kreuzer");
		RadioButton_Kreuzer.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_Kreuzer.setBounds(721, 185, 25, 25);
		frame_spieler.getContentPane().add(RadioButton_Kreuzer);
		
		Getter_Setter_Spieler.setRadioButton_Schiffe(RadioButton_Kreuzer, 1);
		
																												// JRadioButton Zerstörer
		JRadioButton RadioButton_Zerstörer = new JRadioButton("");
		RadioButton_Zerstörer.setActionCommand("Zerst\u00F6rer");
		RadioButton_Zerstörer.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_Zerstörer.setBounds(721, 220, 25, 25);
		frame_spieler.getContentPane().add(RadioButton_Zerstörer);
		
		Getter_Setter_Spieler.setRadioButton_Schiffe(RadioButton_Zerstörer, 2);
		
																												// JRadioButton U-Boot
		JRadioButton RadioButton_UBoot = new JRadioButton("");
		RadioButton_UBoot.setActionCommand("UBoot");
		RadioButton_UBoot.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_UBoot.setBounds(721, 255, 25, 25);
		frame_spieler.getContentPane().add(RadioButton_UBoot);
		
		Getter_Setter_Spieler.setRadioButton_Schiffe(RadioButton_UBoot, 3);
	
		
		ButtonGroup gruppe_schiffe = new ButtonGroup();
		gruppe_schiffe.add(RadioButton_Schlachtschiff);
		gruppe_schiffe.add(RadioButton_Kreuzer);
		gruppe_schiffe.add(RadioButton_Zerstörer);
		gruppe_schiffe.add(RadioButton_UBoot);
		
		Getter_Setter_Spieler.setGruppe_schiffe(gruppe_schiffe);
		
		Getter_Setter_Spieler.getRadioButton_Schiffe()[0].setSelected(true);
	
	}


																							
	private void erstellen_radioButtons() {
	
																												// JRadioButton Horizontal
		JRadioButton RadioButton_Horizontal = new JRadioButton("Horizontal");
		RadioButton_Horizontal.setActionCommand("Horizontal");
		RadioButton_Horizontal.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_Horizontal.setBounds(525, 6, 90, 20);
		frame_spieler.getContentPane().add(RadioButton_Horizontal);
		
		Getter_Setter_Spieler.setRadioButton_Horizontal_Vertikal(RadioButton_Horizontal, 0);
	
																												// JRadioButton Vertikal
		JRadioButton RadioButton_Vertikal = new JRadioButton("Vertikal");
		RadioButton_Vertikal.setActionCommand("Vertikal");
		RadioButton_Vertikal.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_Vertikal.setBounds(625, 6, 90, 20);
		frame_spieler.getContentPane().add(RadioButton_Vertikal);
		
		Getter_Setter_Spieler.setRadioButton_Horizontal_Vertikal(RadioButton_Vertikal, 1);
	
		// Damit die RadioButtons automatisch abgewählt werden, wenn ein anderer gewählt ist
		
		ButtonGroup gruppe_hor_vert = new ButtonGroup();
		gruppe_hor_vert.add(RadioButton_Horizontal);
		gruppe_hor_vert.add(RadioButton_Vertikal);
		
		Getter_Setter_Spieler.setGruppe_hor_vert(gruppe_hor_vert);
	    
		RadioButton_Horizontal.setSelected(true);
		
	}


	private void button_erstellen_A0_bis_J9() {

		JButton[][] button_A0_bis_J9 = new JButton[10][10];

		// z = Zahlen
		for (int z = 1; z <= 10; z++) {
			// b = Buchstaben
			for (int b = 1; b <= 10; b++) {

				String koordinaten = buchstaben[b - 1] + zahlen[z - 1];
				button_A0_bis_J9[b - 1][z - 1] = new JButton(koordinaten);
				button_A0_bis_J9[b - 1][z - 1].setBounds(b * 40, z * 40, 40, 40);
				button_A0_bis_J9[b - 1][z - 1].setText("");
				button_A0_bis_J9[b - 1][z - 1].setFocusable(false);
				button_A0_bis_J9[b - 1][z - 1].setFont(new Font("Tahoma", Font.PLAIN, 16));
				button_A0_bis_J9[b - 1][z - 1].setBackground(new Color(222,222,222));
				button_A0_bis_J9[b - 1][z - 1].setActionCommand(Integer.toString(b-1) + " " + Integer.toString(z-1));
				frame_spieler.getContentPane().add(button_A0_bis_J9[b - 1][z - 1]);
				
				Getter_Setter_Spieler.setButton_A0_bis_J9(button_A0_bis_J9[b - 1][z - 1], b-1, z-1);
				
				Listener_Spieler.buttonListener_spieler(button_A0_bis_J9[b-1][z-1]);
				

			}
		}

	}

	private void text_Anzahl_Schiffe() {
		
		JTextField textField_Anzahl_Schlachtschiff;
		JTextField textField_Anzahl_Kreuzer;
		JTextField textField_Anzahl_Zerstörer;
		JTextField textField_Anzahl_UBoot;
		
																													// JTextField Schlachtschiff
		textField_Anzahl_Schlachtschiff = new JTextField();
		textField_Anzahl_Schlachtschiff.setEditable(false);
		textField_Anzahl_Schlachtschiff.setFocusable(false);
		textField_Anzahl_Schlachtschiff.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Anzahl_Schlachtschiff.setText("1");
		textField_Anzahl_Schlachtschiff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Anzahl_Schlachtschiff.setBounds(525, 150, 50, 25);
	    frame_spieler.getContentPane().add(textField_Anzahl_Schlachtschiff);
	    
	    Getter_Setter_Spieler.setTextField_Anzahl_Schiffe(textField_Anzahl_Schlachtschiff, 0);
	    
	    																											// JTextField Kreuzer
	    textField_Anzahl_Kreuzer = new JTextField();
	    textField_Anzahl_Kreuzer.setEditable(false);
	    textField_Anzahl_Kreuzer.setFocusable(false);
	    textField_Anzahl_Kreuzer.setText("2");
	    textField_Anzahl_Kreuzer.setHorizontalAlignment(SwingConstants.CENTER);
	    textField_Anzahl_Kreuzer.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    textField_Anzahl_Kreuzer.setColumns(10);
	    textField_Anzahl_Kreuzer.setBounds(525, 185, 50, 25);
	    frame_spieler.getContentPane().add(textField_Anzahl_Kreuzer);
	    
	    Getter_Setter_Spieler.setTextField_Anzahl_Schiffe(textField_Anzahl_Kreuzer, 1);
	    
	    																											// JTextField Zerstörer
	    textField_Anzahl_Zerstörer = new JTextField();
	    textField_Anzahl_Zerstörer.setEditable(false);
	    textField_Anzahl_Zerstörer.setFocusable(false);
	    textField_Anzahl_Zerstörer.setText("3");
	    textField_Anzahl_Zerstörer.setHorizontalAlignment(SwingConstants.CENTER);
	    textField_Anzahl_Zerstörer.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    textField_Anzahl_Zerstörer.setColumns(10);
	    textField_Anzahl_Zerstörer.setBounds(525, 220, 50, 25);
	    frame_spieler.getContentPane().add(textField_Anzahl_Zerstörer);
	    
	    Getter_Setter_Spieler.setTextField_Anzahl_Schiffe(textField_Anzahl_Zerstörer, 2);
	    
	    																											// JTextField UBoot
	    textField_Anzahl_UBoot = new JTextField();
	    textField_Anzahl_UBoot.setEditable(false);
	    textField_Anzahl_UBoot.setFocusable(false);
	    textField_Anzahl_UBoot.setText("4");
	    textField_Anzahl_UBoot.setHorizontalAlignment(SwingConstants.CENTER);
	    textField_Anzahl_UBoot.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    textField_Anzahl_UBoot.setColumns(10);
	    textField_Anzahl_UBoot.setBounds(525, 255, 50, 25);
	    frame_spieler.getContentPane().add(textField_Anzahl_UBoot);
	    
	    Getter_Setter_Spieler.setTextField_Anzahl_Schiffe(textField_Anzahl_UBoot, 3);

	}
	
	private void text_Schiffe() {
		
																													// JTextField Schlachtschiff
		txtSchlachtschiff = new JTextField();
		txtSchlachtschiff.setEditable(false);
		txtSchlachtschiff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSchlachtschiff.setText("Schlachtschiff (5)");
		txtSchlachtschiff.setFocusable(false);
		txtSchlachtschiff.setHorizontalAlignment(SwingConstants.CENTER);
		txtSchlachtschiff.setBounds(585, 150, 130, 25);
		frame_spieler.getContentPane().add(txtSchlachtschiff);
		txtSchlachtschiff.setColumns(10);
																													// JTextField Kreuzer
		txtKreuzer = new JTextField();
		txtKreuzer.setEditable(false);
		txtKreuzer.setText("Kreuzer (4)");
		txtKreuzer.setFocusable(false);
		txtKreuzer.setHorizontalAlignment(SwingConstants.CENTER);
		txtKreuzer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtKreuzer.setColumns(10);
		txtKreuzer.setBounds(585, 185, 130, 25);
		frame_spieler.getContentPane().add(txtKreuzer);
																													// JTextField Zerstörer
		txtZerstrer = new JTextField();
		txtZerstrer.setEditable(false);
		txtZerstrer.setText("Zerst\u00F6rer (3)");
		txtZerstrer.setFocusable(false);
		txtZerstrer.setHorizontalAlignment(SwingConstants.CENTER);
		txtZerstrer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtZerstrer.setColumns(10);
		txtZerstrer.setBounds(585, 220, 130, 25);
		frame_spieler.getContentPane().add(txtZerstrer);
																													// JTextField UBoot
		txtUboot = new JTextField();
		txtUboot.setEditable(false);
		txtUboot.setText("U-Boot (2)");
		txtUboot.setFocusable(false);
		txtUboot.setHorizontalAlignment(SwingConstants.CENTER);
		txtUboot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUboot.setColumns(10);
		txtUboot.setBounds(585, 255, 130, 25);
		frame_spieler.getContentPane().add(txtUboot);

	}
	
	private void hinweis_textfeld() {
																													// JTextArea Hinweis
		JTextArea textArea_hinweis = new JTextArea();
		textArea_hinweis.setWrapStyleWord(true);
		textArea_hinweis.setLineWrap(true);
		textArea_hinweis.setBounds(474, 368, 300, 70);
		textArea_hinweis.setEditable(false);
		textArea_hinweis.setFocusable(false);
		textArea_hinweis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textArea_hinweis.setBackground(new Color(222,222,222));
		frame_spieler.getContentPane().add(textArea_hinweis);
		
		Getter_Setter_Spieler.setTextField_hinweis(textArea_hinweis);
		Getter_Setter_Spieler.getTextField_hinweis().setText("Hier werden Hinweise stehen wenn ein Fehler auftritt");
		
		
	}
	
	private void menu_erstellen() {
		
		JMenuBar mb = new JMenuBar();
		
		JMenu menu = new JMenu("Menu");
		
		@SuppressWarnings("serial")
		JMenuItem hilfe = new JMenuItem(new AbstractAction("Hilfe") {

			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				Hilfe_Menu hilfe = new Hilfe_Menu();
								
			}
	
		});
		
		
		menu.add(hilfe);
		mb.add(menu);
		
		frame_spieler.setJMenuBar(mb);
		
	}
}
