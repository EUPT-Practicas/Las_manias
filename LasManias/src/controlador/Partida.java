/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ricardo
 */
public class Partida {

    private static final char SIMBOLO_UNO = 'o';
    private static final char SIMBOLO_DOS = '#';
    private TableroSwing vista;
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
    public Partida(TableroSwing vista, Tablero tablero) {
        this.tablero = tablero;
        tablero.iniciar();
        this.vista = vista;
        jugador1 = new Jugador("Ricardo", SIMBOLO_UNO);
        jugador2 = new Jugador("Alvaro", SIMBOLO_DOS);
    }

    /**
     * Empieza la partida y comprueba si se debe seguir jugando.
     */
    public void jugar(int fila, int columna, int nuevaFila, int nuevaColumna) {
        Jugador jugadorActual;
        //int fila, columna, nuevaFila, nuevaColumna;
        boolean ok = false;
        boolean permitirJugada = false;
        char simboloOponente;
        String turno;
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
        if (primerTurno) {
            jugadorActual = jugador1;
            turno = "Turno de Rojas.";
            simboloOponente = jugador2.getSimbolo();
        } else {
            jugadorActual = jugador2;
            turno = "Turno de Marrones.";
            simboloOponente = jugador1.getSimbolo();
        }
        this.vista.modificarTurno(turno);

        //jugadorActual.setSuTurno(true);
        System.out.println("TURNO JUGADOR: " + jugadorActual.getSimbolo());
//        movimientosPosibles = tablero.movimientoObligatorio(jugadorActual.getSimbolo());
//
//        if (movimientosPosibles.size() > 0) {
//            for (int i = 0; i <= movimientosPosibles.size() && !permitirJugada; i++) {
//                hueco = (Hueco) movimientosPosibles.get(i);
//                if (hueco.getFila() == nuevaFila && hueco.getColumna() == nuevaColumna) {
//                    permitirJugada = true;
//                }
//            }
//        }

        if (tablero.jugadaValida(fila, columna, nuevaFila, nuevaColumna, simboloOponente )) {
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
        } else {
            this.vista.mensajeError("El movimiento no esta permitido.");
        }
        tablero.pintarTablero();

    }

    
    /**
     * Alterna entre jugador1 y jugador2
     */
    public void siguienteTurno() {
        primerTurno = !primerTurno;
    }

    
}
