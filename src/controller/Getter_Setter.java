package controller;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Getter_Setter {

																											//JButton A0 bis J9
	public static JButton[][] button_A0_bis_J9 = new JButton[10][10];
																											//JRadioButtons Schiffe
	public static JRadioButton[] RadioButton_Schiffe = new JRadioButton[4];
	public static ButtonGroup gruppe_schiffe = new ButtonGroup();
																											//JradioButtons Horizontal/Vertikal
	public static JRadioButton[] RadioButton_Horizontal_Vertikal = new JRadioButton[2];
	public static ButtonGroup gruppe_hor_vert = new ButtonGroup();
																											//JTextFields Anzahl Schiffe
	public static JTextField[] TextField_Anzahl_Schiffe = new JTextField[4];
																											//JTextArea Hinweis
	public static JTextArea textArea_hinweis = new JTextArea();


	
																											//Buttons A0 bis J9
	public static JButton getButton_A0_bis_J9(int b, int z) {
		return button_A0_bis_J9[b][z];
	}

	public static void setButton_A0_bis_J9(JButton button_A0_bis_J9, int b, int z) {
		Getter_Setter.button_A0_bis_J9[b][z] = button_A0_bis_J9;
	}
																											//JRadioButtons Schiffe
	public static JRadioButton[] getRadioButton_Schiffe() {
		return RadioButton_Schiffe;
	}

	public static void setRadioButton_Schiffe(JRadioButton radioButton_Schiffe, int zahl) {
		// Reihenfolge von groﬂ zu klein
		RadioButton_Schiffe[zahl] = radioButton_Schiffe;
	}
																											//ButtonGroup Schiffe
	public static ButtonGroup getGruppe_schiffe() {
		// Reihenfolge von groﬂ zu klein
		return gruppe_schiffe;
	}

	public static void setGruppe_schiffe(ButtonGroup gruppe_schiffe) {
		Getter_Setter.gruppe_schiffe = gruppe_schiffe;
	}
																											//JRadioButtons Horizontal/Vertikal
	public static JRadioButton[] getRadioButton_Horizontal_Vertikal() {
		// 0 ist Horizontal und 1 Vertikal
		return RadioButton_Horizontal_Vertikal;
	}

	public static void setRadioButton_Horizontal_Vertikal(JRadioButton horizontal_Vertikal,int zahl) {
		// 0 ist Horizontal und 1 Vertikal
		RadioButton_Horizontal_Vertikal[zahl] = horizontal_Vertikal;
	}
																											//ButtonGroup Horizontal/Vertikal
	public static ButtonGroup getGruppe_hor_vert() {
		return gruppe_hor_vert;
	}

	public static void setGruppe_hor_vert(ButtonGroup gruppe_hor_vert) {
		Getter_Setter.gruppe_hor_vert = gruppe_hor_vert;
	}
																											//JTextFields Anzahl Schiffe
	public static JTextField[] getTextField_Anzahl_Schiffe() {
		// Reihenfolge von groﬂ zu klein
		return TextField_Anzahl_Schiffe;
	}

	public static void setTextField_Anzahl_Schiffe(JTextField textField_Anzahl_Schiffe, int zahl) {
		// Reihenfolge von groﬂ zu klein
		TextField_Anzahl_Schiffe[zahl] = textField_Anzahl_Schiffe;
	}
																											//JTextArea Hinweis
	public static JTextArea getTextField_hinweis() {
		return textArea_hinweis;
	}

	public static void setTextField_hinweis(JTextArea textArea_hinweis) {
		Getter_Setter.textArea_hinweis = textArea_hinweis;
	}

}
