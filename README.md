# War - Card Game

The War card game is a simple card game played by 2 or more players. There are many variations of the game, but the game contained in this code has the following rules. 

### Deck

* The deck contains 52 cards
* There are 4 standard suits (clubs, spades, hearts, diamonds), but the suits do not really matter in this game, nor does the color. 
* The cards have values from 2 to 14 with J, Q, K, A being 11, 12, 13, 14 and the numbers having their respective values.

### Rules

* Each player simulatneiously shows his/her card face up and the player with the card having the highest value takes the two cards and puts it in the bottom of his pile of cards.
* If two or more players have the highest card (same value card of different suites), then a WAR is declared. 
* Rules are different for a 2 player game and a game with more than 2 players, in this particular implementation.
* In the two player game, the players keep going until someone gets a higher ranked card and then winner would take all the cards which were involved during the war.
* The more than 2 players game has a fun twist. A winner is randomly chosen and would take the spoils of the WAR


## Config, Installation & Running the application

* wargame.properties file is the configuration file where you can specify the number of players. 
* There is a runnable jar file, WarGame.jar which you need to run the program. You can find it the home directory of this repository. 
* Make sure you have java installed on your machine. 
* Place both the WarGame.jar and wargame.properties file in the same location and run the program with following command on your command line. 

  ```java -jar WarGame.jar```
  
* If you want to run this in your IDE, you can clone the repository and import the project. 


### Video Demonstration of program

https://streamable.com/mn2we




