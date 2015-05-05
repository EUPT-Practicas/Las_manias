/**
 * Casilla.java
 * 19-abr-2012
 * @author ccatalan
 * 
 *  Version 1.1
 *  27-abr-2012
 *  Modificaciones para mejora la separación MVC
 *    - Usamos la propiedad icon de JLabel para guardar la imagen de la casilla
 */
package vista;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

/**
 * Una casilla del tablero es un JLabel
 */
public class Casilla extends JLabel {
  private int fil, col;  

  /**
   * Casilla
   */
  Casilla(int fil, int col, Icon icon) {
    this.fil = fil;
    this.col = col;
    
    
    //setBackground(Color.BLACK);
//    if(fil%2 != 0 && col%2 ==0){
//                
//                setBackground(Color.BLACK);
//            }else if(fil%2 == 0 && col%2 !=0){
//                setBackground(Color.BLACK);
//            }else{
//                 //setBackground(Color.WHITE); // Color fondo casilla
//            }
    setIcon(icon);
 
    
        
    setHorizontalAlignment(SwingConstants.CENTER);
    setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
  }
  
  /**
   * Casilla
   */
  Casilla(int fil, int col) {
    this(fil, col, null);
  }

  /**
   * getCol
   */
  public int getCol() {
    return col;
  }
  
  /**
   * getFil
   */
  public int getFil() {
    return fil;
  }

  /**
   * toString
   */  
  @Override
  public String toString() {
    return "Casilla{" + "fil=" + fil + ", col=" + col + '}';
  }
}
      
      