package backend;



import backend.Employee;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UpdateViewTest {
   ArrayList<Employee> listEmpleado= new ArrayList();

   @Test
	@DisplayName("Si el ID al que se le quiere hacer un cambio existe, el proceso continua, si no tira exception")
   public void name() {
      Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            
            Employee empleado= new Employee("1","Diego","Burgos","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQu2whjzwoBz71waeE07wh1L_sfjpdm6IIf7g&usqp=CAU");
            listEmpleado.add(empleado);
            
            Employee empleado2= new Employee("2","michael","jackson","www.google.com");
            listEmpleado.set(3, empleado2);
        });
   }
}
