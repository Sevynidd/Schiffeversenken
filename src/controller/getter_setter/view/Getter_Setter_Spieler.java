package controller.getter_setter.view;

import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Getter_Setter_Spieler {

	private static JButton[][] button_A0_bis_J9_spieler = new JButton[10][10];

	private static JRadioButton[] RadioButton_Schiffe = new JRadioButton[4];
	private static ButtonGroup gruppe_schiffe = new ButtonGroup();

	private static JRadioButton[] RadioButton_Horizontal_Vertikal = new JRadioButton[2];
	private static ButtonGroup gruppe_hor_vert = new ButtonGroup();

	private static JTextField[] TextField_Anzahl_Schiffe = new JTextField[4];

	private static JTextArea textArea_hinweis = new JTextArea();

	private static HashMap<Integer, Integer> id_laenge = new HashMap<Integer, Integer>();

	private static String[][] id_true_false = new String[10][5];

	private static String[][] id_koordinaten = new String[10][5];

	public static JButton getButton_A0_bis_J9(int b, int z) {
		return button_A0_bis_J9_spieler[b][z];
	}

	public static void setButton_A0_bis_J9(JButton button_A0_bis_J9, int b, int z) {
		Getter_Setter_Spieler.button_A0_bis_J9_spieler[b][z] = button_A0_bis_J9;
	}

	public static JRadioButton[] getRadioButton_Schiffe() {
		return RadioButton_Schiffe;
	}

	public static void setRadioButton_Schiffe(JRadioButton radioButton_Schiffe, int zahl) {
		// Reihenfolge von groﬂ zu klein
		RadioButton_Schiffe[zahl] = radioButton_Schiffe;
	}

	public static ButtonGroup getGruppe_schiffe() {
		// Reihenfolge von groﬂ zu klein
		return gruppe_schiffe;
	}

	public static void setGruppe_schiffe(ButtonGroup gruppe_schiffe) {
		Getter_Setter_Spieler.gruppe_schiffe = gruppe_schiffe;
	}

	public static JRadioButton[] getRadioButton_Horizontal_Vertikal() {
		// 0 ist Horizontal und 1 Vertikal
		return RadioButton_Horizontal_Vertikal;
	}

	public static void setRadioButton_Horizontal_Vertikal(JRadioButton horizontal_Vertikal, int zahl) {
		// 0 ist Horizontal und 1 Vertikal
		RadioButton_Horizontal_Vertikal[zahl] = horizontal_Vertikal;
	}

	public static ButtonGroup getGruppe_hor_vert() {
		return gruppe_hor_vert;
	}

	public static void setGruppe_hor_vert(ButtonGroup gruppe_hor_vert) {
		Getter_Setter_Spieler.gruppe_hor_vert = gruppe_hor_vert;
	}

	public static JTextField[] getTextField_Anzahl_Schiffe() {
		// Reihenfolge von groﬂ zu klein
		return TextField_Anzahl_Schiffe;
	}

	public static void setTextField_Anzahl_Schiffe(JTextField textField_Anzahl_Schiffe, int zahl) {
		// Reihenfolge von groﬂ zu klein
		TextField_Anzahl_Schiffe[zahl] = textField_Anzahl_Schiffe;
	}

	public static JTextArea getTextField_hinweis() {
		return textArea_hinweis;
	}

	public static void setTextField_hinweis(JTextArea textArea_hinweis) {
		Getter_Setter_Spieler.textArea_hinweis = textArea_hinweis;
	}

	public static HashMap<Integer, Integer> getId_laenge() {
		return id_laenge;
	}

	public static void setId_laenge(int id, int inhalt) {

		Getter_Setter_Spieler.id_laenge.put(id, inhalt);

	}

	public static String getId_true_false(int id, int zahl) {
		return id_true_false[id][zahl];
	}

	public static void setId_true_false(int id, int feld, boolean true_false) {
		Getter_Setter_Spieler.id_true_false[id][feld] = String.valueOf(true_false);
	}

	public static String getId_koordinaten(int id, int zahl) {
		return id_koordinaten[id][zahl];
	}

	public static void setId_koordinaten(int id, int feld, String id_koordinaten) {
		Getter_Setter_Spieler.id_koordinaten[id][feld] = id_koordinaten;
	}

}
