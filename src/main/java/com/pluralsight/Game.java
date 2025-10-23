package com.pluralsight;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean isEnd = false;
        String name = "";
        int choice;
        boolean overdraft = false;
        int numberOfPlayer;

        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Hand dealer = new Hand();

        System.out.println("How many players would play: ");
        numberOfPlayer = scanner.nextInt();
        scanner.nextLine();
        Hand[] hands = new Hand[numberOfPlayer];
        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.println("Hello Player! Please enter your name:");
            name = scanner.nextLine();
            hands[i] = new Hand();
            hands[i].setName(name);
        }


        deck.shuffle();
        dealer.deal(deck.deal());
        for (int i = 0; i < numberOfPlayer; i++) {
            hands[i].deal(deck.deal());
        }
        System.out.println("Dealer's value: " + dealer.getValue());
        dealer.print();

        while (!isEnd){
            for (int i = 0; i < numberOfPlayer; i++) {
                Hand curHand = hands[i];
                System.out.println("\n"+ curHand.getName()+ "'s value: " + curHand.getValue());
                curHand.print();
                if(curHand.getValue()>21){
                    System.out.println("\nOverdraft");
                    curHand.setOverdraft(true);
                    break;
                }
                System.out.println("\nPlease choose what to do?(1 receive next card, 2 to stop)");
                choice= scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 1:
                        curHand.deal(deck.deal());
                        break;
                    case 2:
                        isEnd = true;
                        break;
                    default:
                        System.out.println("Please enter only 1 or 2");
                        break;
                }
            }
        }
        while (dealer.getValue() <= 16) {
            dealer.deal(deck.deal());
            System.out.println("\nDealer's value: " + dealer.getValue());
            dealer.print();
        }
        for (int i = 0; i < numberOfPlayer; i++) {
            Hand curHand = hands[i];
            if (!curHand.isOverdraft()) {
                if (curHand.getValue() > dealer.getValue() || dealer.getValue() > 21) {
                    System.out.println("\nCongratulations, " + curHand.getName()+ "! You Won!");
                } else {
                    System.out.println("Sorry, " + curHand.getName() + "! Casino won!");
                }
            } else {
                System.out.println("\nDealer has " + dealer.getValue());
                System.out.println("Sorry, " + curHand.getName() + "! Casino won!");
            }
        }
    }
}
