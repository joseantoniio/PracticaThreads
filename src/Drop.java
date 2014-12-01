
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose
 */
class Drop {
    
    private Cuenta cuenta;
    private boolean empty=true;
    
    public synchronized void put(Cuenta cuenta){
        while(!empty){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        this.cuenta=cuenta;
        empty=false;
        notifyAll();
    }
    
    public synchronized Cuenta take(){
        while(empty){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        empty=true;
        notifyAll();
        return cuenta;
    }
}
