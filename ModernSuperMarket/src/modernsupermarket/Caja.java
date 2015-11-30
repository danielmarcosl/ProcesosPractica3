package modernsupermarket;

import static java.lang.Thread.sleep;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class Caja {

    public synchronized static int asignarCaja(int num) {
        for (int i = 0; i < ModernSuperMarket.cajas; i++) {
            if (ModernSuperMarket.estadoCaja[i]) { // && ModernSuperMarket.clientesAtendidos <= num) {
                ModernSuperMarket.estadoCaja[i] = false;
                return i;
            }
        }
        System.out.println(ModernSuperMarket.estadoCaja);
        return -1;
    }

    public static void pagar(int num, int ca, int pa) throws InterruptedException {
        System.out.println("Cliente " + num + " esta pagando en la caja " + ca + ", total a pagar " + pa);
        sleep(5000);
        System.out.println("Cliente " + num + " ha terminado de pagar");

        ModernSuperMarket.estadoCaja[ca] = true;
        ModernSuperMarket.clientesAtendidos++;
    }
}
