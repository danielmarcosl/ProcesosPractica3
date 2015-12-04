package modernsupermarket;

import java.util.Random;

/**
 *
 * @author Daniel Marcos Lorrio
 * @version 1 01/12/2015
 */
public class Metodos {

    /**
     * Metodo para actualizar el panel de informacion
     */
    public static void actualizarInfo() {
        Ventana.info.setText("Clientes actuales: " + (ModernSuperMarket.clientes - ModernSuperMarket.clientesAtendidos)
                + "\nCajas activas: " + ModernSuperMarket.cajas + "\nRecaudacion total: " + ModernSuperMarket.recaudacion);
    }

    /**
     * Metodo para inicializar los estados de las cajas
     */
    public static void inicializarCajas() {
        for (int i = 0; i < ModernSuperMarket.cajas; i++) {
            ModernSuperMarket.estadoCaja[i] = true;
        }
    }

    /**
     * Metodo para crear un numero aleatorio entre 50 y 500 para los clientes
     *
     * @return Numero generado
     */
    public static int calcularClientes() {
        Random rand = new Random();
        int num = rand.nextInt(450) + 50;
        return num;
    }

    /**
     * Metodo para crear un numero aleatorio entre 2 y 6 para las cajas
     *
     * @return Numero generado
     */
    public static int calcularCajas() {
        Random rand = new Random();
        int num = rand.nextInt(4) + 2;
        return num;
    }

    /**
     * Metodo para crear un numero aleatorio entre 1 y 100 para el pago
     *
     * @return Numero generado
     */
    public static int generarPago() {
        Random rand = new Random();
        int num = rand.nextInt(100) + 1;
        return num;
    }

    /**
     * Metodo para crear un numero aleatorio entre 1000 y 6000 para el sleep al
     * pagar
     *
     * @return Numero generado
     */
    public static int generarDormir() {
        Random rand = new Random();
        int num = rand.nextInt(5000) + 1000;
        return num;
    }
}
