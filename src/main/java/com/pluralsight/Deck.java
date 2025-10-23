package com.pluralsight;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        String[] suits = {"Hearts","Spades","Diamonds","Clubs"};
        String[] values = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        for (String suit : suits){
            for(String value:values){

            }
        }
    }
}
