
package menu.packageadmin.proveedores;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static menu.packageadmin.proveedores.proveedor1.cbxEstado;
import static menu.packageadmin.proveedores.proveedor1.txtDireccion;
import static menu.packageadmin.proveedores.proveedor1.txtEmail;
import static menu.packageadmin.proveedores.proveedor1.txtRazonSocial;
import static menu.packageadmin.proveedores.proveedor1.txtRepresentante;
import static menu.packageadmin.proveedores.proveedor1.txtRutEmpresa;
import static menu.packageadmin.proveedores.proveedor1.txtTelefono;
import static menu.packageadmin.proveedores.proveedor1.btnGuardarProv;
import static menu.packageadmin.proveedores.proveedor1.btnActualizarProv;


public class proveedores extends javax.swing.JPanel {
    proveedor1 vp =new proveedor1();
    
    
 
    
    public static final String URL = "jdbc:mysql://localhost:3306/dreamgifts"; //Direccion, puerto y nombre de la Base de Datos
    public static final String USERNAME = "root"; //Usuario de Acceso a MySQL
    public static final String PASSWORD = ""; //Password del usuario
    
    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConection() {
        Connection con = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
           // JOptionPane.showMessageDialog(null, "Conexion exitosa");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
}
   
    public static void limpiarCajasProv(){

        txtBuscarProv.setText(null);
        txtRutEmpresa.setText(null);
        txtRazonSocial.setText(null);
        txtRepresentante.setText(null);
        txtDireccion.setText(null);
        txtEmail.setText(null);
        txtidProveedor.setText(null);
        txtTelefono.setText(null);

    }
    
    public static void ActualizarAutomaticamenteProv (){
        
               
        DefaultTableModel modelo = (DefaultTableModel) TablaProveedores.getModel(); /*Tomar la tabla el modelo que ya estamos agregando*/
   /*se necesita para ocultar la id de la tabla, este dato se necesita para la modificacion*/
        modelo.setRowCount(0);/*Para que siempre que se ejecute reinicie las filas existentes*/ 
        
        PreparedStatement ps; /*Declarar unas variables para hacer las transacciones*/
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        
        
        int [] ancho = {30,80,60,7,90,90,25,0}; /*Arreglo con el ancho de las columnas*/
        for  (int i = 0; i< TablaProveedores.getColumnCount(); i++){ /*consulta a la tabla el numero de columna que tiene*/
        TablaProveedores.getColumnModel().getColumn(7).setMaxWidth(0);
        TablaProveedores.getColumnModel().getColumn(7).setMinWidth(0);
        TablaProveedores.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        TablaProveedores.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
         TablaProveedores.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]); //
         btnEditarProv.setEnabled(false);
        
             
        }   
        
        Connection con = null;
        try { 
            con = getConection();
            ps= con.prepareStatement ("SELECT rut_proveedor,razon_social,representante,fono,direccion,email,estado_pro,id_proveedor FROM proveedores");
       
            rs= ps.executeQuery();
            rsmd = rs.getMetaData ();
            columnas = rsmd.getColumnCount(); /*Cuantas Columnas trae esta consulta*/
            
            
            while(rs.next()){ /*Extraer todo los datos de la consulta*/
               Object[] filas = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);

            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
   
    
    public proveedores() {
        initComponents();
        ActualizarAutomaticamenteProv ();
      
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevoProv = new javax.swing.JButton();
        btnEditarProv = new javax.swing.JButton();
        txtBuscarProv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProveedores = new javax.swing.JTable();
        txtidProveedor = new javax.swing.JTextField();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(994, 512));

        btnNuevoProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevoProv.setText("Nuevo Proveedor");
        btnNuevoProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoProvMouseClicked(evt);
            }
        });
        btnNuevoProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProvActionPerformed(evt);
            }
        });

        btnEditarProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditarProv.setText("Editar");
        btnEditarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProvActionPerformed(evt);
            }
        });

        txtBuscarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProvActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Buscar");

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(102, 44));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Proveedores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(251, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Proveedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N

        TablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Rut", "Razon Social", "Representante", "Telefono", "Dirección", "Email", "Estado", "id_proveedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProveedores);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        txtidProveedor.setText("a");
        txtidProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevoProv)
                .addGap(18, 18, 18)
                .addComponent(btnEditarProv)
                .addGap(304, 304, 304)
                .addComponent(txtidProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditarProv)
                        .addComponent(btnNuevoProv)
                        .addComponent(txtidProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoProvMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoProvMouseClicked

    private void btnNuevoProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProvActionPerformed
        limpiarCajasProv();
        vp.setVisible(true);
        btnGuardarProv.setEnabled(true);
        btnActualizarProv.setEnabled(false);
    }//GEN-LAST:event_btnNuevoProvActionPerformed

    private void txtBuscarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProvActionPerformed

    private void TablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProveedoresMouseClicked
        
 
            
        int fila = TablaProveedores.getSelectedRow();
        
        
        
        txtRutEmpresa.setText(TablaProveedores.getValueAt(fila, 0).toString());    
        txtRazonSocial.setText(TablaProveedores.getValueAt(fila, 1).toString()); 
        txtRepresentante.setText(TablaProveedores.getValueAt(fila, 2).toString());       
        txtTelefono.setText(TablaProveedores.getValueAt(fila, 3).toString());     
        txtDireccion.setText(TablaProveedores.getValueAt(fila, 4).toString());
        txtEmail.setText(TablaProveedores.getValueAt(fila, 5).toString());
        cbxEstado.setSelectedItem(TablaProveedores.getValueAt(fila, 6).toString());     
        txtidProveedor.setText(TablaProveedores.getModel().getValueAt(TablaProveedores.getSelectedRow(),7).toString());
        btnEditarProv.setEnabled(true);
        
        


    }//GEN-LAST:event_TablaProveedoresMouseClicked

    private void btnEditarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProvActionPerformed
        vp.setVisible(true);
        btnActualizarProv.setEnabled(true);
        btnGuardarProv.setEnabled(false);
    }//GEN-LAST:event_btnEditarProvActionPerformed

    private void txtidProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TablaProveedores;
    public static javax.swing.JButton btnEditarProv;
    private javax.swing.JButton btnNuevoProv;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField txtBuscarProv;
    public static javax.swing.JTextField txtidProveedor;
    // End of variables declaration//GEN-END:variables
}
