package players;

import cards.Card;
import cards.Deck;

public class Computer {
	public Deck computerDeck;
	
	public Computer(Deck computerCards) {
		computerDeck = computerCards;
	}
	
	public Computer() {}
	
	public Card playCard() {
		Card c = computerDeck.remove();
		return c;
	}

}
