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
class Tablero {
    private static final int FINAL_TABLERO = 7;
    private char[][] huecos = {{'#',' ','#',' ','#',' ','#',' '},
                               {' ','#',' ','#',' ','#',' ','#'},
                               {'#',' ','#',' ','#',' ','#',' '},
                               {' ',' ',' ',' ',' ',' ',' ',' '},
                               {' ',' ',' ',' ',' ',' ',' ',' '},
                               {' ','o',' ','o',' ','o',' ','o'},
                               {'o',' ','o',' ','o',' ','o',' '},
                               {' ','o',' ','o',' ','o',' ','o'}};
    
    public boolean jugadaValida(int fila, int columna, 
                                int nuevaFila, int nuevaColumna, boolean izquierda){
         char simbolo = huecos[fila][columna];
        int auxFila, auxColumna;
        if(izquierda){
            auxFila = fila-1;
            auxColumna = columna-1;
            if((auxFila >= 0 && auxColumna >= 0) 
                                   && (huecos[auxFila][auxColumna] == ' ')){
                huecos[auxFila][auxColumna] = simbolo;
                huecos[fila][columna] = ' ';
                return true;
            }
        }else{
            auxFila = fila-1;
            auxColumna = columna+1;
            if((auxFila <= FINAL_TABLERO && auxColumna <= FINAL_TABLERO)
                                    && (huecos[auxFila][auxColumna] == ' ')){
                huecos[auxFila][auxColumna] = simbolo;
                huecos[fila][columna] = ' ';
                return true;
            }
        } 
        
        
        return false;
    }
    
    public void pintarTablero(){
        System.out.println("   1|2|3|4|5|6|7|8 ");
        //System.out.println("  _________________");
        for(int i = 0 ; i <= FINAL_TABLERO ; i++){
            System.out.print((i+1) + " ");
             for(int j = 0 ; j <= FINAL_TABLERO ; j++){
                 System.out.print("|" + huecos[i][j]);
            }
             System.out.println("|");
        }
        System.out.println("-----------------");
    }
                                
}
