package rules;

import cards.Deck;

public class FourInRowRule implements GameRules {
	@Override
	public boolean canSlap(Deck currentDeck) {
		if (currentDeck.size() < 3) {
			return false; 
		}
		
		int card1 = currentDeck.get(0).rank;
		int card2 = currentDeck.get(1).rank;
		int card3 = currentDeck.get(2).rank;
		int card4 = currentDeck.get(3).rank;
		
		if (isFaceCard(card1) || isFaceCard(card2) || isFaceCard(card3) || isFaceCard(card4)) {
			return false;
		}
		
		if (card1 + 1 == card2 && card2 + 1 == card3 && card3 + 1 == card4) {
			return true;
		}
		
		return false;
	}
	
	private static boolean isFaceCard(int card) {
		if (card == 1 || card > 10) {
			return true;
		}
		return false;
	}
	
	public static void askQuestion() {
		System.out.print("Would you like to include the Four in a Row rule? (Y/N) : ");
	}
	
}
