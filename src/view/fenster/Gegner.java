package view.fenster;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.getter_setter.view.Getter_Setter_Gegner;
import controller.listener.Listener_Gegner;

public class Gegner {

	/*
	 * Die Gegner Seite mit den Feldern auf welche man selbst schießen kann, um
	 * Schiffe zu zerstören.
	 */

	public JFrame frame_gegner;

	private String[] buchstaben = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
	private int[] zahlen = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	// JTextFields
	private JTextField textField_A_bis_J[];
	private JTextField textField_0_bis_9[];

	// JButton

	public Gegner() {
		initialize();
	}

	private void initialize() {
		// JFrame
		frame_gegner = new JFrame();
		frame_gegner.setTitle("Gegner");
		try {

			frame_gegner.setIconImage(ImageIO.read(getClass().getResourceAsStream("/ressources/icons/Gegner.png")));

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		frame_gegner.getContentPane().setBackground(Color.WHITE);
		frame_gegner.getContentPane().setLayout(null);
		frame_gegner.setBounds(1000, 100, 500, 500);
		frame_gegner.setResizable(false);
		frame_gegner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Getter_Setter_Gegner.setSchuss_setzen_erlaubt(false);
		Getter_Setter_Gegner.setSpieler_suche_beendet(false);

		felder_erstellen_A_bis_J();
		felder_erstellen_0_bis_9();
		button_erstellen_A0_bis_J9();

	}

	private void felder_erstellen_A_bis_J() {

		// Die Textfelder A bis J erstellen

		textField_A_bis_J = new JTextField[11];

		for (int i = 1; i <= 10; i++) {

			String[] buchstaben = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };

			String buchstabe = buchstaben[i - 1];
			// JTextFields A bis J
			textField_A_bis_J[i - 1] = new JTextField();
			textField_A_bis_J[i - 1].setBounds(i * 40, 0, 40, 40);
			textField_A_bis_J[i - 1].setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField_A_bis_J[i - 1].setHorizontalAlignment(SwingConstants.CENTER);
			textField_A_bis_J[i - 1].setText(buchstabe);
			textField_A_bis_J[i - 1].setBackground(new Color(222, 222, 222));
			textField_A_bis_J[i - 1].setEditable(false);
			textField_A_bis_J[i - 1].setFocusable(false);

			frame_gegner.getContentPane().add(textField_A_bis_J[i - 1]);
			textField_A_bis_J[i - 1].setColumns(1);

		}

	}

	private void felder_erstellen_0_bis_9() {

		// Die Textfelder 0 bis 9 werden erstellt
		// JTextFields 0 bis 9
		textField_0_bis_9 = new JTextField[10];

		for (int i = 1; i <= 10; i++) {

			String zahl = Integer.toString(i - 1);

			textField_0_bis_9[i - 1] = new JTextField();
			textField_0_bis_9[i - 1].setBounds(0, i * 40, 40, 40);
			textField_0_bis_9[i - 1].setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField_0_bis_9[i - 1].setHorizontalAlignment(SwingConstants.CENTER);
			textField_0_bis_9[i - 1].setText(zahl);
			textField_0_bis_9[i - 1].setBackground(new Color(222, 222, 222));
			textField_0_bis_9[i - 1].setEditable(false);
			textField_0_bis_9[i - 1].setFocusable(false);

			frame_gegner.getContentPane().add(textField_0_bis_9[i - 1]);
			textField_0_bis_9[i - 1].setColumns(1);

		}

	}

	// JButtons A0 bis J9
	private void button_erstellen_A0_bis_J9() {

		// Alle 100 Buttons werden erstellt und im Getter/Setter gespeichert

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
				button_A0_bis_J9[b - 1][z - 1].setBackground(new Color(222, 222, 222));
				button_A0_bis_J9[b - 1][z - 1]
						.setActionCommand(Integer.toString(b - 1) + " " + Integer.toString(z - 1));
				frame_gegner.getContentPane().add(button_A0_bis_J9[b - 1][z - 1]);

				Getter_Setter_Gegner.setButton_A0_bis_J9(button_A0_bis_J9[b - 1][z - 1], b - 1, z - 1);

				Listener_Gegner.buttonListener_spieler(button_A0_bis_J9[b - 1][z - 1]);

			}
		}

	}

}
