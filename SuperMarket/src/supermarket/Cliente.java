package supermarket;

import java.util.Random;

/**
 *
 * @author Daniel Marcos Lorrio
 * @version 2 20/11/2015
 */
public class Cliente extends Thread {

    int num = 0;
    
    Caja c = new Caja();

    public Cliente(int n) {
        this.num = n;
    }

    public void run() {

        Random r = new Random();
        int pago = r.nextInt(200) + 1;

        c.ponerseEnCola();
        Caja.atenderCliente(num, pago);
    }
}
