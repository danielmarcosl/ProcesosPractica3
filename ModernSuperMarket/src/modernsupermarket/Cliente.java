package modernsupermarket;

/**
 *
 * @author Daniel Marcos Lorrio
 * @version 1 01/12/2015
 * @version 2 05/12/2015
 */
class Cliente extends Thread {

    // Variables del cliente
    int numero;
    int pago;
    int cajaAsignada;
    Caja caja;

    /**
     * Constructor de cliente
     *
     * @param n Numero de cliente
     * @param c Clase caja
     */
    public Cliente(int n, Caja c) {
        this.numero = n;
        this.caja = c;
    }

    public void run() {
        // Le asignamos un numero de caja
        cajaAsignada = caja.asignarCaja();

        // Calculamos el pago
        pago = Metodos.generarPago();

        try {
            // Realizamos el pago
            caja.pagar(numero, cajaAsignada, pago);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
