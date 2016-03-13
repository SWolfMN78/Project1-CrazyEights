package com.Shawn;

import java.util.*;

/**
 * Created by Wolfknightx on 3/12/2016.
 * This will be where all my magic aka rules happen.
 * The main will call the table for any and all rules or actions that need to be executed.
 */
public class oTable {
    oDeck gameDeck = new oDeck();
    oDiscardDeck gameDiscard = new oDiscardDeck();
    oHand playerOneHand = new oHand();
    oHand playerTwoHand = new oHand();
    Scanner scanner = new Scanner(System.in);

    public void gameStart(){
        //create the starting deck
        gameDeck.createCards();
        Collections.shuffle(gameDeck.cards, new Random()); //shuffle the deck after it's created
    }

    public void drawCard(oHand player){
        //this will be used to draw a card and deal cards
        player.hand.add(gameDeck.cards.get(0));//get the first card and add it
        gameDeck.cards.remove(0);//remove the card from the deck
    }

    public void openingHands(){
        //populate the player hands with 7 cards.
        for (int x = 0; x < 7; x++){
            drawCard(playerOneHand);
            drawCard(playerTwoHand);
        }
        gameDiscard.discardACard(gameDeck.cards.get(0));//add the first card to the discard deck
        gameDeck.cards.remove(0);//remove
    }

    public void turns(){
        //show the top card to play to.
        System.out.println(gameDiscard.lastCard);

        //Ask the player for which card they wish to play
        System.out.println("It's your turn, please select a card to play by using AH for Ace of hearts or " +
                "5S for 5 of Spades.  H = Hearts, S = Spades, C = Clubs, D = Diamonds.");

    }
}
