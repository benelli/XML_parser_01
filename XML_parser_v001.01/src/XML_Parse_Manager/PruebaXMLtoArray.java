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
            
            
            
            System.out.println(doc.);
            
            
            
            
        } catch (Exception ex) {
           
        }
    }
}
