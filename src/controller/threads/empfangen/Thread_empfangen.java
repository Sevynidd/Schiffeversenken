package controller.threads.empfangen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import controller.threads.senden.Thread_antwort;
import controller.threads.senden.Thread_senden;

public class Thread_empfangen implements Runnable {

	private DatagramSocket datagramSocket;

	// 0 = Hosten; 1 = Connecten
	public static Boolean[] btnClicked = new Boolean[2];

	private Thread_antwort ta = new Thread_antwort();

	private String connect_addresse;
	private boolean connect_addresse_veränderbar = true;

	public static String antwort_auf_anfrage;
	public static int senderPort;
	public static InetAddress senderAdresse;

	public String message;
	private String andereAdresse;
	private String meine_ip;

	public Thread_empfangen(DatagramSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
		Thread antwort = new Thread(ta);
		antwort.start();
	}

	public void run() {
		while (true) {
			DatagramPacket datagramPacket = new DatagramPacket(new byte[512], 512);
			try {
				this.datagramSocket.receive(datagramPacket);
				kommunikation(datagramPacket);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException npe) {
				continue;
			}

		}

	}

	private void kommunikation(DatagramPacket packet) {
		// Adresse des anderen
		senderAdresse = packet.getAddress();
		andereAdresse = senderAdresse.toString();
		senderPort = packet.getPort();
		message = new String(packet.getData());

		// meine Adresse
		meine_ip = "/";

		try {
			InetAddress meine_ip_und_name = InetAddress.getLocalHost();
			meine_ip += meine_ip_und_name.getHostAddress();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

		System.out.println("Meine Adresse: " + meine_ip);
		System.out.println("Andere Adresse: " + andereAdresse);

		if (btnClicked[0] && !btnClicked[1]) {

			hosten();

		} else if (btnClicked[1] && !btnClicked[0]) {

			connecten();

		}

	}

	private void hosten() {

		String connect_addresse;

		// Antwort
		if (message.contains("SVFound") && !meine_ip.contains(andereAdresse)) {
			Thread_senden.getCommunicationSender().setHat_Verbindung(true);
			System.out.println("SVFound bekommen");

			connect_addresse = andereAdresse;
			antwort_auf_anfrage = "SVAck";

			// TODO Kommunikation beginnen (Host)
		}
	}

	private void connecten() {

		// Willkommen
		if (message.contains("SVSearch,[1.0]") && !meine_ip.contains(andereAdresse) && connect_addresse_veränderbar) {

			connect_addresse = andereAdresse;

			connect_addresse_veränderbar = false;

			Thread_senden.getCommunicationSender().setHat_Verbindung(true);
			System.out.println("SVSearch,[1.0]");

			antwort_auf_anfrage = "SVFound";
		}

		// SVAck
		else if (message.contains("SVAck") && !meine_ip.contains(andereAdresse) && andereAdresse.contains(connect_addresse)) {

			// TODO Kommunikation beginnen (Client)

		}
	}

	public static Boolean getBtnClicked(int zahl) {
		return btnClicked[zahl];
	}

	public static void setBtnClicked(Boolean btnClicked, int zahl) {
		Thread_empfangen.btnClicked[zahl] = btnClicked;
	}

}
