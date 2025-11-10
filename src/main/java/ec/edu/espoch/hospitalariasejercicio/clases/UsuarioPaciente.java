
package ec.edu.espoch.hospitalariasejercicio.clases;

public class UsuarioPaciente {
     //Atributos
    public int identificadorPaciente;
    public String nombre;
    public String RUC;
    public double cobertura;
    public String dirección;
    
    //Constructor

    public UsuarioPaciente(String nombre, String RUC, double cobertura, String dirección) {
        this.identificadorPaciente= identificadorPaciente++;
        this.nombre = nombre;
        this.RUC = RUC;
        this.cobertura = cobertura;
        this.dirección = dirección;
    }
}