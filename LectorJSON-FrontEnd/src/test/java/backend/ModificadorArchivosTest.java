package backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ModificadorArchivosTest {
	ObjetoJSON lector = new ObjetoJSON();
	CambiosJSON mod = new CambiosJSON("\"/Users/diegoburgos/Documents/LectorJSON-FrontEnd/src/main/java/Archivos/estructuraCorrecta.json\"");

	@Test
	@DisplayName("No se realiza modificacion al JSON en caso de que el empleado no se encuentre en el archivo")
	public void noDeberiaRealizarModificacion() {
		Employee modEmp = new Employee("PRUEBA", "PRUEBA", "https://jsonformatter.org/img/tom-cruise.jpg", "PRUEBA");
		Assertions.assertFalse(mod.modificarRegistro(modEmp));
	}

	@Test
	@DisplayName("No se elimina registro en el JSON en caso de que el empleado no se encuentre en el archivo")
	public void noSedeberiaEliminar() {
		Employee modEmp = new Employee("PRUEBA", "PRUEBA", "https://jsonformatter.org/img/tom-cruise.jpg", "PRUEBA");
		Assertions.assertFalse(mod.borrarRegistro(modEmp));
	}

}
