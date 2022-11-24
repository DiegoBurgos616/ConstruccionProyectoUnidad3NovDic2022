package backend;

import exeptions.LlaveException;
import exeptions.PrimerArregloException;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class validarJSONTest {
	ObjetoJSON lector = new ObjetoJSON();

	@Test
	@DisplayName("No debe continuarse la lectura si tiene caracteres,tokens erroneos en el archivo json o cuando está vacio")
	public void deberiaLanzarParseException() {
		Assertions.assertThrows(org.json.simple.parser.ParseException.class, () -> {
			lector.lecturaArchivo("/Users/diegoburgos/Documents/LectorJSON-NOVVistas/src/main/java/Archivos/erroresSintacticos.json");
			lector.lecturaArchivo("/Users/diegoburgos/Documents/LectorJSON-NOVVistas/src/main/java/Archivos/vacio.json");
		});
	}

	@Test
	@DisplayName("No debe continuarse la lectura si no existe el archivo json")
	public void deberiaLanzarFileNotFoundException() {
		Assertions.assertThrows(java.io.FileNotFoundException.class, () -> {
			lector.lecturaArchivo("/Users/diegoburgos/Documents/LectorJSON-NOVVistas/src/main/java/Archivos/inexistente.json");
		});
	}

	@Test
	@DisplayName("No debe continuarse la lectura en caso de interrupciones I/O")
	public void deberiaLanzarIOException() {
		Assertions.assertThrows(IOException.class, () -> {
			lector.lecturaArchivo("i/Users/diegoburgos/Documents/LectorJSON-NOVVistas/src/main/java/Archivos/nexistente.json");
		});
	}

	@Test
	@DisplayName("No debe continuarse la lectura en caso de que no se tenga la informacion en un arreglo inicial")
	public void deberiaLanzarArregloInicialException() {
		Assertions.assertThrows(PrimerArregloException.class, () -> {
			lector.lecturaArchivo("/Users/diegoburgos/Documents/LectorJSON-NOVVistas/src/main/java/Archivos/arregloInicialFaltante.json");
		});
	}

	@Test
	@DisplayName("No debe continuarse la lectura en caso de que falte alguna de las llaves iniciales")
	public void deberiaLanzarLlaveFaltanteException() {
		Assertions.assertThrows(LlaveException.class, () -> {
			lector.lecturaArchivo("/Users/diegoburgos/Documents/LectorJSON-NOVVistas/src/main/java/Archivos/llaveFaltante.json");
		});
	}

}
