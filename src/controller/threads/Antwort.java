package controller.threads;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Antwort {
	
	// Hier werden immer die Antworten wie SVFound und SVAck verschickt

	public void antwort_senden(String antwort_auf_anfrage, InetAddress senderAdresse, int senderPort) {

			byte[] nachricht = null;
			try {
				nachricht = antwort_auf_anfrage.getBytes();
			} catch (NullPointerException npe) {
			}
			//InetAddress inetAddress = senderAdresse;
			
			InetAddress inetAddress = null;
			
			try {
				inetAddress = InetAddress.getByName("255.255.255.255");
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			
			int port = 42069;

			try {
				DatagramPacket packet = new DatagramPacket(nachricht, nachricht.length, inetAddress, port);
				DatagramSocket socket = new DatagramSocket();
				socket.setBroadcast(true);
				socket.send(packet);
				socket.close();
				
				System.out.println(antwort_auf_anfrage + " gesendet an " + senderAdresse);

			} catch (IOException e) {
				e.printStackTrace();
			}

			nachricht = null;
			inetAddress = null;
			port = 0;

		}


}
