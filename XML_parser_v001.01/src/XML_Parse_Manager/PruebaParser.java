package XML_Parse_Manager;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PruebaParser{

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





            
            for (int t = 1; t < nodes.getLength(); t++) 
            {
                if (nodes.item(t).getNodeType() == Node.ELEMENT_NODE) 
                    {
                        System.out.println("-" + nodes.item(t).getNodeName() + "-");
                        Childnodes = nodes.item(t).getChildNodes();
                    }
                
                
                for (int i = 0; i < nodes.item(t).getChildNodes().getLength(); i++) 
                {
                    if (Childnodes.item(i).getNodeType() == Node.ELEMENT_NODE) 
                    {
                        System.out.println(Childnodes.item(i).getNodeName() + " = "
                                + Childnodes.item(i).getTextContent());
                    }

                }
            }


//                    System.out.println(nodes)                   
//                    System.out.println("Proceso: " + getValue("CodigoDelProceso", element));
//                    System.out.println("Paso: " + getValue("CodigoDePaso", element));
//                    System.out.println("Codigo: " + getValue("Codigo", element));
            //}

        } catch (Exception ex) {
        }
    }

    private static String getValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }
}
