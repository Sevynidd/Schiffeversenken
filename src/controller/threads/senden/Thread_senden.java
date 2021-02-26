package controller.threads.senden;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import view.connecten_oder_hosten.Connecten_oder_Hosten;

public class Thread_senden implements Runnable {

	private boolean hat_verbindung = false;
	public static final int PORT = 42069;
	public static String nachricht;
	private static volatile Thread_senden thread_senden;

	private DatagramSocket datagramSocket;

	public DatagramSocket getDatagramSocket() {
		return datagramSocket;
	}

	public void setDatagramSocket(DatagramSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
	}

	public void run() {

		while (true) {

			if (Connecten_oder_Hosten.btnClicked[0]) {
				
				nachricht = "SVSearch,[1.0]";

				if (!hat_verbindung) {
					this.packet_verschicken();
					System.out.println("Packet verschicken");
				}
				try {
					Thread.sleep(5000); // 5 sek
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (Connecten_oder_Hosten.btnClicked[1]) {
				/*
				 * Nichts tun, da er bei Thread_empfangen darauf wartet was rein kommt und
				 * die passende Antwort sendet
				 */
			}
		}

	}

	private void packet_verschicken() {

		byte[] willkommens_gruﬂ = nachricht.getBytes();

		InetAddress Addresse;
		try {
			Addresse = InetAddress.getByName("255.255.255.255");
			DatagramPacket packet = new DatagramPacket(willkommens_gruﬂ, willkommens_gruﬂ.length, Addresse, PORT);
			DatagramSocket socket = new DatagramSocket();
			socket.setBroadcast(true);
			socket.send(packet);
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void antwort_senden(InetAddress inetAddress, String message, int port) {

		byte[] nachricht = message.getBytes();

		try {
			DatagramPacket packet = new DatagramPacket(nachricht, nachricht.length, inetAddress, port);
			DatagramSocket socket = new DatagramSocket();
			socket.send(packet);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Thread_senden getCommunicationSender() {

		if (thread_senden == null) {
			synchronized (Thread_senden.class) {
				if (thread_senden == null) {
					thread_senden = new Thread_senden();
				}
			}
		}

		return thread_senden;
	}

	public boolean isHat_Verbindung() {
		return hat_verbindung;
	}

	public void setHat_Verbindung(boolean hat_verbindung) {
		this.hat_verbindung = hat_verbindung;
	}

}
