package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Hilfe_Menu {

	private JFrame hilfe_fenster;
	private int width = 780;
	private int highth = 400;

	private BufferedImage horizontal;
	private BufferedImage vertikal;

	public Hilfe_Menu() {
		initialize();
	}

	private void initialize() {
		hilfe_fenster = new JFrame();
		hilfe_fenster.setTitle("Hilfe");
		hilfe_fenster.setVisible(true);
		hilfe_fenster.getContentPane().setBackground(Color.LIGHT_GRAY);
		hilfe_fenster.getContentPane().setLayout(null);
		hilfe_fenster.setBounds(200, 200, width, highth);
		hilfe_fenster.setResizable(false);
		hilfe_fenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(150, 0, width - 6, highth - 29);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea.setText("Schiffplatzierung: \n\n"
				+ "Bei Horizontal wird immer das linke Ende des Schiffes mit dem Mausklick platziert \n\n\n\n\n\n\n"
				+ "Bei Vertikal wird immer das untere Ende des Schiffes mit dem Mausklick platziert");
		hilfe_fenster.getContentPane().add(textArea);

		// Horizontal BufferedImage wird erstellt

		try {
			horizontal = ImageIO.read(this.getClass().getResource("/ressources/hilfe/Horizontal.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// Horizontales Icon wird skaliert und in ein ImageIcon umgeformt

		ImageIcon horizontal_icon = new ImageIcon(
				new ImageIcon(horizontal).getImage().getScaledInstance(150, 120, Image.SCALE_DEFAULT));

		// JLabel mit dem Bild
		JLabel label_picture_Horizontal = new JLabel(horizontal_icon);
		label_picture_Horizontal.setBounds(0, 0, 150, 115);
		hilfe_fenster.getContentPane().add(label_picture_Horizontal);

		// Vertikal BufferedImage wird erstellt
		try {
			vertikal = ImageIO.read(this.getClass().getResource("/ressources/hilfe/Vertikal.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// Vertikales Icon wird skaliert und in ein ImageIcon umgeformt
		ImageIcon vertikal_icon = new ImageIcon(
				new ImageIcon(vertikal).getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT));

		// JLabel mit dem Bild
		JLabel label_picture_Vertikal = new JLabel(vertikal_icon);
		label_picture_Vertikal.setBounds(0, 118, 150, 180);
		hilfe_fenster.getContentPane().add(label_picture_Vertikal);

	}
}
