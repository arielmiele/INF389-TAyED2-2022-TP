/*
 * Esta interface define el TDA de Conjunto a utilizar
 * 
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */

public interface ConjuntoTDA {
    void InicializarConjunto();

    boolean ConjuntoVacio();

    void Agregar(int x);

    int Elegir();

    void Sacar(int x);

    boolean Pertenece(int x);

    int tamaño();
}
