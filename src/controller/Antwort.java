package controller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Antwort {

	public void antwort_senden(String antwort_auf_anfrage, InetAddress senderAdresse, int senderPort) {

			byte[] nachricht = null;
			try {
				nachricht = antwort_auf_anfrage.getBytes();
			} catch (NullPointerException npe) {
			}
			InetAddress inetAddress = senderAdresse;
			int port = senderPort;

			try {
				DatagramPacket packet = new DatagramPacket(nachricht, nachricht.length, inetAddress, port);
				DatagramSocket socket = new DatagramSocket();
				socket.send(packet);
				socket.close();
				
				System.out.println("Antwort gesendet");

			} catch (IOException e) {
				e.printStackTrace();
			}

			nachricht = null;
			inetAddress = null;
			port = 0;

		}


}
