package backend;

import exeptions.EstructuraIncorrectaException;
import exeptions.LlaveExceptionSinValor;
import exeptions.PrimerArregloException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ObjetoJSON {

    public ArrayList<Employee> lecturaArchivo(String directorio)
            throws EstructuraIncorrectaException, IOException, FileNotFoundException, org.json.simple.parser.ParseException,
            LlaveExceptionSinValor {
        String path = directorio;
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject employeeList = (JSONObject) obj;
        JSONArray employeeData = (JSONArray) employeeList.get("employees");

        if (employeeData == null) {
            throw new PrimerArregloException("employees");
        }

        ArrayList<Employee> empleados = new ArrayList<>();
        for (int i = 0; i < employeeData.size(); i++) {
            JSONObject tempEmployee = (JSONObject) employeeData.get(i);
            validarJSON.validarEstructura(tempEmployee);
            JSONObject employeeObject = (JSONObject) tempEmployee.get("employee");

            if (employeeObject == null) {
                throw new PrimerArregloException("employee");
            }
            Employee tempEmpleado = this.crearEmpleado(employeeObject);
            empleados.add(tempEmpleado);
        }
        return empleados;
    }

    public Employee crearEmpleado(JSONObject jsonInfo) throws LlaveExceptionSinValor {
        String id = (String) jsonInfo.get("id");
        String firstName = (String) jsonInfo.get("firstName");
        String lastName = (String) jsonInfo.get("lastName");
        String photo = (String) jsonInfo.get("photo");

        if (id.equals("")) {
            throw new LlaveExceptionSinValor("id");
        }
        if (firstName.equals("")) {
            throw new LlaveExceptionSinValor("firstName");
        }
        if (lastName.equals("")) {
            throw new LlaveExceptionSinValor("lastName");
        }
        if (photo.equals("")) {
            throw new LlaveExceptionSinValor("photo");
        }

        return new Employee(id, firstName, lastName, photo);
    }

}
