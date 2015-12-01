package modernsupermarket;

import java.util.ArrayList;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class ModernSuperMarket {

    // Numero de cajas
    public static int cajas = 6;
    // Numero de clientes
    public static int clientes = 150;
    // Contador de clientes que han acabado
    public static int clientesAtendidos = 0;
    // Array de booleans para los estados de las cajas
    public static boolean estadoCaja[] = new boolean[cajas];
    // Array de clientes según entran en la cola
    public static ArrayList<Integer> numeroCola = new ArrayList<Integer>(clientes);

    public static void main(String[] args) {
        // Inicializamos la clase Caja
        Caja c = new Caja();

        // Inicializamos los estados de las cajas
        inicializarCajas();

        // Creamos y lanzamos los clientes
        for (int i = 0; i < clientes; i++) {
            new Cliente(i, c).start();
        }
    }

    /**
     * Metodo para inicializar los estados de las cajas
     */
    public static void inicializarCajas() {
        for (int i = 0; i < cajas; i++) {
            estadoCaja[i] = true;
        }
    }
}
