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
import controller.threads.empfangen.Thread_empfangen;
import controller.threads.senden.Thread_senden;
import view.spieler_wird_gesucht.Spieler_wird_gesucht;

public class Listener_Connecten_oder_Hosten {

	public static void buttonListener_Connecten_oder_Hosten(JButton button_ausgewählt, JFrame frame) {
		button_ausgewählt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent cursor) {

				frame.setVisible(false);
				frame.dispose();

				// Welcher Button wurde gedrückt?

				if (button_ausgewählt.getActionCommand() == "btnHosten") {
					Getter_Setter_Thread_empfangen.setBtnClicked(true, 0);

				} else if (button_ausgewählt.getActionCommand() == "btnConnecten") {
					Getter_Setter_Thread_empfangen.setBtnClicked(true, 1);
				}

				// Threads sollen noch nicht beendet werden
				Getter_Setter_Thread_beenden.setBeenden(false);

				// Um die view zu öffnen
				Spieler_wird_gesucht swg = new Spieler_wird_gesucht();

				try {

					// DatagramSocket öffnen
					DatagramSocket socket = new DatagramSocket(Thread_senden.PORT);
					Getter_Setter_Listener_Connecten_oder_Hosten.setSocket(socket);

				} catch (SocketException e) {
					e.printStackTrace();
				}

				// Die Threads starten
				
				Thread_senden.getCommunicationSender()
						.setDatagramSocket(Getter_Setter_Listener_Connecten_oder_Hosten.getSocket());

				Thread sender_Thread = new Thread(Thread_senden.getCommunicationSender());
				sender_Thread.start();
				Thread empfänger_Thread = new Thread(
						new Thread_empfangen(Getter_Setter_Listener_Connecten_oder_Hosten.getSocket()));
				empfänger_Thread.start();

			}

		});
	}

}
