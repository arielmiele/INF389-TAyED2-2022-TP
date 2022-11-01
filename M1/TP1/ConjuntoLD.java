/*
 * Implementación de la interface ConjuntoTDA utilizando listas dinámicas
 * 
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

public class ConjuntoLD implements ConjuntoTDA {

    Nodo c;

    public void InicializarConjunto() {
        c = null;
    }

    public boolean ConjuntoVacio() {
        return (c == null);
    }

    public void Agregar(int x) {
        // Se verifica que x no esté en el Conjunto
        if (!this.Pertenece(x)) {
            Nodo aux = new Nodo();
            aux.info = x;
            aux.sig = c;
            c = aux;
        }
    }

    public int Elegir() {
        return c.info;
    }

    public void Sacar(int x) {
        if (c != null) {
            // Si es el primer elemento de la lista
            if (c.info == x) {
                c = c.sig;
            } else {
                Nodo aux = c;
                while (aux.sig != null && aux.sig.info != x)
                    aux = aux.sig;
                if (aux.sig != null)
                    aux.sig = aux.sig.sig;
            }
        }
    }

    public boolean Pertenece(int x) {
        Nodo aux = c;
        while ((aux != null) && (aux.info != x)) {
            aux = aux.sig;
        }
        return (aux != null);
    }

    public int tamaño() {
        int t = 0;
        Nodo aux = c;
        while ((aux != null)) {
            t++;
        }
        return t;
    }
}
