package modernsupermarket;

import java.util.Random;

/**
 *
 * @author Daniel Marcos Lorrio
 * @version 1 01/12/2015
 */
public class Metodos {

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
     * Metodo para crear un numero aleatorio entre 1 y 6 para las cajas
     *
     * @return Numero generado
     */
    public static int calcularCajas() {
        Random rand = new Random();
        int num = rand.nextInt(6) + 4;
        return num;
    }

    /**
     * Metodo para crear un numero aleatorio entre 1 y 100 para el pago
     *
     * @return Numero generado
     */
    public static int generarPago() {
        Random r = new Random();
        int num = r.nextInt(100) + 1;
        return num;
    }
}
