package com.Shawn;

import java.util.ArrayList;

/**
 * Created by Wolfknightx on 3/12/2016.
 * The discard deck which cards will be played to.  The top card will always be shown and counted as the leading
 * card for which players are playing to (match).
 */
public class oDiscardDeck {
    ArrayList<oCard> discardDeck = new ArrayList<oCard>();
    oCard lastCard = new oCard();

    public void discardACard (oCard card){
        discardDeck.add(card);//add a card to the discard deck - this will build the discard the deck.
        lastCard = card; //set the new value of the last card which will be shown.
    }
}
