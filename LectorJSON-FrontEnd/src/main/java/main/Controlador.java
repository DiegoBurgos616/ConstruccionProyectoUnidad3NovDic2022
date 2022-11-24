/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import backend.Employee;
import backend.ObjetoJSON;
import exeptions.EstructuraIncorrectaException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;
import vista.TablaJSON;



/**
 *
 * @author Pau
 */
public final class Controlador {
      private final String directorio;
      ObjetoJSON lector= new ObjetoJSON();
      ArrayList<Employee> empleados= new ArrayList();

    
    public Controlador( String directorio) {
         this.directorio = directorio;
         envioArrayList();
      }

      public void envioArrayList(){
         try {
               empleados=lector.lecturaArchivo( directorio);
               new TablaJSON(empleados).setVisible(true);
         } catch (EstructuraIncorrectaException | IOException | ParseException ex) {
               Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
         }
      }

      

   public static void main(String[] args) {
      new Controlador("/Users/diegoburgos/Documents/LectorJSON-NOVVistas/src/main/java/Archivos/estructuraCorrecta.json");
   }
}
