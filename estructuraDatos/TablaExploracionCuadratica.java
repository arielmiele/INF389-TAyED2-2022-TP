/*
 * INF389 - Taller de Algoritmos y Estructura de Datos II
 * Trabajo Práctico N° 2
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

package estructuraDatos;

public class TablaExploracionCuadratica extends ExploracionTablaHash {

    public TablaExploracionCuadratica() {
        super();
    }

    protected int buscarPos(Hashable x) {
        int colision = 0;
        int posicionActual = x.hash(vector.length);
        while (vector[posicionActual] != null && !vector[posicionActual].getElemento().equals(x)) {
            posicionActual += 2 * ++colision - 1;
            if (posicionActual >= vector.length)
                posicionActual -= vector.length;
        }
        System.out.println("Para el elemento: " + x.toString() + " posición: " + posicionActual);
        return posicionActual;
    }
}
