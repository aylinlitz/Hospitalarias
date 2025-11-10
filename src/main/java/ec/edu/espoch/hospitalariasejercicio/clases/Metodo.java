
package ec.edu.espoch.hospitalariasejercicio.clases;

import ec.edu.espoch.hospitalariasejercicio.enumeracion.CategoriaMetodo;

public class Metodo {
    //Atributos
    public CategoriaMetodo categoriaMetodo;
    public int codigo;
    public double costo;
    public String resultados;
    int length;
    
    //Contructor

    public Metodo(CategoriaMetodo categoriaMetodo, int codigo) {
        this.categoriaMetodo = categoriaMetodo;
        this.codigo = codigo;
    }
   
    
}