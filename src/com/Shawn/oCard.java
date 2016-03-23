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
        return faceValue + " of " + fancySuit() + " = " + cardCode();
}

    public String cardCode(){
        return justFaceCode() + justSuitCode();
    }

    public String justSuitCode(){
        String suitCode = "";

        switch (suit){
            case Hearts: suitCode = "H";
                break;
            case Diamonds: suitCode = "D";
                break;
            case Spades: suitCode = "S";
                break;
            case Clubs: suitCode = "C";
        }
        return suitCode;
    }

    public String justFaceCode(){
        String faceCode = "";

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
        return faceCode;
    }

    public int faceValues(){
        int value = 0;

        switch (faceValue){
            case Ace: value = 10;
                break;
            case Two: value = 2;
                break;
            case Three: value = 3;
                break;
            case Four: value = 4;
                break;
            case Five: value = 5;
                break;
            case Six: value = 6;
                break;
            case Seven: value = 7;
                break;
            case Eight: value = 50;
                break;
            case Nine: value = 9;
                break;
            case Ten: value = 10;
                break;
            case Jack: value = 10;
                break;
            case Queen: value = 10;
                break;
            case King:value = 10;
                break;
        }
        return value;
    }

    public char fancySuit() {
        char fancySuitCode = 0;

        switch (suit) {
            case Hearts:
                fancySuitCode = 9829;
                break;
            case Diamonds:
                fancySuitCode = 9830;
                break;
            case Spades:
                fancySuitCode = 9824;
                break;
            case Clubs:
                fancySuitCode = 9827;
        }
        return fancySuitCode;
    }
}
