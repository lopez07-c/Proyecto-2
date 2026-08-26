/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package estructuras;

import java.util.List;

/**
 *
 * @author matam
 * @param <T>
 */
public interface IEstructuraDinamica<T> {
    void agregar(T elemento);
    boolean eliminar(T elemento);
    T obtener(int indice);
    int getTamanio();
    List<T> aLista();
}