package modernsupermarket;

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
            while (cajaAsignada < 0) {
                cajaAsignada = caja.asignarCaja(numero);
                if (cajaAsignada < 0) {
                    esperar(numero);
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        generarPago();

        try {
            caja.pagar(numero, cajaAsignada, pago);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        despertar();
    }

    public void generarPago() {
        Random r = new Random();
        pago = r.nextInt(100) + 1;
    }

    public synchronized void despertar() {
        notifyAll();
    }

    public synchronized void esperar(int nu) throws InterruptedException {
        System.out.println(nu + " esperando");
        wait();
    }
}
