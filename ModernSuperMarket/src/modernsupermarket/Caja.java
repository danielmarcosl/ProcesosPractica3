package modernsupermarket;

import static java.lang.Thread.sleep;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class Caja {

    boolean esperando;

    public Caja() {
        this.esperando = true;
    }

    public synchronized int asignarCaja(int num) {
        while (esperando) {
            for (int i = 0; i < ModernSuperMarket.cajas; i++) {
                if (ModernSuperMarket.estadoCaja[i]) { //&& ModernSuperMarket.numeroCola.get(ModernSuperMarket.clientesAtendidos) == num) {
                    ModernSuperMarket.estadoCaja[i] = false;
                    return i;
                }
            }
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    public void pagar(int num, int ca, int pa) throws InterruptedException {
        sleep(1000);
        System.out.println("Cliente " + num + " esta pagando en la caja " + ca);
        sleep(5000);
        System.out.println("Cliente " + num + " ha terminado de pagar en la caja " + ca + ", total a pagar " + pa);

        ModernSuperMarket.estadoCaja[ca] = true;
        ModernSuperMarket.clientesAtendidos++;

        despertar();
    }

    public synchronized void despertar() {
        notifyAll();
    }
}
