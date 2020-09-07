# EgyptianRatScrew

NOTE: PLEASE RUN THE CODE INSIDE THE "EgyptionRatScrew" FOLDER   
NOTE: PLEASE DISREGARD THE "src" FOLDER!!!   
### Running the Code
```
$ javac -sourcepath src -d bin src/**/*.java
$ java -cp bin main.Index
```
### Instructions
This game is called Egyptian Rat Screw, otherwise known as ERS. There are many different variations for this game, but the one that I coded will be a slightly simplified version, where this implementation will be a single player game. 
This game is a very time dependent game -- the goal of this game is to get all 52 cards before the opponent can. At the beginning of the game, the cards are shuffled and the same number of cards are given to both players. Each turn, the player takes the card they have at the top of the deck and and places it in the middle face-up. 
The method in which a player can take all of the cards in the middle is by "slapping" it. When certain conditions are met, whoever slaps the deck first gets to take all of the cards in the middle. The game continues until one person runs out of cards or collects all 52 cards. 

### How to Play
After launching the program the user will be prompted to choose a difficulty level. As the difficulty level increases, the user will have less time to slap the deck before the opponent does. The opponent will always start first and after the oponent places their card, the user can place their card by inputting any key (except for 's') into the console. At any time, however, the user can press 's' to signal that they want to slap the middle. If one of the rules are met, then whoever slapped the deck first will recieve all the cards. However, if none of the rules are met and the user still slaps the middle, they will be forced to pay a card as a penalty. Below are all the included rules in the game (descriptions were taken from the bicyclecards.com website)

* Double – When two cards of equivalent value are laid down consecutively. Ex: 5, 5
* Sandwich – When two cards of equivalent value are laid down consecutively, but with one card of different value between them. Ex: 5, 7, 5
* Top Bottom – When the same card as the first card of the set is laid down.
* Tens – When two cards played consecutively add up to 10. Ex: 3, 7
* Four in a row – When four cards with values in consistent ascending are placed. Ex: 5, 6, 7, 8 
* Marriage – When a queen is placed over or under a king. Ex: Q, K or K,Q

### Design
The classes for the rules all inherited from a custom "GameRules" interface to permit for easy addition and removal for other potential rules. The user, computer, and "middle pile" decks were all implemented with Java's Collections LinkedList class, as the sizes of the players' hands were constantly changing (which made it convenient to quickly add or remove cards from different decks). 
A shuffling algorithm called the Fisher-Yates algorithm was also used to shuffle all of the cards at the beginning of the program. 

### Starting Screen Example
```
===========================================================================
====================== WELCOME TO EGYPTIAN RAT SLAP! ======================
===========================================================================

In this game, enter any key to put a card down and
enter 's' to slap the deck. Best of luck!

What difficulty (1 - 5) do you wish to play with? (1 being the easiest and 5 being the hardest): 1

The next questions will ask you for which rules you want to play by. 
              (The Doubles rule is selected as default)             

Would you like to include the Four in a Row rule? (Y/N) : y
Would you like to include the Marriage rule? (Y/N) : y
Would you like to include the Sandwich rule? (Y/N) : y
Would you like to include the Tens rule? (Y/N) : y
Would you like to include the Top-Bottom rule? (Y/N) : y
```

### Example of Playing
```
Opponent putting card down...

BLACK 9 ♠
a

Putting your card down...

BLACK 9 ♠
RED 3 ♥

Opponent putting card down...

BLACK 9 ♠
RED 3 ♥
RED Q ♥
a

Putting your card down...

BLACK 9 ♠
RED 3 ♥
RED Q ♥
BLACK J ♠

Opponent putting card down...

BLACK 9 ♠
RED 3 ♥
RED Q ♥
BLACK J ♠
RED 9 ♦
a
The opponent slapped in!... The opponent won this round
Opponent putting card down...

BLACK 3 ♣
a

Putting your card down...

BLACK 3 ♣
RED 7 ♥

s
You won this round!
```




