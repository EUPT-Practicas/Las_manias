/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Ricardo
 */
public class Hueco {
    private int fila, columna;
    private char simbolo;
    private boolean dama;

    public Hueco(int fila, int columna, char simbolo, boolean dama) {
        this.fila = fila;
        this.columna = columna;
        this.simbolo = simbolo;
        this.dama = dama;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public boolean isDama() {
        return dama;
    }

    public void setDama(boolean dama) {
        this.dama = dama;
    }
    
    

    
}
