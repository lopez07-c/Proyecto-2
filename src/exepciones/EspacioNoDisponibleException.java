/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exepciones;

/**
 *
 * @author matam
 */
public class EspacioNoDisponibleException extends StorageBoxException {
    public EspacioNoDisponibleException(String numeroEspacio) {
        super("El espacio " + numeroEspacio + " no está disponible.");
    }
}