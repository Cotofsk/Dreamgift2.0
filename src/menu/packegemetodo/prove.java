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
 public class prove {
    
     private int id;
    private String rut;
    private String repesentante;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private String estado;

public prove(){
  }

public prove(int id, String rut,String razonsocial,String repesentante, String telefono, String direccion, String email,String estado) {
        
        this.id= id ;
        this.rut= rut;
        this.nombre=razonsocial;
        this.repesentante= repesentante ;
        this.telefono= telefono;
        this.direccion=direccion ;
        this.email=email;
        this.estado=estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String razonsocial){
        this.nombre=razonsocial;
    }
    public String getRepesentante() {
        return repesentante;
    }

    public void setRepesentante(String repesentante) {
        this.repesentante = repesentante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
 }  