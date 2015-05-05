/**
 * TableroVista.java
 * 19-abr-2012
 * @author ccatalan
 * 
 *  Version 1.1
 *  27-abr-2012
 *  Modificaciones para mejora la separación MVC
 *    - TableroBarcos pasa a llamarse TableroVista
 *    - Recibe evento pero no modifica casilla únicamente notifica a 
 *      los posibles observadores
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Un tablero es una panel con una matriz de Casillas.
 */
public class TableroVista extends JPanel {
  private static final int ALTURA_FILA = 60;
  private static final int ANCHURA_COLUMNA = 60;
  private Casilla casillas[][];
  private java.util.List<Observador> observadores = new ArrayList<>();
  private Icon iconColor = new ImageIcon(this.getClass().getResource("/recursos/negro.png"));

  public static final boolean RECIBIR_EVENTOS_RATON = true;
  public static final boolean NO_RECIBIR_EVENTOS_RATON = false;
  
  public static final int FINAL_TABLERO = 8;

  /**
   * TableroVista
   */
  TableroVista(int filas, int columnas, 
                boolean recibe_eventos_raton, String rutaRecursos) {   
    
    setLayout(new GridLayout(filas, columnas));
    casillas = new Casilla[filas][columnas];
    
    for(int fil = 0; fil < filas; fil++) 
      for(int col = 0; col < columnas; col++) {
        casillas[fil][col] = new Casilla(fil, col);         
        add(casillas[fil][col]);      
        if (recibe_eventos_raton) {
          casillas[fil][col].addMouseListener(new MouseAdapter() { 
          @Override
            public void mousePressed(MouseEvent e) {
              notifica((Casilla)e.getSource());   
	        }
 	      });
        }
      } 
    this.setPreferredSize(new Dimension(filas * ALTURA_FILA, 
                                        columnas * ANCHURA_COLUMNA));
  }
  public void iniciarTablero(){
    for(int col = 0 ; col < FINAL_TABLERO ; col++){
        for(int fil = 0 ; fil <FINAL_TABLERO ; fil++){
            if(fil%2 != 0 && col%2 ==0){
                casillas[fil][col].setIcon(iconColor);
            }else if(fil%2 == 0 && col%2 !=0){
                casillas[fil][col].setIcon(iconColor);
            }
        }
    } 
  }
  /**
   * poner
   */   
  public void ponerIconoCasilla(int fil, int col, boolean isDama, char simbolo ,Icon icono) {
    Icon icon;
    
    if(simbolo == '#' && !isDama){
        //System.out.println("Rojo");
        icon = new ImageIcon(this.getClass().getResource("/recursos/ficha1.png"));
        casillas[fil][col].setIcon(icon);
    }else if(simbolo =='o' && !isDama){
        //System.out.println("Azul");
        icon = new ImageIcon(this.getClass().getResource("/recursos/ficha2.png"));
        casillas[fil][col].setIcon(icon);
    } else if(simbolo == 'x'){
        icon = new ImageIcon(this.getClass().getResource("/recursos/resaltar.png"));
        casillas[fil][col].setIcon(icon);
    }else if(simbolo == '#' && isDama){ 
         icon = new ImageIcon(this.getClass().getResource("/recursos/ficha1Dama.png"));
        casillas[fil][col].setIcon(icon);
    }else if(simbolo == 'o' && isDama){   
        icon = new ImageIcon(this.getClass().getResource("/recursos/ficha2Dama.png"));
        casillas[fil][col].setIcon(icon);
    }else{
        casillas[fil][col].setIcon(null);
    } 
        
  }
  
  /**
   * dimensionCasilla
   */  
  public Dimension dimensionCasilla() {
    return casillas[0][0].getSize();
  }
 
  Icon getIconCasilla(Casilla casilla) {
    return casilla.getIcon();
  }
  
  /**
   * poner
   */   
  public void ponerIconoCasilla(int fil, int col, Icon icono) {
    casillas[fil][col].setIcon(icono);
  }
 
  /**
   * nuevoObservador
   */   
  public void nuevoObservador(Observador observador) {
    observadores.add(observador);
  }
  
  /**
   * notifica
   */  
  public void notifica(Casilla casilla) {
    for(Observador observador: observadores)
      observador.actualiza(casilla);
  }
}
