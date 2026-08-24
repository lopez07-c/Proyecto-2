/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import exepciones.EspacioNoDisponibleException;
import exepciones.StorageBoxException;
import modelo.*;
import estructuras.*;
import java.time.LocalDate;
/**
 *
 * @author matam
 */
public class StorageBoxControlador {
    
    private ListaClientes<Cliente> clientes = new ListaClientes<>();
    private MapaEspacios<String, Espacio> espacios = new MapaEspacios<>();
    private ColaContratos<Contrato> contratosPendientes = new ColaContratos<>();
    private int contadorContratos = 1;

    public void registrarEspacio(String numero, TipoEspacio tipo) throws StorageBoxException {
        if (numero == null || numero.trim().isEmpty()) {
            throw new StorageBoxException("El número de espacio no puede estar vacío.");
        }
        if (espacios.existe(numero)) {
            throw new StorageBoxException("El espacio con número " + numero + " ya está registrado.");
        }
        espacios.registrar(numero, new Espacio(numero, tipo));
    }

    public void registrarCliente(Cliente cliente) throws StorageBoxException {
        if (cliente == null) {
            throw new StorageBoxException("Los datos del cliente no pueden ser nulos.");
        }
        if (cliente.getIdentificacion() == null || cliente.getIdentificacion().trim().isEmpty()) {
            throw new StorageBoxException("La identificación del cliente es requerida.");
        }
        
        for (Cliente client : clientes.aLista()) {
            if (client.getIdentificacion().equalsIgnoreCase(cliente.getIdentificacion())) {
                throw new StorageBoxException("El cliente con identificación " + cliente.getIdentificacion() + " ya existe.");
            }
        }
        clientes.agregar(cliente);
    }

    public Contrato solicitarContrato(String idCliente, String numEspacio, LocalDate inicio, int meses) throws StorageBoxException {
        try {
            Cliente cliente = buscarCliente(idCliente);
            if (cliente == null) {
                throw new StorageBoxException("El cliente solicitado no existe en el sistema.");
            }

            Espacio espacio = espacios.buscar(numEspacio);
            if (espacio == null) {
                throw new StorageBoxException("El espacio indicado no existe.");
            }
            if (espacio.isOcupado()) {
                throw new EspacioNoDisponibleException(numEspacio);
            }

            String codigo = "CNT-" + String.format("%03d", contadorContratos++);

            Contrato nuevoContrato = new Contrato(codigo, cliente, espacio, inicio, meses);
            
            contratosPendientes.encolar(nuevoContrato);
            return nuevoContrato;

        } catch (EspacioNoDisponibleException e) {
            throw e;
        } catch (Exception e) {
            throw new StorageBoxException("Error inesperado al procesar el contrato: " + e.getMessage());
        }
    }

    public Cliente buscarCliente(String id) {
        if (id == null) return null;
        for (Cliente c : clientes.aLista()) {
            if (c.getIdentificacion().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
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
}
