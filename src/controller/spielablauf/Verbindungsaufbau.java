package controller.spielablauf;

import controller.threads.empfangen.Thread_empfangen_BufferedReader;
import controller.threads.senden.Thread_senden_BufferedWriter;

public class Verbindungsaufbau {

	
	public void thread_starten() {
		
		Thread_empfangen_BufferedReader tebr = new Thread_empfangen_BufferedReader();
		Thread thread_reader = new Thread(tebr);
		thread_reader.start();
		
	}
	
}
