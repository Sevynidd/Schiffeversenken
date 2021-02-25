package controller.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.threads.hosten.Thread_hosten_empfangen;
import controller.threads.hosten.Thread_hosten_senden;
import view.spieler_wird_gesucht.Spieler_wird_gesucht;

public class Listener_Connecten_oder_Hosten {
	
	private static DatagramSocket hosten;

	public static void buttonListener_Connecten_oder_Hosten(JButton button_ausgewählt, JFrame frame) {
		button_ausgewählt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent cursor) {
				
				frame.setVisible(false);
				frame.dispose();
				
				Spieler_wird_gesucht fenster = new Spieler_wird_gesucht();
				fenster.frame_spieler_wird_gesucht.setVisible(true);

				
				
				if (button_ausgewählt.getActionCommand().equals("btnHosten")) {

					try {
						hosten = new DatagramSocket(Thread_hosten_senden.PORT);
					} catch (SocketException e) {
						e.printStackTrace();
					}

					Thread_hosten_senden.getCommunicationSender().setDatagramSocket(hosten);

					Thread sender_Thread = new Thread(Thread_hosten_senden.getCommunicationSender());
					sender_Thread.start();
					Thread empfänger_Thread = new Thread(new Thread_hosten_empfangen(hosten));
					empfänger_Thread.start();

				} else if (button_ausgewählt.getActionCommand().equals("btnConnecten")) {

					
					
					
				}

			}

		});
	}

}
