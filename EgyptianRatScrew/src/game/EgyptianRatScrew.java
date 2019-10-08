package game;

import java.util.Scanner;

import cards.Deck;
import players.Computer;
import players.User;
import rules.GameRules;

public class EgyptianRatScrew {
	
	Deck mainPile = new Deck("shuffle");
	
	int difficulty;
	int timeToBeat;
	GameRules[] rules;
	
	User player;
	Computer computer; 
	
	/*
	 * Custom constructor for the difficulty and the rules that the player
	 * wants to play by.
	 */
	public EgyptianRatScrew(int difficulty, GameRules[] rules) {
		this.difficulty = difficulty;
		this.rules = rules;
		this.timeToBeat = 4000 / difficulty;
	}
	
	/*
	 * This function goes through all of the rules and determines
	 * if any rules return true as slappable.
	 */
	public boolean canSlap() {
		for (int i = 0; i < this.rules.length; i += 1) {
			if (rules[i].canSlap(mainPile)) {
				return true;
			} 
		}
		return false;
	}
	
	/*
	 * This function starts the game and continues to run the game until
	 * either the computer or the player wins the game.
	 */
	public void start(Scanner input) {
		int numPlayers = 2;
		
		// this splits all the cards evenly between all players
		computer = new Computer(mainPile.split(52, numPlayers));
		player = new User(mainPile.split(52, numPlayers));
		
		// first two timers for reaction to the opponent's card place
		long startTime1 = 0;
		long elapsedTime1 = 0;
		
		// next two timers for reaction to the player's card place
		long startTime2 = 0;
		long elapsedTime2 = 0;
		
		while (true) {
			// breaks out of the loop if the player wins or loses. 
			if (player.userDeck.size() == 0) {
				System.out.println("You don't have any more cards in your deck.");
				System.out.println("Unfortunately, you have lost");
				return;
			} else if (player.userDeck.size() == 52 || computer.computerDeck.size() == 0) {
				System.out.println("You have all the cards in the deck!");
				System.out.println("Congratulations! You are the winner!");
				return;
			} 
			
			// The opponent always starts off by playing the first card.
			mainPile.add(computer.playCard());
			System.out.println("Opponent putting card down...\n");
			
			// Pauses the program to let the user process the new card.
			try {
				Thread.sleep(1000);
			} catch(Exception e) {}
			
			mainPile.printDeck();
			
			// keeping timer for the response of the computer
			startTime1 = System.currentTimeMillis();
			
			// Takes in the user input. If the user inputs anything other than 's'
			// then the program recognizes that the user wants to place their card down.
			// If the input is 's', then the program recognizes that the user wants to slap 
			// the deck.
			if (input.hasNext()) {
				
				elapsedTime1 = System.currentTimeMillis() - startTime1;
				String answer = input.nextLine();
				if (!answer.equals("s")) {
					if (canSlap()) {
						computerWonCards(computer, mainPile);
						System.out.println("The opponent slapped in!... The opponent won this round");
						continue;
					}
					System.out.println("\nPutting your card down...\n");
					
					mainPile.add(player.playCard());
					mainPile.printDeck();
					
					startTime2 = System.currentTimeMillis();
					System.out.println();
					try {
						Thread.sleep(1000);
					} catch(Exception e) {}
					
				} else if (answer.equals("s")) {
					System.out.println("\nYou slapped the deck!");
					if (canSlap()) {
						if (elapsedTime1 <= timeToBeat) {
							playerWonCards(player, mainPile);
							System.out.println("You won this round!\n");
						} else {
							computerWonCards(computer, mainPile);
							System.out.println(mainPile.size());
							System.out.println("You were too slow... The opponent won this round\n");
						}
					} else {
						// makes sure that the user doesn't slap every time, so there is a penalty.
						System.out.println("You slapped the deck, but there weren't any rules that were fulfilled.");
						System.out.println("You have lost a card from your deck as a penalty.");
						System.out.println("Your card is now the very bottom of the main pile.");
						mainPile.addFirst(player.userDeck.remove());
					}
				}
			}
			
			if (canSlap()) {
				if (input.hasNext()) {
					elapsedTime2 = System.currentTimeMillis() - startTime2;
					String answer = input.nextLine();
					if (answer.equals("s")) {
						if (elapsedTime2 <= timeToBeat) {
							playerWonCards(player, mainPile);
							System.out.println("You won this round!\n");
						} else {
							computerWonCards(computer, mainPile);
							System.out.println("You were too slow... The opponent won this round\n");
						}
					} else {
						computerWonCards(computer, mainPile);
						System.out.println("You were too slow... The opponent won this round\n");
					}
				} else {
					computerWonCards(computer, mainPile);
					System.out.println("You were too slow... The opponent won this round\n");
					
				}
			}
		}
	}
	
	/*
	 * Function for when the player slaps and wins, the player takes all the decks in the mainPile.
	 */
	public static void playerWonCards(User player, Deck mainPile) {
		while (mainPile.size() != 0) {
			player.userDeck.addLast(mainPile.remove());
		}
	}
	/*
	 * Function for when the computer slaps and wins, the computer takes all the decks in the mainPile.
	 */
	public static void computerWonCards(Computer computer, Deck mainPile) {
		while (mainPile.size() != 0) {
			computer.computerDeck.addLast(mainPile.remove());
		}
	}
}
