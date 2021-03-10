package controller.getter_setter.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Getter_Setter_Spieler_wird_gesucht {

	private static JFrame frame_spieler_wird_gesucht;
	private static JTextField txtSpielerWirdGesucht;
	private static JButton btnSpielen;
	private static boolean button_aktiv;
	private JProgressBar progressBar;

	public static JFrame getFrame_spieler_wird_gesucht() {
		return frame_spieler_wird_gesucht;
	}

	public static void setFrame_spieler_wird_gesucht(JFrame frame) {
		frame_spieler_wird_gesucht = frame;
	}

	public static JTextField getTxtSpielerWirdGesucht() {
		return txtSpielerWirdGesucht;
	}

	public static void setTxtSpielerWirdGesucht(JTextField txt) {
		txtSpielerWirdGesucht = txt;
	}

	public static JButton getBtnSpielen() {
		return btnSpielen;
	}

	public static void setBtnSpielen(JButton btnSpielen) {
		Getter_Setter_Spieler_wird_gesucht.btnSpielen = btnSpielen;
	}

	public static boolean isButton_aktiv() {
		return button_aktiv;
	}

	public static void setButton_aktiv(boolean button_aktiv) {
		Getter_Setter_Spieler_wird_gesucht.button_aktiv = button_aktiv;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar pB) {
		progressBar = pB;
	}

}
