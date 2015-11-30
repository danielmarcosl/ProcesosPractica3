package modernsupermarket;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author Daniel Marcos Lorrio
 */
class Cliente extends Thread {

    int numero;
    int pago;
    Caja caja;
    int cajaAsignada = -1;

    public Cliente(int n) {
        this.numero = n;
    }

    public void run() {
        System.out.println("Cliente " + numero + " ha entrado sl supermercado");

        try {
            sleep(1000);
            while (cajaAsignada < 0) {
                cajaAsignada = caja.asignarCaja();
                if (cajaAsignada < 0) {
                    wait();
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        generarPago();
        
        caja.pagar(numero, cajaAsignada, pago);
        
        despertar();
    }

    public void generarPago() {
        Random r = new Random();
        pago = r.nextInt(100) + 1;
    }
    
    public synchronized void despertar() {
        notifyAll();
    }
}
