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
    
    
    public void pintarTablero(){
        System.out.println("_________________");
        for(int i = 0 ; i <= FINAL_TABLERO ; i++){
             for(int j = 0 ; j <= FINAL_TABLERO ; j++){
                 System.out.print("|" + huecos[i][j]);
            }
             System.out.println("|");
        }
        System.out.println("-----------------");
    }
                                
}
