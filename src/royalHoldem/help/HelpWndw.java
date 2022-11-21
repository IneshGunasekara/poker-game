package royalHoldem.help;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import royalHoldem.GameMain;
import royalHoldem.Sound;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HelpWndw {

	private JFrame frame;
	JPanel panelScrl;
	private JPanel panelbtnMain;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpWndw window = new HelpWndw();
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
	public HelpWndw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 80, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 562);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		panelScrl = new JPanel();
		 panelScrl.setPreferredSize(new Dimension(730,1500));
		 
		 JScrollPane scrollPane = new JScrollPane(panelScrl);
			scrollPane.setBounds(20, 137, 750, 414);
			panel.add(scrollPane);
			
			panelbtnMain = new JPanel();
			panelbtnMain.setOpaque(false);
			panelbtnMain.setLayout(null);
			panelbtnMain.setBounds(10, 11,150, 39);
			panel.add(panelbtnMain);
			
			JPanel panelBtnHwtply = new JPanel();
			panelBtnHwtply.setOpaque(false);
			panelBtnHwtply.setBounds(20, 87, 150, 39);
			panel.add(panelBtnHwtply);
			panelBtnHwtply.setLayout(null);
			addBtnHwtopl(panelBtnHwtply);
			
			JPanel panelbtnabt = new JPanel();
			panelbtnabt.setOpaque(false);
			panelbtnabt.setBounds(180, 87, 150, 39);
			panel.add(panelbtnabt);
			panelbtnabt.setLayout(null);
			addBtnabt(panelbtnabt);
			
			JPanel panelbtness = new JPanel();
			panelbtness.setOpaque(false);
			panelbtness.setBounds(340, 87, 150, 39);
			panel.add(panelbtness);
			panelbtness.setLayout(null);
			addBtnEsstr(panelbtness);
			
			JPanel panelbtnhndrnk = new JPanel();
			panelbtnhndrnk.setOpaque(false);
			panelbtnhndrnk.setBounds(500, 87, 150, 39);
			panel.add(panelbtnhndrnk);
			panelbtnhndrnk.setLayout(null);
			addBtnHandrnk(panelbtnhndrnk);
			
			JPanel panelbtntrk = new JPanel();
			panelbtntrk.setOpaque(false);
			panelbtntrk.setBounds(660, 87, 110, 39);
			panel.add(panelbtntrk);
			panelbtntrk.setLayout(null);
			addBtnTrk(panelbtntrk);
			
			addBacgMn(panel);
			addMnBtn(panelbtnMain);
			addStrt();
	}
	public void addMnBtn(JPanel pnl){
		pnl.setLayout(null);
		JLabel background=new JLabel(new ImageIcon(".\\res\\buttons\\Main.png"));
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.playClick();
				gotoMain();
			}
		});
		background.setBounds(0, 0, 150, 39);
		pnl.add(background);	
		frame.repaint();
	}
	public void addBtnHwtopl(JPanel pnl){
		pnl.setLayout(null);
		JLabel background=new JLabel(new ImageIcon(".\\res\\buttons\\BtnHwPly.png"));
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.playClick();
				addBacgHwtoPly();
			}
		});
		background.setBounds(0, 0, 150, 39);
		pnl.add(background);	
		frame.repaint();
	}
	public void addBtnEsstr(JPanel pnl){
		pnl.setLayout(null);
		JLabel background=new JLabel(new ImageIcon(".\\res\\buttons\\BtnEss.png"));
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.playClick();
				addBacgEsst();
			}
		});
		background.setBounds(0, 0, 150, 39);
		pnl.add(background);	
		frame.repaint();
	}
	public void addBtnHandrnk(JPanel pnl){
		pnl.setLayout(null);
		JLabel background=new JLabel(new ImageIcon(".\\res\\buttons\\BtnHndrnk.png"));
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.playClick();
				addBacgRank();
			}
		});
		background.setBounds(0, 0, 150, 39);
		pnl.add(background);	
		frame.repaint();
	}
	public void addBtnTrk(JPanel pnl){
		pnl.setLayout(null);
		JLabel background=new JLabel(new ImageIcon(".\\res\\buttons\\BtnTrk.png"));
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.playClick();
				addBacgTrk();
			}
		});
		background.setBounds(0, 0, 110, 39);
		pnl.add(background);	
		frame.repaint();
	}
	public void addBtnabt(JPanel pnl){
		pnl.setLayout(null);
		JLabel background=new JLabel(new ImageIcon(".\\res\\buttons\\BtnAbt.png"));
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.playClick();
				addBacgAbt();
			}
		});
		background.setBounds(0, 0, 150, 39);
		pnl.add(background);	
		frame.repaint();
	}
	
	private void gotoMain(){
//		Start.gmthrd.stop();
		frame.setVisible(false);
		frame.dispose();
		GameMain.frame.setVisible(true);
		GameMain.frame.toFront();
		
	}

	public void addBacgMn(JPanel pnl){
		pnl.setLayout(null);		
		JLabel background=new JLabel(new ImageIcon(".\\res\\helpbac.png"));
		background.setBounds(0, 0, 800,600);
		pnl.add(background);	
		frame.repaint();
	}
	public void addBacgHwtoPly(){
		panelScrl.removeAll();
		panelScrl.setLayout(null);		
		JLabel background=new JLabel(new ImageIcon(".\\res\\help\\hwtoply.png"));
		background.setBounds(0, 0, 730,1500);
		panelScrl.add(background);	
		frame.repaint();
	}
	public void addBacgAbt(){
		panelScrl.removeAll();
		panelScrl.setLayout(null);		
		JLabel background=new JLabel(new ImageIcon(".\\res\\help\\about.png"));
		background.setBounds(0, 0, 730,1500);
		panelScrl.add(background);	
		frame.repaint();
	}
	public void addBacgEsst(){
		panelScrl.removeAll();
		panelScrl.setLayout(null);		
		JLabel background=new JLabel(new ImageIcon(".\\res\\help\\esstrt.png"));
		background.setBounds(0, 0, 730,1500);
		panelScrl.add(background);	
		frame.repaint();
	}
	public void addBacgRank(){
		panelScrl.removeAll();
		panelScrl.setLayout(null);		
		JLabel background=new JLabel(new ImageIcon(".\\res\\help\\rank.png"));
		background.setBounds(0, 0, 730,1500);
		panelScrl.add(background);	
		frame.repaint();
	}
	public void addBacgTrk(){
		panelScrl.removeAll();
		panelScrl.setLayout(null);		
		JLabel background=new JLabel(new ImageIcon(".\\res\\help\\trick.png"));
		background.setBounds(0, 0, 730,1500);
		panelScrl.add(background);	
		frame.repaint();
	}
	public void addStrt(){
		panelScrl.removeAll();
		panelScrl.setLayout(null);		
		JLabel background=new JLabel(new ImageIcon(".\\res\\help\\strt.png"));
		background.setBounds(0, 0, 730,1500);
		panelScrl.add(background);	
		frame.repaint();
	}

	public JFrame getFrame() {
		return frame;
	}
	
}
