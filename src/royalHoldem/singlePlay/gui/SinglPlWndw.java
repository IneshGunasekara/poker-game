package royalHoldem.singlePlay.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.Icon;

import royalHoldem.GameMain;
import royalHoldem.Start;
import royalHoldem.singlePlay.Card;
import royalHoldem.singlePlay.Logic;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SinglPlWndw {

	public static JFrame frame;
	JPanel panelGameMain ;
	JPanel panelTBLcrd ;
	private JPanel panelTblCrd1;
	private JPanel panelTblCrd2;
	private JPanel panelTblCrd3;
	private JPanel panelTblCrd4;
	private JPanel panelTblCrd5;
	private JPanel panelPlyr;
	private JPanel panelDlr;
	private JPanel panelAI2;
	private JPanel panelAI3;
	private JPanel panelAI4;
	private JPanel panelAI1;
	private JLabel lblRound;
	JLabel lblMaxhand;
	JLabel labelMaxPlayr;
	static int crdnu=0;
	private JLabel labelPlyHv;
	private JPanel AicrdPnl1;
	private JPanel AicrdPnl2;
	private JPanel AicrdPnl3;
	private JPanel AicrdPnl4;
	private JPanel panelMainmenu;
	private JLabel label;

	public JPanel getPanelAI1() {
		return panelAI1;
	}

	public JPanel getPanelDlr() {
		return panelDlr;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglPlWndw window = new SinglPlWndw();
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
	public SinglPlWndw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
//		frame.setBounds(200, 0, 980, 735);
		frame.setBounds(200, 0, 980, 725);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		panelGameMain = new JPanel();
		panelGameMain.setOpaque(false);
		panelGameMain.setBounds(0, 0, 974, 735);
		frame.getContentPane().add(panelGameMain);
		panelGameMain.setLayout(null);
		
		panelTBLcrd = new JPanel();
		panelTBLcrd.setOpaque(false);
		panelTBLcrd.setBounds(337, 306, 308, 70);
		panelGameMain.add(panelTBLcrd);
		panelTBLcrd.setLayout(null);
		
		panelTblCrd1 = new JPanel();
		panelTblCrd1.setOpaque(false);
		panelTblCrd1.setBounds(10, 1, 50, 67);
		panelTBLcrd.add(panelTblCrd1);
		
		panelTblCrd2 = new JPanel();
		panelTblCrd2.setOpaque(false);
		panelTblCrd2.setBounds(70, 1, 50, 67);
		panelTBLcrd.add(panelTblCrd2);
		
		panelTblCrd3 = new JPanel();
		panelTblCrd3.setOpaque(false);
		panelTblCrd3.setBounds(130, 1, 50, 67);
		panelTBLcrd.add(panelTblCrd3);
		
		panelTblCrd4 = new JPanel();
		panelTblCrd4.setOpaque(false);
		panelTblCrd4.setBounds(190, 1, 50, 67);
		panelTBLcrd.add(panelTblCrd4);
		
		panelTblCrd5 = new JPanel();
		panelTblCrd5.setOpaque(false);
		panelTblCrd5.setBounds(250, 1, 50, 67);
		panelTBLcrd.add(panelTblCrd5);
		
		panelPlyr = new JPanel();
		panelPlyr.setOpaque(false);
		panelPlyr.setBounds(137, 419, 700, 280);
		panelGameMain.add(panelPlyr);
		panelPlyr.setLayout(null);
		
		AicrdPnl2 = new JPanel();
		AicrdPnl2.setBounds(10, 11, 66, 44);
		panelPlyr.add(AicrdPnl2);
		AicrdPnl2.setOpaque(false);
		AicrdPnl2.setLayout(null);
		
		AicrdPnl3 = new JPanel();
		AicrdPnl3.setBounds(624, 11, 66, 44);
		panelPlyr.add(AicrdPnl3);
		AicrdPnl3.setOpaque(false);
		AicrdPnl3.setLayout(null);
		
		panelDlr = new JPanel();
		panelDlr.setOpaque(false);
		panelDlr.setLayout(null);
		panelDlr.setBounds(366, 30, 250, 114);
		panelGameMain.add(panelDlr);
		
		panelAI1 = new JPanel();
		panelAI1.setOpaque(false);
		panelAI1.setBounds(36, 30, 122, 173);
		panelGameMain.add(panelAI1);
		panelAI1.setLayout(null);
		
		panelAI2 = new JPanel();
		panelAI2.setOpaque(false);
		panelAI2.setBounds(36, 365, 122, 173);
		panelGameMain.add(panelAI2);
		panelAI2.setLayout(null);
		
		panelAI3 = new JPanel();
		panelAI3.setOpaque(false);
		panelAI3.setBounds(817, 365, 122, 173);
		panelGameMain.add(panelAI3);
		panelAI3.setLayout(null);
		
		panelAI4 = new JPanel();
		panelAI4.setOpaque(false);
		panelAI4.setBounds(817, 30, 122, 173);
		panelGameMain.add(panelAI4);
		panelAI4.setLayout(null);
		
		lblRound = new JLabel("Round");
		lblRound.setForeground(Color.WHITE);
		lblRound.setHorizontalAlignment(SwingConstants.CENTER);
		lblRound.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblRound.setBounds(361, 150, 268, 26);
		panelGameMain.add(lblRound);
		
		lblMaxhand = new JLabel("");
		lblMaxhand.setForeground(Color.YELLOW);
		lblMaxhand.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxhand.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblMaxhand.setBounds(361, 189, 284, 26);
		panelGameMain.add(lblMaxhand);
		
		labelMaxPlayr = new JLabel("");
		labelMaxPlayr.setHorizontalAlignment(SwingConstants.CENTER);
		labelMaxPlayr.setForeground(Color.YELLOW);
		labelMaxPlayr.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		labelMaxPlayr.setBounds(273, 224, 458, 26);
		panelGameMain.add(labelMaxPlayr);
		
		labelPlyHv = new JLabel("");
		labelPlyHv.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlyHv.setForeground(Color.YELLOW);
		labelPlyHv.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		labelPlyHv.setBounds(273, 261, 458, 26);
		panelGameMain.add(labelPlyHv);
		
		AicrdPnl1 = new JPanel();
		AicrdPnl1.setOpaque(false);
		AicrdPnl1.setBounds(154, 122, 66, 44);
		panelGameMain.add(AicrdPnl1);
		AicrdPnl1.setLayout(null);
		
		AicrdPnl4 = new JPanel();
		AicrdPnl4.setOpaque(false);
		AicrdPnl4.setBounds(771, 122, 66, 44);
		panelGameMain.add(AicrdPnl4);
		AicrdPnl4.setLayout(null);
		
		panelMainmenu = new JPanel();
		panelMainmenu.setLayout(null);
		panelMainmenu.setOpaque(false);
		panelMainmenu.setBounds(23, 634, 150, 39);
		panelGameMain.add(panelMainmenu);
		addMnBtn(panelMainmenu);
		
	}
	////////////////////////////////////////////////////////////////////

	public void addMnBtn(JPanel pnl){
		pnl.setLayout(null);
		JLabel background=new JLabel(new ImageIcon(".\\res\\buttons\\Main.png"));
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				gotoMain();
			}
		});
		
		
		background.setBounds(0, 0, 150, 39);
		pnl.add(background);	
		frame.repaint();
	}
	
	private void gotoMain(){
		Start.gmthrd.stop();
		frame.setVisible(false);
		frame.dispose();
		GameMain.frame.setVisible(true);
		GameMain.frame.toFront();
		
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
	
public void addbcgrnd(JPanel pnl){
	pnl.setLayout(new BorderLayout());
	JLabel background=new JLabel(new ImageIcon(".\\res\\tablefinal1.png"));
	background.setBounds(0, 0, 980, 735);
	pnl.add(background);	
	frame.repaint();
}

//////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////
	public JPanel getPanelMain() {
		return panelGameMain;
	}

	public JPanel getPanelTBLcrd() {
		return panelTBLcrd;
	}

	public JPanel getPanelTblCrd1() {
		return panelTblCrd1;
	}

	public JPanel getPanelTblCrd2() {
		return panelTblCrd2;
	}

	public JPanel getPanelTblCrd3() {
		return panelTblCrd3;
	}

	public JPanel getPanelTblCrd4() {
		return panelTblCrd4;
	}

	public JPanel getPanelTblCrd5() {
		return panelTblCrd5;
	}

	

	public JPanel getPanelPlyr() {
		return panelPlyr;
	}

	public JPanel getPanelGameMain() {
		return panelGameMain;
	}

	public JPanel getPanelAI2() {
		return panelAI2;
	}

	public JPanel getPanelAI3() {
		return panelAI3;
	}

	public JPanel getPanelAI4() {
		return panelAI4;
	}

	public JLabel getLblRound() {
		return lblRound;
	}

	public JLabel getLblMaxhand() {
		return lblMaxhand;
	}

	public JLabel getLabelMaxPlayr() {
		return labelMaxPlayr;
	}

	public JLabel getLabelPlyHv() {
		return labelPlyHv;
	}

	public JPanel getAicrdPnl1() {
		return AicrdPnl1;
	}

	public JPanel getAicrdPnl2() {
		return AicrdPnl2;
	}

	public JPanel getAicrdPnl3() {
		return AicrdPnl3;
	}

	public JPanel getAicrdPnl4() {
		return AicrdPnl4;
	}

	public static JFrame getFrame() {
		return frame;
	}
	
	
}
