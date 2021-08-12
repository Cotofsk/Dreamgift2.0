package menu.packageadmin.articulos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static menu.packageadmin.articulos.articulos1.btnActualizar;
import static menu.packageadmin.articulos.articulos1.btnGuardar;
import static menu.packageadmin.articulos.articulos.TablaArticulos;
import static menu.packageadmin.articulos.articulos1.Llenarcbxcategorias;
import static menu.packageadmin.articulos.articulos1.txtArticulo;
import static menu.packageadmin.articulos.articulos1.txtCodigo;
import static menu.packageadmin.articulos.articulos1.cbxCategoriaArt;
import static menu.packageadmin.articulos.articulos1.cbxEstadoArt;
import menu.packegemetodo.arti;
/**
 *
 * @author bsepu
 */
public class articulos extends javax.swing.JPanel {
articulos1 art =new articulos1();


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
   
    public static void limpiarCajas(){

    txtBuscar.setText(null);

    }
    
    
    public arti BuscarId(int id){
        arti ar = new arti();
        String sql = "SELECT pr.id AS id_proveedor, pr.nombre AS nombre_proveedor, p.* FROM proveedor pr INNER JOIN productos p ON p.proveedor = pr.id WHERE p.id = ?";
         Connection con = null;
         try {
            con = getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ar.setId(rs.getInt("id_articulo"));
                ar.setCodigo(rs.getString("codigo_articulo"));
                ar.setNombre(rs.getString("nombre"));
                ar.setCategoria(rs.getInt("categorias_id_categoria "));           
                ar.setStock(rs.getInt("stock_articulo"));
                ar.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ar;
    }
    
    
    
    
    
    
    
    
    public static void ActualizarAutomaticamenteArt (){
        
        Llenarcbxcategorias();       
        DefaultTableModel modelo = (DefaultTableModel) TablaArticulos.getModel(); /*Tomar la tabla el modelo que ya estamos agregando*/
        modelo.setRowCount(0);/*Para que siempre que se ejecute reinicie las filas existentes*/ 
        
        PreparedStatement ps; /*Declarar unas variables para hacer las transacciones*/
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        
        
        int [] ancho = {30,80,20,60}; /*Arreglo con el ancho de las columnas*/
        for  (int i = 0; i< TablaArticulos.getColumnCount(); i++){ /*consulta a la tabla el numero de columna que tiene*/
        TablaArticulos.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]); 
             
        }   
        
        Connection con = null;
        try { 
            con = getConection();
            ps= con.prepareStatement ("SELECT articulos.nombre,articulos.nombre,categorias.catarticulo,articulos.estado FROM articulos \n" +
"INNER JOIN categorias on articulos.categorias_id_categoria=categorias.id_categoria");
       
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
    
    public articulos() {
        initComponents();
        ActualizarAutomaticamenteArt ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaArticulos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        btnNuevo = new javax.swing.JButton();

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Buscar");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabla Articulos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(994, 9));

        TablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
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
                "Nombre Articulo", "Codigo", "Categoria", "Estado"
            }
        ));
        TablaArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaArticulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaArticulos);
        if (TablaArticulos.getColumnModel().getColumnCount() > 0) {
            TablaArticulos.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
        );

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setText("Modificar Articulo");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        label1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Articulos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevo.setText("Nuevo Articulo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnNuevo))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TablaArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaArticulosMouseClicked
        int fila = TablaArticulos.getSelectedRow();
        
        txtArticulo.setText(TablaArticulos.getValueAt(fila, 0).toString());    
        txtCodigo.setText(TablaArticulos.getValueAt(fila, 1).toString());
        cbxCategoriaArt.setSelectedItem(TablaArticulos.getValueAt(fila, 2).toString()); 
        cbxEstadoArt.setSelectedItem(TablaArticulos.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_TablaArticulosMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        art.setVisible(true);
        Llenarcbxcategorias();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        art.setVisible(true);
        btnActualizar.setEnabled(true);
        btnGuardar.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TablaArticulos;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    public static javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
