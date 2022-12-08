package backend;

import exeptions.RegistroDuplicado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CambiosJSONTest {
	ObjetoJSON lector = new ObjetoJSON();
	CambiosJSON mod = new CambiosJSON("/Users/diegoburgos/Documents/LectorJSON-FrontEnd/src/main/java/Archivos/pruebasJSON.json");

        //Test MODIFICAR empleado
	@Test
	@DisplayName("La prueba sale negada ya que el empleado si existe en el JSON y el cambio deberia realizarse")
	public void noDeberiaRealizarModificacionPruebaDenegada() {
		Employee modEmp = new Employee("2", "Paola", "Novelo", "https://img.freepik.com/vector-premium/mujer-avatar-mujer-negocios_38295-63.jpg");
		Assertions.assertFalse(mod.modificarRegistro(modEmp));
	}
        
        @Test
	@DisplayName("La prueba es aprobada ya que el empleado no existe en el JSON y el cambio no se realiza")
	public void noDeberiaRealizarModificacionAproabada() {
		Employee modEmp = new Employee("1", "Paola", "Novelo", "https://img.freepik.com/vector-premium/mujer-avatar-mujer-negocios_38295-63.jpg");
		Assertions.assertFalse(mod.modificarRegistro(modEmp));
	}

        
        //Test ELIMINAR empleado
        @Test
	@DisplayName("La prueba sale denegada ya que el empleado si existe en el JSON y podria elinarse")
	public void noSedeberiaEliminarDenegada() {
		Employee modEmp = new Employee("2", "Paola", "Novelo", "https://img.freepik.com/vector-premium/mujer-avatar-mujer-negocios_38295-63.jpg");
		Assertions.assertFalse(mod.borrarRegistro(modEmp));
	}
        
	@Test
	@DisplayName("La prueba sale aprobada ya que el empleado no existe en el JSON por lo tanto no puede eliminarse nada")
	public void noSedeberiaEliminar() {
		Employee modEmp = new Employee("1", "Paola", "Novelo", "https://img.freepik.com/vector-premium/mujer-avatar-mujer-negocios_38295-63.jpg");
		Assertions.assertFalse(mod.borrarRegistro(modEmp));
	}
        
        
        //Test AGREGAR empleado
	@Test
	@DisplayName("No se crea un nuevo registro en el documento JSON en caso de que el empleado ya exista en el archivo JSON")
	public void noSedeberiaCrearDenegada() {
            //Al existir el empleado y querer crear uno nuevo envia Exception y la prueba es exitosa
		Employee modEmp = new Employee("2", "Paola", "Novelo", "https://img.freepik.com/vector-premium/mujer-avatar-mujer-negocios_38295-63.jpg");
		Assertions.assertThrows(RegistroDuplicado.class, () -> {
			mod.agregarRegistro(modEmp);
		});
	}
         
        @Test
	@DisplayName("No se crea un nuevo registro en el documento JSON en caso de que el empleado ya exista en el archivo JSON")
	public void noSedeberiaCrear() {
                //Al no existir el empleado y querer crear uno nuevo deberia crearse, por lo tanto la prueba es denegada
		Employee modEmp = new Employee("20", "Paola", "Novelo", "https://img.freepik.com/vector-premium/mujer-avatar-mujer-negocios_38295-63.jpg");
		Assertions.assertThrows(RegistroDuplicado.class, () -> {
			mod.agregarRegistro(modEmp);
		});
	}

}
