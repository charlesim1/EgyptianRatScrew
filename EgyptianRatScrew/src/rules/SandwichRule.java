package rules;

import cards.Deck;

public class SandwichRule implements GameRules {

	@Override
	public boolean canSlap(Deck currentDeck) {
		if (currentDeck.size() < 3) {
			return false;
		}
		int size = currentDeck.size();
		int card1 = currentDeck.get(size - 1).rank;
		int card2 = currentDeck.get(size - 3).rank;
		
		if (card1 == card2) {
			return true;
		}
		return false;
	}
	
	public static void askQuestion() {
		System.out.print("Would you like to include the Sandwich rule? (Y/N) : ");
	}
	
}
