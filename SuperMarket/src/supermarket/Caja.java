package supermarket;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class Caja {

    public synchronized void ponerseEnCola() {
        try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void atenderCliente(int numeroCliente, int pago) {

        int numeroCaja = SuperMarket.cajaCliente.get(numeroCliente);

        System.out.println("El cliente " + numeroCliente + " esta pagando en la caja " + numeroCaja);

        // Hacemos que espere un tiempo aleatorio para pagar
        Random r = new Random();
        int tiempo = r.nextInt(6000) + 1000;

        try {
            sleep(tiempo);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Total a pagar por cliente " + numeroCliente + ": " + pago);

        SuperMarket.pagando[numeroCaja] = false;
        SuperMarket.clientesAtendidos++;
    }
}
