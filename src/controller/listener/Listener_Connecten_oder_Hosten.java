package controller.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.threads.empfangen.Thread_empfangen;
import controller.threads.senden.Thread_senden;
import view.spieler_wird_gesucht.Spieler_wird_gesucht;

public class Listener_Connecten_oder_Hosten {
	
	private static DatagramSocket socket;

	public static void buttonListener_Connecten_oder_Hosten(JButton button_ausgewählt, JFrame frame) {
		button_ausgewählt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent cursor) {
				
				frame.setVisible(false);
				frame.dispose();
				
				if(button_ausgewählt.getActionCommand() == "btnHosten") {
					Thread_empfangen.setBtnClicked(true, 0);
				
				}else if(button_ausgewählt.getActionCommand() == "btnConnecten") {
					Thread_empfangen.setBtnClicked(true, 1);
				}
				
				Spieler_wird_gesucht swg = new Spieler_wird_gesucht();
				// Nicht in static way accessen weil sonst das JFrame gar nicht erst aufgebaut wird
				swg.frame_spieler_wird_gesucht.setVisible(true);

				
				
				if (button_ausgewählt.getActionCommand().equals("btnHosten")) {

					try {
						socket = new DatagramSocket(Thread_senden.PORT);
					} catch (SocketException e) {
						e.printStackTrace();
					}

					Thread_senden.getCommunicationSender().setDatagramSocket(socket);

					Thread sender_Thread = new Thread(Thread_senden.getCommunicationSender());
					sender_Thread.start();
					Thread empfänger_Thread = new Thread(new Thread_empfangen(socket));
					empfänger_Thread.start();

				} else if (button_ausgewählt.getActionCommand().equals("btnConnecten")) {
					
					try {
						socket = new DatagramSocket(Thread_senden.PORT);
					} catch (SocketException e) {
						e.printStackTrace();
					}

					Thread_senden.getCommunicationSender().setDatagramSocket(socket);
					
					Thread sender_Thread = new Thread(Thread_senden.getCommunicationSender());
					sender_Thread.start();
					Thread empfänger_Thread = new Thread(new Thread_empfangen(socket));
					empfänger_Thread.start();
					
				}

			}

		});
	}

}
