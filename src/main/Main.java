package main;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import view.Gegner;
import view.Spieler;

public class Main {

	public static void main(String[] args) {
		try {

			try {
				UIManager.setLookAndFeel(new FlatLightLaf());
			} catch (Exception ex) {
				System.err.println("Failed to initialize LaF");
			}

			Spieler spieler = new Spieler();
			spieler.frame_spieler.setVisible(true);

			Gegner gegner = new Gegner();
			gegner.frame_gegner.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}