package royalHoldem.singlePlay.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TableWindw {

	private JFrame frame;
	private JLabel lblHithestBet;
	private JLabel lblCheck;
	private JLabel lblPointofraise;
	private JLabel lblCrd1;
	private JLabel lblCrd2;
	private JLabel lblCrd3;
	private JLabel lblCrd4;
	private JLabel lblCrd5;
	private JPanel panelTbl;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableWindw window = new TableWindw();
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
	public TableWindw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 300, 580, 176);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 564, 125);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		setTblpnl(panel);
		
	}
	public void setTblpnl(JPanel panel){
		panelTbl = new JPanel();
		panelTbl.setBounds(0, 0, 564, 125);
		panel.add(panelTbl);
		panelTbl.setLayout(null);
		
		lblCrd5 = new JLabel("crd5");
		lblCrd5.setBounds(270, 102, 203, 14);
		panelTbl.add(lblCrd5);
		
		lblPointofraise = new JLabel("PointofRaise");
		lblPointofraise.setBounds(10, 53, 203, 14);
		panelTbl.add(lblPointofraise);
		
		lblCrd1 = new JLabel("crd1");
		lblCrd1.setBounds(270, 11, 209, 14);
		panelTbl.add(lblCrd1);
		
		lblCrd2 = new JLabel("crd2");
		lblCrd2.setBounds(268, 34, 203, 14);
		panelTbl.add(lblCrd2);
		
		lblCrd4 = new JLabel("crd4");
		lblCrd4.setBounds(269, 79, 203, 14);
		panelTbl.add(lblCrd4);
		
		lblCrd3 = new JLabel("crd3");
		lblCrd3.setBounds(270, 56, 203, 14);
		panelTbl.add(lblCrd3);
		
		lblCheck = new JLabel("Check");
		lblCheck.setBounds(10, 31, 203, 14);
		panelTbl.add(lblCheck);
		
		lblHithestBet = new JLabel("Hithest bet");
		lblHithestBet.setBounds(10, 11, 203, 14);
		panelTbl.add(lblHithestBet);
	}

	
	public JFrame getFrame() {
		return frame;
	}

	public JLabel getLblHithestBet() {
		return lblHithestBet;
	}

	public JLabel getLblCheck() {
		return lblCheck;
	}

	public JLabel getLblPointofraise() {
		return lblPointofraise;
	}

	public JLabel getLblCrd1() {
		return lblCrd1;
	}

	public JLabel getLblCrd2() {
		return lblCrd2;
	}

	public JLabel getLblCrd3() {
		return lblCrd3;
	}

	public JLabel getLblCrd4() {
		return lblCrd4;
	}

	public JLabel getLblCrd5() {
		return lblCrd5;
	}

	
	
}
