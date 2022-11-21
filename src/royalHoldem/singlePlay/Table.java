package royalHoldem.singlePlay;
import java.util.ArrayList;
import java.util.List;

import royalHoldem.singlePlay.gui.TableWindw;


public class Table {
	List<Card> crdOnTbl;		//for table cards 5
	double highsBet;
	boolean putBet=false;
	boolean check=false;
	int pntOfRaise=0;
	TableWindw window;
	
	public Table() {
		crdOnTbl=new ArrayList<Card>();
		highsBet=0;
		pntOfRaise=0;
		putBet=false;
		check=false;
		window=new TableWindw();
	}
	
	public int getPntOfRaise() {
		return pntOfRaise;
	}
	public void setPntOfRaise(int pntOfRaise) {
		
		this.pntOfRaise = pntOfRaise;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public boolean isPutBet() {
		return putBet;
	}
	public void setPutBet(boolean putBet) {
		this.putBet = putBet;
	}
	public void SetDeck(Card crd){
		crdOnTbl.add(crd);
		int cdno=crdOnTbl.indexOf(crd);
		if(cdno==0){
			window.getLblCrd1().setText("rank "+crd.getRankID()+ " suit "+crd.getSuitID());
			Logic.spwndw.addcrd(Logic.spwndw.getPanelTblCrd1(), crd);
		}
		if(cdno==1){
			window.getLblCrd2().setText("rank "+crd.getRankID()+ " suit "+crd.getSuitID());
			Logic.spwndw.addcrd(Logic.spwndw.getPanelTblCrd2(), crd);
		}
		if(cdno==2){
			window.getLblCrd3().setText("rank "+crd.getRankID()+ " suit "+crd.getSuitID());
			Logic.spwndw.addcrd(Logic.spwndw.getPanelTblCrd3(), crd);
		}
		if(cdno==3){
			window.getLblCrd4().setText("rank "+crd.getRankID()+ " suit "+crd.getSuitID());
			Logic.spwndw.addcrd(Logic.spwndw.getPanelTblCrd4(), crd);
		}
		if(cdno==4){
			window.getLblCrd5().setText("rank "+crd.getRankID()+ " suit "+crd.getSuitID());
			Logic.spwndw.addcrd(Logic.spwndw.getPanelTblCrd5(), crd);
		}
		
		
	}
	
	
	public List<Card> getCrdOnTbl() {
		return crdOnTbl;
	}
	public double getHighsBet() {
		return highsBet;
	}
	public void setHighsBet(double highsBet) {
		this.highsBet = highsBet;
	}
	
}
