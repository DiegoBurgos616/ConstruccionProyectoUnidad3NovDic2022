package backend;

import exeptions.EstructuraIncorrectaException;
import exeptions.LlaveException;
import org.json.simple.JSONObject;


public class validarJSON {

    public validarJSON() {

    }

    public static void validarEstructura(JSONObject employee) throws EstructuraIncorrectaException {
        tieneLlavesvalidas(employee);
    }

    public static void tieneLlavesvalidas(JSONObject employee) throws LlaveException {

        if (employee.get("employee") == null) {
                throw new LlaveException("employee");
        }

        JSONObject employeeObject = (JSONObject) employee.get("employee");
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