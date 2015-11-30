package modernsupermarket;

import static java.lang.Thread.sleep;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class Caja {

    public synchronized static int asignarCaja() {
        for (int i = 0; i < ModernSuperMarket.cajas; i++) {
            if (ModernSuperMarket.estadoCaja[i]) {
                ModernSuperMarket.estadoCaja[i] = false;
                return i;
            }
        }
        System.out.println(ModernSuperMarket.estadoCaja);
        return -1;
    }

    public static void pagar(int num, int ca, int pa) {
        System.out.println("Cliente " + num + " esta pagando en la caja " + ca + ", total a pagar " + pa);
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        ModernSuperMarket.estadoCaja[ca] = true;
    }
}
