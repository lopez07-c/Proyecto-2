/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author matam
 */
public enum TipoEspacio {
    PEQUENO("Pequeño", 5.0, 25000.0),
    MEDIANO("Mediano", 10.0, 45000.0),
    GRANDE("Grande", 20.0, 70000.0);

    private final String nombre;
    private final double tamanioM2;
    private final double precioBase;

    TipoEspacio(String nombre, double tamanioM2, double precioBase) {
        this.nombre = nombre;
        this.tamanioM2 = tamanioM2;
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTamanioM2() {
        return tamanioM2;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    @Override
    public String toString() {
        return nombre;
    }
}