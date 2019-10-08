package main;


import java.util.Scanner;

import game.EgyptianRatScrew;
import rules.DoublesRule;
import rules.FourInRowRule;
import rules.GameRules;
import rules.MarriageRule;
import rules.SandwichRule;
import rules.TensRule;
import rules.TopBottomRule;

public class Index {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("===========================================================================");
		System.out.println("====================== WELCOME TO EGYPTIAN RAT SLAP! ======================");
		System.out.println("===========================================================================\n");
		System.out.println("In this game, enter any key to put a card down and");
		System.out.println("enter 's' to slap the deck. Best of luck!");
		
		int difficulty = 0;
		while (true) {
			System.out.print("\nWhat difficulty (1 - 5) do you wish to play with? (1 being the easiest and 5 being the hardest): "); 
			String temp = input.next();
			try {
				if (Integer.parseInt(temp) >= 0 && Integer.parseInt(temp) <= 5) {
					difficulty = Integer.parseInt(temp);
					break;
				} else {
					continue;
				}
			} catch (Exception e) { 
				continue; 
			}
		}
		
		GameRules[] allowedRules = ruleOptions(input);

		EgyptianRatScrew game = new EgyptianRatScrew(difficulty, allowedRules);
		game.start(input);
		
		System.out.println("===========================================================================");
		System.out.println("====================== THANK YOU FOR PLAYING MY GAME ======================");
		System.out.println("===========================================================================\n");
	}
	
	/*
	 * This funciton presents the options of choosing the different rules. 
	 */
	public static GameRules[] ruleOptions(Scanner input) {
		int numRules = 1; // There is one enabled rule as the default (which is the doubles rule)
		boolean[] ruleDecisions = new boolean[6];
		ruleDecisions[0] = true;
		
		String userInput = "";
		
		System.out.println("\nThe next questions will ask you for which rules you want to play by. ");
		System.out.println("              (The Doubles rule is selected as default)             \n");
		
		input.nextLine();
		while (true) {
			FourInRowRule.askQuestion();
			userInput = (input.nextLine().toLowerCase());
			if ( !userInput.equals("y") && !userInput.equals("n") ) {
				continue;
			} else {
				if (userInput.contentEquals("y")) {
					numRules += 1;
					ruleDecisions[1] = true;
				} else {
					ruleDecisions[1] = false;
				}
			}
			break;
		}
		
		while (true) {
			MarriageRule.askQuestion();
			userInput = (input.nextLine().toLowerCase());
			if ( !userInput.equals("y") && !userInput.equals("n") ) {
				continue;
			} else {
				if (userInput.contentEquals("y")) {
					numRules += 1;
					ruleDecisions[2] = true;
				} else {
					ruleDecisions[2] = false;
				}
			}
			break;
		}
		
		while (true) {
			SandwichRule.askQuestion();
			userInput = (input.nextLine().toLowerCase());
			if ( !userInput.equals("y") && !userInput.equals("n") ) {
				continue;
			} else {
				if (userInput.contentEquals("y")) {
					numRules += 1;
					ruleDecisions[3] = true;
				} else {
					ruleDecisions[3] = false;
				}
			}
			break;
		}
		
		while (true) {
			TensRule.askQuestion();
			userInput = (input.nextLine().toLowerCase());
			if ( !userInput.equals("y") && !userInput.equals("n") ) {
				continue;
			} else {
				if (userInput.contentEquals("y")) {
					numRules += 1;
					ruleDecisions[4] = true;
				} else {
					ruleDecisions[4] = false;
				}
			}
			break;
		}
		
		while (true) {
			TopBottomRule.askQuestion();
			userInput = (input.nextLine().toLowerCase());
			if ( !userInput.equals("y") && !userInput.equals("n") ) {
				continue;
			} else {
				if (userInput.contentEquals("y")) {
					numRules += 1;
					ruleDecisions[5] = true;
				} else {
					ruleDecisions[5] = false;
				}
			}
			break;
		}
		GameRules[] selectedRules = new GameRules[numRules];
		
		selectedRules[0] = new DoublesRule();
		int count = 1;
		if (ruleDecisions[1] == true) {
			selectedRules[count] = new FourInRowRule();
			count += 1;
		}
		if (ruleDecisions[2] == true) {
			selectedRules[count] = new MarriageRule();
			count += 1;
		}
		if (ruleDecisions[3] == true) {
			selectedRules[count] = new SandwichRule();
			count += 1;
		}
		if (ruleDecisions[4] == true) {
			selectedRules[count] = new TensRule();
			count += 1;
		}
		if (ruleDecisions[5] == true) {
			selectedRules[count] = new TopBottomRule();
			count += 1;
		}

		System.out.println();
		return selectedRules;
	}
}
