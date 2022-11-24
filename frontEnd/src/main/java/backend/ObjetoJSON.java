package backend;

import exeptions.EstructuraIncorrectaException;
import exeptions.LlaveException;
import exeptions.PrimerArregloException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class ObjetoJSON {

    public ArrayList<Employee> lecturaArchivo(String direccionArchivoJSON)
            throws EstructuraIncorrectaException, IOException, FileNotFoundException, org.json.simple.parser.ParseException,
            LlaveException {
        String path = direccionArchivoJSON;
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
        System.out.println(empleados);

        return empleados;

    }

    public Employee crearEmpleado(JSONObject jsonInfo) throws LlaveException {

        String id = (String) jsonInfo.get("id");
        String firstName = (String) jsonInfo.get("firstName");
        String lastName = (String) jsonInfo.get("lastName");
        String photo = (String) jsonInfo.get("photo");

    

        return new Employee(id, firstName, lastName, photo);
    }

}