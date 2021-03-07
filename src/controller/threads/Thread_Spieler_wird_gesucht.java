package controller.threads;

import controller.getter_setter.threads.Getter_Setter_Thread_beenden;
import controller.getter_setter.view.Getter_Setter_Spieler_wird_gesucht;

public class Thread_Spieler_wird_gesucht implements Runnable{

	private int value = 0;
	
	public void run() {
		
		while(!Getter_Setter_Thread_beenden.isBeenden()) {
			while(value <= 100) {
				Getter_Setter_Spieler_wird_gesucht.getProgressBar().setValue(value);
				
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
