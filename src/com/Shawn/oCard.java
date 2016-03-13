package com.Shawn;

/**
 * Created by Wolfknightx on 3/12/2016.
 * This is the basic structure of what makes a card
 * Facevalue + Suit
 */
public class oCard {
    oDeck.cardValue faceValue; //will set the values - Ace - 2-10 - Jack, Queen, King
    oDeck.cardsuit suit; //will set the values later - Hearts, Diamonds, Spades, Club

public String newCard(){
    return faceValue + " of " + suit;
}
}
