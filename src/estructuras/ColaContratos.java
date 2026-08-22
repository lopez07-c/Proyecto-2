/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author matam
 * @param <T>
 */
public class ColaContratos<T> {
    
    private Queue<T> cola = new LinkedList<>();

    public void encolar(T elemento) { 
        cola.add(elemento); 
    }
    public T procesarSiguiente() { 
        return cola.poll(); 
    }
    public T verPrimero() { 
        return cola.peek(); 
    }
    public boolean estaVacia() { 
        return cola.isEmpty(); 
    }
    public int getTamanio() { 
        return cola.size(); 
    }
}
