/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exeptions;

/**
 *
 * @author diegoburgos
 */
public class LlaveException extends EstructuraIncorrectaException {
      public LlaveException(String llaveFaltante) {
        System.err.println("El archivo no contiene la llave " + llaveFaltante);
    }
}
