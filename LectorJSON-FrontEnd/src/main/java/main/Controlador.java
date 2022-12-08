package main;

import backend.Employee;
import backend.CambiosJSON;
import backend.ObjetoJSON;
import exeptions.EstructuraIncorrectaException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;
import vista.TablaJSON;

public class Controlador {

    String dir = directorio;

    private static String directorio;
    ObjetoJSON lector = new ObjetoJSON();
    ArrayList<Employee> empleados = new ArrayList();
    private static TablaJSON nView;

    public Controlador(String directorio) {
        this.directorio = directorio;
        envioArrayList();
    }

    public Controlador() {
    }

    public void updateJSON(Employee empleados) {
        String dir = directorio;
        CambiosJSON modificador = new CambiosJSON(dir);
        if (modificador.modificarRegistro(empleados)) {
            closeView();
            envioArrayList();
        } else {
            JOptionPane.showMessageDialog(nView, "No es encuentra ningun dato con ese ID");
        }

    }

    public void deleteRegistroJSON(Employee empleados) {
        CambiosJSON modificador = new CambiosJSON(dir);
        if (modificador.borrarRegistro(empleados)) {
            closeView();
            envioArrayList();
        } else {
            JOptionPane.showMessageDialog(nView, "No es encuentra ningun dato con ese ID");
        }
    }

    public void envioArrayList() {
        try {
            empleados = lector.lecturaArchivo(directorio);
            nView = new TablaJSON(empleados);
            nView.setVisible(true);

        } catch (EstructuraIncorrectaException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeView() {
        nView.setVisible(false);
        nView.dispose();
    }

    public static void main(String[] args) {
        new Controlador("/Users/diegoburgos/Documents/LectorJSON-FrontEnd/src/main/java/Archivos/estructuraCorrecta.json");
    }
}
