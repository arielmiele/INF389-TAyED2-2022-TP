/*
 * Se define la clase Vertice
 * 
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

public class Vertice {
    Nodo v;

    public void InicializarVertice() {
        v = null;
    }

    public boolean VerticeVacio() {
        return (v == null);
    }

    public void Agregar(int x) {
        // Verificamos que x ya no exista en este vértice
        if (!this.Pertenece(x)) {
            Nodo aux = new Nodo();
            aux.info = x;
            aux.sig = v;
            v = aux;
        }
    }

    public int Elegir() {
        return v.info;
    }

    public void Sacar(int x) {
        if (v != null) {
            // Si es el primer elemento de la lista
            if (v.info == x) {
                v = v.sig;
            } else {
                Nodo aux = v;
                while (aux.sig != null && aux.sig.info != x) {
                    aux = aux.sig;
                }
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    public boolean Pertenece(int x) {
        Nodo aux = v;
        while ((aux != null) && (aux.info != x)) {
            aux = aux.sig;
        }
        return (aux != null);
    }
}
