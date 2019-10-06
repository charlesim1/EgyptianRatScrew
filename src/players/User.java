package players;

import cards.Deck;

public class User implements Runnable{
	public Deck userDeck;
	
	public User(Deck userCards) {
		userDeck = userCards;
	}
	
	
	public void setCard() {
		
	}
	
	public boolean slap() {
		return true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
