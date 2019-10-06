package game;

import cards.Deck;
import players.Computer;
import players.User;
import rules.GameRules;

public class EgyptianRatScrew {
	
	Deck mainPile = new Deck("shuffle");
	
	int difficulty;
	GameRules[] rules;
	
	User player;
	Computer[] allComputers;
	
	public EgyptianRatScrew(int numComputer, int difficulty, GameRules[] rules) {
		allComputers = new Computer[numComputer];
		this.difficulty = difficulty;
		this.rules = rules;
	}
	
	public boolean canSlap() {
		for (int i = 0; i < this.rules.length; i += 1) {
			if (rules[i].canSlap(mainPile)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public void start() {
		int numPlayers = allComputers.length + 1;
		
		// this splits all the cards evenly between all players
		for (int i = 0; i < allComputers.length; i += 1) {
			allComputers[i] = new Computer(mainPile.split(52, numPlayers));
			allComputers[i].computerDeck.printDeck();
			System.out.println("===========================");
		}
		player = new User(mainPile.split(52, numPlayers));
		player.userDeck.printDeck();
		
		
		

		
	}
	
}
