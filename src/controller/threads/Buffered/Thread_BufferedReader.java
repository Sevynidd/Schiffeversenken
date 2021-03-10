package controller.threads.Buffered;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;

import controller.getter_setter.view.Getter_Setter_Gegner;
import controller.getter_setter.view.Getter_Setter_Spieler;
import controller.spielablauf.Verbindungsaufbau;

public class Thread_BufferedReader implements Runnable {

	private BufferedReader bufferedReader;
	private String[] buchstaben = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };

	private String[] koordinaten = new String[2];
	private Integer anzahl_an_schiffteilen;

	public Thread_BufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	public void run() {

		anzahl_an_schiffteilen = 30;

		lesen();

	}

	private void lesen() {

		while (true) {
			String nachricht = null;

			try {
				nachricht = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException npe) {
				continue;
			}

			// Fire,[A],[0]
			if (nachricht.contains("Fire")) {

				char buchstabe = nachricht.charAt(6);
				char zahl = nachricht.charAt(10);

				System.out.println(buchstabe + " " + zahl);

				koordinaten[0] = String.valueOf(buchstabe);
				koordinaten[1] = String.valueOf(zahl);

				int index_buchstaben = 0;

				for (int i = 0; i <= 9; i++) {
					if (koordinaten[0].equals(buchstaben[i])) {
						index_buchstaben = i;
						break;
					}
				}

				// Hit
				if (Getter_Setter_Spieler.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
						.getText().contains("X")) {

					anzahl_an_schiffteilen -= 1;

					if (anzahl_an_schiffteilen == 0) {
						
						Getter_Setter_Spieler.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
						.setBackground(Color.BLACK);
						
						Verbindungsaufbau.nachricht_bufferedWriter = "DestroyedLastShip,["
								+ buchstaben[index_buchstaben] + "],[" + koordinaten[1] + "]";

						System.out.println("Spiel verloren");

						//TODO JFrame öffnen: Verloren
					}

					Verbindungsaufbau.nachricht_bufferedWriter = "Hit,[" + buchstaben[index_buchstaben] + "],["
							+ koordinaten[1] + "]";

					Getter_Setter_Spieler.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
							.setBackground(Color.BLACK);

					Getter_Setter_Gegner.setSchuss_setzen_erlaubt(false);

				// Miss
				} else if (!(Getter_Setter_Spieler
						.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1])).getText()
						.contains("X"))) {

					Verbindungsaufbau.nachricht_bufferedWriter = "Miss,[" + buchstaben[index_buchstaben] + "],["
							+ koordinaten[1] + "]";

					Getter_Setter_Spieler.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
							.setBackground(Color.ORANGE);

					Getter_Setter_Gegner.setSchuss_setzen_erlaubt(true);

				}
				// TODO Destroyed

				// Hit,[A],[0]
			} else if (nachricht.contains("Hit")) {

				char buchstabe = nachricht.charAt(5);
				char zahl = nachricht.charAt(9);

				System.out.println(buchstabe + " " + zahl);

				koordinaten[0] = String.valueOf(buchstabe);
				koordinaten[1] = String.valueOf(zahl);

				int index_buchstaben = 0;

				for (int i = 0; i <= 9; i++) {
					if (koordinaten[0].equals(buchstaben[i])) {
						index_buchstaben = i;
						break;
					}
				}

				Getter_Setter_Gegner.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
						.setBackground(Color.BLACK);

				Getter_Setter_Gegner.setSchuss_setzen_erlaubt(true);

				// Miss,[A],[0]
			} else if (nachricht.contains("Miss")) {

				char buchstabe = nachricht.charAt(6);
				char zahl = nachricht.charAt(10);

				System.out.println(buchstabe + " " + zahl);

				koordinaten[0] = String.valueOf(buchstabe);
				koordinaten[1] = String.valueOf(zahl);

				int index_buchstaben = 0;

				for (int i = 0; i <= 9; i++) {
					if (koordinaten[0].equals(buchstaben[i])) {
						index_buchstaben = i;
						break;
					}
				}

				Getter_Setter_Gegner.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
						.setBackground(Color.ORANGE);

				Getter_Setter_Gegner.setSchuss_setzen_erlaubt(false);

			} else if (nachricht.contains("Destroyed")) {

				Getter_Setter_Gegner.setSchuss_setzen_erlaubt(true);

			// DestroyedLastShip,[A],[0]
			} else if (nachricht.contains("DestroyedLastShip")) {
				
				char buchstabe = nachricht.charAt(19);
				char zahl = nachricht.charAt(23);

				System.out.println(buchstabe + " " + zahl);

				koordinaten[0] = String.valueOf(buchstabe);
				koordinaten[1] = String.valueOf(zahl);

				int index_buchstaben = 0;

				for (int i = 0; i <= 9; i++) {
					if (koordinaten[0].equals(buchstaben[i])) {
						index_buchstaben = i;
						break;
					}
				}

				Getter_Setter_Gegner.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
						.setBackground(Color.BLACK);
				
				System.out.println("Spiel gewonnen");


				//TODO JFrame öffnen: Gewonnen

			}

		}

	}

}
