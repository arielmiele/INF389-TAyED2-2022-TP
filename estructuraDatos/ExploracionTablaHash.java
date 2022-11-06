/*
 * INF389 - Taller de Algoritmos y Estructura de Datos II
 * Trabajo Práctico N° 2
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

package estructuraDatos;

public abstract class ExploracionTablaHash implements TablaHash {

    // Declaración de variables y constantes
    private static final int TAMANIO_TABLA_POR_DEFECTO = 11;

    // Vector de elementos
    protected EntradaHash[] vector;

    // Numero de celdas ocupadas
    private int tamanioActual;

    // Declaración de métodos constructores

    // Asignación de memoria al vector
    private final void crearVector(int tamanioVector) {
        vector = new EntradaHash[tamanioVector];
    }

    // Vacía la tabla
    public final void vaciar() {
        this.tamanioActual = 0;
        for (int i = 0; i < vector.length; i++)
            vector[i] = null;
    }

    public ExploracionTablaHash() {
        crearVector(TAMANIO_TABLA_POR_DEFECTO);
        vaciar();
    }

    public void insertar(Hashable x) {
        int posicionActual = buscarPos(x);
        vector[posicionActual] = new EntradaHash(x, true);
    }

    public final void eliminar(Hashable x) {
        int posicionActual = buscarPos(x);
        if (vector[posicionActual] == null) {
            System.out.println("No existe el valor en la tabla hash.\n");
        } else {
            vector[posicionActual].setEstaActivo(false);
        }
    }

    public final Hashable buscar(Hashable x) {
        int posicionActual = buscarPos(x);
        if (vector[posicionActual] == null) {
            System.out.println("No existe el valor en la tabla hash.\n");
        }
        return vector[posicionActual].getElemento();
    }

    protected abstract int buscarPos(Hashable x);

    public boolean estaVacio() {
        for (int i = 0; i < vector.length; i++) {
            if (this.vector[i] == null) {
                return true;
            }
        }
        return false;
    }

    public void imprimirTablaHash(){
        System.out.println(" * POSICION * VALOR *");
    }

    public int getTamanioTablaDefault(){
        return ExploracionTablaHash.TAMANIO_TABLA_POR_DEFECTO;
    }
}
