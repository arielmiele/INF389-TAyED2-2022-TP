/*
 * Esta interface define el TDA de Grafo a utilizar
 * 
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

public interface GrafoTDA {
    void InicializarGrafo();

    void AgregarVertice(int v);

    void EliminarVertice(int v);

    ConjuntoTDA Vertices();

    void AgregarArista(int v1, int v2, int peso);

    void EliminarArista(int v1, int v2);

    boolean ExisteArista(int v1, int v2);

    int PesoArista(int v1, int v2);

    ConjuntoTDA Adyacentes(int v);

    void imprimirGrafo();
}