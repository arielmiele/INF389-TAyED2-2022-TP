/*
 * INF389 - Taller de Algoritmos y Estructura de Datos II
 * Trabajo Práctico N° 2
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

package TP2;

import estructuraDatos.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.concurrent.ExecutorCompletionService;

public class Main {

    static Scanner scanInput = new Scanner(System.in);

    public static void demo() {
        TablaExploracionCuadratica tablaHashCuadratica = new TablaExploracionCuadratica();
        TablaExploracionLineal tablaHashLineal = new TablaExploracionLineal();
        TablaHashingAbierto tablaHashingAbierto = new TablaHashingAbierto();

        Recursos[] recursos = ExploracionTablaHash(11);

        recursos[0] = new Recursos(115558);
        recursos[1] = new Recursos(56184);
        recursos[2] = new Recursos(165187);
        recursos[3] = new Recursos(98478);
        recursos[4] = new Recursos(33358);
        recursos[5] = new Recursos(8181571);
        recursos[6] = new Recursos(13158);
        recursos[7] = new Recursos(157788);
        recursos[8] = new Recursos(548271);
        recursos[9] = new Recursos(123354);
        recursos[10] = new Recursos(178475);

        System.out.println("Se agregan los recursos en la tabla Hash con manejo de colisiones cuadratico.\n");
        for (int i = 0; i < recursos.length; i++) {
            tablaHashCuadratica.insertar(recursos[i]);
        }

        System.out.println("Se agregan los recursos en la tabla Hash con manejo de colisiones lineal.\n");
        for (int i = 0; i < recursos.length; i++) {
            tablaHashLineal.insertar(recursos[i]);
        }

        System.out.println("Se agregan los recursos en la tabla Hash con hashing abierto.\n");
        for (int i = 0; i < recursos.length; i++) {
            tablaHashingAbierto.insertar(recursos[i]);
        }

        System.out.println("Tabla Hash con sondeo cuadratico: \n");
        tablaHashCuadratica.imprimirTablaHash();

        System.out.println("Tabla Hash con sondeo lineal.\n");
        tablaHashLineal.imprimirTablaHash();

        System.out.println("Tabla Hash con hashing abierto.\n");
        tablaHashingAbierto.imprimirTablaHash();
    }

    public static void main(String[] args) {
        String data;
        boolean salir = false;
        do {
            System.out.println("\nOpciones:" + "\nSeleccione el metodo deseado:\n"
                    + "1 - Operar con tabla hash de manejo de colisiones cuadratico\n" +
                    "2 - Operar con tabla hash de manejo de colisiones con sondeo lineal\n" +
                    "3 - Operar con tabla hash de manejo de colisiones de direccionamiento cerrado (hashing abierto)\n"
                    +
                    "4 - Demo\n" +
                    "5 - Salir\n");

            System.out.print(">> ");
            data = scanInput.nextLine();
            switch (data) {
                case "1":
                    System.out.println("\nCaso de hash cuadratico.");
                    ejecutar(TablaExploracionCuadratica.class);
                    break;
                case "2":
                    System.out.println("\nCaso de hash lineal.");
                    ejecutar(TablaExploracionLineal.class);
                    break;
                case "3":
                    System.out.println("\nCaso de hash abierto.");
                    ejecutar(TablaHashingAbierto.class);
                    break;
                case "4":
                    demo();
                    break;
                case "5":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta, por favor seleccione una opcion del 1 al 5.\n");
                    break;
            }
        } while (!salir);

        scanInput.close();
        System.out.println("¡ADIOS!\n");
    }

    public static int imprimirMenu(String tipoHash) {
        String dato;
        System.out.println("\nOpciones:\n" + "1 - Insertar elemento\n" +
                "2 - Buscar elemento\n" + "3 - Borrar elemento\n" + "4 - Imprimir tabla hash completa\n"
                + "5 - Atras\n");

        System.out.print(">> ");
        dato = scanInput.nextLine();
        return Integer.parseInt(dato);
    }

    public static String capturarConLeyenda(String leyenda) {
        System.out.println(leyenda);
        System.out.print(">> ");
        String valor = scanInput.nextLine();
        return valor;
    }

    public static Hashable obtenerObjetoHasheableConLeyenda(String leyenda) {
        String valor = capturarConLeyenda(leyenda);
        Hashable object = new Recursos(Integer.parseInt(valor));
        return object;
    }

    public static void ejecutar(Class claseHash) {
        TablaHash tabla;
        Constructor<TablaHash> constructor = null;
        constructor = claseHash.getConstructor();
        System.out.println("\nSeleccione el tamaño de la tabla hash (escriba 'D' para default):\n");
        String dato;
        System.out.print(">> ");
        dato = scanInput.nextLine();
        if (dato.toUpperCase().equals("D")) {
            tabla = constructor.newInstance();
            System.out.println("\nSe utilizara el tamaño default configurado para la tabla: "
                    + tabla.getTamanioTablaDefault() + ".\n");
        } else {
            tabla = constructor.newInstance(Integer.parseInt(dato));
        }
        int opcion;
        boolean otro;
        do {
            opcion = imprimirMenu("");
            switch (opcion) {
                case 1:
                    do {
                        otro = false;
                        tabla.insertar(obtenerObjetoHasheableConLeyenda(
                                "\nIngrese el valor a insertar (numerico): "));
                        System.out.println("\nDesea insertar otro? (S/N)");
                        System.out.print(">> ");
                        if (scanInput.nextLine().toUpperCase().equals("S")) {
                            otro = true;
                        }
                    } while (otro);
                    break;
                case 2:
                    do {
                        otro = false;
                        tabla.buscar(obtenerObjetoHasheableConLeyenda(
                                "\nIngrese el valor que desea buscar: "));
                        System.out.println("\nDesea buscar otro? (S/N)");
                        System.out.print(">> ");
                        if (scanInput.nextLine().toUpperCase().equals("S")) {
                            otro = true;
                        }
                    } while (otro);
                    break;
                case 3:
                    do {
                        otro = false;
                        tabla.eliminar(obtenerObjetoHasheableConLeyenda(
                                "\nIngrese el valor que desea eliminar"));
                        System.out.println("\nDesea borrar otro? (S/N)");
                        System.out.print(">> ");
                        if (scanInput.nextLine().toUpperCase().equals("S")) {
                            otro = true;
                        }
                    } while (otro);
                    break;
                case 4:
                    tabla.imprimirTablaHash();
                    break;
            }
        } while (opcion != 5);
    }
}