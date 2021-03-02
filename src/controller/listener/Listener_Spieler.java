package controller.listener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import controller.getter_setter.Getter_Setter_Spieler;
import view.connecten_oder_hosten.Connecten_oder_Hosten;

public class Listener_Spieler {

	private static String nicht_platzierbar = "Das Schiff kann dort nicht platziert werden";
	private static String keine_schiffe_mehr = "Es gibt keine Schiffe mehr die man platzieren k�nnte";
	private static String hinweis_text = "Hier werden Hinweise stehen wenn ein Fehler auftritt";
	private static String anderes_schiff_in_der_n�he = "Das Schiff kann nicht platziert werden, da ein anderes Schiff zu nah "
			+ "am zu platzierenden Schiff liegt";

	private static int buchstabe;
	private static int zahl;
	private static int schiff;
	private static int schiffl�nge;

	private static int schiff_anzahl_insgesamt;

	public static void buttonListener_spieler(JButton button_ausgew�hlt) {
		button_ausgew�hlt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent cursor) {

				schiff_anzahl_insgesamt = 0;

				// Schiffe insgesamt
				for (int i = 0; i <= 3; i++) {
					schiff_anzahl_insgesamt += Integer
							.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[i].getText());
				}

				Getter_Setter_Spieler.getTextField_hinweis().setText(hinweis_text);
				Getter_Setter_Spieler.getTextField_hinweis().setBackground(new Color(222, 222, 222));

				buchstabe = Integer.parseInt(button_ausgew�hlt.getActionCommand().split(" ")[0]);
				zahl = Integer.parseInt(button_ausgew�hlt.getActionCommand().split(" ")[1]);

				switch (Getter_Setter_Spieler.getGruppe_hor_vert().getSelection().getActionCommand()) {

				case "Horizontal":

					switch (Getter_Setter_Spieler.getGruppe_schiffe().getSelection().getActionCommand()) {

					case "Schlachtschiff":

						schiff = 0;
						schiffl�nge = 5;

						if (test_horizontal_schiff_in_der_n�he(schiff, schiffl�nge)) {
							horizontal(schiff, schiffl�nge);
						}

						break;

					case "Kreuzer":

						schiff = 1;
						schiffl�nge = 4;

						if (test_horizontal_schiff_in_der_n�he(schiff, schiffl�nge)) {
							horizontal(schiff, schiffl�nge);
						}

						break;

					case "Zerst\u00F6rer":

						schiff = 2;
						schiffl�nge = 3;

						if (test_horizontal_schiff_in_der_n�he(schiff, schiffl�nge)) {
							horizontal(schiff, schiffl�nge);
						}

						break;

					case "UBoot":

						schiff = 3;
						schiffl�nge = 2;

						if (test_horizontal_schiff_in_der_n�he(schiff, schiffl�nge)) {
							horizontal(schiff, schiffl�nge);
						}

						break;

					}

					break;

				case "Vertikal":

					switch (Getter_Setter_Spieler.getGruppe_schiffe().getSelection().getActionCommand()) {

					case "Schlachtschiff":

						schiff = 0;
						schiffl�nge = 5;

						if (test_vertikal_schiff_in_der_n�he(schiff, schiffl�nge)) {
							vertikal(schiff, schiffl�nge);
						}

						break;

					case "Kreuzer":

						schiff = 1;
						schiffl�nge = 4;

						if (test_vertikal_schiff_in_der_n�he(schiff, schiffl�nge)) {
							vertikal(schiff, schiffl�nge);
						}

						break;

					case "Zerst\u00F6rer":

						schiff = 2;
						schiffl�nge = 3;

						if (test_vertikal_schiff_in_der_n�he(schiff, schiffl�nge)) {
							vertikal(schiff, schiffl�nge);
						}

						break;

					case "UBoot":

						schiff = 3;
						schiffl�nge = 2;

						if (test_vertikal_schiff_in_der_n�he(schiff, schiffl�nge)) {
							vertikal(schiff, schiffl�nge);
						}

						break;

					}

					break;

				}

			}

		});
	}

	private static boolean test_horizontal_schiff_in_der_n�he(int Schiff, int Schiffl�nge) {

		/*
		 * Einmal f�r den ganzen �u�eren Rand testen ob dort ein Schiff ist, dann wird
		 * kein neues platziert
		 */

		for (int j = buchstabe; j <= (buchstabe + Schiffl�nge - 1); j++) {

			try {

				if (Color.decode("#f08080").equals(Getter_Setter_Spieler.getButton_A0_bis_J9(j, zahl).getBackground())
						|| Color.decode("#98FB98")
								.equals(Getter_Setter_Spieler.getButton_A0_bis_J9(j, zahl).getBackground())) {

					Getter_Setter_Spieler.getTextField_hinweis().setText(anderes_schiff_in_der_n�he);
					Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));

					return false;

				}

			} catch (IndexOutOfBoundsException ioobe) {
				continue;
			}

		}

		return true;

	}

	private static void horizontal(int Schiff, int Schiffl�nge) {

		for (int i = buchstabe; i <= (buchstabe + (Schiffl�nge - 1)); i++) {

			// Wenn es mehr als ein Schiff gibt
			if (Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText()) > 0) {

				// Wenn es nicht �ber die Kante geht
				if (!((buchstabe + (Schiffl�nge - 1)) > 9)) {

					Getter_Setter_Spieler.getButton_A0_bis_J9(i, zahl).setText("X");

					// Rand au�endrum R�tlich f�rben
					for (int farbe_komplett = buchstabe - 1; farbe_komplett <= (buchstabe
							+ (Schiffl�nge)); farbe_komplett++) {

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
								// Gr�n

								if (!(farbe_komplett == buchstabe - 1 || farbe_komplett == buchstabe + (Schiffl�nge))) {
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

				if (i == buchstabe + (Schiffl�nge - 1)) {

					// Den Text setzen zu dem Text von vorher minus 1
					Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].setText(Integer.toString(
							Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText())
									- 1));

					schiff_anzahl_insgesamt -= 1;

				}

			} else {
				Getter_Setter_Spieler.getTextField_hinweis().setText(keine_schiffe_mehr);
				Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));
				break;
			}

		}

		if (schiff_anzahl_insgesamt == 0) {

			Connecten_oder_Hosten window = new Connecten_oder_Hosten();
			window.frame_connecten_oder_hosten.setVisible(true);

		}

	}

	private static boolean test_vertikal_schiff_in_der_n�he(int Schiff, int Schiffl�nge) {

		for (int j = zahl; j >= zahl - Schiffl�nge + 1; j--) {

			try {

				if (Color.decode("#f08080")
						.equals(Getter_Setter_Spieler.getButton_A0_bis_J9(buchstabe, j).getBackground())
						|| Color.decode("#98FB98")
								.equals(Getter_Setter_Spieler.getButton_A0_bis_J9(buchstabe, j).getBackground())) {

					Getter_Setter_Spieler.getTextField_hinweis().setText(anderes_schiff_in_der_n�he);
					Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));

					return false;

				}

			} catch (IndexOutOfBoundsException ioobe) {
				continue;
			}

		}

		return true;

	}

	private static void vertikal(int Schiff, int Schiffl�nge) {

		for (int i = zahl; i >= (zahl - (Schiffl�nge - 1)); i--) {

			// Wenn es mehr als ein Schiff gibt
			if (Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText()) > 0) {

				// Wenn es nicht �ber die Kante geht
				if ((zahl - (Schiffl�nge - 1)) >= 0) {

					Getter_Setter_Spieler.getButton_A0_bis_J9(buchstabe, i).setText("X");

					// Rand au�endrum R�tlich f�rben
					for (int farbe_komplett = zahl + 1; farbe_komplett >= (zahl - Schiffl�nge); farbe_komplett--) {

						for (int farbe_buchstabe = buchstabe - 1; farbe_buchstabe <= (buchstabe
								+ 1); farbe_buchstabe++) {

							for (int m = 0; m <= 1; m++) {

								try {

									Getter_Setter_Spieler.getButton_A0_bis_J9(farbe_buchstabe, farbe_komplett)
											.setBackground(Color.decode("#f08080"));

								} catch (IndexOutOfBoundsException iaob) {
									continue;
								}
							}

							for (int n = 0; n <= 1; n++) {
								// Gr�n

								if (!(farbe_komplett == zahl + 1 || farbe_komplett == zahl - Schiffl�nge)) {
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

				if (i == zahl - (Schiffl�nge - 1)) {

					// Den Text setzen zu dem Text von vorher minus 1
					Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].setText(Integer.toString(
							Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText())
									- 1));

					schiff_anzahl_insgesamt -= 1;

				}

			} else {
				Getter_Setter_Spieler.getTextField_hinweis().setText(keine_schiffe_mehr);
				Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));
				break;
			}

		}

		if (schiff_anzahl_insgesamt == 0) {

			Connecten_oder_Hosten window = new Connecten_oder_Hosten();
			window.frame_connecten_oder_hosten.setVisible(true);

		}

	}

}