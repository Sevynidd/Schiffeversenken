package controller.getter_setter.threads;

import java.net.InetAddress;

public class Getter_Setter_Thread_empfangen {

	// 0 = Hosten; 1 = Connecten
	private static Boolean[] btnClicked = new Boolean[2];

	private static String antwort_auf_anfrage;
	private static int senderPort;
	private static InetAddress senderAdresse;

	public static Boolean getBtnClicked(int zahl) {
		return btnClicked[zahl];
	}

	public static void setBtnClicked(Boolean btnClicked, int zahl) {
		Getter_Setter_Thread_empfangen.btnClicked[zahl] = btnClicked;
	}

	public static String getAntwort_auf_anfrage() {
		return antwort_auf_anfrage;
	}

	public static void setAntwort_auf_anfrage(String antwort_auf_anfrage) {
		Getter_Setter_Thread_empfangen.antwort_auf_anfrage = antwort_auf_anfrage;
	}

	public static int getSenderPort() {
		return senderPort;
	}

	public static void setSenderPort(int senderPort) {
		Getter_Setter_Thread_empfangen.senderPort = senderPort;
	}

	public static InetAddress getSenderAdresse() {
		return senderAdresse;
	}

	public static void setSenderAdresse(InetAddress senderAdresse) {
		Getter_Setter_Thread_empfangen.senderAdresse = senderAdresse;
	}

}
