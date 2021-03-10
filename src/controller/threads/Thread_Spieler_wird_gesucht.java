package controller.threads;

import controller.getter_setter.view.Getter_Setter_Spieler_wird_gesucht;

public class Thread_Spieler_wird_gesucht implements Runnable {

	private int value = 0;
	private Getter_Setter_Spieler_wird_gesucht gsswg;

	public Thread_Spieler_wird_gesucht(Getter_Setter_Spieler_wird_gesucht gsswg) {
		this.gsswg = gsswg;
	}

	// Das ist der Thread um die Progressbar dauerhaft durchlaufen zu lassen

	public void run() {

		while (true) {
			while (value <= 100) {
				
				value += 1;
				
				gsswg.getProgressBar().setValue(value);


				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				/*
				 * Wenn die Progressbar bei 100% ist und der Text "Spieler gefunden ..."
				 * enthällt, dann werden beide while-Schleifen beendet
				 */

				if (value == 100 && Getter_Setter_Spieler_wird_gesucht.getTxtSpielerWirdGesucht().getText()
						.contains("Spieler gefunden ...")) {

					break;
				}

			}

			if (value == 100 && Getter_Setter_Spieler_wird_gesucht.getTxtSpielerWirdGesucht().getText()
					.contains("Spieler gefunden ...")) {

				break;
			}

			value = 0;
		}
	}

}
