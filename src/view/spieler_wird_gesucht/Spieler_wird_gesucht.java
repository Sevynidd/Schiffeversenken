package view.spieler_wird_gesucht;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.getter_setter.view.Getter_Setter_Spieler_wird_gesucht;
import controller.spielablauf.Verbindungsaufbau;
import controller.threads.Thread_Spieler_wird_gesucht;

public class Spieler_wird_gesucht {

	
	public Spieler_wird_gesucht() {
		initialize();
	}

	private void initialize() {
		
																					//JFrame Spieler_wird_gesucht
		JFrame frame_spieler_wird_gesucht = new JFrame();
		frame_spieler_wird_gesucht.setVisible(true);
		frame_spieler_wird_gesucht.setAlwaysOnTop(true);
		frame_spieler_wird_gesucht.setResizable(false);
		frame_spieler_wird_gesucht.setBounds(300, 250, 500, 245);
		frame_spieler_wird_gesucht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_spieler_wird_gesucht.getContentPane().setLayout(null);
		
		Getter_Setter_Spieler_wird_gesucht.setFrame_spieler_wird_gesucht(frame_spieler_wird_gesucht);
																					//JProgressBar
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setLayout(null);
		progressBar.setBounds(10, 165, 466, 20);
		progressBar.setValue(0);
		frame_spieler_wird_gesucht.getContentPane().add(progressBar);
		
		Getter_Setter_Spieler_wird_gesucht gsswg = new Getter_Setter_Spieler_wird_gesucht();
		
		gsswg.setProgressBar(progressBar);
																					//JTextField
		JTextField txtSpielerWirdGesucht = new JTextField();
		txtSpielerWirdGesucht.setHorizontalAlignment(SwingConstants.CENTER);
		txtSpielerWirdGesucht.setText("Spieler wird gesucht ...");
		txtSpielerWirdGesucht.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSpielerWirdGesucht.setBounds(10, 39, 466, 50);
		txtSpielerWirdGesucht.setEditable(false);
		txtSpielerWirdGesucht.setFocusable(false);
		frame_spieler_wird_gesucht.getContentPane().add(txtSpielerWirdGesucht);
		
		Getter_Setter_Spieler_wird_gesucht.setTxtSpielerWirdGesucht(txtSpielerWirdGesucht);
		
		
		JButton btnSpielen = new JButton("Spielen");
		
		btnSpielen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSpielen.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						
						frame_spieler_wird_gesucht.setVisible(false);
						frame_spieler_wird_gesucht.dispose();
						
						Verbindungsaufbau vab = new Verbindungsaufbau();
						
					}
				});
				
			}
		});
		btnSpielen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSpielen.setBounds(196, 134, 85, 21);
		btnSpielen.setFocusable(false);
		btnSpielen.setVisible(false);
		frame_spieler_wird_gesucht.getContentPane().add(btnSpielen);
		
		Getter_Setter_Spieler_wird_gesucht.setBtnSpielen(btnSpielen);
		
		
		
		
		Thread_Spieler_wird_gesucht swg = new Thread_Spieler_wird_gesucht(gsswg);
		Thread spieler_wird_gesucht = new Thread(swg);
		spieler_wird_gesucht.start();
		
	}
}
