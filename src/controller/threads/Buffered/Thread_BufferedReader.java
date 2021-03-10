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

				koordinaten[0] = String.valueOf(buchstabe);
				koordinaten[1] = String.valueOf(zahl);

				int index_buchstaben = 0;

				for (int i = 0; i <= 9; i++) {
					if (koordinaten[0].equals(buchstaben[i])) {
						index_buchstaben = i;
						break;
					}
				}

				String komplette_koordinaten = buchstaben[index_buchstaben] + zahl;

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

						// TODO JFrame öffnen: Verloren
					}

					boolean break_variable = false;
					boolean schiff_zerstört = false;
					int counter = 0;

					for (int j = 0; j <= 10; j++) {

						for (int k = 0; k < Getter_Setter_Spieler.getId_laenge().get(j); k++) {

							if (Getter_Setter_Spieler.getId_koordinaten(j, k).equals(komplette_koordinaten)) {

								Getter_Setter_Spieler.setId_true_false(j, k, true);

							}

							if (Boolean.valueOf(Getter_Setter_Spieler.getId_true_false(j, k))) {
								counter += 1;
							}

							if (j == 10 && k < Getter_Setter_Spieler.getId_laenge().get(j)
									&& counter == Getter_Setter_Spieler.getId_laenge().get(j)) {

								Verbindungsaufbau.nachricht_bufferedWriter = "Destroyed,["
										+ buchstaben[index_buchstaben] + "],[" + koordinaten[1] + "]";

								schiff_zerstört = true;

								break_variable = true;

								Getter_Setter_Gegner.setSchuss_setzen_erlaubt(false);
								break;

							}

						}

						if (break_variable) {
							break;
						}

					}

					if (!schiff_zerstört) {
						Verbindungsaufbau.nachricht_bufferedWriter = "Hit,[" + buchstaben[index_buchstaben] + "],["
								+ koordinaten[1] + "]";

						Getter_Setter_Spieler.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
								.setBackground(Color.BLACK);

						Getter_Setter_Gegner.setSchuss_setzen_erlaubt(false);

					}

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

				// Hit,[A],[0]
			} else if (nachricht.contains("Hit")) {

				char buchstabe = nachricht.charAt(5);
				char zahl = nachricht.charAt(9);

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

				// DestroyedLastShip,[A],[0]
			} else if (nachricht.contains("DestroyedLastShip")) {

				char buchstabe = nachricht.charAt(19);
				char zahl = nachricht.charAt(23);

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

				// TODO JFrame öffnen: Gewonnen

			}

			// Destroyed,[A],[0]
			else if (nachricht.contains("Destroyed")) {

				char buchstabe = nachricht.charAt(6);
				char zahl = nachricht.charAt(10);

				koordinaten[0] = String.valueOf(buchstabe);
				koordinaten[1] = String.valueOf(zahl);

				int index_buchstaben = 0;

				for (int i = 0; i <= 9; i++) {
					if (koordinaten[0].equals(buchstaben[i])) {
						index_buchstaben = i;
						break;
					}
				}

				String komplette_koordinaten = Integer.toString(index_buchstaben + zahl);

				boolean schleife_beenden = false;

				// TODO Alle ein X in weiß reinsetzen

				for (int j = 0; j <= 10; j++) {

					for (int k = 0; k < Getter_Setter_Spieler.getId_laenge().get(j); k++) {

						if (Getter_Setter_Spieler.getId_koordinaten(j, k).equals(komplette_koordinaten)) {

							for (int i = 0; i < Getter_Setter_Spieler.getId_laenge().get(j); i++) {

								Getter_Setter_Spieler
										.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
										.setText("X");

								Getter_Setter_Spieler
								.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1])).setForeground(Color.WHITE);
								
								schleife_beenden = true;
								
							}

							break;
							
						}

					}
					
					if(schleife_beenden) {
						break;
					}

				}

			}

		}

	}

}
