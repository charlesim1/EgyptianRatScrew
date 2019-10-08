package cards;

/*
 * This class is for an individual card. It has variables that include
 * its color, rank, and suit so that it may be identified once it is played. 
 */
public class Card {
	public String color;
	public int rank;
	public String suit;
	
	/*
	 * Constructor for initializing the color, rank, and suit of a card.
	 */
	public Card(String color, int rank, String suit) {
		this.color = color;
		this.rank = rank;
		this.suit = suit;
	}
	
	/*
	 * Returns a string of the card that represents a real card.
	 */
	public void display() {
		
	}
}
