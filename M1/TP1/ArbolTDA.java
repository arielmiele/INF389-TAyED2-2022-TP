/*
 * Implementa el TDA ARBOL para la itnerface ArbolDef
 * Se basa en un arbol ABB
 * 
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

public class ArbolTDA implements ArbolDef {
    NodoArbol raiz;

    public int Raiz() {
        return raiz.info;
    }

    public ArbolDef HijoIzq() {
        return raiz.hijoIzq;
    }

    public ArbolDef HijoDer() {
        return raiz.hijoDer;
    }

    public boolean ArbolVacio() {
        return (raiz == null);
    }

    public void InicializarArbol() {
        raiz = null;
    }

    public void AgregarElem(int x) {
        if (raiz == null) {
            raiz = new NodoArbol();
            raiz.info = x;
            raiz.hijoIzq = new ArbolTDA();
            raiz.hijoIzq.InicializarArbol();
            raiz.hijoDer = new ArbolTDA();
            raiz.hijoDer.InicializarArbol();
        } else if (raiz.info > x) {
            raiz.hijoIzq.AgregarElem(x);
        } else if (raiz.info < x) {
            raiz.hijoDer.AgregarElem(x);
        }
    }

    public void EliminarElem(int x) {
        if (raiz != null) {
            if (raiz.info == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()) {
                raiz = null;
            } else if (raiz.info == x && !raiz.hijoIzq.ArbolVacio()) {
                raiz.info = this.mayor(raiz.hijoIzq);
                raiz.hijoIzq.EliminarElem(raiz.info);
            } else if (raiz.info == x && raiz.hijoIzq.ArbolVacio()) {
                raiz.info = this.menor(raiz.hijoDer);
                raiz.hijoDer.EliminarElem(raiz.info);
            } else if (raiz.info < x) {
                raiz.hijoDer.EliminarElem(x);
            } else {
                raiz.hijoIzq.EliminarElem(x);
            }
        }
    }

    private int mayor(ArbolDef a) {
        if (a.HijoDer().ArbolVacio())
            return a.Raiz();
        else
            return mayor(a.HijoDer());
    }

    private int menor(ArbolDef a) {
        if (a.HijoIzq().ArbolVacio())
            return a.Raiz();
        else
            return menor(a.HijoIzq());
    }

}