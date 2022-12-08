package exeptions;

public class RegistroDuplicado extends Exception {
    public RegistroDuplicado(String id) {
        System.err.println("No se puede crear un Nuevo Registro con un ID ya existente (El ID: " + id
                + " ya es utilizado en el archivo JSON)");
    }

}
