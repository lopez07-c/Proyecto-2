/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author matam
 */
public enum PuestoEmpleado {
    ADMINISTRADOR("Administrador", 950000.0),
    RECEPCIONISTA("Recepcionista", 700000.0),
    ENCARGADO_BODEGA("Encargado de bodega", 650000.0),
    MANTENIMIENTO("Mantenimiento", 600000.0),
    OPERARIO_CARGA("Operario de carga", 575000.0);

    private final String titulo;
    private final double salarioBase;

    PuestoEmpleado(String titulo, double salarioBase) {
        this.titulo = titulo;
        this.salarioBase = salarioBase;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
