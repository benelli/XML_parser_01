/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML_Parse_Manager;

/**
 *
 * @author jmunoz.ext
 */
public class Campo {
    Integer nivel;
    Boolean padre;
    String nombre;
    String valor;

    public Campo() {
    }
    
    public Campo(String nombre, String valor, Boolean padre) {
        this.nombre = nombre;
        this.valor = valor;
        this.padre = padre;
    }

    
    
    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
          
}
