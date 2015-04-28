/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ricardo
 */
public class Partida {
    private static final char SIMBOLO_UNO = 'o';
    private static final char SIMBOLO_DOS = '#';
    
    private int id;
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Hueco hueco;
    private Scanner scan = new Scanner(System.in);
    private boolean primerTurno = true;
    
    private ArrayList movimientosPosibles = new ArrayList();
    /**
     * Constructor para inicializar una nueva partida.
     */
    public Partida() {
        tablero = new Tablero();
        jugador1 = new Jugador("Ricardo", SIMBOLO_UNO);
        jugador2 = new Jugador("Alvaro", SIMBOLO_DOS);
    }
        /**
     * Empieza la partida y comprueba si se debe seguir jugando.
     */
    public void jugar(){
        Jugador jugadorActual;
        int fila, columna, nuevaFila, nuevaColumna;
        boolean ok = false;
        boolean permitirJugada = false;
        //Prueba mover a la izquierda
//        ok = tablero.jugadaValida(5, 1, 4, 0);
//        ok = tablero.jugadaValida(5, 1, 3, -1);
        //Prueba mover a la derecha
//        ok = tablero.jugadaValida(5, 5, 4, 6);
//        ok = tablero.jugadaValida(4, 6, 3, 7);
//        ok = tablero.jugadaValida(4, 6, 2, 8);
        
        
//        tablero.pintarTablero(); 
//        
//        if(ok){
//            System.out.println("Bien");
//        }else{
//            System.out.println("Mal");
//        }
 
        System.out.println("Finaliza"); 
        
        
        while(true){
            if(primerTurno){
                jugadorActual = jugador1;
            }else{
                jugadorActual = jugador2;
            }
            //jugadorActual.setSuTurno(true);
            System.out.println("TURNO JUGADOR: " + jugadorActual.getSimbolo());
            tablero.pintarTablero();
            movimientosPosibles = tablero.movimientoObligatorio(jugadorActual.getSimbolo());
            System.out.println("Introduce fila: ");
            fila = leerNumero();
            System.out.println("Introduce columna: ");
            columna = leerNumero();
            System.out.println("Introduce nueva fila: ");
            nuevaFila = leerNumero();
            System.out.println("Introduce nueva columna: ");
            nuevaColumna = leerNumero();
            
            if(movimientosPosibles.size() > 0){
                for(int i = 0 ; i <= movimientosPosibles.size() && !permitirJugada; i++){
                   hueco = (Hueco) movimientosPosibles.get(i);
                   if(hueco.getFila() == nuevaFila && hueco.getColumna() == nuevaColumna){
                       permitirJugada = true;
                   }else{
                       System.out.println("Debes de matar!!!!");
                        System.out.println("Introduce fila: ");
                        fila = leerNumero();
                        System.out.println("Introduce columna: ");
                        columna = leerNumero();
                        System.out.println("Introduce nueva fila: ");
                        nuevaFila = leerNumero();
                        System.out.println("Introduce nueva columna: ");
                        nuevaColumna = leerNumero();
                   }
                }
            }

            
            if(tablero.jugadaValida(fila, columna, nuevaFila, nuevaColumna)){
//                if(tablero.jugadaGanadora(columna)){
//                    mensaje("¡ " + jugadorActual.getNombre() + " es el ganador!"); 
//                    jugadorActual.sumarPartidaGanada();
//                    tablero.pintarTablero(jugadorActual.getSimbolo());
//                    //nuevaPartida();
//                }
                siguienteTurno();
                tablero.invertir();
               //tablero.pintarTablero();
                //jugadorActual.setSuTurno(false);
            }else{
                mensaje("esta mal");
            }
        }
    }
    public int leerNumero(){
        int numero = scan.nextInt();
        return numero -1;
    }
        /**
     * Alterna entre jugador1 y jugador2
     */
    public void siguienteTurno(){
        primerTurno = !primerTurno;
    }
    
     /**
     * Mostrar mensaje.
     * @param mensaje 
     */
    public void mensaje(String mensaje){
        System.out.println(mensaje);
    }
}
