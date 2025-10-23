package com.pluralsight;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
        this.isFaceUp = false;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public String getValue() {
        return value;
    }

    public int getPointValue(){
        return Integer.parseInt(value);
    }

    public void flip(){
        if (isFaceUp){
            isFaceUp = false;
        }else {
            isFaceUp = true;
        }
    }
}
