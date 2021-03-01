package controller.threads;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

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

			if (Thread_empfangen.getBtnClicked(0) && !Thread_empfangen.getBtnClicked(1)) {
				
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
			} else if (Thread_empfangen.getBtnClicked(1) && !Thread_empfangen.getBtnClicked(0)) {
				
				
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
			datagramSocket = new DatagramSocket();
			datagramSocket.setBroadcast(true);
			datagramSocket.send(packet);
			datagramSocket.close();

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
