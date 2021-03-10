package controller.getter_setter.listnener;

public class Getter_Setter_Listener_Spieler {

	private static String nicht_platzierbar = "Das Schiff kann dort nicht platziert werden";
	private static String keine_schiffe_mehr = "Es gibt keine Schiffe mehr die man platzieren könnte";
	private static String hinweis_text = "Hier werden Hinweise stehen wenn ein Fehler auftritt";
	private static String anderes_schiff_in_der_nähe = "Das Schiff kann nicht platziert werden, da ein anderes Schiff zu nah "
			+ "am zu platzierenden Schiff liegt";

	private static int buchstabe;
	private static int zahl;
	private static int schiff;
	private static int schifflänge;

	private static int schiff_anzahl_insgesamt;

	public static String getNicht_platzierbar() {
		return nicht_platzierbar;
	}

	public static String getKeine_schiffe_mehr() {
		return keine_schiffe_mehr;
	}

	public static String getHinweis_text() {
		return hinweis_text;
	}

	public static String getAnderes_schiff_in_der_nähe() {
		return anderes_schiff_in_der_nähe;
	}

	public static int getBuchstabe() {
		return buchstabe;
	}

	public static void setBuchstabe(int buchstabe) {
		Getter_Setter_Listener_Spieler.buchstabe = buchstabe;
	}

	public static int getZahl() {
		return zahl;
	}

	public static void setZahl(int zahl) {
		Getter_Setter_Listener_Spieler.zahl = zahl;
	}

	public static int getSchiff() {
		return schiff;
	}

	public static void setSchiff(int schiff) {
		Getter_Setter_Listener_Spieler.schiff = schiff;
	}

	public static int getSchifflänge() {
		return schifflänge;
	}

	public static void setSchifflänge(int schifflänge) {
		Getter_Setter_Listener_Spieler.schifflänge = schifflänge;
	}

	public static int getSchiff_anzahl_insgesamt() {
		return schiff_anzahl_insgesamt;
	}

	public static void setSchiff_anzahl_insgesamt(int schiff_anzahl_insgesamt) {
		Getter_Setter_Listener_Spieler.schiff_anzahl_insgesamt = schiff_anzahl_insgesamt;
	}

}
