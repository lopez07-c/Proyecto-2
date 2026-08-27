/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_2;

import controladores.ClienteControlador;
import controladores.ContratoControlador;
import controladores.EmpleadoControlador;
import controladores.EspacioControlador;
import controladores.PrincipalControlador;
import controladores.ServicioControlador;
import modelo.StorageBoxModelo;
import vistas.FrmPrincipal;

/**
 *
 * @author UTN
 */
public class Proyecto_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StorageBoxModelo modelo = new StorageBoxModelo();

        ClienteControlador clienteControlador = new ClienteControlador(modelo);

        EspacioControlador espacioControlador = new EspacioControlador(modelo);

        ContratoControlador contratoControlador = new ContratoControlador(modelo);

        ServicioControlador servicioControlador = new ServicioControlador(modelo);

        EmpleadoControlador empleadoControlador = new EmpleadoControlador(modelo);

        PrincipalControlador principalControlador = new PrincipalControlador(
                        clienteControlador,
                        espacioControlador,
                        contratoControlador,
                        servicioControlador,
                        empleadoControlador
                );

        FrmPrincipal principal = new FrmPrincipal(principalControlador);

        principal.setVisible(true);
    }
    
}
