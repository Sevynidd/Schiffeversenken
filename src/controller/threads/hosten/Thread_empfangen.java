package controller.threads.hosten;

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
			if (message.equals("SVSearch,[1.0]")) {

				Thread_senden.getCommunicationSender().setHat_Verbindung(true);
				System.out.println("SVSearch,[1.0]");
				Thread_senden.antwort_senden(senderAdresse, "SVFound", senderPort);
			}

			// Antwort
			if (message.equals("SVFound")) {
				Thread_senden.getCommunicationSender().setHat_Verbindung(true);
				System.out.println("SVFound");
				// Spiel ist starklar ... Verbindung steht....

				Thread_senden.antwort_senden(senderAdresse, "SVAck", 42069);
			}

		}

	}

}
