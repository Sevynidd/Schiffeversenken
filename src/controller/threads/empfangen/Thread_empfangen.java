package controller.threads.empfangen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import controller.getter_setter.threads.Getter_Setter_Thread_beenden;
import controller.getter_setter.threads.Getter_Setter_Thread_empfangen;
import controller.getter_setter.view.Getter_Setter_Spieler_wird_gesucht;
import controller.threads.Antwort;
import controller.threads.senden.Thread_senden;

public class Thread_empfangen implements Runnable {

	private DatagramSocket datagramSocket;

	// Die Adresse desjenigen, welcher mir ein SVFound geschickt hat
	private String connect_addresse;
	private boolean connect_addresse_veränderbar = true;

	private String message;
	// Die Adresse welche ich rein bekomme (welche nicht meine eigene sein sollte)
	private String andereAdresse;
	private String meine_ip;

	public Thread_empfangen(DatagramSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
	}

	public void run() {
		while (!Getter_Setter_Thread_beenden.isBeenden()) {
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

	private void kommunikation(DatagramPacket packet) throws UnknownHostException {

		// Adresse des senders
		InetAddress senderAdresse = packet.getAddress();

		Getter_Setter_Thread_empfangen.setSenderAdresse(senderAdresse);

		andereAdresse = senderAdresse.toString();
		int senderPort = packet.getPort();

		Getter_Setter_Thread_empfangen.setSenderPort(senderPort);

		message = new String(packet.getData());

		// meine Adresse
		meine_ip = "/";

		try {
			InetAddress meine_ip_und_name = InetAddress.getLocalHost();
			meine_ip += meine_ip_und_name.getHostAddress();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

		System.out.println("Meine Adresse: " + meine_ip);
		System.out.println("Andere Adresse: " + andereAdresse);

		if (Getter_Setter_Thread_empfangen.getBtnClicked(0) && !Getter_Setter_Thread_empfangen.getBtnClicked(1)) {

			hosten();

		} else if (Getter_Setter_Thread_empfangen.getBtnClicked(1)
				&& !Getter_Setter_Thread_empfangen.getBtnClicked(0)) {

			connecten();

		}

	}

	private void hosten() throws UnknownHostException {

		// Antwort SVFound => Senden SVAck
		if (message.contains("SVFound") && !meine_ip.contains(andereAdresse)) {
			Thread_senden.getCommunicationSender().setHat_Verbindung(true);
			System.out.println("SVFound bekommen");

			// Verhindern von "//"192.168.xxx.xxx
			connect_addresse = andereAdresse.substring(1, andereAdresse.length());
			Getter_Setter_Thread_empfangen.setConnectAdresse(connect_addresse);

			String antwort_auf_anfrage = "SVAck";
			Getter_Setter_Thread_empfangen.setAntwort_auf_anfrage(antwort_auf_anfrage);

			// Antwort senden
			Antwort antwort = new Antwort();
			antwort.antwort_senden(antwort_auf_anfrage, InetAddress.getByName(connect_addresse),
					Getter_Setter_Thread_empfangen.getSenderPort());

			// Text ändern
			Getter_Setter_Spieler_wird_gesucht.getTxtSpielerWirdGesucht().setText("Spieler gefunden ...");

			// Threads beenden auf true setzen
			Getter_Setter_Thread_beenden.setBeenden(true);

			// Spielen Button true setzen, um die Kommunikation des Spiels zu starten
			Getter_Setter_Spieler_wird_gesucht.getBtnSpielen().setVisible(true);

		}
	}

	private void connecten() throws UnknownHostException {

		// Antwort SVSearch => Senden SVFound
		if (message.contains("SVSearch,[1.0]") && !meine_ip.contains(andereAdresse) && connect_addresse_veränderbar) {

			connect_addresse = andereAdresse.substring(1, andereAdresse.length());
			Getter_Setter_Thread_empfangen.setConnectAdresse(connect_addresse);

			connect_addresse_veränderbar = false;

			Thread_senden.getCommunicationSender().setHat_Verbindung(true);
			System.out.println("SVSearch,[1.0] bekommen");

			String antwort_auf_anfrage = "SVFound";

			Antwort antwort = new Antwort();
			antwort.antwort_senden(antwort_auf_anfrage, InetAddress.getByName(connect_addresse),
					Getter_Setter_Thread_empfangen.getSenderPort());
		}

		// Antwort SVAck
		else if (message.contains("SVAck") && !meine_ip.contains(andereAdresse)
				&& andereAdresse.contains(connect_addresse)) {

			System.out.println("SVAck bekommen");

			// Text ändern
			Getter_Setter_Spieler_wird_gesucht.getTxtSpielerWirdGesucht().setText("Spieler gefunden ...");

			// Threads beenden auf true setzen
			Getter_Setter_Thread_beenden.setBeenden(true);

			// Spielen Button true setzen, um die Kommunikation des Spiels zu starten
			Getter_Setter_Spieler_wird_gesucht.getBtnSpielen().setVisible(true);

		}
	}

}
