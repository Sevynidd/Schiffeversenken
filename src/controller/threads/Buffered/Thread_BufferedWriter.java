package controller.threads.Buffered;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import controller.getter_setter.threads.Getter_Setter_Thread_empfangen;
import controller.spielablauf.Verbindungsaufbau;

public class Thread_BufferedWriter extends Thread {

	private Socket client;
	private BufferedWriter bufferedWriter = null;

	public Thread_BufferedWriter(Socket client, BufferedWriter bufferedWriter) {

		this.client = client;
		this.bufferedWriter = bufferedWriter;

	}

	public void run() {

		// Hosten
		if (Getter_Setter_Thread_empfangen.getBtnClicked(0) && !Getter_Setter_Thread_empfangen.getBtnClicked(1)) {

			try {

				OutputStream oS = client.getOutputStream();
				OutputStreamWriter oSW = new OutputStreamWriter(oS);
				bufferedWriter = new BufferedWriter(oSW);

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			schreiben();

			// Connecten
		} else if (Getter_Setter_Thread_empfangen.getBtnClicked(1)
				&& !Getter_Setter_Thread_empfangen.getBtnClicked(0)) {

			schreiben();

		}

	}

	private void schreiben() {

		while (true) {

			if (!(Verbindungsaufbau.nachricht_bufferedWriter == null)) {

				try {
					bufferedWriter.write(Verbindungsaufbau.nachricht_bufferedWriter);
					bufferedWriter.newLine();
					bufferedWriter.flush();

				} catch (IOException e) {
					e.printStackTrace();
				}

				Verbindungsaufbau.nachricht_bufferedWriter = null;

			}

		}

	}

}
