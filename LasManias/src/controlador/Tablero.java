/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
class Tablero {
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
        auxHuecos = new Hueco[FINAL_TABLERO][FINAL_TABLERO];
        iniciar();
    }

    public void iniciar(){
        for(int i = 0; i < FINAL_TABLERO ; i++){
            for(int j = 0; j < FINAL_TABLERO ; j++){
                Hueco hueco = new Hueco(i, j, simbolos[i][j], false); 
                huecos[i][j] =  hueco;
                //System.out.println("fila " + i + "columna" + j + ": "+huecos[i][j].getSimbolo());
                
            }
        }    
    }
    public boolean jugadaValida(int fila, int columna, 
                                int nuevaFila, int nuevaColumna){
        char simbolo = huecos[fila][columna].getSimbolo();
        //System.out.println("El simbolo es: " + simbolo);
        int auxFila, auxColumna;
        
        // Movimiento a la izquierda
        auxFila = fila-1;
        auxColumna = columna-1;
        if(auxFila == nuevaFila && auxColumna == nuevaColumna){
            if((auxFila >= 0 && auxColumna >= 0) 
                                   && (huecos[auxFila][auxColumna].getSimbolo() == '.')){
                huecos[auxFila][auxColumna].setSimbolo(simbolo); 
                huecos[fila][columna].setSimbolo('.'); 
                if(auxFila == 0){ // Crear dama
                   huecos[auxFila][auxColumna].setDama(true);  
                }
                return true;
            }
        }    
        // Movimiento a la derecha.    
        auxFila = fila -1;
        auxColumna = columna+1;
        if(auxFila == nuevaFila && auxColumna == nuevaColumna){
            if((auxFila <= FINAL_TABLERO && auxColumna <= FINAL_TABLERO)
                                    && (huecos[auxFila][auxColumna].getSimbolo() == '.')){
                huecos[auxFila][auxColumna].setSimbolo(simbolo);
                huecos[fila][columna].setSimbolo('.');
                if(auxFila == 0){
                   huecos[auxFila][auxColumna].setDama(true);  
                }
                return true;
            }
        } 
        return false;
    }
    
    public void invertir(){
       auxHuecos = new  Hueco[FINAL_TABLERO][FINAL_TABLERO]; 
       int f = 0, c = 0;
       while(f < FINAL_TABLERO){
            for(int i = FINAL_TABLERO-1 ; i >= 0 ; i--){
                for(int j = FINAL_TABLERO-1 ; j >= 0 ; j--){
                    auxHuecos[f][c] = huecos[i][j];
                    c++;
                }
                f++;
                c = 0;
            }
        }
        huecos = auxHuecos;
    }
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
