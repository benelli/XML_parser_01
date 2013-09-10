/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML_Parse_Manager;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

    
    
    
    
    
    
/**
 *
 * @author jmunoz.ext
 */
public class Parseador {
    
    NodeList nodes;
    NodeList Childnodes;

    public Parseador()       
{
    try {

            File stocks = new File("C:\\prueba.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();
            System.out.println("XML " + doc.getDocumentElement().getNodeName());
            this.nodes = doc.getDocumentElement().getChildNodes();
            this.Childnodes = nodes.item(1).getChildNodes();
            System.out.println("==========================");




            
            for (int t = 1; t < nodes.getLength(); t++) 
            {
                if (nodes.item(t).getNodeType() == Node.ELEMENT_NODE) 
                    {
                        System.out.println("-" + nodes.item(t).getNodeName() + "-");
                        Childnodes = nodes.item(t).getChildNodes();
                    }
                
                Child(t);
                    



        }
            
        }catch (Exception ex) {
        }
    }



private void Child(int x)
    {
        for (int i = 0; i < nodes.item(x).getChildNodes().getLength(); i++) 
                {
                    if(Childnodes.item(i).getFirstChild() == Childnodes.item(i).getLastChild() )
                    {
                        if (Childnodes.item(i).getNodeType() == Node.ELEMENT_NODE) 
                        {
                            System.out.println(Childnodes.item(i).getNodeName() + " = "
                                    + Childnodes.item(i).getTextContent());
                        }
                    }
                    else
                    {
                        System.out.println("AQUI ENTRA EL ELSE");
                        
                    }
                    

                }
        
    }

}
