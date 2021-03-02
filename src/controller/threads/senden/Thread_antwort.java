package controller.threads.senden;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import controller.threads.empfangen.Thread_empfangen;

public class Thread_antwort implements Runnable {

	public void run() {

		while (true) {

			byte[] nachricht = null;
			try {
				nachricht = Thread_empfangen.antwort_auf_anfrage.getBytes();
			} catch (NullPointerException npe) {
			}
			InetAddress inetAddress = Thread_empfangen.senderAdresse;
			int port = Thread_empfangen.senderPort;

			try {
				DatagramPacket packet = new DatagramPacket(nachricht, nachricht.length, inetAddress, port);
				DatagramSocket socket = new DatagramSocket();
				socket.send(packet);
				socket.close();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException npe) {
				continue;
			}

			nachricht = null;
			inetAddress = null;

		}

	}

}