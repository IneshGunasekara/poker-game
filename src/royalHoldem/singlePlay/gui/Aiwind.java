package royalHoldem.singlePlay.gui;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.io.File;

import javax.swing.SwingConstants;

import royalHoldem.singlePlay.Card;


public class Aiwind {

	private JFrame frame;
	JPanel panelAI;
	JLabel lblName;
	JLabel lblAction;
	private JPanel panelBlind;
	JPanel panelAIPic;
	private JPanel panelAICard;
	private JPanel panelCard1;
	private JPanel panelCard2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aiwind window = new Aiwind();
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
	public Aiwind() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 140, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel p=new JPanel();
		p.setBounds(0, 0, 122, 233);
		frame.getContentPane().add(p);
		p.setLayout(null);
		
		panelAI = new JPanel();
		panelAI.setOpaque(false);
		panelAI.setBounds(0, 0, 122, 173);
		p.add(panelAI);
		panelAI.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(10, 11, 102, 19);
		panelAI.add(lblName);
		
		lblAction = new JLabel("Action");
		lblAction.setHorizontalAlignment(SwingConstants.CENTER);
		lblAction.setForeground(Color.WHITE);
		lblAction.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAction.setBounds(0, 134, 122, 19);
		panelAI.add(lblAction);
		
		panelAIPic = new JPanel();
		panelAIPic.setOpaque(false);
		panelAIPic.setBounds(20, 35, 80, 80);
		panelAI.add(panelAIPic);
		panelAIPic.setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon(".\\res\\aiPlayer.png"));
		background.setBounds(0, 0, 80,80);
		panelAIPic.add(background);
		
		
		panelBlind = new JPanel();
		panelBlind.setOpaque(false);
		panelBlind.setBounds(35, 100, 51, 50);
		panelAI.add(panelBlind);
		
		panelAICard = new JPanel();
		panelAICard.setOpaque(false);
		panelAICard.setBounds(0, 0, 66, 44);
		p.add(panelAICard);
		panelAICard.setLayout(null);
		
		panelCard1 = new JPanel();
		panelCard1.setOpaque(false);
		panelCard1.setBounds(2, 2, 30, 40);
		panelAICard.add(panelCard1);
		panelCard1.setLayout(null);
		
		panelCard2 = new JPanel();
		panelCard2.setOpaque(false);
		panelCard2.setBounds(34, 2, 30, 40);
		panelAICard.add(panelCard2);
		panelCard2.setLayout(null);
	}
	public void setBlindBig(){
		panelBlind.removeAll();
		panelBlind.setLayout(new BorderLayout());
		JLabel blind=new JLabel(new ImageIcon(".\\res\\BB.png"));
		blind.setBounds(0, 0, 30,30);
		panelBlind.add(blind);
		SinglPlWndw.frame.repaint();
	}
	public void setBlindSmall(){
		panelBlind.removeAll();
		panelBlind.setLayout(new BorderLayout());
		JLabel blind=new JLabel(new ImageIcon(".\\res\\SB.png"));
		blind.setBounds(0, 0, 30,30);
		panelBlind.add(blind);
		SinglPlWndw.frame.repaint();
	}
	public void remvBlnf(){
		panelBlind.removeAll();
		SinglPlWndw.frame.repaint();
	}
	public void setPLyrActive(boolean actn){
		panelAIPic.removeAll();
		panelAIPic.setLayout(new BorderLayout());
		JLabel background;
		if(actn){
			background=new JLabel(new ImageIcon(".\\res\\aiPlayerSelected.png"));
		}else
			background=new JLabel(new ImageIcon(".\\res\\aiPlayer.png"));
		background.setBounds(0, 0, 80,80);
		panelAIPic.add(background);
		SinglPlWndw.frame.repaint();
	}
	public void setCardsPlay(){
		panelCard1.removeAll();
		panelCard2.removeAll();
		panelCard1.setLayout(new BorderLayout());
		panelCard2.setLayout(new BorderLayout());
		JLabel c1=new JLabel(new ImageIcon(".\\res\\cardsmall\\play.png"));
		JLabel c2=new JLabel(new ImageIcon(".\\res\\cardsmall\\play.png"));
		c1.setBounds(0, 0, 30,40);
		panelCard1.add(c1);
		panelCard2.add(c2);
		panelAICard.repaint();
		SinglPlWndw.frame.repaint();
	}
	public void setCardsFold(){
		panelCard1.removeAll();
		panelCard2.removeAll();
		panelCard1.setLayout(new BorderLayout());
		panelCard2.setLayout(new BorderLayout());
		JLabel c1=new JLabel(new ImageIcon(".\\res\\cardsmall\\back.png"));
		JLabel c2=new JLabel(new ImageIcon(".\\res\\cardsmall\\back.png"));
		c1.setBounds(0, 0, 30,40);
		panelCard1.add(c1);
		panelCard2.add(c2);
		panelAICard.repaint();
		panelAICard.repaint();
		SinglPlWndw.frame.repaint();
	}
	public void addcrd(Card crd1,Card crd2){
		panelCard1.removeAll();
		panelCard2.removeAll();
		panelCard1.setLayout(new BorderLayout());
		panelCard2.setLayout(new BorderLayout());
		ImageIcon img1,img2;
			if(crd1!=null){
//				.\\res\\cardsmall\\
				String path=".\\res\\cardsmall\\"+crd1.getRankID()+crd1.getSuitID()+".png";	
				File f=new File(path);
				if(f.exists()){
					img1=new ImageIcon(".\\res\\cardsmall\\"+crd1.getRankID()+crd1.getSuitID()+".png");
				}else{
					img1=new ImageIcon(".\\res\\cardsmall\\back.png");
				}
			}else{
					img1=new ImageIcon(".\\res\\cardsmall\\back.png");
			}
			if(crd2!=null){
				String path=".\\res\\cardsmall\\"+crd2.getRankID()+crd2.getSuitID()+".png";	
				File f=new File(path);
				if(f.exists()){
					img2=new ImageIcon(".\\res\\cardsmall\\"+crd2.getRankID()+crd2.getSuitID()+".png");
				}else{
					img2=new ImageIcon(".\\res\\cardsmall\\back.png");
				}
			}else{
					img2=new ImageIcon(".\\res\\cardsmall\\back.png");
			}
			
				JLabel c1=new JLabel(img1);
				JLabel c2=new JLabel(img2);
				c1.setBounds(0, 0, 30,40);
				
				panelCard1.add(c1);
				panelCard2.add(c2);
				panelAICard.repaint();
				SinglPlWndw.frame.repaint();
			}
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	public JPanel getPanelAI() {
		return panelAI;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JLabel getLblAction() {
		return lblAction;
	}

	public JPanel getPanelAICard() {
		return panelAICard;
	}

	public JPanel getPanelCard1() {
		return panelCard1;
	}

	public JPanel getPanelCard2() {
		return panelCard2;
	}
	
}
