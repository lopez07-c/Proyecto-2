/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matam
 * @param <T>
 */
public class ListaClientes<T> implements IEstructuraDinamica<T> {

    private List<T> elementos;

    public ListaClientes() {
        this.elementos = new ArrayList<>();
    }

    @Override
    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    @Override
    public boolean eliminar(T elemento) {
        return elementos.remove(elemento);
    }

    @Override
    public int getTamanio() {
        return elementos.size();
    }

    @Override
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    @Override
    public Object[] aArreglo() {
        return elementos.toArray();
    }

    public T obtener(int indice) {
        if (indice >= 0 && indice < elementos.size()) {
            return elementos.get(indice);
        }
        return null;
    }

    public List<T> aLista() {
        return new ArrayList<>(elementos);
    }
}
