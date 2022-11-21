package royalHoldem;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import royalHoldem.help.HelpWndw;
import royalHoldem.multiplay.MultPlyr;
import royalHoldem.singlePlay.Logic;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//main gui start page
public class GameMain {

	public static JFrame frame;
	JPanel panelbg;
	private JPanel panelBtn;
	private JPanel panelBtnSngl;
//	private JPanel panelMltPl;
	private JPanel panelBtnHlp;
	private JPanel panelExit;
	JPanel panelSnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMain window = new GameMain();
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
	public GameMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 80, 805, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		panelbg = new JPanel();
		panelbg.setBounds(0, 0, 800, 600);
		panelbg.setLayout(null);
		frame.getContentPane().add(panelbg);
		
		panelBtnSngl = new JPanel();
		panelBtnSngl.setOpaque(false);
		panelBtnSngl.setLayout(null);
		panelBtnSngl.setBounds(583, 410, 150,39);
		panelbg.add(panelBtnSngl);
		
		
//		panelMltPl = new JPanel();
//		panelMltPl.setOpaque(false);
//		panelMltPl.setBounds(583, 460, 150,39);
//		panelbg.add(panelMltPl);
//		panelMltPl.setLayout(null);
		
		panelBtnHlp = new JPanel();
		panelBtnHlp.setOpaque(false);
		panelBtnHlp.setBounds(583, 510, 75,39);
		panelbg.add(panelBtnHlp);
		panelBtnHlp.setLayout(null);
		
		panelExit = new JPanel();
		panelExit.setOpaque(false);
		panelExit.setBounds(658, 510, 75,39);
		panelbg.add(panelExit);
		panelExit.setLayout(null);
		
		panelSnd = new JPanel();
		panelSnd.setOpaque(false);
		panelSnd.setBounds(673, 46, 60, 60);
		panelSnd.setLayout(null);
		panelbg.add(panelSnd);
		addbcgrnd(panelbg);
		setBtnImg();
		addSndImg();
	}
	public void addSndImg(){
		panelSnd.removeAll();
		panelSnd.setLayout(null);
		JLabel background;
		if(Sound.isSound){
			background=new JLabel(new ImageIcon(".\\res\\sndon.png"));
		}else{
			background=new JLabel(new ImageIcon(".\\res\\sndoff.png"));
		}
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Sound.isSound){
				Sound.isSound=false;		//for turn off sound
				addSndImg();
			}else{
				Sound.isSound=true;			//turn on sounds
				addSndImg();
			}
			}
		});
		background.setBounds(0, 0, 60, 60);
		panelSnd.add(background);	
		frame.repaint();
		
	}
	public void addbcgrnd(JPanel pnl){
		panelbg.setLayout(null);
		JLabel background=new JLabel(new ImageIcon(".\\res\\start.png"));
		background.setBounds(0, 0, 800, 600);
		pnl.add(background);	
		frame.repaint();
	}
	public void setBtnImg(){
		panelBtnSngl.removeAll();
		panelBtnSngl.setLayout(new BorderLayout());
		JLabel btnSngl=new JLabel(new ImageIcon(".\\res\\buttons\\BtnSngl.png"));
		btnSngl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.playClick();
				Logic lg =new Logic();
				Start.gmthrd=new Thread(lg);
				Start.gmthrd.start();
				frame.setVisible(false);
			}
		});
		btnSngl.setBounds(0, 0, 150,39);
		panelBtnSngl.add(btnSngl);
		
//		panelMltPl.removeAll();
//		panelMltPl.setLayout(new BorderLayout());
//		JLabel btnMlt=new JLabel(new ImageIcon(".\\res\\buttons\\BtnMul.png"));
//		btnMlt.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Sound.playClick();
//				MultPlyr ml=new MultPlyr();
//				frame.setVisible(false);
//				ml.getFrame().setVisible(true);
//			}
//		});
//		btnMlt.setBounds(0, 0, 150,39);
//		panelMltPl.add(btnMlt);
		
		panelBtnHlp.removeAll();
		panelBtnHlp.setLayout(new BorderLayout());
		JLabel btnHlp=new JLabel(new ImageIcon(".\\res\\buttons\\BtnHelp.png"));
		btnHlp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.playClick();
				HelpWndw hw=new HelpWndw();
				hw.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
//		btnMlt.setBounds(0, 0, 75,39);
		panelBtnHlp.add(btnHlp);
		
		panelExit.removeAll();
		panelExit.setLayout(new BorderLayout());
		JLabel btnXt=new JLabel(new ImageIcon(".\\res\\buttons\\BtnExit.png"));
		btnXt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.playExit();
				System.exit(0);
			}
		});
		btnXt.setBounds(0, 0, 75,39);
		panelExit.add(btnXt);
		frame.repaint();
	}

	
	////////////////////// getters setters/////////////////////////
	public JFrame getFrame() {
		return frame;
	}

	public JPanel getPanelBtn() {
		return panelBtn;
	}

	public JPanel getPanelBtnSngl() {
		return panelBtnSngl;
	}

	public JPanel getPanelMltPl() {
		return null;
	}

	public JPanel getPanelBtnHlp() {
		return panelBtnHlp;
	}

	public JPanel getPanelExit() {
		return panelExit;
	}
}
