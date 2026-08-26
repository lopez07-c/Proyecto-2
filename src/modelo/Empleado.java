/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import exepciones.StorageBoxException;

/**
 *
 * @author matam
 */
public class Empleado {
    private final String identificacion;
    private String nombre;
    private String telefono;
    private PuestoEmpleado puesto;
    private double salario;

    public Empleado(String identificacion, String nombre,
            String telefono, PuestoEmpleado puesto)
            throws StorageBoxException {

        if (identificacion == null || identificacion.trim().isEmpty()) {
            throw new StorageBoxException("La identificación es requerida");
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new StorageBoxException("El nombre es requerido");
        }

        if (telefono == null || telefono.trim().isEmpty()) {
            throw new StorageBoxException("El teléfono es requerido.");
        }

        if (puesto == null) {
            throw new StorageBoxException("Debe seleccionar un puesto");
        }

        this.identificacion = identificacion.trim();
        this.nombre = nombre.trim();
        this.telefono = telefono.trim();
        this.puesto = puesto;
        this.salario = puesto.getSalarioBase();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public PuestoEmpleado getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setNombre(String nombre) throws StorageBoxException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new StorageBoxException("El nombre no puede estar vacío");
        }

        this.nombre = nombre.trim();
    }

    public void setTelefono(String telefono) throws StorageBoxException {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new StorageBoxException("El teléfono no puede estar vacío");
        }

        this.telefono = telefono.trim();
    }

    public void setPuesto(PuestoEmpleado puesto) throws StorageBoxException {
        if (puesto == null) {
            throw new StorageBoxException("Debe seleccionar un puesto");
        }

        this.puesto = puesto;
        this.salario = puesto.getSalarioBase();
    }
}
