package controller.getter_setter;

import javax.swing.JButton;

public class Getter_Setter_Gegner {

	private static JButton button_A0_bis_J9_gegner[][] = new JButton[10][10];

	
	public static JButton getButton_A0_bis_J9(int b, int z) {
		return button_A0_bis_J9_gegner[b][z];
	}

	public static void setButton_A0_bis_J9(JButton button_A0_bis_J9, int b, int z) {
		button_A0_bis_J9_gegner[b][z] = button_A0_bis_J9;
	}
	
	
}
