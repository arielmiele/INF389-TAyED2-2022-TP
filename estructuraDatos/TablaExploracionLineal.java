/*
 * INF389 - Taller de Algoritmos y Estructura de Datos II
 * Trabajo Práctico N° 2
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

package estructuraDatos;

public class TablaExploracionLineal extends ExploracionTablaHash {

    protected int buscarPos(Hashable x) {
        if (!this.estaVacio()) {
            System.out.println("No existe más posiciones disponibles en la tabla.\n");
            return 0;
        }

        int colision = 0;
        int posicionActual = x.hash(vector.length);
        int posicionInicial = posicionActual;

        while (vector[posicionActual] != null && !vector[posicionActual].getElemento().equals(x)) {
            posicionActual += 1;
            if (posicionActual >= vector.length) {
                posicionActual -= vector.length;
            }
        }

        return posicionActual;
    }

    public void imprimirTablaHash() {
        super.imprimirTablaHash();
        for (int i = 0; i < this.vector.length; i++) {
            System.out.println(" * " + i + " * " + this.vector[i] + " * ");
        }
    }
}
