
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose
 */
public class Productor implements Runnable{
    
    Drop drop;
    String xml;
    
    public Productor(Drop drop,String xml){
        this.drop=drop;
        this.xml=xml;
    }

    @Override
    public void run() {
        ArrayList<Cuenta> cuentas=ObtenerListaCuentaXML.obtenerCuentaXML(xml);
        
        for(Cuenta c:cuentas){
            System.out.println("El productor está procesando la cuenta "+c.getId());
            drop.put(c);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        drop.put(null);
    }
    
    
    
}
