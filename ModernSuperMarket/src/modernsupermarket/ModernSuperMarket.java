package modernsupermarket;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class ModernSuperMarket {

    public static int cajas = 6;
    public static boolean estadoCaja[] = new boolean[cajas];
    public static int clientesAtendidos = 0;

    public static void main(String[] args) {

        int numeroCliente = 0;
        int n_clientes = 100;
        Caja c = null;

        inicializarCajas();

        for (int i = 0; i < n_clientes; i++) {
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
