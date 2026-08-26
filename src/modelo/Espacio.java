/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author matam
 */
public class Espacio {
    
    private String numeroEspacio;
    private TipoEspacio tipo;
    private double tamanioM2;
    private double precioMensual;
    private boolean ocupado;

    public Espacio(String numeroEspacio, TipoEspacio tipo) {
        this.numeroEspacio = numeroEspacio;
        this.tipo = tipo;
        this.tamanioM2 = tipo.getTamanioM2();
        this.precioMensual = tipo.getPrecioBase();
        this.ocupado = false;
    }

    public String getNumeroEspacio() {
        return numeroEspacio;
    }

    public TipoEspacio getTipo() {
        return tipo;
    }

    public double getTamanioM2() {
        return tamanioM2;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setTipo(TipoEspacio tipo) {
        this.tipo = tipo;
        this.tamanioM2 = tipo.getTamanioM2();
        this.precioMensual = tipo.getPrecioBase();
    }

    public void setTamanioM2(double tamanioM2) {
        this.tamanioM2 = tamanioM2;
    }

    public void setPrecioMensual(double precioMensual) {
        this.precioMensual = precioMensual;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}