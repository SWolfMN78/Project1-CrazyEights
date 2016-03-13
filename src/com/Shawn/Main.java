package com.Shawn;

public class Main {
    static oTable gameRules = new oTable();

    public static void main(String[] args) {
	// From here we handle calling the different objects to run the game. 1) game start - follow the CECP.
        double playerOneScore = 0;
        double playerTwoScore = 0;

        //call the table to start a new game - this will also shuffle the deck
        gameRules.gameStart();

        //Deal 7 cards to each player
        gameRules.openingHands();
        System.out.println(gameRules.gameDiscard.lastCard.newCard());
    }
}
