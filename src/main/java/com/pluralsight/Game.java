package com.pluralsight;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean isEnd = false;
        String name;
        int choice;
        boolean overdraft = false;

        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Hand dealer = new Hand();
        Hand player = new Hand();

        System.out.println("Hello Player! Please enter your name:");
        name = scanner.nextLine();

        deck.shuffle();
        dealer.deal(deck.deal());
        player.deal(deck.deal());
        System.out.println("Dealer's value: " + dealer.getValue());
        dealer.print();

        while (!isEnd){
            System.out.println("\nPlayer's value: " + player.getValue());
            player.print();
            if(player.getValue()>21){
                System.out.println("\nOverdraft");
                overdraft=true;
                break;
            }
            System.out.println("Please choose what to do?(1 receive next card, 2 to stop)");
            choice= scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    player.deal(deck.deal());
                    break;
                case 2:
                    isEnd = true;
                    break;
                default:
                    System.out.println("Please enter only 1 or 2");
                    break;
            }
        }
        if(!overdraft) {
            while (dealer.getValue() <= 16) {
                dealer.deal(deck.deal());
                System.out.println("\nDealer's value: " + dealer.getValue());
                dealer.print();
            }
            if (player.getValue() > dealer.getValue() || dealer.getValue() > 21) {
                System.out.println("Congratulations, " + name + "! You Won!");
            } else {
                System.out.println("Sorry, " + name + "! Casino won!");
            }
        }else {
            System.out.println("\nDealer has " + dealer.getValue());
            System.out.println("Sorry, " + name + "! Casino won!");
        }
    }
}
