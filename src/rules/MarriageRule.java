package rules;

import cards.Deck;

public class MarriageRule implements GameRules {

	@Override
	public boolean canSlap(Deck currentDeck) {

		if (currentDeck.size() < 2) {
			return false;
		}
		
		int card1 = currentDeck.get(0).rank;
		int card2 = currentDeck.get(1).rank;
		
		if (card1 == 11 && card2 == 12 || card1 == 12 && card2 == 11) {
			return true;
		}
		return false;
	}
	
	public static void askQuestion() {
		System.out.print("Would you like to include the Marriage rule? (Y/N) : ");
	}
}
