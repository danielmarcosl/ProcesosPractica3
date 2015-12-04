package modernsupermarket;

import java.awt.TextArea;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Daniel Marcos Lorrio
 * @version 1 01/12/2015
 */
public class Ventana {

    private JFrame ventana = new JFrame();
    public static ArrayList<TextArea> texto_ventana;
    private String nombre = "ModernSuperMarket";

    /**
     * Creacion de ventana de Windows
     *
     * @param nombre Nombre de la ventana
     */
    Ventana(int num) {
        ventana.setName(nombre);
        ventana.setTitle(nombre);
        ventana.setSize(400, 400);
        ventana.setVisible(true);

        for (int i = 0; i < num; i++) {
            texto_ventana.set(i, new TextArea());
        }

        for (int i = 0; i < num; i++) {
            ventana.add(texto_ventana.get(i));
        }
    }
}
