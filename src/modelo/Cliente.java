/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author matam
 */
public class Cliente {
    
    private String identificacion;
    private String nombreCompleto;
    private String telefono;

    public Cliente(String identificacion, String nombreCompleto, String telefono) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    public String getIdentificacion() { 
        return identificacion; 
    }
    public String getNombreCompleto() { 
        return nombreCompleto; 
    }
    public String getTelefono() { 
        return telefono; 
    }

    public void setIdentificacion(String identificacion) { 
        this.identificacion = identificacion; 
    }
    
    public void setNombreCompleto(String nombreCompleto) { 
        this.nombreCompleto = nombreCompleto; 
    }
    
    public void setTelefono(String telefono) { 
        this.telefono = telefono; 
    }

    @Override
    public String toString() {
        return identificacion + " - " + nombreCompleto;
    }
}
