/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.packageadmin.packs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static menu.packageadmin.packs.packs1.btnActualizarPacks;
import static menu.packageadmin.packs.packs1.btnGuardarPacks;
import static menu.packageadmin.packs.packs1.cbxEstado;
import static menu.packageadmin.packs.packs1.txtCodigoPacks;
import static menu.packageadmin.packs.packs1.txtNombrePacks;


public class packs extends javax.swing.JPanel {
        packs1 packs1 =new packs1();

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

        public static void limpiarCajasPacks(){

        txtNombrePacks.setText(null);
        txtCodigoPacks.setText(null);
        

    }

     public static void ActualizarAutomaticamentePacks (){
        
               
        DefaultTableModel modelo = (DefaultTableModel) TablaPacks.getModel(); /*Tomar la tabla el modelo que ya estamos agregando*/
   /*se necesita para ocultar la id de la tabla, este dato se necesita para la modificacion*/
        modelo.setRowCount(0);/*Para que siempre que se ejecute reinicie las filas existentes*/ 
        
        PreparedStatement ps; /*Declarar unas variables para hacer las transacciones*/
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        
        
        int [] ancho = {30,80,60,0}; /*Arreglo con el ancho de las columnas*/
        for  (int i = 0; i< TablaPacks.getColumnCount(); i++){ /*consulta a la tabla el numero de columna que tiene*/
        TablaPacks.getColumnModel().getColumn(3).setMaxWidth(0);
        TablaPacks.getColumnModel().getColumn(3).setMinWidth(0);
        TablaPacks.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        TablaPacks.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
        TablaPacks.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]); 
        btnEditarPacks.setEnabled(false);
        }
        
             
        Connection con = null;
        try { 
            con = getConection();
            ps= con.prepareStatement ("SELECT nombre,codigo,estado,idpacks FROM packs");
       
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
    /**
     * Creates new form packs
     */
    public packs() {
        initComponents();    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEditarPacks = new javax.swing.JButton();
        btnNuevoPacks = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPacks = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtidRRSS = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(994, 521));

        btnEditarPacks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditarPacks.setText("Editar packs");
        btnEditarPacks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarPacksMouseClicked(evt);
            }
        });

        btnNuevoPacks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevoPacks.setText("Diseñar nuevo pack");
        btnNuevoPacks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoPacksMouseClicked(evt);
            }
        });
        btnNuevoPacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPacksActionPerformed(evt);
            }
        });

        TablaPacks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Packs", "Nombre Packs", "Precio", "Compuesto", "Stock Disponible", "Estado", "id_Packs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaPacks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPacksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaPacks);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Buscar");

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(102, 44));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Packs");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtidRRSS.setText("a");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevoPacks)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarPacks)
                        .addGap(142, 142, 142)
                        .addComponent(txtidRRSS, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditarPacks)
                        .addComponent(btnNuevoPacks)
                        .addComponent(txtidRRSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarPacksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarPacksMouseClicked
        packs1.setVisible(true);
        btnActualizarPacks.setEnabled(true);
        btnGuardarPacks.setEnabled(false);
    }//GEN-LAST:event_btnEditarPacksMouseClicked

    private void btnNuevoPacksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoPacksMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoPacksMouseClicked

    private void btnNuevoPacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPacksActionPerformed
        limpiarCajasPacks();
        packs1.setVisible(true);
        btnGuardarPacks.setEnabled(true);
        btnActualizarPacks.setEnabled(false);
    }//GEN-LAST:event_btnNuevoPacksActionPerformed

    private void TablaPacksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPacksMouseClicked

        int fila = TablaPacks.getSelectedRow();

        txtNombrePacks.setText(TablaPacks.getValueAt(fila, 0).toString());
        txtCodigoPacks.setText(TablaPacks.getValueAt(fila, 1).toString());
        cbxEstado.setSelectedItem(TablaPacks.getValueAt(fila, 2).toString());
        txtidRRSS.setText(TablaPacks.getModel().getValueAt(TablaPacks.getSelectedRow(),3).toString());
        btnEditarPacks.setEnabled(true);
    }//GEN-LAST:event_TablaPacksMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TablaPacks;
    public static javax.swing.JButton btnEditarPacks;
    public static javax.swing.JButton btnNuevoPacks;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField txtidRRSS;
    // End of variables declaration//GEN-END:variables
}
