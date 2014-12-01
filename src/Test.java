
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
public class Test {
    public static void main(String[] args) {
        Drop drop=new Drop();
        Productor productor1=new Productor(drop, "cuentas1.xml");
        Productor productor2=new Productor(drop, "cuentas2.xml");
        Consumidor consumidor1=new Consumidor(drop);
        Consumidor consumidor2=new Consumidor(drop);
        new Thread(productor1).start();
        new Thread(productor2).start();
        new Thread(consumidor1).start();
        new Thread(consumidor2).start();
    }
}
