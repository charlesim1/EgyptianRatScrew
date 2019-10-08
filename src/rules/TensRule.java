package rules;

import cards.Deck;

public class TensRule implements GameRules {

	@Override
	public boolean canSlap(Deck currentDeck) {
		if (currentDeck.size() < 2) {
			return false;
		}
		int card1 = currentDeck.get(0).rank;
		int card2 = currentDeck.get(1).rank;
		
		if (card1 == 1 || card2 == 1) {
			return false;
		}
		if (card1 + card2 == 10) {
			return true;
		}
		
		return false;
	}
	
	public static void askQuestion() {
		System.out.println("Would you like to include the Tens rule? (Y/N) : ");
	}
	
}
