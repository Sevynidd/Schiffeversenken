package controller.threads.spieler_wird_gesucht;

import view.spieler_wird_gesucht.Spieler_wird_gesucht;

public class Thread_Spieler_wird_gesucht implements Runnable{

	private int value = 0;
	
	public void run() {
		
		while(true) {
			while(value <= 100) {
				Spieler_wird_gesucht.progressBar.setValue(value);
				
				value+=1;
				
				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			value=0;
		}
	}

}
