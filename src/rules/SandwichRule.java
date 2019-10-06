package rules;

import cards.Deck;

public class SandwichRule implements GameRules {

	@Override
	public boolean canSlap(Deck currentDeck) {
		if (currentDeck.size() < 3) {
			return false;
		}
		int card1 = currentDeck.get(0).rank;
		int card2 = currentDeck.get(2).rank;
		
		if (card1 == card2) {
			return true;
		}
		return false;
	}
	
	public static void askQuestion() {
		System.out.print("Would you like to include the Sandwich rule? (Y/N) : ");
	}
	
}
