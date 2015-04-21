/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
    private Scanner scan = new Scanner(System.in);
    private boolean primerTurno = true;
    
    /**
     * Constructor para inicializar una nueva partida.
     */
    public Partida() {
        tablero = new Tablero();
        jugador1 = new Jugador("Luis", SIMBOLO_UNO);
        jugador2 = new Jugador("Mario", SIMBOLO_DOS);
    }
        /**
     * Empieza la partida y comprueba si se debe seguir jugando.
     */
    public void jugar(){
        Jugador jugadorActual;
        int columna;
        boolean izquierda = false;
        boolean ok = false;
//        ok = tablero.jugadaValida(5, 1, 4, 0);
//        ok = tablero.jugadaValida(5, 1, 3, -1);
        ok = tablero.jugadaValida(5, 5, 4, 6, false);
        ok = tablero.jugadaValida(4, 6, 3, 7, false);
        //ok = tablero.jugadaValida(4, 6, 2, 8, false);
        //ok = tablero.jugadaValida(5, 1, 5, -1);
        
        tablero.pintarTablero(); 
        if(ok){
            System.out.println("Bien");
        }else{
            System.out.println("Mal");
        }
              
//        while(true){
//            if(primerTurno){
//                jugadorActual = jugador1;
//            }else{
//                jugadorActual = jugador2;
//            }
//            //jugadorActual.setSuTurno(true);
//            tablero.pintarTablero(jugadorActual.getSimbolo());
//            columna = leerJugada();
//            if(tablero.jugadaValida(columna, jugadorActual.getSimbolo())){
//                if(tablero.jugadaGanadora(columna)){
//                    mensaje("¡ " + jugadorActual.getNombre() + " es el ganador!"); 
//                    jugadorActual.sumarPartidaGanada();
//                    tablero.pintarTablero(jugadorActual.getSimbolo());
//                    //nuevaPartida();
//                }
//                siguienteTurno();
//                //jugadorActual.setSuTurno(false);
//            }else{
//                mensaje("¡Columna llena!");
//            }
//        }
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
