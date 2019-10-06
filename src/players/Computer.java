package players;

import cards.Deck;

public class Computer implements Runnable{
	public Deck computerDeck;
	
	public Computer(Deck computerCards) {
		computerDeck = computerCards;
	}
	
	public Computer() {}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
