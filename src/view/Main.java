package view;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class Main {

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					@SuppressWarnings("unused")
					Main main = new Main();
					
					try {
					    UIManager.setLookAndFeel( new FlatLightLaf() );
					} catch( Exception ex ) {
					    System.err.println( "Failed to initialize LaF" );
					}
					
					Spieler spieler = new Spieler();
					spieler.frame_spieler.setVisible(true);
					
					Gegner gegner = new Gegner();
					gegner.frame_gegner.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}