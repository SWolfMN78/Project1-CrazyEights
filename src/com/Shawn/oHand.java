package com.Shawn;

import java.util.ArrayList;

/**
 * Created by Wolfknightx on 3/12/2016.
 * This will handle the arraylist of cards in either the player hand or cpu hand.
 */
public class oHand {
    ArrayList<oCard> hand = new ArrayList<oCard>(); //the table will control having more than one hand.

    public oCard getCardByCode(String cardCode){
        for (oCard card : hand) {//walk through the hand and check to see if the card matches one in the code.
            if (cardCode.equalsIgnoreCase(card.cardCode())){
                return card;
            }
        }
        return null;
    }

    public int handScore(){
        int finalScore = 0;
        for (oCard card : hand) {
            finalScore += card.faceValues();
        }
        return finalScore;
    }
}
