package vista;

import java.awt.Component;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;



/**
 *
 * @author Pau
 */
public class ImagenJSON extends DefaultTableCellRenderer{

    public ImagenJSON() {
    }

    public JLabel mostrar_imagen(String urll){
         Image imagen = null;
        try {
            //Inicializar y asignar url de la imagen a mostrar
            URL url = new URL(urll);
            //Asignacion de url a la imagen
            imagen = ImageIO.read(url);
            }catch (IOException e) {
                e.printStackTrace();
            }
        JLabel label = new JLabel(new ImageIcon(imagen));
        return label;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof JLabel){
            JLabel lb1=(JLabel)value;
            return lb1;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
    }
    
    
    

}