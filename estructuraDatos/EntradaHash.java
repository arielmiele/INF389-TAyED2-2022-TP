/*
 * INF389 - Taller de Algoritmos y Estructura de Datos II
 * Trabajo Práctico N° 2
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

package estructuraDatos;

public class EntradaHash {

    private Hashable elemento;
    private boolean estaActivo;

    public EntradaHash(Hashable x, boolean b) {
        this.elemento = x;
        this.estaActivo = b;
    }

    public EntradaHash(Hashable e) {
        this.elemento = e;
        this.estaActivo = true;
    }

    public Hashable getElemento() {
        return this.elemento;
    }

    public void setEstaActivo(boolean b) {
        this.estaActivo = true;
    }

}
