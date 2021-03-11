package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gewonnen_Verloren {

	private JFrame frmDankeFrsSpielen;
	private String status;

	public Gewonnen_Verloren(String status) {
		this.status = status;
		initialize();
	}


	private void initialize() {
		frmDankeFrsSpielen = new JFrame();
		frmDankeFrsSpielen.setVisible(true);
		frmDankeFrsSpielen.setTitle("Danke f\u00FCr's spielen. Bis zum n\u00E4chsten mal");
		frmDankeFrsSpielen.setResizable(false);
		frmDankeFrsSpielen.setAlwaysOnTop(true);
		frmDankeFrsSpielen.setBounds(600, 200, 500, 300);
		frmDankeFrsSpielen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDankeFrsSpielen.getContentPane().setLayout(null);
		
		JTextField txtrStatus = new JTextField();
		txtrStatus.setHorizontalAlignment(SwingConstants.CENTER);
		txtrStatus.setFont(new Font("Tahoma", Font.PLAIN, 80));
		txtrStatus.setEditable(false);
		txtrStatus.setFocusable(false);
		txtrStatus.setText(status);
		txtrStatus.setBounds(0, 0, 494, 271);
		frmDankeFrsSpielen.getContentPane().add(txtrStatus);
	}
}
