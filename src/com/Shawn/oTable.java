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
    oHand playerTwoHand = new oHand();//player2 = cpu
    Scanner scanner = new Scanner(System.in);
    boolean isItPlayersTurn = true;

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
        System.out.println("Hands are populated, let's begin.\n");
    }

    public void aceStartingCard(){
        //if starting card is an Eight then display for the player that they can play any card.
        if (gameDiscard.lastCard.faceValue == oDeck.cardValue.Eight){
            System.out.println("The opening card is an 8, you may play any card\n");
        }
    }

    public void turns(){
        while (isGameOver() == false){
            if (isItPlayersTurn == true){
                playerTurn();
            }else {
                cpuTurn();
            }
        }
    }

    private void cpuTurn(){
        //the cpu's turn will have functions in it that control when it's the players turn.
        boolean hasPlayedACard = false;

        for (oCard card : playerTwoHand.hand) {
            if (isValidCardVSDiscard(card.cardCode(), gameDiscard.lastCard)){
                playerTwoHand.hand.remove(card);
                System.out.println("The computer has played a card!\n");
                gameDiscard.discardACard(card);
                hasPlayedACard = true;
                if (card.faceValue != oDeck.cardValue.Eight){
                    System.out.println("The Computer played an Eight, then played another card!");
                    isItPlayersTurn = true;
                }
                break;
            }
        }
        if (hasPlayedACard == false){
            drawCard(playerTwoHand);
            System.out.println("The computer has drawn a card \n");
            isItPlayersTurn = true;
        }
    }

    private void playerTurn(){
        //show the top card to play to.
        System.out.println("The current top card to play to is " + gameDiscard.lastCard.newCard());

        //Display the player hand
        for (oCard card: playerOneHand.hand) {
            System.out.println(card.newCard());
        }

        //Ask the player for which card they wish to play
        System.out.println("It's your turn, please select a card to play by using AH for Ace of hearts or " +
                "5S for 5 of Spades.  H = Hearts, S = Spades, C = Clubs, D = Diamonds.");
        String userInput = scanner.nextLine().toUpperCase();

        //crate a method which will check to see if the hand has a valid card - if not allow a card draw. for now...
        if (userInput.equalsIgnoreCase("draw")){
            drawCard(playerOneHand);
            isItPlayersTurn = false;
        }else {
            if (doesCardExistInHand(userInput, playerOneHand)){
                if (isValidCardVSDiscard(userInput, gameDiscard.lastCard)){
                    oCard x = playerOneHand.getCardByCode(userInput);
                    playerOneHand.hand.remove(x);
                    gameDiscard.discardACard(x);
                    if (x.faceValue != oDeck.cardValue.Eight){
                        System.out.println("You played an Eight!! Play another card!");
                        isItPlayersTurn = false;
                    }
                }else {
                    System.out.println("Not a valid card to play, please try again.");
                }
            }else {
                System.out.println("You do not have that card. Please try again.");
            }
        }
    }

    public boolean doesCardExistInHand (String userInput, oHand playerhand){
        for (oCard card : playerhand.hand) {
            if (userInput.equalsIgnoreCase(card.cardCode())){
                return true;
            }
        }

        return false; //place holder
    }

    public boolean isValidCardVSDiscard (String userInput, oCard lastCard){
        //this is intended to check if the card player wants to play is valid vs the discard pile.
        if (userInput.contains(lastCard.justFaceCode())){
            return true;
        }
        if (userInput.contains(lastCard.justSuitCode())){
            return true;
        }
        if (userInput.contains("8")){
            return true;
        }
        return false;
    }

    public boolean isGameOver(){
        //when this is called the game will not be over unless the following turns out true.
        boolean gameOver = false;

        if (playerTwoHand.hand.size() == 0){
            gameOver = true;
        }
        if (playerOneHand.hand.size() == 0){
            gameOver = true;
        }
        if (gameDeck.cards.size() == 0){
            gameOver = true;
        }
        return gameOver;
    }

    public void whoWon(){
        int handScoreOne = playerOneHand.handScore(); //player score
        int handScoreTwo = playerTwoHand.handScore(); //computer score

        if (handScoreOne < handScoreTwo){
            System.out.println("You won!!  Your score was: " + handScoreOne
                    + ". The computer scored " + handScoreTwo);
        }else {
            System.out.println("You won!!  Your score was: " + handScoreTwo + ". Your score was: " + handScoreOne);
        }
    }
}
