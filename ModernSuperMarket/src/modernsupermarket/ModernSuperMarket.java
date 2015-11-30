package modernsupermarket;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class ModernSuperMarket {

    public static int cajas = 6;
    public static boolean estadoCaja[] = new boolean[cajas];

    public static void main(String[] args) {

        int numeroCliente = 0;
        int n_clientes = 10;
        Caja c = null;

        inicializarCajas();

        for (int i = 0; i < n_clientes; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            new Cliente(numeroCliente).start();
            numeroCliente++;
        }
    }

    public static void inicializarCajas() {
        for (int i = 0; i < cajas; i++) {
            estadoCaja[i] = true;
        }
    }
}
