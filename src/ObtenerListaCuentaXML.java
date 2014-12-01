
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose
 */
public class ObtenerListaCuentaXML {
    
    public static ArrayList<Cuenta> obtenerCuentaXML(String xml){
        ArrayList<Cuenta> lista=new ArrayList<>();
        try {
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document doc=db.parse(new File(xml));
            doc.getDocumentElement().normalize();
            NodeList listaCuentas=doc.getElementsByTagName("cuenta");
            for(int i=0;i<listaCuentas.getLength();i++){
                Node cuenta=listaCuentas.item(i);
                if(cuenta.getNodeType()==Node.ELEMENT_NODE){
                    Element el=(Element)cuenta;
                    int id=Integer.parseInt(getTagValue("id", el));
                    String fech=getTagValue("fecha", el);
                    float cantidad=Float.parseFloat(getTagValue("cantidadCargo", el));
                    lista.add(new Cuenta(id, fech, cantidad));
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());;
        }
        return lista;
    }
    
    private static String getTagValue(String tag,Element el){
        NodeList nodeList=el.getElementsByTagName(tag).item(0).getChildNodes();
        Node node=(Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
