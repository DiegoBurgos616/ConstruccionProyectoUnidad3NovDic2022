/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package backend;


import exeptions.EstructuraIncorrectaException;
import exeptions.LlaveException;
import exeptions.PrimerArregloException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author diegoburgos
 */
public class lectorJSONIT {
	lectorJSON validador = new lectorJSON();

 @org.junit.jupiter.api.Test

	@DisplayName("No debe continuarse la lectura si tiene caracteres,tokens erroneos en el archivo json o cuando está vacio")
	public void deberiaLanzarParseException() {
		Assertions.assertThrows(org.json.simple.parser.ParseException.class, () -> {
			validador.lecturaArchivoJSON("/Users/diegoburgos/Downloads/BackEndConstruccion/LectorJSON-NOV/LectorJSON-NOV/src/main/java/Archivos/erroresSintacticos.json");
			validador.lecturaArchivoJSON("/Users/diegoburgos/Downloads/BackEndConstruccion/LectorJSON-NOV/LectorJSON-NOV/src/main/java/Archivos/vacio.json");
		});
	}

	@org.junit.jupiter.api.Test
	@DisplayName("No debe continuarse la lectura si no existe el archivo json")
	public void deberiaLanzarFileNotFoundException() {
		Assertions.assertThrows(java.io.FileNotFoundException.class, () -> {
                                validador.lecturaArchivoJSON( "/Users/diegoburgos/Downloads/BackEndConstruccion/LectorJSON-NOV/LectorJSON-NOV/src/main/java/Archivos/noexiste.json");

		});
	}

	@org.junit.jupiter.api.Test
	@DisplayName("No debe continuarse la lectura en caso de interrupciones I/O")
	public void deberiaLanzarIOException() {
		Assertions.assertThrows(IOException.class, () -> {
                                validador.lecturaArchivoJSON( "/Users/diegoburgos/Downloads/BackEndConstruccion/LectorJSON-NOV/LectorJSON-NOV/src/main/java/Archivos/noexiste.json");
		});
	}

	@org.junit.jupiter.api.Test
	@DisplayName("No debe continuarse la lectura en caso de que no se tenga la informacion en un arreglo inicial")
	public void deberiaLanzarArregloInicialException() {
		Assertions.assertThrows(PrimerArregloException.class, () -> {
                                validador.lecturaArchivoJSON( "/Users/diegoburgos/Downloads/BackEndConstruccion/LectorJSON-NOV/LectorJSON-NOV/src/main/java/Archivos/arregloInicialFaltante.json");
		});
	}

	@org.junit.jupiter.api.Test
	@DisplayName("No debe continuarse la lectura en caso de que falte alguna de las llaves iniciales")
	public void deberiaLanzarLlaveFaltanteException() {
		Assertions.assertThrows(LlaveException.class, () -> {
                                validador.lecturaArchivoJSON( "/Users/diegoburgos/Downloads/BackEndConstruccion/LectorJSON-NOV/LectorJSON-NOV/src/main/java/Archivos/llaveFaltante.json");
		});
	}


        
}
