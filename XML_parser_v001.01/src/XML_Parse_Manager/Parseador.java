/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML_Parse_Manager;


import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList; 
    
    
    
    
/**
 *
 * @author jmunoz.ext
 */
public class Parseador extends Archivo{
    
    NodeList nodes;
    NodeList Childnodes;
    Campo campotemp;
    ArrayList<Campo> campos;

    public Parseador(Integer opcion, String ruta)       
{
    //Al construir ya rellenamos el arraylist con los datos del archivo XML.
    super(opcion,ruta);
    this.campos = new ArrayList();
    System.out.println("XML " + doc.getDocumentElement().getNodeName());
    System.out.println("==========================");
    Element node = doc.getDocumentElement();
    recurseThroughDoc(node);
 } 

    private void recurseThroughDoc(Node node) {
        NodeList nodeList = node.getChildNodes();
        if (nodeList.getLength() == 1) {
            //NO ES PADRE (hijo)
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Sacamos los datos por consola
//                System.out.print(node.getNodeName() + " = ");
//                System.out.println(node.getTextContent());
                //Rellenamos el arraylist
                this.campotemp = new Campo(node.getNodeName(), node.getTextContent(), false);
                campos.add(campotemp);
                
            }
        } else {
            //ES PADRE
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Sacamos los datos por consola
//                System.out.println("--" + node.getNodeName() + "--");
                //Rellenamos el arraylist
                this.campotemp = new Campo(node.getNodeName(), null, true);
                campos.add(campotemp);
            }
            for (int i = 1; i < nodeList.getLength(); i++) {
                recurseThroughDoc(nodeList.item(i));
            }
            System.out.flush();
        }
    }

    public ArrayList<Campo> getCampos() {
        return campos;
    }
  
    public ArrayList<Campo> reemplazar (ArrayList<Campo> b)
    {
        ArrayList<Campo> diferencias = new ArrayList();
        for( Campo c1 : this.campos ){
            for( Campo c2 : b ){
                if (c1.getNombre().equals(c2.getNombre()))
                {
                    //Hacemos que solo se busquen los campos hijos que tienen valor.
                    if (!c1.padre)
                    {
                        if (!c1.valor.equals(c2.valor))
                        {    
                            diferencias.add(c1);
                            System.out.println("Diferencia en campo: "+c2.nombre+"\nValor1 = "+c1.valor+"\nValor2 = "+c2.valor);
                        }
                    }
                }
                    
            }
        }
        return diferencias;
    }
    
//    public ArrayList<Campo> sacarCoincidenciasNombre (ArrayList<Campo> b)
//    {
//        ArrayList<Campo> coincidencias = new ArrayList();
//        for( Campo c1 : this.campos ){
//            for( Campo c2 : b ){
//                if (c1.getNombre().equals(c2.getNombre()))
//                {
//                    //Hacemos que solo se busquen los campos hijos que tienen valor.
//                    if (!c1.padre)
//                    {
//                        coincidencias.add(c2);
//                        System.out.println("Coincidencia en campo: "+c2.nombre+"\nValor1 = "+c1.valor+"\nValor2 = "+c2.valor);
//                    }
//                }
//                    
//            }
//        }
//        return coincidencias;
//    }
}