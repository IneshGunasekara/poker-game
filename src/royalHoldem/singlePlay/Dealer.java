package royalHoldem.singlePlay;
import java.util.ArrayList;
import java.util.Collections;
import royalHoldem.singlePlay.gui.DelrWindw;


//represent the game's deler 
public class Dealer {
	double betCollection;	// total money for bet 	
	double bgBlind;
	public static int crdpostn=0;
	private ArrayList<Card> allCards;
	DelrWindw window;

	public Dealer() {
		window= new DelrWindw();
		window.setDlrpnl(Logic.spwndw.getPanelDlr());
		Logic.spwndw.getPanelDlr().add(window.getPanelDlr());
		allCards = new ArrayList<Card>();

		for (short suit=0; suit<=3; suit++)		//go through 4 suits
		{
			for (short rank=0; rank<=4; rank++)		//go through 5 ranks
			{
				allCards.add( new Card(suit,rank) );		//add new card to allCard Array
			}
		}

		Collections.shuffle(allCards);	//Shuffling the card deck

		betCollection=0;
		crdpostn=0;
		bgBlind=0;
	}
	
	public void shuffleDeck(){
		Collections.shuffle(allCards);		//Shuffling the card deck
	}
	

	
	public Card getNextCard(){
		Card nxtcrd= allCards.get(crdpostn);		//give the current card of the deck
		crdpostn++;
		return nxtcrd;
	}
	
	
//////////////////////getters setters/////////////////////////
	public double getBetCollection() {
		return betCollection;
	}
	
	public void setBetCollection(double betCollection) {
		this.betCollection = betCollection;
		double view=betCollection%1;
		window.getLblBetcollection().setText("betcoll "+(this.betCollection-view));
	}
	public void addTobetCollctn(double bet){
		betCollection+=bet;
		window.getLblBetcollection().setText("betCollec "+betCollection);
	}
	public double getBgBlind() {
		return bgBlind;
	}
	public void setBgBlind(double bgBlind) {
		this.bgBlind = bgBlind;
	}
	public Card getCard(int cardNo){

		return allCards.get(cardNo);
	}
}
