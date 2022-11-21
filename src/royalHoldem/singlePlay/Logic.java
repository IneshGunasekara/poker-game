package royalHoldem.singlePlay;
import java.util.ArrayList;
import java.util.List;

import royalHoldem.GameMain;
import royalHoldem.Sound;
import royalHoldem.singlePlay.gui.NoMnyWndw;
import royalHoldem.singlePlay.gui.NwRndRquest;
import royalHoldem.singlePlay.gui.SinglPlWndw;


//represent the main single player game
public class Logic implements Runnable{
	
	List<Player> players;		//set of players for game
	List<Player> smrnkPlyrs;
	Dealer dlr;
	boolean allSameBet=false;	
	boolean nextround=false;
	int blncMnyPlyrs=0;
	int plyrInGame=0;
	int foldPlyrs=0;
	public static SinglPlWndw spwndw;
	static int pntOfSmlbl; 		//reference to the small blind to the player on arraylist
	static int round=0;
	
	
	@Override
	public void run() {
		singlGame();
	}
	
	
	public void singlGame(){			//single player game
		spwndw=new SinglPlWndw();
		setPlayers();
		spwndw.addbcgrnd(spwndw.getPanelGameMain());
		spwndw.getFrame().setVisible(true);
		
		do{
			dlr=new Dealer();
			dlr.shuffleDeck();				//shuffle the cards
			Sound.playShfl();
			Table tbl=new Table();
			setCards( dlr, players);		//give cards to players
			Sound.playStcrd();
			putBlinds(dlr, tbl); 
		
			spwndw.getLblRound().setText("<~Preflop Round~>");
			round=0;
			betting(players, tbl, dlr);
			resetfrNewRnd(dlr, tbl, players);
			tbl.SetDeck(dlr.getNextCard());
			tbl.SetDeck(dlr.getNextCard());
			tbl.SetDeck(dlr.getNextCard());
		
			round=1;
			spwndw.getLblRound().setText("<~Flop Round~>");
			betting(players, tbl, dlr);
			resetfrNewRnd(dlr, tbl, players);
			tbl.SetDeck(dlr.getNextCard());    		//4th card
			Sound.playStcrd();
			round=2;
			
			spwndw.getLblRound().setText("<~Turn Round~>");
			betting(players, tbl, dlr);
			resetfrNewRnd(dlr, tbl, players);
		
			tbl.SetDeck(dlr.getNextCard());    		//5th card
			Sound.playStcrd();
			spwndw.getLblRound().setText("<~River Round~>");
			betting(players, tbl, dlr);
			resetfrNewRnd(dlr, tbl, players);
			
			showCards();							//show other players cards
			checkRanks(players, tbl, dlr);			//check the rakns
		
			givePot(dlr, tbl);						//give cash to the winning player
			Sound.playtada();int cnt=0;
			for (Player ply : players) {
				if(ply.getCash()<=0){
					cnt++;
				}
			}
			if(cnt>3){
				ReqGotomn("Other Players Dont have Money to play");
			}else{
				if(players.get(2).getCash()<=0){
					ReqGotomn("Sorry you dont have money to play");
					nextround=false;
				}else{
					nextround=getRequest("Do You want to go for new round ?");
					if(nextround){
						setPlyrsForNewRound();
						setSmlNBgblCrcl(players);
					}
				}
			}
			
			
		}while(nextround);
		try {
			Thread.sleep(5000);				//pause screen for look at cards
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		spwndw.getFrame().setVisible(false);
		spwndw.getFrame().dispose();
		GameMain.frame.setVisible(true);
		GameMain.frame.toFront();
	}
	private void showCards() {
			for (Player plyr : players) {
				if(plyr instanceof AiPlayer){
					((AiPlayer) plyr).showCards();
				}
			}
	}
	private void setPlyrsForNewRound() {		//reset some used variable for next round

		for (Player plyr : players) {	
			plyr.setAllIn(false);
			plyr.setBet(0);
			plyr.setFold(false);
			plyr.setAllInCash(0);
			plyr.setSmRnkOFnhd(0);
			plyr.setRankOfHand(0);
			plyr.getWindow().getLblStatus().setText("Action of Player");
			plyr.getWindow().getLblRound().setText(" ");
			
			if(plyr instanceof AiPlayer){
				((AiPlayer) plyr).setBidrnd(0);
				((AiPlayer) plyr).setChkrnd(0);
				((AiPlayer) plyr).getWnd().getLblAction().setText("Action of Player");
				((AiPlayer) plyr).getWnd().setCardsPlay();
			}
		}
		spwndw.getLabelMaxPlayr().setText(" ");
		spwndw.getLabelPlyHv().setText(" ");
		spwndw.getLblMaxhand().setText(" ");
		spwndw.getLblRound().setText("Pleas Wait for next Round");
		spwndw.getPanelDlr().removeAll();
		spwndw.getPanelTblCrd1().removeAll();
		spwndw.getPanelTblCrd2().removeAll();
		spwndw.getPanelTblCrd3().removeAll();
		spwndw.getPanelTblCrd4().removeAll();
		spwndw.getPanelTblCrd5().removeAll();
		
		try {
			Thread.sleep(5000);				//pause for check cards
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
	}
	private void setPlayers() {				//create players
		players=new ArrayList<Player>();
		
		AiPlayer ai=new AiPlayer("AI Player 1");
		players.add(ai);
		spwndw.getPanelAI1().add(ai.getWnd().getPanelAI());
		spwndw.getAicrdPnl1().add(ai.getWnd().getPanelAICard());
		ai.getWnd().setCardsPlay();
		
		
		
		ai=new AiPlayer("AI Player 2");
		players.add(ai);
		spwndw.getPanelAI2().add(ai.getWnd().getPanelAI());
		spwndw.getAicrdPnl2().add(ai.getWnd().getPanelAICard());
		ai.getWnd().setCardsPlay();
		
		players.add(new Player("You",1));
		
		ai=new AiPlayer("AI Player 3");
		players.add(ai);
		spwndw.getPanelAI3().add(ai.getWnd().getPanelAI());
		spwndw.getAicrdPnl3().add(ai.getWnd().getPanelAICard());
		ai.getWnd().setCardsPlay();
		
		ai=new AiPlayer("AI Player 4");
		players.add(ai);
		spwndw.getPanelAI4().add(ai.getWnd().getPanelAI());
		spwndw.getAicrdPnl4().add(ai.getWnd().getPanelAICard());
		ai.getWnd().setCardsPlay();
		
		
		
			
		Player p1=players.get(0);
		pntOfSmlbl=0;
		p1.setSmlBlnd(true);			//set small and bigblinds to first players 
		Player p2=players.get(1);
		p2.setBgBlnd(true);		
		plyrInGame=players.size();
		
		
	}

	private void setCards(Dealer dlr,List<Player> players){
		for (Player plr : players) {				//dealer give 2 cards to each player
			plr.set1StCard(dlr.getNextCard());	
		}
		
		for (Player plr : players) {
			plr.set2NdCard(dlr.getNextCard());
			}
	}

	private static void setSmlNBgblCrcl(List<Player> plyr) {
		for (Player player : plyr) {
			int size=plyr.size();
			if (plyr.indexOf(player)==pntOfSmlbl%size) {
				player.setSmlBlnd(false);
				player=plyr.get((pntOfSmlbl+1)%size);
				player.setBgBlnd(false);
				player.setSmlBlnd(true);
				player=plyr.get((pntOfSmlbl+2)%size);
				player.setBgBlnd(true);
				
			}			
		}
		pntOfSmlbl++;
	}
	
	private void putBlinds(Dealer dlr, Table tbl) {
		for (Player plr : players) {
				if (plr.isSmlblnd()) {
					plr.postSmlblnd(dlr);		//players put the small and big blinds to table
				}else if (plr.isBgBlnd()) {
					plr.postBglblnd(dlr,tbl);
					tbl.setPntOfRaise(players.indexOf(plr));
					tbl.setCheck(true);
				}			
			}
	}
	
	private void betting(List<Player> plyr,Table tbl,Dealer dlr){
		boolean round=false;
		int MnyBlncPlyr=0;
		double hghstBet=0;
		for (int i = tbl.getPntOfRaise(); i < plyr.size(); i++) {
				if(round ){
					break;
				}
			
			if(true){						
				if((plyr.get(i).getBet()==tbl.getHighsBet() && plyr.get(i).getBet()!=0)||plyr.get(i).isFold()||plyr.get(i).isAllIn()){
					hghstBet=tbl.getHighsBet();
					if(plyr.get(i).isFold()){
						//skip the player Fold
					}else if (plyr.get(i).isAllIn()) {
						//skip the player because All In
					}
					else{
						//skip the player put the same bet
					}
					MnyBlncPlyr++;			//increment if player put highst or fold withowt in low
				}else{						//if  not they have to perform action what to do
					plyr.get(i).actionOfPlayertwo(dlr, tbl,i);		//take action from the player
					if(tbl.getHighsBet()!=hghstBet||!tbl.isCheck()){
						MnyBlncPlyr=0;
					}
				}
			}	
			
			
			if(i==plyr.size()-1){		// go circl over arraylist
				i=-1 ;
			}
			if(MnyBlncPlyr==plyr.size()){
				round=true;
			}
		}
		tbl.setCheck(false);
	}
	
	private void resetfrNewRnd(Dealer dlr, Table tbl,List<Player> plyr){
		dlr.setBgBlind(0);
		tbl.setHighsBet(0);
		tbl.setCheck(false);
		for (Player player : plyr) {
			player.setBet(0);

		}
	}
	private void checkRanks(List<Player> plyr,Table tbl,Dealer dlr){
		int rank=0;
		int maxrank=0;
		int plymx=0;
		smrnkPlyrs=new ArrayList<>();
		for (Player player : plyr) {
			if(player.isFold()){
				player.setRankOfHand(0);
			}else{
				Rank rnk=new Rank();
				rank=rnk.chkRank(tbl.getCrdOnTbl(), player);
				player.setRankOfHand(rank);
				if(rank>maxrank){
					maxrank=rank;
				}
			}
		}
		String names="~ player ";
		for (Player player : plyr) {
			if(player.getRankOfHand()==maxrank){
				plymx++;
				smrnkPlyrs.add(player);
				names=names+player.getName()+" ";
			}
		}
		names=names+"~";
		spwndw.getLabelMaxPlayr().setText(names);
		spwndw.getLabelPlyHv().setText("have the Highest hands");
		if(maxrank==100){
			spwndw.getLblMaxhand().setText("Tables Highst Hand is Royal Flush");
		}else if(maxrank==80){
			spwndw.getLblMaxhand().setText("Tables Highst Hand is Four of kind");
		}else if(maxrank==60){
			spwndw.getLblMaxhand().setText("Tables Highst Hand is Full house");
		}else if(maxrank==40){
			spwndw.getLblMaxhand().setText("Tables Highst Hand is Straigt");
		}else if(maxrank==20){
			spwndw.getLblMaxhand().setText("Tables Highst Hand is Three of kind");
		}else if(maxrank==10){
			spwndw.getLblMaxhand().setText("Tables Highst Hand is Two pair");
		}else if(maxrank==0){
			spwndw.getLblMaxhand().setText(" Dont have Hand ");
		}
		
	}
	
	

	
	
	private void givePot(Dealer dlr,Table tbl){
			int maxrnk=0,mxply=0;
			if(smrnkPlyrs.size()>1){					//if have more than 1plyr of same ranks
				Rank r=new Rank();
				for (Player ply : smrnkPlyrs) {				
					r.chkRnkSMply(ply, tbl);			//again calculate ranks	
				}
				for (Player ply : smrnkPlyrs){
					if(ply.getSmRnkOFnhd()>maxrnk){
						maxrnk=ply.getSmRnkOFnhd();		//find the maximum rank
					}
				}
				for (Player ply : smrnkPlyrs){
					if(ply.getSmRnkOFnhd()==maxrnk){
						mxply++;
					}
				}
				if(mxply==1){
					for (Player ply : smrnkPlyrs){
						if(ply.getSmRnkOFnhd()==maxrnk){
							ply.addCash(dlr.getBetCollection());
							dlr.setBetCollection(0);
							spwndw.getLabelPlyHv().setText("But "+ply.getName()+" Have Higest among them");
							}
					}
				}else if (mxply>1) {
					double cash=dlr.getBetCollection();
					double plycsh=cash/mxply;
					String names="But ";
					for (Player ply : smrnkPlyrs){
						if(ply.getSmRnkOFnhd()==maxrnk){
							ply.addCash(plycsh);
							names=names+ply.getName()+",";
							dlr.setBetCollection(cash-plycsh);
						}
					}
					dlr.setBetCollection(0);
					spwndw.getLabelPlyHv().setText(names+" Have Higest among them");
				}
			}else{													//if only one player have the highest rank
				if(smrnkPlyrs.get(0)!=null){
					smrnkPlyrs.get(0).addCash(dlr.getBetCollection());
					dlr.setBetCollection(0);
				}
		}
	
	}
	private boolean getRequest(String word){
		try {
			Thread.sleep(3500);	//wait while
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		NwRndRquest nr=new NwRndRquest();
		nr.setVisible(true);
		nr.addbcgrnd(nr.getPanelMain());
		boolean action=nr.getAction();
		nr.dispose();
		return action;
		
	}
	private boolean ReqGotomn(String msg){
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		NoMnyWndw mny=new NoMnyWndw();
		mny.getLblSorryYouDont().setText(msg);
		mny.getFrame().setVisible(true);
		return true;
		
	}
	
	
	
	public static int getRound() {
		return round;
	}
	public static void setRound(int round) {
		Logic.round = round;
	}
}

