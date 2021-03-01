package controller.threads;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Thread_antwort implements Runnable {

	public void run() {

		while (true) {

			byte[] nachricht = Thread_empfangen.antwort_auf_anfrage.getBytes();
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
