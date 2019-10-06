package rules;

import cards.Deck;

public interface GameRules {
	public boolean canSlap(Deck currentDeck);
}
