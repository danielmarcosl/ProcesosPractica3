package modernsupermarket;

import static java.lang.Thread.sleep;

/**
 *
 * @author Daniel Marcos Lorrio
 * @version 1 01/12/2015
 * @version 2 05/12/2015
 */
public class Caja {

    // Boolean que indica que el cliente esta esperando a que se le asigne una caja
    boolean esperando;

    /**
     * Constructor de Caja
     */
    public Caja() {
        this.esperando = true;
    }

    /**
     * Bucle que busca cajas libre, si hay una, se le asigna al cliente, si no,
     * se duerme hasta que se despierte y vuelve a iniciar el bucle
     *
     * @return Numero de caja
     */
    public synchronized int asignarCaja() {
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

    /**
     * Duerme al hilo entrante para simular que esta pagando, muestra los datos
     * del cliente y la caja en la que esta, al acabar, anade el pago a la
     * recaudacion, libera la caja y aumenta el contador de clientes atendidos
     *
     * @param num Numero de cliente
     * @param ca Caja asignada
     * @param pa Cantidad a pagar
     * @throws InterruptedException Excepcion de interrupcion
     */
    public void pagar(int num, int ca, int pa) throws InterruptedException {
        // Dormimos el hilo simulando que esta pagando y mostramos sus datos
        sleep(Metodos.generarDormir(3000));
        Ventana.texto_ventana.get(ca).setText(Ventana.texto_ventana.get(ca).getText() + "Cliente " + num + " pagando en " + ca + "\n");
        sleep(Metodos.generarDormir(5000));
        Ventana.texto_ventana.get(ca).setText(Ventana.texto_ventana.get(ca).getText() + "Cliente " + num + " termina en " + ca + ", pago " + pa + "\n");

        // Anadimos el pago a la recaudacion total
        ModernSuperMarket.recaudacion += pa;
        // Cambiamos el estado de la caja para indicar que esta libre
        ModernSuperMarket.estadoCaja[ca] = true;
        // Aumentamos el contador de clientes atendidos
        ModernSuperMarket.clientesAtendidos++;

        // Despertamos al siguiente Cliente
        despertar();

        // Actualizacion del panel de informacion
        Metodos.actualizarInfo();
    }

    /**
     * Despierta al siguiente Cliente
     */
    public synchronized void despertar() {
        notify();
    }
}
