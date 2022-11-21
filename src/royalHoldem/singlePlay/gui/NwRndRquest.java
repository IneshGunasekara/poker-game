package royalHoldem.singlePlay.gui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.UIManager;


public class NwRndRquest extends JDialog {

	boolean nxtround=false;
	boolean isClick=false;
	static NwRndRquest dialog;
	JProgressBar progressBar;
	JPanel panelMain;
	JLabel lblDoYouWan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new NwRndRquest();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NwRndRquest() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(400, 250, 517, 338);
		getContentPane().setLayout(null);
		
		panelMain = new JPanel();
		panelMain.setBounds(0, 0, 500, 300);
		getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		JPanel panelbtn = new JPanel();
		panelbtn.setOpaque(false);
		panelbtn.setBounds(60, 162, 366, 115);
		panelMain.add(panelbtn);
		panelbtn.setLayout(null);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nxtround=true;
				isClick=true;
			}
		});
		btnYes.setBounds(67, 58, 89, 23);
		panelbtn.add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nxtround=false;
				isClick=true;
			}
		});
		btnNo.setBounds(199, 58, 89, 23);
		panelbtn.add(btnNo);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(UIManager.getColor("activeCaptionBorder"));
		progressBar.setBounds(111, 21, 146, 14);
		panelbtn.add(progressBar);
		
		lblDoYouWan = new JLabel("Do You wan to go to new round");
		lblDoYouWan.setForeground(Color.BLUE);
		lblDoYouWan.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoYouWan.setFont(new Font("Stencil Std", Font.BOLD, 14));
		lblDoYouWan.setBounds(96, 114, 298, 37);
		panelMain.add(lblDoYouWan);
	}
	public boolean getAction(){
		int prgrs=0;
		while(prgrs<100){
			if(isClick){
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			prgrs+=10;
			progressBar.setValue(prgrs);
		}
		setVisible(false);
		return nxtround;
		
	}
	public void addbcgrnd(JPanel pnl){
		pnl.setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon(".\\res\\rqstbcgrnd.png"));
		background.setBounds(0, 0, 500, 300);
		pnl.add(background);
		pnl.repaint();
	}

	public JPanel getPanelMain() {
		return panelMain;
	}

	public JLabel getLblDoYouWan() {
		return lblDoYouWan;
	}

	
	
	
	
}
