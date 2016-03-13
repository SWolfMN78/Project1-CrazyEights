package com.Shawn;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by Wolfknightx on 3/12/2016.
 * Create a single deck of 52 cards: 4 suits ranging from 2-9 + Ace, Jack, Queen, King
 */
public class oDeck {
    ArrayList<oCard> cards = new ArrayList<oCard>(); //this is the intended deck we'll be pushing cards into.
    enum cardsuit {Hearts, Spade, Clubs, Diamonds}
    enum cardValue{Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King}

    public void createCards(){
        for(cardsuit suit: cardsuit.values()) //Walk through the first enumeration 4 times
        {
            for(cardValue face: cardValue.values()) //within the top loop run this for each value
            {
                oCard newCard = new oCard();
                newCard.faceValue = face;
                newCard.suit = suit;

                cards.add(newCard);//using the oCards(newCard) build a new card and throw it into the array.
            }
        }
    }
}
