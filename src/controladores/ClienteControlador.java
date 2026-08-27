/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import exepciones.StorageBoxException;
import java.util.List;
import modelo.Cliente;
import modelo.Contrato;
import modelo.EstadoContrato;
import modelo.StorageBoxModelo;
/**
 *
 * @author matam
 */
public class ClienteControlador {

    private final StorageBoxModelo modelo;

    public ClienteControlador(StorageBoxModelo modelo) {
        this.modelo = modelo;
    }

    public void registrarCliente(Cliente cliente)
            throws StorageBoxException {

        if (cliente == null) {
            throw new StorageBoxException(
                    "Los datos del cliente no pueden estar vacíos"
            );
        }

        if (cliente.getIdentificacion() == null
                || cliente.getIdentificacion().trim().isEmpty()) {

            throw new StorageBoxException(
                    "La identificación es requerida"
            );
        }

        if (buscarCliente(cliente.getIdentificacion()) != null) {

            throw new StorageBoxException(
                    "Ya existe un cliente con esa identificación"
            );
        }

        modelo.getClientes().agregar(cliente);
    }

    public void modificarCliente(
            String identificacion,
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

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new StorageBoxException(
                    "El nombre es requerido"
            );
        }

        if (telefono == null || telefono.trim().isEmpty()) {
            throw new StorageBoxException(
                    "El teléfono es requerido."
            );
        }

        if (correo == null || correo.trim().isEmpty()) {
            throw new StorageBoxException(
                    "El correo es requerido"
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

        for (Contrato contrato : modelo.getContratos()) {

            if (contrato.getCliente().getIdentificacion()
                    .equalsIgnoreCase(identificacion)) {

                if (contrato.getEstado() == EstadoContrato.PENDIENTE|| contrato.getEstado() == EstadoContrato.ACTIVO) {

                    throw new StorageBoxException(
                            "No se puede eliminar el cliente porque tiene un contrato pendiente o activo"
                    );
                }
            }
        }

        modelo.getClientes().eliminar(cliente);
    }

    public Cliente buscarCliente(String identificacion) {

        if (identificacion == null) {
            return null;
        }

        for (Cliente cliente : modelo.getClientes().aLista()) {

            if (cliente.getIdentificacion()
                    .equalsIgnoreCase(identificacion.trim())) {

                return cliente;
            }
        }

        return null;
    }

    public List<Cliente> listarClientes() {
        return modelo.getClientes().aLista();
    }
}
