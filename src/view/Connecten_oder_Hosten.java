package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.listener.Listener_Connecten_oder_Hosten;

import javax.swing.JButton;

public class Connecten_oder_Hosten {

	public JFrame frame_connecten_oder_hosten;
	private JTextField txtMchtestDuHosten;
	
	public static void main(String[] args) {
		Connecten_oder_Hosten c_o_h = new Connecten_oder_Hosten();
		c_o_h.frame_connecten_oder_hosten.setVisible(true);
	}

	public Connecten_oder_Hosten() {
		initialize();
	}

	private void initialize() {
		frame_connecten_oder_hosten = new JFrame();
		frame_connecten_oder_hosten.setAlwaysOnTop(true);
		frame_connecten_oder_hosten.setBounds(550, 300, 450, 300);
		frame_connecten_oder_hosten.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame_connecten_oder_hosten.getContentPane().setLayout(null);
		
		
		txtMchtestDuHosten = new JTextField();
		txtMchtestDuHosten.setHorizontalAlignment(SwingConstants.CENTER);
		txtMchtestDuHosten.setBackground(Color.WHITE);
		txtMchtestDuHosten.setText("M\u00F6chtest du Hosten oder Beitreten?");
		txtMchtestDuHosten.setEditable(false);
		txtMchtestDuHosten.setFocusable(false);
		txtMchtestDuHosten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMchtestDuHosten.setBounds(10, 35, 414, 40);
		frame_connecten_oder_hosten.getContentPane().add(txtMchtestDuHosten);
		
		JButton btnHosten = new JButton("Hosten");
		btnHosten.setActionCommand("Hosten");
		btnHosten.setBackground(new Color(187, 255, 255));
		btnHosten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHosten.setBounds(10, 115, 207, 40);
		frame_connecten_oder_hosten.getContentPane().add(btnHosten);
		
		Listener_Connecten_oder_Hosten.buttonListener_Hosten(btnHosten, frame_connecten_oder_hosten);
		
		JButton btnConnecten = new JButton("Beitreten");
		btnConnecten.setActionCommand("Beitreten");
		btnConnecten.setBackground(new Color(127, 255, 212));
		btnConnecten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConnecten.setBounds(217, 115, 207, 40);
		frame_connecten_oder_hosten.getContentPane().add(btnConnecten);
		
		Listener_Connecten_oder_Hosten.buttonListener_Connecten(btnConnecten, frame_connecten_oder_hosten);
			
	}
}
