package estructuraDatos;

public class TablaHashingAbierto extends ExploracionTablaHash {

    int saltos;

    protected int buscarPos(Hashable x) {
        return x.hash(vector.length);
    }

    public void imprimirTablaHash() {
        super.imprimirTablaHash();
        for (int i = 0; i < this.vector.length; i++) {
            String dato;
            if (this.vector[i] == null) {
                dato = null;
            } else {
                EntradaHash siguiente = this.vector[i];
                dato = "";
                while (siguiente != null) {
                    dato = dato + siguiente.toString() + " ";
                    siguiente = siguiente.getSig();
                }
            }
            if (dato == null) {
                System.out.println(" * " + i + " * " + "Libre" + " *");
            } else {
                System.out.println(" * " + i + " * " + dato + " *");
            }
        }
    }

    public void insertar(Hashable valor) {
        this.saltos = 1;
        int posicion = this.buscarPos(valor);
        if (this.vector[posicion] == null) {
            this.vector[posicion] = new EntradaHash(valor, true);
        } else {
            this.insertarEn(valor, this.vector[posicion]);
        }
        System.out.println("Se agrega el elemento " + valor.toString() + " a la posicion " + posicion
                + " numero de elemento dentro de la posicion " + this.saltos);
    }

    private void insertarEn(Hashable valor, EntradaHash entrada) {
        this.saltos++;
        if (entrada.getSig() == null) {
            EntradaHash nuevaEntrada = new EntradaHash(valor, true);
            entrada.setSig(nuevaEntrada);
            nuevaEntrada.setAnt(entrada);
        } else {
            this.insertarEn(valor, entrada.getSig());
            ;
        }
    }

    public void eliminar(Hashable valor) {
        int posicion = buscarPos(valor);
        EntradaHash resultado = this.buscar(valor);
        if (resultado != null) {
            resultado.setEstaActivo(false);
            if (resultado.getAnt() == null) {
                EntradaHash nuevaraiz = this.vector[posicion].getSig();
                this.vector[posicion] = nuevaraiz;
                nuevaraiz.setAnt(null);
            } else {
                resultado.setEstaActivo(false);
                if (resultado.getSig() != null)
                    resultado.getSig().setAnt(resultado.getAnt());
                if (resultado.getAnt() != null)
                    resultado.getAnt().setSig(resultado.getSig());
            }
        } else {
            System.out.println("No existe el valor dentro de la tabla hash.\n");
        }
    }

    public EntradaHash buscar(Hashable valor) {
        int posicion = buscarPos(valor);
        EntradaHash respuesta = null;
        if (this.vector[posicion] != null) {
            System.out.println("No existe el valor dentro de la tabla Hash.\n");
            return null;
        }
        System.out.println("Se encontro el valor en el indice " + Integer.parseInt(String.valueOf(posicion)));
        if (this.vector[posicion].getElemento().equals(valor)) {
            System.out.println(this.vector[posicion].getElemento());
            return this.vector[posicion];
        } else {
            if (this.vector[posicion].getSig() != null) {
                respuesta = this.buscar(valor, this.vector[posicion].getSig());
            }
        }
        if (respuesta == null) {
            System.out.println("No existe el valor dentro de la tabla Hash.\n");
        }
        return respuesta;
    }

    private EntradaHash buscar(Hashable valor, EntradaHash entradaHash) {
        if (entradaHash.getElemento().equals(valor)) {
            System.out.println(entradaHash.getElemento());
            return entradaHash;
        } else {
            if (entradaHash.getSig() != null) {
                return this.buscar(valor, entradaHash.getSig());
            }
        }
        return null;
    }
}
