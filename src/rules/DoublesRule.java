package rules;

import cards.Deck;

public class DoublesRule implements GameRules {

	@Override
	public boolean canSlap(Deck currentDeck) {
		if (currentDeck.size() < 2) {
			return false;
		}
		int card1 = currentDeck.get(0).rank;
		int card2 = currentDeck.get(1).rank;
		
		if (card1 == card2) 
			return true;
		return false;
	}
	
}
