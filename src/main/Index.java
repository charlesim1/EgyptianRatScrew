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
		
		System.out.print("How many computers do you wish to play with? (can select between 1 - 3) : ");
		int numComputers = input.nextInt();
		
		System.out.print("\nWhat difficulty do you want to play with? (1 being the easiest and 5 being the hardest: "); 
		int difficulty = input.nextInt();
		
		
		
		
		GameRules[] allowedRules = ruleOptions();
		
		EgyptianRatScrew game = new EgyptianRatScrew(numComputers, difficulty, allowedRules);
		
		game.start();
	}
	
	public static GameRules[] ruleOptions() {
		int numRules = 1; // There is one enabled rule as the default (which is the doubles rule)
		boolean[] ruleDecisions = new boolean[6];
		ruleDecisions[0] = true;
		
		String userInput = "";
		
		System.out.println("\n The next questions will ask you for which rules you want to play by.");
		System.out.println("(The Doubles rule is selected as default)");
		
		Scanner input = new Scanner(System.in);
		
		while (true) {
			FourInRowRule.askQuestion(); 
			userInput = (input.next().toLowerCase());
			if (userInput != "y" || userInput != "n") {
				continue;
			} else {
				if (userInput == "y") {
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
			userInput = (input.next().toLowerCase());
			if (userInput != "y" || userInput != "n") {
				continue;
			} else {
				if (userInput == "y") {
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
			userInput = (input.next().toLowerCase());
			if (userInput != "y" || userInput != "n") {
				continue;
			} else {
				if (userInput == "y") {
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
			userInput = (input.next().toLowerCase());
			if (userInput != "y" || userInput != "n") {
				continue;
			} else {
				if (userInput == "y") {
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
			userInput = (input.next().toLowerCase());
			if (userInput != "y" || userInput != "n") {
				continue;
			} else {
				if (userInput == "y") {
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
		
		return selectedRules;
	}
}
