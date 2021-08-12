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
public class compradetalle {
private int idlote  ;
    private int idfactura;
    private int idarticulo;
    private int cantidad;
    private int valor;
    private Date fechavenc;
    private String marca;
   
    
    public compradetalle(){
        
    }

    public compradetalle(int idlote, int idfactura, int idarticulo, int cantidad, int valor,Date fechavenc, String marca) {
        this.idlote = idlote;
        this.idfactura = idfactura;
        this.idarticulo = idarticulo;
        this.cantidad = cantidad;
        this.valor = valor;
        this.fechavenc = fechavenc;
        this.marca = marca;
        
    }

    public int getId() {
        return idlote;
    }

    public void setId(int idlote) {
        this.idlote = idlote;
    }

    public int getIdFactura() {
        return idfactura;
    }

    public void setIdFactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getIdArticulo() {
        return idarticulo;
    }

    public void setIdArticulo(int idarticulo) {
        this.idarticulo = idarticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad (int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getFechaVenc() {
        return fechavenc;
    }

    public void setFechaVenc(Date fechavenc) {
        this.fechavenc = fechavenc;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
