package controller.spielablauf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.getter_setter.threads.Getter_Setter_Thread_empfangen;
import controller.getter_setter.view.Getter_Setter_Gegner;
import controller.listener.Listener_Connecten_oder_Hosten;
import controller.threads.Buffered.Thread_BufferedReader;
import controller.threads.Buffered.Thread_BufferedWriter;

public class Verbindungsaufbau {

	private Socket socket_client;
	private ServerSocket socket_host;
	public static volatile String nachricht_bufferedWriter = null;
	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;

	public void thread_starten() {

		Listener_Connecten_oder_Hosten.socket.close();

		// Hosten
		if (Getter_Setter_Thread_empfangen.getBtnClicked(0) && !Getter_Setter_Thread_empfangen.getBtnClicked(1)) {

			
			try {
				
				socket_host = new ServerSocket(42069);

				System.out.println("Warten auf einen Client am Port " + socket_host.getLocalPort() + "\n");

				Socket client = socket_host.accept();

				System.out.println("Client ist verbunden.");
				
				Getter_Setter_Gegner.setSchuss_setzen_erlaubt(true);

				Thread_BufferedWriter thread = new Thread_BufferedWriter(client, null);
				thread.start();
				
				Thread_BufferedReader tsbw = new Thread_BufferedReader(client,null);
				Thread thread_writer = new Thread(tsbw);
				thread_writer.start();
				

			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Connecten
		} else if (Getter_Setter_Thread_empfangen.getBtnClicked(1)
				&& !Getter_Setter_Thread_empfangen.getBtnClicked(0)) {

			try {
				
				socket_client = new Socket(Getter_Setter_Thread_empfangen.getConnectAdresse(), 42069);

				InputStream in_st = socket_client.getInputStream();
				InputStreamReader in_st_re = new InputStreamReader(in_st);
				bufferedReader = new BufferedReader(in_st_re);

				OutputStream os = socket_client.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				bufferedWriter = new BufferedWriter(osw);

			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			
			Thread_BufferedWriter thread = new Thread_BufferedWriter(null, bufferedWriter);
			thread.start();
			
			Thread_BufferedReader tsbw = new Thread_BufferedReader(null, bufferedReader);
			Thread thread_writer = new Thread(tsbw);
			thread_writer.start();

		}

	}

	


}
