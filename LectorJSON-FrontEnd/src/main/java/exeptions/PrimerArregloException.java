
package exeptions;


public class PrimerArregloException extends EstructuraIncorrectaException {
public PrimerArregloException(String arreglo) {
        System.err.println("El archivo no contiene el arreglo inicial de empleados");
    }
}
