package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

class Deck implements Iterable<Card> {

    private int cartasUsadas;
    private Card[] cartas;
    private int top;

    public Deck() {


        //Iniciar Deck

        cartas = new Card[52];
        barajear();

    }
    //Crea el deck de una forma ordenada
    public void barajear() {
        Card.Palo[] palos = Card.getPalos();
        int minValor = Card.getMinValor();
        int maxValor = Card.getMaxValor();

        int i = 0;
        for (Card.Palo palo : palos)
            for (int valor = minValor; valor <= maxValor; valor++)
                cartas[i++] = new Card(valor, palo);

        top = cartas.length - 1;
    }

    //Mezclar deck
    public void shuffle() {
        for (int i = 0; i < 52; i++) {
            int r = (int) (Math.random() * (52));
            Card temporal = cartas[r];
            cartas[r] = cartas[i];
            cartas[i] = temporal;

            System.out.println("Se mezclo deck");
        }
        cartasUsadas = 0;
    }

    //Valor para saber cuando no quedan cartas
    public boolean vacio() {
        return top < 0;
    }


    //Mostrar la primera carta del deck
    public Card head(String[] deck) {
        if (vacio())
            throw new IllegalStateException("No se puede repartir de un deck vacio");
        return cartas[top--];

    }


    public int cartaRestante() {
        return 52 - cartasUsadas;
    }

    public Card darCarta() {
        if (cartasUsadas == 52)
            shuffle();
        cartasUsadas++;
        return cartas[cartasUsadas - 1];
    }

    public void print() {
        if (vacio()) {
            System.out.println("El deck esta vacio");
            return;

        }

        System.out.println("El deck que tienes es: ");
        for (Card carta : this)
            System.out.println("" + carta);
    }

    public Iterator<Card> iterator() {
        return new Iterator<Card>() {
            private int cursor = top;

            public boolean hasNext() {
                return cursor >= 0;
            }

            public Card next() {
                if (hasNext())
                    return cartas[cursor--];
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}