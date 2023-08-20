/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author pakv
 */
public enum Value{
    ACE(14),
    TWO(2), 
    THREE(3), 
    FOUR(4), 
    FIVE(5), 
    SIX(6), 
    SEVEN(7), 
    EIGHT(8),
    NINE(9), 
    TEN(10), 
    JACK(11), 
    QUEEN(12), 
    KING(13);
    
    
    public final int intValue;

    private Value(int intValue) {
        this.intValue = intValue;
    }
}