/*
 * Se define el tipo de dato abstracto Grafo
 * Se implementa de forma estática utilizando una matriz de adyacencia
 * 
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

public class GrafoMA implements GrafoTDA {

    static int numVertices;
    int[][] MAdy;
    int[] Etiqs; // Esta matriz corresponde a los Nodos
    int cantNodos;

    public GrafoMA(int nVertices) {
        MAdy = new int[nVertices][nVertices];
        Etiqs = new int[nVertices];
        cantNodos = 0;
        numVertices = nVertices;
    }

    public void InicializarGrafo() {
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

    public ConjuntoTDA Vertices() {
        ConjuntoTDA Vert = new ConjuntoLD();
        Vert.InicializarConjunto();

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
        int[] distancia = new int[GrafoMA.numVertices];
        boolean visitado[] = new boolean[GrafoMA.numVertices];

        // Inicializa todas las distancias como infinito y setea los estados de los
        // vértices como FALSO (no visitado)
        for (int i = 0; i < GrafoMA.numVertices; i++) {
            distancia[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }

        // Se setea la distancia del vértice origen / fuente hacia si mismo como 0
        distancia[fuente] = 0;
        // Setea el vertice origen / fuente como visitado
        visitado[fuente] = true;

        // Busca y encuentra el camino más corto para todos los vértices
        for (int c = 0; c < GrafoMA.numVertices - 1; c++) {

            // Encuentra el vértice con la distancia mínima del conjunto de vértices no
            // visitados
            int vDM = distanciaMinima(distancia, visitado);

            // Se setea el vértice como visitado
            visitado[vDM] = true;

            // Actualiza el valor de distancia para todos los vertices adyacentes al vértice
            // visitado
            for (int v = 0; v < GrafoMA.numVertices; v++) {
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
        for (int v = 0; v < GrafoMA.numVertices; v++) {
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
        for (int i = 0; i < GrafoMA.numVertices; i++) {
            System.out.printf("Distancia entre %d y &d: %d\n\n", fue, i + 1, dis[i]);
        }
    }

    public static GrafoTDA kruskal(GrafoTDA g) throws Exception {

        int vertice, cantidad = 0, i, aux_vertice, c1 = 0, c2 = 0, cantidad_pendientes;
        Par aux_par = new Par();
        ConjuntoTDA aux_adyacentes;

        GrafoTDA grafoKruskal = new GrafoMA(g.Vertices().tamaño());
        grafoKruskal.InicializarGrafo();

        ConjuntoTDA vertices = g.Vertices();

        while (!vertices.ConjuntoVacio()) {
            vertice = vertices.Elegir();
            vertices.Sacar(vertice);
            grafoKruskal.AgregarVertice(vertice);
            cantidad++;
        }

        // En el par, varl1 y valor2 son los vértices y prioridad es el peso
        ColaPrioridadTDA<Par> aristas = new ColaPrioridad<Par>();
        aristas.InicializarCola();

        // en el par, valor 1 es el vértice y valor 2 el conjunto
        VectorTDA<Par> conjuntos = new Vector<Par>();
        conjuntos.inicializarVector(cantidad);

        vertices = g.Vertices();
        i = 0;
        while (!vertices.ConjuntoVacio()) {
            vertice = vertices.Elegir();
            vertices.Sacar(vertice);
            aux_par = new Par();
            aux_par.valor1 = vertice;
            aux_par.valor2 = vertice;
            conjuntos.agregarElemento(i, aux_par);
            i++;
            aux_adyacentes = g.Adyacentes(vertice);
            while (!aux_adyacentes.ConjuntoVacio()) {
                aux_vertice = aux_adyacentes.Elegir();
                aux_adyacentes.Sacar(aux_vertice);
                if (aux_vertice > vertice) {
                    aux_par = new Par();
                    aux_par.valor1 = vertice;
                    aux_par.valor2 = aux_vertice;
                    aristas.AgregarElemento(aux_par, g.PesoArista(vertice, aux_vertice));
                }
            }
        }

        cantidad_pendientes = cantidad;
        // Mientras haya más de un conjunto
        while (cantidad_pendientes > i) {
            // Tomo la arista más liviana
            aux_par = aristas.RecuperarMinElemento();

            // Busco a qué conjunto pertenece cada vértice de la arista
            for (i = 0; i < cantidad; i++) {
                if (conjuntos.recuperarElemento(i).valor1 == aux_par.valor1) {
                    c1 = conjuntos.recuperarElemento(i).valor2;
                }
                if (conjuntos.recuperarElemento(i).valor1 == aux_par.valor2) {
                    c2 = conjuntos.recuperarElemento(i).valor2;
                }
            }

            // Si pertenece a distintos conjuntos
            if (c1 != c2) {
                // Unifico los conjuntos
                for (i = 0; i < cantidad; i++) {
                    if (conjuntos.recuperarElemento(i).valor2 == c2) {
                        conjuntos.recuperarElemento(i).valor2 = c1;
                    }
                }
                // Agrego la arista al resultado
                grafoKruskal.AgregarArista(aux_par.valor1, aux_par.valor2, (int) aristas.RecuperarMinPrioridad());
                cantidad_pendientes--;
            }
            aristas.EliminarMinPrioridad();
        }
        return grafoKruskal;
    }

    public static GrafoTDA dijkstra(GrafoTDA g, int origen) {
        int vertice, aux_vertice, mejor_vertice, mejor_distancia;
        GrafoTDA distanciasMinimas = new GrafoMA(g.Vertices().tamaño());
        distanciasMinimas.InicializarGrafo();

        distanciasMinimas.AgregarVertice(origen);

        ConjuntoTDA vertices = g.Vertices();
        vertices.Sacar(origen);

        while (!vertices.ConjuntoVacio()) {
            vertice = vertices.Elegir();
            vertices.Sacar(vertice);
            distanciasMinimas.AgregarVertice(vertice);
            if (g.ExisteArista(origen, vertice)) {
                distanciasMinimas.AgregarArista(origen, vertice, g.PesoArista(origen, vertice));
            }
        }

        ConjuntoTDA pendientes = g.Vertices();
        pendientes.Sacar(origen);

        ConjuntoTDA aux_pendientes = new ConjuntoLD();
        aux_pendientes.InicializarConjunto();

        while (!pendientes.ConjuntoVacio()) {
            mejor_distancia = 0;
            mejor_vertice = 0;
            while (!pendientes.ConjuntoVacio()) {
                aux_vertice = pendientes.Elegir();
                pendientes.Sacar(aux_vertice);
                aux_pendientes.Agregar(aux_vertice);
                if ((distanciasMinimas.ExisteArista(origen, aux_vertice) && (mejor_distancia == 0
                        || (mejor_distancia > distanciasMinimas.PesoArista(origen, aux_vertice))))) {
                    mejor_distancia = distanciasMinimas.PesoArista(origen, aux_vertice);
                    mejor_vertice = aux_vertice;
                }
            }

            vertice = mejor_vertice;

            if (vertice != 0) {
                aux_pendientes.Sacar(vertice);
                while (!aux_pendientes.ConjuntoVacio()) {
                    aux_vertice = aux_pendientes.Elegir();
                    aux_pendientes.Sacar(aux_vertice);
                    if (g.ExisteArista(vertice, aux_vertice)) {
                        if (!distanciasMinimas.ExisteArista(origen, aux_vertice)) {
                            distanciasMinimas.AgregarArista(origen, aux_vertice,
                                    distanciasMinimas.PesoArista(origen, vertice) + g.PesoArista(vertice, aux_vertice));
                        } else {
                            if (distanciasMinimas.PesoArista(origen, aux_vertice) > distanciasMinimas.PesoArista(origen,
                                    vertice) + g.PesoArista(vertice, aux_vertice)) {
                                distanciasMinimas.AgregarArista(origen, aux_vertice,
                                        distanciasMinimas.PesoArista(origen, vertice)
                                                + g.PesoArista(vertice, aux_vertice));
                            }
                        }
                    }
                }
            }
        }
        return distanciasMinimas;
    }

    public ConjuntoTDA Adyacentes(int v) {
        // Método que debe retornar los adyacentes pertenecientes al grafo
        return null;
    }
}