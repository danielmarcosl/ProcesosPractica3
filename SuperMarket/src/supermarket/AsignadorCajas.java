package supermarket;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class AsignadorCajas extends Thread {

    public AsignadorCajas() {
    }

    public static void asignar() {
        for (int i = 0; i < SuperMarket.cajas; i++) {
            if (!SuperMarket.pagando[i]) {
                SuperMarket.pagando[i] = true;
                SuperMarket.cli[SuperMarket.clientesAtendidos + 1].notify();
                SuperMarket.cajaCliente.add(i);
            }
        }
    }

    public void run() {
        while (SuperMarket.clientesAtendidos != SuperMarket.clientes) {
            asignar();
        }
    }
}
