package controller.getter_setter.view;

import javax.swing.JButton;

public class Getter_Setter_Connecten_oder_Hosten {

	private static JButton btnConnecten;
	private static JButton btnHosten;

	public static JButton getBtnConnecten() {
		return btnConnecten;
	}

	public static void setBtnConnecten(JButton btnConnecten) {
		Getter_Setter_Connecten_oder_Hosten.btnConnecten = btnConnecten;
	}

	public static JButton getBtnHosten() {
		return btnHosten;
	}

	public static void setBtnHosten(JButton btnHosten) {
		Getter_Setter_Connecten_oder_Hosten.btnHosten = btnHosten;
	}

}
