/*
 * Esta interface define el TDA de ColaPrioridad a utilizar
 * 
 * Nombre: Ariel Gerardo Miele
 * Legajo: VINF011482
 * DNI: 34.434.704
 */
public interface ColaPrioridadTDA<E> {
    // Agrega el elemento e con la prioridad asociada p
    void AgregarElemento(E e, double p);

    // Devuelve true si la cola no tiene elementos y false en caso contrario
    boolean ColaVacia();

    // Elimina el elemento con mayor prioridad
    void EliminarMaxPrioridad();

    // Elimina el elemento con menor prioridad
    void EliminarMinPrioridad();

    // Inicializa la cola
    void InicializarCola();

    // Recupera el valor del elemento con mayor prioridad
    E RecuperarMaxElemento();

    // Recupera la prioridad del elemento con mayor prioridad
    double RecuperarMaxPrioridad();

    // Recupera el valor del elemento con menor prioridad
    E RecuperarMinElemento();

    // Recupera la prioridad del elemento con menor prioridad
    double RecuperarMinPrioridad();
}
