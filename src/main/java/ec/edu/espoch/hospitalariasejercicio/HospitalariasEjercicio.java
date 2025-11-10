
package ec.edu.espoch.hospitalariasejercicio;

import ec.edu.espoch.hospitalariasejercicio.clases.Atencion;
import ec.edu.espoch.hospitalariasejercicio.clases.Factura;
import ec.edu.espoch.hospitalariasejercicio.clases.UsuarioPaciente;
import ec.edu.espoch.hospitalariasejercicio.clases.Metodo;
import ec.edu.espoch.hospitalariasejercicio.enumeracion.EstadoAtencion;
import ec.edu.espoch.hospitalariasejercicio.enumeracion.MetodoPago;
import ec.edu.espoch.hospitalariasejercicio.enumeracion.CategoriaPrioridad;
import ec.edu.espoch.hospitalariasejercicio.enumeracion.CategoriaMetodo;

public class HospitalariasEjercicio {

    public static void main(String[] args) {
       Atencion atencionUno=new Atencion(1, EstadoAtencion.REGISTRADA);
       UsuarioPaciente usuariopacienteUno=new UsuarioPaciente("Paul", "655434", 30, "Alejandro Riera");
       atencionUno.cambiarEstado(EstadoAtencion.EN_TRIAJE);
       atencionUno.asignarPrioridad(CategoriaPrioridad.ROJO);
       atencionUno.añadirObservacion("Dolor irradiado, sudoracion");
       atencionUno.cambiarEstado(EstadoAtencion.EN_ATENCION);
       
       
       
       Metodo procedimiento1AtencionUno=new Metodo(CategoriaMetodo.ECG, 01);
       procedimiento1AtencionUno.costo=30.0;
       atencionUno.agregarMetodo(procedimiento1AtencionUno);
       Metodo procedimiento2AtencionUno=new Metodo(CategoriaMetodo.LABORATORIO, 02);
       procedimiento2AtencionUno.costo=35.0;
       atencionUno.agregarMetodo(procedimiento2AtencionUno);
       
       atencionUno.agregarIndicacion("Alergia a penicilina");
       
       atencionUno.ordenarMedicacion("Paracetamol");
       
       atencionUno.agregarInsumo("Suero salino");
       
       
       atencionUno.cambiarEstado(EstadoAtencion.LISTA_PARA_ALTA);
       
       atencionUno.calcCovertura(usuariopacienteUno.cobertura);
       
       atencionUno.cambiarEstado(EstadoAtencion.ALTA_EMITIDA);
        System.out.println(atencionUno.toString());
       
       Factura facturaUno=new Factura(1, MetodoPago.EFECTIVO);
       System.out.println("");
       facturaUno.generarFactura(atencionUno, usuariopacienteUno);
       facturaUno.imprimirFactura();
       
       Atencion atencionDos=new Atencion(2, EstadoAtencion.REGISTRADA);
       Metodo procedimiento1AtencionDos=new Metodo(CategoriaMetodo.LABORATORIO, 28);
       atencionDos.agregarMetodo(procedimiento1AtencionDos);
       atencionDos.cancelarAtencion("Desistimiento de la familia");
       System.out.println(atencionDos.toString());
       
    }
}
