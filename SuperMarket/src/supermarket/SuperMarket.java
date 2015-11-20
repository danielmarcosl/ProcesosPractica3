package supermarket;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class SuperMarket {

    // Numero de cajas
    public static int cajas = 5;
    // Numero de clientes
    public static int clientes = 0;
    // Numero de clientes atendidos
    public static int clientesAtendidos = 0;
    // Numero de caja asignada a cada cliente
    public static ArrayList<Integer> cajaCliente;
    // Array que contiene los clientes
    public static Cliente cli[];
    // Boolean para controlar las cajas
    public static boolean pagando[] = new boolean[cajas];

    /**
     * Metodo para declarar que las cajas estan vacias al iniciar el programa
     */
    public static void inicializarEstadoCajas() {
        for (int i = 0; i < cajas; i++) {
            pagando[i] = false;
        }
    }

    /**
     * Metodo para generar un numero aleatorio de clientes
     */
    public static void calcularClientes() {
        Random r = new Random();
        int m = r.nextInt(500) + 1;
        clientes = m;
        System.out.println("Hay " + clientes + " clientes");
    }

    public static void main(String[] args) {

        // Se declaran que estan libres las cajas
        inicializarEstadoCajas();

        // Se crea un numero aleatorio de clientes
        calcularClientes();

        // Inicializamos el array de clientes
        cli = new Cliente[clientes];
        cajaCliente = new ArrayList<Integer>(clientes);

        // Lanzamos los clientes
        for (int i = 0; i < clientes; i++) {
            cli[i] = new Cliente(i);
            cli[i].start();
        }
        
        AsignadorCajas asignador = new AsignadorCajas();
        asignador.start();
    }
}
