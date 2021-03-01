package controller.threads;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Thread_empfangen implements Runnable {

	private DatagramSocket datagramSocket;

	// 0 = Hosten; 1 = Connecten
	public static Boolean[] btnClicked = new Boolean[2];
	
	private Thread_antwort ta = new Thread_antwort();
	
	protected static String antwort_auf_anfrage;
	protected static int senderPort;
	protected static InetAddress senderAdresse;
	

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
		String andereAdresse = senderAdresse.toString();
		senderPort = packet.getPort();
		String message = new String(packet.getData());

		// meine Adresse
		String meine_ip = "/";

		try {
			InetAddress meine_ip_und_name = InetAddress.getLocalHost();
			meine_ip += meine_ip_und_name.getHostAddress();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

		System.out.println("Meine Adresse: " + meine_ip);
		System.out.println("Andere Adresse: " + andereAdresse);
		// Willkommen
		if (message.contains("SVSearch,[1.0]") && !meine_ip.contains(andereAdresse) && btnClicked[1]) {

			Thread_senden.getCommunicationSender().setHat_Verbindung(true);
			System.out.println("SVSearch,[1.0]");
			
			antwort_auf_anfrage = "SVFound";
		}

		// Antwort
		else if (message.contains("SVFound") && !meine_ip.contains(andereAdresse) && btnClicked[0]) {
			Thread_senden.getCommunicationSender().setHat_Verbindung(true);
			System.out.println("SVFound bekommen");

			
			antwort_auf_anfrage = "SVAck";
			
			
			// TODO Kommunikation beginnen (Host)
		}

		// SVAck
		else if (message.contains("SVAck") && !meine_ip.contains(andereAdresse) && btnClicked[1]) {

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
