package controller.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Listener_Connecten_oder_Hosten {

	public static void buttonListener_Connecten(JButton button_ausgewählt, JFrame frame_connecten) {
		
		button_ausgewählt.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent cursor) {
				
				frame_connecten.setVisible(false);
				frame_connecten.dispose();
							
				
			}
	
		});
		
	}
	
	public static void buttonListener_Hosten(JButton button_ausgewählt, JFrame frame_hosten) {
		
		button_ausgewählt.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent cursor) {
				
				frame_hosten.setVisible(false);
				frame_hosten.dispose();
				
			
			}
	
		});
		
	}
	

}
