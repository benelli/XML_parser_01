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
            System.out.println("==========================");



            Element node = doc.getDocumentElement();

            recurseThroughDoc(node);


        } catch (Exception ex) {
        }
    }

    private static void recurseThroughDoc(Node node) {
        NodeList nodeList = node.getChildNodes();
        if (nodeList.getLength() == 1) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.print(node.getNodeName() + " = ");
                System.out.println(node.getTextContent());
            }
        } else {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("--" + node.getNodeName() + "--");
            }
            for (int i = 1; i < nodeList.getLength(); i++) {
                recurseThroughDoc(nodeList.item(i));
            }
            System.out.flush();
        }
    }
}
