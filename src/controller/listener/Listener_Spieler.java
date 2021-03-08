package controller.listener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import controller.getter_setter.listnener.Getter_Setter_Listener_Spieler;
import controller.getter_setter.view.Getter_Setter_Spieler;
import view.connecten_oder_hosten.Connecten_oder_Hosten;

public class Listener_Spieler {

	public static void buttonListener_spieler(JButton button_ausgew�hlt) {
		button_ausgew�hlt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent cursor) {

				Getter_Setter_Listener_Spieler.setSchiff_anzahl_insgesamt(0);

				// Schiffe insgesamt
				for (int i = 0; i <= 3; i++) {

					int gsai = Getter_Setter_Listener_Spieler.getSchiff_anzahl_insgesamt();

					Getter_Setter_Listener_Spieler.setSchiff_anzahl_insgesamt(
							gsai += Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[i].getText()));
				}

				Getter_Setter_Spieler.getTextField_hinweis().setText(Getter_Setter_Listener_Spieler.getHinweis_text());
				Getter_Setter_Spieler.getTextField_hinweis().setBackground(new Color(222, 222, 222));

				Getter_Setter_Listener_Spieler
						.setBuchstabe(Integer.parseInt(button_ausgew�hlt.getActionCommand().split(" ")[0]));
				Getter_Setter_Listener_Spieler
						.setZahl(Integer.parseInt(button_ausgew�hlt.getActionCommand().split(" ")[1]));

				switch (Getter_Setter_Spieler.getGruppe_hor_vert().getSelection().getActionCommand()) {

				case "Horizontal":

					switch (Getter_Setter_Spieler.getGruppe_schiffe().getSelection().getActionCommand()) {

					case "Schlachtschiff":

						Getter_Setter_Listener_Spieler.setSchiff(0);
						Getter_Setter_Listener_Spieler.setSchiffl�nge(5);

						if (test_horizontal_schiff_in_der_n�he(Getter_Setter_Listener_Spieler.getSchiff(),
								Getter_Setter_Listener_Spieler.getSchiffl�nge())) {
							horizontal(Getter_Setter_Listener_Spieler.getSchiff(),
									Getter_Setter_Listener_Spieler.getSchiffl�nge());
						}

						break;

					case "Kreuzer":

						Getter_Setter_Listener_Spieler.setSchiff(1);
						Getter_Setter_Listener_Spieler.setSchiffl�nge(4);

						if (test_horizontal_schiff_in_der_n�he(Getter_Setter_Listener_Spieler.getSchiff(),
								Getter_Setter_Listener_Spieler.getSchiffl�nge())) {
							horizontal(Getter_Setter_Listener_Spieler.getSchiff(),
									Getter_Setter_Listener_Spieler.getSchiffl�nge());
						}

						break;

					case "Zerst\u00F6rer":

						Getter_Setter_Listener_Spieler.setSchiff(2);
						Getter_Setter_Listener_Spieler.setSchiffl�nge(3);

						if (test_horizontal_schiff_in_der_n�he(Getter_Setter_Listener_Spieler.getSchiff(),
								Getter_Setter_Listener_Spieler.getSchiffl�nge())) {
							horizontal(Getter_Setter_Listener_Spieler.getSchiff(),
									Getter_Setter_Listener_Spieler.getSchiffl�nge());
						}

						break;

					case "UBoot":

						Getter_Setter_Listener_Spieler.setSchiff(3);
						Getter_Setter_Listener_Spieler.setSchiffl�nge(2);

						if (test_horizontal_schiff_in_der_n�he(Getter_Setter_Listener_Spieler.getSchiff(),
								Getter_Setter_Listener_Spieler.getSchiffl�nge())) {
							horizontal(Getter_Setter_Listener_Spieler.getSchiff(),
									Getter_Setter_Listener_Spieler.getSchiffl�nge());
						}

						break;

					}

					break;

				case "Vertikal":

					switch (Getter_Setter_Spieler.getGruppe_schiffe().getSelection().getActionCommand()) {

					case "Schlachtschiff":

						Getter_Setter_Listener_Spieler.setSchiff(0);
						Getter_Setter_Listener_Spieler.setSchiffl�nge(5);

						if (test_vertikal_schiff_in_der_n�he(Getter_Setter_Listener_Spieler.getSchiff(),
								Getter_Setter_Listener_Spieler.getSchiffl�nge())) {
							vertikal(Getter_Setter_Listener_Spieler.getSchiff(),
									Getter_Setter_Listener_Spieler.getSchiffl�nge());
						}

						break;

					case "Kreuzer":

						Getter_Setter_Listener_Spieler.setSchiff(1);
						Getter_Setter_Listener_Spieler.setSchiffl�nge(4);

						if (test_vertikal_schiff_in_der_n�he(Getter_Setter_Listener_Spieler.getSchiff(),
								Getter_Setter_Listener_Spieler.getSchiffl�nge())) {
							vertikal(Getter_Setter_Listener_Spieler.getSchiff(),
									Getter_Setter_Listener_Spieler.getSchiffl�nge());
						}

						break;

					case "Zerst\u00F6rer":

						Getter_Setter_Listener_Spieler.setSchiff(2);
						Getter_Setter_Listener_Spieler.setSchiffl�nge(3);

						if (test_vertikal_schiff_in_der_n�he(Getter_Setter_Listener_Spieler.getSchiff(),
								Getter_Setter_Listener_Spieler.getSchiffl�nge())) {
							vertikal(Getter_Setter_Listener_Spieler.getSchiff(),
									Getter_Setter_Listener_Spieler.getSchiffl�nge());
						}

						break;

					case "UBoot":

						Getter_Setter_Listener_Spieler.setSchiff(3);
						Getter_Setter_Listener_Spieler.setSchiffl�nge(2);

						if (test_vertikal_schiff_in_der_n�he(Getter_Setter_Listener_Spieler.getSchiff(),
								Getter_Setter_Listener_Spieler.getSchiffl�nge())) {
							vertikal(Getter_Setter_Listener_Spieler.getSchiff(),
									Getter_Setter_Listener_Spieler.getSchiffl�nge());
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

		for (int j = Getter_Setter_Listener_Spieler.getBuchstabe(); j <= (Getter_Setter_Listener_Spieler.getBuchstabe()
				+ Schiffl�nge - 1); j++) {

			try {

				if (Color.decode("#f08080")
						.equals(Getter_Setter_Spieler.getButton_A0_bis_J9(j, Getter_Setter_Listener_Spieler.getZahl())
								.getBackground())
						|| Color.decode("#98FB98").equals(Getter_Setter_Spieler
								.getButton_A0_bis_J9(j, Getter_Setter_Listener_Spieler.getZahl()).getBackground())) {

					Getter_Setter_Spieler.getTextField_hinweis()
							.setText(Getter_Setter_Listener_Spieler.getAnderes_schiff_in_der_n�he());
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

		for (int i = Getter_Setter_Listener_Spieler.getBuchstabe(); i <= (Getter_Setter_Listener_Spieler.getBuchstabe()
				+ (Schiffl�nge - 1)); i++) {

			// Wenn es mehr als ein Schiff gibt
			if (Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText()) > 0) {

				// Wenn es nicht �ber die Kante geht
				if (!((Getter_Setter_Listener_Spieler.getBuchstabe() + (Schiffl�nge - 1)) > 9)) {

					Getter_Setter_Spieler.getButton_A0_bis_J9(i, Getter_Setter_Listener_Spieler.getZahl()).setText("X");

					// Rand au�endrum R�tlich f�rben
					for (int farbe_komplett = Getter_Setter_Listener_Spieler.getBuchstabe()
							- 1; farbe_komplett <= (Getter_Setter_Listener_Spieler.getBuchstabe()
									+ (Schiffl�nge)); farbe_komplett++) {

						for (int farbe_zahl = Getter_Setter_Listener_Spieler.getZahl()
								+ 1; farbe_zahl >= (Getter_Setter_Listener_Spieler.getZahl() - 1); farbe_zahl--) {

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

								if (!(farbe_komplett == Getter_Setter_Listener_Spieler.getBuchstabe() - 1
										|| farbe_komplett == Getter_Setter_Listener_Spieler.getBuchstabe()
												+ (Schiffl�nge))) {
									Getter_Setter_Spieler
											.getButton_A0_bis_J9(farbe_komplett,
													Getter_Setter_Listener_Spieler.getZahl())
											.setBackground(Color.decode("#98FB98"));
								}
							}

						}

					}

				} else {
					Getter_Setter_Spieler.getTextField_hinweis()
							.setText(Getter_Setter_Listener_Spieler.getNicht_platzierbar());
					Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));
					break;
				}

				if (i == Getter_Setter_Listener_Spieler.getBuchstabe() + (Schiffl�nge - 1)) {

					// Den Text setzen zu dem Text von vorher minus 1
					Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].setText(Integer.toString(
							Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText())
									- 1));

					Getter_Setter_Listener_Spieler.setSchiff_anzahl_insgesamt(
							Getter_Setter_Listener_Spieler.getSchiff_anzahl_insgesamt() - 1);

				}

			} else {
				Getter_Setter_Spieler.getTextField_hinweis()
						.setText(Getter_Setter_Listener_Spieler.getKeine_schiffe_mehr());
				Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));
				break;
			}

		}

		if (Getter_Setter_Listener_Spieler.getSchiff_anzahl_insgesamt() == 0) {

			Connecten_oder_Hosten window = new Connecten_oder_Hosten();
			window.frame_connecten_oder_hosten.setVisible(true);

		}

	}

	private static boolean test_vertikal_schiff_in_der_n�he(int Schiff, int Schiffl�nge) {

		for (int j = Getter_Setter_Listener_Spieler.getZahl(); j >= Getter_Setter_Listener_Spieler.getZahl()
				- Schiffl�nge + 1; j--) {

			try {

				if (Color.decode("#f08080")
						.equals(Getter_Setter_Spieler
								.getButton_A0_bis_J9(Getter_Setter_Listener_Spieler.getBuchstabe(), j).getBackground())
						|| Color.decode("#98FB98")
								.equals(Getter_Setter_Spieler
										.getButton_A0_bis_J9(Getter_Setter_Listener_Spieler.getBuchstabe(), j)
										.getBackground())) {

					Getter_Setter_Spieler.getTextField_hinweis()
							.setText(Getter_Setter_Listener_Spieler.getAnderes_schiff_in_der_n�he());
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

		for (int i = Getter_Setter_Listener_Spieler.getZahl(); i >= (Getter_Setter_Listener_Spieler.getZahl()
				- (Schiffl�nge - 1)); i--) {

			// Wenn es mehr als ein Schiff gibt
			if (Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText()) > 0) {

				// Wenn es nicht �ber die Kante geht
				if ((Getter_Setter_Listener_Spieler.getZahl() - (Schiffl�nge - 1)) >= 0) {

					Getter_Setter_Spieler.getButton_A0_bis_J9(Getter_Setter_Listener_Spieler.getBuchstabe(), i)
							.setText("X");

					// Rand au�endrum R�tlich f�rben
					for (int farbe_komplett = Getter_Setter_Listener_Spieler.getZahl()
							+ 1; farbe_komplett >= (Getter_Setter_Listener_Spieler.getZahl()
									- Schiffl�nge); farbe_komplett--) {

						for (int farbe_buchstabe = Getter_Setter_Listener_Spieler.getBuchstabe()
								- 1; farbe_buchstabe <= (Getter_Setter_Listener_Spieler.getBuchstabe()
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

								if (!(farbe_komplett == Getter_Setter_Listener_Spieler.getZahl() + 1
										|| farbe_komplett == Getter_Setter_Listener_Spieler.getZahl() - Schiffl�nge)) {
									Getter_Setter_Spieler
											.getButton_A0_bis_J9(Getter_Setter_Listener_Spieler.getBuchstabe(),
													farbe_komplett)
											.setBackground(Color.decode("#98FB98"));
								}
							}

						}

					}

				} else {
					Getter_Setter_Spieler.getTextField_hinweis()
							.setText(Getter_Setter_Listener_Spieler.getNicht_platzierbar());
					Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));
					break;
				}

				if (i == Getter_Setter_Listener_Spieler.getZahl() - (Schiffl�nge - 1)) {

					// Den Text setzen zu dem Text von vorher minus 1
					Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].setText(Integer.toString(
							Integer.parseInt(Getter_Setter_Spieler.getTextField_Anzahl_Schiffe()[Schiff].getText())
									- 1));

					Getter_Setter_Listener_Spieler.setSchiff_anzahl_insgesamt(
							Getter_Setter_Listener_Spieler.getSchiff_anzahl_insgesamt() - 1);

				}

			} else {
				Getter_Setter_Spieler.getTextField_hinweis()
						.setText(Getter_Setter_Listener_Spieler.getKeine_schiffe_mehr());
				Getter_Setter_Spieler.getTextField_hinweis().setBackground(Color.decode("#f08080"));
				break;
			}

		}

		if (Getter_Setter_Listener_Spieler.getSchiff_anzahl_insgesamt() == 0) {

			Connecten_oder_Hosten window = new Connecten_oder_Hosten();
			window.frame_connecten_oder_hosten.setVisible(true);

		}

	}

}
