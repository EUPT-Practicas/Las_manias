/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Ricardo
 */
public class Tablero extends Observable{
    private static final int FINAL_TABLERO = 8;
    private static final char HUECO_NULO = '.';
    private Hueco huecos[][];
    private Hueco auxHuecos[][];    
                                // 0   1   2   3   4   5   6   7      
    private char[][] simbolos = {{'#','.','#','.','#','.','#','.'}, //0
                                {'.','#','.','#','.','#','.','#'},  //1
                                {'#','.','#','.','#','.','#','.'},  //2
                                {'.','.','.','.','.','.','.','.'},  //3
                                {'.','.','.','.','.','.','.','.'},  //4
                                {'.','o','.','o','.','o','.','o'},  //5
                                {'o','.','o','.','o','.','o','.'},  //6
                                {'.','o','.','o','.','o','.','o'}}; //7
    public Tablero(){
        huecos = new Hueco[FINAL_TABLERO][FINAL_TABLERO];
        iniciar();
    }
    
    public void iniciar(){
        for(int i = 0; i < FINAL_TABLERO ; i++){
            for(int j = 0; j < FINAL_TABLERO ; j++){
                Hueco hueco = new Hueco(i, j, simbolos[i][j], false); 
                huecos[i][j] =  hueco;
                setChanged();
                this.notifyObservers(huecos[i][j]);
            }
        }    
    }
    
    
    /**
     * Permite saber si el movimiento introducico por el usuairo es valido
     * @param fila
     * @param columna
     * @param nuevaFila
     * @param nuevaColumna
     * @return 
     */
    
    public boolean jugadaValida(int fila, int columna, int nuevaFila, int nuevaColumna, char simboloOponente){
        boolean ok = false, salto = false;
        int auxFila, auxColumna;
        int auxFilaSalto = -1 , auxColumnaSalto = -1;
        int auxFilaSaltoDerecha = -1 , auxColumnaSaltoDerecha = -1;
        char nuevoSimbolo; 
        
        if(!huecos[fila][columna].isDama() || huecos[fila][columna].isDama()){                    //si no es dama
            //Movimiento superior izquierdo
            auxFila = fila -1;
            auxColumna = columna -1;
            // Si el movimiento va con salto
            if(auxFila >= 0 && auxColumna >=0){
                if(huecos[auxFila][auxColumna].getSimbolo() == simboloOponente){ 
                    auxFilaSalto = fila -2;
                    auxColumnaSalto = columna - 2;
                    salto = true;
                }
            }
            
            if( ( (auxFila == nuevaFila && auxColumna == nuevaColumna) || 
                 (auxFilaSalto == nuevaFila && auxColumnaSalto == nuevaColumna) ) 
                                           && (auxFila >= 0 && auxColumna >=0)){
                //System.out.println("Entraaa");
                ok = movimientoSuperiorIzquierdo(fila, columna, nuevaFila, nuevaColumna, simboloOponente, salto);
                //System.out.println("El error es: " + ok);
            }
            
            //Movimiento superior derecho
            auxFila = fila -1;
            auxColumna = columna +1;
            if(auxFila >= 0 && auxColumna < FINAL_TABLERO){ 
                if(huecos[auxFila][auxColumna].getSimbolo() == simboloOponente){
                    auxFilaSaltoDerecha = fila -2;
                    auxColumnaSaltoDerecha = columna + 2;
                    salto = true;
                }
            }
            
            if( ( (auxFila == nuevaFila && auxColumna == nuevaColumna) ||
                    (auxFilaSaltoDerecha == nuevaFila && auxColumnaSaltoDerecha == nuevaColumna))
                                && (auxFila >= 0 && auxColumna < FINAL_TABLERO)){
                System.out.println("NO deberia de entra aqui");
                //System.out.println("Entra hacia la derecha");
                ok = movimientoSuperiorDerecho(fila, columna, nuevaFila, nuevaColumna, simboloOponente, salto);
                System.out.println("El error es: " + ok);
            }
        }else if(huecos[fila][columna].isDama()){                                                  //si no es dama
            //Movimiento inferior izquierdo
            auxFila = fila +1;
            auxColumna = columna -1;
            // Si el movimiento va con salto
            if(auxFila >= 0 && auxColumna >=0){
                if(huecos[auxFila][auxColumna].getSimbolo() == simboloOponente){ 
                    auxFilaSalto = fila +2;
                    auxColumnaSalto = columna - 2;
                    salto = true;
                }
            }
            
            if( ( (auxFila == nuevaFila && auxColumna == nuevaColumna) || 
                 (auxFilaSalto == nuevaFila && auxColumnaSalto == nuevaColumna) ) 
                                           && (auxFila >= 0 && auxColumna >=0)){
                //System.out.println("Entraaa");
                ok = movimientoInferiorIzquierdo(fila, columna, nuevaFila, nuevaColumna, simboloOponente, salto);
                //System.out.println("El error es: " + ok);
            }
            
            //Movimiento superior derecho
            auxFila = fila +1;
            auxColumna = columna +1;
            if(auxFila >= 0 && auxColumna < FINAL_TABLERO){ 
                if(huecos[auxFila][auxColumna].getSimbolo() == simboloOponente){
                    auxFilaSaltoDerecha = fila +2;
                    auxColumnaSaltoDerecha = columna + 2;
                    salto = true;
                }
            }
            
            if( ( (auxFila == nuevaFila && auxColumna == nuevaColumna) ||
                    (auxFilaSaltoDerecha == nuevaFila && auxColumnaSaltoDerecha == nuevaColumna))
                                && (auxFila >= 0 && auxColumna < FINAL_TABLERO)){
                System.out.println("NO deberia de entra aqui");
                //System.out.println("Entra hacia la derecha");
                ok = movimientoInferiorDerecho(fila, columna, nuevaFila, nuevaColumna, simboloOponente, salto);
                System.out.println("El error es: " + ok);
            }
        }   
        return ok;
    }
    public boolean movimientoSuperiorIzquierdo(int fila, int columna, int nuevaFila, int nuevaColumna, char simboloOponente, boolean salto){
        System.out.println("\t - Movimiento a la izquierda.");
        char simbolo = huecos[fila][columna].getSimbolo();
        char siguieteCasilla = huecos[nuevaFila][nuevaColumna].getSimbolo();
        if(siguieteCasilla == '.' || siguieteCasilla == 'x' ){
            huecos[nuevaFila][nuevaColumna].setSimbolo(simbolo);
            huecos[fila][columna].setSimbolo('.');
            huecos[fila][columna].setDama(false);

            if(salto){
                System.out.println("Comida hacia la izquierda");
                huecos[fila-1][columna-1].setSimbolo('.');
                huecos[fila-1][columna-1].setDama(false);
            }
            if(nuevaFila == 0){
                huecos[nuevaFila][nuevaColumna].setDama(true);
            }
            return true;
        }
        return false;
    }
        public boolean movimientoSuperiorDerecho(int fila, int columna, int nuevaFila, int nuevaColumna, char simboloOponente, boolean salto){
        System.out.println("\t - Movimiento a la Derecha.");
        char simbolo = huecos[fila][columna].getSimbolo();
        char siguieteCasilla = huecos[nuevaFila][nuevaColumna].getSimbolo();
        if(siguieteCasilla == '.' || siguieteCasilla == 'x' ){
            huecos[nuevaFila][nuevaColumna].setSimbolo(simbolo);
            huecos[fila][columna].setSimbolo('.');
            huecos[fila][columna].setDama(false);
            
            if(salto){
                System.out.println("Comida hacia la derecha");
                huecos[fila-1][columna+1].setSimbolo('.');
                huecos[fila-1][columna+1].setDama(false);
            }
            if(nuevaFila == 0){
                huecos[nuevaFila][nuevaColumna].setDama(true);
            }
            return true;
        }
        return false;
    }
     public boolean movimientoInferiorIzquierdo(int fila, int columna, int nuevaFila, int nuevaColumna, char simboloOponente, boolean salto){
        System.out.println("\t - Movimiento a la izquierda.");
        char simbolo = huecos[fila][columna].getSimbolo();
        char siguieteCasilla = huecos[nuevaFila][nuevaColumna].getSimbolo();
        if(siguieteCasilla == '.' || siguieteCasilla == 'x' ){
            huecos[nuevaFila][nuevaColumna].setSimbolo(simbolo);
            huecos[nuevaFila][nuevaColumna].setDama(true);
            huecos[fila][columna].setSimbolo('.');
            huecos[fila][columna].setDama(false);

            if(salto){
                System.out.println("Comida hacia la izquierda");
                huecos[fila+1][columna-1].setSimbolo('.');
                huecos[fila+1][columna-1].setDama(false);
            }
            if(nuevaFila == 0){
                huecos[nuevaFila][nuevaColumna].setDama(true);
            }
            return true;
        }
        return false;
    }
        public boolean movimientoInferiorDerecho(int fila, int columna, int nuevaFila, int nuevaColumna, char simboloOponente, boolean salto){
        System.out.println("\t - Movimiento a la Derecha.");
        char simbolo = huecos[fila][columna].getSimbolo();
        char siguieteCasilla = huecos[nuevaFila][nuevaColumna].getSimbolo();
        if(siguieteCasilla == '.' || siguieteCasilla == 'x' ){
            huecos[nuevaFila][nuevaColumna].setSimbolo(simbolo);
            huecos[nuevaFila][nuevaColumna].setDama(true);
            huecos[fila][columna].setSimbolo('.');
            huecos[fila][columna].setDama(false);
            
            if(salto){
                System.out.println("Comida hacia la derecha");
                huecos[fila+1][columna+1].setSimbolo('.');
                huecos[fila+1][columna+1].setDama(false);
            }
            if(nuevaFila == 0){
                huecos[nuevaFila][nuevaColumna].setDama(true);
            }
            return true;
        }
        return false;
    }
  
    
    /**
     * Invierte el tablero para que el usuario siempre juegue desde abajo.
     */
    public void invertir(){
       auxHuecos = new Hueco[FINAL_TABLERO][FINAL_TABLERO];
       for (int i = 0 ; i < FINAL_TABLERO; i++){
            for (int j = 0; j < FINAL_TABLERO; j++) {
                auxHuecos[i][j] = new Hueco(i, j, HUECO_NULO, false);
            }
        }
       int f = 0, c = 0;
       while(f < FINAL_TABLERO){
            for(int i = FINAL_TABLERO-1 ; i >= 0 ; i--){
                for(int j = FINAL_TABLERO-1 ; j >= 0 ; j--){
                    auxHuecos[f][c].setSimbolo(huecos[i][j].getSimbolo());
                    auxHuecos[f][c].setDama(huecos[i][j].isDama());
                    setChanged();
                    this.notifyObservers(auxHuecos[f][c]);
                    c++;
                }
                f++;
                c = 0;
            }
        }
       
        huecos = auxHuecos;
    }
    
    /**
     * muestra las casillas a las que se puede mover la ficha.
     * @param fila
     * @param columna
       */
    public void posiblesMovimientos(int fila, int columna){
        int auxFila, auxColumna;
        char simbolo = huecos[fila][columna].getSimbolo();
        if(!huecos[fila][columna].isDama()){
            //Mostrar obcion hacia la izquierda.
            auxFila = fila -1;
            auxColumna = columna -1;
            if(huecos[auxFila][auxColumna].getSimbolo() == '.' ){
               huecos[auxFila][auxColumna].setSimbolo('x'); 
               setChanged();
               this.notifyObservers(huecos[auxFila][auxColumna]);
            }
            auxFila = fila -1;
            auxColumna = columna +1;
            if(huecos[auxFila][auxColumna].getSimbolo() == '.' ){
               huecos[auxFila][auxColumna].setSimbolo('x'); 
               setChanged();
               this.notifyObservers(huecos[auxFila][auxColumna]);
            }
        } //Falta si es dama
        
        this.pintarTablero();
    }
    public void eliminarPosiblesMovimientos(){
        for(int i = 0; i < FINAL_TABLERO ; i++){
            for (int j = 0; j < FINAL_TABLERO; j++) {
                if(huecos[i][j].getSimbolo() == 'x'){
                    huecos[i][j].setSimbolo('.');
                    setChanged();
                    this.notifyObservers(huecos[i][j]);
                }
            }
        }
    }
    /**
     * No permitira al usuario hacer un movimiento si tiene que comer una ficha
     * @param simbolo
     * @return 
     */
    public ArrayList movimientoObligatorio(char simbolo){
        ArrayList movimientosPosibles = new ArrayList();
        int fila, columna;
        for(int i = 0 ; i < FINAL_TABLERO ; i++){
            for(int j = 0 ; j < FINAL_TABLERO ; j++){
                if(huecos[i][j].isDama()){  //MOver hacia abajo
                    fila = i + 1;               // Derecha
                    columna = j + 1;
                    if((fila < FINAL_TABLERO && columna < FINAL_TABLERO) && (huecos[fila][columna].getSimbolo() != simbolo)){
                        movimientosPosibles.add(huecos[i][j]);
                    }
                    fila = i + 1;               // Izquierda
                    columna = j - 1;
                    if((fila < FINAL_TABLERO && columna >= 0) && (huecos[fila][columna].getSimbolo() != simbolo)){
                        movimientosPosibles.add(huecos[i][j]);
                    }
                }                          //Mover hacia arriba
                fila = i - 1;               // Derecha
                columna = j + 1;
                if((fila >=0 && columna < FINAL_TABLERO) && (huecos[fila][columna].getSimbolo() != simbolo)){
                    movimientosPosibles.add(huecos[i][j]);
                }
                fila = i - 1;               // Izquierda
                columna = j - 1;
                if((fila >=0 && columna >= 0) && (huecos[fila][columna].getSimbolo() != simbolo)){
                    movimientosPosibles.add(huecos[i][j]);
                }
                
            }
        }
        return movimientosPosibles;
    }
    

    
    public void pintarTablero(){
        System.out.println("");
        System.out.println("   1|2|3|4|5|6|7|8 ");
        //System.out.println("  _________________");
        for(int i = 0 ; i < FINAL_TABLERO ; i++){
            System.out.print((i+1) + " ");
             for(int j = 0 ; j < FINAL_TABLERO ; j++){
                 System.out.print("|" + huecos[i][j].getSimbolo());
            }
             System.out.println("|");
        }
        System.out.println("-----------------");
    }
                                
}
