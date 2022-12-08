package backend;

import backend.Employee;
import backend.ObjetoJSON;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import exeptions.LlaveExceptionSinValor;
import exeptions.RegistroDuplicado;

public class CambiosJSON {

    private String documento;

    public CambiosJSON(String documento) {
        this.documento = documento;
    }

    private void crearArchivoJSON(JSONObject finalJSON) {
        try ( PrintWriter file = new PrintWriter(this.documento)) {
            ObjectMapper mapper = new ObjectMapper();
            String betterFormat = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper.readTree(finalJSON.toJSONString()));
            file.write(betterFormat);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int buscarEmpleado(Employee empleado) {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader(this.documento);
            Object obj = jsonParser.parse(reader);
            ObjetoJSON convertorJSON = new ObjetoJSON();
            JSONObject employeeList = (JSONObject) obj;
            JSONArray employeeData = (JSONArray) employeeList.get("employees");
            for (int i = 0; i < employeeData.size(); i++) {
                JSONObject tempEmployeeObject = (JSONObject) employeeData.get(i);
                JSONObject employeeObject = (JSONObject) tempEmployeeObject.get("employee");
                Employee employee = convertorJSON.crearEmpleado(employeeObject);
                if (employee.getId().equals(empleado.getId())) {
                    return i;
                }
            }
            return -1;
        } catch (IOException | ParseException | LlaveExceptionSinValor e) {
            e.printStackTrace();
            return -1;
        }

    }

    public boolean modificarRegistro(Employee empleado) {
        int posEmpleado = this.buscarEmpleado(empleado);
        if (posEmpleado != -1) {
            JSONParser jsonParser = new JSONParser();
            try {
                FileReader reader = new FileReader(this.documento);
                Object obj = jsonParser.parse(reader);
                JSONObject employeeList = (JSONObject) obj;
                JSONArray employeeData = (JSONArray) employeeList.get("employees");
                JSONObject tempEmployeeObject = (JSONObject) employeeData.get(posEmpleado);
                JSONObject employeeObject = (JSONObject) tempEmployeeObject.get("employee");
                employeeObject.replace("id", empleado.getId());
                employeeObject.replace("firstName", empleado.getFirstName());
                employeeObject.replace("lastName", empleado.getLastName());
                employeeObject.replace("photo", empleado.getPhoto());
                tempEmployeeObject.replace("employee", employeeObject);
                employeeData.remove(posEmpleado);
                employeeData.add(posEmpleado, tempEmployeeObject);
                JSONObject finalJSON = new JSONObject();
                finalJSON.put("employees", employeeData);
                this.crearArchivoJSON(finalJSON);
                return true;
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean borrarRegistro(Employee empleado) {
        int posEmpleado = this.buscarEmpleado(empleado);
        if (posEmpleado != -1) {
            JSONParser jsonParser = new JSONParser();
            try {
                FileReader reader = new FileReader(this.documento);
                Object obj = jsonParser.parse(reader);
                JSONObject employeeList = (JSONObject) obj;
                JSONArray employeeData = (JSONArray) employeeList.get("employees");
                employeeData.remove(posEmpleado);
                JSONObject finalJSON = new JSONObject();
                finalJSON.put("employees", employeeData);
                this.crearArchivoJSON(finalJSON);
                return true;
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean agregarRegistro(Employee empleado) throws RegistroDuplicado {
        int posEmpleado = this.buscarEmpleado(empleado);
        if (posEmpleado != -1) {
            throw new RegistroDuplicado(empleado.getId());
        }
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader(this.documento);
            Object obj = jsonParser.parse(reader);
            JSONObject employeeList = (JSONObject) obj;
            JSONArray employeeData = (JSONArray) employeeList.get("employees");
            JSONObject nuevoRegistro = new JSONObject();
            nuevoRegistro.put("firstName", empleado.getFirstName());
            nuevoRegistro.put("lastName", empleado.getLastName());
            nuevoRegistro.put("photo", empleado.getPhoto());
            nuevoRegistro.put("id", empleado.getId());

            JSONObject employee = new JSONObject();
            employee.put("employee", nuevoRegistro);
            employeeData.add(employee);
            JSONObject finalJSON = new JSONObject();
            finalJSON.put("employees", employeeData);
            this.crearArchivoJSON(finalJSON);
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

}
