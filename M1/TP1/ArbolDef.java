/*
 * Define la interface ARBOL
 * Se basa en un arbol ABB
 * 
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

public interface ArbolDef {
    int Raiz();
    ArbolDef HijoIzq();
    ArbolDef HijoDer();
    boolean ArbolVacio();
    void InicializarArbol();
    void AgregarElem(int x);
    void EliminarElem(int x);
}
