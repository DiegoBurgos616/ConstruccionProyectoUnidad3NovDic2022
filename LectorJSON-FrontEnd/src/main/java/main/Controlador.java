/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import backend.Employee;
import backend.ModificarEmpleadoJSON;
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
 * @author betoh
 */
public class Controlador {
    //
      private static String directorio;
      ObjetoJSON lector= new ObjetoJSON();
      ArrayList<Employee> empleados= new ArrayList();
      private static TablaJSON nView;

    
      public Controlador(String directorio) {
         this.directorio = directorio;
         envioArrayList();
      }
      
      public Controlador(ArrayList<Employee> empleados){
        String dir=directorio;
        if(ModificarEmpleadoJSON.actualizarArchivo(empleados,dir)){
            envioArrayList();
            UpdateView();
        }
            
      }

      public void envioArrayList(){
         try {
               empleados=lector.lecturaArchivo(directorio);
               nView= new TablaJSON(empleados);
               nView.setVisible(true);
               
         } catch (EstructuraIncorrectaException ex) {
               Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
               Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ParseException ex) {
               Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
         }
      }

      public void UpdateView() {
            nView.setVisible(false);
            nView.setVisible(true);
      }
      
      

      

   public static void main(String[] args) {
      new Controlador("/Users/diegoburgos/Documents/LectorJSON-FrontEnd/src/main/java/Archivos/estructuraCorrecta.json");
   }
}
