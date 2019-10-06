package main;

import java.util.Scanner;

import game.EgyptianRatScrew;
import rules.GameRules;
import rules.Marriage;

public class Index {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many computers do you wish to play with? (can select between 1 - 3) : ");
		int numComputers = input.nextInt();
		
		System.out.print("\nWhat difficulty do you want to play with? (1 being the easiest and 5 being the hardest: \n"); 
		int difficulty = input.nextInt();
		
		GameRules[] g = { new Marriage() };
		
		EgyptianRatScrew game = new EgyptianRatScrew(numComputers, difficulty, g);
		
		game.start();
	}
}
