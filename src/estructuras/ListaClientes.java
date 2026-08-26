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

    private final List<T> elementos;

    public ListaClientes() {
        elementos = new ArrayList<>();
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
    public T obtener(int indice) {

        if (indice >= 0 && indice < elementos.size()) {
            return elementos.get(indice);
        }

        return null;
    }

    @Override
    public int getTamanio() {
        return elementos.size();
    }

    @Override
    public List<T> aLista() {
        return new ArrayList<>(elementos);
    }
}
