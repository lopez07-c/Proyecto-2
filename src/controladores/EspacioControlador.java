/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import exepciones.StorageBoxException;
import java.util.ArrayList;
import java.util.List;
import modelo.Espacio;
import modelo.StorageBoxModelo;
import modelo.TipoEspacio;
/**
 *
 * @author matam
 */
public class EspacioControlador {

    private final StorageBoxModelo modelo;

    public EspacioControlador(StorageBoxModelo modelo) {
        this.modelo = modelo;
    }

    public void registrarEspacio(
            String numero,
            TipoEspacio tipo,
            double tamanio,
            double precio)
            throws StorageBoxException {

        if (numero == null || numero.trim().isEmpty()) {

            throw new StorageBoxException(
                    "El número de espacio es requerido."
            );
        }

        if (tipo == null) {

            throw new StorageBoxException(
                    "Debe seleccionar un tipo de espacio."
            );
        }

        if (tamanio <= 0) {

            throw new StorageBoxException(
                    "El tamaño debe ser mayor a 0."
            );
        }

        if (precio <= 0) {

            throw new StorageBoxException(
                    "El precio debe ser mayor a 0."
            );
        }

        if (modelo.getEspacios().existe(numero.trim())) {

            throw new StorageBoxException(
                    "El espacio número "
                    + numero
                    + " ya está registrado."
            );
        }

        Espacio espacio =
                new Espacio(numero.trim(), tipo);

        espacio.setTamanioM2(tamanio);
        espacio.setPrecioMensual(precio);

        modelo.getEspacios().registrar(
                numero.trim(),
                espacio
        );
    }

    public void modificarEspacio(
            String numero,
            TipoEspacio tipo,
            double tamanio,
            double precio)
            throws StorageBoxException {

        Espacio espacio = buscarEspacio(numero);

        if (espacio == null) {

            throw new StorageBoxException(
                    "El espacio no existe."
            );
        }

        if (tipo == null) {

            throw new StorageBoxException(
                    "Debe seleccionar un tipo de espacio."
            );
        }

        if (tamanio <= 0) {

            throw new StorageBoxException(
                    "El tamaño debe ser mayor a 0."
            );
        }

        if (precio <= 0) {

            throw new StorageBoxException(
                    "El precio debe ser mayor a 0."
            );
        }

        espacio.setTipo(tipo);
        espacio.setTamanioM2(tamanio);
        espacio.setPrecioMensual(precio);
    }

    public void eliminarEspacio(String numero)
            throws StorageBoxException {

        Espacio espacio = buscarEspacio(numero);

        if (espacio == null) {

            throw new StorageBoxException(
                    "El espacio no existe."
            );
        }

        if (espacio.isOcupado()) {

            throw new StorageBoxException(
                    "No se puede eliminar un espacio ocupado."
            );
        }

        modelo.getEspacios().remover(numero);
    }

    public Espacio buscarEspacio(String numero) {

        if (numero == null) {
            return null;
        }

        return modelo.getEspacios()
                .buscar(numero.trim());
    }

    public List<Espacio> listarEspacios() {

        return new ArrayList<>(
                modelo.getEspacios().obtenerTodos()
        );
    }

    public List<Espacio> filtrarEspacios(String filtro) {

        List<Espacio> resultado =
                new ArrayList<>();

        for (Espacio espacio :
                modelo.getEspacios().obtenerTodos()) {

            boolean mostrar = false;

            if (filtro == null
                    || filtro.equals("Todos")) {

                mostrar = true;

            } else if (filtro.equals("Pequeño")
                    && espacio.getTipo()
                    == TipoEspacio.PEQUENO) {

                mostrar = true;

            } else if (filtro.equals("Mediano")
                    && espacio.getTipo()
                    == TipoEspacio.MEDIANO) {

                mostrar = true;

            } else if (filtro.equals("Grande")
                    && espacio.getTipo()
                    == TipoEspacio.GRANDE) {

                mostrar = true;

            } else if (filtro.equals("Disponible")
                    && !espacio.isOcupado()) {

                mostrar = true;

            } else if (filtro.equals("Ocupado")
                    && espacio.isOcupado()) {

                mostrar = true;
            }

            if (mostrar) {
                resultado.add(espacio);
            }
        }

        return resultado;
    }
}