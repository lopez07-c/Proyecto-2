/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import exepciones.StorageBoxException;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;
import modelo.PuestoEmpleado;
import modelo.StorageBoxModelo;
/**
 *
 * @author matam
 */
public class EmpleadoControlador {

    private final StorageBoxModelo modelo;

    public EmpleadoControlador(StorageBoxModelo modelo) {
        this.modelo = modelo;
    }

    public Empleado registrarEmpleado(String identificacion,String nombre,String telefono,PuestoEmpleado puesto)
            throws StorageBoxException {

        if (identificacion == null|| identificacion.trim().isEmpty()) {

            throw new StorageBoxException("La identificación es requerida");
        }

        if (nombre == null|| nombre.trim().isEmpty()) {

            throw new StorageBoxException( "El nombre es requerido");
        }

        if (telefono == null|| telefono.trim().isEmpty()) {

            throw new StorageBoxException("El teléfono es requerido");
        }

        if (puesto == null) {

            throw new StorageBoxException("Debe seleccionar un puesto");
        }

        if (buscarEmpleado(identificacion) != null) {

            throw new StorageBoxException("Ya existe un empleado con esa identificación"
            );
        }

        Empleado empleado =new Empleado( identificacion.trim(),nombre.trim(),telefono.trim(),puesto);
        modelo.getEmpleados().add(empleado);

        return empleado;
    }

    public void modificarEmpleado(String identificacion,String nombre, String telefono,PuestoEmpleado puesto)
            throws StorageBoxException {

        Empleado empleado =buscarEmpleado(identificacion);

        if (empleado == null) {

            throw new StorageBoxException("El empleado no existe");
        }

        if (nombre == null|| nombre.trim().isEmpty()) {

            throw new StorageBoxException("El nombre es requerido");
        }

        if (telefono == null|| telefono.trim().isEmpty()) {

            throw new StorageBoxException("El teléfono es requerido");
        }

        if (puesto == null) {

            throw new StorageBoxException( "Debe seleccionar un puesto");
        }

        empleado.setNombre(nombre.trim());
        empleado.setTelefono(telefono.trim());
        empleado.setPuesto(puesto);
    }

    public void eliminarEmpleado(String identificacion)throws StorageBoxException {

        Empleado empleado = buscarEmpleado(identificacion);

        if (empleado == null) {

            throw new StorageBoxException("El empleado no existe");
        }

        modelo.getEmpleados().remove(empleado);
    }

    public Empleado buscarEmpleado(String identificacion) {

        if (identificacion == null) {
            return null;
        }

        for (Empleado empleado : modelo.getEmpleados()) {

            if (empleado.getIdentificacion() .equalsIgnoreCase(identificacion.trim())) {

                return empleado;
            }
        }

        return null;
    }

    public List<Empleado> listarEmpleados() {

        return new ArrayList<>(
                modelo.getEmpleados()
        );
    }

    public List<Empleado> filtrarEmpleados(
            String texto) {

        List<Empleado> resultado =
                new ArrayList<>();

        if (texto == null) {
            texto = "";
        }

        String criterio =
                texto.trim().toLowerCase();

        for (Empleado empleado : modelo.getEmpleados()) {

            if (criterio.isEmpty()|| empleado.getIdentificacion().toLowerCase()
                            .contains(criterio) || empleado.getNombre().toLowerCase().contains(criterio)
                    || empleado.getTelefono().toLowerCase().contains(criterio)
                    || empleado.getPuesto().toString().toLowerCase().contains(criterio)) {

                resultado.add(empleado);
            }
        }

        return resultado;
    }
}