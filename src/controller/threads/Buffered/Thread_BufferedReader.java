package controller.threads.Buffered;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;

import controller.getter_setter.view.Getter_Setter_Gegner;
import controller.getter_setter.view.Getter_Setter_Spieler;
import controller.spielablauf.Verbindungsaufbau;
import view.Gewonnen_Verloren;

public class Thread_BufferedReader implements Runnable {

	/*
	 * Dieser Thread reagiert auf alles was man von den Gegner rein bekommmt.
	 * Fire, Miss, Destroyed, DestroyedLastShip
	 */

	private BufferedReader bufferedReader;
	private String[] buchstaben = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };

	private String[] koordinaten = new String[2];
	private Integer anzahl_an_schiffteilen;

	private int[] counter = new int[10];

	public Thread_BufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	public void run() {

		anzahl_an_schiffteilen = 30;

		lesen();

	}

	private void lesen() {

		for (int m = 0; m <= 9; m++) {
			counter[m] = 0;
		}

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

				String komplette_koordinaten = Integer.toString(index_buchstaben) + koordinaten[1];

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

						Gewonnen_Verloren gv = new Gewonnen_Verloren("Verloren", Color.decode("#f08080"));
					}

					boolean break_variable = false;
					boolean schiff_zerst�rt = false;

					for (int j = 0; j <= 9; j++) {
						// ID

						for (int k = 0; k <= (Getter_Setter_Spieler.getId_laenge().get(j) - 1); k++) {
							// Alle Koordinaten durchgehen

							if (Getter_Setter_Spieler.getId_koordinaten(j, k).equals(komplette_koordinaten)) {

								Getter_Setter_Spieler.setId_true_false(j, k, true);

								counter[j] += 1;

								if (counter[j] == Getter_Setter_Spieler.getId_laenge().get(j)) {

									Getter_Setter_Spieler
											.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
											.setBackground(Color.BLACK);

									Verbindungsaufbau.nachricht_bufferedWriter = "Destroyed,["
											+ buchstaben[index_buchstaben] + "],[" + koordinaten[1] + "]";

									for (int i = 0; i <= (Getter_Setter_Spieler.getId_laenge().get(j) - 1); i++) {

										int b = Integer.parseInt(String
												.valueOf(Getter_Setter_Spieler.getId_koordinaten(j, i).charAt(0)));
										int z = Integer.parseInt(String
												.valueOf(Getter_Setter_Spieler.getId_koordinaten(j, i).charAt(1)));

										Getter_Setter_Spieler.getButton_A0_bis_J9(b, z).setText("X");

										Getter_Setter_Spieler.getButton_A0_bis_J9(b, z).setForeground(Color.WHITE);

									}

									schiff_zerst�rt = true;

									break_variable = true;

									Getter_Setter_Gegner.setSchuss_setzen_erlaubt(false);
									break;

								}

							}

							if (j == 9 && k == (Getter_Setter_Spieler.getId_laenge().get(j) - 1)
									&& counter[j] == Getter_Setter_Spieler.getId_laenge().get(j)) {

								Verbindungsaufbau.nachricht_bufferedWriter = "Destroyed,["
										+ buchstaben[index_buchstaben] + "],[" + koordinaten[1] + "]";

								for (int i = 0; i <= 9; i++) {

									Getter_Setter_Spieler
											.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
											.setText("X");

									Getter_Setter_Spieler
											.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
											.setForeground(Color.WHITE);

								}

								schiff_zerst�rt = true;

								break_variable = true;

								Getter_Setter_Gegner.setSchuss_setzen_erlaubt(false);
								break;

							}

						}

						if (break_variable) {
							break;
						}

					}

					if (!schiff_zerst�rt) {
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

				Gewonnen_Verloren gv = new Gewonnen_Verloren("Gewonnen", Color.decode("#98FB98"));

			}

			// Destroyed,[A],[0]
			else if (nachricht.contains("Destroyed")) {

				char buchstabe = nachricht.charAt(11);
				char zahl = nachricht.charAt(15);

				koordinaten[0] = String.valueOf(buchstabe);
				koordinaten[1] = String.valueOf(zahl);

				int index_buchstaben = 0;

				for (int i = 0; i <= 9; i++) {
					if (koordinaten[0].equals(buchstaben[i])) {
						index_buchstaben = i;
						break;
					}
				}

				String komplette_koordinaten = Integer.toString(index_buchstaben) + koordinaten[1];

				boolean break_variable = false;

				for (int j = 0; j <= 9; j++) {

					for (int k = 0; k <= (Getter_Setter_Spieler.getId_laenge().get(j) - 1); k++) {

						if (Getter_Setter_Spieler.getId_koordinaten(j, k).equals(komplette_koordinaten)) {

							for (int i = 0; i <= (Getter_Setter_Spieler.getId_laenge().get(j) - 1); i++) {

								int b = Integer.parseInt(
										String.valueOf(Getter_Setter_Spieler.getId_koordinaten(j, i).charAt(0)));
								int z = Integer.parseInt(
										String.valueOf(Getter_Setter_Spieler.getId_koordinaten(j, i).charAt(1)));

								Getter_Setter_Gegner.getButton_A0_bis_J9(b, z).setText("X");

								Getter_Setter_Gegner.getButton_A0_bis_J9(b, z).setBackground(Color.BLACK);

								Getter_Setter_Gegner.getButton_A0_bis_J9(b, z).setForeground(Color.WHITE);

							}
							break_variable = true;
							break;

						}

					}

					if (break_variable) {
						break;
					}

				}

				Getter_Setter_Gegner.setSchuss_setzen_erlaubt(true);

			}

		}

	}

}
