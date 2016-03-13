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
        return faceValue + " of " + suit + " = " + cardCode();
}
    public String cardCode(){
        String suitCode = "";
        String faceCode = "";

        switch (suit){
            case Hearts: suitCode = "H";
                break;
            case Diamonds: suitCode = "D";
                break;
            case Spades: suitCode = "S";
                break;
            case Clubs: suitCode = "C";
        }
        switch (faceValue){
            case Ace: faceCode = "A";
                break;
            case Two: faceCode = "2";
                break;
            case Three: faceCode = "3";
                break;
            case Four: faceCode = "4";
                break;
            case Five: faceCode = "5";
                break;
            case Six: faceCode = "6";
                break;
            case Seven: faceCode = "7";
                break;
            case Eight: faceCode = "8";
                break;
            case Nine: faceCode = "9";
                break;
            case Ten: faceCode = "10";
                break;
            case Jack: faceCode = "J";
                break;
            case Queen: faceCode = "Q";
                break;
            case King:faceCode = "K";
                break;
        }
        return faceCode + suitCode;
    }
}
