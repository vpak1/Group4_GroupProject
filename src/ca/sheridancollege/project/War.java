/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author pakv
 */
public class War extends Game {
    Card[] deckOfCards = new Card[52];
    Player[] players = new Player[2];
    
    public War(String name) {
        super(name);
    }
   
    
    @Override
    public void play() {        
        //Populate Deck of Cards
        int counter = 0;
        for (Suit value1 : Suit.values()) {
            for (Value value : Value.values()) {
                Card card = new Card(value, value1);
                deckOfCards[counter] = card;
                counter++;
            }
        }
        //Shuffle Cards Randomly
        Collections.shuffle(Arrays.asList(deckOfCards));

        //Create players and assign hands to them
        initializePlayers();
        Player player1 = players[0];
        Player player2 = players[1];
        
        //Delete first six cards from the deck of cards
        deckOfCards = updateDeckOfCards(deckOfCards, 6);
        
        //Start the game process
        Scanner scanner = new Scanner(System.in);
        
        
        while(deckOfCards.length != 0){
            //player 1 choice and draw the card
            System.out.println("--------------------------------------------------");
            System.out.println(player1.getName() + " choose card(ENTER 1, 2 OR 3)" );
            int cardIndex1 = scanner.nextInt() - 1;
            Card selectedCard1 = player1.getHand()[cardIndex1];
            System.out.println(player1.getName() + " card is: " + selectedCard1.value + " " + selectedCard1.suit);
            player1.drawCard(deckOfCards[0], cardIndex1);
            System.out.println("");
            System.out.println("");
            //player 2 choice and draw the card
            System.out.println(player2.getName() + " choose card(ENTER 1, 2 OR 3)" );
            int cardIndex2 = scanner.nextInt() - 1;
            Card selectedCard2 = player2.getHand()[cardIndex2];
            System.out.println(player2.getName() + " card is: " + selectedCard2.value + " " + selectedCard2.suit);
            player2.drawCard(deckOfCards[1], cardIndex2);
            System.out.println("");
            System.out.println(""); 
            if(selectedCard1.value.intValue > selectedCard2.value.intValue){
                System.out.println(selectedCard1.value + " " + selectedCard1.suit + " beats " + selectedCard2.value + " " + selectedCard2.suit);
                System.out.println("Round won " + player1.getName());
                System.out.println("--------------------------------------------------");
                player1.winRound();
            }else{
                System.out.println(selectedCard2.value + " " + selectedCard2.suit + " beats " + selectedCard1.value + " " + selectedCard1.suit);
                System.out.println("Round won " + player2.getName());
                System.out.println("--------------------------------------------------");
                player2.winRound();
            }
            
            //Update Deck of Cards once cards has been drawn by both players
            deckOfCards = updateDeckOfCards(deckOfCards, 2);
        }
        declareWinner(player1, player2);
    }
    
    @Override
    public void declareWinner(Player player1, Player player2) {
        System.out.println("Final Score:");
        System.out.println(player1.getName() + " : " + player1.getScore() + "   " + player2.getScore() + " : " + player2.getName());
        if(player1.getScore() > player2.getScore()){
            System.out.println("Contgratulation!!!! You won!!!!!!! BAAAAM BOOOOM!!!!! " + player1.getName());
        }else{
            System.out.println("Contgratulation!!!! You won!!!!!!! BAAAAM BOOOOM!!!!! " + player2.getName());
        }
        System.out.println("	┻━┻ ︵ヽ(`Д´)ﾉ︵ ┻━┻");
    }
    
    public Card[] updateDeckOfCards(Card[] deckOfCards, int fromIndex){
        int newLength = deckOfCards.length - fromIndex; 
        Card[] updatedDeck = new Card[newLength];
        int j = 0;
        
        for(int i = fromIndex; i < deckOfCards.length; i++){
            updatedDeck[j] = deckOfCards[i];
            j++;
        }
        
        return updatedDeck;
    }
    
    public void initializePlayers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1 please enter your name: ");
        String name1 = scanner.nextLine();
        System.out.println("Player 2 please enter your name: ");
        String name2 = scanner.nextLine();
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        Card[] hand1 = {deckOfCards[0],deckOfCards[1],deckOfCards[2]};
        Card[] hand2 = {deckOfCards[3],deckOfCards[4],deckOfCards[5]};
        player1.setHand(hand1);
        player2.setHand(hand2);
        players[0] = player1; 
        players[1] = player2;
    }    
}
