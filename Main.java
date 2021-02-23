package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Deck deck = new Deck();
        System.out.println("Antes de mezclar");
        deck.print();
        System.out.println();

        System.out.println("Despues de mezclar");
        deck.shuffle();
        deck.print();
        System.out.println();
    }
}
