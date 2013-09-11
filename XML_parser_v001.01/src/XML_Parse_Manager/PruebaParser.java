package XML_Parse_Manager;

import java.util.Scanner;

public class PruebaParser{

    
    public static void main(String args[]) 
    {
        String ruta;
        String ruta2;
        Integer opcion = 0;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Introduzca 2 si las rutas son URL web, 1 si es archivo:\n");
        opcion=1;   //sc.nextInt();
        
        System.out.println("Introduzca la ruta del primer fichero XML:\n");
        ruta="C:\\prueba.xml";  //sc.next();
        System.out.println("Tratando de inicializar primer fichero ...");
        Parseador a = new Parseador(opcion, ruta);
        
        System.out.println("Introduzca la ruta del segundo fichero XML:\n");
        ruta2="C:\\prueba2.xml"; //sc.next();
        System.out.println("Tratando de inicializar segundo fichero ...");
        Parseador b = new Parseador(opcion, ruta2);
        
        a.reemplazar(b.getCampos());
    }
}