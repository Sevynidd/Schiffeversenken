package controller.getter_setter.view;

import javax.swing.JButton;

public class Getter_Setter_Gegner {

	private static JButton button_A0_bis_J9_gegner[][] = new JButton[10][10];
	
	private static boolean spieler_suche_beendet;
	private static boolean schuss_setzen_erlaubt;

	
	public static JButton getButton_A0_bis_J9(int b, int z) {
		return button_A0_bis_J9_gegner[b][z];
	}

	public static void setButton_A0_bis_J9(JButton button_A0_bis_J9, int b, int z) {
		button_A0_bis_J9_gegner[b][z] = button_A0_bis_J9;
	}

	public static boolean isSpieler_suche_beendet() {
		return spieler_suche_beendet;
	}

	public static void setSpieler_suche_beendet(boolean spieler_suche_beendet) {
		Getter_Setter_Gegner.spieler_suche_beendet = spieler_suche_beendet;
	}

	public static boolean isSchuss_setzen_erlaubt() {
		return schuss_setzen_erlaubt;
	}

	public static void setSchuss_setzen_erlaubt(boolean schuss_setzen_erlaubt) {
		Getter_Setter_Gegner.schuss_setzen_erlaubt = schuss_setzen_erlaubt;
	}
	
	
}
