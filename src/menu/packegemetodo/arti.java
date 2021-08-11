/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.packegemetodo;

/**
 *
 * @author Usuario
 */
public class arti {
    

    private int id;
    private String codigo;
    private String nombre;
    private int categoria;
    private int stock;
    private String estado;

public arti (){
  }

public arti (int id, String codigo,String nombre,int categoria, int stock, String estado) {
        
        this.id= id ;
        this.codigo= codigo;
        this.nombre=nombre;
        this.categoria=categoria;
        this.stock= stock ;
        this.estado= estado;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
     public int getCategoria() {
        return categoria;
    }
    
    public void setCategoria (int categoria){
        this.categoria=categoria;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

     public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
 }  
