package controller.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import controller.getter_setter.view.Getter_Setter_Gegner;
import controller.spielablauf.Verbindungsaufbau;

public class Listener_Gegner {

	private static String[] buchstaben = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };

	public static void buttonListener_spieler(JButton button_ausgewählt) {

		button_ausgewählt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent cursor) {

				if (Getter_Setter_Gegner.isSpieler_suche_beendet() && Getter_Setter_Gegner.isSchuss_setzen_erlaubt()) {

					Integer buchstabe = Integer.parseInt(button_ausgewählt.getActionCommand().split(" ")[0]);
					Integer zahl = Integer.parseInt(button_ausgewählt.getActionCommand().split(" ")[1]);

					String buchstabe_kein_int = null;

					for (int i = 0; i <= 9; i++) {

						if (i == buchstabe) {

							buchstabe_kein_int = buchstaben[i];
							break;
						}

					}

					Verbindungsaufbau.nachricht_bufferedWriter = "Fire,[" + buchstabe_kein_int + "],[" + zahl + "]";

					Getter_Setter_Gegner.setSchuss_setzen_erlaubt(false);

				}

			}
		});

	}

}
