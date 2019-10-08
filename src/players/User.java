package players;

import java.util.Scanner;

import cards.Card;
import cards.Deck;

public class User {
	public Deck userDeck;
	
	public User(Deck userCards) {
		userDeck = userCards;
	}
	
	public Card playCard() {
		Card c = userDeck.remove();
		return c;
	}
}
