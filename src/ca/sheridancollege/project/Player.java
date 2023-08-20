/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Player {

    private String name; //the unique name for this player
    private Card[] hand = new Card[3];
    private int score = 0;
    
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setHand(Card[] hand){
        this.hand  = hand; 
    }
    
    public Card[] getHand(){
        return hand;
    }
    
    public void drawCard(Card card, int insteadIndex){
        hand[insteadIndex] = card;
    }
    
    public int getScore(){
        return score; 
    }
    
    public void winRound(){
        score += 2;
    } 
}
