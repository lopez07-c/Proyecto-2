/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import exepciones.EspacioNoDisponibleException;
import exepciones.StorageBoxException;
import estructuras.ColaContratos;
import estructuras.ListaClientes;
import estructuras.MapaEspacios;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Espacio;
import modelo.EstadoContrato;
import modelo.TipoEspacio;
/**
 *
 * @author matam
 */
public class StorageBoxControlador {
    
    private ListaClientes<Cliente> clientes = new ListaClientes<>();
    private MapaEspacios<String, Espacio> espacios = new MapaEspacios<>();
    private ColaContratos<Contrato> contratosPendientes = new ColaContratos<>();
    private ArrayList<Contrato> contratos = new ArrayList<>();
    
    public void registrarCliente(Cliente cliente)
            throws StorageBoxException {

        if (cliente == null) {
            throw new StorageBoxException(
                    "Los datos del cliente no pueden ser nulos."
            );
        }

        if (cliente.getIdentificacion() == null
                || cliente.getIdentificacion().trim().isEmpty()) {

            throw new StorageBoxException(
                    "La identificación del cliente es requerida."
            );
        }

        for (Cliente c : clientes.aLista()) {

            if (c.getIdentificacion().equalsIgnoreCase(
                    cliente.getIdentificacion())) {

                throw new StorageBoxException(
                        "El cliente con identificación "
                        + cliente.getIdentificacion()
                        + " ya existe"
                );
            }
        }

        clientes.agregar(cliente);
    }

    public void modificarCliente(String identificacion,
            String nombre,
            String telefono,
            String correo)
            throws StorageBoxException {

        Cliente cliente = buscarCliente(identificacion);

        if (cliente == null) {
            throw new StorageBoxException(
                    "El cliente no existe"
            );
        }

        cliente.setNombreCompleto(nombre);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);
    }

    public void eliminarCliente(String identificacion)
            throws StorageBoxException {

        Cliente cliente = buscarCliente(identificacion);

        if (cliente == null) {
            throw new StorageBoxException(
                    "El cliente no existe"
            );
        }

        for (Contrato contrato : contratos) {

            if (contrato.getCliente().getIdentificacion()
                    .equalsIgnoreCase(identificacion)) {

                if (contrato.getEstado() == EstadoContrato.PENDIENTE
                        || contrato.getEstado() == EstadoContrato.ACTIVO) {

                    throw new StorageBoxException(
                            "No se puede eliminar el cliente porque tiene un contrato pendiente o activo"
                    );
                }
            }
        }

        clientes.eliminar(cliente);
    }

    public Cliente buscarCliente(String identificacion) {

        if (identificacion == null) {
            return null;
        }

        for (Cliente cliente : clientes.aLista()) {

            if (cliente.getIdentificacion()
                    .equalsIgnoreCase(identificacion)) {

                return cliente;
            }
        }

        return null;
    }

    public void registrarEspacio(String numero,
            TipoEspacio tipo)
            throws StorageBoxException {

        if (numero == null || numero.trim().isEmpty()) {
            throw new StorageBoxException(
                    "El número de espacio no puede estar vacío"
            );
        }

        if (tipo == null) {
            throw new StorageBoxException(
                    "Debe seleccionar un tipo de espacio"
            );
        }

        if (espacios.existe(numero)) {
            throw new StorageBoxException(
                    "El espacio con número"
                    + numero
                    + " ya está registrado"
            );
        }

        Espacio espacio = new Espacio(numero, tipo);

        espacios.registrar(numero, espacio);
    }

    public void modificarEspacio(String numero,
            TipoEspacio tipo,
            double tamanio,
            double precio)
            throws StorageBoxException {

        Espacio espacio = espacios.buscar(numero);

        if (espacio == null) {
            throw new StorageBoxException(
                    "El espacio no existe"
            );
        }

        if (tipo == null) {
            throw new StorageBoxException(
                    "Debe seleccionar un tipo de espacio"
            );
        }

        if (tamanio <= 0) {
            throw new StorageBoxException(
                    "El tamaño debe ser mayor a 0"
            );
        }

        if (precio <= 0) {
            throw new StorageBoxException(
                    "El precio debe ser mayor a 0"
            );
        }

        espacio.setTipo(tipo);
        espacio.setTamanioM2(tamanio);
        espacio.setPrecioMensual(precio);
    }

    public void eliminarEspacio(String numero)
            throws StorageBoxException {

        Espacio espacio = espacios.buscar(numero);

        if (espacio == null) {
            throw new StorageBoxException(
                    "El espacio no existe"
            );
        }

        if (espacio.isOcupado()) {
            throw new StorageBoxException(
                    "No se puede eliminar un espacio ocupado"
            );
        }

        espacios.remover(numero);
    }

    public Espacio buscarEspacio(String numero) {

        if (numero == null) {
            return null;
        }

        return espacios.buscar(numero);
    }

    public Contrato solicitarContrato(String idCliente,
            String numEspacio,
            LocalDate inicio,
            LocalDate fechaFinal)
            throws StorageBoxException {

        Cliente cliente = buscarCliente(idCliente);

        if (cliente == null) {
            throw new StorageBoxException(
                    "El cliente solicitado no existe en el sistema"
            );
        }

        Espacio espacio = espacios.buscar(numEspacio);

        if (espacio == null) {
            throw new StorageBoxException(
                    "El espacio indicado no existe"
            );
        }

        if (espacio.isOcupado()) {
            throw new EspacioNoDisponibleException(numEspacio);
        }

        Contrato nuevoContrato = new Contrato(
                cliente,
                espacio,
                inicio,
                fechaFinal
        );

        contratosPendientes.encolar(nuevoContrato);
        contratos.add(nuevoContrato);

        return nuevoContrato;
    }

    public ListaClientes<Cliente> getClientes() {
        return clientes;
    }

    public MapaEspacios<String, Espacio> getEspacios() {
        return espacios;
    }

    public ColaContratos<Contrato> getContratosPendientes() {
        return contratosPendientes;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }
}
