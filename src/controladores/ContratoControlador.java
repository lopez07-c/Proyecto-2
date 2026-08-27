/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import exepciones.EspacioNoDisponibleException;
import exepciones.StorageBoxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Espacio;
import modelo.EstadoContrato;
import modelo.ServicioAdicional;
import modelo.StorageBoxModelo;
/**
 *
 * @author matam
 */
public class ContratoControlador {

    private final StorageBoxModelo modelo;

    public ContratoControlador(StorageBoxModelo modelo) {
        this.modelo = modelo;
    }

    public Contrato solicitarContrato(String idCliente,String numEspacio,LocalDate fechaInicio,LocalDate fechaFinal)
            throws StorageBoxException {

        Cliente cliente = buscarCliente(idCliente);

        if (cliente == null) {

            throw new StorageBoxException("El cliente no existe");
        }

        Espacio espacio = buscarEspacio(numEspacio);

        if (espacio == null) {

            throw new StorageBoxException("El espacio no existe");
        }

        if (fechaInicio == null|| fechaFinal == null) {

            throw new StorageBoxException("Debe indicar las fechas del contrato");
        }

        if (!fechaFinal.isAfter(fechaInicio)) {
            
            throw new StorageBoxException("La fecha final debe ser posterior a la fecha inicial");
        }

        for (Contrato contrato : modelo.getContratos()) {

            if (contrato.getEspacio().getNumeroEspacio().equalsIgnoreCase(numEspacio)) {

                if (contrato.getEstado()!= EstadoContrato.CANCELADO) {

                    boolean hayConflicto =!fechaFinal.isBefore(contrato.getFechaInicio())&&
                            !fechaInicio.isAfter( contrato.getFechaFinal());

                    if (hayConflicto) {

                        throw new EspacioNoDisponibleException( numEspacio);
                    }
                }
            }
        }

        Contrato nuevoContrato =  new Contrato( cliente,  espacio,  fechaInicio,  fechaFinal  );

        modelo.getContratos()
                .add(nuevoContrato);

        modelo.getContratosPendientes()
                .encolar(nuevoContrato);

        return nuevoContrato;
    }

    public Contrato activarSiguienteContrato()
            throws StorageBoxException {
        while (!modelo.getContratosPendientes().estaVacia()) {

            Contrato primero =
                    modelo.getContratosPendientes()
                            .verPrimero();

            if (primero.getEstado()
                    == EstadoContrato.CANCELADO) {

                modelo.getContratosPendientes()
                        .procesarSiguiente();

            } else {
                break;
            }
        }

        Contrato contrato =
                modelo.getContratosPendientes()
                        .verPrimero();

        if (contrato == null) {

            throw new StorageBoxException(
                    "No hay contratos pendientes"
            );
        }

        if (contrato.getEspacio().isOcupado()) {

            throw new EspacioNoDisponibleException(contrato.getEspacio().getNumeroEspacio());
        }

        contrato.activar();
        modelo.getContratosPendientes().procesarSiguiente();

        return contrato;
    }

    public void finalizarContrato(int numeroContrato) throws StorageBoxException {

        Contrato contrato = buscarContrato(numeroContrato);

        if (contrato == null) {

            throw new StorageBoxException( "El contrato no existe");
        }

        contrato.finalizar();
    }

    public void cancelarContrato(int numeroContrato)throws StorageBoxException {

        Contrato contrato = buscarContrato(numeroContrato);

        if (contrato == null) {

            throw new StorageBoxException( "El contrato no existe");
        }
        contrato.cancelar();
    }

    public Contrato buscarContrato(
            int numeroContrato) {

        for (Contrato contrato : modelo.getContratos()) {

            if (contrato.getNumeroContrato() == numeroContrato) {

                return contrato;
            }
        }

        return null;
    }

    public List<Contrato> listarContratos() {

        return new ArrayList<>(
                modelo.getContratos());
    }
    public List<Cliente> listarClientes() {
        
        return modelo.getClientes().aLista();
    }

    public List<Espacio> listarEspaciosDisponibles() {

        List<Espacio> disponibles = new ArrayList<>();

        for (Espacio espacio : modelo.getEspacios().obtenerTodos()) {

            if (!espacio.isOcupado()) {

                disponibles.add(espacio);
            }
        }

        return disponibles;
    }

    public List<ServicioAdicional>
            listarServicios() {

        return new ArrayList<>(modelo.getServicios());
    }

    public void agregarServicioContrato(int numeroContrato,String codigoServicio)throws StorageBoxException {

        Contrato contrato =buscarContrato(numeroContrato);

        if (contrato == null) {

            throw new StorageBoxException("El contrato no existe");
        }

        ServicioAdicional servicio =buscarServicio(codigoServicio);

        if (servicio == null) {

            throw new StorageBoxException("El servicio no existe");
        }

        contrato.agregarServicio(servicio);
    }

    private Cliente buscarCliente(String identificacion) {

        for (Cliente cliente : modelo.getClientes().aLista()) {

            if (cliente.getIdentificacion().equalsIgnoreCase(identificacion)) {

                return cliente;
            }
        }

        return null;
    }

    private Espacio buscarEspacio(String numero) {

        return modelo.getEspacios().buscar(numero);
    }

    private ServicioAdicional buscarServicio(String codigo) {

        for (ServicioAdicional servicio : modelo.getServicios()) {

            if (servicio.getCodigo().equalsIgnoreCase(codigo)) {

                return servicio;
            }
        }

        return null;
    }
}