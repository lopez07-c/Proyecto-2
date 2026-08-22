/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package estructuras;

/**
 *
 * @author matam
 * @param <T>
 */
public interface IEstructuraDinamica <T>{
    
    void agregar(T elemento);
    boolean eliminar(T elemento);
    int getTamanio();
    boolean estaVacia();
    Object[] aArreglo();
}
