package exeptions;

public class LlaveExceptionSinValor extends Exception {
    public LlaveExceptionSinValor(String llave) {
        System.err.println("La llave " + llave + " no tiene valor dentro del archivo JSON");
    }
}