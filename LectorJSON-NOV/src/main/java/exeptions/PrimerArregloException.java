
package exeptions;


public class PrimerArregloException extends EstructuraIncorrectaException {
public PrimerArregloException() {
        System.err.println("El archivo no contiene el arreglo inicial de empleados (llave \"employees\")");
    }
}
