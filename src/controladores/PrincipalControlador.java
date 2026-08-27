/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import vistas.FrmClientes;
import vistas.FrmContratos;
import vistas.FrmEmpleados;
import vistas.FrmEspacios;
import vistas.FrmServicios;
/**
 *
 * @author matam
 */
public class PrincipalControlador {

    private final ClienteControlador clienteControlador;
    private final EspacioControlador espacioControlador;
    private final ContratoControlador contratoControlador;
    private final ServicioControlador servicioControlador;
    private final EmpleadoControlador empleadoControlador;

    public PrincipalControlador(
            ClienteControlador clienteControlador,
            EspacioControlador espacioControlador,
            ContratoControlador contratoControlador,
            ServicioControlador servicioControlador,
            EmpleadoControlador empleadoControlador) {

        this.clienteControlador = clienteControlador;

        this.espacioControlador = espacioControlador;

        this.contratoControlador = contratoControlador;

        this.servicioControlador =servicioControlador;

        this.empleadoControlador =empleadoControlador;
    }

    public void abrirClientes() {

        FrmClientes ventana = new FrmClientes(clienteControlador );

        ventana.setVisible(true);
    }

    public void abrirEspacios() {

        FrmEspacios ventana = new FrmEspacios(espacioControlador );

        ventana.setVisible(true);
    }

    public void abrirContratos() {

        FrmContratos ventana =new FrmContratos(contratoControlador);

        ventana.setVisible(true);
    }

    public void abrirServicios() {

        FrmServicios ventana =  new FrmServicios(servicioControlador );

        ventana.setVisible(true);
    }

    public void abrirEmpleados() {

        FrmEmpleados ventana = new FrmEmpleados( empleadoControlador);

        ventana.setVisible(true);
    }
}