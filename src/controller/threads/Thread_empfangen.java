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

	public Thread_empfangen(DatagramSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
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
		InetAddress senderAdresse = packet.getAddress();
		String andereAdresse = senderAdresse.toString();
		int senderPort = packet.getPort();
		String message = new String(packet.getData());

		// meine Adresse
		String meine_ip = "/";

		try {
			InetAddress meine_ip_und_name = InetAddress.getLocalHost();
			meine_ip += meine_ip_und_name.getHostAddress();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

		System.out.println(andereAdresse);
		// Willkommen
		if (message.contains("SVSearch,[1.0]") && !meine_ip.contains(andereAdresse) && btnClicked[1]) {

			Thread_senden.getCommunicationSender().setHat_Verbindung(true);
			System.out.println("SVSearch,[1.0]");
			Thread_senden.antwort_senden(senderAdresse, "SVFound", senderPort);
		}

		// Antwort
		else if (message.contains("SVFound") && !meine_ip.contains(andereAdresse) && btnClicked[0]) {
			Thread_senden.getCommunicationSender().setHat_Verbindung(true);
			System.out.println("SVFound bekommen");
			// Spiel ist starklar ... Verbindung steht....

			Thread_senden.antwort_senden(senderAdresse, "SVAck", senderPort);
		}

		// SVAck
		else if (message.contains("SVAck") && !meine_ip.contains(andereAdresse) && btnClicked[1]) {

			// TODO Kommunikation beginnen

		}
	}

	public static Boolean getBtnClicked(int zahl) {
		return btnClicked[zahl];
	}

	public static void setBtnClicked(Boolean btnClicked, int zahl) {
		Thread_empfangen.btnClicked[zahl] = btnClicked;
	}

}
