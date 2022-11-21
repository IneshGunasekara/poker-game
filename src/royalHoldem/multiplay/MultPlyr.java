package royalHoldem.multiplay;


import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import royalHoldem.GameMain;
import royalHoldem.Sound;

import java.awt.Font;
import java.awt.Color;

public class MultPlyr {

	private static JFrame frame;
	private JPanel panelbg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultPlyr window = new MultPlyr();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MultPlyr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 80, 805, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelbg = new JPanel();
		panelbg.setBounds(0, 0, 800, 600);
		panelbg.setLayout(null);
		frame.getContentPane().add(panelbg);
		
		JPanel panelMain = new JPanel();
		panelMain.setOpaque(false);
		panelMain.setBounds(20, 36, 150, 39);
		panelbg.add(panelMain);
		panelMain.setLayout(null);
		
		JLabel lblStillWeAre = new JLabel("Still we are Implementing Online facility But you can Play Single play ");
		lblStillWeAre.setForeground(Color.YELLOW);
		lblStillWeAre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStillWeAre.setHorizontalAlignment(SwingConstants.CENTER);
		lblStillWeAre.setBounds(54, 133, 683, 90);
		panelbg.add(lblStillWeAre);
		addbcgrnd(panelbg);
		addMnBtn(panelMain);
	}
	public void addbcgrnd(JPanel pnl){
		panelbg.setLayout(null);
		
		JLabel lblHappyPoker = new JLabel("Happy Poker ! Digital Coders");
		lblHappyPoker.setHorizontalAlignment(SwingConstants.CENTER);
		lblHappyPoker.setForeground(Color.YELLOW);
		lblHappyPoker.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHappyPoker.setBounds(64, 193, 683, 90);
		panelbg.add(lblHappyPoker);
		
		JLabel background=new JLabel(new ImageIcon(".\\res\\MulBac.png"));
		background.setBounds(0, 0, 800, 600);
		pnl.add(background);	
		frame.repaint();
	}
	public void addMnBtn(JPanel pnl){
		pnl.setLayout(null);
		JLabel background=new JLabel(new ImageIcon(".\\res\\buttons\\Main.png"));
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.playClick();
				frame.setVisible(false);
				GameMain.frame.setVisible(true);
				GameMain.frame.toFront();
			}
		});
		background.setBounds(0, 0, 150, 39);
		pnl.add(background);	
		frame.repaint();
	}

	
	
//////////////////////getters setters/////////////////////////
	public JFrame getFrame() {
		return frame;
	}
}
