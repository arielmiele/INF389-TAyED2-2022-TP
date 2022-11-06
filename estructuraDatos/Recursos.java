/*
 * INF389 - Taller de Algoritmos y Estructura de Datos II
 * Trabajo Práctico N° 2
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

package estructuraDatos;

public class Recursos implements Hashable {

    private int codigo;

    public Recursos(int valor) {
        this.codigo = valor;
    }

    public int hash(int tableSize) {
        return this.codigo % tableSize;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Recursos recurso = (Recursos) obj;
        return this.codigo == recurso.codigo;
    }

    public String aCadena() {
        return "Recurso (cod = " + this.codigo + ").\n";
    }

    public int obtCodigo() {
        return this.codigo;
    }
}