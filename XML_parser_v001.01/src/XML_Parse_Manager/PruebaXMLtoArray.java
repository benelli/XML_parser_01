/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML_Parse_Manager;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author atorralba.ext
 */
public class PruebaXMLtoArray {

    public static void main(String args[]) {
        try {
            File stocks = new File("C:\\prueba.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();
            System.out.println("XML " + doc.getDocumentElement().getNodeName());
            NodeList nodes = doc.getDocumentElement().getChildNodes();
            NodeList Childnodes = nodes.item(1).getChildNodes();
            System.out.println("==========================");



            Element node = doc.getDocumentElement();

            recurseThroughDoc(node);


        } catch (Exception ex) {
        }
    }

    private static void recurseThroughDoc(Node node) {
        NodeList nodeList = node.getChildNodes();


        //Tiene hijos?
        //Si Tiene Hijos
        if (nodeList.getLength() > 0) {
            
            //Imprime Nodo
            System.out.println(node.getNodeName());
            
            //Imprime Hijos
            for (int i = 0; i < nodeList.getLength(); i++) {
                
                    if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                        System.out.print(nodeList.item(i).getNodeName() + " = ");
                        System.out.println(nodeList.item(i).getTextContent());
                    }
                
                    recurseThroughDoc(nodeList.item(i));
                }
                System.out.flush();
            }

         
        //No Tiene Hijos
        else 
        {
            
        }

    }
}
