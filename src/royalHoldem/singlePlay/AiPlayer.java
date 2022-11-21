package royalHoldem.singlePlay;


import royalHoldem.Sound;
import royalHoldem.singlePlay.gui.Aiwind;

// represent the Artifical Inteligence player
public class AiPlayer extends Player {

	private  int bidrnd=0;
	private  int chkrnd=0;
	public Aiwind wnd;
	
	
	public AiPlayer(String name) {
		super(name);
		wnd=new Aiwind();
		wnd.getLblName().setText(name);
	}
	
	@Override
	public void actionOfPlayertwo(Dealer dlr, Table tbl, int index) {		//take the action for play game
			wnd.setPLyrActive(true);
			int myrnk=chkMycrds();
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
			if(cash<=0){
				fold(dlr);
				wnd.getLblAction().setText("Exit No Money");
			}else{
				if(Logic.getRound()==0){
					
						if(tbl.getHighsBet()>cash){
							wnd.getLblAction().setText("All In");
							allIN(dlr);
						}else{
							if(myrnk>30){
								call(dlr, tbl);
								wnd.getLblAction().setText("call");
							}else{
								fold(dlr);
								wnd.getLblAction().setText("Fold");
							}
						}
				}else if(Logic.getRound()==1){
						chkrnd++;
						aiPlyrndtwo(dlr, tbl, index, myrnk);
				}else if(Logic.getRound()==2){
						Rank rnk=new Rank();
						int crdrnk=rnk.chkRank(tbl.getCrdOnTbl(), this);
						aiPlyrndthree(dlr, tbl, index, crdrnk);
				}else{
						
				}
			}
		wnd.setPLyrActive(false);
	}

	private  int chkMycrds(){					//check his own cards
		int myrnk=0;
		if(crd1!=null&&crd2!=null){
			myrnk+=crd1.getRankID();
			myrnk+=crd2.getRankID();
			if(crd1.getRankID()==crd2.getRankID()){
				myrnk+=40;
			}else if(crd1.getRankID()-1==crd2.getRankID()||crd1.getRankID()+1==crd2.getRankID()){
				myrnk+=20;
			}
			if(crd1.getSuitID()==crd2.getSuitID()){
				myrnk+=20;
			}if(crd1.getRankID()==14||crd2.getRankID()==14){
				myrnk+=30;
			}
		}
		return myrnk;
	}
		
	public void aiPlyrndtwo(Dealer dlr,Table tbl,int index,int myrnk){ 		//take action by cheking the cards
		if(tbl.isCheck()){
				if(tbl.getHighsBet()>cash){
					if(myrnk>50){
						allIN(dlr);
						wnd.getLblAction().setText("All In");
					}else{
						fold(dlr);
						wnd.getLblAction().setText("fold");
					}
				}else{
					if(myrnk>48&&bidrnd<2){
						raiseAI(dlr, tbl, index);
						wnd.getLblAction().setText("Raise "+bet);
						bidrnd++;
					}else {
						call(dlr, tbl);
						wnd.getLblAction().setText("call");
					}
				}			
		}
		else{
			if(tbl.getHighsBet()>cash){
				if(myrnk>50){
					allIN(dlr);
					wnd.getLblAction().setText("All In");
				}else{
					fold(dlr);
					wnd.getLblAction().setText("Fold");
				}
			}else{
				if(myrnk>60&&bidrnd<2){
					raiseAI(dlr, tbl, index);
					wnd.getLblAction().setText("Bid");
					tbl.setCheck(true);
					tbl.setPntOfRaise(index);
					bidrnd++;
					}else{
						if(chkrnd>2){
							raiseAI(dlr, tbl, index);
							tbl.setCheck(true);
							tbl.setPntOfRaise(index);	
							wnd.getLblAction().setText("Raise "+bet);
						}else{
						//check for pass the hand
							Sound.playchk();
							chkrnd++;
						wnd.getLblAction().setText("Check");
						}
					}				
				}
			}
		}

	public void aiPlyrndthree(Dealer dlr,Table tbl,int index,int crdrnk){
		if(tbl.isCheck()){
				if(tbl.getHighsBet()>cash){
					if(crdrnk>59){
						allIN(dlr);
						wnd.getLblAction().setText("All In");
					}else{
						wnd.getLblAction().setText("Fold");
						fold(dlr);
						}
				}else{
					if(crdrnk>65&&bidrnd<3){
						////raise
						raiseAI(dlr, tbl, index);
						wnd.getLblAction().setText("Raise "+bet);
						bidrnd++;
					}else if(crdrnk<15){
						wnd.getLblAction().setText("Fold");
						fold(dlr);
					}
					else {
						wnd.getLblAction().setText("Call");
						call(dlr, tbl);
					}
				}			
			}
		else{
			if(tbl.getHighsBet()>cash){
				if(crdrnk>59){
					allIN(dlr);
					wnd.getLblAction().setText("All In");
				}else{
					wnd.getLblAction().setText("Fold");
					fold(dlr);
				}
			}else{
				if(crdrnk>65&&bidrnd<3){
					////raise
					raiseAI(dlr, tbl, index);
					wnd.getLblAction().setText("Bid "+bet);
					tbl.setCheck(true);
					tbl.setPntOfRaise(index);
					bidrnd++;
					}else{
						if(chkrnd>2){
							raiseAI(dlr, tbl, index);
							tbl.setCheck(true);
							tbl.setPntOfRaise(index);	
							wnd.getLblAction().setText("Raise "+bet);
						}else{
						//check for pass the hand
							Sound.playchk();
						chkrnd++;
						wnd.getLblAction().setText("Check");
						}
					}				
				}
			}
		}

	public void aiPlyrndfour(Dealer dlr,Table tbl,int index,int crdrnk){
		if(tbl.isCheck()){
			if(tbl.getHighsBet()>cash){
				if(crdrnk>59){
					allIN(dlr);
					wnd.getLblAction().setText("All In");
				}else{
					fold(dlr);
					wnd.getLblAction().setText("Fold");
				}
			}else{
				if(crdrnk>65&&bidrnd<3){
					////raise
					raiseAI(dlr, tbl, index);
					bidrnd++;
					wnd.getLblAction().setText("Raise "+bet);
				}else if(crdrnk<25){
					fold(dlr);
					wnd.getLblAction().setText("Fold");
				}
				else {
						call(dlr, tbl);
						wnd.getLblAction().setText("Call");
				}
			}			
		}
		else{
			if(tbl.getHighsBet()>cash){
				if(crdrnk>59){
					allIN(dlr);
					wnd.getLblAction().setText("All In");
				}else{
					fold(dlr);
					wnd.getLblAction().setText("Fold");
				}
			}else{
				if(crdrnk>65&&bidrnd<3){
					////raise
					raiseAI(dlr, tbl, index);
					tbl.setCheck(true);
					tbl.setPntOfRaise(index);
					wnd.getLblAction().setText("Raise "+bet);
					bidrnd++;
					}else{
						if(chkrnd>2){
							raiseAI(dlr, tbl, index);
							tbl.setCheck(true);
							tbl.setPntOfRaise(index);	
							wnd.getLblAction().setText("Raise "+bet);
						}
						//check for pass the hand
						chkrnd++;
						wnd.getLblAction().setText("Check");
					}				
			}
//			
			}
		}

	

	private void raiseAI(Dealer dlr,Table tbl,int index){		//methods for raise 
		Sound.playRais();
		tbl.setPntOfRaise(index);
		double input=tbl.getHighsBet()+5;		
		cash-=(input-bet);
		bet=input;
		tbl.setHighsBet(input);
		dlr.setBgBlind(input);
		dlr.addTobetCollctn(input);
	}
	

	@Override
	public void setSmlBlnd(boolean smlBlnd) {
		super.setSmlBlnd(smlBlnd);
		if(smlBlnd){
			wnd.getLblAction().setText("put Small Blind");
			wnd.setBlindSmall();
		}else{
			wnd.getLblAction().setText(" ");
			wnd.remvBlnf();
		}
	}

	@Override
	public void setBgBlnd(boolean bgBlnd) {
		super.setBgBlnd(bgBlnd);
		if(bgBlnd){
		wnd.getLblAction().setText("put Big Blind");
		wnd.setBlindBig();
		}else{
			wnd.getLblAction().setText(" ");
			wnd.remvBlnf();
		}
		
	}
	public void showCards(){
		if(!fold){
			wnd.addcrd(crd1, crd2);
		}
	}
	@Override
	public void fold(Dealer dlr) {
		Sound.playFold();
		this.fold=true;
		wnd.setCardsFold();
	}

	
	
//////////////////////getters setters/////////////////////////
	public void setBidrnd(int bidrnd) {
		this.bidrnd = bidrnd;
	}

	public void setChkrnd(int chkrnd) {
		this.chkrnd = chkrnd;
	}
	public Aiwind getWnd() {
		return wnd;
	}
	
	
	
	
}
