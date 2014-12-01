/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose
 */
public class Consumidor implements Runnable{

    private Drop drop;
    
    public Consumidor(Drop drop){
        this.drop=drop;
    }
    
    @Override
    public void run() {       
        for(Cuenta cuenta=drop.take();cuenta!=null;cuenta=drop.take()){
            System.out.println("El consumidor está recibiendo la cuenta "+cuenta.getId());
            Listados.cuentas.add(cuenta);
        }
    
    }
    
}
