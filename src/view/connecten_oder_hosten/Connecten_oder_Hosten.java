package view.connecten_oder_hosten;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.getter_setter.threads.Getter_Setter_Thread_empfangen;
import controller.getter_setter.view.Getter_Setter_Connecten_oder_Hosten;
import controller.listener.Listener_Connecten_oder_Hosten;

public class Connecten_oder_Hosten {

	public JFrame frame_connecten_oder_hosten;

	private JTextField txtConnectenOderHosten;

	public Connecten_oder_Hosten() {
		initialize();
	}

	private void initialize() {

		Getter_Setter_Thread_empfangen.setBtnClicked(false, 0);
		Getter_Setter_Thread_empfangen.setBtnClicked(false, 1);

		frame_connecten_oder_hosten = new JFrame();
		frame_connecten_oder_hosten.setResizable(false);
		frame_connecten_oder_hosten.setAlwaysOnTop(true);
		frame_connecten_oder_hosten.setBounds(300, 200, 450, 250);
		frame_connecten_oder_hosten.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_connecten_oder_hosten.getContentPane().setLayout(null);

		txtConnectenOderHosten = new JTextField();
		txtConnectenOderHosten.setBackground(Color.LIGHT_GRAY);
		txtConnectenOderHosten.setText("Connecten oder Hosten?");
		txtConnectenOderHosten.setHorizontalAlignment(SwingConstants.CENTER);
		txtConnectenOderHosten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtConnectenOderHosten.setEditable(false);
		txtConnectenOderHosten.setFocusable(false);
		txtConnectenOderHosten.setBounds(10, 10, 415, 40);
		frame_connecten_oder_hosten.getContentPane().add(txtConnectenOderHosten);
		txtConnectenOderHosten.setColumns(10);

		/*
		 * Die beiden Buttons Connecten und Hosten werden erstellt, beide werden im
		 * Getter/Setter hinterlegt und beide bekommen einen Button Listener
		 */

		JButton btnConnecten = new JButton("Connecten");

		btnConnecten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConnecten.setActionCommand("btnConnecten");
		btnConnecten.setBounds(10, 93, 206, 65);
		btnConnecten.setFocusable(false);

		Getter_Setter_Connecten_oder_Hosten.setBtnConnecten(btnConnecten);

		Listener_Connecten_oder_Hosten.buttonListener_Connecten_oder_Hosten(btnConnecten, frame_connecten_oder_hosten);

		frame_connecten_oder_hosten.getContentPane().add(btnConnecten);

		JButton btnHosten = new JButton("Hosten");
		btnHosten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHosten.setActionCommand("btnHosten");
		btnHosten.setBounds(219, 93, 206, 65);
		btnHosten.setFocusable(false);

		Getter_Setter_Connecten_oder_Hosten.setBtnHosten(btnHosten);

		Listener_Connecten_oder_Hosten.buttonListener_Connecten_oder_Hosten(btnHosten, frame_connecten_oder_hosten);

		frame_connecten_oder_hosten.getContentPane().add(btnHosten);
	}
}
