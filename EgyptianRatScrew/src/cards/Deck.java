package cards;

import java.util.LinkedList;
import java.util.Random;

public class Deck {
	private final String[] COLORS = { "RED", "BLACK" };
	
	// Ace is expressed as 1, Jack as 11, Queen as 12, and King as 13.
	private final int[] RANK = { 1, 2, 3, 4, 
									5, 6, 7, 8, 
									9, 10, 11, 12, 13 };
	private final String[] SUIT = { "\u2663", "\u2666", "\u2665", "\u2660" };
	
	// this is a doubly linked list of the current cards in the deck
	private LinkedList<Card> currentDeck = new LinkedList<>();
	
	/*
	 * The default constructor initializes a full, shuffled deck
	 */
	public Deck(String descriptor) {
		if (descriptor.contentEquals("empty")) {
			return;
		} else {
			shuffle();
		}
	}
	
	/*
	 * Default constructor
	 */
	public Deck() {}

	/*
	 * Shuffles the existing deck in this object. 
	 */
	private void shuffle() {
		Random rand = new Random();
		int[] nums = new int[52];
		
		for (int i = 0; i < 52; i += 1) {
			nums[i] = i;
		}
		
		// using Fisher-Yates algorithm
		for (int i = 0; i < 52; i += 1) {
			int randomNum =	 i + (rand.nextInt(52 - i));
			int temp = nums[randomNum];
			nums[randomNum] = nums[i];
			nums[i] = temp;
		}
		
		// adding shuffled cards into the deck
		for (int i : nums) {
			if (i < 13) {
				currentDeck.add(new Card(COLORS[1], RANK[i], SUIT[0]));
				continue;
			} else if (i < 26 && i >= 13) {
				currentDeck.add(new Card(COLORS[0], RANK[i - 13], SUIT[1]));
				continue;
			} else if (i < 39 && i >= 26) {
				currentDeck.add(new Card(COLORS[0], RANK[i - 26], SUIT[2]));
				continue;
			} else {
				currentDeck.add(new Card(COLORS[1], RANK[i - 39], SUIT[3]));
				continue;
			}
		}
	}
	
	public void printDeck() {
		for (Card c : currentDeck) {
			System.out.print(c.color + " ");
			if (c.rank == 1) {
				System.out.print("A " + c.suit + "\n");
			} else if (c.rank == 11) {
				System.out.print("J " + c.suit + "\n");
			} else if (c.rank == 12) {
				System.out.print("Q " + c.suit + "\n");
			} else if (c.rank == 13) {
				System.out.print("K " + c.suit + "\n");
			} else {
				System.out.println(c.rank + " " + c.suit);
			}
		}
	}
	
	/*
	 * Returns the size of the deck.
	 */
	public int size() {
		return currentDeck.size();
	}
	
	public Card get(int index) {
		return currentDeck.get(index);
	}
	
	public Card getLast() {
		return currentDeck.getLast();
	}
	
	public Card remove() {
		return currentDeck.remove();
	}
	
	public void add(Card c) {
		currentDeck.addLast(c);
	}
	
	public void addFirst(Card c) {
		currentDeck.addFirst(c);
	}
	
	public void addLast(Card c) {
		currentDeck.addLast(c);
	}
	
	public Card removeLast() {
		return currentDeck.removeLast();
	}
	
	/*
	 * Returns the number value of the card. 
	 */
	public int peekRank() {
		return currentDeck.peek().rank;
	}
	
	
	public Deck split(int numCards, int numPlayers) {
		Deck splitDeck = new Deck(); // Deck to return, containing the new split cards
		
		int cardsToGive = numCards / numPlayers;
		
		// In the case where the number of players is three and the cards can't be distributed
		// evenly, the extra card is given to the player.
		if (numPlayers == 3 && this.currentDeck.size() == 18)
			cardsToGive += 1;
		
		for (int i = 0; i < cardsToGive; i += 1) {
			Card temp = currentDeck.remove();
			splitDeck.add(temp);
		}
		return splitDeck;
	}
}
