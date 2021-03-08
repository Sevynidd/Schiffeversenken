package controller.threads;

import controller.getter_setter.threads.Getter_Setter_Thread_beenden;
import controller.getter_setter.view.Getter_Setter_Spieler_wird_gesucht;

public class Thread_Spieler_wird_gesucht implements Runnable{

	private int value = 0;
	private Getter_Setter_Spieler_wird_gesucht gsswg;
	
	public Thread_Spieler_wird_gesucht(Getter_Setter_Spieler_wird_gesucht gsswg) {
		this.gsswg = gsswg;
	}
	
	// Das ist der Thread um die Progressbar dauerhaft durchlaufen zu lassen
	
	public void run() {
		
		while(!Getter_Setter_Thread_beenden.isBeenden()) {
			while(value <= 100) {
				gsswg.getProgressBar().setValue(value);
				
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
