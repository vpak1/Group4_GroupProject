/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * @author Viktoriya Pak 
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card {
    //default modifier for child classes
    public Value value;
    public Suit suit;
    public Card(Value value, Suit suit){
        this.value=value;
        this.suit=suit;
    }
    
    public Value getValue(){
        return this.value;
    }
    public void setValue(Value value){
        this.value=value;
    }
    public Suit getSuit(){
        return this.suit;
    }
    public void setSuit(Suit suit){
        this.suit=suit;
    }
//     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
//     */
}
 