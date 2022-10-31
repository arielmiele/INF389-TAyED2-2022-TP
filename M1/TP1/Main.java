import java.util.Scanner;

public class Main {

    private static int ingresarValor(String mensaje) {

        int datoIngresado = 0;
        boolean esCorrecto = false;
        try (Scanner in = new Scanner(System.in)) {
            while (!esCorrecto) {
                System.out.println(mensaje);
                datoIngresado = in.nextInt();
                if (datoIngresado < 1 || datoIngresado > 13) {
                    System.out.println("El valor ingresado debe estar entre 1 y 13, ingresar nuevo valor: ");
                    ingresarValor(mensaje);
                } else {
                    esCorrecto = true;
                }
            }
        }

        return datoIngresado;
    }

    public static void main(String[] args) {

        // Se crea el nuevo grafo
        GrafoTDA grf = new GrafoTDA(13);

        // Creamos los vértices del grafo
        for (int i = 0; i < GrafoTDA.numVertices; i++) {
            grf.AgregarVertice(i);
        }

        // Creamos las aristas del grafo (llenando la matriz de adyacencia)
        grf.AgregarArista(0, 1, 200);
        grf.AgregarArista(0, 12, 250);
        grf.AgregarArista(0, 8, 290);
        grf.AgregarArista(1, 5, 360);
        grf.AgregarArista(1, 2, 190);
        grf.AgregarArista(2, 5, 250);
        grf.AgregarArista(2, 4, 190);
        grf.AgregarArista(2, 0, 300);
        grf.AgregarArista(3, 2, 180);
        grf.AgregarArista(4, 5, 300);
        grf.AgregarArista(4, 9, 400);
        grf.AgregarArista(5, 10, 350);
        grf.AgregarArista(5, 11, 300);
        grf.AgregarArista(6, 3, 300);
        grf.AgregarArista(6, 2, 250);
        grf.AgregarArista(6, 0, 150);
        grf.AgregarArista(7, 6, 200);
        grf.AgregarArista(7, 0, 220);
        grf.AgregarArista(8, 7, 180);
        grf.AgregarArista(8, 12, 180);
        grf.AgregarArista(9, 3, 200);
        grf.AgregarArista(10, 9, 700);
        grf.AgregarArista(10, 4, 200);
        grf.AgregarArista(11, 1, 150);
        grf.AgregarArista(12, 11, 100);
        grf.AgregarArista(12, 1, 200);

        // imprime matriz de adyacencia
        System.out.println("Se genera el grafo con la siguiente matriz de adyacencia: ");
        grf.imprimirGrafo();

        // Se procede a calcular el camino mínimo sin pesos
        int origen = ingresarValor("Ingrese el nodo origen para el calculo de los caminos minimos, del 1 al 13: ");
        System.out.println("Caminos sin pesos a todos los vértices: \n");
        grf.caminoMinimoSinPeso(grf.retornarMatrizAdyacencia(), origen - 1);

        // Cálculo del camino mínimo usando el Algoritmo de Dijkstra
        System.out.println("Calculo de camino minimo usando el algoritmo de dijkstra");
        int inicio = ingresarValor("Ingrese nodo origen (1-2-3-4-5-6-7-8-9-10-11-12-13): ");
        int fin = ingresarValor("Ingrese nodo destino (1-2-3-4-5-6-7-8-9-10-11-12-13):");
        // grf.dijkstra(inicio - 1, fin - 1);
    }
}