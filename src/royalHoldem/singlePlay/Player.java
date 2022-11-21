package royalHoldem.singlePlay;


import royalHoldem.Sound;
import royalHoldem.singlePlay.gui.PlayerWindw;




public class Player {
	Card crd1;
	Card crd2;
	private boolean smlBlnd=false;
	private boolean bgBlnd=false;
	public boolean fold=false;
	private boolean allIn=false;
	public double bet=0;
	public double cash=250;
	public double allInCash=0;
	private int rankOfHand;
	private int smRnkOFnhd;
	private String name;
	
	PlayerWindw window;
	
	public Player(String name) {
		this.name = name;
		window = new PlayerWindw();
	}
	public Player(String name,int num) {
		this.name = name;
		window = new PlayerWindw();
		
		Logic.spwndw.getPanelPlyr().add(window.getPanel());
		window.getLblName().setText(name);
		window.getPanel_main().setVisible(false);
		double frac=cash%1;
		window.getLblCash().setText("cash "+(cash-frac));
	}
	
	public void addCash(double cash) {
		this.cash += cash;
		double fract=cash%1;
		window.getLblCash().setText("cash "+(this.cash-fract));
	}
	public void set1StCard(Card crd){
		crd1=crd;	
		window.addcrd(window.getPanelCard1(), crd);
	}
	public void set2NdCard(Card crd){
		crd2=crd;	
		window.addcrd(window.getPanelCard2(), crd);
	}
	
	public void setSmlBlnd(boolean smlBlnd) {
		this.smlBlnd = smlBlnd;
		if(smlBlnd){			
			window.getLblStatus().setText("Put Small Blind");
				window.setBlindSmall();
			}else{
				window.remvBlnf();
			}
	}
		
	
	public void setBgBlnd(boolean bgBlnd) {
		this.bgBlnd = bgBlnd;
		if(bgBlnd){			
			window.setBlindBig();
			window.getLblStatus().setText("Put Big Blind");
			}else{
			window.remvBlnf();
		}
	}
	
	public boolean isBgBlnd() {
		return bgBlnd;
	}
	public int getRankOfHand() {
		return rankOfHand;
	}
	public void setRankOfHand(int rankOfHand) {
		this.rankOfHand = rankOfHand;
		if(rankOfHand==100){
			window.getLblRound().setText("You have Royal Flush");
		}else if(rankOfHand==80){
			window.getLblRound().setText("You have Four of kind");
		}else if(rankOfHand==60){
			window.getLblRound().setText("You have Full house");
		}else if(rankOfHand==40){
			window.getLblRound().setText("You Straigt");
		}else if(rankOfHand==20){
			window.getLblRound().setText("You Three of kind");
		}else if(rankOfHand==10){
			window.getLblRound().setText("You Two pair");
		}else if(rankOfHand==0){
//			window.getLblRound().setText("You Dont have Hand ");
		}
	}
	
	public void actionOfPlayertwo(Dealer dlr,Table tbl,int index){
		window.getPanel_main().setVisible(true);
		window.frame.toFront();
		window.setBtnvsbl(false);
		if(tbl.isCheck()){
			if(tbl.getHighsBet()>cash){
				window.getLblMsgtoplyr().setText("you have only "+cash);
				window.getBtnAllIn().setVisible(true);
				window.getBtnFold().setVisible(true);
			}else{
				window.getBtnCall().setVisible(true);
				window.getBtnRaise().setVisible(true);
				window.getBtnFold().setVisible(true);
			}
			
			int choice=getActionGUi();
				switch(choice) {
					case 1:
						if(cash==0){
							fold(dlr);
						}else{
							call(dlr,tbl);
							window.getLblStatus().setText("Call");
						}
						break;
					case 2:
						if(cash==0){
							fold(dlr);
						}else{
						raise(dlr,tbl,index);
						}
						break;
					case 3:
						fold(dlr);
						break;
					case 4:
						allIN(dlr);
						break;
			
					default:
						break;
					}
			}
		else{
			window.getBtnCheck().setVisible(true);
			if(tbl.getHighsBet()>cash){
				window.getBtnAllIn().setVisible(true);
				window.getBtnFold().setVisible(true);
				
			}else{
				window.getBtnRaise().setVisible(true);
				window.getBtnRaise().setText("Bid");
				window.getBtnFold().setVisible(true);
			}
			int choice=getActionGUi();		
				switch(choice) {
					case 1:
						window.getLblStatus().setText("Check");
						Sound.playchk();
						break;
					case 2:
						if(cash==0){
							fold(dlr);
						}else{
							bid(dlr,tbl);
							tbl.setCheck(true);
							tbl.setPntOfRaise(index);
						}
						break;
					case 3:
						fold(dlr);
						break;
					case 4:
						allIN(dlr);
						break;
					case 5:
						window.getLblStatus().setText("Check");
						break;
			
					default:
						break;
					}
			}
		window.setBtnActn(0);
		window.getBtnRaise().setText("Raise");
		}
	public void allIN(Dealer dlr){
		Sound.playBid();
		allIn=true;
		dlr.addTobetCollctn(cash);
		allInCash=cash;
		cash=0;
		window.getLblStatus().setText("All in");
		window.getLblCash().setText("cash "+cash);
	}
	
	public void fold(Dealer dlr) {
		Sound.playFold();
		this.fold=true;
		window.getLblStatus().setText("Fold ");
		window.getLblCash().setText("cash "+cash);
		window.addcrd(window.getPanelCard2());
		window.addcrd(window.getPanelCard1());
	}
	public void call(Dealer dlr,Table tbl){
		Sound.playCall();
		double balnce=tbl.getHighsBet()-bet;
		cash-=balnce;
		bet=tbl.getHighsBet();
		dlr.addTobetCollctn(balnce);
		window.getLblCash().setText("cash "+cash);
		window.getLblStatus().setText("Call");
	}
	private void raise(Dealer dlr,Table tbl,int index){
		Sound.playRais();
		double bgblnd=dlr.getBgBlind();
		
		window.setCash(cash);
		window.setBlind(bgblnd);
		

		tbl.setPntOfRaise(index);
		double input=getActnRaise(dlr,tbl);
		cash-=(input-bet);
		bet=input;
		tbl.setHighsBet(input);
		dlr.setBgBlind(input);
		dlr.addTobetCollctn(input);
		
		if(cash<=0){
			allIN(dlr);
			window.getLblStatus().setText("All In");
		}else{
		window.getLblStatus().setText("Raise");
		}
		window.getLblCash().setText("cash "+cash);
	}
	
	public void postSmlblnd(Dealer dlr){
		double smlBlndBet=10;
		cash-=smlBlndBet;
		bet=smlBlndBet;
		dlr.addTobetCollctn(smlBlndBet);
		window.getLblCash().setText("cash "+cash);
		window.getLblStatus().setText("Put Big Blind");
		
	}
	public void postBglblnd(Dealer dlr,Table tbl){
		double bgBlndBet=20;
		cash-=bgBlndBet;
		bet=bgBlndBet;
		tbl.highsBet=bgBlndBet;
		dlr.addTobetCollctn(bgBlndBet);
		dlr.setBgBlind(bgBlndBet);
		window.getLblCash().setText("cash "+cash);
		window.getLblStatus().setText("Put Big Blind");
	}
	private void bid(Dealer dlr,Table tbl){
		Sound.playBid();
		window.setCash(cash);
		window.setBlind(0);
		double input=getActnRaise(dlr,tbl);
		
				cash-=input;
		bet=input;
		tbl.setHighsBet(input);
		dlr.setBgBlind(input);
		dlr.addTobetCollctn(input);
		if(cash<=0){
			allIN(dlr);
			window.getLblStatus().setText("All In");
		}else{
		window.getLblStatus().setText("Bid");
		}
		window.getLblCash().setText("cash "+cash);
	}
	
public void testAction(){
	window.getPanel_main().setVisible(true);
	window.setBtnvsbl(true);
	window.setRaisecomp(false);
	int prgrs=0;
	window.setProgress(prgrs);	
	while(prgrs<100){
		if(window.isIsclick()){
			break;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		prgrs+=10;
		window.setProgress(prgrs);
	}
	window.getPanel_main().setVisible(false);
	
}

public int getActionGUi(){
	window.setRaisecomp(false);
	int prgrs=0;
	window.setProgress(prgrs);	
	while(prgrs<100){
		if(window.isIsclick()){
			break;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		prgrs+=1;
		window.setProgress(prgrs);
	}
	int choice=window.getBtnActn();		
	if(choice==0){
		choice=3;
	}
	
	window.getPanel_main().setVisible(false);
	
	return choice;
}

public double getActnRaise(Dealer dlr,Table tbl){
	window.frame.toFront();
	window.setRaisecomp(true);
	window.setBtnvsbl(false);
	window.getPanel_main().setVisible(true);
	window.getBtnSetcash().setVisible(false);
	int prgrs=0;
	window.setProgress(prgrs);	
	while(prgrs<100){
		if(window.isIsclick()){
			break;
		}else{
			window.getPanel_raise().setVisible(true);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		prgrs+=10;
		window.setProgress(prgrs);
	}
	int choice=window.getBtnActn();
	double plyin=window.getRaise();
	double raise=dlr.getBgBlind();
	if(plyin>tbl.getHighsBet()){
		raise=plyin;
	}else{
		raise=dlr.getBgBlind()+5;
	
	}
	
		window.getPanel_main().setVisible(false);
		window.getPanel_raise().setVisible(false);
	
	
	return raise;
}

//////////////////////getters setters/////////////////////////
public int getSmRnkOFnhd() {
	return smRnkOFnhd;
}
public void setSmRnkOFnhd(int smRnkOFnhd) {
	this.smRnkOFnhd = smRnkOFnhd;
}
public boolean isAllIn() {
	return allIn;
}
public void setAllIn(boolean allIn) {
	this.allIn = allIn;
}
public boolean isSmlBlnd() {
	return smlBlnd;
}
public void setBet(double bet) {
	this.bet = bet;
}
public double getBet() {
	return bet;
}


public PlayerWindw getWindow() {
	return window;
}
public boolean isFold() {
	return fold;
}
public void setFold(boolean fold) {
	this.fold = fold;
}	
public double getCash() {
	return cash;
}
public void setCash(double cash) {
	this.cash = cash;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public double getAllInCash() {
	return allInCash;
}
public void setAllInCash(double allInCash) {
	this.allInCash = allInCash;
}
public Card getCrd1() {
	return crd1;
}
public void setCrd1(Card crd1) {
	this.crd1 = crd1;
}
public Card getCrd2() {
	return crd2;
}
public void setCrd2(Card crd2) {
	this.crd2 = crd2;
}
public boolean isSmlblnd(){
	return smlBlnd;
}
public boolean bgBlbnd(){
	return bgBlbnd();
}


}
