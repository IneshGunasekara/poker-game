package royalHoldem.singlePlay.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;


public class DelrWindw {

	private JFrame frame;
	private JLabel lblBetcollection;
	private JPanel panel_1;
	private JPanel panelDlr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelrWindw window = new DelrWindw();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DelrWindw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 100, 309, 208);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 250, 114);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		setDlrpnl(panel_1);
		
	}
	public void setDlrpnl(JPanel panel_1){
		panelDlr = new JPanel();
		panelDlr.setOpaque(false);
		panelDlr.setBounds(0, 0, 250, 114);
		panel_1.add(panelDlr);
		panelDlr.setLayout(null);
		
		lblBetcollection = new JLabel("betCollection");
		lblBetcollection.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBetcollection.setForeground(Color.YELLOW);
		lblBetcollection.setHorizontalAlignment(SwingConstants.CENTER);
		lblBetcollection.setBounds(73, 57, 124, 26);
		panelDlr.add(lblBetcollection);
		
		JLabel lblDeler = new JLabel("Dealer");
		lblDeler.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeler.setForeground(Color.WHITE);
		lblDeler.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeler.setBounds(90, 11, 75, 26);
		panelDlr.add(lblDeler);
	}

	public JLabel getLblBetcollection() {
		return lblBetcollection;
	}

	

	public JFrame getFrame() {
		return frame;
	}

	public JPanel getPanelDlr() {
		return panelDlr;
	}
	
}
