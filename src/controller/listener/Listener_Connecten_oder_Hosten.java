package controller.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Listener_Connecten_oder_Hosten {

	public static void buttonListener_Connecten(JButton button_ausgewählt, JFrame frame_connecten) {
		
		button_ausgewählt.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent cursor) {
				
				connecten(frame_connecten);
											
			}
	
		});
		
	}
	
	public static void buttonListener_Hosten(JButton button_ausgewählt, JFrame frame_hosten) {
		
		button_ausgewählt.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent cursor) {
				
				try {
					
					hosten(frame_hosten);
					
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
					
			}
	
		});
		
	}
	
	
	private static void connecten(JFrame frame) {
		
		frame.setVisible(false);
		frame.dispose();
		
		
	}
	
	
	private static void hosten(JFrame frame) throws IOException {
		
		frame.setVisible(false);
		frame.dispose();
		
		DatagramSocket hosten = new DatagramSocket();
		InetAddress inetAddress = InetAddress.getByName("255.255.255.255");
		
		
		byte[] willkommen = "Schiffaktion Welcome".getBytes();
		DatagramPacket packet = new DatagramPacket(willkommen, willkommen.length, inetAddress, 42069);
		
		hosten.setBroadcast(true);
		hosten.send(packet);
		hosten.close();
				
	}
	

}
