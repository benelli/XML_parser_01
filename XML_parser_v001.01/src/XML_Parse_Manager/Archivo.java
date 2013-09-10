/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML_Parse_Manager;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author jmunoz.ext
 */
public class Archivo {
    File ruta;
    Document doc;

    public Archivo(String ruta) {
        try {
            this.ruta = new File(ruta);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.doc = dBuilder.parse(this.ruta);
            this.doc.getDocumentElement().normalize();
        } catch (Exception ex) {
            //lanzamiento de excepción
        }
        
    }
}
