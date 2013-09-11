package XML_Parse_Manager;

import java.util.Scanner;

public class PruebaParser{

    
    public static void main(String args[]) 
    {
        String ruta;
        Integer opcion = 0;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Introduzca la ruta del fichero XML:\n");
        ruta=sc.next();
        
        System.out.println("Introduzca 2 si la ruta es una URL web, 1 si es un archivo:\n");
        opcion=sc.nextInt();
        
        System.out.println("Tratando de inicializar ...");
        
        Parseador a = new Parseador(opcion, ruta);
    }
}