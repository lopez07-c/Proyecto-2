/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import estructuras.ColaContratos;
import estructuras.ListaClientes;
import estructuras.MapaEspacios;
import java.util.ArrayList;
/**
 *
 * @author matam
 */
public class StorageBoxModelo {

    private ListaClientes<Cliente> clientes;
    private MapaEspacios<String, Espacio> espacios;
    private ColaContratos<Contrato> contratosPendientes;
    private ArrayList<Contrato> contratos;
    private ArrayList<ServicioAdicional> servicios;
    private ArrayList<Empleado> empleados;

    public StorageBoxModelo() {

        clientes = new ListaClientes<>();
        espacios = new MapaEspacios<>();
        contratosPendientes = new ColaContratos<>();

        contratos = new ArrayList<>();
        servicios = new ArrayList<>();
        empleados = new ArrayList<>();
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

    public ArrayList<ServicioAdicional> getServicios() {
        return servicios;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
}
