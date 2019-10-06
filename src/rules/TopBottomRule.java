package rules;

import cards.Deck;

public class TopBottomRule implements GameRules {

	@Override
	public boolean canSlap(Deck currentDeck) {
		if (currentDeck.size() < 2) {
			return false;
		}

		int top = currentDeck.get(0).rank;
		int bot = currentDeck.getLast().rank;
		
		if (top == bot) {
			return true;
		}
		return false;
	}

}
