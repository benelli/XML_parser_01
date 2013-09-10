/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML_Parse_Manager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 *
 * @author jmunoz.ext
 */
public class Web {
    URL url;
    Document doc;
    
    public Web(String ruta) {    
        try {
            //Conectamos con la URL del XML, lo leemos y creamos un DOC con él
            this.url =    new URL(ruta);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String entrada;
            String cadena="";
            while ((entrada = br.readLine()) != null){
                    cadena = cadena + entrada;
            }
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource archivo = new InputSource();
            archivo.setCharacterStream(new StringReader(cadena)); 

            this.doc = db.parse(archivo);
            this.doc.getDocumentElement().normalize();

            br.close();
        }
            catch(Exception ex)
            {
                // lanzar excepcion
            }
    }
}
