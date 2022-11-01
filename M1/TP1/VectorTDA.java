/*
 * Esta interface define el TDA de Vector a utilizar
 * 
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

public interface VectorTDA<E> {
    // Agrega un elemento en una posición dada
    void agregarElemento(int posicion, E elemento);

    // Devuelve la capacidad del vector
    int capacidadVector();

    // Elimina un elemento del vector dada una posición
    void EliminarElemento(int posicion);

    // Inicializa la estructura del vector con capacidad n
    void inicializarVector(int n);

    // Permite recuperar el elemento de una posición dada
    E recuperarElemento(int posicion);
}
