package controller.threads.Buffered;

import java.io.BufferedWriter;
import java.io.IOException;

import controller.spielablauf.Verbindungsaufbau;

public class Thread_BufferedWriter extends Thread {

	private BufferedWriter bufferedWriter = null;

	public Thread_BufferedWriter(BufferedWriter bufferedWriter) {

		this.bufferedWriter = bufferedWriter;

	}

	public void run() {

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
