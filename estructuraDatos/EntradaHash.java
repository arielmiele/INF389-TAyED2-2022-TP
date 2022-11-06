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
    private EntradaHash ant = null;
    private EntradaHash sig = null;

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

    public EntradaHash getSig() {
        return sig;
    }

    public void setSig(EntradaHash sig) {
        this.sig = sig;
    }

    public EntradaHash getAnt() {
        return ant;
    }

    public void setAnt(EntradaHash ant) {
        this.ant = ant;
    }

    public String aCadena() {
        return this.elemento.toString();
    }

    public boolean estaActivo() {
        return this.estaActivo;
    }
}
