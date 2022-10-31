/*
 * Se define el tipo de dato abstracto Grafo
 * Se implementa de forma estática utilizando una matriz de adyacencia
 * 
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

public class GrafoTDA {

    static int numVertices;
    int[][] MAdy;
    int[] Etiqs; // Esta matriz corresponde a los Nodos
    int cantNodos;

    public GrafoTDA(int nVertices) {
        MAdy = new int[nVertices][nVertices];
        Etiqs = new int[nVertices];
        cantNodos = 0;
        numVertices = nVertices;

        // Inicializamos la matriz de adyacencia MAdy con 0 para el mismo destino y con
        // -1 para todos los demás
        for (int i = 0; i < MAdy.length; i++) {
            for (int j = 0; j > MAdy[i].length; j++) {
                if (i == j) {
                    MAdy[i][j] = 0;
                } else {
                    MAdy[i][j] = -1;
                }
            }
        }
    }

    public void AgregarVertice(int v) {
        Etiqs[cantNodos] = v;
        for (int i = 0; i <= cantNodos; i++) {
            MAdy[cantNodos][i] = 0;
            MAdy[i][cantNodos] = 0;
        }
        cantNodos++;
    }

    public void EliminarVertice(int v) {
        int ind = Vert2Indice(v);

        for (int k = 0; k < cantNodos; k++) {
            MAdy[k][ind] = MAdy[k][cantNodos - 1];
        }
        for (int k = 0; k < cantNodos; k++) {
            MAdy[ind][k] = MAdy[cantNodos - 1][k];
        }

        Etiqs[ind] = Etiqs[cantNodos - 1];
        cantNodos--;
    }

    private int Vert2Indice(int v) {
        int i = cantNodos - 1;
        while (i >= 0 && Etiqs[i] != v) {
            i--;
        }
        return i;
    }

    public Vertice Vertices() {
        Vertice Vert = new Vertice();
        Vert.InicializarVertice();

        for (int i = 0; i < cantNodos; i++) {
            Vert.Agregar(Etiqs[i]);
        }
        return Vert;
    }

    public void AgregarArista(int v1, int v2, int peso) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        MAdy[o][d] = peso;
    }

    public void EliminarArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        MAdy[o][d] = 0;
    }

    public boolean ExisteArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return MAdy[o][d] != 0;
    }

    public int PesoArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return MAdy[o][d];
    }

    public void imprimirGrafo() {
        for (int i = 1; i < MAdy.length; i++) {
            System.out.printf("\t%d", i + 1);
        }

        for (int i = 0; i < MAdy.length; i++) {
            System.out.printf("%d\t" + i + 1);
            for (int j = 0; j < MAdy[i].length; j++) {
                System.out.printf("%d\t", MAdy[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] retornarMatrizAdyacencia() {
        return this.MAdy;
    }

    /*
     * Creación del método para buscar el camino mínimo sin pesos
     * Se utiliza el algoritmo Breadth First Search (BFS)
     */
    public void caminoMinimoSinPeso(int[][] grafo, int fuente) {
        int[] distancia = new int[GrafoTDA.numVertices];
        boolean visitado[] = new boolean[GrafoTDA.numVertices];

        // Inicializa todas las distancias como infinito y setea los estados de los
        // vértices como FALSO (no visitado)
        for (int i = 0; i < GrafoTDA.numVertices; i++) {
            distancia[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }

        // Se setea la distancia del vértice origen / fuente hacia si mismo como 0
        distancia[fuente] = 0;
        // Setea el vertice origen / fuente como visitado
        visitado[fuente] = true;

        // Busca y encuentra el camino más corto para todos los vértices
        for (int c = 0; c < GrafoTDA.numVertices - 1; c++) {

            // Encuentra el vértice con la distancia mínima del conjunto de vértices no
            // visitados
            int vDM = distanciaMinima(distancia, visitado);

            // Se setea el vértice como visitado
            visitado[vDM] = true;

            // Actualiza el valor de distancia para todos los vertices adyacentes al vértice
            // visitado
            for (int v = 0; v < GrafoTDA.numVertices; v++) {
                if (!visitado[v] && grafo[vDM][v] > 0 && distancia[vDM] != Integer.MAX_VALUE
                        && distancia[vDM] + 1 < distancia[v]) {
                    distancia[v] = distancia[vDM] + 1;
                }
            }
        }

        // Mostramos por pantalla el arreglo con las distancias
        imprimirDistancias(distancia, fuente);
    }

    public int distanciaMinima(int[] d, boolean[] visitado) {
        // Inicializamos el valor mínimo (en este caso será el valor infinito)
        int minimo = Integer.MAX_VALUE;
        int dMin = 0;

        // Visitamos todos los vértices del grafo, si no se encuentra visitado
        // y su distancia es menor que el mínimo (significa que se encuentra conectado)
        // Busca el mínimo de las distancias encontradas por el algoritmo
        for (int v = 0; v < GrafoTDA.numVertices; v++) {
            if (visitado[v] == false && d[v] <= minimo) {
                minimo = d[v];
                dMin = v;
            }
        }

        // Devuelve la distancia mínima
        return dMin;
    }

    public void imprimirDistancias(int[] dis, int fue) {
        // Imprime las distancias para todos los vértices del gráfo
        for (int i = 0; i < GrafoTDA.numVertices; i++) {
            System.out.printf("Distancia entre %d y &d: %d\n\n", fue, i + 1, dis[i]);
        }
    }
}

/*
 * 
 * public void dijkstra(int inicio, int fin) {
 * int[] dist = new int[this.NUM_VERTICES];
 * // dist[i] guarda la distancia mas corta desde inicio hasta todos los
 * diferentes
 * // vertices
 * 
 * boolean[] verticeYaProcesado = new boolean[this.NUM_VERTICES];
 * // Este arreglo tiene true si el vertice i ya fue procesado
 * 
 * // Inicializa todas las distancias como INFINITE y stpSet [] como falso
 * for (int i = 0; i < this.NUM_VERTICES; i++) {
 * dist[i] = Integer.MAX_VALUE;
 * verticeYaProcesado[i] = false;
 * }
 * // La distancia del vertice origen hacia el mismo es siempre 0
 * dist[inicio] = 0;
 * 
 * // Encuentra el camino mas corto para todos los vertices
 * for (int count = 0; count < this.NUM_VERTICES - 1; count++) {
 * 
 * // Toma el vertice con la distancia minima del cojunto de vertices aun no
 * // procesados
 * // En la primera iteracion siempre se devuelve src
 * int u = distanciaMinima(dist, verticeYaProcesado);
 * 
 * // Se marca como ya procesado
 * verticeYaProcesado[u] = true;
 * 
 * // Actualiza el valor dist de los vértices adyacentes del vértice
 * seleccionado.
 * for (int v = 0; v < this.NUM_VERTICES; v++)
 * 
 * // Se actualiza la dist[v] solo si no esta en verticeYaProcesado, hay un
 * // arco desde u a v y el peso total del camino desde src hasta v a traves de
 * u
 * // es
 * // mas pequeno que el valor actual de dist[v]
 * if (!verticeYaProcesado[v] && this.grafo[u][v] > 0 && dist[u] !=
 * Integer.MAX_VALUE
 * && dist[u] + this.grafo[u][v] < dist[v])
 * dist[v] = dist[u] + this.grafo[u][v];
 * }
 * 
 * // se imprime el arreglo con las distancias
 * System.out.printf("Distancia desde d%d hasta d%d -> %d\n", inicio + 1, fin +
 * 1, dist[fin]);
 * }
 * 
 * private void printSolution(int[] dist, int n) {
 * for (int i = 0; i < this.NUM_VERTICES; i++)
 * System.out.printf("Distancia entre d%d y d%d -> %d\n", n + 1, i + 1,
 * dist[i]);
 * }
 * 
 * private int distanciaMinima(int[] dist, boolean[] verticeYaProcesado) {
 * // Initialize min value
 * int min = Integer.MAX_VALUE;
 * int min_index = 0;
 * 
 * // acumula todas las dictancias de los vertices que no fueran procesados
 * // anteriormente
 * for (int v = 0; v < this.NUM_VERTICES; v++)
 * if (verticeYaProcesado[v] == false && dist[v] <= min) {
 * min = dist[v];
 * min_index = v;
 * }
 * 
 * return min_index;
 * }
 * 
 */