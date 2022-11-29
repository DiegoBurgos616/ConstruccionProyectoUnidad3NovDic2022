/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.construccionjson;

import backend.lectorJSON;
import exeptions.EstructuraIncorrectaException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author diegoburgos
 */
public class ConstruccionJson {

    public static void main(String[] args) throws IOException, EstructuraIncorrectaException, ParseException {
        System.out.println("Hello World!");
        lectorJSON prueba=new lectorJSON();
        
        prueba.lecturaArchivoJSON("/Users/diegoburgos/Downloads/BackEndConstruccion/LectorJSON-NOV/LectorJSON-NOV/src/main/java/Archivos/estructuraCorrecta.json");
    }
}
