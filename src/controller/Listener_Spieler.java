package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Listener_Spieler {

	private static String nicht_platzierbar = "Das Schiff kann dort nicht platziert werden";
	private static String keine_schiffe_mehr = "Es gibt keine Schiffe mehr die man platzieren könnte";
	private static String hinweis_text = "Hier werden Hinweise stehen wenn ein Fehler auftritt";
	
	private static int buchstabe;
	private static int zahl;
	private static int Schiff;
	private static int Schifflänge;
	

	public static void buttonListener(JButton button_ausgewählt) {
		button_ausgewählt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent cursor) {

				Getter_Setter_Spieler.getTextField_hinweis().setText(hinweis_text);
				Getter_Setter_Spieler.getTextField_hinweis().setBackground(new Color(222, 222, 222));

				buchstabe = Integer.parseInt(button_ausgewählt.getActionCommand().split(" ")[0]);
				zahl = Integer.parseInt(button_ausgewählt.getActionCommand().split(" ")[1]);

				switch (Getter_Setter_Spieler.getGruppe_hor_vert().getSelection().getActionCommand()) {

				case "Horizontal":

					switch (Getter_Setter_Spieler.getGruppe_schiffe().getSelection().getActionCommand()) {

					case "Schlachtschiff":
						
						Schiff = 0;
						Schifflänge = 5;

						horizontal(Schiff, Schifflänge);

						break;

					case "Kreuzer":

						Schiff = 1;
						Schifflänge = 4;

						horizontal(Schiff, Schifflänge);

						break;

					case "Zerst\u00F6rer":

						Schiff = 2;
						Schifflänge = 3;

						horizontal(Schiff, Schifflänge);

						break;

					case "UBoot":

						Schiff = 3;
						Schifflänge = 2;

						horizontal(Schiff, Schifflänge);

						break;

					}

					break;
				case "Vertikal":

					switch (Getter_Setter_Spieler.getGruppe_schiffe().getSelection().getActionCommand()) {

					case "Schlachtschiff":

						Schiff = 0;
						Schifflänge = 5;
						
						vertikal(Schiff, Schifflänge);

						break;

					case "Kreuzer":

						Schiff = 1;
						Schifflänge = 4;
						
						vertikal(Schiff, Schifflänge);

						break;

					case "Zerst\u00F6rer":

						Schiff = 2;
						Schifflänge = 3;
						
						vertikal(Schiff, Schifflänge);

						break;

					case "UBoot":

						Schiff = 3;
						Schifflänge = 2;
						
						vertikal(Schiff, Schifflänge);

						break;

					}

					break;

				}

			}

		});
	}
	
	private static void horizontal(int Schiff, int Schifflänge) {
		
		for (int i = buchstabe; i <= (buchstabe + (Schifflänge-1)); i++) {

			// Wenn es mehr als ein Schiff gibt
			if (Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText()) > 0) {

				// Wenn es nicht über die Kante geht
				if (!((buchstabe + (Schifflänge-1)) > 9)) {

					Getter_Setter_Spieler.getButton_A0_bis_J9(i, zahl).setText("X");

					// Rand außendrum Rötlich färben
					for (int farbe_komplett = buchstabe - 1; farbe_komplett <= (buchstabe
							+ (Schifflänge)); farbe_komplett++) {

						for (int farbe_zahl = zahl + 1; farbe_zahl >= (zahl - 1); farbe_zahl--) {

							for (int m = 0; m <= 1; m++) {

								try {
									
									Getter_Setter_Spieler.getButton_A0_bis_J9(farbe_komplett, farbe_zahl)
									.setBackground(Color.decode("#f08080"));
									

								} catch (IndexOutOfBoundsException iaob) {
									continue;
								}
							}

							for (int n = 0; n <= 1; n++) {
								// Grün

								if (!(farbe_komplett == buchstabe - 1
										|| farbe_komplett == buchstabe + (Schifflänge))) {
									Getter_Setter_Spieler.getButton_A0_bis_J9(farbe_komplett, zahl)
											.setBackground(Color.decode("#98FB98"));
								}
							}

						}

					}

				} else {
					Getter_Setter_Spieler.getTextField_hinweis().setText(nicht_platzierbar);
					Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));
					break;
				}

				if (i == buchstabe + Schifflänge) {

					// Den Text setzen zu dem Text von vorher minus 1
					Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].setText(Integer.toString(
							Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText())
									- 1));

				}

			} else {
				Getter_Setter_Spieler.getTextField_hinweis().setText(keine_schiffe_mehr);
				Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));
				break;
			}

		}

		
	}
	
	private static void vertikal(int Schiff, int Schifflänge) {
		
		for (int i = zahl; i >= (zahl - (Schifflänge-1)); i--) {

			// Wenn es mehr als ein Schiff gibt
			if (Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText()) > 0) {

				// Wenn es nicht über die Kante geht
				if ((zahl - (Schifflänge-1)) >= 0) {

					Getter_Setter_Spieler.getButton_A0_bis_J9(buchstabe, i).setText("X");

					// Rand außendrum Rötlich färben
					for (int farbe_komplett = zahl + 1; farbe_komplett >= (zahl
							- Schifflänge); farbe_komplett--) {
						

						for (int farbe_buchstabe = buchstabe - 1; farbe_buchstabe <= (buchstabe + 1); farbe_buchstabe++) {
							
							for (int m = 0; m <= 1; m++) {

								try {
									
									Getter_Setter_Spieler.getButton_A0_bis_J9(farbe_buchstabe, farbe_komplett)
									.setBackground(Color.decode("#f08080"));
										

								} catch (IndexOutOfBoundsException iaob) {
									continue;
								}
							}

							for (int n = 0; n <= 1; n++) {
								// Grün

								if (!(farbe_komplett == zahl + 1
										|| farbe_komplett == zahl - Schifflänge)) {
									Getter_Setter_Spieler.getButton_A0_bis_J9(buchstabe, farbe_komplett)
											.setBackground(Color.decode("#98FB98"));
								}
							}

						}

					}

				} else {
					Getter_Setter_Spieler.getTextField_hinweis().setText(nicht_platzierbar);
					Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));
					break;
				}

				if (i == zahl - 4) {

					// Den Text setzen zu dem Text von vorher minus 1
					Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].setText(Integer.toString(
							Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText())
									- 1));

				}

			} else {
				Getter_Setter_Spieler.getTextField_hinweis().setText(keine_schiffe_mehr);
				Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));
				break;
			}

		}
		
	}

}
