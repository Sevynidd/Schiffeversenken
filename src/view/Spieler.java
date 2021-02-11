package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Spieler {

	protected JFrame frame_spieler;

	private String[] buchstaben = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
	private int[] zahlen = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

																								// JTextFields
	private JTextField textField_A_bis_J[];
	private JTextField textField_0_bis_9[];
																								// JButtons
	protected JButton button_A0_bis_J9[][];
																								// JTextFields Anzahl Schiffe
	private JTextField textField_Anzahl_Schlachtschiff;
	private JTextField textField_Anzahl_Kreuzer;
	private JTextField textField_Anzahl_Zerstörer;
	private JTextField textField_Anzahl_UBoot;
																								//	JTextFields Namen Schiffe
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
		frame_spieler.getContentPane().setBackground(Color.WHITE);
		frame_spieler.getContentPane().setLayout(null);
		frame_spieler.setBounds(100, 100, 800, 500);
		frame_spieler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		felder_erstellen_A_bis_J();
		felder_erstellen_0_bis_9();
		button_erstellen_A0_bis_J9();
		erstellen_radioButtons();
		text_Anzahl_Schiffe();
		text_Schiffe();
		buttons_Auswahl_Schiffe();
		

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

			frame_spieler.getContentPane().add(textField_0_bis_9[i - 1]);
			textField_0_bis_9[i - 1].setColumns(1);

		}

	}

																								// JButtons A0-J9
	public void button_erstellen_A0_bis_J9() {

		button_A0_bis_J9 = new JButton[10][10];

		// z = Zahlen
		for (int z = 1; z <= 10; z++) {
			// b = Buchstaben
			for (int b = 1; b <= 10; b++) {

				String koordinaten = buchstaben[b - 1] + zahlen[z - 1];
				button_A0_bis_J9[b - 1][z - 1] = new JButton(koordinaten);
				button_A0_bis_J9[b - 1][z - 1].setBounds(b * 40, z * 40, 40, 40);
				button_A0_bis_J9[b - 1][z - 1].setText("");
				button_A0_bis_J9[b - 1][z - 1].setFont(new Font("Tahoma", Font.PLAIN, 16));
				button_A0_bis_J9[b - 1][z - 1].setBackground(new Color(222,222,222));
				frame_spieler.getContentPane().add(button_A0_bis_J9[b - 1][z - 1]);

			}
		}

	}

	public void erstellen_radioButtons() {

																								// JRadioButton Horizontal
		JRadioButton RadioButton_Horizontal = new JRadioButton("Horizontal");
		RadioButton_Horizontal.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_Horizontal.setBounds(525, 6, 90, 20);
		frame_spieler.getContentPane().add(RadioButton_Horizontal);

																								// JRadioButton Vertikal
		JRadioButton RadioButton_Vertikal = new JRadioButton("Vertikal");
		RadioButton_Vertikal.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_Vertikal.setBounds(625, 6, 90, 20);
		frame_spieler.getContentPane().add(RadioButton_Vertikal);

		// Damit die RadioButtons automatisch abgewählt werden, wenn ein anderer gewählt ist
		
		ButtonGroup gruppe_hor_vert = new ButtonGroup();
		gruppe_hor_vert.add(RadioButton_Horizontal);
		gruppe_hor_vert.add(RadioButton_Vertikal);
	    
	    
	}
	
	public void text_Anzahl_Schiffe() {
																								//JTextField Schlachtschiff
		textField_Anzahl_Schlachtschiff = new JTextField();
		textField_Anzahl_Schlachtschiff.setEditable(false);
		textField_Anzahl_Schlachtschiff.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Anzahl_Schlachtschiff.setText("1");
		textField_Anzahl_Schlachtschiff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Anzahl_Schlachtschiff.setBounds(525, 150, 50, 25);
	    frame_spieler.getContentPane().add(textField_Anzahl_Schlachtschiff);
	    textField_Anzahl_Schlachtschiff.setColumns(10);
	    																						//JTextField Kreuzer
	    textField_Anzahl_Kreuzer = new JTextField();
	    textField_Anzahl_Kreuzer.setEditable(false);
	    textField_Anzahl_Kreuzer.setText("2");
	    textField_Anzahl_Kreuzer.setHorizontalAlignment(SwingConstants.CENTER);
	    textField_Anzahl_Kreuzer.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    textField_Anzahl_Kreuzer.setColumns(10);
	    textField_Anzahl_Kreuzer.setBounds(525, 185, 50, 25);
	    frame_spieler.getContentPane().add(textField_Anzahl_Kreuzer);
	    																						//JTextField Zerstörer
	    textField_Anzahl_Zerstörer = new JTextField();
	    textField_Anzahl_Zerstörer.setEditable(false);
	    textField_Anzahl_Zerstörer.setText("3");
	    textField_Anzahl_Zerstörer.setHorizontalAlignment(SwingConstants.CENTER);
	    textField_Anzahl_Zerstörer.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    textField_Anzahl_Zerstörer.setColumns(10);
	    textField_Anzahl_Zerstörer.setBounds(525, 220, 50, 25);
	    frame_spieler.getContentPane().add(textField_Anzahl_Zerstörer);
	    																						//JTextField UBoot
	    textField_Anzahl_UBoot = new JTextField();
	    textField_Anzahl_UBoot.setEditable(false);
	    textField_Anzahl_UBoot.setText("4");
	    textField_Anzahl_UBoot.setHorizontalAlignment(SwingConstants.CENTER);
	    textField_Anzahl_UBoot.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    textField_Anzahl_UBoot.setColumns(10);
	    textField_Anzahl_UBoot.setBounds(525, 255, 50, 25);
	    frame_spieler.getContentPane().add(textField_Anzahl_UBoot);

	}
	
	private void text_Schiffe() {
		
																								//JTextField Schlachtschiff
		txtSchlachtschiff = new JTextField();
		txtSchlachtschiff.setEditable(false);
		txtSchlachtschiff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSchlachtschiff.setText("Schlachtschiff (5)");
		txtSchlachtschiff.setHorizontalAlignment(SwingConstants.CENTER);
		txtSchlachtschiff.setBounds(585, 150, 130, 25);
		frame_spieler.getContentPane().add(txtSchlachtschiff);
		txtSchlachtschiff.setColumns(10);
																								//JTextField Kreuzer
		txtKreuzer = new JTextField();
		txtKreuzer.setEditable(false);
		txtKreuzer.setText("Kreuzer (4)");
		txtKreuzer.setHorizontalAlignment(SwingConstants.CENTER);
		txtKreuzer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtKreuzer.setColumns(10);
		txtKreuzer.setBounds(585, 185, 130, 25);
		frame_spieler.getContentPane().add(txtKreuzer);
																								//JTextField Zerstörer
		txtZerstrer = new JTextField();
		txtZerstrer.setEditable(false);
		txtZerstrer.setText("Zerst\u00F6rer (3)");
		txtZerstrer.setHorizontalAlignment(SwingConstants.CENTER);
		txtZerstrer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtZerstrer.setColumns(10);
		txtZerstrer.setBounds(585, 220, 130, 25);
		frame_spieler.getContentPane().add(txtZerstrer);
																								//JTextField UBoot
		txtUboot = new JTextField();
		txtUboot.setEditable(false);
		txtUboot.setText("U-Boot (2)");
		txtUboot.setHorizontalAlignment(SwingConstants.CENTER);
		txtUboot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUboot.setColumns(10);
		txtUboot.setBounds(585, 255, 130, 25);
		frame_spieler.getContentPane().add(txtUboot);

	}
	
	public void buttons_Auswahl_Schiffe() {
																								//JRadioButton Schlachtschiff
		JRadioButton RadioButton_Schlachtschiff = new JRadioButton("");
		RadioButton_Schlachtschiff.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_Schlachtschiff.setBounds(721, 150, 25, 25);
		frame_spieler.getContentPane().add(RadioButton_Schlachtschiff);

																								//JRadioButton Kreuzer
		JRadioButton RadioButton_Kreuzer = new JRadioButton("");
		RadioButton_Kreuzer.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_Kreuzer.setBounds(721, 185, 25, 25);
		frame_spieler.getContentPane().add(RadioButton_Kreuzer);
		
																								//JRadioButton Zerstörer
		JRadioButton RadioButton_Zerstörer = new JRadioButton("");
		RadioButton_Zerstörer.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_Zerstörer.setBounds(721, 220, 25, 25);
		frame_spieler.getContentPane().add(RadioButton_Zerstörer);
		
																								//JRadioButton U-Boot
		JRadioButton RadioButton_UBoot = new JRadioButton("");
		RadioButton_UBoot.setHorizontalAlignment(SwingConstants.CENTER);
		RadioButton_UBoot.setBounds(721, 255, 25, 25);
		frame_spieler.getContentPane().add(RadioButton_UBoot);

		
		ButtonGroup gruppe_schiffe = new ButtonGroup();
		gruppe_schiffe.add(RadioButton_Schlachtschiff);
		gruppe_schiffe.add(RadioButton_Kreuzer);
		gruppe_schiffe.add(RadioButton_Zerstörer);
		gruppe_schiffe.add(RadioButton_UBoot);
	
	}
}
