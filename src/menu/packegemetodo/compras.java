/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.packegemetodo;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class compras {
    
    
    private int id_factura_compra  ;
    private int num_factura;
    private String fec_factura;
    private int proveedores_rut_proveedor;
    
    
    
    public compras(){
        
    }

    public compras (int id_factura_compra, int num_factura, String fec_factura, int proveedores_rut_proveedor) {
        this.id_factura_compra = id_factura_compra;
        this.num_factura= num_factura;
        this.fec_factura = fec_factura;
        this.proveedores_rut_proveedor = proveedores_rut_proveedor;
      
    }

    public int getId() {
        return id_factura_compra;
    }

    public void setId(int id_factura_compra) {
        this.id_factura_compra= id_factura_compra;
    }

    public int getNFacura() {
        return num_factura;
    }

    public void setNFactura(int num_factura) {
        this.num_factura = num_factura;
    }

    public String getFFactura() {
        return fec_factura;
    }

    public void setFFactura(String fec_factura) {
        this.fec_factura = fec_factura;
    }

    public int getRProveedor() {
        return proveedores_rut_proveedor;
    }

    public void setRProveedor (int proveedores_rut_proveedor) {
        this.proveedores_rut_proveedor = proveedores_rut_proveedor;
    }

   
}
