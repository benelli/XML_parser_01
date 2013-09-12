/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML_Parse_Manager;

import java.io.File;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author atorralba.ext
 */
public class PruebaXMLtoArray {

    static JFrame VMain;
    static String ruta;
    static String paso;
    static String proceso;
    static String XML;
    

    public PruebaXMLtoArray() {
            lanzar();

    }
    
    
    public void lanzar() {
        
    
           
           
          
        
        
        try {
            File stocks = new File(ruta);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();
            Element node = doc.getDocumentElement();
            
            
            
            //lamamos a la funcion
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
                XML = (XML + "\n" + node.getNodeName() + " = " + node.getTextContent());
                MainFrame.TxtXML.setText(XML);
                if(node.getNodeName() ==  "CodigoDelProceso")
                {
                    proceso = node.getTextContent();
                }
                if(node.getNodeName() ==  "CodigoDePaso")
                {
                    paso = node.getTextContent();
                }
            }
        } else {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("--" + node.getNodeName() + "--");
                XML = (XML + "\n" + "--" + node.getNodeName() + "--");
                MainFrame.TxtXML.setText(XML);
            }
            for (int i = 1; i < nodeList.getLength(); i++) {
                recurseThroughDoc(nodeList.item(i));
            }
            System.out.flush();
        }
    }
}
