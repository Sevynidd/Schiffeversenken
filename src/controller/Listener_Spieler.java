package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Listener_Spieler {

	private static String nicht_platzierbar = "Das Schiff kann dort nicht platziert werden";
	private static String keine_schiffe_mehr = "Es gibt keine Schiffe mehr die man platzieren könnte";
	private static String hinweis_text = "Hier werden Hinweise stehen wenn ein Fehler auftritt";

	public static void buttonListener(JButton button_ausgewählt) {
		button_ausgewählt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent cursor) {
				
				// Hinweistext zurücksetzen und auf die normale Farbe

				Getter_Setter.getTextField_hinweis().setText(hinweis_text);
				Getter_Setter.getTextField_hinweis().setBackground(new Color(222, 222, 222));

				// Die Daten die durch den Button gereicht werden aufteilen
				int buchstabe = Integer.parseInt(button_ausgewählt.getActionCommand().split(" ")[0]);
				int zahl = Integer.parseInt(button_ausgewählt.getActionCommand().split(" ")[1]);

				
				// Welcher ist aktiv? Horizontal oder Vertikal
				switch (Getter_Setter.getGruppe_hor_vert().getSelection().getActionCommand()) {

				case "Horizontal":
					
					// Welcher von den 4 Schiffsbuttons ist aktiv?
					switch (Getter_Setter.getGruppe_schiffe().getSelection().getActionCommand()) {

					case "Schlachtschiff":
						
						//Länge vom Schiff
						for (int i = buchstabe; i <= (buchstabe + 4); i++) {

							// Wenn es mehr als ein Schiff gibt
							if (Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[0].getText()) > 0) {

								// Wenn es nicht über die Kante geht
								if (!((buchstabe + 4) > 9)) {

									Getter_Setter.getButton_A0_bis_J9(i, zahl).setText("X");

									// Rand außendrum Rötlich färben
									// farbe_komplett geht am schiff entlang (wie for-Schleife i)
									for (int farbe_komplett = buchstabe - 1; farbe_komplett <= (buchstabe
											+ 5); farbe_komplett++) {

										// farbe_zahl geht durch die Reihen
										for (int farbe_zahl = zahl + 1; farbe_zahl >= (zahl - 1); farbe_zahl--) {

											/*
											 * for-Schleife m visiert immer nur einen bestimmten Button an
											 * Wenn ein Fehler auftritt (IndexOutOfBounds), dann wird dieser
											 * eine Button übersprungen
											 */
											for (int m = 0; m <= 1; m++) {

												try {
													
													Getter_Setter.getButton_A0_bis_J9(farbe_komplett, farbe_zahl)
													.setBackground(Color.decode("#f08080"));
													

												} catch (IndexOutOfBoundsException iaob) {
													continue;
												}
											}

											for (int n = 0; n <= 1; n++) {
												// Grün

												if (!(farbe_komplett == buchstabe - 1
														|| farbe_komplett == buchstabe + 5)) {
													Getter_Setter.getButton_A0_bis_J9(farbe_komplett, zahl)
															.setBackground(Color.decode("#98FB98"));
												}
											}

										}

									}

								} else {
									Getter_Setter.getTextField_hinweis().setText(nicht_platzierbar);
									Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
									break;
								}
								
								
								/*
								 *  Wenn das letzte X platziert wird, dann wird die Anzahl der zu
								 *  platzierenden Schiffe um eins reduziert
								 */
								if (i == buchstabe + 4) {

									// Den Text setzen zu dem Text von vorher minus 1
									Getter_Setter.getTextField_Anzahl_Schiffe()[0].setText(Integer.toString(
											Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[0].getText())
													- 1));

								}

							} else {
								Getter_Setter.getTextField_hinweis().setText(keine_schiffe_mehr);
								Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
								break;
							}

						}

						break;

					case "Kreuzer":

						for (int j = buchstabe; j <= (buchstabe + 3); j++) {

							// Wenn es mehr als ein Schiff gibt
							if (Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[1].getText()) > 0) {

								// Wenn es nicht über die Kante geht
								if (!((buchstabe + 3) > 9)) {
									Getter_Setter.getButton_A0_bis_J9(j, zahl).setText("X");

									// Rand außendrum Rötlich färben
									for (int farbe_komplett = buchstabe - 1; farbe_komplett <= (buchstabe
											+ 4); farbe_komplett++) {

										for (int farbe_zahl = zahl + 1; farbe_zahl >= (zahl - 1); farbe_zahl--) {

											for (int m = 0; m <= 1; m++) {

												try {

													Getter_Setter.getButton_A0_bis_J9(farbe_komplett, farbe_zahl)
															.setBackground(Color.decode("#f08080"));
	

												} catch (IndexOutOfBoundsException iaob) {
													continue;
												}
											}

											for (int n = 0; n <= 1; n++) {
												// Grün

												if (!(farbe_komplett == buchstabe - 1
														|| farbe_komplett == buchstabe + 4)) {
													Getter_Setter.getButton_A0_bis_J9(farbe_komplett, zahl)
															.setBackground(Color.decode("#98FB98"));
												}
											}

										}

									}

								} else {
									Getter_Setter.getTextField_hinweis().setText(nicht_platzierbar);
									Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
									break;
								}

								if (j == buchstabe + 3) {

									// Den Text setzen zu dem Text von vorher minus 1
									Getter_Setter.getTextField_Anzahl_Schiffe()[1].setText(Integer.toString(
											Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[1].getText())
													- 1));

								}

							} else {
								Getter_Setter.getTextField_hinweis().setText(keine_schiffe_mehr);
								Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
								break;
							}

						}

						break;

					case "Zerst\u00F6rer":

						for (int k = buchstabe; k <= (buchstabe + 2); k++) {

							// Wenn es mehr als ein Schiff gibt
							if (Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[2].getText()) > 0) {

								// Wenn es nicht über die Kante geht
								if (!((buchstabe + 2) > 9)) {
									Getter_Setter.getButton_A0_bis_J9(k, zahl).setText("X");

									// Rand außendrum Rötlich färben
									for (int farbe_komplett = buchstabe - 1; farbe_komplett <= (buchstabe
											+ 3); farbe_komplett++) {

										for (int farbe_zahl = zahl + 1; farbe_zahl >= (zahl - 1); farbe_zahl--) {

											for (int m = 0; m <= 1; m++) {

												try {
													// Links
													Getter_Setter.getButton_A0_bis_J9(farbe_komplett, farbe_zahl)
															.setBackground(Color.decode("#f08080"));


												} catch (IndexOutOfBoundsException iaob) {
													continue;
												}
											}

											for (int n = 0; n <= 1; n++) {
												// Grün

												if (!(farbe_komplett == buchstabe - 1
														|| farbe_komplett == buchstabe + 3)) {
													Getter_Setter.getButton_A0_bis_J9(farbe_komplett, zahl)
															.setBackground(Color.decode("#98FB98"));
												}
											}

										}

									}

								} else {
									Getter_Setter.getTextField_hinweis().setText(nicht_platzierbar);
									Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
									break;
								}

								if (k == buchstabe + 2) {

									// Den Text setzen zu dem Text von vorher minus 1
									Getter_Setter.getTextField_Anzahl_Schiffe()[2].setText(Integer.toString(
											Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[2].getText())
													- 1));

								}

							} else {
								Getter_Setter.getTextField_hinweis().setText(keine_schiffe_mehr);
								Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
								break;
							}

						}

						break;

					case "UBoot":

						for (int n = buchstabe; n <= (buchstabe + 1); n++) {

							// Wenn es mehr als ein Schiff gibt
							if (Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[3].getText()) > 0) {

								// Wenn es nicht über die Kante geht
								if (!((buchstabe + 1) > 9)) {
									Getter_Setter.getButton_A0_bis_J9(n, zahl).setText("X");

									// Rand außendrum Rötlich färben
									for (int farbe_komplett = buchstabe - 1; farbe_komplett <= (buchstabe
											+ 2); farbe_komplett++) {

										for (int farbe_zahl = zahl + 1; farbe_zahl >= (zahl - 1); farbe_zahl--) {

											for (int m = 0; m <= 1; m++) {

												try {
													
													Getter_Setter.getButton_A0_bis_J9(farbe_komplett, farbe_zahl)
															.setBackground(Color.decode("#f08080"));

													
												} catch (IndexOutOfBoundsException iaob) {
													continue;
												}
											}

											for (int l = 0; l <= 1; l++) {
												// Grün

												if (!(farbe_komplett == buchstabe - 1
														|| farbe_komplett == buchstabe + 2)) {
													Getter_Setter.getButton_A0_bis_J9(farbe_komplett, zahl)
															.setBackground(Color.decode("#98FB98"));
												}
											}

										}

									}

								} else {
									Getter_Setter.getTextField_hinweis().setText(nicht_platzierbar);
									Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
									break;
								}

								if (n == buchstabe + 1) {

									// Den Text setzen zu dem Text von vorher minus 1
									Getter_Setter.getTextField_Anzahl_Schiffe()[3].setText(Integer.toString(
											Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[3].getText())
													- 1));

								}

							} else {
								Getter_Setter.getTextField_hinweis().setText(keine_schiffe_mehr);
								Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
								break;
							}

						}

						break;

					}

					break;
				case "Vertikal":

					switch (Getter_Setter.getGruppe_schiffe().getSelection().getActionCommand()) {

					case "Schlachtschiff":

						for (int i = zahl; i >= (zahl - 4); i--) {

							// Wenn es mehr als ein Schiff gibt
							if (Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[0].getText()) > 0) {

								// Wenn es nicht über die Kante geht
								if ((zahl - 4) >= 0) {

									Getter_Setter.getButton_A0_bis_J9(buchstabe, i).setText("X");

									// Rand außendrum Rötlich färben
									for (int farbe_komplett = zahl + 1; farbe_komplett >= (zahl
											- 5); farbe_komplett--) {
										

										for (int farbe_buchstabe = buchstabe - 1; farbe_buchstabe <= (buchstabe + 1); farbe_buchstabe++) {
											
											for (int m = 0; m <= 1; m++) {

												try {
													
													Getter_Setter.getButton_A0_bis_J9(farbe_buchstabe, farbe_komplett)
													.setBackground(Color.decode("#f08080"));
														

												} catch (IndexOutOfBoundsException iaob) {
													continue;
												}
											}

											for (int n = 0; n <= 1; n++) {
												// Grün

												if (!(farbe_komplett == zahl + 1
														|| farbe_komplett == zahl - 5)) {
													Getter_Setter.getButton_A0_bis_J9(buchstabe, farbe_komplett)
															.setBackground(Color.decode("#98FB98"));
												}
											}

										}

									}

								} else {
									Getter_Setter.getTextField_hinweis().setText(nicht_platzierbar);
									Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
									break;
								}

								if (i == zahl - 4) {

									// Den Text setzen zu dem Text von vorher minus 1
									Getter_Setter.getTextField_Anzahl_Schiffe()[0].setText(Integer.toString(
											Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[0].getText())
													- 1));

								}

							} else {
								Getter_Setter.getTextField_hinweis().setText(keine_schiffe_mehr);
								Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
								break;
							}

						}

						break;

					case "Kreuzer":

						for (int i = zahl; i >= (zahl - 3); i--) {

							// Wenn es mehr als ein Schiff gibt
							if (Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[1].getText()) > 0) {

								// Wenn es nicht über die Kante geht
								if ((zahl - 3) >= 0) {

									Getter_Setter.getButton_A0_bis_J9(buchstabe, i).setText("X");

									// Rand außendrum Rötlich färben
									for (int farbe_komplett = zahl + 1; farbe_komplett >= (zahl
											- 4); farbe_komplett--) {
										

										for (int farbe_buchstabe = buchstabe - 1; farbe_buchstabe <= (buchstabe + 1); farbe_buchstabe++) {
											
											for (int m = 0; m <= 1; m++) {

												try {
													
													Getter_Setter.getButton_A0_bis_J9(farbe_buchstabe, farbe_komplett)
													.setBackground(Color.decode("#f08080"));
														

												} catch (IndexOutOfBoundsException iaob) {
													continue;
												}
											}

											for (int n = 0; n <= 1; n++) {
												// Grün

												if (!(farbe_komplett == zahl + 1
														|| farbe_komplett == zahl - 4)) {
													Getter_Setter.getButton_A0_bis_J9(buchstabe, farbe_komplett)
															.setBackground(Color.decode("#98FB98"));
												}
											}

										}

									}

								} else {
									Getter_Setter.getTextField_hinweis().setText(nicht_platzierbar);
									Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
									break;
								}

								if (i == zahl - 3) {

									// Den Text setzen zu dem Text von vorher minus 1
									Getter_Setter.getTextField_Anzahl_Schiffe()[1].setText(Integer.toString(
											Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[1].getText())
													- 1));

								}

							} else {
								Getter_Setter.getTextField_hinweis().setText(keine_schiffe_mehr);
								Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
								break;
							}

						}

						break;

					case "Zerst\u00F6rer":

						for (int i = zahl; i >= (zahl - 2); i--) {

							// Wenn es mehr als ein Schiff gibt
							if (Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[2].getText()) > 0) {

								// Wenn es nicht über die Kante geht
								if ((zahl - 2) >= 0) {

									Getter_Setter.getButton_A0_bis_J9(buchstabe, i).setText("X");

									// Rand außendrum Rötlich färben
									for (int farbe_komplett = zahl + 1; farbe_komplett >= (zahl
											- 3); farbe_komplett--) {
										

										for (int farbe_buchstabe = buchstabe - 1; farbe_buchstabe <= (buchstabe + 1); farbe_buchstabe++) {
											
											for (int m = 0; m <= 1; m++) {

												try {
													
													Getter_Setter.getButton_A0_bis_J9(farbe_buchstabe, farbe_komplett)
													.setBackground(Color.decode("#f08080"));
														

												} catch (IndexOutOfBoundsException iaob) {
													continue;
												}
											}

											for (int n = 0; n <= 1; n++) {
												// Grün

												if (!(farbe_komplett == zahl + 1
														|| farbe_komplett == zahl - 3)) {
													Getter_Setter.getButton_A0_bis_J9(buchstabe, farbe_komplett)
															.setBackground(Color.decode("#98FB98"));
												}
											}

										}

									}

								} else {
									Getter_Setter.getTextField_hinweis().setText(nicht_platzierbar);
									Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
									break;
								}

								if (i == zahl - 2) {

									// Den Text setzen zu dem Text von vorher minus 1
									Getter_Setter.getTextField_Anzahl_Schiffe()[2].setText(Integer.toString(
											Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[2].getText())
													- 1));

								}

							} else {
								Getter_Setter.getTextField_hinweis().setText(keine_schiffe_mehr);
								Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
								break;
							}

						}

						break;

					case "UBoot":

						for (int i = zahl; i >= (zahl - 1); i--) {

							// Wenn es mehr als ein Schiff gibt
							if (Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[3].getText()) > 0) {

								// Wenn es nicht über die Kante geht
								if ((zahl - 1) >= 0) {

									Getter_Setter.getButton_A0_bis_J9(buchstabe, i).setText("X");

									// Rand außendrum Rötlich färben
									for (int farbe_komplett = zahl + 1; farbe_komplett >= (zahl
											- 2); farbe_komplett--) {
										

										for (int farbe_buchstabe = buchstabe - 1; farbe_buchstabe <= (buchstabe + 1); farbe_buchstabe++) {
											
											for (int m = 0; m <= 1; m++) {

												try {
													
													Getter_Setter.getButton_A0_bis_J9(farbe_buchstabe, farbe_komplett)
													.setBackground(Color.decode("#f08080"));
														

												} catch (IndexOutOfBoundsException iaob) {
													continue;
												}
											}

											for (int n = 0; n <= 1; n++) {
												// Grün

												if (!(farbe_komplett == zahl + 1
														|| farbe_komplett == zahl - 2)) {
													Getter_Setter.getButton_A0_bis_J9(buchstabe, farbe_komplett)
															.setBackground(Color.decode("#98FB98"));
												}
											}

										}

									}

								} else {
									Getter_Setter.getTextField_hinweis().setText(nicht_platzierbar);
									Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
									break;
								}

								if (i == zahl - 4) {

									// Den Text setzen zu dem Text von vorher minus 1
									Getter_Setter.getTextField_Anzahl_Schiffe()[3].setText(Integer.toString(
											Integer.parseInt(Getter_Setter.getTextField_Anzahl_Schiffe()[3].getText())
													- 1));

								}

							} else {
								Getter_Setter.getTextField_hinweis().setText(keine_schiffe_mehr);
								Getter_Setter.getTextField_hinweis().setBackground(Color.decode("#f08080"));
								break;
							}

						}

						break;

					}

					break;

				}

			}

		});
	}

}
