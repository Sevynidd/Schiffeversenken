package controller.threads;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Thread_empfangen implements Runnable {

	private DatagramSocket datagramSocket;

	public Thread_empfangen(DatagramSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
	}

	public void run() {
		while (true) {
			DatagramPacket datagramPacket = new DatagramPacket(new byte[512], 512);
			try {
				this.datagramSocket.receive(datagramPacket);
			} catch (IOException e) {
				e.printStackTrace();
			}

			InetAddress senderAdresse = datagramPacket.getAddress();
			int senderPort = datagramPacket.getPort();
			String message = new String(datagramPacket.getData());

			// Willkommen
			if (message.equals("Schiffaktion Welcome")) {
				Thread_senden.getCommunicationSender().setHat_Verbindung(true);
				System.out.println("Schiffaktion Welcome");
				Thread_senden.getCommunicationSender().antwort_senden(senderAdresse, "Schiffaktion Antwort",
						senderPort);
			}

			// Antwort
			if (message.equals("Schiffaktion Antwort")) {
				Thread_senden.getCommunicationSender().setHat_Verbindung(true);
				System.out.println("Schiffaktion Antwort");
				// Spiel ist starklar ... Verbindung steht....
			}

		}

	}

}
