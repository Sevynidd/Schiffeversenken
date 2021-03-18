package controller.threads.senden;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import controller.getter_setter.threads.Getter_Setter_Thread_beenden;
import controller.getter_setter.threads.Getter_Setter_Thread_empfangen;

public class Thread_senden implements Runnable {

	/*
	 * Thread, welcher am Anfang die ganze Zeit SVSearch schickt, bis er das erste
	 * mal eine Nachricht zurück bekommt (SVAck).
	 */

	private boolean hat_verbindung = false;
	public static final int PORT = 42069;
	public static String nachricht;

	// Für synchronized
	private static volatile Thread_senden thread_senden;

	private DatagramSocket datagramSocket;

	public DatagramSocket getDatagramSocket() {
		return datagramSocket;
	}

	public void setDatagramSocket(DatagramSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
	}

	public void run() {

		// So lange wie die Threads nicht durch die Variable beendet werden:
		while (!Getter_Setter_Thread_beenden.isBeenden()) {

			// Wenn der Button "Hosten" geklickt wurde:
			if (Getter_Setter_Thread_empfangen.getBtnClicked(0) && !Getter_Setter_Thread_empfangen.getBtnClicked(1)) {

				nachricht = "SVSearch,[1.0]";

				// Es wird so lange SVSearch geschickt, bis man das erste mal ein SVFound erhält
				if (!hat_verbindung) {
					this.packet_verschicken();
					System.out.println("Packet verschicken");
				}
				try {
					Thread.sleep(5000); // 5 sek
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (Getter_Setter_Thread_empfangen.getBtnClicked(1)
					&& !Getter_Setter_Thread_empfangen.getBtnClicked(0)) {

				/*
				 * Nichts tun, da er bei Thread_empfangen darauf wartet was rein kommt und die
				 * passende Antwort sendet
				 */
			}
		}

	}

	private void packet_verschicken() {

		byte[] willkommens_gruß = nachricht.getBytes();

		InetAddress Addresse;
		try {
			Addresse = InetAddress.getByName("255.255.255.255");
			DatagramPacket packet = new DatagramPacket(willkommens_gruß, willkommens_gruß.length, Addresse, PORT);
			datagramSocket = new DatagramSocket();
			datagramSocket.setBroadcast(true);
			datagramSocket.send(packet);
			datagramSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Thread_senden getCommunicationSender() {

		// Eigentlich keine Ahnung was hier passiert (Copied from Katzberg)

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
