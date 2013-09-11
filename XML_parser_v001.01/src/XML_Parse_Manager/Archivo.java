/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML_Parse_Manager;

import java.io.BufferedReader;
import java.io.File;
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
public class Archivo {
   
    Integer opcion;
    Document doc;

    //Si se va a acceder via WEB la ocpión debe estar a 2, por defecto se usará la opción de acceso a archivo en disco 
    public Archivo(Integer opcion, String ruta) {
        this.opcion = opcion;
        if (opcion == 2)
            this.Web(ruta);
        else 
            this.Fichero(ruta);            
    }

    public void Fichero(String direccion) {
        File ruta;
        try {
            ruta = new File(direccion);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.doc = dBuilder.parse(ruta);
            this.doc.getDocumentElement().normalize();
        } catch (Exception ex) {
            //lanzamiento de excepción
        }
        
    }
    
    public void Web(String ruta) {    
        URL url;
        try {
            //Conectamos con la URL del XML, lo leemos y creamos un DOC con él
            url =    new URL(ruta);
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
