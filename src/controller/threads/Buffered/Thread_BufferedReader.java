package controller.threads.Buffered;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import controller.getter_setter.threads.Getter_Setter_Thread_empfangen;
import controller.getter_setter.view.Getter_Setter_Gegner;
import controller.getter_setter.view.Getter_Setter_Spieler;
import controller.spielablauf.Verbindungsaufbau;

public class Thread_BufferedReader implements Runnable {

	private Socket client;
	private BufferedReader bufferedReader;
	private String[] buchstaben = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };

	private String[] koordinaten = new String[2];
	private Integer anzahl_an_schiffteilen;

	public Thread_BufferedReader(Socket client, BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
		this.client = client;

	}

	public void run() {

		anzahl_an_schiffteilen = 30;

		if (Getter_Setter_Thread_empfangen.getBtnClicked(0) && !Getter_Setter_Thread_empfangen.getBtnClicked(1)) {

			try {
				InputStream in_st = client.getInputStream();
				InputStreamReader in_st_re = new InputStreamReader(in_st);
				bufferedReader = new BufferedReader(in_st_re);

			} catch (IOException e) {
				e.printStackTrace();
			}

			lesen();

		} else if (Getter_Setter_Thread_empfangen.getBtnClicked(1)
				&& !Getter_Setter_Thread_empfangen.getBtnClicked(0)) {

			lesen();

		}

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

			if (nachricht.contains("Fire")) {

				// 1) Fire  , 2) [A] , 3) [0] 
				String[] ergebnis_1 = nachricht.split(",");
				
				
				String[] ergebnis_2 = ergebnis_1[1].split("\\[|\\]");
				
				System.out.println(ergebnis_2);
				
				
				koordinaten[0] = ergebnis_1[1];
				koordinaten[1] = ergebnis_1[2];

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
					Verbindungsaufbau.nachricht_bufferedWriter = "Hit," + buchstaben[index_buchstaben] + ","
							+ koordinaten[1];

					Getter_Setter_Spieler.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
							.setBackground(Color.BLACK);

					anzahl_an_schiffteilen -= 1;

					if (anzahl_an_schiffteilen == 0) {
						Verbindungsaufbau.nachricht_bufferedWriter = "DestroyedLastShip," + buchstaben[index_buchstaben]
								+ "," + koordinaten[1];
						
						System.out.println("Spiel verloren");
					}

					Getter_Setter_Gegner.setSchuss_setzen_erlaubt(false);

					// Miss
				} else if (!(Getter_Setter_Spieler
						.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1])).getText()
						.contains("X"))) {

					Verbindungsaufbau.nachricht_bufferedWriter = "Miss," + buchstaben[index_buchstaben] + ","
							+ koordinaten[1];

					Getter_Setter_Gegner.getButton_A0_bis_J9(index_buchstaben, Integer.parseInt(koordinaten[1]))
							.setBackground(Color.ORANGE);

					Getter_Setter_Gegner.setSchuss_setzen_erlaubt(true);

				}
				// TODO Destroyed

			} else if (nachricht.contains("Hit")) {
				
				Getter_Setter_Gegner.setSchuss_setzen_erlaubt(true);

			} else if (nachricht.contains("Miss")) {
				
				Getter_Setter_Gegner.setSchuss_setzen_erlaubt(false);

			} else if (nachricht.contains("Destroyed")) {
				
				Getter_Setter_Gegner.setSchuss_setzen_erlaubt(true);

			} else if (nachricht.contains("DestroyedLastShip")) {
				System.out.println("Spiel gewonnen");
			}

		}

	}

}
