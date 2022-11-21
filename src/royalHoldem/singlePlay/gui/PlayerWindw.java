package royalHoldem.singlePlay.gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.io.File;

import javax.swing.SwingConstants;

import royalHoldem.Sound;
import royalHoldem.singlePlay.Card;
import royalHoldem.singlePlay.Logic;


public class PlayerWindw {

	public JFrame frame;
	public  JLabel lblName;
	public  JProgressBar progressBar;
	private JLabel lblRound;
	private JLabel lblCash;
	private JPanel panel_main;
	private JLabel lblStatus;
	private JButton btnCall;
	private JButton btnRaise;
	private JButton btnFold;
	private JButton btnAllIn;
	private JButton btnCheck;
	private JButton btnSetcash;
	private JSlider slider ;
	private JPanel panelblind;
	JPanel panelCard1 ;
	JPanel panelCard2;
	
	private boolean isclick=false;
	private int btnActn=0;
	private double cash=0;
	private double blind=0;
	private double raise=0;
	JPanel panel_raise;
	private JLabel lblMsgtoplyr;
	private JLabel lblCash_1;
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerWindw window = new PlayerWindw();
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
	public PlayerWindw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 731, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pnlfrm=new JPanel();
		pnlfrm.setBounds(0, 0, 713, 291);
		frame.getContentPane().add(pnlfrm);
		pnlfrm.setLayout(null);
		setPpnl(pnlfrm,0);
		
		
		
	}
	public void setPpnl(JPanel pnlfrm,int x){
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 0, 700,280);
//		frame.getContentPane().add(panel);
		pnlfrm.add(panel);
		panel.setLayout(null);
		  
		  lblName = new JLabel("name");
		  lblName.setBounds(106, 44, 120, 23);
		  panel.add(lblName);
		  lblName.setForeground(Color.GREEN);
		  lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		  
		  lblCash = new JLabel("Cash");
		  lblCash.setBounds(106, 78, 145, 22);
		  panel.add(lblCash);
		  lblCash.setForeground(Color.GREEN);
		  lblCash.setFont(new Font("Tahoma", Font.PLAIN, 18));
		  
		  lblRound = new JLabel("");
		  lblRound.setHorizontalAlignment(SwingConstants.CENTER);
		  lblRound.setFont(new Font("Tahoma", Font.BOLD, 15));
		  lblRound.setForeground(Color.GREEN);
		  lblRound.setBounds(422, 20, 238, 23);
		  panel.add(lblRound);
		  
		  lblStatus = new JLabel("Action");
		  lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		  lblStatus.setBounds(281, 95, 133, 23);
		  panel.add(lblStatus);
		  lblStatus.setForeground(Color.GREEN);
		  lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		  
		  panel_main = new JPanel();
		  panel_main.setOpaque(false);
		  panel_main.setBounds(0, 120, 700, 149);
		  panel.add(panel_main);
		  panel_main.setLayout(null);
		  
		  btnCall = new JButton("Call");			  
		  btnCall.setForeground(Color.BLACK);
		  btnCall.setFont(new Font("Stencil Std", Font.PLAIN, 12));
		  btnCall.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		btnclick(e.getSource());
		  	}
		  });
		  btnCall.setBounds(155, 103, 89, 23);
		  panel_main.add(btnCall);
		  
		  btnFold = new JButton("Fold");
		  btnFold.setForeground(Color.BLACK);
		  btnFold.setFont(new Font("Stencil Std", Font.PLAIN, 12));
		  btnFold.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		btnclick(e.getSource());
		   	}
		   });
		  btnFold.setBounds(245, 103, 89, 23);
		  panel_main.add(btnFold);
		  
		  btnAllIn = new JButton("All In");
		  btnAllIn.setFont(new Font("Stencil Std", Font.PLAIN, 12));
		  btnAllIn.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		btnclick(e.getSource());
		   	}
		   });
		  btnAllIn.setBounds(333, 103, 89, 23);
		  panel_main.add(btnAllIn);
		  
		  btnCheck = new JButton("Check");
		  btnCheck.setFont(new Font("Stencil", Font.PLAIN, 12));
		  btnCheck.setForeground(Color.BLACK);
		  btnCheck.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		btnclick(e.getSource());
		   		Sound.playchk();
		   	}
		   });
		  btnCheck.setBounds(66, 103, 89, 23);
		  panel_main.add(btnCheck);
		  
		  progressBar = new JProgressBar();
		  progressBar.setForeground(Color.RED);
		  progressBar.setBounds(219, 28, 265, 14);
		  panel_main.add(progressBar);
		  
		  JLabel lblTimeRemain = new JLabel("Time remain");
		  lblTimeRemain.setForeground(Color.WHITE);
		  lblTimeRemain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  lblTimeRemain.setBounds(266, 52, 89, 14);
		  panel_main.add(lblTimeRemain);
		  
		  lblMsgtoplyr = new JLabel("");
		  lblMsgtoplyr.setBounds(0, 28, 121, 47);
		  panel_main.add(lblMsgtoplyr);
		  
		  
		  panel_raise = new JPanel();
		  panel_raise.setOpaque(false);
		  panel_raise.setBounds(522, 27, 164, 130);
		  panel_main.add(panel_raise);
		  panel_raise.setLayout(null);
		  
		  slider = new JSlider(0, 100, 0);
		  slider.setOpaque(false);
		  slider.setMajorTickSpacing(10);
		  slider.setPaintTicks(true);
		  slider.setBounds(0, 11, 154, 23);
		  panel_raise.add(slider);
		  
		  JLabel lblRaisecash = new JLabel("RaiseCash");
		  lblRaisecash.setForeground(Color.WHITE);
		  lblRaisecash.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  lblRaisecash.setBounds(0, 45, 100, 14);
		  panel_raise.add(lblRaisecash);
		  
		  btnSetcash = new JButton("SetCash");
		  btnSetcash.setFont(new Font("Stencil Std", Font.PLAIN, 12));
		  btnSetcash.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		btnclick(e.getSource());
		   	}
		   });
		  btnSetcash.setBounds(29, 82, 114, 23);
		  panel_raise.add(btnSetcash);
		  
		  lblCash_1 = new JLabel("Cash");
		  lblCash_1.setForeground(Color.WHITE);
		  lblCash_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  lblCash_1.setBounds(96, 45, 68, 14);
		  panel_raise.add(lblCash_1);
		  
		   btnRaise = new JButton("Raise");
		   btnRaise.setFont(new Font("Stencil Std", Font.PLAIN, 12));
		   btnRaise.setBounds(423, 103, 89, 23);
		   panel_main.add(btnRaise);
		   
		    panelblind = new JPanel();
		    panelblind.setOpaque(false);
		   panelblind.setBounds(250, 20, 51, 50);
		   panel.add(panelblind);
		   
		    panelCard1 = new JPanel();
		   panelCard1.setOpaque(false);
		   panelCard1.setBounds(292, 17, 50, 67);
		   panel.add(panelCard1);
		   
		   panelCard2 = new JPanel();
		   panelCard2.setOpaque(false);
		   panelCard2.setBounds(362, 17, 50, 67);
		   panel.add(panelCard2);
		   
		  btnRaise.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		btnclick(e.getSource());
		  	}
		  });
		  btnRaise.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		btnclick(e.getSource());
		   	}
		   });
		 slider.addChangeListener(new ChangeListener() {
		 	
		 	public void stateChanged(ChangeEvent e) {
		 		JSlider source = (JSlider)e.getSource();				
		 		setBet(source.getValue());
		 	}
		 });
	}
	public void setPanel_main(JPanel panel_main) {
		this.panel_main = panel_main;
	}

	public void setProgress(int val){
		progressBar.setValue(val);
	}
	private void btnclick(Object object){		
		if(object==btnCall){
			btnActn=1;
		}
		if(object==btnRaise){
			btnActn=2;
		}
		if(object==btnFold){
			btnActn=3;
		}
		if(object==btnAllIn){
			btnActn=4;
		}
		if(object==btnCheck){
			btnActn=5;
		}
		
		
		
		isclick=true;
		System.out.println("is click true"+btnActn);
	}
	public void setBtnvsbl(boolean val){
		btnAllIn.setVisible(val);
		btnCall.setVisible(val);
		btnCheck.setVisible(val);
		btnFold.setVisible(val);
		btnRaise.setVisible(val);
	}
	public void setRaisecomp(boolean val){
		slider.setValue(0);
		lblCash_1.setText(" ");
		panel_raise.setVisible(val);
	}
	private void setBet(int prs){
		double bet=(cash*prs/100);
		
		if(bet>blind){
			double fraction=bet%1;
			lblCash_1.setText(" "+(bet-fraction));
			raise=bet-fraction;
			btnSetcash.setVisible(true);
			}else
		btnSetcash.setVisible(false);
	}
	public void setBlindBig(){
		panelblind.removeAll();
		panelblind.setLayout(new BorderLayout());
		JLabel blind=new JLabel(new ImageIcon(".\\res\\BB.png"));
		blind.setBounds(0, 0, 30,30);
		panelblind.add(blind);
		SinglPlWndw.frame.repaint();
	}
	public void setBlindSmall(){
		panelblind.removeAll();
		panelblind.setLayout(new BorderLayout());
		JLabel blind=new JLabel(new ImageIcon(".\\res\\SB.png"));
		blind.setBounds(0, 0, 30,30);
		panelblind.add(blind);
		SinglPlWndw.frame.repaint();
	}
	public void remvBlnf(){
		panelblind.removeAll();
		SinglPlWndw.frame.repaint();
	}
	public void addcrd(JPanel pnl,Card crd){
		pnl.removeAll();
		ImageIcon img;
		pnl.setLayout(new BorderLayout());		
			if(crd!=null){		
				
					
				String path=".\\res\\cards\\"+crd.getRankID()+crd.getSuitID()+".png";	
//				card_back.png
				File f=new File(path);
				if(f.exists()){
//					img=new ImageIcon(f);
					img=new ImageIcon(".\\res\\cards\\"+crd.getRankID()+crd.getSuitID()+".png");
				}else{
					img=new ImageIcon(".\\res\\cards\\back.png");
				}
				}else{
						img=new ImageIcon(".\\res\\cards\\back.png");
//						
				}
				JLabel background=new JLabel(img);
				background.setBounds(1, 1, 50, 67);
				pnl.add(background);				
				Logic.spwndw.frame.repaint();
			}
	public void addcrd(JPanel pnl){
		pnl.removeAll();
		ImageIcon img;
		pnl.setLayout(new BorderLayout());				
				img=new ImageIcon(".\\res\\cards\\back.png");			
				JLabel background=new JLabel(img);
				background.setBounds(1, 1, 50, 67);
				pnl.add(background);
//				SwingUtilities.updateComponentTreeUI(Logic.spwndw.frame);
				Logic.spwndw.frame.repaint();
			}
		
	
	
	
	////////////////////////////////////////////////////////////////// getters
	public  JLabel getLblName() {
		return lblName;
	}
	public JPanel getPanel_raise() {
		return panel_raise;
	}
	public JPanel getPanel_main() {
		return panel_main;
	}
	
	public JLabel getLblCash() {
		return lblCash;
	}
	
	public JLabel getLblStatus() {
		return lblStatus;
	}
	
	public JLabel getLblMsgtoplyr() {
		return lblMsgtoplyr;
	}

	public JButton getBtnCall() {
		return btnCall;
	}
	public JButton getBtnRaise() {
		return btnRaise;
	}
	public JButton getBtnFold() {
		return btnFold;
	}
	public JButton getBtnAllIn() {
		return btnAllIn;
	}
	public JButton getBtnCheck() {
		return btnCheck;
	}

	public boolean isIsclick() {
		if(isclick==true){
			isclick=false;
			return true;
		}
		return isclick;
	}

	public int getBtnActn() {
		System.out.println("value in window"+btnActn);
		
		return btnActn;
	}

	public void setBtnActn(int btnActn) {
		this.btnActn = btnActn;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double range) {
		this.cash = range;
	}

	public JButton getBtnSetcash() {
		return btnSetcash;
	}

	public double getBlind() {
		return blind;
	}

	public void setBlind(double blind) {
		this.blind = blind;
	}

	public JLabel getLblCash_1() {
		return lblCash_1;
	}

	public JLabel getLblRound() {
		return lblRound;
	}

	public double getRaise() {
		return raise;
	}

	public JPanel getPanel() {
		return panel;
	}

	

	public JPanel getPanelCard1() {
		return panelCard1;
	}

	public JPanel getPanelCard2() {
		return panelCard2;
	}	
	
}
