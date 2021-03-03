package view.spieler_wird_gesucht;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.getter_setter.view.Getter_Setter_Spieler_wird_gesucht;
import controller.threads.Thread_Spieler_wird_gesucht;

public class Spieler_wird_gesucht {

	
	public Spieler_wird_gesucht() {
		initialize();
	}

	private void initialize() {
		
		JFrame frame_spieler_wird_gesucht = new JFrame();
		frame_spieler_wird_gesucht.setAlwaysOnTop(true);
		frame_spieler_wird_gesucht.setResizable(false);
		frame_spieler_wird_gesucht.setBounds(300, 250, 500, 245);
		frame_spieler_wird_gesucht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_spieler_wird_gesucht.getContentPane().setLayout(null);
		
		Getter_Setter_Spieler_wird_gesucht.setFrame_spieler_wird_gesucht(frame_spieler_wird_gesucht);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setLayout(null);
		progressBar.setBounds(10, 165, 466, 20);
		progressBar.setValue(0);
		frame_spieler_wird_gesucht.getContentPane().add(progressBar);
		
		Getter_Setter_Spieler_wird_gesucht.setProgressBar(progressBar);
		
		JTextField txtSpielerWirdGesucht = new JTextField();
		txtSpielerWirdGesucht.setHorizontalAlignment(SwingConstants.CENTER);
		txtSpielerWirdGesucht.setText("Spieler wird gesucht ...");
		txtSpielerWirdGesucht.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSpielerWirdGesucht.setBounds(10, 39, 466, 50);
		txtSpielerWirdGesucht.setEditable(false);
		txtSpielerWirdGesucht.setFocusable(false);
		frame_spieler_wird_gesucht.getContentPane().add(txtSpielerWirdGesucht);
		
		Getter_Setter_Spieler_wird_gesucht.setTxtSpielerWirdGesucht(txtSpielerWirdGesucht);
		
		Thread_Spieler_wird_gesucht swg = new Thread_Spieler_wird_gesucht();
		Thread spieler_wird_gesucht = new Thread(swg);
		spieler_wird_gesucht.start();
		
	}
}
