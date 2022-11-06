/*
 * INF389 - Taller de Algoritmos y Estructura de Datos II
 * Trabajo Práctico N° 2
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

package estructuraDatos;

public interface TablaHash {
    /**
     * Inserta el elemento x en la tabla de hash
     * @param x elemento a insertar
     */
    void insertar(Hashable x);
    /**
     * Remueve un elemento x de la tabla de hash
     * @param x elemento a borrar
     */
    void eliminar(Hashable x);
    /**
     * Encuentra un elemento en la tabla
     * @param x elemento a buscar
     * @return el elemento encontrado
     */
    Object buscar(Hashable x);
    /**
     * Hace la tabla de hash logicamente vacia
     */
    void vaciar();
    boolean estaVacio();
    int getTamanioTablaDefault();
    void imprimirTablaHash();
}