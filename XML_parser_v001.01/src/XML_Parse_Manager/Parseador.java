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
                
                Parsea(t);
                    
            }
            
            
        }catch (Exception ex) {
        }
    }


private void Parsea(int x)
{
    if(Childnodes.item(x).getChildNodes().getLength() == 0)
    {
            Padre(x);
    }   
    else
    {
            Hijo(x);
    }
        
}
    
    
private void Padre(int x)
    {        
            if (nodes.item(x).getNodeType() == Node.ELEMENT_NODE)
            {
                System.out.println("-" + nodes.item(x).getNodeName() + "-");
                Childnodes = nodes.item(x).getChildNodes();
            }            
    }


private void Hijo(int x)
    {
        for (int i = 0; i < nodes.item(x).getChildNodes().getLength(); i++) 
                {        
                    if (Childnodes.item(i).getChildNodes().getLength() == 0)
                    {
                        if (Childnodes.item(i).getNodeType() == Node.ELEMENT_NODE) 
                        {
                            System.out.println(Childnodes.item(i).getNodeName() + " = "
                                    + Childnodes.item(i).getTextContent());
                        }
                    }
                    else
                    {
                        
                    }
                }
    }


private void XMLtoArray()
{
   
}

}




