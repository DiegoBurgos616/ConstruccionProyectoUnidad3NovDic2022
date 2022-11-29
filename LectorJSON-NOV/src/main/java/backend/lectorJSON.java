package backend;


import exeptions.EstructuraIncorrectaException;
import exeptions.LlaveException;
import exeptions.PrimerArregloException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class lectorJSON {

     public lectorJSON() {

    }

    public String lecturaArchivoJSON(String direccionArchivoJSON)
            throws EstructuraIncorrectaException, IOException, FileNotFoundException, org.json.simple.parser.ParseException {
        String path = direccionArchivoJSON ;

        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);

        JSONObject listaEmpleados = (JSONObject) obj;

        JSONArray datosEmpleados = (JSONArray) listaEmpleados.get("employees");
        if (datosEmpleados == null) {
            throw new PrimerArregloException();
        }
            System.out.println("El archivo presenta una estructura correcta");

        for (int i = 0; i < datosEmpleados.size(); i++) {
            JSONObject objectoEmpleadoTemporal = (JSONObject) datosEmpleados.get(i);
            this.validarEstructura(objectoEmpleadoTemporal);
                        System.out.println("\n");

            System.out.println(objectoEmpleadoTemporal.toString());
            

        }
        return "Archivo correcto";

    }

    public void validarEstructura(JSONObject empleado) throws EstructuraIncorrectaException {
        this.tieneLlavesvalidas(empleado);
    }

    public void tieneLlavesvalidas(JSONObject empleado) throws LlaveException {

        if (empleado.get("employee") == null) {
            throw new LlaveException("employee");
        }

        JSONObject employeeObject = (JSONObject) empleado.get("employee");
        String error = "";

        if (employeeObject.get("id") == null) {
            error = "id";
        } else if (employeeObject.get("firstName") == null) {
            error = "firstName";
        } else if (employeeObject.get("lastName") == null) {
            error = "lastName";
        } else if (employeeObject.get("photo") == null) {
            error = "photo";
        }

        if (!error.equals("")) {
            throw new LlaveException(error);
        }

    }


}