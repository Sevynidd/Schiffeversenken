package controller.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.getter_setter.listnener.Getter_Setter_Listener_Connecten_oder_Hosten;
import controller.getter_setter.threads.Getter_Setter_Thread_beenden;
import controller.getter_setter.threads.Getter_Setter_Thread_empfangen;
import controller.getter_setter.view.Getter_Setter_Spieler_wird_gesucht;
import controller.spielablauf.Verbindungsaufbau;
import controller.threads.empfangen.Thread_empfangen;
import controller.threads.senden.Thread_senden;
import view.spieler_wird_gesucht.Spieler_wird_gesucht;

public class Listener_Connecten_oder_Hosten {

	public static void buttonListener_Connecten_oder_Hosten(JButton button_ausgew�hlt, JFrame frame) {
		button_ausgew�hlt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent cursor) {

				frame.setVisible(false);
				frame.dispose();

				if (button_ausgew�hlt.getActionCommand() == "btnHosten") {
					Getter_Setter_Thread_empfangen.setBtnClicked(true, 0);

				} else if (button_ausgew�hlt.getActionCommand() == "btnConnecten") {
					Getter_Setter_Thread_empfangen.setBtnClicked(true, 1);
				}
				
				Getter_Setter_Thread_beenden.setBeenden(false);
				Getter_Setter_Thread_empfangen.setThreads_aktiv(true);

				// Um die view zu �ffnen
				@SuppressWarnings("unused")
				Spieler_wird_gesucht swg = new Spieler_wird_gesucht();
				Getter_Setter_Spieler_wird_gesucht.getFrame_spieler_wird_gesucht().setVisible(true);
				
				try {

					DatagramSocket socket = new DatagramSocket(Thread_senden.PORT);
					Getter_Setter_Listener_Connecten_oder_Hosten.setSocket(socket);

				} catch (SocketException e) {
					e.printStackTrace();
				}

				Thread_senden.getCommunicationSender()
						.setDatagramSocket(Getter_Setter_Listener_Connecten_oder_Hosten.getSocket());

				Thread sender_Thread = new Thread(Thread_senden.getCommunicationSender());
				sender_Thread.start();
				Thread empf�nger_Thread = new Thread(
						new Thread_empfangen(Getter_Setter_Listener_Connecten_oder_Hosten.getSocket()));
				empf�nger_Thread.start();

				while(Getter_Setter_Thread_empfangen.isThreads_aktiv()) {
					
					// Mach nichts solange bis die Threads fertig sind mit kommunikation
					
				}
				
				Verbindungsaufbau vab = new Verbindungsaufbau();
				
			}

		});
	}

}
