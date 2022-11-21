package royalHoldem.singlePlay;
import java.util.ArrayList;
import java.util.List;

import royalHoldem.singlePlay.gui.Rnkwindw;


public class Rank {
	List<Card> crds;
	List<Card> cardst;
	int cmnSID=24;
	Rnkwindw wndw;
	
	public Rank() {
		wndw=new Rnkwindw();
	}
	
	public int chkRank(List<Card> tblcrds,Player plr){
		wndw.getLblName().setText(plr.getName());
		crds=new ArrayList<Card>();
		for (Card card : tblcrds) {
			crds.add(card);
		}
		crds.add(plr.getCrd1());
		crds.add(plr.getCrd2());
		sortBack(crds);
		sortBack(crds);
		sortBack(crds);
		
		setLblCrd();
		if(isRoyalFlush()){	
			crds.clear();
			return 100;
		}else if (isFourOfKnd()) {
			crds.clear();
			wndw.getLblValue().setText("value  80");
			return 80;
		}else if (isFullHouse()) {
			crds.clear();
			wndw.getLblValue().setText("value  60");
			return 60;
		}else if (isStraight()) {
			crds.clear();
			wndw.getLblValue().setText("value  40");
			return 40;
		}else if (isThreeOfkind()) {
			crds.clear();
			wndw.getLblValue().setText("value  20");
			return 20;
		}else if (isTwoPair()) {
			crds.clear();
			wndw.getLblValue().setText("value  10");
			return 10;
		}else
			crds.clear();
		wndw.getLblValue().setText("value  0");
		return 0;
	}
	private boolean isFlush(){
		int sameSuit=0;
		int hrt=0,spd=0,diom=0,clb=0;
		
		for (int i = 0; i < crds.size()-1; i++) {
			if(crds.get(i).getSuitID()==0){
				hrt++;
			}else if (crds.get(i).getSuitID()==1) {
				spd++;
			}else if (crds.get(i).getSuitID()==2) {
				diom++;
			}else if (crds.get(i).getSuitID()==3) {
				clb++;
			}
		}
		
		
		if(hrt>=4||spd>=4||diom>=4||clb>=0){
			if(hrt==5){
				cmnSID=0;
			}else if (spd==5) {
				cmnSID=1;
			}else if (diom==5) {
				cmnSID=2;
			}else if (clb==5) {
				cmnSID=3;
			}
			wndw.getLblFlush().setText("Flush    true");
			return true;
		}
		wndw.getLblFlush().setText("Flush    false");
		cmnSID=24;
		return false;
	}
	private boolean isRoyalFlush(){
		List<Card> rylSet=new ArrayList<Card>();
		if(isFlush()){
			for (Card card : crds) {
				if(card.getSuitID()==cmnSID){
					rylSet.add(card);
					if(card.getRankID()==14){
						wndw.getLblRoyalFlush().setText("Royal flush   true" );
						return true;
					}
				}
			}
			
		}	
		wndw.getLblRoyalFlush().setText("Royal flush   false" );
		
		return false;
		
	}
	private boolean isFourOfKnd(){
		int cnt=0,rID=0,sID=0;
		boolean first=true;
		for (int i = 0; i < crds.size()-1; i++) {
			rID=crds.get(i).getRankID();
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()){
				if(sID!=crds.get(i).getRankID()){
					first=true;
					cnt=0;
				}
				if(first||(rID==crds.get(i).getRankID()&&sID==crds.get(i).getRankID())){
					cnt++;
					sID=crds.get(i).getRankID();
					first=false;
				}
				if(cnt==3){
					wndw.getLblOfKind().setText("four of kind    true");
					return true;
				}
				
			}
		}
		wndw.getLblOfKind().setText("four of kind    false");
		return false;
	}
	private boolean isOnePair(){
		for (int i = 0; i < crds.size()-1; i++) {
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()){
					return true;				
				}
		}
		return false;
	}
	private boolean isTwoPair(){
		int rID=0;
		for (int i = 0; i < crds.size()-1; i++) {
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()){
				if(rID!=crds.get(i).getRankID()&& i>1){
					wndw.getLblpair().setText("two pair    true");
					return true;				
				}
				rID=crds.get(i).getRankID();
				}
		
		}
		wndw.getLblpair().setText("two pair    false");
		return false;
	}
	private boolean isThreeOfkind(){
		int cnt=0,rID=0,sID=0;
		boolean first=true;
		for (int i = 0; i < crds.size()-1; i++) {			
			rID=crds.get(i).getRankID();
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()){
				if(sID!=crds.get(i).getRankID()){
					first=true;
					cnt=0;
				}
				if(first||(rID==crds.get(i).getRankID()&&sID==crds.get(i).getRankID())){
					cnt++;					
					sID=crds.get(i).getRankID();
				}
				if(cnt==2){
					wndw.getLblfknd().setText("three of kind true");
					return true;
				}
			}
		}
		wndw.getLblfknd().setText("three of kind false");
		return false;
	}
	private boolean isStraight(){
		int cnt=0;
		for (int i = 0; i < crds.size()-1; i++) {
			if(crds.get(i).getRankID()>crds.get(i+1).getRankID()){
				cnt++;
				if(cnt==4){
					wndw.getLblStrait().setText("Straight     true");
					return true;
				}
			}
		}
		wndw.getLblStrait().setText("Straight     false");
		return false;
	}
	private boolean isFullHouse(){
		int cnt=0,rID=0,thrrnkID=0;
		boolean thrOfKnd=false;
		boolean onePair=false;
		boolean first=true;
		for (int i = 0; i < crds.size()-1; i++) {			
			rID=crds.get(i).getRankID();
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()){
				if(thrrnkID!=crds.get(i).getRankID()){
					first=true;
					cnt=0;
				}
				if(first||(rID==crds.get(i).getRankID()&&thrrnkID==crds.get(i).getRankID())){
					cnt++;					
					thrrnkID=crds.get(i).getRankID();
				}
				if(cnt==2){
					wndw.getLblfknd().setText("three of kind true");
					thrOfKnd= true;
				}
				
			}
		}
		for (int i = 0; i <  crds.size()-1; i++) {
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()&& thrrnkID!=crds.get(i).getRankID()){
				onePair=true;
			}
		}
			if(thrOfKnd&&onePair){
				wndw.getLblFullHouse().setText("Full house   true");
				return true;
			}
			wndw.getLblFullHouse().setText("Full house   false");
			return false;
			}
	
	private void setLblCrd(){
		int i=crds.size();
		
		if(i>=1)			
			wndw.getLblCard1().setText("rank "+crds.get(0).getRankID()+" suit "+crds.get(0).getSuitID());
		if(i>=2)			
			wndw.getLblCard2().setText("rank "+crds.get(1).getRankID()+" suit "+crds.get(1).getSuitID());
		if(i>=3)			
			wndw.getLblCard3().setText("rank "+crds.get(2).getRankID()+" suit "+crds.get(2).getSuitID());
		if(i>=4)			
			wndw.getLblCard4().setText("rank "+crds.get(3).getRankID()+" suit "+crds.get(3).getSuitID());
		if(i>=5)			
			wndw.getLblCard5().setText("rank "+crds.get(4).getRankID()+" suit "+crds.get(4).getSuitID());
		if(i>=6)			
			wndw.getLblCard6().setText("rank "+crds.get(5).getRankID()+" suit "+crds.get(5).getSuitID());
		if(i>=7)			
			wndw.getLblCard7().setText("rank "+crds.get(6).getRankID()+" suit "+crds.get(6).getSuitID());
	}
	
	private void sort(List<Card> crds){
		Card temp;
		for (int i = crds.size()-1; i >0 ; i--) {
			for (int j = 0; j<i; j++) {
				if(crds.get(j).getRankID()>crds.get(j+1).getRankID()){
					temp=crds.get(i);
					crds.remove(i);
					crds.add(i, crds.get(j));
					crds.remove(j);
					crds.add(j, temp);
					temp=null;
				}
			}
		}

	}

	private void sortBack(List<Card> crds){
		Card temp;
		for (int i = crds.size()-1; i >0 ; i--) {
			for (int j = 0; j<i; j++) {
				if(crds.get(j).getRankID()<crds.get(j+1).getRankID()){
					temp=crds.get(i);
					crds.remove(i);
					crds.add(i, crds.get(j));
					crds.remove(j);
					crds.add(j, temp);
					temp=null;
				}
			}
		}

		
	}
	public void chkRnkSMply(Player player,Table tbl){		
			
			int rnkofpl=player.getRankOfHand();
			 cardst=new ArrayList<>();
			 for (Card card : tbl.getCrdOnTbl()) {
				 cardst.add(card);
				}
			Rank r=new Rank();
			cardst.add(player.getCrd1());
			cardst.add(player.getCrd2());
			wndw.getLblCard1().setText(" "+cardst.get(6).getRankID());
			sortBack(cardst);
			sortBack(cardst);
			sortBack(cardst);
			sortBack(cardst);
			sortBack(cardst);
			if(rnkofpl==80){
				player.setSmRnkOFnhd(chkSmfrOFknd(cardst));
			}else if(rnkofpl==60){
				player.setSmRnkOFnhd(r.chkSmFullHs(cardst));
			}else if(rnkofpl==40){
				player.setSmRnkOFnhd(50);
			
		}		
	}
	public int chkSmfrOFknd(List<Card> crdset){
		int cnt=0,rID=0,sID=0;
		boolean first=true;
		for (int i = 0; i < crdset.size()-1; i++) {
			rID=crdset.get(i).getRankID();
			if(crdset.get(i).getRankID()==crdset.get(i+1).getRankID()){
				if(sID!=crdset.get(i).getRankID()){
					first=true;
					cnt=0;
				}
				if(first||(rID==crdset.get(i).getRankID()&&sID==crdset.get(i).getRankID())){
					cnt++;
					sID=crdset.get(i).getRankID();
					first=false;
				}
				if(cnt==3){
					wndw.getLblOfKind().setText("four of kind    true");
					return sID;
				}
				
			}
		}
		wndw.getLblOfKind().setText("four of kind    false");
		return -1;
		
	}
	
	public int chkSmFullHs(List<Card> crdset){
		int rank=0;
		int thrknd=0;
		for (int i = 0; i < crdset.size()-2; i++) {
			if(crdset.get(i).getRankID()==crdset.get(i+1).getRankID()&&crdset.get(i+2).getRankID()==crdset.get(i).getRankID()){
				thrknd=crdset.get(i).getRankID();
				rank=(crdset.get(i).getRankID())*3;
				break;
			}
		}
		for (int i = 0; i < crdset.size()-1; i++) {
			if(crdset.get(i).getRankID()==crdset.get(i+1).getRankID()&&thrknd!=crdset.get(i).getRankID()){
				rank+=crdset.get(i).getRankID();
			}
		}
		crdset.clear();
		return rank;
		}
	
}
	

