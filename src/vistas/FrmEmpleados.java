/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;
import controladores.EmpleadoControlador;
import exepciones.StorageBoxException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.PuestoEmpleado;
/**
 *
 * @author matam
 */
public class FrmEmpleados extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmEmpleados.class.getName());
    private EmpleadoControlador controlador;
    private DefaultTableModel modeloTabla;
    /**
     * Creates new form FrmEmpleados
     */
    private void configurarTabla() {

    String[] columnas = {
        "Cédula",
        "Nombre",
        "Teléfono",
        "Puesto",
        "Salario"
    };

    modeloTabla = new DefaultTableModel(columnas, 0) {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    tblEmpleados.setModel(modeloTabla);
    }
    public FrmEmpleados() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public FrmEmpleados(
        EmpleadoControlador controlador) {
        initComponents();
        this.controlador = controlador;configurarTabla();cargarTablaEmpleados();actualizarSalario();
        txtSalario.setEditable(false);
        setLocationRelativeTo(null);
    }
    
    private void cargarTablaEmpleados() {

    modeloTabla.setRowCount(0);
    for (Empleado empleado :
            controlador.listarEmpleados()) {
        Object[] fila = {
            empleado.getIdentificacion(),
            empleado.getNombre(),
            empleado.getTelefono(),
            empleado.getPuesto(),
            empleado.getSalario()
        };

            modeloTabla.addRow(fila);
        }
    }
    private PuestoEmpleado obtenerPuesto() {
        String puesto = cbxPuesto.getSelectedItem().toString();

    if (puesto.equals("Administrador")) {

            return PuestoEmpleado.ADMINISTRADOR;

    } else if (puesto.equals("Recepcionista")) {

            return PuestoEmpleado.RECEPCIONISTA;

    } else if (puesto.equals("Encargado de bodega")) {

            return PuestoEmpleado.ENCARGADO_BODEGA;

    } else if (puesto.equals("Mantenimiento")) {

            return PuestoEmpleado.MANTENIMIENTO;

    } else {

            return PuestoEmpleado.OPERARIO_CARGA;
        }
    }
    private void actualizarSalario() {

    if (cbxPuesto.getSelectedItem() == null) {
        return;
    }

    PuestoEmpleado puesto =obtenerPuesto();
    txtSalario.setText(String.valueOf(puesto.getSalarioBase()));
    }
    private void limpiarFormulario() {

        txtCedula.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtBuscar.setText("");
        cbxPuesto.setSelectedIndex(0);
        cbxFiltroPuesto.setSelectedIndex(0);
        actualizarSalario();
        txtCedula.setEnabled(true);
        tblEmpleados.clearSelection();
        txtCedula.requestFocus();
    }
    private void buscarYFiltrar() {

        if (controlador == null|| modeloTabla == null) {

            return;
        }
        String texto =txtBuscar.getText().trim().toLowerCase();

        String filtro =cbxFiltroPuesto.getSelectedItem().toString();
        modeloTabla.setRowCount(0);

    for (Empleado empleado :
            controlador.listarEmpleados()) {

        boolean coincideBusqueda =
                texto.isEmpty() || empleado.getIdentificacion() .toLowerCase().contains(texto)
                || empleado.getNombre() .toLowerCase().contains(texto)
                || empleado.getTelefono().toLowerCase() .contains(texto);

        boolean coincidePuesto = false;

        if (filtro.equals("Todos")) {

            coincidePuesto = true;

        } else if (filtro.equals("Administrador") && empleado.getPuesto()== PuestoEmpleado.ADMINISTRADOR) {
            
            coincidePuesto = true;
            
        } else if (filtro.equals("Recepcionista")&& empleado.getPuesto() == PuestoEmpleado.RECEPCIONISTA) {

            coincidePuesto = true;

        } else if (filtro.equals("Encargado de bodega")&& empleado.getPuesto() == PuestoEmpleado.ENCARGADO_BODEGA) {

            coincidePuesto = true;

        } else if (filtro.equals("Mantenimiento") && empleado.getPuesto() == PuestoEmpleado.MANTENIMIENTO) {

            coincidePuesto = true;

        } else if (filtro.equals("Operario de carga") && empleado.getPuesto() == PuestoEmpleado.OPERARIO_CARGA) {

            coincidePuesto = true;
        }

        if (coincideBusqueda && coincidePuesto) {
            
            Object[] fila = {
                empleado.getIdentificacion(),
                empleado.getNombre(),
                empleado.getTelefono(),
                empleado.getPuesto(),
                empleado.getSalario()};
                modeloTabla.addRow(fila);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cbxPuesto = new javax.swing.JComboBox<>();
        txtSalario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxFiltroPuesto = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Cedula:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Telefono:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Puesto:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Salario:");

        txtCedula.addActionListener(this::txtCedulaActionPerformed);

        txtNombre.addActionListener(this::txtNombreActionPerformed);

        txtTelefono.addActionListener(this::txtTelefonoActionPerformed);

        cbxPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Recepcionista", "Encargado de bodega", "Mantenimiento", "Operario de carga" }));
        cbxPuesto.addActionListener(this::cbxPuestoActionPerformed);

        txtSalario.addActionListener(this::txtSalarioActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(cbxPuesto, 0, 1, Short.MAX_VALUE)
                            .addComponent(txtSalario))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar/Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Buscar:");

        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Filtrar Puesto:");

        cbxFiltroPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Administrador", "Recepcionista", "Encargado de bodega", "Mantenimiento", "Operario de carga" }));
        cbxFiltroPuesto.addActionListener(this::cbxFiltroPuestoActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxFiltroPuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(49, 49, 49)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxFiltroPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleados Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Teléfono", "Puesto", "Salario"
            }
        ));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(this::btnModificarActionPerformed);

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void cbxPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPuestoActionPerformed
        actualizarSalario();
    }//GEN-LAST:event_cbxPuestoActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        buscarYFiltrar();
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void cbxFiltroPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroPuestoActionPerformed
        if (controlador != null
            && modeloTabla != null) {
            buscarYFiltrar();
        }
    }//GEN-LAST:event_cbxFiltroPuestoActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int fila = tblEmpleados.getSelectedRow();

        if (fila != -1) {

        txtCedula.setText(modeloTabla.getValueAt(fila, 0).toString());
        txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
        txtTelefono.setText(modeloTabla.getValueAt(fila, 2).toString());

        String puesto = modeloTabla.getValueAt(fila, 3).toString();

        if (puesto.contains("ADMINISTRADOR")) {

            cbxPuesto.setSelectedItem("Administrador");

        } else if (puesto.contains("RECEPCIONISTA")) {

            cbxPuesto.setSelectedItem("Recepcionista");

        } else if (puesto.contains("ENCARGADO")) {

            cbxPuesto.setSelectedItem("Encargado de bodega");

        } else if (puesto.contains("MANTENIMIENTO")) {
            
            cbxPuesto.setSelectedItem("Mantenimiento");
 
            } else {
            
                cbxPuesto.setSelectedItem("Operario de carga");
            }
            actualizarSalario();
            txtCedula.setEnabled(false);
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String cedula =txtCedula.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono =txtTelefono.getText().trim();
        
        if (cedula.isEmpty()|| nombre.isEmpty()|| telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Debe completar todos los campos.");

            return;
        }

        if (!cedula.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "La cédula solo puede contener números.");

            return;
        }

        if (!telefono.matches("[0-9]+")) {

            JOptionPane.showMessageDialog(this, "El teléfono solo puede contener números.");

            return;
        }

        try {

            controlador.registrarEmpleado(cedula,nombre,telefono,obtenerPuesto());
            cargarTablaEmpleados();
            limpiarFormulario();

            JOptionPane.showMessageDialog(this,
                    "Empleado registrado correctamente.");

        } catch (StorageBoxException e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = tblEmpleados.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this,"Seleccione un empleado.");

            return;
        }

        String cedula = txtCedula.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        if (nombre.isEmpty() || telefono.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Debe completar los campos.");

            return;
        }

        if (!telefono.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "El teléfono solo puede contener números.");

            return;
        }

    try {
        controlador.modificarEmpleado(cedula,nombre,telefono,obtenerPuesto());
        cargarTablaEmpleados();
        limpiarFormulario();
        JOptionPane.showMessageDialog(this, "Empleado modificado correctamente.");

        } catch (StorageBoxException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblEmpleados.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this,"Seleccione un empleado.");

            return;
        }

        String cedula = txtCedula.getText().trim();
        int opcion = JOptionPane.showConfirmDialog(this,"¿Está seguro de eliminar este empleado?","Confirmar",JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {

            try {
                controlador.eliminarEmpleado(cedula);
                cargarTablaEmpleados();
                limpiarFormulario();
                JOptionPane.showMessageDialog(this, "Empleado eliminado correctamente.");

            } catch (StorageBoxException e) {

                JOptionPane.showMessageDialog(this,e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarFormulario();
        cargarTablaEmpleados();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmEmpleados().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbxFiltroPuesto;
    private javax.swing.JComboBox<String> cbxPuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
