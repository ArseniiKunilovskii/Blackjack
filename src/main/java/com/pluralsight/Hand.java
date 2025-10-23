package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }

    public void deal(Card card){
        cards.add(card);
    }
    public int getSize(){
        return cards.size();
    }
    public int getValue(){
        int value = 0;
        for (Card card:cards){
            card.flip();
            value += card.getPointValue();
            card.flip();
        }
        return value;
    }

    public void print(){
        System.out.println("Cards in Hand:");
        for (Card card:cards){
            card.flip();
            System.out.println(card.getValue() + " of " + card.getSuit());
            card.flip();
        }
    }
}
