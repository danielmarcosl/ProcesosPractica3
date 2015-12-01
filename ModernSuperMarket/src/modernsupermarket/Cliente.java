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

    public Cliente(int n, Caja c) {
        this.numero = n;
        this.caja = c;
    }

    public void run() {
        System.out.println("Cliente " + numero + " ha entrado sl supermercado");

        cajaAsignada = caja.asignarCaja(numero);

//        try {
//            while (cajaAsignada < 0) {
//                cajaAsignada = caja.asignarCaja(numero);
//                if (cajaAsignada < 0) {
//                    esperar(numero);
//                }
//            }
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
        generarPago();

        try {
            caja.pagar(numero, cajaAsignada, pago);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void generarPago() {
        Random r = new Random();
        pago = r.nextInt(100) + 1;
    }
}
