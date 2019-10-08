package rules;

import cards.Deck;

public class MarriageRule implements GameRules {

	@Override
	public boolean canSlap(Deck currentDeck) {

		if (currentDeck.size() < 2) {
			return false;
		}
		int size = currentDeck.size();
		int card1 = currentDeck.get(size - 1).rank;
		int card2 = currentDeck.get(size - 2).rank;
		
		if (card1 == 12 && card2 == 13 || card1 == 13 && card2 == 12) {
			return true;
		}
		return false;
	}
	
	public static void askQuestion() {
		System.out.print("Would you like to include the Marriage rule? (Y/N) : ");
	}
}
