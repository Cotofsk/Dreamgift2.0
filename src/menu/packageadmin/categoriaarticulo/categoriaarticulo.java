/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.packageadmin.categoriaarticulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static menu.packageadmin.categoriaarticulo.categoriaarticulo1.btnActualizarCatArticulo;
import static menu.packageadmin.categoriaarticulo.categoriaarticulo1.btnGuardarCatArticulo;
import static menu.packageadmin.categoriaarticulo.categoriaarticulo1.cbxEstadoCatArticulo;
import static menu.packageadmin.categoriaarticulo.categoriaarticulo1.txtCodigoCatArticulo;
import static menu.packageadmin.categoriaarticulo.categoriaarticulo1.txtNombreCatArticulo;

/**
 *
 * @author Usuario
 */
public class categoriaarticulo extends javax.swing.JPanel {
    categoriaarticulo1 categoriaarticulo1 =new categoriaarticulo1();

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

        public static void limpiarCajasCatArticulo(){

        txtNombreCatArticulo.setText(null);
        txtCodigoCatArticulo.setText(null);
        

    }

        public static void ActualizarAutomaticamenteCatArticulo (){
        
               
        DefaultTableModel modelo = (DefaultTableModel) TablaCatArticulo.getModel(); /*Tomar la tabla el modelo que ya estamos agregando*/
   /*se necesita para ocultar la id de la tabla, este dato se necesita para la modificacion*/
        modelo.setRowCount(0);/*Para que siempre que se ejecute reinicie las filas existentes*/ 
        
        PreparedStatement ps; /*Declarar unas variables para hacer las transacciones*/
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        
        
        int [] ancho = {30,80,60,0}; /*Arreglo con el ancho de las columnas*/
        for  (int i = 0; i< TablaCatArticulo.getColumnCount(); i++){ /*consulta a la tabla el numero de columna que tiene*/
        TablaCatArticulo.getColumnModel().getColumn(3).setMaxWidth(0);
        TablaCatArticulo.getColumnModel().getColumn(3).setMinWidth(0);
        TablaCatArticulo.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        TablaCatArticulo.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
        TablaCatArticulo.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]); 
        btnEditarCatArticulo.setEnabled(false);
        
             
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
     * Creates new form categoriaarticulo
     */
    public categoriaarticulo() {
        initComponents();
        ActualizarAutomaticamenteCatArticulo();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevoCatArticulo = new javax.swing.JButton();
        btnEditarCatArticulo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCatArticulo = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtidCatArticulo = new javax.swing.JTextField();

        btnNuevoCatArticulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevoCatArticulo.setText("Nueva categoria");
        btnNuevoCatArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoCatArticuloMouseClicked(evt);
            }
        });
        btnNuevoCatArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCatArticuloActionPerformed(evt);
            }
        });

        btnEditarCatArticulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditarCatArticulo.setText("Editar");
        btnEditarCatArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarCatArticuloMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(102, 44));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Categoria articulos");

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

        TablaCatArticulo.setModel(new javax.swing.table.DefaultTableModel(
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
                "Categoria de articulo ", "Codigo", "Estado", "Id_CatArticulo"
            }
        ));
        TablaCatArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCatArticuloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCatArticulo);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Buscar");

        txtidCatArticulo.setText("jTextField2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevoCatArticulo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarCatArticulo)
                        .addGap(263, 263, 263)
                        .addComponent(txtidCatArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btnEditarCatArticulo)
                    .addComponent(btnNuevoCatArticulo)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtidCatArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoCatArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoCatArticuloMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoCatArticuloMouseClicked

    private void btnNuevoCatArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCatArticuloActionPerformed
        limpiarCajasCatArticulo();
        categoriaarticulo1.setVisible(true);
        btnGuardarCatArticulo.setEnabled(true);
        btnActualizarCatArticulo.setEnabled(false);
    }//GEN-LAST:event_btnNuevoCatArticuloActionPerformed

    private void btnEditarCatArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarCatArticuloMouseClicked
        categoriaarticulo1.setVisible(true);
        btnActualizarCatArticulo.setEnabled(true);
        btnGuardarCatArticulo.setEnabled(false);
    }//GEN-LAST:event_btnEditarCatArticuloMouseClicked

    private void TablaCatArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCatArticuloMouseClicked

        int fila = TablaCatArticulo.getSelectedRow();

        txtNombreCatArticulo.setText(TablaCatArticulo.getValueAt(fila, 0).toString());
        txtCodigoCatArticulo.setText(TablaCatArticulo.getValueAt(fila, 1).toString());
        cbxEstadoCatArticulo.setSelectedItem(TablaCatArticulo.getValueAt(fila, 2).toString());
        txtidCatArticulo.setText(TablaCatArticulo.getModel().getValueAt(TablaCatArticulo.getSelectedRow(),3).toString());
        btnEditarCatArticulo.setEnabled(true);
    }//GEN-LAST:event_TablaCatArticuloMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TablaCatArticulo;
    public static javax.swing.JButton btnEditarCatArticulo;
    public static javax.swing.JButton btnNuevoCatArticulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField txtidCatArticulo;
    // End of variables declaration//GEN-END:variables
}
