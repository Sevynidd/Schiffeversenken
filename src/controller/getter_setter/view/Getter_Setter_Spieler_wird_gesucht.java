package controller.getter_setter.view;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Getter_Setter_Spieler_wird_gesucht {

	private static JFrame frame_spieler_wird_gesucht;
	private static JTextField txtSpielerWirdGesucht;
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

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar pB) {
		progressBar = pB;
	}

}
