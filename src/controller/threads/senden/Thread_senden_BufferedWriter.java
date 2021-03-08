package controller.threads.senden;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import controller.threads.empfangen.Thread_empfangen_BufferedReader;

public class Thread_senden_BufferedWriter {

	public void schicken(String nachricht) {

		BufferedWriter bufferedWriter = null;

		try {
			OutputStream os = Thread_empfangen_BufferedReader.input.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			bufferedWriter = new BufferedWriter(osw);

			bufferedWriter.write(nachricht);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			bufferedWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
