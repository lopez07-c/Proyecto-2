/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import exepciones.StorageBoxException;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author matam
 */
public class Cliente {
    
    private final String identificacion;
    private String nombreCompleto;
    private final LocalDate fechaNacimiento;
    private String telefono;
    private String correo;

    public Cliente(String identificacion, String nombreCompleto,
            LocalDate fechaNacimiento, String telefono, String correo)
            throws StorageBoxException {

        if (identificacion == null || identificacion.trim().isEmpty()) {
            throw new StorageBoxException("La identificación es requerida.");
        }

        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new StorageBoxException("El nombre del cliente es requerido.");
        }

        if (fechaNacimiento == null) {
            throw new StorageBoxException("La fecha de nacimiento es requerida.");
        }

        if (fechaNacimiento.isAfter(LocalDate.now())) {
            throw new StorageBoxException("La fecha de nacimiento no es válida.");
        }

        if (telefono == null || telefono.trim().isEmpty()) {
            throw new StorageBoxException("El teléfono es requerido.");
        }

        if (correo == null || correo.trim().isEmpty()) {
            throw new StorageBoxException("El correo electrónico es requerido.");
        }

        this.identificacion = identificacion.trim();
        this.nombreCompleto = nombreCompleto.trim();
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono.trim();
        this.correo = correo.trim();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public void setNombreCompleto(String nombreCompleto) throws StorageBoxException {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new StorageBoxException("El nombre no puede estar vacío.");
        }

        this.nombreCompleto = nombreCompleto.trim();
    }

    public void setTelefono(String telefono) throws StorageBoxException {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new StorageBoxException("El teléfono no puede estar vacío.");
        }

        this.telefono = telefono.trim();
    }

    public void setCorreo(String correo) throws StorageBoxException {
        if (correo == null || correo.trim().isEmpty()) {
            throw new StorageBoxException("El correo no puede estar vacío.");
        }

        this.correo = correo.trim();
    }
}
