package controller.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import controller.getter_setter.view.Getter_Setter_Gegner;

public class Listener_Gegner {

	public static void buttonListener_spieler(JButton button_ausgew�hlt) {
		
		button_ausgew�hlt.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent cursor) {
				
				if(Getter_Setter_Gegner.isSpieler_suche_beendet()) {
					
					System.out.println(button_ausgew�hlt.getActionCommand());
					
					
					
				}
				
				
				//TODO Komplettes Listen f�r Sch�sse fehlt
			
				
				
			}
		});

	}
	
}
