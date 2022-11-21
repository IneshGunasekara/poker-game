package royalHoldem.singlePlay.gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import royalHoldem.GameMain;
import royalHoldem.Start;
import royalHoldem.singlePlay.Logic;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NoMnyWndw {

	private JFrame frame;
	private JPanel panel;
	JLabel lblSorryYouDont;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoMnyWndw window = new NoMnyWndw();
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
	public NoMnyWndw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 200, 463, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 450, 281);
		frame.getContentPane().add(panel);
		
		lblSorryYouDont = new JLabel("Sorry You Dont Have Money To Play");
		lblSorryYouDont.setForeground(Color.GREEN);
		lblSorryYouDont.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSorryYouDont.setHorizontalAlignment(SwingConstants.CENTER);
		lblSorryYouDont.setBounds(31, 99, 385, 82);
		panel.add(lblSorryYouDont);
		addbcgrnd(panel);
	}
	public void addbcgrnd(JPanel pnl){
		panel.setLayout(null);
		
		JPanel panelMainBtn = new JPanel();
		panelMainBtn.setOpaque(false);
		panelMainBtn.setBounds(142, 192, 150, 39);
		panel.add(panelMainBtn);
		
//		\res\buttons\Main.png
		JLabel mn=new JLabel(new ImageIcon(".\\res\\buttons\\Main.png"));
		mn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gotoMain();
			}
		});
		mn.setBounds(0, 0, 150, 39);
		panelMainBtn.add(mn);
		
		JLabel background=new JLabel(new ImageIcon(".\\res\\Nomny.png"));
		background.setBounds(0, 0, 450, 281);
		pnl.add(background);
		pnl.repaint();
	}
	private void gotoMain(){
		Start.gmthrd.stop();
		Logic.spwndw.frame.setVisible(false);
		frame.setVisible(false);
		frame.dispose();
		GameMain.frame.setVisible(true);
		GameMain.frame.toFront();
		
	}

	public JLabel getLblSorryYouDont() {
		return lblSorryYouDont;
	}

	public JFrame getFrame() {
		return frame;
	}
	
}
