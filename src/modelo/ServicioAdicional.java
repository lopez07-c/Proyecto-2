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
public class ServicioAdicional {
    
    private static int consecutivo = 1;
    private final String codigo;
    private final String nombre;
    private String descripcion;
    private double precio;

    public ServicioAdicional(String nombre, String descripcion, double precio)
            throws StorageBoxException {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new StorageBoxException("El nombre del servicio es requerido");
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new StorageBoxException("La descripción es requerida");
        }

        if (precio < 0) {
            throw new StorageBoxException("El precio no puede ser negativo");
        }

        this.codigo = generarCodigo();
        this.nombre = nombre.trim();
        this.descripcion = descripcion.trim();
        this.precio = precio;
    }

    private static String generarCodigo() {
        String codigoGenerado = String.format("SER-%03d", consecutivo);
        consecutivo++;
        return codigoGenerado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setDescripcion(String descripcion) throws StorageBoxException {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new StorageBoxException("La descripción no puede estar vacía");
        }

        this.descripcion = descripcion.trim();
    }

    public void setPrecio(double precio) throws StorageBoxException {
        if (precio < 0) {
            throw new StorageBoxException("El precio no puede ser negativo");
        }

        this.precio = precio;
    }
}
