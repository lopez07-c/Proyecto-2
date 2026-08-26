/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_2;

import controladores.StorageBoxControlador;
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
        StorageBoxControlador controlador = new StorageBoxControlador();
        FrmPrincipal principal = new FrmPrincipal(controlador);
        principal.setVisible(true);
    }
    
}
