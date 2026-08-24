/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author matam
 */
public class Contrato {
    
    private String codigo;
    private Cliente cliente;
    private Espacio espacio;
    private LocalDate fechaInicio;
    private int meses;
    private EstadoContrato estado;

    public Contrato(String codigo, Cliente cliente, Espacio espacio, LocalDate fechaInicio, int meses) {
        
    this.codigo = codigo;
    this.cliente = cliente;
    this.espacio = espacio;
    this.fechaInicio = fechaInicio;
    this.meses = meses;
    this.estado = EstadoContrato.PENDIENTE;
    }

    public String getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public int getMeses() {
        return meses;
    }

    public EstadoContrato getEstado() {
        return estado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public void setEstado(EstadoContrato estado) {
        this.estado = estado;
    }


    public double calcularMontoTotal() {
        if (espacio != null) {
            return espacio.getPrecioMensual() * meses;
        }
        return 0.0;
    }
}

