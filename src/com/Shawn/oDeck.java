package com.Shawn;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by Wolfknightx on 3/12/2016.
 * Create a single deck of 52 cards: 4 suits ranging from 2-9 + Ace, Jack, Queen, King
 */
public class oDeck {
    ArrayList<oCard> cards = new ArrayList<oCard>(); //this is the intended deck we'll be pushing cards into.
    enum cardsuit {Hearts, Spades, Clubs, Diamonds}
    enum cardValue{Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King}

    public void createCards(){
        for(cardsuit suit: cardsuit.values()) //Walk through the first enumeration 4 times
        {
            if (cardsuit.values().equals("Hearts")){
                char heart =9829; //set the symbol to hearts
            }else if (cardsuit.values().equals("Spade")){
                char spade =9824; //set the symbol to spades
            }else if (cardsuit.values().equals("Clubs")){
                char club = 9827; //set the symbol to clubs
            }else if (cardsuit.values().equals("Diamonds")){
                char diamond = 9830; //set the symbol to dismonds
            }
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
