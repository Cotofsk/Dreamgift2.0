/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.packageadmin.bancos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import menu.menu1;
import static menu.packageadmin.bancos.bancos1.btnActualizarBanco;
import static menu.packageadmin.bancos.bancos1.btnGuardarBanco;
import static menu.packageadmin.bancos.bancos1.cbxEstadoBanco;
import static menu.packageadmin.bancos.bancos1.txtCodigoBanco;
import static menu.packageadmin.bancos.bancos1.txtNombreBanco;


/**
 *
 * @author CotoF
 */
public class bancos extends javax.swing.JPanel {
    bancos1 bancos1=new bancos1();
    
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
        
        
        public static void ActualizarAutomaticamenteBanco (){
        
               
        DefaultTableModel modelo = (DefaultTableModel) TablaBanco.getModel(); /*Tomar la tabla el modelo que ya estamos agregando*/
        modelo.setRowCount(0);/*Para que siempre que se ejecute reinicie las filas existentes*/ 
        
        PreparedStatement ps; /*Declarar unas variables para hacer las transacciones*/
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        
        
        int [] ancho = {30,80,60,0}; /*Arreglo con el ancho de las columnas*/
        for  (int i = 0; i< TablaBanco.getColumnCount(); i++){ /*consulta a la tabla el numero de columna que tiene*/
        TablaBanco.getColumnModel().getColumn(3).setMaxWidth(0);
        TablaBanco.getColumnModel().getColumn(3).setMinWidth(0);
        TablaBanco.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        TablaBanco.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
        TablaBanco.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]); 
             
        }   
        
        Connection con = null;
        try { 
            con = getConection();
            ps= con.prepareStatement ("SELECT  codigo_banco,nom_banco,estado,id_banco FROM bancos");
       
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

        public static void limpiarCajasBanco(){

        txtNombreBanco.setText(null);
        txtCodigoBanco.setText(null);
        

    }                    
    /**
     * Creates new form bancos
     */
    public bancos() {
        initComponents();
        ActualizarAutomaticamenteBanco ();

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevoBanco = new javax.swing.JButton();
        btnEditarBanco = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtidBanco = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaBanco = new javax.swing.JTable();

        btnNuevoBanco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevoBanco.setText("Nuevo banco");
        btnNuevoBanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoBancoMouseClicked(evt);
            }
        });
        btnNuevoBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoBancoActionPerformed(evt);
            }
        });

        btnEditarBanco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditarBanco.setText("Editar");
        btnEditarBanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarBancoMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(102, 44));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bancos");

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

        txtidBanco.setText("jTextField2");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Buscar");

        TablaBanco.setModel(new javax.swing.table.DefaultTableModel(
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
                "Nombre ", "Codigo", "Estado", "Id_comuna"
            }
        ));
        TablaBanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaBancoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaBanco);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevoBanco)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarBanco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtidBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(257, 257, 257)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoBanco)
                    .addComponent(btnEditarBanco)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtidBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoBancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoBancoMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoBancoMouseClicked

    private void btnNuevoBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoBancoActionPerformed
        limpiarCajasBanco();
        bancos1.setVisible(true);
        btnGuardarBanco.setEnabled(true);
        btnActualizarBanco.setEnabled(false);
    }//GEN-LAST:event_btnNuevoBancoActionPerformed

    private void btnEditarBancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarBancoMouseClicked
        bancos1.setVisible(true);
        btnActualizarBanco.setEnabled(true);
        btnGuardarBanco.setEnabled(false);
    }//GEN-LAST:event_btnEditarBancoMouseClicked

    private void TablaBancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaBancoMouseClicked

        int fila = TablaBanco.getSelectedRow();

        txtNombreBanco.setText(TablaBanco.getValueAt(fila, 0).toString());
        txtCodigoBanco.setText(TablaBanco.getValueAt(fila, 1).toString());
        cbxEstadoBanco.setSelectedItem(TablaBanco.getValueAt(fila, 2).toString());
        txtidBanco.setText(TablaBanco.getModel().getValueAt(TablaBanco.getSelectedRow(),3).toString());
        btnEditarBanco.setEnabled(true);
    }//GEN-LAST:event_TablaBancoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TablaBanco;
    public static javax.swing.JButton btnEditarBanco;
    public static javax.swing.JButton btnNuevoBanco;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField txtidBanco;
    // End of variables declaration//GEN-END:variables
}
