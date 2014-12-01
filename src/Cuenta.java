/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose
 */
class Cuenta {
    private int id;
    private String fecha;
    private float cantidad;
    
    public Cuenta(int id,String fecha,float cantidad){
        this.id=id;
        this.fecha=fecha;
        this.cantidad=cantidad;
    }
    
    public int getId(){return id;}
    public String getFecha(){return fecha;}
    public float getCantidadCargo(){return cantidad;}
}
