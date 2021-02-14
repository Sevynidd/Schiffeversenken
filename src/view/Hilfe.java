package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Hilfe {

	private JFrame hilfe_fenster;
	private int width = 650;
	private int highth = 150;

	public Hilfe() {
		initialize();
	}

	private void initialize() {
		hilfe_fenster = new JFrame();
		hilfe_fenster.setTitle("Hilfe");
		hilfe_fenster.setVisible(true);
		hilfe_fenster.getContentPane().setBackground(Color.WHITE);
		hilfe_fenster.getContentPane().setLayout(null);
		hilfe_fenster.setBounds(200, 200, width, highth);
		hilfe_fenster.setResizable(false);
		hilfe_fenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(0, 0, width-6, highth-29);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea.setText("Schiffplatzierung: \n\n" 
				+ "Bei Horizontal wird immer das linke Ende des Schiffes mit dem Mausklick platziert \n"
				+ "Bei Vertikal wird immer das untere Ende des Schiffes mit dem Mausklick platziert");
		hilfe_fenster.getContentPane().add(textArea);

	}
}
