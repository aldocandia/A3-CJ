package com.company;

import java.util.Objects;


public class Card {

    public enum  Palo
    {
        TREBOL, CORAZON, DIAMANTE, PICA;
    }


    private static final int MIN_VALOR = 1;
    private static final int MAX_VALOR = 13;

    private int valor;
    private  Palo palo;
    //private Color color;

    public Card(int valor, Palo palo /*Color color*/){
        setValor(valor);
        setPalo(palo);
        //setColor(color);
    }

    public int getValor(){
        return valor;
    }

    public void setValor(int valor){
        if(valor<MIN_VALOR || valor >MAX_VALOR)
            throw new RuntimeException(String.format("Rango invalido> %d (de ser entre %d y %d)", valor, MIN_VALOR, MAX_VALOR));
            this.valor = valor;
    }

    public Palo getPalo(){
        return palo;
    }

    public void setPalo(Palo palo){
        if(palo==null)
            throw new RuntimeException("El palo no debe ser null");
        this.palo = palo;
    }

    public String toString() {
        return String.format("%s[Valor= %d, Palo= %s]",
            getClass().getSimpleName(),
            getValor(),
            getPalo().name());
    }

    public String cartaHead(Card cartas[]){
        return String.format("%s[Valor= %d, Palo= %s]", getValor(),getPalo().name());
    }

    public static int getMinValor()
    {
        return MIN_VALOR;
    }


    public static int getMaxValor()
    {
        return MAX_VALOR;
    }


    public static Palo[] getPalos(){
        return Palo.values();
    }
}