package royalHoldem.singlePlay.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class Rnkwindw {

	public JFrame frame;
	private JLabel lblCard1;
	private JLabel lblCard2;
	private JLabel lblCard3;
	private JLabel lblCard4;
	private JLabel lblCard5;
	private JLabel lblCard6;
	private JLabel lblCard7;
	 JLabel lblRoyalFlush;
	JLabel lblStrait;
	JLabel lblOfKind;
	JLabel lblFullHouse;
	JLabel lbthrlfknd;
	JLabel lblpair;
	JLabel lblFlush;
	JLabel lblValue;
	JLabel lblName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rnkwindw window = new Rnkwindw();
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
	public Rnkwindw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(950, 100, 217, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 205, 445);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblCard1 = new JLabel("Card 1");
		lblCard1.setBounds(10, 11, 154, 14);
		panel.add(lblCard1);
		
		lblCard2 = new JLabel("Card 2");
		lblCard2.setBounds(10, 36, 154, 14);
		panel.add(lblCard2);
		
		lblCard3 = new JLabel("Card 3");
		lblCard3.setBounds(10, 61, 154, 14);
		panel.add(lblCard3);
		
		lblCard4 = new JLabel("Card 4");
		lblCard4.setBounds(10, 86, 154, 14);
		panel.add(lblCard4);
		
		lblCard5 = new JLabel("Card 5");
		lblCard5.setBounds(10, 113, 154, 14);
		panel.add(lblCard5);
		
		lblCard6 = new JLabel("Card 6");
		lblCard6.setBounds(10, 141, 154, 14);
		panel.add(lblCard6);
		
		lblCard7 = new JLabel("Card 7");
		lblCard7.setBounds(10, 169, 154, 14);
		panel.add(lblCard7);
		
		lblRoyalFlush = new JLabel("Royal flush");
		lblRoyalFlush.setBounds(10, 194, 169, 14);
		panel.add(lblRoyalFlush);
		
		lblStrait = new JLabel("Strait");
		lblStrait.setBounds(10, 273, 154, 14);
		panel.add(lblStrait);
		
		 lblOfKind = new JLabel("4 of kind");
		lblOfKind.setBounds(10, 219, 154, 14);
		panel.add(lblOfKind);
		
		lblFullHouse = new JLabel("Full house");
		lblFullHouse.setBounds(10, 244, 154, 14);
		panel.add(lblFullHouse);
		
		lbthrlfknd = new JLabel("30fknd");
		lbthrlfknd.setBounds(10, 303, 154, 14);
		panel.add(lbthrlfknd);
		
		 lblpair = new JLabel("2pair");
		lblpair.setBounds(10, 328, 154, 14);
		panel.add(lblpair);
		
		lblFlush = new JLabel("Flush");
		lblFlush.setBounds(10, 353, 154, 14);
		panel.add(lblFlush);
		
		 lblValue = new JLabel("Value");
		lblValue.setBounds(10, 420, 154, 14);
		panel.add(lblValue);
		
	lblName = new JLabel("Name");
		lblName.setBounds(10, 378, 46, 14);
		panel.add(lblName);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getLblCard1() {
		return lblCard1;
	}

	public void setLblCard1(JLabel lblCard1) {
		this.lblCard1 = lblCard1;
	}

	public JLabel getLblCard2() {
		return lblCard2;
	}

	public void setLblCard2(JLabel lblCard2) {
		this.lblCard2 = lblCard2;
	}

	public JLabel getLblCard3() {
		return lblCard3;
	}

	public void setLblCard3(JLabel lblCard3) {
		this.lblCard3 = lblCard3;
	}

	public JLabel getLblCard4() {
		return lblCard4;
	}

	public void setLblCard4(JLabel lblCard4) {
		this.lblCard4 = lblCard4;
	}

	public JLabel getLblCard5() {
		return lblCard5;
	}

	public void setLblCard5(JLabel lblCard5) {
		this.lblCard5 = lblCard5;
	}

	public JLabel getLblCard6() {
		return lblCard6;
	}

	public void setLblCard6(JLabel lblCard6) {
		this.lblCard6 = lblCard6;
	}

	public JLabel getLblCard7() {
		return lblCard7;
	}

	public void setLblCard7(JLabel lblCard7) {
		this.lblCard7 = lblCard7;
	}

	public JLabel getLblRoyalFlush() {
		return lblRoyalFlush;
	}

	public void setLblRoyalFlush(JLabel lblRoyalFlush) {
		this.lblRoyalFlush = lblRoyalFlush;
	}

	public JLabel getLblStrait() {
		return lblStrait;
	}

	public void setLblStrait(JLabel lblStrait) {
		this.lblStrait = lblStrait;
	}

	public JLabel getLblOfKind() {
		return lblOfKind;
	}

	public void setLblOfKind(JLabel lblOfKind) {
		this.lblOfKind = lblOfKind;
	}

	public JLabel getLblFullHouse() {
		return lblFullHouse;
	}

	public void setLblFullHouse(JLabel lblFullHouse) {
		this.lblFullHouse = lblFullHouse;
	}

	public JLabel getLblfknd() {
		return lbthrlfknd;
	}

	public void setLblfknd(JLabel lblfknd) {
		this.lbthrlfknd = lblfknd;
	}

	public JLabel getLblpair() {
		return lblpair;
	}

	public void setLblpair(JLabel lblpair) {
		this.lblpair = lblpair;
	}

	public JLabel getLblFlush() {
		return lblFlush;
	}

	public void setLblFlush(JLabel lblFlush) {
		this.lblFlush = lblFlush;
	}

	public JLabel getLblValue() {
		return lblValue;
	}

	public void setLblValue(JLabel lblValue) {
		this.lblValue = lblValue;
	}

	public JLabel getLblName() {
		return lblName;
	}
	
}
