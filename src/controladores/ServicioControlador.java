/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import exepciones.StorageBoxException;
import java.util.ArrayList;
import java.util.List;
import modelo.ServicioAdicional;
import modelo.StorageBoxModelo;
/**
 *
 * @author matam
 */
public class ServicioControlador {

    private final StorageBoxModelo modelo;

    public ServicioControlador(StorageBoxModelo modelo) {
        this.modelo = modelo;
    }

    public ServicioAdicional registrarServicio(
            String nombre,
            String descripcion,
            double precio)
            throws StorageBoxException {

        if (nombre == null || nombre.trim().isEmpty()) {

            throw new StorageBoxException(
                    "El nombre del servicio es requerido."
            );
        }

        if (descripcion == null
                || descripcion.trim().isEmpty()) {

            throw new StorageBoxException(
                    "La descripción es requerida."
            );
        }

        if (precio <= 0) {

            throw new StorageBoxException(
                    "El precio debe ser mayor a 0."
            );
        }

        ServicioAdicional servicio =
                new ServicioAdicional(
                        nombre.trim(),
                        descripcion.trim(),
                        precio
                );

        modelo.getServicios().add(servicio);

        return servicio;
    }

    public void modificarServicio(
            String codigo,
            String descripcion,
            double precio)
            throws StorageBoxException {

        ServicioAdicional servicio =
                buscarServicio(codigo);

        if (servicio == null) {

            throw new StorageBoxException(
                    "El servicio no existe."
            );
        }

        if (descripcion == null
                || descripcion.trim().isEmpty()) {

            throw new StorageBoxException(
                    "La descripción es requerida."
            );
        }

        if (precio <= 0) {

            throw new StorageBoxException(
                    "El precio debe ser mayor a 0."
            );
        }

        servicio.setDescripcion(
                descripcion.trim()
        );

        servicio.setPrecio(precio);
    }

    public void eliminarServicio(String codigo)
            throws StorageBoxException {

        ServicioAdicional servicio =
                buscarServicio(codigo);

        if (servicio == null) {

            throw new StorageBoxException(
                    "El servicio no existe."
            );
        }

        modelo.getServicios().remove(servicio);
    }

    public ServicioAdicional buscarServicio(
            String codigo) {

        if (codigo == null) {
            return null;
        }

        for (ServicioAdicional servicio :
                modelo.getServicios()) {

            if (servicio.getCodigo()
                    .equalsIgnoreCase(
                            codigo.trim())) {

                return servicio;
            }
        }

        return null;
    }

    public List<ServicioAdicional> listarServicios() {

        return new ArrayList<>(
                modelo.getServicios()
        );
    }

    public List<ServicioAdicional> filtrarServicios(
            String texto) {

        List<ServicioAdicional> resultado =
                new ArrayList<>();

        if (texto == null) {
            texto = "";
        }

        String criterio =
                texto.trim().toLowerCase();

        for (ServicioAdicional servicio :
                modelo.getServicios()) {

            if (criterio.isEmpty() || servicio.getCodigo().toLowerCase().contains(criterio)
                    || servicio.getNombre().toLowerCase().contains(criterio)
                    || servicio.getDescripcion() .toLowerCase() .contains(criterio)) {

                resultado.add(servicio);
            }
        }

        return resultado;
    }
}