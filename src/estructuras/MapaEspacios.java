/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author matam
 * @param <K>
 * @param <V>
 */
public class MapaEspacios<K, V> {
    
    private Map<K, V> mapa = new HashMap<>();

    public void registrar(K clave, V valor) {
        mapa.put(clave, valor); 
    }
    public V buscar(K clave) { 
        return mapa.get(clave); 
    }
    public boolean existe(K clave) { 
        return mapa.containsKey(clave); 
    }
    public V remover(K clave) { 
        return mapa.remove(clave); 
    }
    public Collection<V> obtenerTodos() { 
        return mapa.values(); 
    }
    public int getTamanio() { 
        return mapa.size(); 
    }
}