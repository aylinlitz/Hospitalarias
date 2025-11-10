
package ec.edu.espoch.hospitalariasejercicio.clases;

import ec.edu.espoch.hospitalariasejercicio.enumeracion.MetodoPago;

public class Factura {
    //Atributos
    public int identificadorFactura;
    public MetodoPago metodoPago;
    public double monto;
    public String RUC;
    public int identificadorAtencion;
    
    //Constructor
    public Factura(int identificadorFactura, MetodoPago metodoPago) {
        this.identificadorFactura = identificadorFactura;
        this.metodoPago = metodoPago;
    }
    
    //Metodos
    public void generarFactura(Atencion atencion, UsuarioPaciente usuariopaciente){
        this.monto=atencion.total;
        this.RUC=usuariopaciente.RUC;
        this.identificadorAtencion=atencion.identificadorAtencion;
    }
    
    public void imprimirFactura(){
        System.out.println("=======FACTURA========");
        System.out.println("ID Factura: "+this.identificadorFactura);
        System.out.println("ID Atencion: "+this.identificadorAtencion);
        System.out.println("Ruc Paciente: "+this.RUC);
        System.out.println("Metodo de pago: "+this.metodoPago);
        System.out.println("Monto: "+this.monto);
    }  
} 