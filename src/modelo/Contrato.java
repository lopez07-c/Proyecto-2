/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import exepciones.StorageBoxException;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author matam
 */
public class Contrato {
    
    private static int consecutivo = 1;

    private final int numeroContrato;
    private final Cliente cliente;
    private final Espacio espacio;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFinal;

    private EstadoContrato estado;
    private final ArrayList<ServicioAdicional> servicios;

    private int cantidadDias;
    private int cantidadPeriodos;

    private double subtotal;
    private double impuestos;
    private double total;

    public Contrato(Cliente cliente, Espacio espacio,
            LocalDate fechaInicio, LocalDate fechaFinal)
            throws StorageBoxException {

        if (cliente == null) {
            throw new StorageBoxException("Debe seleccionar un cliente.");
        }

        if (espacio == null) {
            throw new StorageBoxException("Debe seleccionar un espacio.");
        }

        if (fechaInicio == null || fechaFinal == null) {
            throw new StorageBoxException("Debe indicar las fechas del contrato.");
        }

        if (fechaFinal.isBefore(fechaInicio)) {
            throw new StorageBoxException(
                    "La fecha final no puede ser anterior a la fecha inicial."
            );
        }

        this.numeroContrato = consecutivo;
        consecutivo++;

        this.cliente = cliente;
        this.espacio = espacio;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;

        this.estado = EstadoContrato.PENDIENTE;
        this.servicios = new ArrayList<>();

        cantidadDias = 1;
        LocalDate fecha = fechaInicio;

        while (fecha.isBefore(fechaFinal)) {
            fecha = fecha.plusDays(1);
            cantidadDias++;
        }

        cantidadPeriodos = cantidadDias / 30;

        if (cantidadDias % 30 != 0) {
            cantidadPeriodos++;
        }

        calcularCostos();
    }

    public void agregarServicio(ServicioAdicional servicio) {

        if (servicio != null) {
            servicios.add(servicio);
            calcularCostos();
        }
    }

    public void eliminarServicio(ServicioAdicional servicio) {

        if (servicio != null) {
            servicios.remove(servicio);
            calcularCostos();
        }
    }

    private void calcularCostos() {

        total = espacio.getPrecioMensual() * cantidadPeriodos;

        for (ServicioAdicional servicio : servicios) {
            total += servicio.getPrecio();
        }

        subtotal = total;
        impuestos = 0;
    }

    public void activar() throws StorageBoxException {

    if (estado != EstadoContrato.PENDIENTE) {
        throw new StorageBoxException(
                "Solo se pueden activar contratos pendientes"
        );
    }

    estado = EstadoContrato.ACTIVO;
    espacio.setOcupado(true);
}

    public void finalizar() throws StorageBoxException {

    if (estado != EstadoContrato.ACTIVO) {
        throw new StorageBoxException(
                "Solo se pueden finalizar contratos activos"
        );
    }

    estado = EstadoContrato.FINALIZADO;
    espacio.setOcupado(false);
}

public void cancelar() throws StorageBoxException {

    if (estado != EstadoContrato.PENDIENTE) {
        throw new StorageBoxException(
                "Solo se pueden cancelar contratos pendientes"
        );
    }

    estado = EstadoContrato.CANCELADO;
    espacio.setOcupado(false);
}

    public int getNumeroContrato() {
        return numeroContrato;
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

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public EstadoContrato getEstado() {
        return estado;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public int getCantidadPeriodos() {
        return cantidadPeriodos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<ServicioAdicional> getServicios() {
        return new ArrayList<>(servicios);
    }
}

