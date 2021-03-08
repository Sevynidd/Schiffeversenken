package controller.threads.empfangen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import controller.getter_setter.view.Getter_Setter_Gegner;
import controller.listener.Listener_Connecten_oder_Hosten;

public class Thread_empfangen_BufferedReader implements Runnable {

	//private String adresse = Getter_Setter_Thread_empfangen.getSenderAdresse().getHostAddress().substring(1,
			//Getter_Setter_Thread_empfangen.getSenderAdresse().getHostAddress().length());

	public static Socket input;
	private Integer[] koordinaten = new Integer[2];

	public void run() {

		BufferedReader bufferedReader = null;

		try {
			
			Listener_Connecten_oder_Hosten.socket.close();
			
			input = new Socket("localhost", 42069);
			
			InputStream in_st = input.getInputStream();
			InputStreamReader in_st_re = new InputStreamReader(in_st);
			bufferedReader = new BufferedReader(in_st_re);

		} catch (IOException e) {
		}

		while (true) {

			String nachricht = null;

			try {

				nachricht = bufferedReader.readLine();

				System.out.println(nachricht);

			} catch (IOException ioe) {
				continue;
			}

			if (!nachricht.contains(null)) {

				if (nachricht.contains("Fire")) {

					String[] ergebnis = nachricht.split(",");
					
					koordinaten[0] = Integer.parseInt(ergebnis[1]);
					koordinaten[1] = Integer.parseInt(ergebnis[2]);

					Getter_Setter_Gegner.getButton_A0_bis_J9(koordinaten[0], koordinaten[1]).setText("X");
					
				}

			}

		}

	}

}
