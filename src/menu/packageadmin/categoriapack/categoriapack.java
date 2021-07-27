/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.packageadmin.categoriapack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static menu.packageadmin.categoriapack.categoriapack1.btnActualizarCatPacks;
import static menu.packageadmin.categoriapack.categoriapack1.btnGuardarCatPacks;
import static menu.packageadmin.categoriapack.categoriapack1.cbxEstadoCatPacks;
import static menu.packageadmin.categoriapack.categoriapack1.txtCodigoCatPacks;
import static menu.packageadmin.categoriapack.categoriapack1.txtNombreCatPacks;

/**
 *
 * @author Usuario
 */
public class categoriapack extends javax.swing.JPanel {
        categoriapack1 categoriapack1 =new categoriapack1();
    
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
    
            public static void limpiarCajasCatPacks(){

        txtNombreCatPacks.setText(null);
        txtCodigoCatPacks.setText(null);
        

    }

        public static void ActualizarAutomaticamenteCatPacks (){
        
               
        DefaultTableModel modelo = (DefaultTableModel) TablaCatPacks.getModel(); /*Tomar la tabla el modelo que ya estamos agregando*/
   /*se necesita para ocultar la id de la tabla, este dato se necesita para la modificacion*/
        modelo.setRowCount(0);/*Para que siempre que se ejecute reinicie las filas existentes*/ 
        
        PreparedStatement ps; /*Declarar unas variables para hacer las transacciones*/
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        
        
        int [] ancho = {30,80,60,0}; /*Arreglo con el ancho de las columnas*/
        for  (int i = 0; i< TablaCatPacks.getColumnCount(); i++){ /*consulta a la tabla el numero de columna que tiene*/
        TablaCatPacks.getColumnModel().getColumn(3).setMaxWidth(0);
        TablaCatPacks.getColumnModel().getColumn(3).setMinWidth(0);
        TablaCatPacks.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        TablaCatPacks.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
        TablaCatPacks.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]); 
        btnEditarCatPacks.setEnabled(false);
        
             
        }   
        
        Connection con = null;
        try { 
            con = getConection();
            ps= con.prepareStatement ("SELECT catarticulo,codigo,estado,id_categoria FROM categorias");
       
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
     * Creates new form categoriapack
     */
    public categoriapack() {
        initComponents();
        ActualizarAutomaticamenteCatPacks();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCatPacks = new javax.swing.JTable();
        txtidCatPacks = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnEditarCatPacks = new javax.swing.JButton();
        btnNuevoCatPacks = new javax.swing.JButton();

        TablaCatPacks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Categoria de articulo ", "Codigo", "Estado", "Id_CatPacks"
            }
        ));
        TablaCatPacks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCatPacksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCatPacks);

        txtidCatPacks.setText("jTextField2");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Buscar");

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(102, 44));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Categoria de packs");

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

        btnEditarCatPacks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditarCatPacks.setText("Editar");
        btnEditarCatPacks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarCatPacksMouseClicked(evt);
            }
        });

        btnNuevoCatPacks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevoCatPacks.setText("Nueva categoria");
        btnNuevoCatPacks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoCatPacksMouseClicked(evt);
            }
        });
        btnNuevoCatPacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCatPacksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevoCatPacks)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarCatPacks)
                        .addGap(204, 204, 204)
                        .addComponent(txtidCatPacks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarCatPacks)
                    .addComponent(btnNuevoCatPacks)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtidCatPacks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TablaCatPacksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCatPacksMouseClicked

        int fila = TablaCatPacks.getSelectedRow();

        txtNombreCatPacks.setText(TablaCatPacks.getValueAt(fila, 0).toString());
        txtCodigoCatPacks.setText(TablaCatPacks.getValueAt(fila, 1).toString());
        cbxEstadoCatPacks.setSelectedItem(TablaCatPacks.getValueAt(fila, 2).toString());
        txtidCatPacks.setText(TablaCatPacks.getModel().getValueAt(TablaCatPacks.getSelectedRow(),3).toString());
        btnEditarCatPacks.setEnabled(true);
    }//GEN-LAST:event_TablaCatPacksMouseClicked

    private void btnEditarCatPacksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarCatPacksMouseClicked
        categoriapack1.setVisible(true);
        btnActualizarCatPacks.setEnabled(true);
        btnGuardarCatPacks.setEnabled(false);
    }//GEN-LAST:event_btnEditarCatPacksMouseClicked

    private void btnNuevoCatPacksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoCatPacksMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoCatPacksMouseClicked

    private void btnNuevoCatPacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCatPacksActionPerformed
        limpiarCajasCatPacks();
        categoriapack1.setVisible(true);
        btnGuardarCatPacks.setEnabled(true);
        btnActualizarCatPacks.setEnabled(false);
    }//GEN-LAST:event_btnNuevoCatPacksActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TablaCatPacks;
    public static javax.swing.JButton btnEditarCatPacks;
    public static javax.swing.JButton btnNuevoCatPacks;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField txtidCatPacks;
    // End of variables declaration//GEN-END:variables
}
